package com.imooc.service;

import com.imooc.bean.Command;
import com.imooc.bean.CommandContent;
import com.imooc.dao.CommandDao;
import com.imooc.util.Iconst;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * Created by baidu on 17/1/21.
 */
public class QueryService {
    public String queryByCommand(String command){

        CommandDao commandDao = new CommandDao();
        List<Command> commandList = new ArrayList<>();

        if(Iconst.HELP_COMMAND.equals(command))
        {
            commandList = commandDao.queryCommandList(null, null);
            StringBuilder result = new StringBuilder();
            for(int i = 0; i < commandList.size(); ++i){
                if(i != 0){
                    result.append("<br/>");
                }
                result.append("回复[" + commandList.get(i).getName() + "]可以查看" + commandList.get(i).getDescription());
            }
            return result.toString();

        }

        commandList = commandDao.queryCommandList(command, null);
        if(commandList.size()>0) {
            List<CommandContent>contentList =  commandList.get(0).getContentList();
            int i = new Random().nextInt(contentList.size());
            return contentList.get(i).getContent();
        }
        return Iconst.NO_MATCH_CONTENT;

/*
        //MessageDao messageDao = new MessageDao();
        List<Message>messageList = new ArrayList<Message>();
        ListService listService = new ListService();
        if("帮助".equals(command)){
            messageList = listService.queryListMessage(null, null);
            StringBuilder result = new StringBuilder();
            for(int i = 0; i < messageList.size(); ++i){
                if(i != 0){
                    result.append("<br/>");
                }
                result.append("回复[" + messageList.get(i).getCommand() + "]可以查看" + messageList.get(i).getDescription());
            }
            return result.toString();
        }



        messageList = listService.queryListMessage(command, null);
        if(messageList.size() > 0)
            return messageList.get(0).getContent();
        return Iconst.NO_MATCH_CONTENT;
        */
    }

}
