package com.varn.springHello.HelloSpring.service;

import com.varn.springHello.HelloSpring.c.Hero;
import com.varn.springHello.HelloSpring.dao.MIHeroMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MHeroService {
    @Autowired
    private MIHeroMapper miHeroMapper;

    public List<Hero> findHeroList() {
        return miHeroMapper.findHeroList();
    }

}
