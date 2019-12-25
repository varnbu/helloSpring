package com.varn.springHello.HelloSpring.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HtmlController {
    @RequestMapping("/result")
    public String result(Model model) {
        model.addAttribute("message", "from controller");
        return "result";
    }
}
