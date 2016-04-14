package security;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by jason on 16/4/14.
 */
public abstract class SHACoder {
    public final static String ENCODING = "UTF-8";

    public final static String SHA = "SHA";
    public final static String SHA256 = "SHA256";
    public final static String SHA384 = "SHA384";
    public final static String SHA512 = "SHA512";

    /**
     * SHA消息摘要
     */
    public static byte[] encodeSHA(String data) {

        return DigestUtils.sha(data);
    }

    /**
     * SHA消息摘要
     * 十六进制
     */
    public static String encodeSHAHex(String data) {
        return DigestUtils.shaHex(data);
    }


    /**
     *
     * @param data 待加密数据
     * @param type 加密算法类型 SHA,SHA256,SHA384,SHA512
     */
    public static byte[] encodeSHA(String data, String type) {

        if (SHA.equalsIgnoreCase(type)) {
            return DigestUtils.sha(data);

        } else if (SHA256.equalsIgnoreCase(type)) {
            return DigestUtils.sha256(data);

        } else if (SHA384.equalsIgnoreCase(type)) {
            return DigestUtils.sha384(data);

        } else if (SHA512.equalsIgnoreCase(type)) {
            return DigestUtils.sha512(data);
        }

        return null;

    }

    /**
     * @param data 待加密数据
     * @param type 加密算法类型 SHA,SHA256,SHA384,SHA512
     */
    public static String encodeSHAHex(String data, String type) {

        if (SHA.equalsIgnoreCase(type)) {
            return DigestUtils.shaHex(data);

        } else if (SHA256.equalsIgnoreCase(type)) {
            return DigestUtils.sha256Hex(data);

        } else if (SHA384.equalsIgnoreCase(type)) {
            return DigestUtils.sha384Hex(data);

        } else if (SHA512.equalsIgnoreCase(type)) {
            return DigestUtils.sha512Hex(data);
        }

        return null;
    }


    public static byte[] encode(String data){

        try {
            MessageDigest md = MessageDigest.getInstance("SHA");
            return md.digest(data.getBytes(ENCODING));

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static String encodeHex(String data){
        byte[] b = encode(data);
        return Hex.encodeHexString(b);
    }

}
