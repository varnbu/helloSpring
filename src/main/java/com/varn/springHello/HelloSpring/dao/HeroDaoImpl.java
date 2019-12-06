package com.varn.springHello.HelloSpring.dao;

import com.varn.springHello.HelloSpring.c.Hero;
import com.varn.springHello.HelloSpring.dao.IHeroDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HeroDaoImpl implements IHeroDao {
    private JdbcTemplate jdbcTemplate;

    public HeroDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int add(Hero hero) {
        return jdbcTemplate.update("insert into table_hero(name,sex,areas,speed) values (?,?,?,?)",
                hero.getName(), hero.getSex(), hero.getAreas(), hero.getSpeed());
    }

    @Override
    public int update(Hero hero) {
        return jdbcTemplate.update("update table_hero set name=? where id=?",
                hero.getName(), hero.getId());
    }

    @Override
    public int delete(int id) {
        return jdbcTemplate.update("delete from table_hero where id=?0",
                id);
    }

    @Override
    public Hero findById(int id) {
        List<Hero> list = jdbcTemplate.query("select * from table_hero where id=?", new Object[]{id}, new BeanPropertyRowMapper(Hero.class));
        if (list != null && list.size() > 0) {
            Hero hero = list.get(0);
            return hero;
        } else {
            return null;
        }
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
