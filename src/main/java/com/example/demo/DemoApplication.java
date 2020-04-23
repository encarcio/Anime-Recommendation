package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.*;

@Controller
@SpringBootApplication
public class DemoApplication {

    @GetMapping("/hello")
    @ResponseBody
    public String home() {
      return "index";
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}