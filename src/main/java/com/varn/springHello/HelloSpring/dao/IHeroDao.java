package com.varn.springHello.HelloSpring.dao;

import com.varn.springHello.HelloSpring.c.Hero;

import java.util.List;

public interface IHeroDao {
    int add(Hero hero);
    int update(Hero hero);
    int delete(Hero hero);
    Hero findById(int id);
    List<Hero> findHeroList();
}
