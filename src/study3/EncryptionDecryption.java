package study3;

import javax.crypto.Cipher;
import java.security.Key;
import java.security.Security;

public class EncryptionDecryption {
    private static String strDefaultKey = "wfkey";

    //encrypt
    private Cipher encryptCipher = null;

    // decryption
    private Cipher decryptCipher = null;

    /**
     * byte array to hexadecimal
     *
     * @param arrB
     * @return 16
     * @throws Exception
     */
    public static String byteArr2HexStr(byte[] arrB) throws Exception {
        int bLen = arrB.length;
        //
        StringBuffer strBuffer = new StringBuffer(bLen * 2);
        for (int i = 0; i != bLen; ++i) {
            int intTmp = arrB[i];
            //
            while (intTmp < 0) {
                intTmp = intTmp + 256;//
            }
            //
            if (intTmp < 16) {
                strBuffer.append("0");
            }
            strBuffer.append(Integer.toString(intTmp, 16));
        }
        return strBuffer.toString();
    }


    /**
     * hex to byte array
     *
     * @param hexStr
     * @return
     * @throws Exception
     */
    public static byte[] hexStr2ByteArr(String hexStr) throws Exception {
        byte[] arrB = hexStr.getBytes();
        int bLen = arrB.length;
        byte[] arrOut = new byte[bLen / 2];
        for (int i = 0; i < bLen; i = i + 2) {
            String strTmp = new String(arrB, i, 2);
            arrOut[i / 2] = (byte) Integer.parseInt(strTmp, 16);
        }
        return arrOut;
    }

    /**
     * encrypt
     *
     * @throws Exception
     */
    public EncryptionDecryption() throws Exception {
        this(strDefaultKey);
    }


    /**
     * encryption
     *
     * @param strKey
     * @throws Exception
     */
    @SuppressWarnings("restriction")
    public EncryptionDecryption(String strKey) throws Exception {
        Security.addProvider(new com.sun.crypto.provider.SunJCE());
        Key key = getKey(strKey.getBytes());

        encryptCipher = Cipher.getInstance("DES");
        encryptCipher.init(Cipher.ENCRYPT_MODE, key);

        decryptCipher = Cipher.getInstance("DES");
        decryptCipher.init(Cipher.DECRYPT_MODE, key);
    }

    /**
     * encrypt
     *
     * @param arrB
     * @return
     * @throws Exception
     */
    public byte[] encrypt(byte[] arrB) throws Exception {
        return encryptCipher.doFinal(arrB);
    }

    /**
     * encrypt
     *
     * @param strIn
     * @return
     * @throws Exception
     */
    public String encrypt(String strIn) throws Exception {
        return byteArr2HexStr(encrypt(strIn.getBytes()));
    }

    /**
     * decrypt
     *
     * @param arrB
     * @return
     * @throws Exception
     */
    public byte[] decrypt(byte[] arrB) throws Exception {
        return decryptCipher.doFinal(arrB);
    }

    /**
     * decrypt
     *
     * @param strIn
     * @return
     * @throws Exception
     */
    public String decrypt(String strIn) throws Exception {
        try {
            return new String(decrypt(hexStr2ByteArr(strIn)));
        } catch (Exception e) {
            return "";
        }
    }


    /**
     * get the key
     *
     * @param arrBTmp
     * @return
     * @throws Exception
     */
    private Key getKey(byte[] arrBTmp) throws Exception {
        byte[] arrB = new byte[8]; //
        for (int i = 0; i < arrBTmp.length && i < arrB.length; ++i) {
            arrB[i] = arrBTmp[i];
        }

        //
        Key key = new javax.crypto.spec.SecretKeySpec(arrB, "DES");
        return key;
    }
}
