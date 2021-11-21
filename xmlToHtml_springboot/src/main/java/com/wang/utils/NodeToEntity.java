package com.wang.utils;

import com.wang.entity.Course;
import org.dom4j.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * 将节点转为实体
 */
public class NodeToEntity {
    /**
     * 将节点转为课程实体
     * @param list 节点
     * @return 课程
     */
    public static List<Course> nodeTOCourse(List<Node> list) {
        List<Course> res = new ArrayList<>();
        for(Node node : list) {
            String name = node.valueOf("@name");
            String teacher = node.selectSingleNode("teacher").getText();
            String room = node.selectSingleNode("room").getText();
            if(node.selectSingleNode("publication") != null) {
                String publication = node.selectSingleNode("publication").getText();
                res.add(new Course(name, teacher, room, publication));
            } else {
                res.add(new Course(name, teacher, room));
            }
        }
        return res;
    }
}
