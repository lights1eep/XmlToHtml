package com.wang.service;

import com.wang.entity.Course;

import java.util.List;

public interface QueryXMLService {
    public List<Course> queryAll();
    public List<Course> queryByCourseName(String name);
    public List<Course> queryByTeacher(String teacher);
    public List<Course> queryByRoom(String room);
    public List<Course> queryByPublication(String publication);
}
