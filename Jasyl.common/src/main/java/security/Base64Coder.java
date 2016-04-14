package security;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;

import java.io.UnsupportedEncodingException;

/**
 * Created by jason on 16/4/14.
 *
 * commons.codec.binary.Base64方式
 *
 * BASE64 编码解码
 */

@Slf4j
public abstract class Base64Coder {
    /**
     * 字符编码
     */
    public final static String ENCODING = "UTF-8";

    /**
     * Base64编码
     */
    public static String encode(String data) {

        try {
            byte[] b = Base64.encodeBase64(data.getBytes(ENCODING));
            return new String(b, ENCODING);
        } catch (UnsupportedEncodingException e) {
            log.info("encode编码异常:{}", e);
            return "";
        }
    }

    /**
     * Base64编码
     */
    public static String encode(byte[] data) {

        try {
            byte[] b = Base64.encodeBase64(data);
            return new String(b, ENCODING);
        } catch (UnsupportedEncodingException e) {
            log.info("encode编码异常:{}", e);
            return "";
        }
    }

    /**
     * Base64安全编码
     */
    public static String encodeSafe(String data) {
        try {
            byte[] b = Base64.encodeBase64(data.getBytes(ENCODING), true);
            return new String(b, ENCODING);
        } catch (UnsupportedEncodingException e) {
            log.info("encodeSafe编码异常:{}", e);
            return "";
        }
    }

    /**
     * Base64解码
     */
    public static String decode(String data) {
        try {
            byte[] b = Base64.decodeBase64(data.getBytes(ENCODING));
            return new String(b, ENCODING);
        } catch (UnsupportedEncodingException e) {
            log.info("decode解码异常:{}", e);
            return "";
        }
    }




}
