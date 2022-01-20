package com.demo.encoder;

import lombok.extern.slf4j.Slf4j;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

/**
 * MD即Message-Digest Algorithm （信息-摘要算法），用于确保信息传输完整一致。是计算机广泛使用的杂凑算法之一（又译摘要算法、哈希算法），主流编程语言普遍已有MD实现。将数据（如汉字）运算为另一固定长度值，是杂凑算法的基础原理，MD的前身有MD、MD和MD。广泛用于加密和解密技术，常用于文件校验。校验？不管文件多大，经过MD后都能生成唯一的MD值。好比现在的ISO校验，都是MD校验。怎么用？当然是把ISO经过MD后产生MD的值。一般下载linux-ISO的朋友都见过下载链接旁边放着MD的串。就是用来验证文件是否一致的。
 * 通常我们不直接使用上述MD加密。通常将MD产生的字节数组交给BASE再加密一把，得到相应的字符串
 * @description: MD(Message Digest algorithm ，信息摘要算法)
 * @author：yi.qin
 * @date：2021/12/30
 * @version：1.0
 * @slogan：打铁还需自身硬
 */
@Slf4j
public class MD {
    public static final String KEY_MD = "MD5";

    public static String getResult(String inputStr) {
        log.info("加密前的数据:{}", inputStr);
        StringBuilder result = new StringBuilder();
        try {
            MessageDigest md = MessageDigest.getInstance(KEY_MD);
            md.update(inputStr.getBytes(StandardCharsets.UTF_8));
            byte[] s = md.digest();

            for (byte b : s) {
                result.append(Integer.toHexString((0x000000ff & b) | 0xffffff00).substring(6));
            }
            log.info("MD加密后:{}", result.toString().toUpperCase());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String inputStr = "abc123";
        getResult(inputStr);

        StringBuffer sb = new StringBuffer();
        StringBuffer sb1 = new StringBuffer();
        sb.append(sb1);
    }
}
