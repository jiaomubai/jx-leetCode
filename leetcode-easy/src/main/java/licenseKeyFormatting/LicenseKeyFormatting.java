package licenseKeyFormatting;


import com.alibaba.fastjson.JSON;

import java.io.*;
import java.net.DatagramPacket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * @author jiaoxian
 * @name licenseKeyFormatting
 * @date 2023/1/18 17:31
 * @description leetCode-482: 密钥格式化
 */
public class LicenseKeyFormatting {

    public String licenseKeyFormatting(String s, int k) {

        // 替换掉 "-"
        s = s.replaceAll("-", "");
        // 计算长度
        int length = s.length();
        if (length == 0) {
            return "";
        }
        // 可分为 num 组
        int num = length / k;
        // 分成 num 组之后还剩下 left 个字符
        int left = length % k;
        StringBuilder stringBuilder = new StringBuilder();
        if (left != 0) {
            // 如果不能分成整组, 即有剩余字符
            stringBuilder.append(s.substring(0, left));
        }
        for (int i = 0; i < num; i++) {
            stringBuilder.append("-");
            stringBuilder.append(s.substring(left + i * k, (i + 1) * k + left));
        }
        String result = stringBuilder.toString();
        if (result.charAt(0) == '-') {
            result = result.substring(1);
        }
        return result.toUpperCase();
    }

    public static void main(String[] args) throws Exception {
//        String s = "5-f3z-2e9-w";
//        int k = 4;
//        LicenseKeyFormatting licenseKeyFormatting = new LicenseKeyFormatting();
//        System.out.println(licenseKeyFormatting.licenseKeyFormatting(s, k));

        try {
//1.建立客户端socket连接，指定服务器位置及端口
            Socket socket =new Socket("", 0000);
//2.得到socket读写流
            OutputStream os=socket.getOutputStream();
            PrintWriter pw=new PrintWriter(os);
//输入流
            InputStream is=socket.getInputStream();
            BufferedReader br=new BufferedReader(new InputStreamReader(is));
//3.利用流按照一定的操作，对socket进行读写操作
            String sendInfo="向服务器发送的数据信息！";
            pw.write(sendInfo);
            pw.flush();
            socket.shutdownOutput();
//接收服务器的相应
            String replyInfo=null;
            while(!((replyInfo=br.readLine())==null)){
                br.readLine().length();

                System.out.println("接收服务器的数据信息："+replyInfo);
            }
//4.关闭资源
            br.close();
            is.close();
            pw.close();
            os.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
