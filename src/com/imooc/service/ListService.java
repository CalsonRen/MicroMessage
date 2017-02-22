package com.imooc.service;

import com.imooc.bean.Message;
import com.imooc.dao.MessageDao;

import java.util.List;

/**
 * Created by renjie on 17/1/15.
 * service logic about list
 */
public class ListService {
    public List<Message> queryListMessage(String command, String description){
        MessageDao messageDao = new MessageDao();
        return messageDao.queryMessageList(command, description);
    }

}
