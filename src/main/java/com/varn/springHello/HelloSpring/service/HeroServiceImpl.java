package com.varn.springHello.HelloSpring.service.serviceImpl;

import com.varn.springHello.HelloSpring.c.Hero;
import com.varn.springHello.HelloSpring.dao.IHeroDao;
import com.varn.springHello.HelloSpring.service.IHeroService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeroServiceImpl implements IHeroService {
    IHeroDao iHeroDao;

    public HeroServiceImpl(IHeroDao iHeroDao) {
        this.iHeroDao = iHeroDao;
    }

    @Override
    public int add(Hero hero) {
        return iHeroDao.add(hero);
    }

    @Override
    public int update(Hero hero) {
        return iHeroDao.update(hero);
    }

    @Override
    public int delete(int id) {
        return iHeroDao.delete(id);
    }

    @Override
    public Hero findById(int id) {
        return iHeroDao.findById(id);
    }

    @Override
    public List<Hero> findHeroList() {
        return iHeroDao.findHeroList();
    }
}
