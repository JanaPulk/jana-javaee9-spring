package com.sda.javaee9spring.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
@RequestMapping("/first")
public class FirstController {

    // the same as @slf4j
    //private static final Logger log = LoggerFactory.getLogger(FirstController.class);

    @GetMapping({"/my-first-page", "/"})
    public String firstPage() {
        log.info("firstPage() method called");
        return "home-page";
    }

    @GetMapping("/my-second-page")
    public String secondPage() {
        log.info("secondPage () method called");
        return "second-page";
    }

    //@GetMapping
    @GetMapping(value ={ "/my-third-page","/third-too", "/abcd"})
    public String thirdPage() {
        log.info("third page() method called");
        return "pages/third-page";
    }

    // /my-name?name=jana&surname=pulk
    @GetMapping("/my-name")
    public String myName(@RequestParam(value = "name", defaultValue = "Jana") String myName,
                         @RequestParam(value = "surname", defaultValue = "Pulk") String mySurname,
                         Model pageParameters){
        log.info("myName()", "method was called");
        log.info("my name is:[{}] and my surname is: [{}]", myName, mySurname);
        log.info(String.format("my name is: [%s] and my surname is: [%s]",myName, mySurname));

        pageParameters.addAttribute("myName",myName)
                .addAttribute("mySurname",mySurname);

            return "pages/name-and-surname";
        }

        @PostMapping("/my-first-post")
    public String myFirstOtherThanGetHttpMethod(){
        log.info("myFirstOtherThanGetHttpMethod() was called");

        return"pages/post-page";
        }

    }

