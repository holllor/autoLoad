/*
Тестовый класс предназначен для шифрования и деШифрования
Текстовых сообщений.
Идея такая: в консоли через ключ передаются логин и пароль, 
в json файле сохраняется строка с зашифрованными данными - логин и пароль
программа позже считывает их, расшифровывает и передает в автокликер для авторизации
Итог - нигде не хранится в открытом ввиде пара лог/пар не только вне программы(внешинх файлах), но и в ее коде.
А также можно спокойно хранить весь код и вспомогательные файлы в репозитории(файл с зашифрованным текстом лучше исключить)
или для удобства батник(шел скрипт) с командой на запуск держать отдельно.
 */
package ru.home.auto.crypto;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author oleg
 */
public class TestCrypto {

    private SecretKey secretKey;
    private String chifr = "AES";

    public static void main(String[] args) {
        TestCrypto tc = new TestCrypto();

        byte[] encr = tc.makeAes("test message lsk;djadjf; тест сообщение", Cipher.ENCRYPT_MODE);
        System.out.println(new String(encr));
//        

        byte[] dencr = tc.makeAes(encr, Cipher.DECRYPT_MODE);
        System.out.println(new String(dencr));
//        String decr = tc.makeAes("test message тест сообщение", Cipher.DECRYPT_MODE);
//        System.out.println(decr);
//       
    }

    /**
     * конструктор с инициализацией шифра
     */
    public TestCrypto() {
        try {
            //        try {
            String testKey = "testdfsdgsfgsgfKeys53535635gsfgs" ;//16,24,32 byte
            SecretKey secretKey2 = new SecretKeySpec(testKey.getBytes("UTF-8"), "AES");
//            KeyGenerator keyGenerator = KeyGenerator.getInstance(chifr);
//
//            keyGenerator.init(256);
//            this.secretKey = keyGenerator.generateKey();
this.secretKey = secretKey2;
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        }
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(TestCrypto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public byte[] makeAes(byte[] rawMessage, int cipherMode) {
        try {
            Cipher cipher = Cipher.getInstance(chifr);
            cipher.init(cipherMode, this.secretKey);
            byte[] output = cipher.doFinal(rawMessage);
            return output;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public byte[] makeAes(String rawMessage, int cipherMode) {
        try {
            Cipher cipher = Cipher.getInstance(chifr);
            cipher.init(cipherMode, this.secretKey);
            byte[] output = cipher.doFinal(rawMessage.getBytes());

            return output;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
