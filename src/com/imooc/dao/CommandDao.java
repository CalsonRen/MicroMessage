package com.imooc.dao;

import com.imooc.bean.Command;
import com.imooc.db.DBAccess;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by baidu on 17/2/2.
 * database operation correspond to command table
 */
public class CommandDao {
    public List<Command> queryCommandList(String name, String description){

        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        List<Command> commandList = new ArrayList<Command>();

        try {
            Command command = new Command();
            command.setName(name);
            command.setDescription(description);
            sqlSession = dbAccess.getSqlSession();
            commandList = sqlSession.selectList("Command.queryCommandList", command);
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(sqlSession != null)
                sqlSession.close();
        }
        return commandList;
    }

}
