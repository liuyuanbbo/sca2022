package org.mybatis3.example;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis3.example.mapper.PersonMapper;
import org.mybatis3.example.pojo.Person;

import java.io.InputStream;

public class MainTest01 {

    public static SqlSession getSqlSession() {
        String resource = "mybatis-config.xml";
        InputStream is = MainTest01.class.getClassLoader().getResourceAsStream(resource);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        return factory.openSession(true); // false 默认手动提交, true 自动提交
    }

    public static void main(String[] args) {
        SqlSession sqlSession = getSqlSession();
        PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);
        Person person = personMapper.getPersonById(1L);
        System.out.println(person);
    }
}
