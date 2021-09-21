package com.itheima.es;

import com.alibaba.fastjson.JSON;
import com.itheima.es.bean.Goods;
import com.itheima.es.mapper.GoodsMapper;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.client.IndicesClient;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;
import org.elasticsearch.cluster.metadata.MappingMetaData;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.*;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.Aggregation;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.elasticsearch.search.sort.SortOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.lang.model.element.NestingKind;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @author: yp
 */
@SpringBootTest(classes = EsApplication.class)
@RunWith(SpringRunner.class)
public class EsTest02 {

    @Autowired
    private RestHighLevelClient client;

    @Autowired
    private GoodsMapper goodsMapper;

    @Test
    /*批量操作
     * 1. 删除2号记录
     * 2. 添加6号记录
     * 3. 修改8号记录 名称为 小叶子
     */
    public void fun01() throws IOException {
        //1. 创建BulkRequest对象
        BulkRequest bulkRequest = new BulkRequest();
        //2. 调用add()方法增加操作
        //删除2号记录
        DeleteRequest deleteRequest = new DeleteRequest("person1", "2");
        bulkRequest.add(deleteRequest);

        //添加6号记录
        HashMap map = new HashMap();
        map.put("name", "赵6");
        map.put("age", 6);
        map.put("address", "深圳");
        IndexRequest indexRequest = new IndexRequest("person1").id("6").source(map);
        bulkRequest.add(indexRequest);

        //修改8号记录 名称为 小叶子
        HashMap updateMap = new HashMap();
        updateMap.put("name", "小叶子");
        UpdateRequest updateRequest = new UpdateRequest("person1", "8").doc(updateMap);
        bulkRequest.add(updateRequest);

        //3. 调用bulk()方法
        BulkResponse responses = client.bulk(bulkRequest, RequestOptions.DEFAULT);
        System.out.println(responses.status().getStatus());

        client.close();

    }

    @Test
    public void fun02() throws IOException {
        List<Goods> goodsList = goodsMapper.selectList(null);
        //1.创建BulkRequest对象
        BulkRequest bulkRequest = new BulkRequest();

        //2.遍历goodsList, 创建IndexRequest, 添加到BulkRequest
        for (Goods goods : goodsList) {
            //转换spec  {"机身内存":"16G","网络":"联通3G"}
            Map map = JSON.parseObject(goods.getSpecStr(), Map.class);
            goods.setSpec(map);
            //创建IndexRequest
            IndexRequest indexRequest = new IndexRequest("goods").id(goods.getId() + "").source(JSON.toJSONString(goods), XContentType.JSON);
            // 添加到BulkRequest
            bulkRequest.add(indexRequest);
        }

        //3.调用bulk方法,批量操作
        client.bulk(bulkRequest, RequestOptions.DEFAULT);
        client.close();
    }

    @Test
    //matchall查询
    public void fun03() throws IOException {
        //1. 创建SearchRequest对象
        SearchRequest searchRequest = new SearchRequest("goods");
        //2. 创建查询条件构建器SearchSourceBuilder
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

        //3. 构建查询条件对象QueryBuilder
        MatchAllQueryBuilder builder = QueryBuilders.matchAllQuery();

        searchSourceBuilder.query(builder);
        searchRequest.source(searchSourceBuilder);

        //4. 调用search()方法
        SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);

        //5. 处理结果
        //获得查询的命中的对象(包含了查询出来的数据)
        SearchHits hits = response.getHits();
        System.out.println("总记录数=" + hits.getTotalHits().value);
        List<Goods> goodsList = new ArrayList<Goods>();

        for (SearchHit hit : hits) {
            //一个hit里面就包含了一个document(直接把document通过字符串的方式获得)
            String data = hit.getSourceAsString();
            Goods goods = JSON.parseObject(data, Goods.class);
            goodsList.add(goods);

        }
        System.out.println(goodsList);
        client.close();
    }

    @Test
    //term查询：不会对查询条件进行分词
    public void fun04() throws IOException {
        //1. 创建SearchRequest对象
        SearchRequest searchRequest = new SearchRequest("goods");
        //2. 创建查询条件构建器SearchSourceBuilder
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

        //3. 构建查询条件对象QueryBuilder
        TermQueryBuilder builder = QueryBuilders.termQuery("title", "华为");

        searchSourceBuilder.query(builder);
        searchRequest.source(searchSourceBuilder);

        //4. 调用search()方法
        SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);

        //5. 处理结果
        //获得查询的命中的对象(包含了查询出来的数据)
        SearchHits hits = response.getHits();
        System.out.println("总记录数=" + hits.getTotalHits().value);
        List<Goods> goodsList = new ArrayList<Goods>();

        for (SearchHit hit : hits) {
            //一个hit里面就包含了一个document(直接把document通过字符串的方式获得)
            String data = hit.getSourceAsString();
            Goods goods = JSON.parseObject(data, Goods.class);
            goodsList.add(goods);

        }
        System.out.println(goodsList);
        client.close();

    }

    @Test
    //matchQuery会对查询条件进行分词,然后将分词后的查询条件和词条进行等值匹配,默认取并集（OR）
    public void fun05() throws IOException {
        //1. 创建SearchRequest对象
        SearchRequest searchRequest = new SearchRequest("goods");
        //2. 创建查询条件构建器SearchSourceBuilder
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

        //3. 构建查询条件对象QueryBuilder
        //TermQueryBuilder builder = QueryBuilders.termQuery("title", "华为");
        MatchQueryBuilder builder = QueryBuilders.matchQuery("title", "华为手机").operator(Operator.AND);

        searchSourceBuilder.query(builder);
        searchRequest.source(searchSourceBuilder);

        //4. 调用search()方法
        SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);

        //5. 处理结果
        //获得查询的命中的对象(包含了查询出来的数据)
        SearchHits hits = response.getHits();
        System.out.println("总记录数=" + hits.getTotalHits().value);
        List<Goods> goodsList = new ArrayList<Goods>();

        for (SearchHit hit : hits) {
            //一个hit里面就包含了一个document(直接把document通过字符串的方式获得)
            String data = hit.getSourceAsString();
            Goods goods = JSON.parseObject(data, Goods.class);
            goodsList.add(goods);

        }
        System.out.println(goodsList);
        client.close();

    }

    @Test
    /**
     * 模糊查询
     * + wildcard查询：会对查询条件进行分词。还可以使用通配符 ?（任意单个字符） 和 * （0个或多个字符）
     * + regexp查询：正则查询
     * + prefix查询：前缀查询
     */
    public void fun06() throws IOException {
        //1. 创建SearchRequest对象
        SearchRequest searchRequest = new SearchRequest("goods");
        //2. 创建查询条件构建器SearchSourceBuilder
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

        //3. 构建查询条件对象QueryBuilder
        // wildcard查询：会对查询条件进行分词。还可以使用通配符 ?（任意单个字符） 和 * （0个或多个字符）
        //WildcardQueryBuilder builder = QueryBuilders.wildcardQuery("title", "华*");

        //regexp查询：正则查询
        //RegexpQueryBuilder builder = QueryBuilders.regexpQuery("title", "n[0-9].+");

        //prefix查询：前缀查询
        PrefixQueryBuilder builder = QueryBuilders.prefixQuery("brandName", "华");

        searchSourceBuilder.query(builder);
        searchRequest.source(searchSourceBuilder);

        //4. 调用search()方法
        SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);

        //5. 处理结果
        //获得查询的命中的对象(包含了查询出来的数据)
        SearchHits hits = response.getHits();
        System.out.println("总记录数=" + hits.getTotalHits().value);
        List<Goods> goodsList = new ArrayList<Goods>();

        for (SearchHit hit : hits) {
            //一个hit里面就包含了一个document(直接把document通过字符串的方式获得)
            String data = hit.getSourceAsString();
            Goods goods = JSON.parseObject(data, Goods.class);
            goodsList.add(goods);

        }
        System.out.println(goodsList);
        client.close();

    }

    @Test
    //范围和排序 查询price在2000~3000之间的 并且按照价格降序 如果价格一样,根据saleNum降序
    public void fun07() throws IOException {
        //1. 创建SearchRequest对象
        SearchRequest searchRequest = new SearchRequest("goods");
        //2. 创建查询条件构建器SearchSourceBuilder
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

        //3. 构建查询条件对象QueryBuilder
        RangeQueryBuilder builder = QueryBuilders.rangeQuery("price").gte(2000).lte(3000);
        searchSourceBuilder.query(builder);

        //排序
        searchSourceBuilder.sort("price", SortOrder.DESC);

        searchSourceBuilder.from(0);
        searchSourceBuilder.size(100);

        searchRequest.source(searchSourceBuilder);

        //4. 调用search()方法
        SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);

        //5. 处理结果
        //获得查询的命中的对象(包含了查询出来的数据)
        SearchHits hits = response.getHits();
        System.out.println("总记录数=" + hits.getTotalHits().value);
        List<Goods> goodsList = new ArrayList<Goods>();

        for (SearchHit hit : hits) {
            //一个hit里面就包含了一个document(直接把document通过字符串的方式获得)
            String data = hit.getSourceAsString();
            Goods goods = JSON.parseObject(data, Goods.class);
            goodsList.add(goods);

        }
        System.out.println(goodsList);
        client.close();

    }

    @Test
    /**
     * boolQuery：
     * 1.对多个查询条件连接。
     * 2.连接方式：
     *  must（and）：条件必须成立
     *  must_not（not）：条件必须不成立
     *  should（or）：条件可以成立
     *  filter：条件必须成立，性能比must高。不会计算得分
     *
     *  查询华为的品牌的手机, 并且价格在2000~3000之间
     */
    public void fun08() throws IOException {
        //1. 创建SearchRequest对象
        SearchRequest searchRequest = new SearchRequest("goods");
        //2. 创建查询条件构建器SearchSourceBuilder
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

        //3. 构建查询条件对象QueryBuilder
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();

        //3.1 华为的品牌
        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("brandName", "华为");
        boolQueryBuilder.filter(termQueryBuilder);

        //3.2 商品名里面有手机
        MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("title", "手机");
        boolQueryBuilder.filter(matchQueryBuilder);

        //3.3 价格在2000~3000之间
        RangeQueryBuilder rangeQueryBuilder = QueryBuilders.rangeQuery("price").gte(2000).lte(3000);
        boolQueryBuilder.filter(rangeQueryBuilder);

        searchSourceBuilder.query(boolQueryBuilder);
        searchRequest.source(searchSourceBuilder);

        //4. 调用search()方法
        SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);

        //5. 处理结果
        //获得查询的命中的对象(包含了查询出来的数据)
        SearchHits hits = response.getHits();
        System.out.println("总记录数=" + hits.getTotalHits().value);
        List<Goods> goodsList = new ArrayList<Goods>();

        for (SearchHit hit : hits) {
            //一个hit里面就包含了一个document(直接把document通过字符串的方式获得)
            String data = hit.getSourceAsString();
            Goods goods = JSON.parseObject(data, Goods.class);
            goodsList.add(goods);

        }
        System.out.println(goodsList);
        client.close();

    }


    /**
     * 桶聚合: 查询title包含手机的数据的品牌列表
     * @throws IOException
     */
    @Test
    public void fun09() throws IOException {
        //1. 创建SearchRequest对象
        SearchRequest searchRequest = new SearchRequest("goods");
        //2. 创建查询条件构建器SearchSourceBuilder
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

        //3. 构建查询条件对象QueryBuilder

        //3.1 构建query
        MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("title", "手机");
        searchSourceBuilder.query(matchQueryBuilder);

        //3.2 构建聚合
        TermsAggregationBuilder aggregationBuilder = AggregationBuilders.terms("brand_names").field("brandName").size(1000);
        searchSourceBuilder.aggregation(aggregationBuilder);


        searchRequest.source(searchSourceBuilder);
        //4. 调用search()方法
        SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);

        //5. 处理结果
        //获得查询的命中的对象(包含了查询出来的数据)
        SearchHits hits = response.getHits();
        System.out.println("总记录数=" + hits.getTotalHits().value);
        List<Goods> goodsList = new ArrayList<Goods>();

        for (SearchHit hit : hits) {
            //一个hit里面就包含了一个document(直接把document通过字符串的方式获得)
            String data = hit.getSourceAsString();
            Goods goods = JSON.parseObject(data, Goods.class);
            goodsList.add(goods);

        }
        System.out.println(goodsList);

        //获得聚合的结果, 通过转成map获得
        Map<String, Aggregation> aggregationMap = response.getAggregations().asMap();
        //Aggregation aggregation = aggregationMap.get("brand_names");
        Terms terms = (Terms) aggregationMap.get("brand_names");
        List<? extends Terms.Bucket> buckets = terms.getBuckets();
        for (Terms.Bucket bucket : buckets) {
            System.out.println("品牌:" + bucket.getKey() + ",数量:" + bucket.getDocCount());
        }

        client.close();

    }

    /**
     * 高亮查询: 高亮查询电视
     * @throws IOException
     */
    @Test
    public void fun10() throws IOException {
        //1. 创建SearchRequest对象
        SearchRequest searchRequest = new SearchRequest("goods");
        //2. 创建查询条件构建器SearchSourceBuilder
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

        //3. 构建查询条件对象QueryBuilder
        //3.1 构建query
        MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("title", "电视");
        searchSourceBuilder.query(matchQueryBuilder);

        //3.2 构建高亮
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.field("title").preTags("<font color='red'>").postTags("</font>");
        searchSourceBuilder.highlighter(highlightBuilder);


        searchRequest.source(searchSourceBuilder);
        //4. 调用search()方法
        SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);

        //5. 处理结果
        //获得查询的命中的对象(包含了查询出来的数据)
        SearchHits hits = response.getHits();
        System.out.println("总记录数=" + hits.getTotalHits().value);
        List<Goods> goodsList = new ArrayList<Goods>();

        for (SearchHit hit : hits) {
            //一个hit里面就包含了一个document(直接把document通过字符串的方式获得)
            String data = hit.getSourceAsString();
            Goods goods = JSON.parseObject(data, Goods.class);

            //取出高亮
            Map<String, HighlightField> highlightFields = hit.getHighlightFields();
            HighlightField titleField = highlightFields.get("title");
            String title = titleField.getFragments()[0].toString(); //取到了高亮的文本
            goods.setTitle(title);

            goodsList.add(goods);

        }
        System.out.println(goodsList);

        client.close();

    }
}
