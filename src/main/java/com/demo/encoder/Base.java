package com.demo.encoder;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * Base是网络上最常见的用于传输Bit字节代码的编码方式之一，大家可以查看RFC～RFC，上面有MIME的详细规范。Base编码可用于在HTTP环境下传递较长的标识信息。例如，在Java Persistence系统Hibernate中，就采用了Base来将一个较长的唯一标识符（一般为-bit的UUID）编码为一个字符串，用作HTTP表单和HTTP GET URL中的参数。在其他应用程序中，也常常需要把二进制数据编码为适合放在URL（包括隐藏表单域）中的形式。此时，采用Base编码具有不可读性，即所编码的数据不会被人用肉眼所直接看到。（来源百度百科）
 *
 * @description:
 * @author：yi.qin
 * @date：2021/12/30
 * @version：1.0
 * @slogan：打铁还需自身硬
 */
public class Base {
    /**
     * BASE解密
     * JRE 中 sun 和 com.sun 开头包的类都是未被文档化的，他们属于 java, javax 类库的基础，其中的实现大多数与底层平台有关，
     * <p>
     * 一般来说是不推荐使用的。
     *
     * @param key
     * @return
     * @throws Exception
     */

    public static byte[] decryptBASE(String key) throws Exception {

        return (new BASE64Decoder()).decodeBuffer(key);

    }

    /**
     * BASE加密
     *
     * @param key
     * @return
     * @throws Exception
     */
    public static String encryptBASE(byte[] key) throws Exception {
        return (new BASE64Encoder()).encodeBuffer(key);
    }

    public static void main(String[] args) {
        String str = "E99A18C428CB38D5F260853678922E03";
        try {
            String result = Base.encryptBASE(str.getBytes());
            System.out.println("result=====加密数据==========" + result);
            byte[] byteResult = Base.decryptBASE(result);
            String strr = new String(byteResult);
            System.out.println("str========解密数据========" + strr);

        } catch (Exception e) {

            e.printStackTrace();

        }

    }
}
