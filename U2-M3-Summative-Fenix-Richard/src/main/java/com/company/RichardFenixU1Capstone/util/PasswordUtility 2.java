package com.company.RichardFenixU1Capstone.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordUtility {

    public static void main(String[] args) {
        PasswordEncoder enc = new BCryptPasswordEncoder();

        String password = "staff";
        String encodedPassword = enc.encode(password);
        System.out.println("staff password is set as " + encodedPassword);

        password = "manager";
        encodedPassword = enc.encode(password);
        System.out.println("manager password is set as " + encodedPassword);

        password = "admin";
        encodedPassword = enc.encode(password);
        System.out.println("admin password is set as " + encodedPassword);

    }
}