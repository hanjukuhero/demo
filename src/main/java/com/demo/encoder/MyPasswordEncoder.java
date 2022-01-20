package com.demo.encoder;

import org.springframework.security.crypto.password.PasswordEncoder;

import java.security.NoSuchAlgorithmException;

/**
 * @description:
 * @author：yi.qin
 * @date：2021/12/30
 * @version：1.0
 * @slogan：打铁还需自身硬
 */
public class MyPasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(CharSequence rawPassword) {

        String encodedPassword = "";
        // add salt
        String saltedPassword = Common.SALT + rawPassword.toString();
        //encrypt the password
        encodedPassword = MD.getResult(saltedPassword);

        return encodedPassword;
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return false;
    }
}
