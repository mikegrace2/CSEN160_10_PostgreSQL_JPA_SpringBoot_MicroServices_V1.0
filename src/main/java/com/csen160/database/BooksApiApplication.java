package com.csen160.database;

import lombok.extern.java.Log;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Log
public class BooksApiApplication {
    /**
     * Taken from Devtiro https://www.youtube.com/watch?v=Nv2DERaMx-4
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(BooksApiApplication.class, args);
    }
}
