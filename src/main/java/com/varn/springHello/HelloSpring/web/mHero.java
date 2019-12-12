package com.varn.springHello.HelloSpring.web;

import com.varn.springHello.HelloSpring.c.Hero;
import com.varn.springHello.HelloSpring.service.MHeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/mhero")
public class mHero {
    @Autowired
    MHeroService mHeroService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Hero> getList() {
        System.out.println("mybatis 引入与使用");
        return mHeroService.findHeroList();
    }
}
