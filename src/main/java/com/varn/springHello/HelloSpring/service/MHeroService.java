package com.varn.springHello.HelloSpring.service;

import com.varn.springHello.HelloSpring.c.Hero;
import com.varn.springHello.HelloSpring.dao.MIHeroMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MHeroService {

    private MIHeroMapper miHeroMapper;

    public MHeroService(MIHeroMapper miHeroMapper) {
        this.miHeroMapper = miHeroMapper;
    }


    public List<Hero> findHeroList() {
        return miHeroMapper.findHeroList();
    }

}
