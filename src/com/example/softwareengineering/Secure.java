package com.example.softwareengineering;

import java.math.BigInteger;
import java.security.*;

class Secure {

    static String generateSalt() {
        SecureRandom random = new SecureRandom();
        return new BigInteger(130, random).toString(32);
    }


    static String md5(String md5) {
        try {
            MessageDigest md = MessageDigest.getInstance("md5");
            byte[] array = md.digest(md5.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : array) {
                sb.append(Integer.toHexString(b & 0xFF));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Wrong HASH");
            throw new RuntimeException(e);
        }
    }
}
