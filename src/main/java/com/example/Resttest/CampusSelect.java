package com.example.Resttest;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/campus-select")
public class CampusSelect {

    @RequestMapping("/all")
    public String Hello() {
        return "Hello World";
    }


}
