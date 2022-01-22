package com.sda.javaee9spring.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class FirstController {

    // the same as @slf4j
    //private static final Logger log = LoggerFactory.getLogger(FirstController.class);

    @GetMapping ("/my-first-page")
    public String firstPage(){
        log.info("firstPage() method called");
        return"home-page";
    }
}
