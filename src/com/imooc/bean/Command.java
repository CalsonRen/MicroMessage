package com.imooc.bean;

import java.util.List;

/**
 * Created by baidu on 17/2/2.
 */
public class Command {
    private int id;
    private String name;
    private String description;

    // list of contents correspond to the command
    private List<CommandContent> contentList;

    // get and set function


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<CommandContent> getContentList() {
        return contentList;
    }

    public void setContentList(List<CommandContent> contentList) {
        this.contentList = contentList;
    }
}
