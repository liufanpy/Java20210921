```
#测试分词  DSL
POST _analyze
{
  "text":"我是程序员",
  "analyzer": "ik_smart"
}

#一,操作索引和映射
#需求: 创建person1索引, 创建映射, 设定name类型为text, age类型为Integer 
PUT person1
{
  "mappings": {
    "properties": {
      "name":{
        "type": "text"
      },
      "age":{
        "type": "integer"
      }
    }
  }
}


PUT person3


GET person1

#添加字段address
PUT person1/_mapping
{
  "properties":{
    "address":{
      "type":"text"
    }
  }
}

#二,操作文档
#1.新增(指定id)
POST person1/_doc/2
{
  "name":"ww",
  "age":20,
  "address":"深圳"
}

#新增(不指定id)
POST person1/_doc
{
  "name":"ls",
  "age":19,
  "address":"上海"
}


GET person1/_search

#2.删除文档(删除id为2的)
DELETE person1/_doc/2


#3.查询
#3.1 根据id查询
GET person1/_doc/1

#3.2 数据准备
#需求:  创建person2索引, 创建映射, 设定name类型为keyword age类型为Integer,addres类型为text 指定ik分词器

PUT person2
{
  "mappings": {
    "properties": {
      "name":{
        "type": "keyword"
      },
      "age":{
        "type": "integer"
      },
      "address":{
        "type": "text",
        "analyzer": "ik_smart"
      }
    }
  }
}

POST /person2/_doc/1
{
  "name":"张三",
  "age":18,
  "address":"北京海淀区"
}

POST /person2/_doc/2
{
  "name":"李四",
  "age":18,
  "address":"北京朝阳区"
}

POST /person2/_doc/3
{
  "name":"王五",
  "age":18,
  "address":"北京昌平区"
}




#3.3  term查询  对于用户输入的搜索词语不会进行分词
GET person2/_search
{
  "query": {
    "term": {
      "address": {
        "value": "北京昌平区"
      }
    }
  }
}



#3.4  match查询  对于用户输入的搜索词语会进行分词
GET person2/_search
{
  "query": {
    "match": {
      "address": "北京昌平"
    }
  }
}

POST _analyze
{
  "text":"北京昌平区",
  "analyzer": "ik_max_word"
}

GET itcast/_search
```

