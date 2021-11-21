package com.wang.controller;

import com.wang.entity.Course;
import com.wang.service.QueryXMLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QueryXMLController {
    @Autowired
    QueryXMLService queryXMLService;

    @RequestMapping("/all")
    public List<Course> queryAll() {
        return queryXMLService.queryAll();
    }

    @RequestMapping("/name/{name}")
    public List<Course> queryByCourseName(@PathVariable("name") String name) {
        return queryXMLService.queryByCourseName(name);
    }

    @RequestMapping("/teacher/{teacher}")
    public List<Course> queryByTeacher(@PathVariable("teacher") String teacher) {
        return queryXMLService.queryByTeacher(teacher);
    }

    @RequestMapping("/room/{room}")
    public List<Course> queryByRoom(@PathVariable("room") String room) {
        return queryXMLService.queryByRoom(room);
    }

    @RequestMapping("/publication/{publication}")
    public List<Course> queryByPublication(@PathVariable("publication") String publication) {
        return queryXMLService.queryByPublication(publication);
    }
}
