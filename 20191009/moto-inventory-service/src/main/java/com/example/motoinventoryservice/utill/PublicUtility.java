package com.example.motoinventoryservice.utill;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PublicUtility {

    public static void main(String[] args) {
        PasswordEncoder enc = new BCryptPasswordEncoder();

        //user alex in mySQL db
        //String password = "password";

        //user bill in mySQL db
        //String password = "password2019"

        //user conner in mySQL db
        String password = "manager";
        String encodedPassword = enc.encode(password);
        System.out.println("conner (manager) hashedPassword: " + encodedPassword);

        //user johnson in mySQL db
        password = "person";
        encodedPassword = enc.encode(password);
        System.out.println("johnson (person) hashedPassword: " + encodedPassword);

        //user booker in mySQL db
        password = "staff";
        encodedPassword = enc.encode(password);
        System.out.println("booker (staff) hashedPassword: " + encodedPassword);

    }
}
