package com.wang.mapper;

import com.wang.utils.MyXMLQuery;
import org.dom4j.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class QueryXMLMapper {
    @Autowired
    MyXMLQuery myXMLQuery;

    public List<Node> queryAll() {
        return myXMLQuery.queryAll("/courses/course");
    }

    public List<Node> queryByCourseName(String name) {
        return myXMLQuery.queryByCourseName("/courses/course", name);
    }

    public List<Node> queryByTeacher(String teacher) {
        return myXMLQuery.queryByTeacher("/courses/course", teacher);
    }

    public List<Node> queryByRoom(String room) {
        return myXMLQuery.queryByRoom("/courses/course", room);
    }

    public List<Node> queryByPublication(String publication) {
        return myXMLQuery.queryByPublication("/courses/course", publication);
    }

}
