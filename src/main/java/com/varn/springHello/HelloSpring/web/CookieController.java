package com.varn.springHello.HelloSpring.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/cookie")
public class CookieController {
    @RequestMapping("/test")
    public String cookie(@RequestParam("browser") String brower, HttpServletRequest requset, HttpSession session) {

        return "1";
    }
}
