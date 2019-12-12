package com.varn.springHello.HelloSpring.dao;


import com.varn.springHello.HelloSpring.c.Hero;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MIHeroMapper {
    @Select("select name, id , sex, areas, speed  from table_hero")
    List<Hero> findHeroList();
}
