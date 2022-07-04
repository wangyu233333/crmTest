package com.test;

import com.jopo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;

public class Demo1Test {
    public static void main(String[] args) {
        String file = "mybatis-config.xml";
        Reader reader = null;

        try {
            reader = Resources.getResourceAsReader(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //  1.创建sqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);

        //  2.创建SqlSession
        SqlSession session = factory.openSession();

        //  3.执行数据库操作
        User user = session.selectOne("selectUserById", 1);

        System.out.println(user);

        session.close();
    }

}
