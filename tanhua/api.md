
 <h1 class="curproject-name"> 探花交友 </h1> 





# 上报地理信息 位置
<a id=上报地理信息> </a>
### 基本信息

**Path：** /baidu/location

**Method：** POST

**接口描述：**


### 请求参数
**Headers**

| 参数名称  | 参数值  |  是否必须 | 示例  | 备注  |
| ------------ | ------------ | ------------ | ------------ | ------------ |
| Content-Type  |  application/json | 是  |   |   |
**Body**

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0-0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> latitude</span></td><td key=1><span>number</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">纬度</span></td><td key=5></td></tr><tr key=0-1><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> longitude</span></td><td key=1><span>number</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">经度</span></td><td key=5></td></tr><tr key=0-2><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> addrStr</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">位置描述</span></td><td key=5></td></tr>
               </tbody>
              </table>

### 返回数据

```javascript
{}
```

### 实现

a.根据userId查询地理位置表，看记录是否存在

b.如果不存在，保存地理位置

c.如果存在，更新地理位置

# 环信用户信息 用户

<a id=环信用户信息> </a>
### 基本信息

**Path：** /huanxin/user

**Method：** GET

**接口描述：**


### 请求参数

### 返回数据

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0-0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> username</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">用户名</span></td><td key=5><p key=2><span style="font-weight: '700'">枚举: </span><span>taoshiwei</span></p></td></tr><tr key=0-1><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> password</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">用户密码</span></td><td key=5><p key=2><span style="font-weight: '700'">枚举: </span><span>123456</span></p></td></tr>
               </tbody>
              </table>

# ·登陆 用户


## 登录第一步---手机号登录 （发送验证码）
<a id=登录第一步---手机号登录> </a>
### 基本信息

**Path：** /user/login

**Method：** POST

**接口描述：**


### 请求参数
**Headers**

| 参数名称  | 参数值  |  是否必须 | 示例  | 备注  |
| ------------ | ------------ | ------------ | ------------ | ------------ |
| Content-Type  |  application/json | 是  |   |   |
**Body**

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0-0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> phone</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">手机号</span></td><td key=5></td></tr>
               </tbody>
              </table>

### 返回数据

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody">
               </tbody>
              </table>
### 实现

a.根据手机号查询redis验证码是否失效

b.如果存在，直接返回错误信息，告知“验证码还未失效”

c.如果不存在，调用短信平台（阿里云）发送验证码短信

d.发送成功，将验证码写入redis

## 登录第二步---验证码校验

<a id=登录第二步---验证码校验> </a>
### 基本信息

**Path：** /user/loginVerification

**Method：** POST

**接口描述：**


### 请求参数
**Headers**

| 参数名称  | 参数值  |  是否必须 | 示例  | 备注  |
| ------------ | ------------ | ------------ | ------------ | ------------ |
| Content-Type  |  application/json | 是  |   |   |
**Body**

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0-0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> phone</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">手机号</span></td><td key=5></td></tr><tr key=0-1><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> verificationCode</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">验证码</span></td><td key=5></td></tr>
               </tbody>
              </table>

### 返回数据

```javascript
{
   "token": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1NjI4MjkzMzYsInVzZXJfaWQiOiIxIn0.Mbzn6LzsLrkVWEbhexR3lTYDZjxqIcqW11rJxDQ6Ewk",
   "isNew": true
}
```
### 实现

a.根据手机号作为key查询redis验证码是否存在

b.验证码不存在，说明验证码失效了

c.验证码存在，校验验证码

d.校验验证码失败了，说明验证码错误

f.验证码校验成功了，说明登录成功了

g.调用服务提供者：根据手机号码查询tb_user表 看用户是否存在

h.如果用户存在**，则生成token存入redis**

j.如果用户不存在，保存用户:服务提供者保存用户，**则生成token存入redis**

# ·注册 用户

## 新用户---1填写资料

<a id=新用户---1填写资料> </a>

### 基本信息

**Path：** /user/loginReginfo

**Method：** POST

**接口描述：**


### 请求参数

**Headers**

| 参数名称     | 参数值           | 是否必须 | 示例 | 备注 |
| ------------ | ---------------- | -------- | ---- | ---- |
| Content-Type | application/json | 是       |      |      |

**Body**

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0-0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> gender</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">性别 man woman</span></td><td key=5></td></tr><tr key=0-1><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> nickname</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">昵称</span></td><td key=5></td></tr><tr key=0-2><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> birthday</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">生日 年月日</span></td><td key=5></td></tr><tr key=0-3><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> city</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">城市</span></td><td key=5></td></tr><tr key=0-4><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> header</span></td><td key=1><span>string</span></td><td key=2>非必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">用户头像</span></td><td key=5></td></tr>
               </tbody>
              </table>


### 返回数据

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody">
               </tbody>
              </table>
### 实现

判断Token是否存在（是否登录了？）

调用服务提供者保存用户个人信息

## 新用户---2选取头像

<a id=新用户---2选取头像> </a>

### 基本信息

**Path：** /user/loginReginfo/head

**Method：** POST

**接口描述：**


### 请求参数

**Headers**

| 参数名称     | 参数值              | 是否必须 | 示例 | 备注 |
| ------------ | ------------------- | -------- | ---- | ---- |
| Content-Type | multipart/form-data | 是       |      |      |

**Body**

| 参数名称  | 参数类型 | 是否必须 | 示例 | 备注     |
| --------- | -------- | -------- | ---- | -------- |
| headPhoto | file     | 是       |      | 头像图片 |



### 返回数据

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody">
               </tbody>
              </table>
### 实现

a.判断Token是否存在（是否登录了？）

b校验token

c.人脸识别 调用百度云组件

d.上传头像 调用阿里云OSS组件

f.更新用户头像


# 1 交友（前端已联调）

## 探花-不喜欢

<a id=探花-不喜欢> </a>

### 基本信息

**Path：** /tanhua/:id/unlove

**Method：** GET

**接口描述：**


### 请求参数

**Headers**

| 参数名称      | 参数值                                                       | 是否必须 | 示例 | 备注 |
| ------------- | ------------------------------------------------------------ | -------- | ---- | ---- |
| Content-Type  | application/json                                             | 是       |      |      |
| Authorization | eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1NjI4MjkzMzYsInVzZXJfaWQiOiIxIn0.Mbzn6LzsLrkVWEbhexR3lTYDZjxqIcqW11rJxDQ6Ewk | 是       |      | 令牌 |

**路径参数**

| 参数名称 | 示例 | 备注     |
| -------- | ---- | -------- |
| id       | 1    | 用户编号 |

**Body**

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0-0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> id</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">编号</span></td><td key=5></td></tr>
               </tbody>
              </table>


### 返回数据

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody">
               </tbody>
              </table>


## 探花-喜欢

<a id=探花-喜欢> </a>

### 基本信息

**Path：** /tanhua/:id/love

**Method：** GET

**接口描述：**


### 请求参数

**Headers**

| 参数名称      | 参数值                                                       | 是否必须 | 示例 | 备注 |
| ------------- | ------------------------------------------------------------ | -------- | ---- | ---- |
| Content-Type  | application/json                                             | 是       |      |      |
| Authorization | eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1NjI4MjkzMzYsInVzZXJfaWQiOiIxIn0.Mbzn6LzsLrkVWEbhexR3lTYDZjxqIcqW11rJxDQ6Ewk | 是       |      | 令牌 |

**路径参数**

| 参数名称 | 示例 | 备注     |
| -------- | ---- | -------- |
| id       | 1    | 用户编号 |

**Body**

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0-0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> id</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">编号</span></td><td key=5></td></tr><tr key=0-1><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> isLike</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">1喜欢/0不喜欢</span></td><td key=5></td></tr>
               </tbody>
              </table>


### 返回数据

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody">
               </tbody>
              </table>


## 探花-左滑右滑

<a id=探花-左滑右滑> </a>

### 基本信息

**Path：** /tanhua/cards

**Method：** GET

**接口描述：**


### 请求参数

**Headers**

| 参数名称      | 参数值                                                       | 是否必须 | 示例 | 备注 |
| ------------- | ------------------------------------------------------------ | -------- | ---- | ---- |
| Content-Type  | application/json                                             | 是       |      |      |
| Authorization | eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1NjI4MjkzMzYsInVzZXJfaWQiOiIxIn0.Mbzn6LzsLrkVWEbhexR3lTYDZjxqIcqW11rJxDQ6Ewk | 是       |      | 令牌 |

### 返回数据

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> </span></td><td key=1><span>object []</span></td><td key=2>非必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5><p key=0><span style="font-weight: '700'">最小数量: </span><span>10</span></p><p key=1><span style="font-weight: '700'">元素是否都不同: </span><span>true</span></p><p key=2><span style="font-weight: '700'">最大数量: </span><span>10</span></p><p key=3><span style="font-weight: '700'">item 类型: </span><span>object</span></p></td></tr><tr key=0-0><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> id</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">编号</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>10000</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>1</span></p></td></tr><tr key=0-1><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> avatar</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">头像</span></td><td key=5><p key=2><span style="font-weight: '700'">枚举: </span><span>https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/tanhua/avatar_1.png,https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/tanhua/avatar_2.png,https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/tanhua/avatar_3.png,https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/tanhua/avatar_4.png</span></p></td></tr><tr key=0-2><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> nickname</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">昵称</span></td><td key=5><p key=2><span style="font-weight: '700'">枚举: </span><span>黑马小妹,米朵妹妹,致远哥哥</span></p></td></tr><tr key=0-3><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> gender</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">性别 man woman</span></td><td key=5><p key=2><span style="font-weight: '700'">枚举: </span><span>man,woman</span></p></td></tr><tr key=0-4><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> age</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">年龄</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>30</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>20</span></p></td></tr><tr key=0-5><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> tags</span></td><td key=1><span>string []</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">标签</span></td><td key=5><p key=0><span style="font-weight: '700'">最小数量: </span><span>1</span></p><p key=1><span style="font-weight: '700'">元素是否都不同: </span><span>true</span></p><p key=2><span style="font-weight: '700'">最大数量: </span><span>3</span></p><p key=3><span style="font-weight: '700'">item 类型: </span><span>string</span></p></td></tr><tr key=array-2><td key=0><span style="padding-left: 40px"><span style="color: #8c8a8a">├─</span> </span></td><td key=1><span></span></td><td key=2>非必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr>
               </tbody>
              </table>
## 桃花传音-发送语音（学生实战）

<a id=桃花传音-发送语音（学生实战）> </a>

### 基本信息

**Path：** /peachblossom

**Method：** POST

**接口描述：**


### 请求参数

**Headers**

| 参数名称      | 参数值                                                       | 是否必须 | 示例 | 备注 |
| ------------- | ------------------------------------------------------------ | -------- | ---- | ---- |
| Content-Type  | multipart/form-data                                          | 是       |      |      |
| Authorization | eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1NjI4MjkzMzYsInVzZXJfaWQiOiIxIn0.Mbzn6LzsLrkVWEbhexR3lTYDZjxqIcqW11rJxDQ6Ewk | 是       |      | 令牌 |

**Body**

| 参数名称  | 参数类型 | 是否必须 | 示例 | 备注 |
| --------- | -------- | -------- | ---- | ---- |
| soundFile | file     | 是       |      |      |



### 返回数据

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody">
               </tbody>
              </table>



## 桃花传音-接收语音（学生实战）

<a id=桃花传音-接收语音（学生实战）> </a>

### 基本信息

**Path：** /peachblossom

**Method：** GET

**接口描述：**


### 请求参数

**Headers**

| 参数名称      | 参数值                                                       | 是否必须 | 示例 | 备注 |
| ------------- | ------------------------------------------------------------ | -------- | ---- | ---- |
| Content-Type  | application/json                                             | 是       |      |      |
| Authorization | eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1NjI4MjkzMzYsInVzZXJfaWQiOiIxIn0.Mbzn6LzsLrkVWEbhexR3lTYDZjxqIcqW11rJxDQ6Ewk | 是       |      | 令牌 |

### 返回数据

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0-0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> id</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">用户id</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>10000</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>1</span></p></td></tr><tr key=0-1><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> avatar</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">头像</span></td><td key=5><p key=2><span style="font-weight: '700'">枚举: </span><span>https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/tanhua/avatar_1.png,https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/tanhua/avatar_2.png,https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/tanhua/avatar_3.png,https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/tanhua/avatar_4.png</span></p></td></tr><tr key=0-2><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> nickname</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">昵称</span></td><td key=5><p key=2><span style="font-weight: '700'">枚举: </span><span>相思落无声</span></p></td></tr><tr key=0-3><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> gender</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">性别 man woman</span></td><td key=5><p key=2><span style="font-weight: '700'">枚举: </span><span>woman,man</span></p></td></tr><tr key=0-4><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> age</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">年龄</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>40</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>20</span></p></td></tr><tr key=0-5><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> soundUrl</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">语音地址</span></td><td key=5><p key=2><span style="font-weight: '700'">枚举: </span><span>https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/peach_blossom/eabf404f623db20344011507026cb53e.m4a</span></p></td></tr><tr key=0-6><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> remainingTimes</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">剩余次数</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>10</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>0</span></p></td></tr>
               </tbody>
              </table>



## 测灵魂-提交问卷（学生实战）

<a id=测灵魂-提交问卷（学生实战）> </a>

### 基本信息

**Path：** /testSoul

**Method：** POST

**接口描述：**


### 请求参数

**Headers**

| 参数名称      | 参数值                                                       | 是否必须 | 示例 | 备注 |
| ------------- | ------------------------------------------------------------ | -------- | ---- | ---- |
| Content-Type  | application/json                                             | 是       |      |      |
| Authorization | eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1NjI4MjkzMzYsInVzZXJfaWQiOiIxIn0.Mbzn6LzsLrkVWEbhexR3lTYDZjxqIcqW11rJxDQ6Ewk | 是       |      | 令牌 |

**Body**

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0-0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> answers</span></td><td key=1><span>object []</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">作答</span></td><td key=5><p key=3><span style="font-weight: '700'">item 类型: </span><span>object</span></p></td></tr><tr key=0-0-0><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> questionId</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">试题编号</span></td><td key=5></td></tr><tr key=0-0-1><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> optionId</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">选项编号</span></td><td key=5></td></tr>
               </tbody>
              </table>



### 返回数据

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> </span></td><td key=1><span>string</span></td><td key=2>非必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">报告id</span></td><td key=5><p key=5><span style="font-weight: '700'">mock: </span><span>@id</span></p></td></tr>
               </tbody>
              </table>



## 测灵魂-查看结果（学生实战）

<a id=测灵魂-查看结果（学生实战）> </a>

### 基本信息

**Path：** /testSoul/report/:id

**Method：** GET

**接口描述：**


### 请求参数

**Headers**

| 参数名称      | 参数值                                                       | 是否必须 | 示例 | 备注 |
| ------------- | ------------------------------------------------------------ | -------- | ---- | ---- |
| Content-Type  | application/json                                             | 是       |      |      |
| Authorization | eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1NjI4MjkzMzYsInVzZXJfaWQiOiIxIn0.Mbzn6LzsLrkVWEbhexR3lTYDZjxqIcqW11rJxDQ6Ewk | 是       |      | 令牌 |

**路径参数**

| 参数名称 | 示例 | 备注   |
| -------- | ---- | ------ |
| id       |      | 报告id |

**Body**

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody">
               </tbody>
              </table>



### 返回数据

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0-0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> conclusion</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">鉴定结果</span></td><td key=5><p key=2><span style="font-weight: '700'">枚举: </span><span>猫头鹰：他们的共同特质为重计划、条理、细节精准。在行为上，表现出喜欢理性思考与分析、较重视制度、结构、规范。他们注重执行游戏规则、循规蹈矩、巨细靡遗、重视品质、敬业负责。,白兔型：平易近人、敦厚可靠、避免冲突与不具批判性。在行为上，表现出不慌不忙、冷静自持的态度。他们注重稳定与中长程规划，现实生活中，常会反思自省并以和谐为中心，即使面对困境，亦能泰然自若，从容应付。,狐狸型 ：人际关系能力极强，擅长以口语表达感受而引起共鸣，很会激励并带动气氛。他们喜欢跟别人互动，重视群体的归属感，基本上是比较「人际导向」。由于他们富同理心并乐于分享，具有很好的亲和力，在服务业、销售业、传播业及公共关系等领域中，狐狸型的领导者都有很杰出的表现。,狮子型：性格为充满自信、竞争心强、主动且企图心强烈，是个有决断力的领导者。一般而言，狮子型的人胸怀大志，勇于冒险，看问题能够直指核心，并对目标全力以赴。他们在领导风格及决策上，强调权威与果断，擅长危机处理，此种性格最适合开创性与改革性的工作。</span></p></td></tr><tr key=0-1><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> cover</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">鉴定图片</span></td><td key=5><p key=2><span style="font-weight: '700'">枚举: </span><span>https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/test_soul/owl.png,https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/test_soul/rabbit.png,https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/test_soul/fox.png,https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/test_soul/lion.png</span></p></td></tr><tr key=0-2><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> dimensions</span></td><td key=1><span>object []</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">维度</span></td><td key=5><p key=0><span style="font-weight: '700'">最小数量: </span><span>4</span></p><p key=2><span style="font-weight: '700'">最大数量: </span><span>4</span></p><p key=3><span style="font-weight: '700'">item 类型: </span><span>object</span></p></td></tr><tr key=0-2-0><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> key</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">维度项（外向，判断，抽象，理性）</span></td><td key=5><p key=2><span style="font-weight: '700'">枚举: </span><span>外向,判断,抽象,理性</span></p></td></tr><tr key=0-2-1><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> value</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">维度值</span></td><td key=5><p key=2><span style="font-weight: '700'">枚举: </span><span>80%,70%,90%,60%</span></p></td></tr><tr key=0-3><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> similarYou</span></td><td key=1><span>object []</span></td><td key=2>非必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">与你相似</span></td><td key=5><p key=0><span style="font-weight: '700'">最小数量: </span><span>10</span></p><p key=1><span style="font-weight: '700'">元素是否都不同: </span><span>true</span></p><p key=2><span style="font-weight: '700'">最大数量: </span><span>10</span></p><p key=3><span style="font-weight: '700'">item 类型: </span><span>object</span></p></td></tr><tr key=0-3-0><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> id</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">用户编号</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>10000</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>1</span></p><p key=5><span style="font-weight: '700'">mock: </span><span>@id</span></p></td></tr><tr key=0-3-1><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> avatar</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">头像</span></td><td key=5><p key=2><span style="font-weight: '700'">枚举: </span><span>https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/tanhua/avatar_1.png,https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/tanhua/avatar_2.png,https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/tanhua/avatar_3.png,https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/tanhua/avatar_4.png</span></p></td></tr>
               </tbody>
              </table>



## 测灵魂-问卷列表（学生实战）

<a id=测灵魂-问卷列表（学生实战）> </a>

### 基本信息

**Path：** /testSoul

**Method：** GET

**接口描述：**


### 请求参数

**Headers**

| 参数名称      | 参数值                                                       | 是否必须 | 示例 | 备注 |
| ------------- | ------------------------------------------------------------ | -------- | ---- | ---- |
| Content-Type  | application/json                                             | 是       |      |      |
| Authorization | eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1NjI4MjkzMzYsInVzZXJfaWQiOiIxIn0.Mbzn6LzsLrkVWEbhexR3lTYDZjxqIcqW11rJxDQ6Ewk | 是       |      | 令牌 |

### 返回数据

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> </span></td><td key=1><span>object []</span></td><td key=2>非必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5><p key=0><span style="font-weight: '700'">最小数量: </span><span>3</span></p><p key=1><span style="font-weight: '700'">元素是否都不同: </span><span>true</span></p><p key=2><span style="font-weight: '700'">最大数量: </span><span>3</span></p><p key=3><span style="font-weight: '700'">item 类型: </span><span>object</span></p></td></tr><tr key=0-0><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> id</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">问卷编号</span></td><td key=5><p key=5><span style="font-weight: '700'">mock: </span><span>@id</span></p></td></tr><tr key=0-1><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> name</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">问卷名称</span></td><td key=5><p key=2><span style="font-weight: '700'">枚举: </span><span>初级灵魂题,中级灵魂题,高级灵魂题</span></p></td></tr><tr key=0-2><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> cover</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">封面</span></td><td key=5><p key=2><span style="font-weight: '700'">枚举: </span><span>https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/test_soul/qn_cover_01.png,https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/test_soul/qn_cover_02.png,https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/test_soul/qn_cover_03.png</span></p></td></tr><tr key=0-3><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> level</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">级别</span></td><td key=5><p key=2><span style="font-weight: '700'">枚举: </span><span>初级,中级,高级</span></p></td></tr><tr key=0-4><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> star</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">星别（例如：2颗星，3颗星，5颗星）</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>5</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>2</span></p></td></tr><tr key=0-5><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> questions</span></td><td key=1><span>object []</span></td><td key=2>非必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">试题</span></td><td key=5><p key=0><span style="font-weight: '700'">最小数量: </span><span>10</span></p><p key=1><span style="font-weight: '700'">元素是否都不同: </span><span>true</span></p><p key=2><span style="font-weight: '700'">最大数量: </span><span>10</span></p><p key=3><span style="font-weight: '700'">item 类型: </span><span>object</span></p></td></tr><tr key=0-5-0><td key=0><span style="padding-left: 40px"><span style="color: #8c8a8a">├─</span> id</span></td><td key=1><span>string</span></td><td key=2>非必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">试题编号</span></td><td key=5><p key=5><span style="font-weight: '700'">mock: </span><span>@id</span></p></td></tr><tr key=0-5-1><td key=0><span style="padding-left: 40px"><span style="color: #8c8a8a">├─</span> question</span></td><td key=1><span>string</span></td><td key=2>非必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">题目</span></td><td key=5><p key=2><span style="font-weight: '700'">枚举: </span><span>假如你在你房间墙壁上发现一个了小孔，你希望从这个小孔中看如下到什么样的场景？</span></p></td></tr><tr key=0-5-2><td key=0><span style="padding-left: 40px"><span style="color: #8c8a8a">├─</span> options</span></td><td key=1><span>object []</span></td><td key=2>非必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">选项</span></td><td key=5><p key=0><span style="font-weight: '700'">最小数量: </span><span>7</span></p><p key=1><span style="font-weight: '700'">元素是否都不同: </span><span>true</span></p><p key=2><span style="font-weight: '700'">最大数量: </span><span>7</span></p><p key=3><span style="font-weight: '700'">item 类型: </span><span>object</span></p></td></tr><tr key=0-5-2-0><td key=0><span style="padding-left: 60px"><span style="color: #8c8a8a">├─</span> id</span></td><td key=1><span>string</span></td><td key=2>非必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">选项编号</span></td><td key=5><p key=5><span style="font-weight: '700'">mock: </span><span>@id</span></p></td></tr><tr key=0-5-2-1><td key=0><span style="padding-left: 60px"><span style="color: #8c8a8a">├─</span> option</span></td><td key=1><span>string</span></td><td key=2>非必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">选项</span></td><td key=5><p key=2><span style="font-weight: '700'">枚举: </span><span>正在拥抱的一对恋人,一家人正其乐融融地吃晚餐</span></p></td></tr><tr key=0-6><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> isLock</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">是否锁住（0解锁，1锁住）</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>1</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>0</span></p></td></tr><tr key=0-7><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> reportId</span></td><td key=1><span>string</span></td><td key=2>非必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">最新报告id</span></td><td key=5><p key=5><span style="font-weight: '700'">mock: </span><span>@id</span></p></td></tr>
               </tbody>
              </table>



# 搜附近

<a id=搜附近> </a>

### 基本信息

**Path：** /tanhua/search

**Method：** GET

**接口描述：**


### 请求参数
**Headers**

| 参数名称  | 参数值  |  是否必须 | 示例  | 备注  |
| ------------ | ------------ | ------------ | ------------ | ------------ |
| Content-Type  |  application/json | 是  |   |   |
| Authorization  |  eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1NjI4MjkzMzYsInVzZXJfaWQiOiIxIn0.Mbzn6LzsLrkVWEbhexR3lTYDZjxqIcqW11rJxDQ6Ewk | 是  |   |  令牌 |
**Query**

| 参数名称  |  是否必须 | 示例  | 备注  |
| ------------ | ------------ | ------------ | ------------ |
| gender | 是  |  man |  性别 man woman |
| distance | 是  |  500 |  距离（m） |

### 返回数据

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> </span></td><td key=1><span>object []</span></td><td key=2>非必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5><p key=0><span style="font-weight: '700'">最小数量: </span><span>20</span></p><p key=2><span style="font-weight: '700'">最大数量: </span><span>20</span></p><p key=3><span style="font-weight: '700'">item 类型: </span><span>object</span></p></td></tr><tr key=0-0><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> userId</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">用户Id</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>10000</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>1</span></p></td></tr><tr key=0-1><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> avatar</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">头像</span></td><td key=5><p key=2><span style="font-weight: '700'">枚举: </span><span>https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/tanhua/avatar_1.png,https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/tanhua/avatar_2.png,https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/tanhua/avatar_3.png,https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/tanhua/avatar_4.png</span></p></td></tr><tr key=0-2><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> nickname</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">昵称</span></td><td key=5><p key=2><span style="font-weight: '700'">枚举: </span><span>下了夏天,花花花世界,谁动了我的冬天,梦里的画,雨落的花</span></p></td></tr>
               </tbody>
              </table>
### 实现

a.调用搜附近服务方法 返回List<T>

​	**a.根据当前用户id查询当前用户位置**

**b.根据当前用户位置 与 距离 通过Mongodb的API搜附近用户列表数据**

**b.将自己的用户id过滤     将性别不符合要求过滤**

c.根据userId查询UserInfo

d.封装VO返回

# 谁看过我

<a id=谁看过我> </a>

### 基本信息

**Path：** /movements/visitors

**Method：** GET

**接口描述：**


### 请求参数

**Headers**

| 参数名称      | 参数值                                                       | 是否必须 | 示例 | 备注 |
| ------------- | ------------------------------------------------------------ | -------- | ---- | ---- |
| Content-Type  | application/json                                             | 是       |      |      |
| Authorization | eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1NjI4MjkzMzYsInVzZXJfaWQiOiIxIn0.Mbzn6LzsLrkVWEbhexR3lTYDZjxqIcqW11rJxDQ6Ewk | 是       |      | 令牌 |

### 返回数据

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> </span></td><td key=1><span>object []</span></td><td key=2>非必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5><p key=0><span style="font-weight: '700'">最小数量: </span><span>0</span></p><p key=1><span style="font-weight: '700'">元素是否都不同: </span><span>true</span></p><p key=2><span style="font-weight: '700'">最大数量: </span><span>4</span></p><p key=3><span style="font-weight: '700'">item 类型: </span><span>object</span></p></td></tr><tr key=0-0><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> id</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">用户id</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>10000</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>1</span></p></td></tr><tr key=0-1><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> avatar</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">头像</span></td><td key=5><p key=2><span style="font-weight: '700'">枚举: </span><span>https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/tanhua/avatar_1.png,https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/tanhua/avatar_2.png,https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/tanhua/avatar_3.png,https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/tanhua/avatar_4.png</span></p></td></tr><tr key=0-2><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> nickname</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">昵称</span></td><td key=5><p key=2><span style="font-weight: '700'">枚举: </span><span>黑马小妹,米朵妹妹,致远哥哥</span></p></td></tr><tr key=0-3><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> gender</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">性别 man woman</span></td><td key=5><p key=2><span style="font-weight: '700'">枚举: </span><span>man,woman</span></p></td></tr><tr key=0-4><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> age</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">年龄</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>30</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>20</span></p></td></tr><tr key=0-5><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> tags</span></td><td key=1><span>string []</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">标签</span></td><td key=5><p key=0><span style="font-weight: '700'">最小数量: </span><span>1</span></p><p key=1><span style="font-weight: '700'">元素是否都不同: </span><span>true</span></p><p key=2><span style="font-weight: '700'">最大数量: </span><span>3</span></p><p key=3><span style="font-weight: '700'">item 类型: </span><span>string</span></p></td></tr><tr key=array-14><td key=0><span style="padding-left: 40px"><span style="color: #8c8a8a">├─</span> </span></td><td key=1><span></span></td><td key=2>非必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr><tr key=0-6><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> fateValue</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">缘分值</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>100</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>80</span></p></td></tr>
               </tbody>
              </table>
### 实现

a.如果没有上次登录时间，根据当前登录用户id 查询访客记录（默认查询5条）

b.如果有上次登录时间，根据当前登录用户id 与  date大于上次登录时间  查询访客记录（默认查询5条）

c.根据visitorUserId:来访的用户id 查询userInfo

d.封装Vo返回


# 今日佳人

<a id=今日佳人> </a>

### 基本信息

**Path：** /tanhua/todayBest

**Method：** GET

**接口描述：**


### 请求参数
**Headers**

| 参数名称  | 参数值  |  是否必须 | 示例  | 备注  |
| ------------ | ------------ | ------------ | ------------ | ------------ |
| Content-Type  |  application/json | 是  |   |   |
| Authorization  |  eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1NjI4MjkzMzYsInVzZXJfaWQiOiIxIn0.Mbzn6LzsLrkVWEbhexR3lTYDZjxqIcqW11rJxDQ6Ewk | 是  |   |  令牌 |

### 返回数据

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0-0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> id</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">编号</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>10000</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>1</span></p></td></tr><tr key=0-1><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> avatar</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">头像</span></td><td key=5><p key=2><span style="font-weight: '700'">枚举: </span><span>https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/tanhua/avatar_1.png,https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/tanhua/avatar_2.png,https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/tanhua/avatar_3.png,https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/tanhua/avatar_4.png</span></p></td></tr><tr key=0-2><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> nickname</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">昵称</span></td><td key=5><p key=2><span style="font-weight: '700'">枚举: </span><span>黑马小妹,米朵妹妹,致远哥哥</span></p></td></tr><tr key=0-3><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> gender</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">性别 man woman</span></td><td key=5><p key=2><span style="font-weight: '700'">枚举: </span><span>man,woman</span></p></td></tr><tr key=0-4><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> age</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">年龄</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>30</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>20</span></p></td></tr><tr key=0-5><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> tags</span></td><td key=1><span>string []</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">标签</span></td><td key=5><p key=0><span style="font-weight: '700'">最小数量: </span><span>1</span></p><p key=1><span style="font-weight: '700'">元素是否都不同: </span><span>true</span></p><p key=2><span style="font-weight: '700'">最大数量: </span><span>3</span></p><p key=3><span style="font-weight: '700'">item 类型: </span><span>string</span></p></td></tr><tr key=array-1><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> </span></td><td key=1><span></span></td><td key=2>非必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr><tr key=0-6><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> fateValue</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">缘分值</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>100</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>80</span></p></td></tr>
               </tbody>
              </table>
### 实现

a.根据当前用户id查询跟当前用户最匹配的今日佳人用户对象RecommendUser(UserId Score)

b.根据今日佳人UserId查询tb_userInfo表得到UserInfo对象

c.将UserInfo与Score 封装Vo返回

# 推荐用户

<a id=推荐朋友> </a>

### 基本信息

**Path：** /tanhua/recommendation

**Method：** GET

**接口描述：**


### 请求参数

**Headers**

| 参数名称      | 参数值                                                       | 是否必须 | 示例 | 备注 |
| ------------- | ------------------------------------------------------------ | -------- | ---- | ---- |
| Content-Type  | application/json                                             | 是       |      |      |
| Authorization | eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1NjI4MjkzMzYsInVzZXJfaWQiOiIxIn0.Mbzn6LzsLrkVWEbhexR3lTYDZjxqIcqW11rJxDQ6Ewk | 是       |      | 令牌 |

**Query**

| 参数名称  | 是否必须 | 示例     | 备注                                               |
| --------- | -------- | -------- | -------------------------------------------------- |
| page      | 是       | 1        | 当前页数                                           |
| pagesize  | 是       | 10       | 页尺寸                                             |
| gender    | 是       | man      | 性别 man woman                                     |
| lastLogin | 是       | 1天      | 近期登陆时间（15分钟, 1小时, 1天）                 |
| age       | 是       | 30       | 年龄（岁）                                         |
| city      | 是       | 北京城区 | 居住地                                             |
| education | 是       | 本科     | 学历（博士, 研究生, 本科, 大专, 高中及以下, 不限） |

### 返回数据

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0-0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> counts</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">总记录数</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>5000</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>100</span></p></td></tr><tr key=0-1><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> pagesize</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">页大小</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>50</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>5</span></p></td></tr><tr key=0-2><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> pages</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">总页数</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>100</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>1</span></p></td></tr><tr key=0-3><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> page</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">当前页码</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>100</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>1</span></p></td></tr><tr key=0-4><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> items</span></td><td key=1><span>object []</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">列表</span></td><td key=5><p key=0><span style="font-weight: '700'">最小数量: </span><span>10</span></p><p key=1><span style="font-weight: '700'">元素是否都不同: </span><span>true</span></p><p key=2><span style="font-weight: '700'">最大数量: </span><span>10</span></p><p key=3><span style="font-weight: '700'">item 类型: </span><span>object</span></p></td></tr><tr key=0-4-0><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> id</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">编号</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>10000</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>1</span></p></td></tr><tr key=0-4-1><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> avatar</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">头像</span></td><td key=5><p key=2><span style="font-weight: '700'">枚举: </span><span>https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/tanhua/avatar_1.png,https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/tanhua/avatar_2.png,https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/tanhua/avatar_3.png,https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/tanhua/avatar_4.png</span></p></td></tr><tr key=0-4-2><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> nickname</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">昵称</span></td><td key=5><p key=2><span style="font-weight: '700'">枚举: </span><span>黑马小妹,米朵妹妹,致远哥哥</span></p></td></tr><tr key=0-4-3><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> gender</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">性别 man woman</span></td><td key=5><p key=2><span style="font-weight: '700'">枚举: </span><span>man,woman</span></p></td></tr><tr key=0-4-4><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> age</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">年龄</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>30</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>20</span></p></td></tr><tr key=0-4-5><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> tags</span></td><td key=1><span>string []</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">标签</span></td><td key=5><p key=0><span style="font-weight: '700'">最小数量: </span><span>1</span></p><p key=1><span style="font-weight: '700'">元素是否都不同: </span><span>true</span></p><p key=2><span style="font-weight: '700'">最大数量: </span><span>3</span></p><p key=3><span style="font-weight: '700'">item 类型: </span><span>string</span></p></td></tr><tr key=array-3><td key=0><span style="padding-left: 40px"><span style="color: #8c8a8a">├─</span> </span></td><td key=1><span></span></td><td key=2>非必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr><tr key=0-4-6><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> fateValue</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">缘分值</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>100</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>80</span></p></td></tr>
               </tbody>
              </table>
### 实现

a.根据用户id分页查询推荐用户列表

b.如果推荐用户列表数据为空，造10条假数据

c.根据推荐用户ids查询用户信息

d.封装VO，返回给app

# 佳人信息

<a id=佳人信息> </a>

### 基本信息

**Path：** /tanhua/:id/personalInfo

**Method：** GET

**接口描述：**


### 请求参数

**Headers**

| 参数名称      | 参数值                                                       | 是否必须 | 示例 | 备注 |
| ------------- | ------------------------------------------------------------ | -------- | ---- | ---- |
| Content-Type  | application/json                                             | 是       |      |      |
| Authorization | eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1NjI4MjkzMzYsInVzZXJfaWQiOiIxIn0.Mbzn6LzsLrkVWEbhexR3lTYDZjxqIcqW11rJxDQ6Ewk | 是       |      | 令牌 |

**路径参数**

| 参数名称 | 示例 | 备注   |
| -------- | ---- | ------ |
| id       | 1    | 用户id |

### 返回数据

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0-0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> id</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">编号</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>10000</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>1</span></p></td></tr><tr key=0-1><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> avatar</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">头像</span></td><td key=5><p key=2><span style="font-weight: '700'">枚举: </span><span>https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/tanhua/avatar_1.png,https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/tanhua/avatar_2.png,https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/tanhua/avatar_3.png,https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/tanhua/avatar_4.png</span></p></td></tr><tr key=0-2><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> nickname</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">昵称</span></td><td key=5><p key=2><span style="font-weight: '700'">枚举: </span><span>相思落无声</span></p></td></tr><tr key=0-3><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> gender</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">性别 man woman</span></td><td key=5><p key=2><span style="font-weight: '700'">枚举: </span><span>woman</span></p></td></tr><tr key=0-4><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> age</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">年龄</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>25</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>25</span></p></td></tr><tr key=0-5><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> tags</span></td><td key=1><span>string []</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">标签</span></td><td key=5><p key=0><span style="font-weight: '700'">最小数量: </span><span>1</span></p><p key=1><span style="font-weight: '700'">元素是否都不同: </span><span>true</span></p><p key=2><span style="font-weight: '700'">最大数量: </span><span>3</span></p><p key=3><span style="font-weight: '700'">item 类型: </span><span>string</span></p></td></tr><tr key=array-4><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> </span></td><td key=1><span></span></td><td key=2>非必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr><tr key=0-6><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> fateValue</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">缘分值</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>100</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>80</span></p></td></tr>
               </tbody>
              </table>
### 实现

a.根据传入的佳人用户id 查询tb_user_info 得到userInfo

b.根据佳人用户id和登陆用户id查询recommend_user得到缘分值

# 陌生人问题-查询

<a id=查询陌生人问题> </a>

### 基本信息

**Path：** /tanhua/strangerQuestions

**Method：** GET

**接口描述：**


### 请求参数

**Headers**

| 参数名称      | 参数值                                                       | 是否必须 | 示例 | 备注 |
| ------------- | ------------------------------------------------------------ | -------- | ---- | ---- |
| Content-Type  | application/json                                             | 是       |      |      |
| Authorization | eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1NjI4MjkzMzYsInVzZXJfaWQiOiIxIn0.Mbzn6LzsLrkVWEbhexR3lTYDZjxqIcqW11rJxDQ6Ewk | 是       |      | 令牌 |

**Query**

| 参数名称 | 是否必须 | 示例 | 备注   |
| -------- | -------- | ---- | ------ |
| userId   | 是       | 1    | 用户id |

**Body**

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0-0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> content</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">问题</span></td><td key=5></td></tr>
               </tbody>
              </table>



### 返回数据

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> </span></td><td key=1><span>string</span></td><td key=2>非必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">陌生人问题</span></td><td key=5><p key=2><span style="font-weight: '700'">枚举: </span><span>你喜欢去看蔚蓝的大海还是去爬巍峨的高山？</span></p></td></tr>
               </tbody>
              </table>



### 实现

a.根据传入的佳人用户id 查询tb_question 得到 陌生人问题


# ·陌生人问题回复

<a id=回复陌生人问题> </a>
### 基本信息

**Path：** /tanhua/strangerQuestions

**Method：** POST

**接口描述：**


### 请求参数
**Headers**

| 参数名称  | 参数值  |  是否必须 | 示例  | 备注  |
| ------------ | ------------ | ------------ | ------------ | ------------ |
| Content-Type  |  application/json | 是  |   |   |
| Authorization  |  eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1NjI4MjkzMzYsInVzZXJfaWQiOiIxIn0.Mbzn6LzsLrkVWEbhexR3lTYDZjxqIcqW11rJxDQ6Ewk | 是  |   |  令牌 |
**Body**

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0-0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> userId</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">用户id</span></td><td key=5></td></tr><tr key=0-1><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> reply</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">回复</span></td><td key=5></td></tr>
               </tbody>
              </table>

### 返回数据

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody">
               </tbody>
              </table>


### 实现

a.userId 通过UserHolder.getUserId()

b.根据当前用户id查询userInfo得到昵称

c.根据传入的佳人用户id 查询tb_question 得到佳人问题

d.reply:回复的内容（传入的参数）

f.将以上数据map（json格式）调用环信云sendMsg(接收消息的用户id,msg消息内容)

# 2 圈子（前端已联调）

## 推荐动态

<a id=推荐动态> </a>
### 基本信息

**Path：** /movements/recommend

**Method：** GET

**接口描述：**


### 请求参数
**Headers**

| 参数名称  | 参数值  |  是否必须 | 示例  | 备注  |
| ------------ | ------------ | ------------ | ------------ | ------------ |
| Content-Type  |  application/json | 是  |   |   |
| Authorization  |  eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1NjI4MjkzMzYsInVzZXJfaWQiOiIxIn0.Mbzn6LzsLrkVWEbhexR3lTYDZjxqIcqW11rJxDQ6Ewk | 是  |   |  令牌 |
**Query**

| 参数名称  |  是否必须 | 示例  | 备注  |
| ------------ | ------------ | ------------ | ------------ |
| page | 是  |  1 |  当前页数 |
| pagesize | 是  |  10 |  页尺寸 |

### 返回数据

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0-0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> counts</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">总记录数</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>5000</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>100</span></p></td></tr><tr key=0-1><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> pagesize</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">页大小</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>50</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>5</span></p></td></tr><tr key=0-2><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> pages</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">总页数</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>100</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>1</span></p></td></tr><tr key=0-3><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> page</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">当前页码</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>100</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>1</span></p></td></tr><tr key=0-4><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> items</span></td><td key=1><span>object []</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">列表</span></td><td key=5><p key=0><span style="font-weight: '700'">最小数量: </span><span>10</span></p><p key=1><span style="font-weight: '700'">元素是否都不同: </span><span>true</span></p><p key=2><span style="font-weight: '700'">最大数量: </span><span>10</span></p><p key=3><span style="font-weight: '700'">item 类型: </span><span>object</span></p></td></tr><tr key=0-4-0><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> id</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">动态id</span></td><td key=5></td></tr><tr key=0-4-1><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> userId</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">用户id</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>10000</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>1</span></p></td></tr><tr key=0-4-2><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> avatar</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">头像</span></td><td key=5><p key=2><span style="font-weight: '700'">枚举: </span><span>https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/tanhua/avatar_1.png,https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/tanhua/avatar_2.png,https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/tanhua/avatar_3.png,https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/tanhua/avatar_4.png</span></p></td></tr><tr key=0-4-3><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> nickname</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">昵称</span></td><td key=5><p key=2><span style="font-weight: '700'">枚举: </span><span>黑马小妹,米朵妹妹,致远哥哥</span></p></td></tr><tr key=0-4-4><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> gender</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">性别 man woman</span></td><td key=5><p key=2><span style="font-weight: '700'">枚举: </span><span>man,woman</span></p></td></tr><tr key=0-4-5><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> age</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">年龄</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>30</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>20</span></p></td></tr><tr key=0-4-6><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> tags</span></td><td key=1><span>string []</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">标签</span></td><td key=5><p key=0><span style="font-weight: '700'">最小数量: </span><span>1</span></p><p key=1><span style="font-weight: '700'">元素是否都不同: </span><span>true</span></p><p key=2><span style="font-weight: '700'">最大数量: </span><span>3</span></p><p key=3><span style="font-weight: '700'">item 类型: </span><span>string</span></p></td></tr><tr key=array-5><td key=0><span style="padding-left: 40px"><span style="color: #8c8a8a">├─</span> </span></td><td key=1><span></span></td><td key=2>非必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr><tr key=0-4-7><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> textContent</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">文字动态</span></td><td key=5><p key=2><span style="font-weight: '700'">枚举: </span><span>下属去看脱发……请病假合适吗……,有家的地方，没有工作，有工作的地方没有家，他乡容不下的灵魂，故乡安置不了的肉身，谁能留下我这尊大可爱~</span></p></td></tr><tr key=0-4-8><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> imageContent</span></td><td key=1><span>string []</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">图片动态</span></td><td key=5><p key=0><span style="font-weight: '700'">最小数量: </span><span>1</span></p><p key=1><span style="font-weight: '700'">元素是否都不同: </span><span>true</span></p><p key=2><span style="font-weight: '700'">最大数量: </span><span>6</span></p><p key=3><span style="font-weight: '700'">item 类型: </span><span>string</span></p></td></tr><tr key=array-6><td key=0><span style="padding-left: 40px"><span style="color: #8c8a8a">├─</span> </span></td><td key=1><span></span></td><td key=2>非必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr><tr key=0-4-9><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> distance</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">距离</span></td><td key=5><p key=2><span style="font-weight: '700'">枚举: </span><span>1.2公里</span></p></td></tr><tr key=0-4-10><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> createDate</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">发布时间</span></td><td key=5><p key=2><span style="font-weight: '700'">枚举: </span><span>10分钟前</span></p></td></tr><tr key=0-4-11><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> likeCount</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">点赞数</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>100</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>0</span></p></td></tr><tr key=0-4-12><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> commentCount</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">评论数</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>100</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>0</span></p></td></tr><tr key=0-4-13><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> loveCount</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">喜欢数</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>100</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>0</span></p></td></tr><tr key=0-4-14><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> hasLiked</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">是否点赞（1是，0否）</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>1</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>0</span></p></td></tr><tr key=0-4-15><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> hasLoved</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">是否喜欢（1是，0否）</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>1</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>0</span></p></td></tr>
               </tbody>
              </table>
### 实现

1. 推荐动态表（根据当前登录用户userId查询推荐动态表 得到发布id）
2. 发布表
3. 用户信息表

## 好友动态

<a id=好友动态> </a>

### 基本信息

**Path：** /movements

**Method：** GET

**接口描述：**


### 请求参数

**Headers**

| 参数名称      | 参数值                                                       | 是否必须 | 示例 | 备注 |
| ------------- | ------------------------------------------------------------ | -------- | ---- | ---- |
| Content-Type  | application/json                                             | 是       |      |      |
| Authorization | eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1NjI4MjkzMzYsInVzZXJfaWQiOiIxIn0.Mbzn6LzsLrkVWEbhexR3lTYDZjxqIcqW11rJxDQ6Ewk | 是       |      | 令牌 |

**Query**

| 参数名称 | 是否必须 | 示例 | 备注     |
| -------- | -------- | ---- | -------- |
| page     | 是       | 1    | 当前页数 |
| pagesize | 是       | 10   | 页尺寸   |

### 返回数据

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0-0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> counts</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">总记录数</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>5000</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>100</span></p></td></tr><tr key=0-1><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> pagesize</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">页大小</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>50</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>5</span></p></td></tr><tr key=0-2><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> pages</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">总页数</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>100</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>1</span></p></td></tr><tr key=0-3><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> page</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">当前页码</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>100</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>1</span></p></td></tr><tr key=0-4><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> items</span></td><td key=1><span>object []</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">列表</span></td><td key=5><p key=0><span style="font-weight: '700'">最小数量: </span><span>10</span></p><p key=1><span style="font-weight: '700'">元素是否都不同: </span><span>true</span></p><p key=2><span style="font-weight: '700'">最大数量: </span><span>10</span></p><p key=3><span style="font-weight: '700'">item 类型: </span><span>object</span></p></td></tr><tr key=0-4-0><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> id</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">动态id</span></td><td key=5></td></tr><tr key=0-4-1><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> userId</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">用户id</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>10000</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>1</span></p></td></tr><tr key=0-4-2><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> avatar</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">头像</span></td><td key=5><p key=2><span style="font-weight: '700'">枚举: </span><span>https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/tanhua/avatar_1.png,https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/tanhua/avatar_2.png,https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/tanhua/avatar_3.png,https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/tanhua/avatar_4.png</span></p></td></tr><tr key=0-4-3><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> nickname</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">昵称</span></td><td key=5><p key=2><span style="font-weight: '700'">枚举: </span><span>黑马小妹,米朵妹妹,致远哥哥</span></p></td></tr><tr key=0-4-4><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> gender</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">性别 man woman</span></td><td key=5><p key=2><span style="font-weight: '700'">枚举: </span><span>man,woman</span></p></td></tr><tr key=0-4-5><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> age</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">年龄</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>30</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>20</span></p></td></tr><tr key=0-4-6><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> tags</span></td><td key=1><span>string []</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">标签</span></td><td key=5><p key=0><span style="font-weight: '700'">最小数量: </span><span>1</span></p><p key=1><span style="font-weight: '700'">元素是否都不同: </span><span>true</span></p><p key=2><span style="font-weight: '700'">最大数量: </span><span>3</span></p><p key=3><span style="font-weight: '700'">item 类型: </span><span>string</span></p></td></tr><tr key=array-9><td key=0><span style="padding-left: 40px"><span style="color: #8c8a8a">├─</span> </span></td><td key=1><span></span></td><td key=2>非必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr><tr key=0-4-7><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> textContent</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">文字动态</span></td><td key=5><p key=2><span style="font-weight: '700'">枚举: </span><span>下属去看脱发……请病假合适吗……,有家的地方，没有工作，有工作的地方没有家，他乡容不下的灵魂，故乡安置不了的肉身，谁能留下我这尊大可爱~</span></p></td></tr><tr key=0-4-8><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> imageContent</span></td><td key=1><span>string []</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">图片动态</span></td><td key=5><p key=0><span style="font-weight: '700'">最小数量: </span><span>1</span></p><p key=1><span style="font-weight: '700'">元素是否都不同: </span><span>true</span></p><p key=2><span style="font-weight: '700'">最大数量: </span><span>6</span></p><p key=3><span style="font-weight: '700'">item 类型: </span><span>string</span></p></td></tr><tr key=array-10><td key=0><span style="padding-left: 40px"><span style="color: #8c8a8a">├─</span> </span></td><td key=1><span></span></td><td key=2>非必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr><tr key=0-4-9><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> distance</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">距离</span></td><td key=5><p key=2><span style="font-weight: '700'">枚举: </span><span>1.2公里</span></p></td></tr><tr key=0-4-10><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> createDate</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">发布时间</span></td><td key=5><p key=2><span style="font-weight: '700'">枚举: </span><span>10分钟前</span></p></td></tr><tr key=0-4-11><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> likeCount</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">点赞数</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>100</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>0</span></p></td></tr><tr key=0-4-12><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> commentCount</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">评论数</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>100</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>0</span></p></td></tr><tr key=0-4-13><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> loveCount</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">喜欢数</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>100</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>0</span></p></td></tr><tr key=0-4-14><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> hasLiked</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">是否点赞（1是，0否）</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>1</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>0</span></p></td></tr><tr key=0-4-15><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> hasLoved</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">是否喜欢（1是，0否）</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>1</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>0</span></p></td></tr>
               </tbody>
              </table>
### 实现

1. 根据当前用户id 查询自己的时间线表（好友时间线表） 得到发布id
2. 根据发布id 查询发布表 得到动态数据
3. 根据发布动态用户id 查询用户信息表


## 用户动态

<a id=用户动态> </a>

### 基本信息

**Path：** /movements/all

**Method：** GET

**接口描述：**


### 请求参数

**Headers**

| 参数名称      | 参数值                                                       | 是否必须 | 示例 | 备注 |
| ------------- | ------------------------------------------------------------ | -------- | ---- | ---- |
| Content-Type  | application/json                                             | 是       |      |      |
| Authorization | eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1NjI4MjkzMzYsInVzZXJfaWQiOiIxIn0.Mbzn6LzsLrkVWEbhexR3lTYDZjxqIcqW11rJxDQ6Ewk | 是       |      | 令牌 |

**Query**

| 参数名称 | 是否必须 | 示例 | 备注     |
| -------- | -------- | ---- | -------- |
| page     | 是       | 1    | 当前页数 |
| pagesize | 是       | 10   | 页尺寸   |
| userId   | 是       | 1    | 用户id   |

### 返回数据

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0-0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> counts</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">总记录数</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>5000</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>100</span></p></td></tr><tr key=0-1><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> pagesize</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">页大小</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>50</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>5</span></p></td></tr><tr key=0-2><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> pages</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">总页数</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>100</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>1</span></p></td></tr><tr key=0-3><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> page</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">当前页码</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>100</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>1</span></p></td></tr><tr key=0-4><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> items</span></td><td key=1><span>object []</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">列表</span></td><td key=5><p key=0><span style="font-weight: '700'">最小数量: </span><span>10</span></p><p key=1><span style="font-weight: '700'">元素是否都不同: </span><span>true</span></p><p key=2><span style="font-weight: '700'">最大数量: </span><span>10</span></p><p key=3><span style="font-weight: '700'">item 类型: </span><span>object</span></p></td></tr><tr key=0-4-0><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> id</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">动态id</span></td><td key=5></td></tr><tr key=0-4-1><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> userId</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">用户id</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>10000</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>1</span></p></td></tr><tr key=0-4-2><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> avatar</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">头像</span></td><td key=5><p key=2><span style="font-weight: '700'">枚举: </span><span>https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/tanhua/avatar_1.png</span></p></td></tr><tr key=0-4-3><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> nickname</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">昵称</span></td><td key=5><p key=2><span style="font-weight: '700'">枚举: </span><span>相思落无声</span></p></td></tr><tr key=0-4-4><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> gender</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">性别 man woman</span></td><td key=5><p key=2><span style="font-weight: '700'">枚举: </span><span>woman</span></p></td></tr><tr key=0-4-5><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> age</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">年龄</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>25</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>25</span></p></td></tr><tr key=0-4-6><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> tags</span></td><td key=1><span>string []</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">标签</span></td><td key=5><p key=0><span style="font-weight: '700'">最小数量: </span><span>1</span></p><p key=1><span style="font-weight: '700'">元素是否都不同: </span><span>true</span></p><p key=2><span style="font-weight: '700'">最大数量: </span><span>3</span></p><p key=3><span style="font-weight: '700'">item 类型: </span><span>string</span></p></td></tr><tr key=array-11><td key=0><span style="padding-left: 40px"><span style="color: #8c8a8a">├─</span> </span></td><td key=1><span></span></td><td key=2>非必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr><tr key=0-4-7><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> textContent</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">文字动态</span></td><td key=5><p key=2><span style="font-weight: '700'">枚举: </span><span>下属去看脱发……请病假合适吗……,有家的地方，没有工作，有工作的地方没有家，他乡容不下的灵魂，故乡安置不了的肉身，谁能留下我这尊大可爱~</span></p></td></tr><tr key=0-4-8><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> imageContent</span></td><td key=1><span>string []</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">图片动态</span></td><td key=5><p key=0><span style="font-weight: '700'">最小数量: </span><span>1</span></p><p key=1><span style="font-weight: '700'">元素是否都不同: </span><span>true</span></p><p key=2><span style="font-weight: '700'">最大数量: </span><span>6</span></p><p key=3><span style="font-weight: '700'">item 类型: </span><span>string</span></p></td></tr><tr key=array-12><td key=0><span style="padding-left: 40px"><span style="color: #8c8a8a">├─</span> </span></td><td key=1><span></span></td><td key=2>非必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr><tr key=0-4-9><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> distance</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">距离</span></td><td key=5><p key=2><span style="font-weight: '700'">枚举: </span><span>1.2公里</span></p></td></tr><tr key=0-4-10><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> createDate</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">发布时间</span></td><td key=5><p key=2><span style="font-weight: '700'">枚举: </span><span>10分钟前</span></p></td></tr><tr key=0-4-11><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> likeCount</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">点赞数</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>100</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>0</span></p></td></tr><tr key=0-4-12><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> commentCount</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">评论数</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>100</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>0</span></p></td></tr><tr key=0-4-13><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> loveCount</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">喜欢数</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>100</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>0</span></p></td></tr><tr key=0-4-14><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> hasLiked</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">是否点赞（1是，0否）</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>1</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>0</span></p></td></tr><tr key=0-4-15><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> hasLoved</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">是否喜欢（1是，0否）</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>1</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>0</span></p></td></tr>
               </tbody>
              </table>

## 单条动态

<a id=单条动态> </a>

### 基本信息

**Path：** /movements/:id

**Method：** GET

**接口描述：**


### 请求参数

**Headers**

| 参数名称      | 参数值                                                       | 是否必须 | 示例 | 备注 |
| ------------- | ------------------------------------------------------------ | -------- | ---- | ---- |
| Content-Type  | application/json                                             | 是       |      |      |
| Authorization | eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1NjI4MjkzMzYsInVzZXJfaWQiOiIxIn0.Mbzn6LzsLrkVWEbhexR3lTYDZjxqIcqW11rJxDQ6Ewk | 是       |      | 令牌 |

**路径参数**

| 参数名称 | 示例 | 备注   |
| -------- | ---- | ------ |
| id       |      | 动态id |

### 返回数据

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0-0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> id</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">动态id</span></td><td key=5></td></tr><tr key=0-1><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> userId</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">用户id</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>10000</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>1</span></p></td></tr><tr key=0-2><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> avatar</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">头像</span></td><td key=5><p key=2><span style="font-weight: '700'">枚举: </span><span>https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/tanhua/avatar_1.png,https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/tanhua/avatar_2.png,https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/tanhua/avatar_3.png,https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/tanhua/avatar_4.png</span></p></td></tr><tr key=0-3><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> nickname</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">昵称</span></td><td key=5><p key=2><span style="font-weight: '700'">枚举: </span><span>黑马小妹,米朵妹妹,致远哥哥</span></p></td></tr><tr key=0-4><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> gender</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">性别 man woman</span></td><td key=5><p key=2><span style="font-weight: '700'">枚举: </span><span>man,woman</span></p></td></tr><tr key=0-5><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> age</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">年龄</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>30</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>20</span></p></td></tr><tr key=0-6><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> tags</span></td><td key=1><span>string []</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">标签</span></td><td key=5><p key=0><span style="font-weight: '700'">最小数量: </span><span>1</span></p><p key=1><span style="font-weight: '700'">元素是否都不同: </span><span>true</span></p><p key=2><span style="font-weight: '700'">最大数量: </span><span>3</span></p><p key=3><span style="font-weight: '700'">item 类型: </span><span>string</span></p></td></tr><tr key=array-7><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> </span></td><td key=1><span></span></td><td key=2>非必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr><tr key=0-7><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> textContent</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">文字动态</span></td><td key=5><p key=2><span style="font-weight: '700'">枚举: </span><span>下属去看脱发……请病假合适吗……,有家的地方，没有工作，有工作的地方没有家，他乡容不下的灵魂，故乡安置不了的肉身，谁能留下我这尊大可爱~</span></p></td></tr><tr key=0-8><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> imageContent</span></td><td key=1><span>string []</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">图片动态</span></td><td key=5><p key=0><span style="font-weight: '700'">最小数量: </span><span>1</span></p><p key=1><span style="font-weight: '700'">元素是否都不同: </span><span>true</span></p><p key=2><span style="font-weight: '700'">最大数量: </span><span>6</span></p><p key=3><span style="font-weight: '700'">item 类型: </span><span>string</span></p></td></tr><tr key=array-8><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> </span></td><td key=1><span></span></td><td key=2>非必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr><tr key=0-9><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> distance</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">距离</span></td><td key=5><p key=2><span style="font-weight: '700'">枚举: </span><span>1.2公里</span></p></td></tr><tr key=0-10><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> createDate</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">发布时间</span></td><td key=5><p key=2><span style="font-weight: '700'">枚举: </span><span>10分钟前</span></p></td></tr><tr key=0-11><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> likeCount</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">点赞数</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>100</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>0</span></p></td></tr><tr key=0-12><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> commentCount</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">评论数</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>100</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>0</span></p></td></tr><tr key=0-13><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> loveCount</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">喜欢数</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>100</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>0</span></p></td></tr>
               </tbody>
              </table>
### 实现

a.调用服务提供者 根据发布id查询发布表获取动态数据

b.根据发布表中发布用户id 查询用户信息表 得到用户信息

c.将动态数据与用户信息封装Vo返回


## ·动态-发布

<a id=动态-发布> </a>

### 基本信息

**Path：** /movements

**Method：** POST

**接口描述：**


### 请求参数

**Headers**

| 参数名称      | 参数值                                                       | 是否必须 | 示例 | 备注 |
| ------------- | ------------------------------------------------------------ | -------- | ---- | ---- |
| Content-Type  | multipart/form-data                                          | 是       |      |      |
| Authorization | eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1NjI4MjkzMzYsInVzZXJfaWQiOiIxIn0.Mbzn6LzsLrkVWEbhexR3lTYDZjxqIcqW11rJxDQ6Ewk | 是       |      | 令牌 |

**Body**

| 参数名称     | 参数类型 | 是否必须 | 示例 | 备注                     |
| ------------ | -------- | -------- | ---- | ------------------------ |
| textContent  | text     | 是       |      | 文字动态                 |
| imageContent | file     | 是       |      | 图片动态（支持多张图片） |
| location     | text     | 是       |      | 位置                     |
| longitude    | text     | 是       |      | 经度                     |
| latitude     | text     | 是       |      | 纬度                     |



### 返回数据

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody">
               </tbody>
              </table>
### 实现

1. 往动态表插入动态数据quanzi_publish
2. 往相册表插入我的动态记录（动态id 或 发布id）
3. 先查询好友表获取好友ids
4. 再往好友时间线表插入动态记录（动态id 或 发布id）


## 动态-点赞

<a id=动态-点赞> </a>

### 基本信息

**Path：** /movements/:id/like

**Method：** GET

**接口描述：**


### 请求参数

**Headers**

| 参数名称      | 参数值                                                       | 是否必须 | 示例 | 备注 |
| ------------- | ------------------------------------------------------------ | -------- | ---- | ---- |
| Content-Type  | application/json                                             | 是       |      |      |
| Authorization | eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1NjI4MjkzMzYsInVzZXJfaWQiOiIxIn0.Mbzn6LzsLrkVWEbhexR3lTYDZjxqIcqW11rJxDQ6Ewk | 是       |      | 令牌 |

**路径参数**

| 参数名称 | 示例 | 备注   |
| -------- | ---- | ------ |
| id       |      | 动态id |

**Body**

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0-0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> id</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">编号</span></td><td key=5></td></tr><tr key=0-1><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> isLike</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">1喜欢/0不喜欢</span></td><td key=5></td></tr>
               </tbody>
              </table>


### 返回数据

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> </span></td><td key=1><span>integer</span></td><td key=2>非必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">点赞数</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>100</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>0</span></p></td></tr>
               </tbody>
              </table>
### 实现

1. 点赞记录写入评论表
2. 点赞记录写入redis
3. 动态表中点赞记录数➕1
4. 查询点赞数并返回

## 动态-取消点赞

<a id=动态-取消点赞> </a>

### 基本信息

**Path：** /movements/:id/dislike

**Method：** GET

**接口描述：**


### 请求参数

**Headers**

| 参数名称      | 参数值                                                       | 是否必须 | 示例 | 备注 |
| ------------- | ------------------------------------------------------------ | -------- | ---- | ---- |
| Content-Type  | application/json                                             | 是       |      |      |
| Authorization | eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1NjI4MjkzMzYsInVzZXJfaWQiOiIxIn0.Mbzn6LzsLrkVWEbhexR3lTYDZjxqIcqW11rJxDQ6Ewk | 是       |      | 令牌 |

**路径参数**

| 参数名称 | 示例 | 备注   |
| -------- | ---- | ------ |
| id       |      | 动态id |

**Body**

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0-0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> id</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">编号</span></td><td key=5></td></tr><tr key=0-1><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> isLike</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">1喜欢/0不喜欢</span></td><td key=5></td></tr>
               </tbody>
              </table>


### 返回数据

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> </span></td><td key=1><span>integer</span></td><td key=2>非必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">点赞数</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>100</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>0</span></p></td></tr>
               </tbody>
              </table>




## 动态-喜欢
<a id=动态-喜欢> </a>
### 基本信息

**Path：** /movements/:id/love

**Method：** GET

**接口描述：**


### 请求参数
**Headers**

| 参数名称  | 参数值  |  是否必须 | 示例  | 备注  |
| ------------ | ------------ | ------------ | ------------ | ------------ |
| Content-Type  |  application/json | 是  |   |   |
| Authorization  |  eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1NjI4MjkzMzYsInVzZXJfaWQiOiIxIn0.Mbzn6LzsLrkVWEbhexR3lTYDZjxqIcqW11rJxDQ6Ewk | 是  |   |  令牌 |
**路径参数**

| 参数名称 | 示例  | 备注  |
| ------------ | ------------ | ------------ |
| id |   |  动态id |
**Body**

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0-0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> id</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">编号</span></td><td key=5></td></tr><tr key=0-1><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> isLike</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">1喜欢/0不喜欢</span></td><td key=5></td></tr>
               </tbody>
              </table>

### 返回数据

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> </span></td><td key=1><span>integer</span></td><td key=2>非必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">喜欢数</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>100</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>0</span></p></td></tr>
               </tbody>
              </table>
## 动态-取消喜欢

<a id=动态-取消喜欢> </a>

### 基本信息

**Path：** /movements/:id/unlove

**Method：** GET

**接口描述：**


### 请求参数

**Headers**

| 参数名称      | 参数值                                                       | 是否必须 | 示例 | 备注 |
| ------------- | ------------------------------------------------------------ | -------- | ---- | ---- |
| Content-Type  | application/json                                             | 是       |      |      |
| Authorization | eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1NjI4MjkzMzYsInVzZXJfaWQiOiIxIn0.Mbzn6LzsLrkVWEbhexR3lTYDZjxqIcqW11rJxDQ6Ewk | 是       |      | 令牌 |

**路径参数**

| 参数名称 | 示例 | 备注   |
| -------- | ---- | ------ |
| id       |      | 动态id |

**Body**

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0-0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> id</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">编号</span></td><td key=5></td></tr><tr key=0-1><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> isLike</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">1喜欢/0不喜欢</span></td><td key=5></td></tr>
               </tbody>
              </table>


### 返回数据

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> </span></td><td key=1><span>integer</span></td><td key=2>非必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">喜欢数</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>100</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>0</span></p></td></tr>
               </tbody>
              </table>


## 评论-点赞

<a id=评论-点赞> </a>

### 基本信息

**Path：** /comments/:id/like

**Method：** GET

**接口描述：**


### 请求参数

**Headers**

| 参数名称      | 参数值                                                       | 是否必须 | 示例 | 备注 |
| ------------- | ------------------------------------------------------------ | -------- | ---- | ---- |
| Content-Type  | application/json                                             | 是       |      |      |
| Authorization | eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1NjI4MjkzMzYsInVzZXJfaWQiOiIxIn0.Mbzn6LzsLrkVWEbhexR3lTYDZjxqIcqW11rJxDQ6Ewk | 是       |      | 令牌 |

**路径参数**

| 参数名称 | 示例 | 备注   |
| -------- | ---- | ------ |
| id       |      | 评论id |

**Body**

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0-0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> id</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">编号</span></td><td key=5></td></tr><tr key=0-1><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> isLike</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">1喜欢/0不喜欢</span></td><td key=5></td></tr>
               </tbody>
              </table>


### 返回数据

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> </span></td><td key=1><span>integer</span></td><td key=2>非必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">点赞数</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>100</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>0</span></p></td></tr>
               </tbody>
              </table>



## 评论-取消点赞
<a id=评论-取消点赞> </a>
### 基本信息

**Path：** /comments/:id/dislike

**Method：** GET

**接口描述：**


### 请求参数
**Headers**

| 参数名称  | 参数值  |  是否必须 | 示例  | 备注  |
| ------------ | ------------ | ------------ | ------------ | ------------ |
| Content-Type  |  application/json | 是  |   |   |
| Authorization  |  eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1NjI4MjkzMzYsInVzZXJfaWQiOiIxIn0.Mbzn6LzsLrkVWEbhexR3lTYDZjxqIcqW11rJxDQ6Ewk | 是  |   |  令牌 |
**路径参数**

| 参数名称 | 示例  | 备注  |
| ------------ | ------------ | ------------ |
| id |   |  评论id |
**Body**

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0-0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> id</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">编号</span></td><td key=5></td></tr><tr key=0-1><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> isLike</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">1喜欢/0不喜欢</span></td><td key=5></td></tr>
               </tbody>
              </table>

### 返回数据

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> </span></td><td key=1><span>integer</span></td><td key=2>非必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">点赞数</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>100</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>0</span></p></td></tr>
               </tbody>
              </table>

## 评论-提交
<a id=评论-提交> </a>
### 基本信息

**Path：** /comments

**Method：** POST

**接口描述：**


### 请求参数
**Headers**

| 参数名称  | 参数值  |  是否必须 | 示例  | 备注  |
| ------------ | ------------ | ------------ | ------------ | ------------ |
| Content-Type  |  application/json | 是  |   |   |
| Authorization  |  eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1NjI4MjkzMzYsInVzZXJfaWQiOiIxIn0.Mbzn6LzsLrkVWEbhexR3lTYDZjxqIcqW11rJxDQ6Ewk | 是  |   |  令牌 |
**Body**

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0-0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> movementId</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">动态编号</span></td><td key=5></td></tr><tr key=0-1><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> comment</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">评论</span></td><td key=5></td></tr>
               </tbody>
              </table>

### 返回数据

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody">
               </tbody>
              </table>

## 评论列表
<a id=评论列表> </a>
### 基本信息

**Path：** /comments

**Method：** GET

**接口描述：**


### 请求参数
**Headers**

| 参数名称  | 参数值  |  是否必须 | 示例  | 备注  |
| ------------ | ------------ | ------------ | ------------ | ------------ |
| Content-Type  |  application/json | 是  |   |   |
| Authorization  |  eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1NjI4MjkzMzYsInVzZXJfaWQiOiIxIn0.Mbzn6LzsLrkVWEbhexR3lTYDZjxqIcqW11rJxDQ6Ewk | 是  |   |  令牌 |
**Query**

| 参数名称  |  是否必须 | 示例  | 备注  |
| ------------ | ------------ | ------------ | ------------ |
| movementId | 是  |   |  动态编号 |
| page | 是  |  1 |  当前页数 |
| pagesize | 是  |  10 |  页尺寸 |

### 返回数据

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0-0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> counts</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">总记录数</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>5000</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>100</span></p></td></tr><tr key=0-1><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> pagesize</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">页大小</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>50</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>5</span></p></td></tr><tr key=0-2><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> pages</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">总页数</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>100</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>1</span></p></td></tr><tr key=0-3><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> page</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">当前页码</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>100</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>1</span></p></td></tr><tr key=0-4><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> items</span></td><td key=1><span>object []</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">列表</span></td><td key=5><p key=0><span style="font-weight: '700'">最小数量: </span><span>1</span></p><p key=1><span style="font-weight: '700'">元素是否都不同: </span><span>true</span></p><p key=2><span style="font-weight: '700'">最大数量: </span><span>10</span></p><p key=3><span style="font-weight: '700'">item 类型: </span><span>object</span></p></td></tr><tr key=0-4-0><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> id</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">评论id</span></td><td key=5></td></tr><tr key=0-4-1><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> avatar</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">头像</span></td><td key=5><p key=2><span style="font-weight: '700'">枚举: </span><span>https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/tanhua/avatar_1.png,https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/tanhua/avatar_2.png,https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/tanhua/avatar_3.png,https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/tanhua/avatar_4.png</span></p></td></tr><tr key=0-4-2><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> nickname</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">昵称</span></td><td key=5><p key=2><span style="font-weight: '700'">枚举: </span><span>春花多时有,清水河上住</span></p></td></tr><tr key=0-4-3><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> content</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">评论</span></td><td key=5><p key=2><span style="font-weight: '700'">枚举: </span><span>最美的风景配最美的人~,灯泡</span></p></td></tr><tr key=0-4-4><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> createDate</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">评论时间</span></td><td key=5><p key=2><span style="font-weight: '700'">枚举: </span><span>08:27</span></p></td></tr><tr key=0-4-5><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> likeCount</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">点赞数</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>100</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>0</span></p></td></tr><tr key=0-4-6><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> hasLiked</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">是否点赞（1是，0否）</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>1</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>0</span></p></td></tr>
               </tbody>
              </table>
## 是否喜欢（新增接口）

<a id=是否喜欢（新增接口）> </a>

### 基本信息

**Path：** /users/:uid/alreadyLove

**Method：** GET

**接口描述：**


### 请求参数

**Headers**

| 参数名称      | 参数值                                                       | 是否必须 | 示例 | 备注 |
| ------------- | ------------------------------------------------------------ | -------- | ---- | ---- |
| Content-Type  | application/json                                             | 是       |      |      |
| Authorization | eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1NjI4MjkzMzYsInVzZXJfaWQiOiIxIn0.Mbzn6LzsLrkVWEbhexR3lTYDZjxqIcqW11rJxDQ6Ewk | 是       |      | 令牌 |

**路径参数**

| 参数名称 | 示例 | 备注 |
| -------- | ---- | ---- |
| uid      |      |      |

### 返回数据

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> </span></td><td key=1><span>boolean</span></td><td key=2>非必须</td><td key=3>true</td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr>
               </tbody>
              </table>


## 缘分值（前端暂未联调）

<a id=缘分值（前端暂未联调）> </a>

### 基本信息

**Path：** /users/:id/fateValue

**Method：** GET

**接口描述：**


### 请求参数

**Headers**

| 参数名称      | 参数值                                                       | 是否必须 | 示例 | 备注 |
| ------------- | ------------------------------------------------------------ | -------- | ---- | ---- |
| Content-Type  | application/json                                             | 是       |      |      |
| Authorization | eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1NjI4MjkzMzYsInVzZXJfaWQiOiIxIn0.Mbzn6LzsLrkVWEbhexR3lTYDZjxqIcqW11rJxDQ6Ewk | 是       |      | 令牌 |

**路径参数**

| 参数名称 | 示例 | 备注 |
| -------- | ---- | ---- |
| id       |      |      |

### 返回数据

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0-0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> fateValue</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">缘分值</span></td><td key=5></td></tr><tr key=0-1><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> tags</span></td><td key=1><span>string []</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">标签</span></td><td key=5><p key=3><span style="font-weight: '700'">item 类型: </span><span>string</span></p></td></tr><tr key=array-13><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> </span></td><td key=1><span></span></td><td key=2>非必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr><tr key=0-2><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> myAvatar</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">我的头像</span></td><td key=5></td></tr><tr key=0-3><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> friendAvatar</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">好友头像</span></td><td key=5></td></tr>
               </tbody>
              </table>



# 3 消息（前端已联调）

## 公告列表
<a id=公告列表> </a>
### 基本信息

**Path：** /messages/announcements

**Method：** GET

**接口描述：**


### 请求参数
**Headers**

| 参数名称  | 参数值  |  是否必须 | 示例  | 备注  |
| ------------ | ------------ | ------------ | ------------ | ------------ |
| Content-Type  |  application/json | 是  |   |   |
| Authorization  |  eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1NjI4MjkzMzYsInVzZXJfaWQiOiIxIn0.Mbzn6LzsLrkVWEbhexR3lTYDZjxqIcqW11rJxDQ6Ewk | 是  |   |  令牌 |
**Query**

| 参数名称  |  是否必须 | 示例  | 备注  |
| ------------ | ------------ | ------------ | ------------ |
| page | 是  |  1 |  当前页数 |
| pagesize | 是  |  10 |  页尺寸 |

### 返回数据

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0-0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> counts</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">总记录数</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>5000</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>100</span></p></td></tr><tr key=0-1><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> pagesize</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">页大小</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>50</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>5</span></p></td></tr><tr key=0-2><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> pages</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">总页数</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>100</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>1</span></p></td></tr><tr key=0-3><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> page</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">当前页码</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>100</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>1</span></p></td></tr><tr key=0-4><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> items</span></td><td key=1><span>object []</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">列表</span></td><td key=5><p key=0><span style="font-weight: '700'">最小数量: </span><span>10</span></p><p key=1><span style="font-weight: '700'">元素是否都不同: </span><span>true</span></p><p key=2><span style="font-weight: '700'">最大数量: </span><span>10</span></p><p key=3><span style="font-weight: '700'">item 类型: </span><span>object</span></p></td></tr><tr key=0-4-0><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> id</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">编号</span></td><td key=5></td></tr><tr key=0-4-1><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> title</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">标题</span></td><td key=5><p key=2><span style="font-weight: '700'">枚举: </span><span>探花新版本上线发布啦～,盛夏high趴开始了，赶紧来报名吧！</span></p></td></tr><tr key=0-4-2><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> description</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">描述</span></td><td key=5><p key=2><span style="font-weight: '700'">枚举: </span><span>探花App2019年7月23日起在苹果商店…,浓情夏日，清爽一聚，探花将吧大家聚…</span></p></td></tr><tr key=0-4-3><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> createDate</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">发布时间</span></td><td key=5><p key=2><span style="font-weight: '700'">枚举: </span><span>2019-09-08 10:07</span></p><p key=4><span style="font-weight: '700'">format: </span><span>date-time</span></p></td></tr>
               </tbody>
              </table>

## 喜欢列表
<a id=喜欢列表> </a>
### 基本信息

**Path：** /messages/loves

**Method：** GET

**接口描述：**


### 请求参数
**Headers**

| 参数名称  | 参数值  |  是否必须 | 示例  | 备注  |
| ------------ | ------------ | ------------ | ------------ | ------------ |
| Content-Type  |  application/json | 是  |   |   |
| Authorization  |  eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1NjI4MjkzMzYsInVzZXJfaWQiOiIxIn0.Mbzn6LzsLrkVWEbhexR3lTYDZjxqIcqW11rJxDQ6Ewk | 是  |   |  令牌 |
**Query**

| 参数名称  |  是否必须 | 示例  | 备注  |
| ------------ | ------------ | ------------ | ------------ |
| page | 是  |  1 |  当前页数 |
| pagesize | 是  |  10 |  页尺寸 |

### 返回数据

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0-0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> counts</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">总记录数</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>5000</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>100</span></p></td></tr><tr key=0-1><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> pagesize</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">页大小</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>50</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>5</span></p></td></tr><tr key=0-2><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> pages</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">总页数</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>100</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>1</span></p></td></tr><tr key=0-3><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> page</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">当前页码</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>100</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>1</span></p></td></tr><tr key=0-4><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> items</span></td><td key=1><span>object []</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">列表</span></td><td key=5><p key=0><span style="font-weight: '700'">最小数量: </span><span>10</span></p><p key=1><span style="font-weight: '700'">元素是否都不同: </span><span>true</span></p><p key=2><span style="font-weight: '700'">最大数量: </span><span>10</span></p><p key=3><span style="font-weight: '700'">item 类型: </span><span>object</span></p></td></tr><tr key=0-4-0><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> id</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">编号</span></td><td key=5></td></tr><tr key=0-4-1><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> avatar</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">头像</span></td><td key=5><p key=2><span style="font-weight: '700'">枚举: </span><span>https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/tanhua/avatar_1.png,https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/tanhua/avatar_2.png,https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/tanhua/avatar_3.png,https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/tanhua/avatar_4.png</span></p></td></tr><tr key=0-4-2><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> nickname</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">昵称</span></td><td key=5><p key=2><span style="font-weight: '700'">枚举: </span><span>Wendy,谁动了我的冬天,卿本笨笨</span></p></td></tr><tr key=0-4-3><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> createDate</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">喜欢时间</span></td><td key=5><p key=2><span style="font-weight: '700'">枚举: </span><span>2019-09-08 10:07</span></p></td></tr>
               </tbody>
              </table>
## 评论列表

<a id=评论列表> </a>

### 基本信息

**Path：** /messages/comments

**Method：** GET

**接口描述：**


### 请求参数

**Headers**

| 参数名称      | 参数值                                                       | 是否必须 | 示例 | 备注 |
| ------------- | ------------------------------------------------------------ | -------- | ---- | ---- |
| Content-Type  | application/json                                             | 是       |      |      |
| Authorization | eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1NjI4MjkzMzYsInVzZXJfaWQiOiIxIn0.Mbzn6LzsLrkVWEbhexR3lTYDZjxqIcqW11rJxDQ6Ewk | 是       |      | 令牌 |

**Query**

| 参数名称 | 是否必须 | 示例 | 备注     |
| -------- | -------- | ---- | -------- |
| page     | 是       | 1    | 当前页数 |
| pagesize | 是       | 10   | 页尺寸   |

### 返回数据

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0-0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> counts</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">总记录数</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>5000</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>100</span></p></td></tr><tr key=0-1><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> pagesize</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">页大小</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>50</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>5</span></p></td></tr><tr key=0-2><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> pages</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">总页数</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>100</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>1</span></p></td></tr><tr key=0-3><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> page</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">当前页码</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>100</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>1</span></p></td></tr><tr key=0-4><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> items</span></td><td key=1><span>object []</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">列表</span></td><td key=5><p key=0><span style="font-weight: '700'">最小数量: </span><span>10</span></p><p key=1><span style="font-weight: '700'">元素是否都不同: </span><span>true</span></p><p key=2><span style="font-weight: '700'">最大数量: </span><span>10</span></p><p key=3><span style="font-weight: '700'">item 类型: </span><span>object</span></p></td></tr><tr key=0-4-0><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> id</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">编号</span></td><td key=5></td></tr><tr key=0-4-1><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> avatar</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">头像</span></td><td key=5><p key=2><span style="font-weight: '700'">枚举: </span><span>https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/tanhua/avatar_1.png,https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/tanhua/avatar_2.png,https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/tanhua/avatar_3.png,https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/tanhua/avatar_4.png</span></p></td></tr><tr key=0-4-2><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> nickname</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">昵称</span></td><td key=5><p key=2><span style="font-weight: '700'">枚举: </span><span>Wendy,谁动了我的冬天,卿本笨笨</span></p></td></tr><tr key=0-4-3><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> createDate</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">评论时间</span></td><td key=5><p key=2><span style="font-weight: '700'">枚举: </span><span>2019-09-08 10:07</span></p></td></tr>
               </tbody>
              </table>



## 点赞列表

<a id=点赞列表> </a>
### 基本信息

**Path：** /messages/likes

**Method：** GET

**接口描述：**


### 请求参数
**Headers**

| 参数名称  | 参数值  |  是否必须 | 示例  | 备注  |
| ------------ | ------------ | ------------ | ------------ | ------------ |
| Content-Type  |  application/json | 是  |   |   |
| Authorization  |  eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1NjI4MjkzMzYsInVzZXJfaWQiOiIxIn0.Mbzn6LzsLrkVWEbhexR3lTYDZjxqIcqW11rJxDQ6Ewk | 是  |   |  令牌 |
**Query**

| 参数名称  |  是否必须 | 示例  | 备注  |
| ------------ | ------------ | ------------ | ------------ |
| page | 是  |  1 |  当前页数 |
| pagesize | 是  |  10 |  页尺寸 |

### 返回数据

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0-0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> counts</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">总记录数</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>5000</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>100</span></p></td></tr><tr key=0-1><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> pagesize</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">页大小</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>50</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>5</span></p></td></tr><tr key=0-2><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> pages</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">总页数</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>100</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>1</span></p></td></tr><tr key=0-3><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> page</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">当前页码</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>100</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>1</span></p></td></tr><tr key=0-4><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> items</span></td><td key=1><span>object []</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">列表</span></td><td key=5><p key=0><span style="font-weight: '700'">最小数量: </span><span>10</span></p><p key=1><span style="font-weight: '700'">元素是否都不同: </span><span>true</span></p><p key=2><span style="font-weight: '700'">最大数量: </span><span>10</span></p><p key=3><span style="font-weight: '700'">item 类型: </span><span>object</span></p></td></tr><tr key=0-4-0><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> id</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">编号</span></td><td key=5></td></tr><tr key=0-4-1><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> avatar</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">头像</span></td><td key=5><p key=2><span style="font-weight: '700'">枚举: </span><span>https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/tanhua/avatar_1.png,https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/tanhua/avatar_2.png,https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/tanhua/avatar_3.png,https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/tanhua/avatar_4.png</span></p></td></tr><tr key=0-4-2><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> nickname</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">昵称</span></td><td key=5><p key=2><span style="font-weight: '700'">枚举: </span><span>Wendy,谁动了我的冬天,卿本笨笨</span></p></td></tr><tr key=0-4-3><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> createDate</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">点赞时间</span></td><td key=5><p key=2><span style="font-weight: '700'">枚举: </span><span>2019-09-08 10:07</span></p></td></tr>
               </tbody>
              </table>

## 联系人列表
<a id=联系人列表> </a>
### 基本信息

**Path：** /messages/contacts

**Method：** GET

**接口描述：**


### 请求参数
**Headers**

| 参数名称  | 参数值  |  是否必须 | 示例  | 备注  |
| ------------ | ------------ | ------------ | ------------ | ------------ |
| Content-Type  |  application/json | 是  |   |   |
| Authorization  |  eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1NjI4MjkzMzYsInVzZXJfaWQiOiIxIn0.Mbzn6LzsLrkVWEbhexR3lTYDZjxqIcqW11rJxDQ6Ewk | 是  |   |  令牌 |
**Query**

| 参数名称  |  是否必须 | 示例  | 备注  |
| ------------ | ------------ | ------------ | ------------ |
| page | 是  |  1 |  当前页数 |
| pagesize | 是  |  10 |  页尺寸 |
| keyword | 是  |   |  关键字 |

### 返回数据

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0-0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> counts</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">总记录数</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>5000</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>100</span></p></td></tr><tr key=0-1><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> pagesize</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">页大小</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>50</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>5</span></p></td></tr><tr key=0-2><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> pages</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">总页数</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>100</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>1</span></p></td></tr><tr key=0-3><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> page</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">当前页码</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>100</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>1</span></p></td></tr><tr key=0-4><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> items</span></td><td key=1><span>object []</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">列表</span></td><td key=5><p key=0><span style="font-weight: '700'">最小数量: </span><span>10</span></p><p key=1><span style="font-weight: '700'">元素是否都不同: </span><span>true</span></p><p key=2><span style="font-weight: '700'">最大数量: </span><span>10</span></p><p key=3><span style="font-weight: '700'">item 类型: </span><span>object</span></p></td></tr><tr key=0-4-0><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> id</span></td><td key=1><span>integer</span></td><td key=2>非必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">编号</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>10000</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>1</span></p></td></tr><tr key=0-4-1><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> userId</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">用户id</span></td><td key=5><p key=2><span style="font-weight: '700'">枚举: </span><span>liujunjie</span></p></td></tr><tr key=0-4-2><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> avatar</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">头像</span></td><td key=5><p key=2><span style="font-weight: '700'">枚举: </span><span>https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/tanhua/avatar_1.png,https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/tanhua/avatar_2.png,https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/tanhua/avatar_3.png,https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/tanhua/avatar_4.png</span></p></td></tr><tr key=0-4-3><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> nickname</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">昵称</span></td><td key=5><p key=5><span style="font-weight: '700'">mock: </span><span>@cname</span></p></td></tr><tr key=0-4-4><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> gender</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">性别 man woman</span></td><td key=5><p key=2><span style="font-weight: '700'">枚举: </span><span>man,woman</span></p></td></tr><tr key=0-4-5><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> age</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">年龄</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>30</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>20</span></p></td></tr><tr key=0-4-6><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> city</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">城市</span></td><td key=5><p key=2><span style="font-weight: '700'">枚举: </span><span>上海,北京,广州</span></p></td></tr>
               </tbody>
              </table>

## ·联系人添加
<a id=联系人添加> </a>
### 基本信息

**Path：** /messages/contacts

**Method：** POST

**接口描述：**
<p>“聊一下”一键添加好友</p>


### 请求参数
**Headers**

| 参数名称  | 参数值  |  是否必须 | 示例  | 备注  |
| ------------ | ------------ | ------------ | ------------ | ------------ |
| Content-Type  |  application/json | 是  |   |   |
| Authorization  |  eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1NjI4MjkzMzYsInVzZXJfaWQiOiIxIn0.Mbzn6LzsLrkVWEbhexR3lTYDZjxqIcqW11rJxDQ6Ewk | 是  |   |  令牌 |
**Body**

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0-0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> userId</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">用户id</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>10000</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>1</span></p></td></tr>
               </tbody>
              </table>

### 返回数据

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody">
               </tbody>
              </table>
### 实现



# 4 小视频（前端已联调）

## 小视频列表
<a id=小视频列表> </a>
### 基本信息

**Path：** /smallVideos

**Method：** GET

**接口描述：**


### 请求参数
**Headers**

| 参数名称  | 参数值  |  是否必须 | 示例  | 备注  |
| ------------ | ------------ | ------------ | ------------ | ------------ |
| Content-Type  |  application/json | 是  |   |   |
| Authorization  |  eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1NjI4MjkzMzYsInVzZXJfaWQiOiIxIn0.Mbzn6LzsLrkVWEbhexR3lTYDZjxqIcqW11rJxDQ6Ewk | 是  |   |  令牌 |
**Query**

| 参数名称  |  是否必须 | 示例  | 备注  |
| ------------ | ------------ | ------------ | ------------ |
| page | 是  |  1 |  当前页数 |
| pagesize | 是  |  10 |  页尺寸 |

### 返回数据

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0-0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> counts</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">总记录数</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>5000</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>100</span></p></td></tr><tr key=0-1><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> pagesize</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">页大小</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>50</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>5</span></p></td></tr><tr key=0-2><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> pages</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">总页数</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>100</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>1</span></p></td></tr><tr key=0-3><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> page</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">当前页码</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>100</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>1</span></p></td></tr><tr key=0-4><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> items</span></td><td key=1><span>object []</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">列表</span></td><td key=5><p key=0><span style="font-weight: '700'">最小数量: </span><span>10</span></p><p key=1><span style="font-weight: '700'">元素是否都不同: </span><span>true</span></p><p key=2><span style="font-weight: '700'">最大数量: </span><span>10</span></p><p key=3><span style="font-weight: '700'">item 类型: </span><span>object</span></p></td></tr><tr key=0-4-0><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> id</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">编号</span></td><td key=5><p key=5><span style="font-weight: '700'">mock: </span><span>@id</span></p></td></tr><tr key=0-4-1><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> userId</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">用户id</span></td><td key=5></td></tr><tr key=0-4-2><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> avatar</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">头像</span></td><td key=5><p key=2><span style="font-weight: '700'">枚举: </span><span>https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/tanhua/avatar_1.png,https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/tanhua/avatar_2.png,https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/tanhua/avatar_3.png,https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/tanhua/avatar_4.png</span></p></td></tr><tr key=0-4-3><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> nickname</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">昵称</span></td><td key=5><p key=5><span style="font-weight: '700'">mock: </span><span>@cname</span></p></td></tr><tr key=0-4-4><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> hasFocus</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">是否关注 （1是，0否）</span></td><td key=5><p key=3><span style="font-weight: '700'">枚举: </span><span>1,0</span></p></td></tr><tr key=0-4-5><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> cover</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">封面</span></td><td key=5><p key=2><span style="font-weight: '700'">枚举: </span><span>https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/video/video_1.png,https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/video/video_2.png,https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/video/video_3.png,https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/video/video_4.png,https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/video/video_5.png,https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/video/video_6.png,https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/video/video_7.png,https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/video/video_8.png,https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/video/video_9.png,https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/video/video_10.png,https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/video/video_12.png,https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/video/video_13.png,https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/video/video_14.png,https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/video/video_15.png,https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/video/video_16.png,https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/video/video_17.png,https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/video/video_18.png,https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/video/video_19.png,https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/video/video_20.png</span></p></td></tr><tr key=0-4-6><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> videoUrl</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">视频URL</span></td><td key=5><p key=2><span style="font-weight: '700'">枚举: </span><span>https://itcast-tanhua.oss-cn-shanghai.aliyuncs.com/images/video/1576134125940400.mp4</span></p></td></tr><tr key=0-4-7><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> signature</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">签名</span></td><td key=5><p key=5><span style="font-weight: '700'">mock: </span><span>@ctitle</span></p></td></tr><tr key=0-4-8><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> likeCount</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">点赞数量</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>999</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>10</span></p></td></tr><tr key=0-4-9><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> hasLiked</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">是否已赞（1是，0否）</span></td><td key=5><p key=3><span style="font-weight: '700'">枚举: </span><span>1,0</span></p></td></tr><tr key=0-4-10><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> commentCount</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">评论数量</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>999</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>10</span></p></td></tr>
               </tbody>
              </table>
### 实现

a.调用小视频列表分页查询服务方法

b.根据视频记录中发布小视频的用户id查询UserInfo信息

c.将小视频数据与用户信息封装返回Vo

## ·视频上传

<a id=视频上传> </a>

### 基本信息

**Path：** /smallVideos

**Method：** POST

**接口描述：**


### 请求参数
**Headers**

| 参数名称  | 参数值  |  是否必须 | 示例  | 备注  |
| ------------ | ------------ | ------------ | ------------ | ------------ |
| Content-Type  |  multipart/form-data | 是  |   |   |
**Body**

| 参数名称  | 参数类型  |  是否必须 | 示例  | 备注  |
| ------------ | ------------ | ------------ | ------------ | ------------ |
| videoThumbnail | file  |  是 |    |  视频封面文件 |
| videoFile | file  |  是 |    |  视频文件 |



### 返回数据

```javascript
{}
```
### 实现

a.视频封面图片文件（oss存储）、视频文件（fastdfs存储）

b.分别得到图片地址、视频地址

c.封装数据调用服务提供者保存视频记录

## 视频点赞

<a id=视频点赞> </a>
### 基本信息

**Path：** /smallVideos/:id/like

**Method：** POST

**接口描述：**


### 请求参数
**Headers**

| 参数名称  | 参数值  |  是否必须 | 示例  | 备注  |
| ------------ | ------------ | ------------ | ------------ | ------------ |
| Content-Type  |  application/x-www-form-urlencoded | 是  |   |   |
**路径参数**

| 参数名称 | 示例  | 备注  |
| ------------ | ------------ | ------------ |
| id |   |  视频id |

### 返回数据

```javascript
{}
```
## 视频点赞 - 取消
<a id=视频点赞 - 取消> </a>
### 基本信息

**Path：** /smallVideos/:id/dislike

**Method：** POST

**接口描述：**


### 请求参数
**Headers**

| 参数名称  | 参数值  |  是否必须 | 示例  | 备注  |
| ------------ | ------------ | ------------ | ------------ | ------------ |
| Content-Type  |  application/x-www-form-urlencoded | 是  |   |   |
**路径参数**

| 参数名称 | 示例  | 备注  |
| ------------ | ------------ | ------------ |
| id |   |  视频id |

### 返回数据

```javascript
{}
```
## 评论点赞

<a id=评论点赞> </a>

### 基本信息

**Path：** /smallVideos/comments/:id/like

**Method：** POST

**接口描述：**

<p>服务端自动切换点赞状态 做取反操作</p>


### 请求参数

**Headers**

| 参数名称     | 参数值                            | 是否必须 | 示例 | 备注 |
| ------------ | --------------------------------- | -------- | ---- | ---- |
| Content-Type | application/x-www-form-urlencoded | 是       |      |      |

**路径参数**

| 参数名称 | 示例 | 备注   |
| -------- | ---- | ------ |
| id       |      | 评论id |

### 返回数据

```javascript
{}
```

## 评论点赞 - 取消

<a id=评论点赞 - 取消> </a>

### 基本信息

**Path：** /smallVideos/comments/:id/dislike

**Method：** POST

**接口描述：**

<p>服务端自动切换点赞状态 做取反操作</p>


### 请求参数

**Headers**

| 参数名称     | 参数值                            | 是否必须 | 示例 | 备注 |
| ------------ | --------------------------------- | -------- | ---- | ---- |
| Content-Type | application/x-www-form-urlencoded | 是       |      |      |

**路径参数**

| 参数名称 | 示例 | 备注    |
| -------- | ---- | ------- |
| id       |      | 评论 id |

### 返回数据

```javascript
{}
```

## 视频用户关注

<a id=视频用户关注> </a>

### 基本信息

**Path：** /smallVideos/:uid/userFocus

**Method：** POST

**接口描述：**


### 请求参数

**Headers**

| 参数名称     | 参数值                            | 是否必须 | 示例 | 备注 |
| ------------ | --------------------------------- | -------- | ---- | ---- |
| Content-Type | application/x-www-form-urlencoded | 是       |      |      |

**路径参数**

| 参数名称 | 示例 | 备注    |
| -------- | ---- | ------- |
| uid      |      | 用户uid |

### 返回数据

```javascript
{}
```

### 实现

a.被关注的用户id 当前用户id

b.根据当前用户与被关注的用户id查询FollowUser表 记录是否存在

c.记录不存在，保存关注记录 记录存在，FollowUser不做任何操作

d.根据被关注的用户id与当前登录用户id查询FollowUser表 记录是否存在

f.记录存在，说明可以成为好友（就可以操作好友表）  记录不存在不做任何操作

g.根据当前用户id与 好友id 到好友表查询记录是否存在 （最终要保证好友表只会有2条记录）

## 视频用户关注 - 取消

<a id=视频用户关注 - 取消> </a>

### 基本信息

**Path：** /smallVideos/:uid/userUnFocus

**Method：** POST

**接口描述：**


### 请求参数

**Headers**

| 参数名称     | 参数值                            | 是否必须 | 示例 | 备注 |
| ------------ | --------------------------------- | -------- | ---- | ---- |
| Content-Type | application/x-www-form-urlencoded | 是       |      |      |

**路径参数**

| 参数名称 | 示例 | 备注    |
| -------- | ---- | ------- |
| uid      |      | 用户uid |

### 返回数据

```javascript
{}
```

### 实现

## 评论列表

<a id=评论列表> </a>
### 基本信息

**Path：** /smallVideos/:id/comments

**Method：** GET

**接口描述：**


### 请求参数
**Headers**

| 参数名称  | 参数值  |  是否必须 | 示例  | 备注  |
| ------------ | ------------ | ------------ | ------------ | ------------ |
| Content-Type  |  application/json | 是  |   |   |
| Authorization  |  eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1NjI4MjkzMzYsInVzZXJfaWQiOiIxIn0.Mbzn6LzsLrkVWEbhexR3lTYDZjxqIcqW11rJxDQ6Ewk | 是  |   |  令牌 |
**路径参数**

| 参数名称 | 示例  | 备注  |
| ------------ | ------------ | ------------ |
| id |   |  视频id |
**Query**

| 参数名称  |  是否必须 | 示例  | 备注  |
| ------------ | ------------ | ------------ | ------------ |
| page | 是  |  1 |  当前页数 |
| pagesize | 是  |  10 |  页尺寸 |

### 返回数据

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0-0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> counts</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">总记录数</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>5000</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>100</span></p></td></tr><tr key=0-1><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> pagesize</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">页大小</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>50</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>5</span></p></td></tr><tr key=0-2><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> pages</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">总页数</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>100</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>1</span></p></td></tr><tr key=0-3><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> page</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">当前页码</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>100</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>1</span></p></td></tr><tr key=0-4><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> items</span></td><td key=1><span>object []</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">列表</span></td><td key=5><p key=0><span style="font-weight: '700'">最小数量: </span><span>10</span></p><p key=1><span style="font-weight: '700'">元素是否都不同: </span><span>true</span></p><p key=2><span style="font-weight: '700'">最大数量: </span><span>10</span></p><p key=3><span style="font-weight: '700'">item 类型: </span><span>object</span></p></td></tr><tr key=0-4-0><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> id</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">编号</span></td><td key=5><p key=5><span style="font-weight: '700'">mock: </span><span>@id</span></p></td></tr><tr key=0-4-1><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> avatar</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">头像</span></td><td key=5><p key=2><span style="font-weight: '700'">枚举: </span><span>https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/tanhua/avatar_1.png,https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/tanhua/avatar_2.png,https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/tanhua/avatar_3.png,https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/tanhua/avatar_4.png</span></p></td></tr><tr key=0-4-2><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> nickname</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">昵称</span></td><td key=5><p key=5><span style="font-weight: '700'">mock: </span><span>@cname</span></p></td></tr><tr key=0-4-3><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> content</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">评论内容</span></td><td key=5><p key=5><span style="font-weight: '700'">mock: </span><span>@cparagraph</span></p></td></tr><tr key=0-4-4><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> createDate</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">评论时间</span></td><td key=5><p key=5><span style="font-weight: '700'">mock: </span><span>@time</span></p></td></tr><tr key=0-4-5><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> likeCount</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">评论被赞数量</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>999</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>10</span></p></td></tr><tr key=0-4-6><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> hasLiked</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">是否已赞（1是，0否）</span></td><td key=5></td></tr>
               </tbody>
              </table>

## 评论发布
<a id=评论发布> </a>
### 基本信息

**Path：** /smallVideos/:id/comments

**Method：** POST

**接口描述：**
<p>服务端自动切换点赞状态 做取反操作</p>


### 请求参数
**Headers**

| 参数名称  | 参数值  |  是否必须 | 示例  | 备注  |
| ------------ | ------------ | ------------ | ------------ | ------------ |
| Content-Type  |  application/json | 是  |   |   |
**路径参数**

| 参数名称 | 示例  | 备注  |
| ------------ | ------------ | ------------ |
| id |   |  视频id |
**Body**

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0-0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> comment</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">评论正文</span></td><td key=5></td></tr>
               </tbody>
              </table>

### 返回数据

```javascript
{}
```
# 5 我的（前端已联调）

# 用户资料 - 读取
<a id=用户资料 - 读取> </a>

### 基本信息

**Path：** /users

**Method：** GET

**接口描述：**


### 请求参数
**Headers**

| 参数名称  | 参数值  |  是否必须 | 示例  | 备注  |
| ------------ | ------------ | ------------ | ------------ | ------------ |
| Content-Type  |  application/json | 是  |   |   |
| Authorization  |  eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1NjI4MjkzMzYsInVzZXJfaWQiOiIxIn0.Mbzn6LzsLrkVWEbhexR3lTYDZjxqIcqW11rJxDQ6Ewk | 是  |   |  令牌 |
**Query**

| 参数名称  |  是否必须 | 示例  | 备注  |
| ------------ | ------------ | ------------ | ------------ |
| userID | 否  |   |  用户ID, 如果用户自己不传入 |
| huanxinID | 否  |   |  环信用户账号id |

### 返回数据

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0-0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> id</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">编号</span></td><td key=5></td></tr><tr key=0-1><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> avatar</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">头像</span></td><td key=5><p key=2><span style="font-weight: '700'">枚举: </span><span>https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/tanhua/avatar_1.png,https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/tanhua/avatar_2.png,https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/tanhua/avatar_3.png,https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/tanhua/avatar_4.png</span></p></td></tr><tr key=0-2><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> nickname</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">昵称</span></td><td key=5><p key=2><span style="font-weight: '700'">枚举: </span><span>神仙与妖精,始终都爱你,你还梦不梦,一无所有,奇葩少女萌哒哒i,妖の叶子,氧气萌主,他没挽留i,长伴心中人i,野似温柔猫</span></p></td></tr><tr key=0-3><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> birthday</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">生日 2019-09-11</span></td><td key=5><p key=2><span style="font-weight: '700'">枚举: </span><span>2010-01-01,1990-01-01,1988-01-01,1992-01-01,1995-01-01</span></p></td></tr><tr key=0-4><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> age</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">年龄</span></td><td key=5><p key=2><span style="font-weight: '700'">枚举: </span><span>18,20,25,28,29</span></p></td></tr><tr key=0-5><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> gender</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">性别 man woman</span></td><td key=5><p key=2><span style="font-weight: '700'">枚举: </span><span>man,woman</span></p></td></tr><tr key=0-6><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> city</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">城市</span></td><td key=5><p key=5><span style="font-weight: '700'">mock: </span><span>@city</span></p></td></tr><tr key=0-7><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> education</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">学历</span></td><td key=5><p key=2><span style="font-weight: '700'">枚举: </span><span>本科,硕士,双硕,博士,双博</span></p></td></tr><tr key=0-8><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> income</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">月收入</span></td><td key=5><p key=2><span style="font-weight: '700'">枚举: </span><span>5k,8K,15K,35K,55K,80K,100K</span></p></td></tr><tr key=0-9><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> profession</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">行业</span></td><td key=5><p key=2><span style="font-weight: '700'">枚举: </span><span>IT行业,服务行业,公务员</span></p></td></tr><tr key=0-10><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> marriage</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">婚姻状态（0未婚，1已婚）</span></td><td key=5><p key=3><span style="font-weight: '700'">枚举: </span><span>0,1</span></p></td></tr>
               </tbody>
              </table>
### 实现

a.判断Token是否存在(判断是否登录了)

b.调用服务提供者：根据当前用户id查询tb_userInfo数据

c.得到UserInfo后将数据copy到UserInfoVO中

d.返回UserInfoVo

## 用户资料 - 修改

<a id=用户资料 - 保存> </a>

### 基本信息

**Path：** /users

**Method：** PUT

**接口描述：**


### 请求参数

**Headers**

| 参数名称      | 参数值                                                       | 是否必须 | 示例 | 备注 |
| ------------- | ------------------------------------------------------------ | -------- | ---- | ---- |
| Content-Type  | application/json                                             | 是       |      |      |
| Authorization | eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1NjI4MjkzMzYsInVzZXJfaWQiOiIxIn0.Mbzn6LzsLrkVWEbhexR3lTYDZjxqIcqW11rJxDQ6Ewk | 是       |      | 令牌 |

**Body**

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0-0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> nickname</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">昵称</span></td><td key=5></td></tr><tr key=0-1><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> birthday</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">生日 1990-01-01</span></td><td key=5></td></tr><tr key=0-2><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> gender</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">性别 man woman</span></td><td key=5></td></tr><tr key=0-3><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> city</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">城市</span></td><td key=5></td></tr><tr key=0-4><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> education</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">学历</span></td><td key=5></td></tr><tr key=0-5><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> income</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">月收入</span></td><td key=5></td></tr><tr key=0-6><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> profession</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">行业</span></td><td key=5></td></tr><tr key=0-7><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> marriage</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">婚姻状态（0未婚，1已婚）</span></td><td key=5></td></tr>
               </tbody>
              </table>
### 实现

a.判断Token是否存在(判断是否登录了)

b.调用服务提供者：根据当前用户id更新tb_userInfo数据

c.如果更新了生日，需要同步更新年龄字段

### 返回数据

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody">
               </tbody>
              </table>


## 用户资料 - 修改头像

<a id=用户资料 - 保存头像> </a>

### 基本信息

**Path：** /users/header

**Method：** POST

**接口描述：**


### 请求参数

**Headers**

| 参数名称      | 参数值                                                       | 是否必须 | 示例 | 备注 |
| ------------- | ------------------------------------------------------------ | -------- | ---- | ---- |
| Content-Type  | multipart/form-data                                          | 是       |      |      |
| Authorization | eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1NjI4MjkzMzYsInVzZXJfaWQiOiIxIn0.Mbzn6LzsLrkVWEbhexR3lTYDZjxqIcqW11rJxDQ6Ewk | 是       |      | 令牌 |

**Body**

| 参数名称  | 参数类型 | 是否必须 | 示例 | 备注     |
| --------- | -------- | -------- | ---- | -------- |
| headPhoto | file     | 是       |      | 头像文件 |



### 返回数据

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody">
               </tbody>
              </table>



# 互相喜欢，喜欢，粉丝 - 统计

<a id=互相喜欢，喜欢，粉丝 - 统计> </a>

### 基本信息

**Path：** /users/counts

**Method：** GET

**接口描述：**


### 请求参数

**Headers**

| 参数名称      | 参数值                                                       | 是否必须 | 示例 | 备注 |
| ------------- | ------------------------------------------------------------ | -------- | ---- | ---- |
| Content-Type  | application/json                                             | 是       |      |      |
| Authorization | eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1NjI4MjkzMzYsInVzZXJfaWQiOiIxIn0.Mbzn6LzsLrkVWEbhexR3lTYDZjxqIcqW11rJxDQ6Ewk | 是       |      | 令牌 |

### 返回数据

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0-0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> eachLoveCount</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">互相喜欢</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>999</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>55</span></p></td></tr><tr key=0-1><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> loveCount</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">喜欢</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>999</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>55</span></p></td></tr><tr key=0-2><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> fanCount</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">粉丝</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>999</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>55</span></p></td></tr>
               </tbody>
              </table>

## 互相喜欢、喜欢、粉丝、谁看过我 - 翻页列表

<a id=互相喜欢、喜欢、粉丝、谁看过我 - 翻页列表> </a>
### 基本信息

**Path：** /users/friends/:type

**Method：** GET

**接口描述：**


### 请求参数
**Headers**

| 参数名称  | 参数值  |  是否必须 | 示例  | 备注  |
| ------------ | ------------ | ------------ | ------------ | ------------ |
| Content-Type  |  application/json | 是  |   |   |
| Authorization  |  eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1NjI4MjkzMzYsInVzZXJfaWQiOiIxIn0.Mbzn6LzsLrkVWEbhexR3lTYDZjxqIcqW11rJxDQ6Ewk | 是  |   |  令牌 |
**路径参数**

| 参数名称 | 示例  | 备注  |
| ------------ | ------------ | ------------ |
| type |   |  1 互相关注<br/>2 我关注<br/>3 粉丝<br/>4 谁看过我 |
**Query**

| 参数名称  |  是否必须 | 示例  | 备注  |
| ------------ | ------------ | ------------ | ------------ |
| page | 是  |  1 |  当前页数 |
| pagesize | 否  |  10 |  页尺寸 |
| nickname | 否  |   |  昵称 |

### 返回数据

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0-0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> counts</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">总记录数</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>5000</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>100</span></p></td></tr><tr key=0-1><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> pagesize</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">页大小</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>50</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>5</span></p></td></tr><tr key=0-2><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> pages</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">总页数</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>100</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>1</span></p></td></tr><tr key=0-3><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> page</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">当前页码</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>100</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>1</span></p></td></tr><tr key=0-4><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> items</span></td><td key=1><span>object []</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">列表</span></td><td key=5><p key=0><span style="font-weight: '700'">最小数量: </span><span>10</span></p><p key=1><span style="font-weight: '700'">元素是否都不同: </span><span>true</span></p><p key=2><span style="font-weight: '700'">最大数量: </span><span>10</span></p><p key=3><span style="font-weight: '700'">item 类型: </span><span>object</span></p></td></tr><tr key=0-4-0><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> id</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">编号</span></td><td key=5></td></tr><tr key=0-4-1><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> avatar</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">头像</span></td><td key=5><p key=2><span style="font-weight: '700'">枚举: </span><span>https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/tanhua/avatar_1.png,https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/tanhua/avatar_2.png,https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/tanhua/avatar_3.png,https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/tanhua/avatar_4.png</span></p></td></tr><tr key=0-4-2><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> nickname</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">昵称</span></td><td key=5><p key=5><span style="font-weight: '700'">mock: </span><span>@cname</span></p></td></tr><tr key=0-4-3><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> gender</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">性别 man woman</span></td><td key=5><p key=2><span style="font-weight: '700'">枚举: </span><span>man,woman</span></p></td></tr><tr key=0-4-4><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> age</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">年龄</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>29</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>18</span></p></td></tr><tr key=0-4-5><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> city</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">城市</span></td><td key=5><p key=5><span style="font-weight: '700'">mock: </span><span>@city</span></p></td></tr><tr key=0-4-6><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> education</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">学历</span></td><td key=5><p key=2><span style="font-weight: '700'">枚举: </span><span>本科,硕士,双硕,博士,双博</span></p></td></tr><tr key=0-4-7><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> marriage</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">婚姻状态（0未婚，1已婚）</span></td><td key=5><p key=3><span style="font-weight: '700'">枚举: </span><span>0,1</span></p></td></tr><tr key=0-4-8><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> matchRate</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">匹配度</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>99</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>30</span></p></td></tr><tr key=0-4-9><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> alreadyLove</span></td><td key=1><span>boolean</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">是否喜欢ta</span></td><td key=5></td></tr>
               </tbody>
              </table>
## 喜欢 - 取消

<a id=喜欢 - 取消> </a>

### 基本信息

**Path：** /users/like/:uid

**Method：** DELETE

**接口描述：**


### 请求参数

**Headers**

| 参数名称      | 参数值                                                       | 是否必须 | 示例 | 备注 |
| ------------- | ------------------------------------------------------------ | -------- | ---- | ---- |
| Content-Type  | application/x-www-form-urlencoded                            | 是       |      |      |
| Authorization | eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1NjI4MjkzMzYsInVzZXJfaWQiOiIxIn0.Mbzn6LzsLrkVWEbhexR3lTYDZjxqIcqW11rJxDQ6Ewk | 是       |      | 令牌 |

**路径参数**

| 参数名称 | 示例 | 备注   |
| -------- | ---- | ------ |
| uid      |      | 用户id |

### 返回数据

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody">
               </tbody>
              </table>


## 粉丝 - 喜欢

<a id=粉丝 - 喜欢> </a>

### 基本信息

**Path：** /users/fans/:uid

**Method：** POST

**接口描述：**


### 请求参数

**Headers**

| 参数名称      | 参数值                                                       | 是否必须 | 示例 | 备注 |
| ------------- | ------------------------------------------------------------ | -------- | ---- | ---- |
| Content-Type  | application/x-www-form-urlencoded                            | 是       |      |      |
| Authorization | eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1NjI4MjkzMzYsInVzZXJfaWQiOiIxIn0.Mbzn6LzsLrkVWEbhexR3lTYDZjxqIcqW11rJxDQ6Ewk | 是       |      | 令牌 |

**路径参数**

| 参数名称 | 示例 | 备注 |
| -------- | ---- | ---- |
| uid      |      |      |

### 返回数据

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody">
               </tbody>
              </table>



# 用户通用设置 - 读取

<a id=用户通用设置 - 读取> </a>

### 基本信息

**Path：** /users/settings

**Method：** GET

**接口描述：**


### 请求参数

**Headers**

| 参数名称      | 参数值                                                       | 是否必须 | 示例 | 备注 |
| ------------- | ------------------------------------------------------------ | -------- | ---- | ---- |
| Content-Type  | application/json                                             | 是       |      |      |
| Authorization | eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1NjI4MjkzMzYsInVzZXJfaWQiOiIxIn0.Mbzn6LzsLrkVWEbhexR3lTYDZjxqIcqW11rJxDQ6Ewk | 是       |      | 令牌 |

### 返回数据

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0-0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> id</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">编号</span></td><td key=5></td></tr><tr key=0-1><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> strangerQuestion</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">陌生人问题</span></td><td key=5><p key=2><span style="font-weight: '700'">枚举: </span><span>你喜欢打羽毛球么？</span></p></td></tr><tr key=0-2><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> phone</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">手机号</span></td><td key=5><p key=2><span style="font-weight: '700'">枚举: </span><span>18613338833,18613338866</span></p></td></tr><tr key=0-3><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> likeNotification</span></td><td key=1><span>boolean</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">推送喜欢通知</span></td><td key=5></td></tr><tr key=0-4><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> pinglunNotification</span></td><td key=1><span>boolean</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">推送评论通知</span></td><td key=5></td></tr><tr key=0-5><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> gonggaoNotification</span></td><td key=1><span>boolean</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">推送公告通知</span></td><td key=5></td></tr>
               </tbody>
              </table>
### 实现

a.通过UserHolder.getUserId()   UserHolder.getUser().getMobile()

b.根据用户id查询问题表   问题不存在，设置默认问题  

c.根据用户id查询通用设置表， 记录不存在 返回默认不通知

d.封装数据到返回Vo对象中

## 设置陌生人问题 - 修改

<a id=设置陌生人问题 - 保存> </a>

### 基本信息

**Path：** /users/questions

**Method：** POST

**接口描述：**


### 请求参数

**Headers**

| 参数名称      | 参数值                                                       | 是否必须 | 示例 | 备注 |
| ------------- | ------------------------------------------------------------ | -------- | ---- | ---- |
| Content-Type  | application/json                                             | 是       |      |      |
| Authorization | eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1NjI4MjkzMzYsInVzZXJfaWQiOiIxIn0.Mbzn6LzsLrkVWEbhexR3lTYDZjxqIcqW11rJxDQ6Ewk | 是       |      | 令牌 |

**Body**

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0-0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> content</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">问题</span></td><td key=5></td></tr>
               </tbody>
              </table>


### 返回数据

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody">
               </tbody>
              </table>
### 实现

.根据用户id查询问题表记录是否存在

b.不存在，则保存问题表记录

c.存在，则更新问题表

## 通知设置 - 修改

<a id=通知设置 - 保存> </a>

### 基本信息

**Path：** /users/notifications/setting

**Method：** POST

**接口描述：**


### 请求参数

**Headers**

| 参数名称      | 参数值                                                       | 是否必须 | 示例 | 备注 |
| ------------- | ------------------------------------------------------------ | -------- | ---- | ---- |
| Content-Type  | application/json                                             | 是       |      |      |
| Authorization | eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1NjI4MjkzMzYsInVzZXJfaWQiOiIxIn0.Mbzn6LzsLrkVWEbhexR3lTYDZjxqIcqW11rJxDQ6Ewk | 是       |      | 令牌 |

**Body**

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0-0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> likeNotification</span></td><td key=1><span>boolean</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">推送喜欢通知</span></td><td key=5></td></tr><tr key=0-1><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> pinglunNotification</span></td><td key=1><span>boolean</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">推送评论通知</span></td><td key=5></td></tr><tr key=0-2><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> gonggaoNotification</span></td><td key=1><span>boolean</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">推送公告通知</span></td><td key=5></td></tr>
               </tbody>
              </table>


### 返回数据

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody">
               </tbody>
              </table>
### 实现

a.根据当前用户id查询通知设置表记录是否存在

b.如果不存在，则保存通用设置记录

c.如果存在，则更新通用设置记录


## 黑名单 - 翻页列表

<a id=黑名单 - 翻页列表> </a>

### 基本信息

**Path：** /users/blacklist

**Method：** GET

**接口描述：**


### 请求参数

**Headers**

| 参数名称      | 参数值                                                       | 是否必须 | 示例 | 备注 |
| ------------- | ------------------------------------------------------------ | -------- | ---- | ---- |
| Content-Type  | application/json                                             | 是       |      |      |
| Authorization | eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1NjI4MjkzMzYsInVzZXJfaWQiOiIxIn0.Mbzn6LzsLrkVWEbhexR3lTYDZjxqIcqW11rJxDQ6Ewk | 是       |      | 令牌 |

**Query**

| 参数名称 | 是否必须 | 示例 | 备注     |
| -------- | -------- | ---- | -------- |
| page     | 是       | 1    | 当前页数 |
| pagesize | 是       | 10   | 页尺寸   |

### 返回数据

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0-0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> counts</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">总记录数</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>5000</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>100</span></p></td></tr><tr key=0-1><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> pagesize</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">页大小</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>50</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>5</span></p></td></tr><tr key=0-2><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> pages</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">总页数</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>100</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>1</span></p></td></tr><tr key=0-3><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> page</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">当前页码</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>100</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>1</span></p></td></tr><tr key=0-4><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> items</span></td><td key=1><span>object []</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">列表</span></td><td key=5><p key=0><span style="font-weight: '700'">最小数量: </span><span>10</span></p><p key=1><span style="font-weight: '700'">元素是否都不同: </span><span>true</span></p><p key=2><span style="font-weight: '700'">最大数量: </span><span>20</span></p><p key=3><span style="font-weight: '700'">item 类型: </span><span>object</span></p></td></tr><tr key=0-4-0><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> id</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">编号</span></td><td key=5></td></tr><tr key=0-4-1><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> avatar</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">头像</span></td><td key=5><p key=2><span style="font-weight: '700'">枚举: </span><span>https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/tanhua/avatar_1.png,https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/tanhua/avatar_2.png,https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/tanhua/avatar_3.png,https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/tanhua/avatar_4.png</span></p></td></tr><tr key=0-4-2><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> nickname</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">昵称</span></td><td key=5><p key=5><span style="font-weight: '700'">mock: </span><span>@ctitle</span></p></td></tr><tr key=0-4-3><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> gender</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">性别 man woman</span></td><td key=5><p key=2><span style="font-weight: '700'">枚举: </span><span>man,woman</span></p></td></tr><tr key=0-4-4><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> age</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">年龄</span></td><td key=5><p key=0><span style="font-weight: '700'">最大值: </span><span>29</span></p><p key=1><span style="font-weight: '700'">最小值: </span><span>18</span></p></td></tr>
               </tbody>
              </table>
### 实现

a.调用服务:根据当前用户id查询黑名单表

b.根据黑名单用户ids 查询用户信息表

c.将数据封装Vo返回

## 黑名单 - 移除

<a id=黑名单 - 移除> </a>

### 基本信息

**Path：** /users/blacklist/:uid

**Method：** DELETE

**接口描述：**


### 请求参数

**Headers**

| 参数名称      | 参数值                                                       | 是否必须 | 示例 | 备注 |
| ------------- | ------------------------------------------------------------ | -------- | ---- | ---- |
| Content-Type  | application/x-www-form-urlencoded                            | 是       |      |      |
| Authorization | eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1NjI4MjkzMzYsInVzZXJfaWQiOiIxIn0.Mbzn6LzsLrkVWEbhexR3lTYDZjxqIcqW11rJxDQ6Ewk | 是       |      | 令牌 |

**路径参数**

| 参数名称 | 示例 | 备注   |
| -------- | ---- | ------ |
| uid      |      | 用户id |

### 返回数据

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody">
               </tbody>
              </table>
###   实现

1. controller接收请求后，/:uid 地址栏参数（黑名单用户id）@PathVariable

2. controller调用service业务处理

   调用服务：根据当前用户id与黑名单用户id 删除黑名单用户



## 修改手机号- 1 发送短信验证码

<a id=修改手机号- 1 发送短信验证码> </a>

### 基本信息

**Path：** /users/phone/sendVerificationCode

**Method：** POST

**接口描述：**


### 请求参数

**Headers**

| 参数名称      | 参数值                                                       | 是否必须 | 示例 | 备注 |
| ------------- | ------------------------------------------------------------ | -------- | ---- | ---- |
| Content-Type  | application/x-www-form-urlencoded                            | 是       |      |      |
| Authorization | eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1NjI4MjkzMzYsInVzZXJfaWQiOiIxIn0.Mbzn6LzsLrkVWEbhexR3lTYDZjxqIcqW11rJxDQ6Ewk | 是       |      | 令牌 |

### 返回数据

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody">
               </tbody>
              </table>



## 修改手机号 - 2 校验验证码

<a id=修改手机号 - 2 校验验证码> </a>
### 基本信息

**Path：** /users/phone/checkVerificationCode

**Method：** POST

**接口描述：**


### 请求参数
**Headers**

| 参数名称  | 参数值  |  是否必须 | 示例  | 备注  |
| ------------ | ------------ | ------------ | ------------ | ------------ |
| Content-Type  |  application/x-www-form-urlencoded | 是  |   |   |
| Authorization  |  eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1NjI4MjkzMzYsInVzZXJfaWQiOiIxIn0.Mbzn6LzsLrkVWEbhexR3lTYDZjxqIcqW11rJxDQ6Ewk | 是  |   |  令牌 |
**Body**

| 参数名称  | 参数类型  |  是否必须 | 示例  | 备注  |
| ------------ | ------------ | ------------ | ------------ | ------------ |
| verificationCode | text  |  是 |    |  验证码 |



### 返回数据

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0-0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> verification</span></td><td key=1><span>boolean</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">是否验证通过</span></td><td key=5></td></tr>
               </tbody>
              </table>

## 修改手机号 - 3 保存
<a id=修改手机号 - 3 保存> </a>
### 基本信息

**Path：** /users/phone

**Method：** POST

**接口描述：**


### 请求参数
**Headers**

| 参数名称  | 参数值  |  是否必须 | 示例  | 备注  |
| ------------ | ------------ | ------------ | ------------ | ------------ |
| Content-Type  |  application/json | 是  |   |   |
| Authorization  |  eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1NjI4MjkzMzYsInVzZXJfaWQiOiIxIn0.Mbzn6LzsLrkVWEbhexR3lTYDZjxqIcqW11rJxDQ6Ewk | 是  |   |  令牌 |
**Body**

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0-0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> phone</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">新手机号</span></td><td key=5></td></tr>
               </tbody>
              </table>

### 返回数据

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody">
               </tbody>
              </table>

## 缘分值高 用户 - 列表（已废弃）
<a id=缘分值高 用户 - 列表（已废弃）> </a>
### 基本信息

**Path：** /users/friends/luck

**Method：** GET

**接口描述：**


### 请求参数
**Headers**

| 参数名称  | 参数值  |  是否必须 | 示例  | 备注  |
| ------------ | ------------ | ------------ | ------------ | ------------ |
| Content-Type  |  application/json | 是  |   |   |
| Authorization  |  eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1NjI4MjkzMzYsInVzZXJfaWQiOiIxIn0.Mbzn6LzsLrkVWEbhexR3lTYDZjxqIcqW11rJxDQ6Ewk | 是  |   |  令牌 |

### 返回数据

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> </span></td><td key=1><span>object []</span></td><td key=2>非必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5><p key=0><span style="font-weight: '700'">最小数量: </span><span>4</span></p><p key=1><span style="font-weight: '700'">元素是否都不同: </span><span>true</span></p><p key=2><span style="font-weight: '700'">最大数量: </span><span>4</span></p><p key=3><span style="font-weight: '700'">item 类型: </span><span>object</span></p></td></tr><tr key=0-0><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> id</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">用户id</span></td><td key=5></td></tr><tr key=0-1><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> avatar</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">头像</span></td><td key=5><p key=2><span style="font-weight: '700'">枚举: </span><span>https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/tanhua/avatar_1.png,https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/tanhua/avatar_2.png,https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/tanhua/avatar_3.png,https://tanhua-dev.oss-cn-zhangjiakou.aliyuncs.com/images/tanhua/avatar_4.png</span></p></td></tr>
               </tbody>
              </table>
​       