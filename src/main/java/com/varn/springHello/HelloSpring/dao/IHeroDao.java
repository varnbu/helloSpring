package com.varn.springHello.HelloSpring.dao;

import com.varn.springHello.HelloSpring.c.Hero;

import java.util.List;

public interface IHeroDao {
    int add(Hero hero);
    int update(Hero hero);
    int delete(int id);
    Hero findById(int id);
    List<Hero> findHeroList();
}
