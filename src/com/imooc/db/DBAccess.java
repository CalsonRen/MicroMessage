package com.imooc.db;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;


/**
 * Created by renjie on 17/1/15.
 * access to database
 */
public class DBAccess {
    public SqlSession getSqlSession() throws IOException{
        //get sqlSession through configure file.
        Reader reader = Resources.getResourceAsReader("com/imooc/config/Configuration.xml");
        // create sqlSession factory by reading configure file.
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        // open sqlSession.
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession;
    }
}
