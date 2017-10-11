package com.pyq.study.utils;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import java.security.Key;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * Created by pangyueqiang on 17/5/17.
 */
public class RsaUtils {
    /**
     *
     * @param ciphertext 密文
     * @param privateKeyStr 私钥
     * @return
     * @throws Exception
     */
    public static String decryptByPrivateKey(String ciphertext, String privateKeyStr) throws Exception {
        byte[] encryptData = null;

        encryptData = Base64.decodeBase64(ciphertext);
        // 对密钥解密
        byte[] keyBytes = Base64.decodeBase64(privateKeyStr);
        // 取得私钥
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        Key privateKey = keyFactory.generatePrivate(pkcs8KeySpec);
        // 对数据解密
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        return new String(cipher.doFinal(encryptData));
    }

    /**
     *
     * @param ciphertext 密文
     * @param sign 数字签名
     * @param publicKeyStr 微办公公钥
     * @return
     */
    public static boolean verifyData(String ciphertext,String sign,String publicKeyStr) throws Exception{
        byte[] encryptData = Base64.decodeBase64(ciphertext);
        // 对密钥解密
        byte[] keyBytes = Base64.decodeBase64(publicKeyStr);
        // 构造X509EncodedKeySpec对象
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
        // KEY_ALGORITHM 指定的加密算法
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        // 取公钥匙对象
        PublicKey pubKey = keyFactory.generatePublic(keySpec);
        Signature signature = Signature.getInstance("MD5withRSA");
        signature.initVerify(pubKey);
        signature.update(encryptData);
        // 验证签名是否正常
        return signature.verify(Base64.decodeBase64(sign));
    }

    public static void main(String[] args) throws Exception{
        String wbgPublicKey =
                "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCNi8REkef/8jSLtzYVpFlBcfjVQWK90vRWmcI0\n" +
                "5mNYgPv2hdimCHJcdPP3YWK7/BhmT5hsWzvdQ/jLJ2Tw9nGlz77cZTtf18sBM0pK4tM7RAt6m6ce\n" +
                "8rcpQea8lCYHc5bFalRnE4mmTIydlfBgfdWN1XYrpJZ+nPjC1HX2tV9O7wIDAQAB";
        //商户私钥
        String privateKey ="MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAKzwYm_j5CUyNYPfOeY9cyhqrR5D8TuMgBG2Tsu6A7PheAuVfDVUW_dhoJhvQS5lSsv0DYYHvfcdKNmzk1GznIRThClZzEgU-U7BXPwMlscCVj7orSznd8lUpgJPrFYeZSkcWSsAZE3wGVI44oLN8zpbbqZc0uuWMVMs00vpmG_lAgMBAAECgYBWlu3StDpRXXhqFOT6oR39yJvxoXcxp8GgHLYLT5H3CReARVKxqRF7JcixSlNKlbEDuajjyRCWoGUJy94hdFsTGsRI9-Mrp7zwMP4RHFsLvtkFsrRIMxK62-ZJh5s7pPa01W04yzwR53cagZfecsImKogc5d99p0ri_Xi3cquZaQJBAOfOCOkzfELk5uk89xbXRDQEixNgSKUwczF-QVDR3sF-2F0wfCbiSRfSRIuVZ4d1dahnnyavZnjavZL9ZNyO46MCQQC-_WtZVOEkmZAhyQgDziVYHqUXJUSw6bfqwbrNSsCCODO5UqtR3QnbZ-nswY1YPjGyfqlb5Sx3oQ5FwLTUT9bXAkEAs56suv-hNzimUW9jS_isqd4nYnFGeXJMoLpjpFurz6YZxERQv9SyrNnLMZoo6gczj7YT1ecucVGWenMNl_bFHwJAGbcVVRnQlpT2ixX-NkTzUkIOCGfEL-3IDZu4Axwlf2MB09oFpygTw67iGDaXSWJWXqofM3hP3Gua-FlR_6QgUQJBAJrLT5VyYJoOcVZ8r0kt2GsN2nCDj1KQPCxVMinYDTMIimBSdgIgjmH9kY7Qy7UokMhO3HLhIZBCTG2TZwpwqEs";

        //数字签名
        String signature = "ADp-M_Ljsq-eYyO9MubI375QTmcon9acKMRMeTuYPxGxnCXPlhyA9whG30AhHhLVeOWsHlW4SlRrfG2X2AdmCEPnUJ1TTtDX9hcpyQQg9AO1zlPm417AM5D_zA-D2h5TnkaZQfjkC9A6OGfVnQUsk0nWv70Bq4Nh55BmECggnBA";
        //个人凭据密文

        String ciphertext ="UpuENCPmwauCX4T94GPRaBLRbvMwvaCm1n5KnlNGzU9NdRKV6PrDixCB7SZrtolVBUhrvYXF56QAVgiVOn-AG1zJ4UFfaGrXnDKBvYHpdgyUtGwt7DqTfV-iNQEB1YRIercL4O-u4siuubsWdX6YP3I9pw-GmOGp8ZqMpZU0im4";

        System.out.println("签名验证：\n"+verifyData(ciphertext,signature,wbgPublicKey));

        System.out.println("解密信息：\n"+decryptByPrivateKey(ciphertext,privateKey));


    }
}
