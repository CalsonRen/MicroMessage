package com.imooc.service;

import com.imooc.bean.Message;
import com.imooc.dao.MessageDao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by baidu on 17/1/20.
 */
public class MaintainService {
    public void deleteOne(String id){
        if(id != null && !"".equals(id.trim())){
            MessageDao messageDao = new MessageDao();
            messageDao.deleteOne(Integer.valueOf(id));
        }

    }

    public void deleteBatch(String[] ids){
        MessageDao messageDao = new MessageDao();
        List<Integer>idList = new ArrayList<>();
        for(String id : ids){
            idList.add(Integer.valueOf(id));
        }
        messageDao.deleteBatch(idList);
    }

    public void insertOne(String command, String description, String content){
        if(command != null && description != null && content != null){

            MessageDao messageDao = new MessageDao();
            Message message = new Message();
            message.setDescription(description);
            message.setCommand(command);
            message.setContent(content);
            messageDao.insertOne(message);
        }

    }
}
