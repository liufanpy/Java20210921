package com.itheima.es;

import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.IndicesClient;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;
import org.elasticsearch.cluster.metadata.MappingMetaData;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @author: yp
 */
@SpringBootTest(classes = EsApplication.class)
@RunWith(SpringRunner.class)
public class EsTest01 {


    //@Resource(name = "clusterClient")
    @Autowired
    private RestHighLevelClient client;

    @Test
    //创建索引
    public void fun01() throws IOException {
        //1. 获得操作索引对象
        IndicesClient indices = client.indices();
        //2. 创建 创建索引请求对象 设置索引名称
        CreateIndexRequest request = new CreateIndexRequest("szitheima");
        //3. 创建
        CreateIndexResponse response = indices.create(request, RequestOptions.DEFAULT);

        System.out.println(response.isAcknowledged());
    }

    @Test
    //创建索引,指定映射
    public void fun02() throws IOException {
        //1. 获得操作索引对象
        IndicesClient indices = client.indices();
        //2. 创建 创建索引请求对象 设置索引名称
        CreateIndexRequest request = new CreateIndexRequest("itcast");
        String mappingStr = "{\n" +
                "    \"properties\": {\n" +
                "      \"name\":{\n" +
                "        \"type\": \"keyword\"\n" +
                "      },\n" +
                "      \"age\":{\n" +
                "        \"type\": \"integer\"\n" +
                "      },\n" +
                "      \"address\":{\n" +
                "        \"type\": \"text\",\n" +
                "        \"analyzer\": \"ik_smart\"\n" +
                "      }\n" +
                "    }\n" +
                "  }";
        request.mapping(mappingStr,
                XContentType.JSON);
        //3. 创建
        CreateIndexResponse response = indices.create(request, RequestOptions.DEFAULT);
        System.out.println(response.isAcknowledged());
    }

    @Test
    public void fun03() throws IOException {
        GetIndexRequest request = new GetIndexRequest("szitheima");
        GetIndexResponse response = client.indices().get(request, RequestOptions.DEFAULT);
        Map<String, MappingMetaData> map = response.getMappings();
        System.out.println(map);
    }

    @Test
    public void fun04() throws IOException {
        //1. 获得操作索引对象
        //IndicesClient indices = client.indices();
        //2. 创建删除索引请求对象
        //DeleteRequest deleteRequest = new DeleteRequest("szitheima");
        //3. 调用delete()方法
        //DeleteResponse delete = indices.delete(deleteRequest, RequestOptions.DEFAULT);

        //System.out.println(response.status().getStatus());

        DeleteIndexRequest request = new DeleteIndexRequest("szitheima");
        AcknowledgedResponse deleteIndexResponse = client.indices().delete(request, RequestOptions.DEFAULT);
        System.out.println(deleteIndexResponse.isAcknowledged());
    }

    @Test
    //新增文档
    public void fun05() throws IOException {
        // 1. 创建IndexRequest
        HashMap map = new HashMap();
        map.put("name", "zs");
        map.put("age", 18);
        map.put("address", "北京");

        IndexRequest indexRequest = new IndexRequest("itcast").id("1").source(map);

        // 2. 调用index方法
        IndexResponse response = client.index(indexRequest, RequestOptions.DEFAULT);

        System.out.println(response.status().getStatus());

    }

    @Test
    public void fun06() throws IOException {
        IndexRequest request = new IndexRequest("itcast");
        request.id("2");
        String jsonString = "{" +
                "\"name\":\"ls\"," +
                "\"age\":\"19\"," +
                "\"address\":\"深圳\"" +
                "}";
        request.source(jsonString, XContentType.JSON);

        IndexResponse indexResponse = client.index(request, RequestOptions.DEFAULT);

        System.out.println(indexResponse.status().getStatus());

    }


    @Test
    //查询id为1的文档
    public void fun07() throws IOException {
        //1. 创建GetRequest对象
        GetRequest getRequest = new GetRequest("itcast", "1");

        //2. 调用get()方法
        GetResponse response = client.get(getRequest, RequestOptions.DEFAULT);

        System.out.println(response.getSourceAsString()); //把查询的结果通过字符串的方式打印

    }

    @Test
    //把id为1的name改成小叶子
    public void fun08() throws IOException {
        // 1. 创建IndexRequest
        HashMap map = new HashMap();
        map.put("name", "小叶子");

        IndexRequest indexRequest = new IndexRequest("itcast").id("1").source(map);

        // 2. 调用index方法
        IndexResponse response = client.index(indexRequest, RequestOptions.DEFAULT);

        System.out.println(response.status().getStatus());

    }

    @Test
    //把id为1的文档删除
    public void fun09() throws IOException {
       // 1. 创建DeleteRequest
        DeleteRequest deleteRequest = new DeleteRequest("itcast", "1");

        // 2. 调用delete方法
        DeleteResponse response = client.delete(deleteRequest, RequestOptions.DEFAULT);

        System.out.println(response.status().getStatus());

    }



    //创建索引
    @Test
    public void test01() throws IOException {
        //1. 获得索引对象
        IndicesClient indices = client.indices();
        //2. 创建 索引请求对象 设置索引名称
        CreateIndexRequest request = new CreateIndexRequest("itcast2");
        //3. 设置mapping
        String mapping ="{\n" +
                "    \"properties\": {\n" +
                "      \"name\":{\n" +
                "        \"type\": \"keyword\"\n" +
                "      },\n" +
                "      \"age\":{\n" +
                "        \"type\": \"integer\"\n" +
                "      },\n" +
                "      \"address\":{\n" +
                "        \"type\": \"text\",\n" +
                "        \"analyzer\": \"ik_smart\"\n" +
                "      }\n" +
                "    }\n" +
                "  }";
        //4. 添加映射
        request.mapping(mapping,XContentType.JSON);

        //创建
        CreateIndexResponse createIndexResponse = indices.create(request, RequestOptions.DEFAULT);

        System.out.println(createIndexResponse.isAcknowledged());
    }

}
