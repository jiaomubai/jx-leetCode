package bank.baoli;

import java.net.URLEncoder;
import java.security.cert.X509Certificate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.itrus.client.ISigner;
import com.itrus.client.impl.SignerImpl;
import com.itrus.cryptorole.Recipient;
import com.itrus.cryptorole.SignatureVerifyException;
import com.itrus.cryptorole.bc.RecipientBcImpl;
import com.itrus.cvm.CVM;
import com.itrus.exception.CAException;
import com.itrus.util.Base64;

/**
 * @author jiaoxian
 * @name bank.baoli.baoli
 * @date 2023/7/6 17:44
 * @description TODO
 */
public class Baoli {

    static String password = "12345678";
    static String testCertDN ="test加解密";
    static String p11DllPath = "C:\\Windows\\System32\\gm3000_pkcs11_tw.dll";
    static String plainTextStr = "plainText";

    static String signDataB64Str = "";

    public void testClientSign() throws Exception {
        ISigner signer = new SignerImpl();
        try {
            int state = signer.clientModuleInit(testCertDN, p11DllPath, password);
            if(state!=0){
                String message = "";
                switch (state) {
                    case 1:
                        message ="没有检测到usbkey。";
                        throw new RuntimeException(message);
                    case 2:
                        message ="密码错误。";
                        throw new RuntimeException(message);
                    case 3:
                        message ="证书与传入modName不一致。";
                        throw new RuntimeException(message);
                    default:
                }
            }
            byte[] signData = null;
            signData = signer.signMessage(plainTextStr.getBytes("utf-8"));

            // step6 以Base64字符串格式，传到服务器端
            signDataB64Str = Base64.encode(signData);
            System.out.println("signData1 base64:\n[" + signDataB64Str + "]");

        } catch (CAException e) {
            System.out.println("Error Code" + e.getErrCode());
            System.out.println("Error Message" + e.getMessage());
        }
    }



    public static void main(String[] args) {

        String timeStr1= LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(timeStr1);

        URLEncoder.encode("");

        Baoli test = new Baoli();
        try {
            test.testClientSign();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void testServerVerify() throws Exception {

        try {
            // step1 初始化证书有效性验证模块
            String classPath = getClass().getResource(getClass().getSimpleName() + ".class").getPath();
            String configPath = classPath.substring(0, classPath.lastIndexOf("bin"));
            configPath = configPath.replaceAll("%20", " ");
            System.out.println("########## configPath=" + configPath + " ##########");
            CVM.config(configPath + "bin/cvm.xml");

            // step2 验证签名值有效
            Recipient recipent = new RecipientBcImpl();
            byte[] originalMessage = (plainTextStr).getBytes("utf-8");
            byte[] signedData = Base64.decode(signDataB64Str);
            X509Certificate cert = recipent.verifySignature(originalMessage, signedData);

            // step3 验证证书有效
            if (cert != null) {
                int ret = CVM.verifyCertificate(cert);
                if (ret != CVM.VALID) {
                    String message = "";
                    switch (ret) {
                        case CVM.CVM_INIT_ERROR:
                            message ="CVM初始化错误，请检查配置文件或给CVM增加支持的CA。";
                            throw new RuntimeException(message);
                        case CVM.CRL_UNAVAILABLE:
                            message ="CRL不可用，未知状态。";
                            throw new RuntimeException(message);
                        case CVM.EXPIRED:
                            message ="证书已过期。";
                            throw new RuntimeException(message);
                        case CVM.ILLEGAL_ISSUER:
                            message ="非法颁发者。";
                            throw new RuntimeException(message);
                        case CVM.REVOKED:
                            message ="证书已吊销。";
                            throw new RuntimeException(message);
                        case CVM.UNKNOWN_ISSUER:
                            message ="不支持的颁发者。请检查cvm.xml配置文件";
                            throw new RuntimeException(message);
                        case CVM.REVOKED_AND_EXPIRED:
                            message ="证书被吊销且已过期。";
                            throw new RuntimeException(message);
                        default:
                    }
                } else {
//					// step4 校验证书与用户绑定的证书序列号一致
//					String SerialNumber = cert.getSerialNumber().toString(16).toUpperCase();
                    System.out.println("验证签名成功");
                }
            }
        } catch (SignatureVerifyException e) {
            // 原文被篡改时，抛出 Signature verify failed, plaintext may be falsified. 提示
            System.out.println(e.getMessage());
        }
    }


}
