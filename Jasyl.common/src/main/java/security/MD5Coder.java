package security;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * Created by jason on 16/4/14.
 */
public abstract class MD5Coder {

    public final static String ENCODING = "UTF-8";

    /**
     * MD5消息摘要
     */
    public static byte[] encodeMD5(String data) {
        return DigestUtils.md5(data);
    }

    /**
     * MD5消息摘要 转成十六进制
     */
    public static String encodeMD5Hex(String data) {

        return DigestUtils.md5Hex(data);
    }
}
