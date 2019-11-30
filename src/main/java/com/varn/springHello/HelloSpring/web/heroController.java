package com.varn.springHello.HelloSpring.web;

import com.varn.springHello.HelloSpring.c.Hero;
import com.varn.springHello.HelloSpring.service.IHeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hero")
public class heroController {
    @Autowired
    IHeroService iHeroService;
    @RequestMapping("/test")
    public String test() {
        return "hero test";
    }
    @RequestMapping("list")
    public List<Hero> list(){
        return iHeroService.findHeroList();
    }
}
