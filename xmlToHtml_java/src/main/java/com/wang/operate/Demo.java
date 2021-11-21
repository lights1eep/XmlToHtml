package com.wang.operate;

import com.wang.entity.Course;
import com.wang.utils.MyXMLQuery;
import com.wang.utils.NodeToEntity;
import org.dom4j.Node;

import java.io.File;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        File file = new File("src/main/resources/courses.xml");
        MyXMLQuery myXMLQuery = new MyXMLQuery(file);
        List<Node> list = myXMLQuery.queryByCourseName("/courses/course", "太极");
        List<Course> courses = NodeToEntity.nodeTOCourse(list);
        for(Course course : courses) {
            System.out.println(course.toString());
        }
    }
}
