package me.sharma.vardan.healtyfy.util;

/**
 * Created by krishan on 3/2/16.
 */
public interface Encryptor {
    String encrypt(String string);
    byte[] decrypt(String string) throws Exception;
}
