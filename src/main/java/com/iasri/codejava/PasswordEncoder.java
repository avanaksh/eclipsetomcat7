package com.iasri.codejava;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
        String rawPassword="avan1234";
        String encodedPassword=passwordEncoder.encode(rawPassword);
        
        System.out.println(encodedPassword);
        
	}

}
