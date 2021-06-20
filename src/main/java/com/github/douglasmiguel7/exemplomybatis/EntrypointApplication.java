package com.github.douglasmiguel7.exemplomybatis;

import com.github.douglasmiguel7.exemplomybatis.domain.Person;
import com.github.douglasmiguel7.exemplomybatis.mybatisrepository.PersonMyBatisRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class EntrypointApplication {

    public static void main(String[] args) {
        SpringApplication.run(EntrypointApplication.class, args);
    }

    @Bean
    public boolean onStartup(PersonMyBatisRepository personMyBatisRepository) {
        Person doug = Person.builder().name("doug").build();

        personMyBatisRepository.save(doug);

        List<Person> persons = personMyBatisRepository.findAll();

        persons.stream().map(person -> String.format("Save %s", person)).forEach(System.out::println);

        return true;
    }

}
