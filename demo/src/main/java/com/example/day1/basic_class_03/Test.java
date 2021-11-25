package com.example.day1.basic_class_03;

import cn.hutool.crypto.symmetric.SM4;
import org.springframework.util.Base64Utils;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Test {
    public static void main(String[] args) throws UnsupportedEncodingException {
        byte[] decode = Base64.getDecoder().decode("A7tXiFrGbFtug7N5BlZALKqlYIwKtDM3JYYdBbNC6Xc=");
        byte[] bytes = Base64Utils.decodeFromString("A7tXiFrGbFtug7N5BlZALKqlYIwKtDM3JYYdBbNC6Xc=");

        String s = "03bb57885ac66c5b6e83b3790656402caaa5608c0ab4333725861d05b342e977";
        byte[] bytes1 = s.getBytes(StandardCharsets.ISO_8859_1);

        System.out.println( new String(bytes1, "UTF-8"));
    }
}
