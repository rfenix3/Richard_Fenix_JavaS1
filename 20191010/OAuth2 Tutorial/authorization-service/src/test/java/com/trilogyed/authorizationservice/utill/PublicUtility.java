package com.trilogyed.authorizationservice.utill;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PublicUtility {

    public static void main(String[] args) {
        PasswordEncoder enc = new BCryptPasswordEncoder();

        //user alex in mySQL db
        //String password = "password";

        //user bill in mySQL db
        //String password = "password2019"

        //user plainUser in mySQL db
        String password = "plain";
        String encodedPassword = enc.encode(password);
        System.out.println("plainUser (ROLE_USER) hashedPassword: " + encodedPassword);

        //user managerUser in mySQL db
        password = "manager";
        encodedPassword = enc.encode(password);
        System.out.println("managerUser (ROLE_MANAGER) hashedPassword: " + encodedPassword);

        //user adminUser in mySQL db
        password = "admin";
        encodedPassword = enc.encode(password);
        System.out.println("adminUser (ROLE_ADMIN) hashedPassword: " + encodedPassword);

    }
}
