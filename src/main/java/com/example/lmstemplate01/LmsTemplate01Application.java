package com.example.lmstemplate01;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LmsTemplate01Application {
    @Bean
    public ModelMapper modelMapper () {
        return  new  ModelMapper ();
    }

    public static void main(String[] args) {
        SpringApplication.run(LmsTemplate01Application.class, args);
    }

}
