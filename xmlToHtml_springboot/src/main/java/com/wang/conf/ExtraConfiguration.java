package com.wang.conf;

import com.wang.utils.MyXMLQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;

/**
 * 额外配置类
 */
@Configuration
public class ExtraConfiguration {

    /**
     * 已有 xml 文件
     * @return xml 文件
     */
    @Bean
    public File XMLFile() {
        ClassPathResource classPathResource = new ClassPathResource("courses.xml");
        File file = null;
        try {
            file = classPathResource.getFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

    @Autowired
    File XMLFile;

    /**
     * MyXMLQuery 对象
     * @return MyXMLQuery 对象
     */
    @Bean
    public MyXMLQuery myXMLQuery() {
        return new MyXMLQuery(XMLFile);
    }

    /**
     * 结果 xml 文件
     * @return xml 文件
     */
    @Bean
    public File newXmlFile() {
        return new File("E:/JavaFile/XmlToHtml/xmlToHtml_springboot/src/main/resources/index.xml");
    }
}
