package com.wang.utils;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 自定义 xml 查询类
 */
public class MyXMLQuery {

    @Autowired
    File newXmlFile;

    private Document document;
    private SAXReader saxReader;


    /**
     * MyXMLQuery 构造函数
     * @param file xml 文件
     */
    public MyXMLQuery(File file) {
        this.saxReader = new MySAXReader().getSaxReader();
        try {
            this.document = this.saxReader.read(file);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查找所有节点
     * @param path 节点路径
     * @return 查询结果
     */
    public List<Node> queryAll(String path) {
        List<Node> nodes = document.selectNodes(path);
        MyFileWriter.wirteHead(newXmlFile);
        MyFileWriter.writeNode(nodes, newXmlFile);
        MyFileWriter.wirteTear(newXmlFile);
        return nodes;
    }

    /**
     * 查询所有满足课程名的节点
     * @param path 节点路径
     * @param name 课程名
     * @return 查询结果
     */
    public List<Node> queryByCourseName(String path, String name) {
        List<Node> nodes = document.selectNodes(path);
        List<Node> res = new ArrayList<>();
        MyFileWriter.wirteHead(newXmlFile);
        for(Node node : nodes) {
            String text = node.valueOf("@name");
            if(name.equals(text)) {
                res.add(node);
            }
        }
        MyFileWriter.writeNode(res, newXmlFile);
        MyFileWriter.wirteTear(newXmlFile);
        return res;
    }

    /**
     * 查询指定路径的满足教师的所有节点
     * @param path xml 节点路径
     * @param teacher 教师名
     * @return 查询结果 (xml 节点数组)
     */
    public List<Node> queryByTeacher(String path, String teacher) {
        List<Node> nodes = document.selectNodes(path);
        List<Node> res = new ArrayList<>();
        MyFileWriter.wirteHead(newXmlFile);
        for(Node node : nodes) {
            String text = node.selectSingleNode("teacher").getText();
            if(teacher.equals(text)) {
                res.add(node);
            }
        }
        MyFileWriter.writeNode(res, newXmlFile);
        MyFileWriter.wirteTear(newXmlFile);
        return res;
    }

    /**
     * 查询所有满足教学场地的所有节点
     * @param path 节点路径
     * @param room 教学场所
     * @return  查询结果 (xml 节点数组)
     */
    public List<Node> queryByRoom(String path, String room) {
        List<Node> nodes = document.selectNodes(path);
        List<Node> res = new ArrayList<>();
        MyFileWriter.wirteHead(newXmlFile);
        for(Node node : nodes) {
            String text = node.selectSingleNode("room").getText();
            if(room.equals(text)) {
                res.add(node);
            }
        }
        MyFileWriter.writeNode(res, newXmlFile);
        MyFileWriter.wirteTear(newXmlFile);
        return res;
    }

    /**
     * 查询所有满足教材的所有节点
     * @param path 节点路径
     * @param publication 教材
     * @return 查询结果 (xml 节点数组)
     */
    public List<Node> queryByPublication(String path, String publication) {
        List<Node> nodes = document.selectNodes(path);
        List<Node> res = new ArrayList<>();
        MyFileWriter.wirteHead(newXmlFile);
        for(Node node : nodes) {
            if(node.selectSingleNode("publication") == null)
                continue;
            String text = node.selectSingleNode("publication").getText();
            if(text.indexOf(publication) >= 0) {
                res.add(node);
            }
        }
        MyFileWriter.writeNode(res, newXmlFile);
        MyFileWriter.wirteTear(newXmlFile);
        return res;
    }

}
