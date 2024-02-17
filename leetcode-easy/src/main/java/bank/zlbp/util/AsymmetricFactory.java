package bank.zlbp.util;

/**
 * @author jiaoxian
 * @name bank.zlbp.util
 * @date 2023/12/13 17:35
 * @description TODO
 */

import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.NoSuchPaddingException;
public class AsymmetricFactory {
//
//    public static DsaSigner createSigner(AsymmetricCipherEnum asymmetricCipherEnum, DigestEnum digestEnum, InputStream privateKeyStream, String password) throws PKCSException, OperatorCreationException, IOException {
//        X9ECParameters CURVE_PARAMS;
//        switch (asymmetricCipherEnum) {
//            case SM2:
//                CURVE_PARAMS = CustomNamedCurves.getByName(asymmetricCipherEnum.getCurveName());
//                switch (digestEnum) {
//                    case SM2:
//                        return (DsaSigner)new Sm2Impl(CURVE_PARAMS, (Digest)new SM3Digest(), privateKeyStream, password);
//                    case SECP256K1:
//                        return (DsaSigner)new Sm2Impl(CURVE_PARAMS, (Digest)new SHA256Digest(), privateKeyStream, password);
//                }
//                break;
//            case SECP256K1:
//                CURVE_PARAMS = CustomNamedCurves.getByName(asymmetricCipherEnum.getCurveName());
//                switch (digestEnum) {
//                    case SM2:
//                        return (DsaSigner)new EcdsaSigner(CURVE_PARAMS, (Digest)new SM3Digest(), privateKeyStream, password);
//                    case SECP256K1:
//                        return (DsaSigner)new EcdsaSigner(CURVE_PARAMS, (Digest)new SHA256Digest(), privateKeyStream, password);
//                }
//                break;
//            case RSA2048:
//                switch (digestEnum) {
//                    case SM2:
//                        return (DsaSigner)new RsaSigner((Digest)new SM3Digest(), privateKeyStream, password);
//                    case SECP256K1:
//                        return (DsaSigner)new RsaSigner((Digest)new SHA256Digest(), privateKeyStream, password);
//                }
//                break;
//        }
//        return null;
//    }

}
