package com.github.douglasmiguel7.exemplomybatis.mybatisrepository;

import com.github.douglasmiguel7.exemplomybatis.domain.Person;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PersonMyBatisRepository {

    @Insert("insert into person(name) values (#{name})")
    @Options(useGeneratedKeys = true)
    Integer save(Person person);

    @Select("select * from person")
    List<Person> findAll();

}
