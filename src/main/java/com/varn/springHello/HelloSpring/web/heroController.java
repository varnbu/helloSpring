package com.varn.springHello.HelloSpring.web;

import com.varn.springHello.HelloSpring.c.Hero;
import com.varn.springHello.HelloSpring.service.IHeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/hero")
public class heroController {
    @Autowired
    IHeroService iHeroService;

    @RequestMapping("test")
    public String test() {

        char a = 'a';
        int n1 = 'a';
        char a1 = '\u0041';

        int[] arr = new int[5];
        int[] arr2 = new int[]{81, 32, 43, 42,90,46,75,66,45};

        String[] names = {"abc", "xyz", "zoo"};
        String s = names[1];
        names[1] = "cat";
        System.out.println(s);

        // foreach 循环
        for (int n : arr2) {
            System.out.println(n);
        }
        System.out.println(Arrays.toString(arr2));




        return "hero test";
    }

    @RequestMapping("list")
    public List<Hero> list() {
        return iHeroService.findHeroList();
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public int add(@RequestParam(value = "name") String name,
                   @RequestParam(value = "sex") int sex,
                   @RequestParam(value = "areas") int areas,
                   @RequestParam(value = "speed") int speed) {
        Hero hero = new Hero();
        hero.setName(name);
        hero.setSex(sex);
        hero.setAreas(areas);
        hero.setSpeed(speed);
        int res = iHeroService.add(hero);
        if (res == 1) {
            return 9;
        } else {
            return 0;
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String updateHero(@PathVariable("id") int id, @RequestParam(value = "name", required = true) String name) {
        Hero hero = new Hero();
        hero.setId(id);
        hero.setName(name);
        int count = iHeroService.update(hero);
        if (count > 0) {
            return hero.getName();
        } else {
            return "update fail";
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Hero getHero(@PathVariable("id") int id) {
        return iHeroService.findById(id);
    }
}
