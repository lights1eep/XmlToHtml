package com.wang.service;

import com.wang.entity.Course;
import com.wang.mapper.QueryXMLMapper;
import com.wang.utils.NodeToEntity;
import org.dom4j.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QueryXMLServiceImpl implements QueryXMLService{

    @Autowired
    QueryXMLMapper queryXMLMapper;

    @Override
    public List<Course> queryAll() {
        List<Node> nodes = queryXMLMapper.queryAll();
        return NodeToEntity.nodeTOCourse(nodes);
    }

    @Override
    public List<Course> queryByCourseName(String name) {
        List<Node> nodes = queryXMLMapper.queryByCourseName(name);
        return NodeToEntity.nodeTOCourse(nodes);
    }

    @Override
    public List<Course> queryByTeacher(String teacher) {
        List<Node> nodes = queryXMLMapper.queryByTeacher(teacher);
        return NodeToEntity.nodeTOCourse(nodes);
    }

    @Override
    public List<Course> queryByRoom(String room) {
        List<Node> nodes = queryXMLMapper.queryByRoom(room);
        return NodeToEntity.nodeTOCourse(nodes);
    }

    @Override
    public List<Course> queryByPublication(String publication) {
        List<Node> nodes = queryXMLMapper.queryByPublication(publication);
        return NodeToEntity.nodeTOCourse(nodes);
    }
}
