package com.wang.utils;

import org.dom4j.io.SAXReader;

/**
 * xml SAXReader 工厂类
 */
public class MySAXReader {
    private SAXReader saxReader;

    public SAXReader getSaxReader() {
        saxReader = new SAXReader();
        return saxReader;
    }
}
