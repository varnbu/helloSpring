package com.varn.springHello.HelloSpring.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HtmlController {
    @RequestMapping("/result")
    public String result(@RequestParam(defaultValue = "world") String name, Model model) {
        model.addAttribute("message", name+" say hello");
        return "result";
    }
}
