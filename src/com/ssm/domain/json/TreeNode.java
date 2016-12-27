package com.ssm.domain.json;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/12/20.
 */




public class TreeNode {
    private int id;
    private String text;
    private String state;
    private List<ChildNode> children = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<ChildNode> getChildren() {
        return children;
    }

    public void setChildren(List<ChildNode> children) {
        this.children = children;
    }
    private Attribute attributes;

    public Attribute getAttributes() {
        return attributes;
    }

    public void setAttributes(Attribute attributes) {
        this.attributes = attributes;
    }
}
