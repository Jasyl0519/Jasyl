import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class DataDemo {
    /**
     * 请求ID
     */
    public static final String APPIDKEY = "thappid";
    /**
     * 加密的请求参数
     */
    public static final String PARAMETERKEY = "thparameters";
    /**
     * 请求签名
     */
    public static final String SIGNKEY = "thsign";

    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException, InvalidKeySpecException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, IOException {
        /***
         * 环境 编码utf8 jdk1.7
         * 加密过程
         * 请求参数三个 ，顺序固定
         *  thappid  请求ID
         *  thparameters 加密的请求参数，
         *  thsign 请求签名
         *

         *  thparameters产生说明：
         *  1 封装参数和url请求参数一样,如：shopid=1243456&type=09,顺序固定
         *  2使用ThDataUtil.thencrypt方法进行运用appkey进行编码
         *
         *  thsign 产生说明
         *  1 封装请求url，如thappid=123456&thparameters=xxxdeeee ,顺序固定
         *  2 使用ThDataUtil.getSign产生签名
         */
        String key = thGeneratorKey();//生成就不变的
        String thAppId="123456";
        String text = "shopid=31&type=09";
        String thparameters = thencrypt(key,text);
        String req = APPIDKEY+"="+thAppId+"&"+PARAMETERKEY+"="+text;
        String thsign= getSign(req);
        System.out.println("请求参数："+APPIDKEY+"="+thAppId+"&"+PARAMETERKEY+"="+thparameters+"&"+SIGNKEY+"="+thsign);

        System.out.println("秘钥："+key);
        System.out.println("参数加密："+PARAMETERKEY+"="+thparameters);
        System.out.println("参数解密："+thdecrypt(key, thparameters));
        System.out.println("请求参数："+SIGNKEY+"="+thsign);

    }

    /**
     * 获取key
     * @return
     * @throws NoSuchAlgorithmException
     */
    private static String thGeneratorKey() throws NoSuchAlgorithmException {
        //生成key
        KeyGenerator generator = KeyGenerator.getInstance("DES");
        generator.init(56);
        SecretKey key = generator.generateKey();
        byte[] byteKey = key.getEncoded();
        return new String(byteKey);
    }

    /**
     * 加密
     * @return
     * @throws InvalidKeyException
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     * @throws NoSuchPaddingException
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     */
    private static String thencrypt(String key,String  text) throws InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException  {
        // key 转换
        DESKeySpec keyspace = new DESKeySpec(key.getBytes());
        SecretKeyFactory factory = SecretKeyFactory.getInstance("DES");
        Key ckey = factory.generateSecret(keyspace);

        // 加密
        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, ckey);
        byte[] result = cipher.doFinal(text.getBytes());
        return new sun.misc.BASE64Encoder().encode(result);
    }


    /**
     * 解密
     * @throws IOException
     */
    private static String thdecrypt(String key,String  text) throws InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, IOException  {
        byte[] bytetext = new sun.misc.BASE64Decoder().decodeBuffer(text);
        // key 转换
        DESKeySpec keyspace = new DESKeySpec(key.getBytes());
        SecretKeyFactory factory = SecretKeyFactory.getInstance("DES");
        Key ckey = factory.generateSecret(keyspace);
        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, ckey);
        return new String(cipher.doFinal(bytetext));
    }

    /**
     * Md5摘要算法
     * @param str
     * @return
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
    public static String getSign(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException{
        //确定计算方法
        MessageDigest md5=MessageDigest.getInstance("MD5");
        //加密后的字符串
        String newstr= new sun.misc.BASE64Encoder().encode(md5.digest(str.getBytes("utf-8")));
        return newstr;
    }


}
