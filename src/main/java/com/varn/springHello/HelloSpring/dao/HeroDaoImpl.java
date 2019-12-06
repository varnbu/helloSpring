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
        String sql = "insert into table_hero(name,sex,areas,speed) values (?,?,?,?)";
        return jdbcTemplate.update(sql,
                hero.getName(), hero.getSex(), hero.getAreas(), hero.getSpeed());
    }

    @Override
    public int update(Hero hero) {
        String sql = "update table_hero set name=? where id=?";
        return jdbcTemplate.update(sql, hero.getName(), hero.getId());
    }

    @Override
    public int delete(int id) {
        String sql = "delete from table_hero where id=?";
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public Hero findById(int id) {
        String sql = "select * from table_hero where id=?";
        List<Hero> list = jdbcTemplate.query(sql, new Object[]{id}, new BeanPropertyRowMapper(Hero.class));
        if (list != null && list.size() > 0) {
            Hero hero = list.get(0);
            return hero;
        } else {
            return null;
        }
    }

    @Override
    public List<Hero> findHeroList() {
        String sql = "SELECT * FROM table_hero";
        List<Hero> list = jdbcTemplate.query(sql, new Object[]{}, new BeanPropertyRowMapper(Hero.class));
        if (list.size() > 0) {
            return list;
        } else {
            return null;
        }
    }
}
