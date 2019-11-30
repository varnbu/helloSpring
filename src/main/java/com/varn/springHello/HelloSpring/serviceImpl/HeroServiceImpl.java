package com.varn.springHello.HelloSpring.serviceImpl;

import com.varn.springHello.HelloSpring.c.Hero;
import com.varn.springHello.HelloSpring.dao.IHeroDao;
import com.varn.springHello.HelloSpring.service.IHeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HeroServiceImpl implements IHeroService {
    @Autowired
    IHeroDao iHeroDao;

    @Override
    public int add(Hero hero) {
        return iHeroDao.add(hero);
    }

    @Override
    public int update(Hero hero) {
        return 0;
    }

    @Override
    public int delete(Hero hero) {
        return 0;
    }

    @Override
    public Hero findById(int id) {
        return null;
    }

    @Override
    public List<Hero> findHeroList() {
        return iHeroDao.findHeroList();
    }
}
