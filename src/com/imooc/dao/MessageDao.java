package com.imooc.dao;

import com.imooc.bean.Message;
import com.imooc.db.DBAccess;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by renjie on 17/1/15.
 * operation on message table
 */
public class MessageDao {
    /**
     * query message list according to the condition.
     */
    public List<Message> queryMessageList(String command, String description){

        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        List<Message> messageList = new ArrayList<Message>();

        try {
            Message message = new Message();
            message.setCommand(command);
            message.setDescription(description);
            sqlSession = dbAccess.getSqlSession();
            messageList = sqlSession.selectList("Message.queryMessageList", message);
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(sqlSession != null)
                sqlSession.close();
        }
        return messageList;
    }

    public void deleteOne(int id){
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;

        try{
            sqlSession = dbAccess.getSqlSession();
            sqlSession.delete("Message.deleteOne", id);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(sqlSession != null)
                sqlSession.close();
        }
    }

    public void deleteBatch(List<Integer> ids){
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            sqlSession.delete("Message.deleteBatch", ids);
            sqlSession.commit();
        }catch (IOException e){
            e.printStackTrace();
        }finally{
            if(sqlSession != null)
                sqlSession.close();
        }

    }

    public void insertOne(Message message)
    {
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            sqlSession.insert("Message.insertOne", message);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(sqlSession != null)
                sqlSession.close();
        }
    }

//    public List<Message> queryMessageList(String command, String description){
//        List<Message> messageList = new ArrayList<Message>();
//        try {
//
//            //connect to mysql
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/micro_message?characterEncoding=UTF-8", "renjie", "renjie992424");
//
//            // create query sql
//            StringBuilder sql = new StringBuilder("select id, command, description, content from message where 1=1");
//            List<String> paramList = new ArrayList<String>();
//
//            // concatenate sql
//            if(command != null && !"".equals(command.trim())){
//                sql.append(" and command = ?");
//                paramList.add(command);
//            }
//            if(description != null && !"".equals(description.trim())){
//                sql.append(" and description like '%' ? '%'");
//                paramList.add(description);
//            }
//
//            PreparedStatement statement = conn.prepareStatement(sql.toString());
//
//            for(int i = 0; i < paramList.size(); i++){
//                statement.setString(i+1, paramList.get(i));
//            }
//
//            //execute sql
//            ResultSet rs = statement.executeQuery();
//
//            //handle result.
//            while(rs.next()){
//                Message message = new Message();
//                messageList.add(message);
//                message.setId(rs.getString("id"));
//                message.setCommand(rs.getString("command"));
//                message.setDescription(rs.getString("description"));
//                message.setContent(rs.getString("content"));
//            }
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return messageList;
//
//    }
}
