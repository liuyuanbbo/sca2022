package org.mybatis3.example.mapper;

import org.mybatis3.example.pojo.Person;

public interface PersonMapper {
    Person getPersonById(Long id);
}
