package com.varn.springHello.HelloSpring.service;

import com.varn.springHello.HelloSpring.c.Hero;

import java.util.List;

public interface IHeroService {
    int add(Hero hero);

    int update(Hero hero);

    int delete(int id);

    Hero findById(int id);

    List<Hero> findHeroList();
}
