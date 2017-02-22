package com.imooc.bean;

/**
 * Created by baidu on 17/2/2.
 */
public class CommandContent {
    private int id;
    private String content;
    private int commandId;

    // get and set function

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getCommand_id() {
        return commandId;
    }

    public void setCommand_id(int command_id) {
        this.commandId = commandId;
    }
}
