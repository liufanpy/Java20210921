package com.itheima.mybatis.builder;


import com.itheima.mybatis.binding.Mapper;
import com.itheima.mybatis.io.Resources;
import com.itheima.mybatis.session.Configuration;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 解析配置文件：
 * 1. sqlMapConfig.xml  --> configuration
 * 2. xxxMapper.xml    ---> mapper  -->configuration.mappers
 */
public class XMLConfigBuilder {

    // 定义封装数据的对象：
    private static Configuration configuration = new Configuration();


    /**
     * 解析核心配置文件的方法：
     * 读取配置信息，封装数据 （解析xml）
     *
     * @param config
     * @return
     */
    public static Configuration parseConfiguration(InputStream config) {

        System.out.println("**********【自定义mybatis开始工作了】*********");

        try {
            // 1. SAXReader 对象解析xml
            SAXReader saxReader = new SAXReader();

            // 2. 通过SAXReader将xml读取得到 document对象
            Document document = saxReader.read(config);

            // 3.通过document对象获取 configuration根节点
            Element rootElement = document.getRootElement();

            // 4.解析数据源节点   selectNodes查找节点
            loadDataSourceElement(rootElement);

            // 5.解析mapper文件节点  selectNodes查找节点
            loadMapperElement(rootElement);

            // 6. 返回configuration对象
            return configuration;


        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("加载配置文件时异常.....");
        } finally {

            try {
                config.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 解析数据源节点：
     *
     * @param rootElement
     */
    public static void loadDataSourceElement(Element rootElement) {

        // 1.可以通过xpath解析property标签，得到对应的数据
        List<Element> list = rootElement.selectNodes("//property");

        // 2.有多个property 需要遍历
        for (Element propertyElement : list) {

            // 获取每个property，获取name属性，
            String name = propertyElement.attributeValue("name");

            // 判断内容，然后进一步封装数据:
            if ("driver".equals(name)) {
                configuration.setDriver(propertyElement.attributeValue("value"));
            }
            if ("url".equals(name)) {
                configuration.setUrl(propertyElement.attributeValue("value"));
            }
            if ("username".equals(name)) {
                configuration.setUsername(propertyElement.attributeValue("value"));
            }
            if ("password".equals(name)) {
                configuration.setPassword(propertyElement.attributeValue("value"));
            }
        }

    }

    /**
     * 解析mappers节点
     *
     * @param rootElement
     */
    public static void loadMapperElement(Element rootElement) throws IOException {
        // 1.获取 mapper节点信息
        List<Element> list = rootElement.selectNodes("//mappers/mapper");

        // 2.mapper配置可能有多个，需要遍历
        for (Element element : list) {
            // 注意： 目前这里只解析了xml格式的 mapper， 后面可以继续判断注解 或者 包扫描；
            Attribute attribute = element.attribute("resource");
            String mapperPath = attribute.getValue();// 获取到： com/itheima/dao/UserMapper.xml

            if ("" != mapperPath && mapperPath.length() > 0) {
                // 具体解析每一个mapper映射文件中的内容：
                Map<String, Mapper> mappers = loadMapperXML(mapperPath);

                // 将mapper对象设置到 configuration对象中
                configuration.setMappers(mappers);

            }

        }

    }


    /**
     * 解析mapper.xml  --> 封装进map
     * <p>
     * 返回map:
     * key： 是唯一的 --> statementId = namespace + id --> "com.itheima.dao.UserMapper.findAll"
     * value:  mapper --> 解析 参数类型、返回值类型、sql语句
     *
     * @param mapperPath
     * @return
     */
    public static Map<String, Mapper> loadMapperXML(String mapperPath) throws IOException {
        InputStream inputStream = null;
        // mappers集合：
        Map<String, Mapper> mappers = new HashMap<>();


        try {
            // 1. 加载xml文件
            inputStream = Resources.getResourceAsStream(mapperPath);

            // 2. 读取文件，获得document
            Document document = new SAXReader().read(inputStream);

            // 3. 得到根节点
            Element rootElement = document.getRootElement();

            // 4. 得到namespace
            String namespace = rootElement.attributeValue("namespace");

            // 5.得到每个crud标签，解析内容 ：
            // 目前我们先解析 select
            List<Element> list = rootElement.selectNodes("//select");

            // 6. 可能有多个 statement，需要遍历
            for (Element element : list) {
                // 取出id
                String id = element.attributeValue("id");

                // 取出 sql
                String sql = element.getText();  //  select * from user

                // 取出参数类型
                String parameterType = element.attributeValue("parameterType");

                // 取出返回值类型
                String resultType = element.attributeValue("resultType");

                Mapper mapper = new Mapper();
                mapper.setQueryString(sql);
                mapper.setResultType(resultType);
                mapper.setParameterType(parameterType);

                // 拼装key:   "com.itheima.dao.UserMapper.findAll"
                String key = namespace + "." + id;
                // 将mapper存入 mappers集合中
                mappers.put(key, mapper);

            }

            // 7. 将map信息封装完整，然后返回
            return mappers;

        } catch (DocumentException e) {
            e.printStackTrace();
            throw new RuntimeException("读取mapper文件异常");
        } finally {
            inputStream.close();
        }
    }

}
