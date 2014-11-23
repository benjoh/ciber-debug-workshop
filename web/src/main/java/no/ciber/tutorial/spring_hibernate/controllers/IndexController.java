package no.ciber.tutorial.spring_hibernate.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

    @RequestMapping("/")
    @ResponseBody
    public String showIndex(){
        return "Hello world";
    }
}
