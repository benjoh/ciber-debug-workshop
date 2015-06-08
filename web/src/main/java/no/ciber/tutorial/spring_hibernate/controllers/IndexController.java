package no.ciber.tutorial.spring_hibernate.controllers;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @Value("${test.message}")
    private String message = "Hello world";

    @RequestMapping(value="/")
    public String showIndex(){
        return "index";
    }
}
