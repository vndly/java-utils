package com.mauriciotogneri.javautils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encoding
{
    private static final String UTF8 = "UTF-8";

    public static String toString(byte[] bytes) throws UnsupportedEncodingException
    {
        return new String(bytes, UTF8);
    }

    public static byte[] toByteArray(String text) throws UnsupportedEncodingException
    {
        return text.getBytes(UTF8);
    }

    public static String urlEncode(String text) throws Exception
    {
        return URLEncoder.encode(text, UTF8);
    }

    public static String urlDecode(String text) throws Exception
    {
        return URLDecoder.decode(text, UTF8);
    }

    public static String sha256(String input) throws NoSuchAlgorithmException
    {
        return hash("SHA-256", input);
    }

    public static String sha512(String input) throws NoSuchAlgorithmException
    {
        return hash("SHA-512", input);
    }

    public static String hash(String algorithm, String input) throws NoSuchAlgorithmException
    {
        MessageDigest digest = MessageDigest.getInstance(algorithm);
        digest.update(input.getBytes());
        byte messageDigest[] = digest.digest();

        StringBuilder hexString = new StringBuilder(messageDigest.length * 2);

        for (byte element : messageDigest)
        {
            hexString.append(String.format("%02x", element));
        }

        return hexString.toString();
    }
}