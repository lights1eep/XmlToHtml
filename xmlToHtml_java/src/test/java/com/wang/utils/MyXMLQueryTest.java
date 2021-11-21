package com.wang.utils;

import com.wang.entity.Course;
import org.dom4j.Node;
import org.junit.Test;

import java.io.File;
import java.util.List;

/**
 * MyXMLQuery 测试类
 */
public class MyXMLQueryTest {

    @Test
    public void queryAll() {
        File file = new File("src/main/resources/courses.xml");
        MyXMLQuery myXMLQuery = new MyXMLQuery(file);
        List<Node> nodes = myXMLQuery.queryAll("/courses/course");
        List<Course> courses = NodeToEntity.nodeTOCourse(nodes);
        for(Course course : courses) {
            System.out.println(course.toString());
        }
    }

    @Test
    public void queryByCourseName() {
        File file = new File("src/main/resources/courses.xml");
        MyXMLQuery myXMLQuery = new MyXMLQuery(file);
        List<Node> nodes = myXMLQuery.queryByCourseName("courses/course", "数据结构");
        List<Course> courses = NodeToEntity.nodeTOCourse(nodes);
        for(Course course : courses) {
            System.out.println(course.toString());
        }
    }

    @Test
    public void queryByTeacher() {
        File file = new File("src/main/resources/courses.xml");
        MyXMLQuery myXMLQuery = new MyXMLQuery(file);
        List<Node> nodes = myXMLQuery.queryByTeacher("courses/course", "王五");
        List<Course> courses = NodeToEntity.nodeTOCourse(nodes);
        for(Course course : courses) {
            System.out.println(course.toString());
        }
    }

    @Test
    public void queryByRoom() {
        File file = new File("src/main/resources/courses.xml");
        MyXMLQuery myXMLQuery = new MyXMLQuery(file);
        List<Node> nodes = myXMLQuery.queryByRoom("courses/course", "三教302");
        List<Course> courses = NodeToEntity.nodeTOCourse(nodes);
        for(Course course : courses) {
            System.out.println(course.toString());
        }
    }

    @Test
    public void queryByPublication() {
        File file = new File("src/main/resources/courses.xml");
        MyXMLQuery myXMLQuery = new MyXMLQuery(file);
        List<Node> nodes = myXMLQuery.queryByPublication("courses/course", "算法");
        List<Course> courses = NodeToEntity.nodeTOCourse(nodes);
        for(Course course : courses) {
            System.out.println(course.toString());
        }
    }
}