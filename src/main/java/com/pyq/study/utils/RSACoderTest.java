package com.pyq.study.utils;


import org.apache.commons.codec.binary.Base64;

import java.util.Map;

public class RSACoderTest {
    private String publicKey;
    private String privateKey;

    public void setUp() throws Exception {
        Map<String, Object> keyMap = RSACoder.initKey();
        publicKey = RSACoder.getPublicKey(keyMap);
        privateKey = RSACoder.getPrivateKey(keyMap);
        System.err.println("公钥: \n\r" + publicKey);
        System.err.println("私钥： \n\r" + privateKey);
    }


    public void test() throws Exception {
        System.err.println("公钥加密——私钥解密");
        String inputStr = "enterprise_id=144432&user_id=12345&userName=张三&sn=zj123";
        byte[] data = inputStr.getBytes();

        byte[] encodedData = RSACoder.encryptByPublicKey(data, publicKey);


        byte[] decodedData = RSACoder.decryptByPrivateKey(Hex.decodeHexstrToByte(Hex.encodeByteToHexStr(encodedData)),
                privateKey);

        String outputStr = new String(decodedData);
        System.err.println("加密前: " + inputStr + "\n\r" +"加密后: "+ Hex.encodeByteToHexStr(encodedData) +  "\n\r" + "解密后: " + outputStr);
        System.out.println(inputStr.equals(outputStr));

    }

    public void testSign() throws Exception {
        System.err.println("私钥加密——公钥解密");

        String inputStr = "signdfsgfdshvdvdvsdfhvdsvdshvfsfvsvsfh";
        byte[] data = inputStr.getBytes();

        byte[] encodedData = RSACoder.encryptByPrivateKey(data, privateKey);

        byte[] decodedData = RSACoder
                .decryptByPublicKey(encodedData, publicKey);

        String outputStr = new String(decodedData);
        System.err.println("加密前: " + inputStr + "\n" + "解密后: " + outputStr);

        System.out.println(inputStr.equals(outputStr));

        System.err.println("私钥签名——公钥验证签名");
        // 产生签名
        String sign = RSACoder.sign(encodedData, privateKey);
        System.err.println("签名:\n" + sign);

        // 验证签名
        boolean status = RSACoder.verify(encodedData, publicKey, sign);
        System.err.println("状态:\n" + status);
        System.out.println(inputStr.equals(outputStr));

    }



    public void testSign2() throws Exception {
        System.err.println("公钥加密——私钥解密");
        String inputStr = "userId=792074&enterpriseId=792072&userNamsdfdfadfadsadhaddddhvdhhdhahsddsahsdhsadhdshdsahsadbsdhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhe=姚思廉";
        byte[] data = inputStr.getBytes();

        byte[] encodedData = RSACoder.encryptByPublicKey(data, publicKey);

        String ciphertext = Base64.encodeBase64URLSafeString(encodedData);

        String outputStr = RsaUtils.decryptByPrivateKey(ciphertext,privateKey);

        System.err.println("加密前: " + inputStr + "\n"  +"加密后:"+ ciphertext + "\n" + "解密后: " + outputStr);

        System.err.println("私钥签名——公钥验证签名");
        // 产生签名
        String sign = RSACoder.sign(encodedData, RSACoder.WBG_PRIVATE_KEY);
        System.err.println("签名:\n" + sign);
        // 验证签名
        boolean status = RsaUtils.verifyData(ciphertext,sign, RSACoder.WBG_PUBLIC_KEY);
        System.err.println("状态:\n" + status);

    }

    public void testSign3() throws Exception {




        String ciphertext = "dmHusLaApN0DYcXOyWiovE3IB9UY3PcZ3IMZNweOYFfrRm1pffiulLKYsvnS6_09DRX5uYx0_a_IiH-iqQtm4E5sFq7mzPQuu012Us8RCAh6mF0U-aptxRMgxmOH_gtX-GP9Q9uBf5EbDcL6lnAzttW3xTiKBbEV-15f1VD3RTQ";
        String sign = "ema6kXcJD-_ldbCxI8VUaAAjjGvCyrSMWF0QcASYB3L1BkG-9ihdUPdwba_N8pBpaSslaW4ZB9I3XsVL2gQGyH8GppZJU6VhWISheZdJ73micBieifGZf1RUDDiK-91weoN03FcJqVTFiuSTwWvHR_ZDxmIhsVk6Gpd55mJJDXw";
        String wbgPublickey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCNi8REkef/8jSLtzYVpFlBcfjVQWK90vRWmcI0\n" +
                "5mNYgPv2hdimCHJcdPP3YWK7/BhmT5hsWzvdQ/jLJ2Tw9nGlz77cZTtf18sBM0pK4tM7RAt6m6ce\n" +
                "8rcpQea8lCYHc5bFalRnE4mmTIydlfBgfdWN1XYrpJZ+nPjC1HX2tV9O7wIDAQAB";
        String privateKey = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAKzwYm_j5CUyNYPfOeY9cyhqrR5D8TuMgBG2Tsu6A7PheAuVfDVUW_dhoJhvQS5lSsv0DYYHvfcdKNmzk1GznIRThClZzEgU-U7BXPwMlscCVj7orSznd8lUpgJPrFYeZSkcWSsAZE3wGVI44oLN8zpbbqZc0uuWMVMs00vpmG_lAgMBAAECgYBWlu3StDpRXXhqFOT6oR39yJvxoXcxp8GgHLYLT5H3CReARVKxqRF7JcixSlNKlbEDuajjyRCWoGUJy94hdFsTGsRI9-Mrp7zwMP4RHFsLvtkFsrRIMxK62-ZJh5s7pPa01W04yzwR53cagZfecsImKogc5d99p0ri_Xi3cquZaQJBAOfOCOkzfELk5uk89xbXRDQEixNgSKUwczF-QVDR3sF-2F0wfCbiSRfSRIuVZ4d1dahnnyavZnjavZL9ZNyO46MCQQC-_WtZVOEkmZAhyQgDziVYHqUXJUSw6bfqwbrNSsCCODO5UqtR3QnbZ-nswY1YPjGyfqlb5Sx3oQ5FwLTUT9bXAkEAs56suv-hNzimUW9jS_isqd4nYnFGeXJMoLpjpFurz6YZxERQv9SyrNnLMZoo6gczj7YT1ecucVGWenMNl_bFHwJAGbcVVRnQlpT2ixX-NkTzUkIOCGfEL-3IDZu4Axwlf2MB09oFpygTw67iGDaXSWJWXqofM3hP3Gua-FlR_6QgUQJBAJrLT5VyYJoOcVZ8r0kt2GsN2nCDj1KQPCxVMinYDTMIimBSdgIgjmH9kY7Qy7UokMhO3HLhIZBCTG2TZwpwqEs";

        // 验证签名
        boolean status = RsaUtils.verifyData(ciphertext,sign, wbgPublickey);
        System.err.println("状态:\n" + status);

        //解密：
        String info = RsaUtils.decryptByPrivateKey(ciphertext,privateKey);
        System.err.println("明文:\n" + info);


    }

    public static void main(String[] args) throws Exception {
        RSACoderTest test = new RSACoderTest();
        test.setUp();
       test.testSign2();
//
    }

}
