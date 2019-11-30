package com.varn.springHello.HelloSpring.daoImpl;

import com.varn.springHello.HelloSpring.c.Hero;
import com.varn.springHello.HelloSpring.dao.IHeroDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HeroDaoImpl implements IHeroDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int add(Hero hero) {
        return jdbcTemplate.update("insert into table_hero(name,sex,areas,speed) values (?,?,?,?)",
                hero.getName(), hero.getSex(), hero.getAreas(), hero.getSpeed());
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
        List<Hero> list = jdbcTemplate.query("SELECT * FROM table_hero", new Object[]{}, new BeanPropertyRowMapper(Hero.class));
        if (list.size() > 0) {
            return list;
        } else {
            return null;
        }
    }
}
