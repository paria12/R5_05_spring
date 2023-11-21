package com.spring.project.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class hello {
    
    @RequestMapping(value="/bonjour")
    public static String sayHello(){
        return "Bonjour le monde !";
    }
}
