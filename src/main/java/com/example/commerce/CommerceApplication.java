package com.example.commerce;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CommerceApplication implements CommandLineRunner {

    public static void main(String [] args){
        SpringApplication.run(CommerceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception{}
}
