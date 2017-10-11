package com.pyq.study.rsa;


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
        String inputStr = "afsdjbdshvjdsvdvsdjf&dasd=2&sdsd=19";
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

        String inputStr = "sign";
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

    public static void main(String[] args) throws Exception {
        RSACoderTest test = new RSACoderTest();
        test.setUp();
        //test.test();
        test.testSign();
    }

}
