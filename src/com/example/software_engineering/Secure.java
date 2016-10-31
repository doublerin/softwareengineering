package com.example.software_engineering;

import java.math.BigInteger;
import java.security.SecureRandom;

public class Secure {

    public static String generateSalt() {
        SecureRandom random = new SecureRandom();
        return new BigInteger(130, random).toString(32);
    }


    public static String md5(String md5) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("md5");
            byte[] array = md.digest(md5.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
            System.out.println("Wrong HASH");
            e.printStackTrace();
        }
        return null;
    }
}
