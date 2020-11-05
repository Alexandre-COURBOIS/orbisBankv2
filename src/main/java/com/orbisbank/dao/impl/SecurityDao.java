package com.orbisbank.dao.impl;

import java.security.MessageDigest;

public class SecurityDao {

    public String hashPassword(String password) {
        String algorithm = "SHA-512";

        byte[] plainText = password.getBytes();

        try {
            MessageDigest md = MessageDigest.getInstance(algorithm);

            md.reset();
            md.update(plainText);
            byte[] encodedPassword = md.digest();

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < encodedPassword.length; i++) {
                if ((encodedPassword[i] & 0xff) < 0x10) {
                    sb.append("0");
                }

                sb.append(Long.toString(encodedPassword[i] & 0xff, 16));
            }

            System.out.println("Plain    : " + password);
            System.out.println("Encrypted: " + sb.toString());
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "error while encrypting password";
        }
    }

}
