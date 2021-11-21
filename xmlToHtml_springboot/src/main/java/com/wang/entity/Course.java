package com.wang.entity;

import lombok.Data;
import lombok.ToString;

/**
 * 课程实体类
 */
@Data
@ToString
public class Course {
    private String name;        //课程名
    private String teacher;     //教师
    private String room;        //教学场地
    private String publication; //教材

    public Course(String name, String teacher, String room, String publication) {
        this.name = name;
        this.teacher = teacher;
        this.room = room;
        this.publication = publication;
    }

    public Course(String name, String teacher, String room) {
        this(name, teacher, room, "无");
    }
}
