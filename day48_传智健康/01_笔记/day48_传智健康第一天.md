# day48_传智健康第一天

# 学习目标

- [ ] 了解传智健康项目需求
- [ ] 掌握项目环境搭建过程（重点）
- [ ] 掌握PowerDesigner的使用
- [ ] 掌握ElementUI常用组件使用（重点）
- [ ] 了解预约管理模块需求
- [ ] 掌握新增检查项（重点）

# 第一章 - ElementUI

## 1. 目标

ElementUI介绍，及学习和使用方法

## 2. 路径

1. ElementUI介绍

2. 常用组件

   （1）Container布局容器（用于页面布局）

   （2）Dropdown下拉菜单（用于首页退出菜单）

   （3）NavMenu导航菜单（用于左侧菜单）

   （4）Tabel表格（用于列表展示）

   （5）Pagination分页（用于列表分页展示）

   （6）Message消息提示（用于保存、修改、删除的时候成功或失败提示）

   （7）Tabs标签页（用于一个页面多个业务功能）

   （8）Form表单（新增、修改时的表单，及表单验证）

## 3. 讲解

### 3.1. ElementUI介绍

ElementUI是一套基于VUE2.0的桌面端组件库，ElementUI提供了丰富的组件帮助开发人员快速构建功能强大、风格统一的页面。

官网地址：[http://element-cn.eleme.io/#/zh-CN](#/zh-CN)

传智健康项目后台系统就是使用ElementUI来构建页面，在页面上引入 js 和 css 文件即可开始使用，如下：

```html
<!-- 引入ElementUI样式 -->
<link rel="stylesheet" href="https://unpkg.com/element-ui/lib/theme-chalk/index.css">
<script src="https://unpkg.com/vue/dist/vue.js"></script>
<!-- 引入ElementUI组件库 -->
<script src="https://unpkg.com/element-ui/lib/index.js"></script>
```

完成入门案例，参照HelloWorld：

el-button（按钮）和el-dialog（窗口）

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<!-- 引入ElementUI样式 -->
<link rel="stylesheet" href="https://unpkg.com/element-ui/lib/theme-chalk/index.css">
<script src="https://unpkg.com/vue/dist/vue.js"></script>
<!-- 引入ElementUI组件库 -->
<script src="https://unpkg.com/element-ui/lib/index.js"></script>
<body>
    <div id="app">
        <el-button type="success" @click="visible = true">Button</el-button>
        <el-dialog :visible.sync="visible" title="Hello world">
            <p>Try Element</p>
        </el-dialog>
    </div>

</body>
</html>
<script>
    new Vue({
        el: '#app',
        data: {
            visible: false
        }
    })
</script>
```

### 3.2. 常用组件

#### 3.2.1. Container 布局容器

用于布局的容器组件，方便快速搭建页面 

<el-container>：外层容器。当子元素中包含 <el-header> 或 <el-footer> 时，全部子元素会垂直上下排列，否则会水平左右排列

<el-header>：顶栏容器

<el-aside>：侧边栏容器

<el-main>：主要区域容器

<el-footer>：底栏容器

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<!-- 引入ElementUI样式 -->
<link rel="stylesheet" href="https://unpkg.com/element-ui/lib/theme-chalk/index.css">
<script src="https://unpkg.com/vue/dist/vue.js"></script>
<!-- 引入ElementUI组件库 -->
<script src="https://unpkg.com/element-ui/lib/index.js"></script>
<style>
    .el-header, .el-footer {
        background-color: #B3C0D1;
        color: #333;
        text-align: center;
        line-height: 60px;
    }

    .el-aside {
        background-color: #D3DCE6;
        color: #333;
        text-align: center;
        line-height: 200px;
    }

    .el-main {
        background-color: #E9EEF3;
        color: #333;
        text-align: center;
        line-height: 160px;
    }

    body > .el-container {
        margin-bottom: 40px;
    }

    .el-container:nth-child(5) .el-aside,
    .el-container:nth-child(6) .el-aside {
        line-height: 260px;
    }

    .el-container:nth-child(7) .el-aside {
        line-height: 320px;
    }
</style>
<body>
    <div id="app">
        <el-container>
            <el-header>
                标题
            </el-header>
            <el-container>
                <el-aside width="200px">
                    菜单
                </el-aside>
                <el-container>
                    <el-main>
                        功能区域
                    </el-main>
                    <el-footer>
                        底部
                    </el-footer>
                </el-container>
            </el-container>
        </el-container>
    </div>
</body>
</html>
<script>
    new Vue({
        el:"#app"
    })
</script>
```

#### 3.2.2. Dropdown 下拉菜单

将动作或菜单折叠到下拉菜单中。

- 方式一：hover激活事件


![img](./img/056.png) 

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<!-- 引入ElementUI样式 -->
<link rel="stylesheet" href="https://unpkg.com/element-ui/lib/theme-chalk/index.css">
<script src="https://unpkg.com/vue/dist/vue.js"></script>
<!-- 引入ElementUI组件库 -->
<script src="https://unpkg.com/element-ui/lib/index.js"></script>
<style>
    .el-dropdown-link {
        cursor: pointer;
        color: #409EFF;
    }
    .el-icon-arrow-down {
        font-size: 12px;
    }
</style>
<body>
    <div id="app">
        <el-dropdown>
            <span class="el-dropdown-link">
               下拉菜单<i class="el-icon-arrow-down el-icon--right"></i>
            </span>
            <el-dropdown-menu slot="dropdown">
                <el-dropdown-item>退出系统</el-dropdown-item>
                <el-dropdown-item disabled>修改密码</el-dropdown-item>
                <el-dropdown-item divided>联系管理员</el-dropdown-item>
            </el-dropdown-menu>
        </el-dropdown>
    </div>
</body>
</html>
<script>
    new Vue({
        el:"#app"
    })
</script>
```

- 方式二：click点击事件


![img](./img/057.png) 

```html
<el-dropdown trigger="click">
    <span class="el-dropdown-link">
       下拉菜单<i class="el-icon-arrow-down el-icon--right"></i>
    </span>
    <el-dropdown-menu slot="dropdown">
        <el-dropdown-item>退出系统</el-dropdown-item>
        <el-dropdown-item disabled>修改密码</el-dropdown-item>
        <el-dropdown-item divided>联系管理员</el-dropdown-item>
    </el-dropdown-menu>
</el-dropdown>
```

添加：trigger="click"

- 方式三：按钮下拉菜单


![img](./img/058.png) 

```html
<el-dropdown split-button trigger="click">
    <span class="el-dropdown-link">
       下拉菜单<!--<i class="el-icon-arrow-down el-icon--right"></i>-->
    </span>
    <el-dropdown-menu slot="dropdown">
        <el-dropdown-item>退出系统</el-dropdown-item>
        <el-dropdown-item disabled>修改密码</el-dropdown-item>
        <el-dropdown-item divided>联系管理员</el-dropdown-item>
    </el-dropdown-menu>
</el-dropdown>
```

添加：split-button trigger="click"

#### 3.2.3. NavMenu 导航菜单

为网站提供导航功能的菜单。

![img](./img/059.png) 

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<!-- 引入ElementUI样式 -->
<link rel="stylesheet" href="https://unpkg.com/element-ui/lib/theme-chalk/index.css">
<script src="https://unpkg.com/vue/dist/vue.js"></script>
<!-- 引入ElementUI组件库 -->
<script src="https://unpkg.com/element-ui/lib/index.js"></script>

<body>
    <div id="app">
        <el-menu>
             <el-submenu index="1">
               <template slot="title">
                 <i class="el-icon-location"></i>
                 <span slot="title">导航一</span>
               </template>
               <el-menu-item>选项1</el-menu-item>
               <el-menu-item>选项2</el-menu-item>
               <el-menu-item>选项3</el-menu-item>
             </el-submenu>
             <el-submenu index="2">
               <template slot="title">
                 <i class="el-icon-menu"></i>
                 <span slot="title">导航二</span>
               </template>
               <el-menu-item>选项1</el-menu-item>
               <el-menu-item>选项2</el-menu-item>
               <el-menu-item>选项3</el-menu-item>
             </el-submenu>
        </el-menu>
    </div>
</body>
</html>
<script>
    new Vue({
        el:"#app"
    })
</script>
```

#### 3.2.4. **Table 表格**【重点】

![img](./img/060.png) 

用于展示多条结构类似的数据，可对数据进行排序、筛选、对比或其他自定义操作。

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<!-- 引入ElementUI样式 -->
<link rel="stylesheet" href="https://unpkg.com/element-ui/lib/theme-chalk/index.css">
<script src="https://unpkg.com/vue/dist/vue.js"></script>
<!-- 引入ElementUI组件库 -->
<script src="https://unpkg.com/element-ui/lib/index.js"></script>

<body>
    <div id="app">
        <el-table :data="tableData" stripe>
             <el-table-column prop="date" label="日期"></el-table-column>
             <el-table-column prop="name" label="姓名"></el-table-column>
             <el-table-column prop="address" label="地址"></el-table-column>
             <el-table-column label="操作" align="center">
               <!--
        slot-scope：作用域插槽，可以获取表格数据
        scope：代表表格数据，可以通过scope.row来获取表格当前行数据，scope不是固定写法
    -->
               <template slot-scope="scope">
                 <el-button type="primary" size="mini" @click="handleUpdate(scope.row)">编辑</el-button>
                 <el-button type="danger" size="mini"  @click="handleDelete(scope.row)">删除</el-button>
               </template>
             </el-table-column>
        </el-table>

    </div>
</body>
</html>
<script>
    new Vue({
        el:'#app',
        data:{
            tableData: [{
                date: '2016-05-02',
                name: '王小虎',
                address: '上海市普陀区金沙江路 1518 弄'
            }, {
                date: '2016-05-04',
                name: '王小虎',
                address: '上海市普陀区金沙江路 1517 弄'
            }, {
                date: '2016-05-01',
                name: '王小虎',
                address: '上海市普陀区金沙江路 1519 弄'
            }]
        },
        methods:{
            handleDelete(row){
                alert(row.date);
            },
            handleUpdate(row){
                alert(row.date);
            }
        }
    });
</script>
```

其中：

```javascript
handleDelete(row){
	alert(row.date);
},
handleUpdate(row){
    alert(row.date);
}
```

为ES6的语法 修改:

![img](./img/100.png)

#### 3.2.5. **Pagination 分页**【重点】

 ![image-20210204105825412](img/image-20210204105825412.png)

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<!-- 引入ElementUI样式 -->
<link rel="stylesheet" href="https://unpkg.com/element-ui/lib/theme-chalk/index.css">
<script src="https://unpkg.com/vue/dist/vue.js"></script>
<!-- 引入ElementUI组件库 -->
<script src="https://unpkg.com/element-ui/lib/index.js"></script>

<body>
    <div id="app">
        <el-table :data="tableData" stripe>
             <el-table-column prop="date" label="日期"></el-table-column>
             <el-table-column prop="name" label="姓名"></el-table-column>
             <el-table-column prop="address" label="地址"></el-table-column>
             <el-table-column label="操作" align="center">
               <!--
        slot-scope：作用域插槽，可以获取表格数据
        scope：代表表格数据，可以通过scope.row来获取表格当前行数据，scope不是固定写法
    -->
               <template slot-scope="scope">
                 <el-button type="primary" size="mini" @click="handleUpdate(scope.row)">编辑</el-button>
                 <el-button type="danger" size="mini"  @click="handleDelete(scope.row)">删除</el-button>
               </template>
             </el-table-column>
        </el-table>
        <el-pagination @current-change="handleCurrentChange"
                       :current-page="5"
                       :page-size="10"
                       layout="total, prev, pager, next, jumper"
                       :total="305">
        </el-pagination>
    </div>
</body>
</html>
<script>
    new Vue({
        el:'#app',
        data:{
            tableData: [{
                date: '2016-05-02',
                name: '王小虎',
                address: '上海市普陀区金沙江路 1518 弄'
            }, {
                date: '2016-05-04',
                name: '王小虎',
                address: '上海市普陀区金沙江路 1517 弄'
            }, {
                date: '2016-05-01',
                name: '王小虎',
                address: '上海市普陀区金沙江路 1519 弄'
            }]
        },
        methods:{
            handleDelete:function(row){
                alert(row.date);
            },
            handleUpdate:function(row){
                alert(row.date);
            },
            // 当前页发生变化的时候，触发
            handleCurrentChange(page){
                alert(page);
            }
        }
    });
</script>
```

 

#### 3.2.6. **Message 消息提示**【重点】

常用于主动操作后的反馈提示。 

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<!-- 引入ElementUI样式 -->
<link rel="stylesheet" href="https://unpkg.com/element-ui/lib/theme-chalk/index.css">
<script src="https://unpkg.com/vue/dist/vue.js"></script>
<!-- 引入ElementUI组件库 -->
<script src="https://unpkg.com/element-ui/lib/index.js"></script>

<body>
    <div id="app">
        <el-button :plain="true" @click="open1">消息</el-button>
        <el-button :plain="true" @click="open2">成功</el-button>
        <el-button :plain="true" @click="open3">警告</el-button>
        <el-button :plain="true" @click="open4">错误</el-button>
    </div>
</body>
</html>
<script>
    new Vue({
        el:'#app',
        data:{

        },
        methods: {
            open1() {
                this.$message('这是一条消息提示');
            },
            open2() {
                this.$message({
                    message: '恭喜你，这是一条成功消息',
                    type: 'success'
                });
            },
            open3() {
                this.$message({
                    message: '警告哦，这是一条警告消息',
                    type: 'warning'
                });
            },
            open4() {
                this.$message.error('错了哦，这是一条错误消息');
            }
        }
    });
</script>
```

 

#### 3.2.7. **Tabs 标签页**

分隔内容上有关联但属于不同类别的数据集合。

![img](./img/066.png) 

![img](./img/067.png) 

![img](./img/068.png) 

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<!-- 引入ElementUI样式 -->
<link rel="stylesheet" href="https://unpkg.com/element-ui/lib/theme-chalk/index.css">
<script src="https://unpkg.com/vue/dist/vue.js"></script>
<!-- 引入ElementUI组件库 -->
<script src="https://unpkg.com/element-ui/lib/index.js"></script>

<body>
    <div id="app">
        <h3>基础的、简洁的标签页</h3>
        <!--
            通过value属性来指定当前选中的标签页
        -->
        <el-tabs value="first">
             <el-tab-pane label="用户管理" name="first">用户管理</el-tab-pane>
             <el-tab-pane label="配置管理" name="second">配置管理</el-tab-pane>
             <el-tab-pane label="角色管理" name="third">角色管理</el-tab-pane>
             <el-tab-pane label="定时任务补偿" name="fourth">定时任务补偿</el-tab-pane>
        </el-tabs>
        <h3>选项卡样式的标签页</h3>
        <el-tabs value="first" type="card">
             <el-tab-pane label="用户管理" name="first">用户管理</el-tab-pane>
             <el-tab-pane label="配置管理" name="second">配置管理</el-tab-pane>
             <el-tab-pane label="角色管理" name="third">角色管理</el-tab-pane>
             <el-tab-pane label="定时任务补偿" name="fourth">定时任务补偿</el-tab-pane>
        </el-tabs>
        <h3>卡片化的标签页</h3>
        <el-tabs value="first" type="border-card">
             <el-tab-pane label="用户管理" name="first">用户管理</el-tab-pane>
             <el-tab-pane label="配置管理" name="second">配置管理</el-tab-pane>
             <el-tab-pane label="角色管理" name="third">角色管理</el-tab-pane>
             <el-tab-pane label="定时任务补偿" name="fourth">定时任务补偿</el-tab-pane>
        </el-tabs>
    </div>
</body>
</html>
<script>
    new Vue({
        el:'#app'
    });
</script>
```

 

#### 3.2.8. **Form 表单**【重点】

由输入框、选择器、单选框、多选框等控件组成，用以收集、校验、提交数据。在 Form 组件中，每一个表单域由一个 Form-Item 组件构成，表单域中可以放置各种类型的表单控件，包括 Input、Select、Checkbox、Radio、Switch、DatePicker、TimePicker。

![img](./img/069.png) 

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<!-- 引入ElementUI样式 -->
<link rel="stylesheet" href="https://unpkg.com/element-ui/lib/theme-chalk/index.css">
<script src="https://unpkg.com/vue/dist/vue.js"></script>
<!-- 引入ElementUI组件库 -->
<script src="https://unpkg.com/element-ui/lib/index.js"></script>

<body>
    <div id="app">
        <!--
   rules：表单验证规则
-->
        <el-form ref="form" :model="form" :rules="rules" label-width="80px">
            <!--
                prop：表单域 model 字段，在使用 validate、resetFields 方法的情况下，该属性是必填的
            -->
            <el-form-item label="活动名称" prop="name">
                <el-input v-model="form.name"></el-input>
            </el-form-item>
            <el-form-item label="活动区域" prop="region">
                <el-select v-model="form.region" placeholder="请选择活动区域">
                    <el-option label="区域一" value="shanghai"></el-option>
                    <el-option label="区域二" value="beijing"></el-option>
                </el-select>
            </el-form-item>
            <el-form-item label="活动时间">
                <el-col :span="11">
                    <el-date-picker type="date" placeholder="选择日期" v-model="form.date1" style="width: 100%;"></el-date-picker>
                </el-col>
                <el-col class="line" :span="2">-</el-col>
                <el-col :span="11">
                    <el-time-picker type="fixed-time" placeholder="选择时间" v-model="form.date2" style="width: 100%;"></el-time-picker>
                </el-col>
            </el-form-item>
            <el-form-item label="即时配送">
                <el-switch v-model="form.delivery"></el-switch>
            </el-form-item>
            <el-form-item label="活动性质">
                <el-checkbox-group v-model="form.type">
                    <el-checkbox label="美食/餐厅线上活动" name="type"></el-checkbox>
                    <el-checkbox label="地推活动" name="type"></el-checkbox>
                    <el-checkbox label="线下主题活动" name="type"></el-checkbox>
                    <el-checkbox label="单纯品牌曝光" name="type"></el-checkbox>
                </el-checkbox-group>
            </el-form-item>
            <el-form-item label="特殊资源">
                <el-radio-group v-model="form.resource">
                    <el-radio label="线上品牌商赞助"></el-radio>
                    <el-radio label="线下场地免费"></el-radio>
                </el-radio-group>
            </el-form-item>
            <el-form-item label="活动形式">
                <el-input type="textarea" v-model="form.desc"></el-input>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="onSubmit">立即创建</el-button>
            </el-form-item>
        </el-form>
    </div>
</body>
</html>
<script>
    new Vue({
        el:'#app',
        data:{
            form: {
                name: '',
                region: '',
                date1: '',
                date2: '',
                delivery: false,
                type: [],
                resource: '',
                desc: ''
            },
            //定义校验规则
            rules: {
                // name对应prop="name"
                name: [
                    { required: true, message: '请输入活动名称', trigger: 'blur' },
                    { min: 3, max: 5, message: '长度在 3 到 5 个字符', trigger: 'blur' }
                ],
                region: [
                    { required: true, message: '请选择活动区域', trigger: 'change' }
                ]
            }
        },
        methods:{
            onSubmit() {
                console.log(this.form);
                //validate：对整个表单进行校验的方法，参数为一个回调函数。
                //该回调函数会在校验结束后被调用，并传入两个参数：是否校验成功和未通过校验的字段。
                // $refs['form']对应el-form ref="form"
                this.$refs['form'].validate((valid) => {
                    alert(valid)
                    if (valid) {
                        alert('submit!'); //ajax提交，完成保存/更新
                    } else {
                        console.log('error submit!!');
                        return false;
                    }
                });
            }
        }
    });
</script>
```

 

作业：删除的时候，用到MessageBox弹框 

实现一个删除的确认

![img](./img/071.png) 

## 4. 小结

* ElementUI介绍

> ElementUI是一套基于VUE2.0的桌面端组件库，ElementUI提供了丰富的组件帮助开发人员快速构建功能强大、风格统一的页面。 后台管理系统使用, github有很多elemetUI的模板(专业前端开发)

* 常用组件

  （1）Container布局容器（用于页面布局）

  （2）Dropdown下拉菜单（用于首页退出菜单）

  （3）NavMenu导航菜单（用于左侧菜单）

  （4）Tabel表格（用于列表展示）

  （5）Pagination分页（用于列表分页展示）

  （6）Message消息提示（用于保存、修改、删除的时候成功或失败提示）

  （7）Tabs标签页（用于一个页面多个业务功能）

  （8）Form表单（新增、修改时的表单，及表单验证）

# 第二章 - PowerDesigner

## 1. 目标

学会使用软件数据库设计工具（PowerDesigner）

## 2. 路径

1：PowerDesigner介绍

2：PowerDesigner使用

（1）创建物理数据模型

（2）从PDM导出SQL脚本

（3）逆向工程：从SQL脚本导入PowerDesigner

（4）生成数据库报表文件（用于项目组存档）

## 3. 讲解

### 3.1. **PowerDesigner介绍**

PowerDesigner是Sybase公司的一款软件，使用它可以方便地对系统进行分析设计，他几乎包括了数据库模型设计的全过程。利用PowerDesigner可以制作数据流程图、概念数据模型、物理数据模型、面向对象模型。

在项目设计阶段通常会使用PowerDesigner进行数据库设计。使用PowerDesigner可以更加直观的表现出数据库中表之间的关系，并且可以直接导出相应的建表语句。

![img](./img/022.png) 

### 3.2. **PowerDesigner使用**

#### 3.2.1. **创建物理数据模型**

操作步骤：

（1）创建数据模型PDM

![img](./img/023.png) 

（2）选择数据库类型

![img](./img/024.png) 

（3）创建表和字段

![img](./img/025.png) 

指定表名

![img](./img/026.png) 

![img](./img/027.png) 

创建字段

![img](./img/028.png) 

![img](./img/029.png) 

添加外键约束

![img](./img/032.png) 

![img](./img/034.png) 

发现问题，订单表的主键id，既是主键，也是外键。

双击外键

![img](./img/035.png)![img](./img/036.png) 

#### 3.2.2. **从PDM导出SQL脚本**

可以通过PowerDesigner设计的PDM模型导出为SQL脚本，如下：

选择Database中的Generate Database

![img](./img/037.png) 

![img](./img/038.png) 

#### 3.2.3. **逆向工程(从SQL脚本导入PowerDesign)**

上面我们是首先创建PDM模型，然后通过PowerDesigner提供的功能导出SQL脚本。实际上这个过程也可以反过来，也就是我们可以通过SQL脚本逆向生成PDM模型，这称为逆向工程，操作如下：

1：从数据库中导出sql

![img](./img/039.png) 

![img](./img/040.png) 

2：新建一个新的模型

![img](./img/042.png) 

![img](./img/043.png) 

![img](./img/044.png) 

![img](./img/045.png) 

![img](./img/046.png) 

![img](./img/047.png) 

#### 3.2.4. **生成数据库报表文件**

【需求】：用于生成文档，存档，供开发、测试、运维使用

通过PowerDesigner提供的功能，可以将PDM模型生成报表文件，具体操作如下：

（1）打开报表向导窗口

![img](./img/048.png) 

（2）指定报表名称和语言

![img](./img/049.png) 

（3）选择报表格式和样式

![img](./img/050.png) 

![img](./img/051.png) 

（4）选择对象类型

![img](./img/052.png) 

（5）执行生成操作

![img](./img/053.png) 

点击完成。

打开

![img](./img/054.png) 

## 4. 小结

1：PowerDesigner介绍: uml工具，可以做数据库建模（设计表结构）

  程序员应该会的： 类图，时序图，活动图（流程图），用例图

2：PowerDesigner使用

（1）创建物理数据模型

（2）从PDM导出SQL脚本

（3）逆向工程：从SQL脚本导入PowerDesigner

（4）生成数据库报表文件（用于项目组存档）

# 第三章 - 环境搭建

## 知识点-项目概述

### 1.目标

传智健康的项目总体的业务和技术

### 2.路径

1：项目介绍

2：原型展示

3：技术架构

4：功能架构

5：软件开发流程

### 3.讲解

#### 3.1. 项目介绍

​	传智健康管理系统是一款应用于健康管理机构(爱康国宾、慈铭)的业务系统，实现健康管理机构工作内容可视化、会员管理专业化、健康评估数字化、健康干预流程化、知识库集成化，从而提高健康管理师的工作效率，加强与会员间的互动，增强管理者对健康管理机构运营情况的了解。

详见：资料\01_传智健康项目资源\01-需求\传智健康PRD文档.docx

#### 3.2. **原型展示**

参见资料\01_传智健康项目资源\03-静态页面 

x

![img](./img/003.png) 

后台管理系统首页index.html

![img](./img/005.png) 

#### 3.3. **技术架构**

![img](./img/006.png) 

#### 3.4. **功能架构（SSM）**

![60925558367](./img/1609255583675.png) 

#### 3.5. **软件开发流程**

软件开发一般会经历如下几个阶段，整个过程是顺序展开，所以通常称为瀑布模型。

![img](./img/008.png)  

### 4. 小结

1. 掌握项目的功能介绍

2. 项目中的2套系统

   PC端管理系统（医院人员），移动端系统（客户，即体检人员）

3. 技术架构

* 掌握项目开发技术

4. 功能架构

* 掌握项目的业务功能

5. 软件开发流程

* 瀑布模型

## 案例-环境搭建

### 1.目标

使用maven搭建系统环境

### 2.路径

项目结构

1：父工程health_parent

2：子模块health_common（工具类）

3：子模块health_pojo（实体类）

4：子模块health_dao（Dao类）

5：子模块health_service（Service类）

6：子模块health_web（表现层）

7：测试

### 3.讲解

#### 3.1. **项目结构**

本项目采用maven分模块开发方式，即对整个项目拆分为几个模块，每个maven工程存放特定的一类代码，具体如下：

![60925429027](./img/1609254290277.png)

各模块职责定位：

health_parent：父工程，打包方式为pom，统一锁定依赖的版本，同时聚合其他子模块便于统一执行maven命令

health_common：通用模块，打包方式为jar，存放项目中使用到的一些工具类和常量类

health_pojo：打包方式为jar，存放实体类和返回结果类等

health_dao：持久层模块，打包方式为jar，存放Dao接口和Mapper映射文件等

health_service：业务逻辑模块，打包方式为jar，存放业务逻辑实现类

health_web：打包方式为war，作为控制层，存放Controller、HTML页面、js、css、spring配置文件等，需要部署到tomcat运行

#### 3.2. **maven项目搭建**

通过前面的项目功能架构图可以知道本项目分为传智健康管理后台和传智健康管理前台（微信端），本小节我们先搭建管理后台项目

##### 3.2.1. **health_parent**

【路径】

1：创建工程

2：导入坐标

【讲解】

1：创建health_parent，父工程，打包方式为pom，用于统一管理依赖版本

![img](./img/011.png) 

2：pom.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.itheima</groupId>
    <artifactId>health_parent</artifactId>
    <version>1.0-SNAPSHOT</version>

    
    <!--1. 打包方式-->
    <packaging>pom</packaging>

    <!--2. 依赖管理-->
    <!-- 集中定义依赖版本号 -->
    <properties>
        <junit.version>4.12</junit.version>
        <spring.version>5.0.5.RELEASE</spring.version>
        <pagehelper.version>4.1.4</pagehelper.version>
        <servlet-api.version>2.5</servlet-api.version>
        <mybatis.version>3.4.5</mybatis.version>
        <mybatis.spring.version>1.3.1</mybatis.spring.version>
        <mysql.version>5.1.32</mysql.version>
        <druid.version>1.0.9</druid.version>
        <commons-fileupload.version>1.3.1</commons-fileupload.version>
        <spring.security.version>5.0.5.RELEASE</spring.security.version>
        <poi.version>3.14</poi.version>
        <jedis.version>2.9.0</jedis.version>
        <quartz.version>2.2.1</quartz.version>
        <slf4j.version>1.6.6</slf4j.version>
        <qiniu.version>7.2.0</qiniu.version>
        <jsp-api.version>2.3.1</jsp-api.version>
        <servlet-api.version>3.1.0</servlet-api.version>
    </properties>
    <!-- 依赖管理标签  必须加 -->
    <dependencyManagement>
        <dependencies>
            <!-- Spring -->
            <dependency>
                <groupId>org.springframework</groupId>
                <artifactId>spring-context</artifactId>
                <version>${spring.version}</version>
            </dependency>
            <dependency>
                <groupId>org.springframework</groupId>
                <artifactId>spring-beans</artifactId>
                <version>${spring.version}</version>
            </dependency>
            <!--springmvc-->
            <dependency>
                <groupId>org.springframework</groupId>
                <artifactId>spring-web</artifactId>
                <version>${spring.version}</version>
            </dependency>
            <dependency>
                <groupId>org.springframework</groupId>
                <artifactId>spring-webmvc</artifactId>
                <version>${spring.version}</version>
            </dependency>
            <dependency>
                <groupId>org.springframework</groupId>
                <artifactId>spring-jdbc</artifactId>
                <version>${spring.version}</version>
            </dependency>
            <dependency>
                <groupId>org.springframework</groupId>
                <artifactId>spring-aspects</artifactId>
                <version>${spring.version}</version>
            </dependency>

            <dependency>
                <groupId>org.springframework</groupId>
                <artifactId>spring-context-support</artifactId>
                <version>${spring.version}</version>
            </dependency>
            <dependency>
                <groupId>org.springframework</groupId>
                <artifactId>spring-test</artifactId>
                <version>${spring.version}</version>
            </dependency>
            <dependency>
                <groupId>junit</groupId>
                <artifactId>junit</artifactId>
                <version>4.12</version>
            </dependency>
            <dependency>
                <groupId>com.alibaba</groupId>
                <artifactId>fastjson</artifactId>
                <version>1.2.47</version>
            </dependency>
            <dependency>
                <groupId>javassist</groupId>
                <artifactId>javassist</artifactId>
                <version>3.12.1.GA</version>
            </dependency>
            <dependency>
                <groupId>commons-codec</groupId>
                <artifactId>commons-codec</artifactId>
                <version>1.10</version>
            </dependency>
            <!--mybatis的分页插件-->
            <dependency>
                <groupId>com.github.pagehelper</groupId>
                <artifactId>pagehelper</artifactId>
                <version>${pagehelper.version}</version>
            </dependency>
            <!-- Mybatis -->
            <dependency>
                <groupId>org.mybatis</groupId>
                <artifactId>mybatis</artifactId>
                <version>${mybatis.version}</version>
            </dependency>
            <dependency>
                <groupId>org.mybatis</groupId>
                <artifactId>mybatis-spring</artifactId>
                <version>${mybatis.spring.version}</version>
            </dependency>
            <!-- MySql -->
            <dependency>
                <groupId>mysql</groupId>
                <artifactId>mysql-connector-java</artifactId>
                <version>${mysql.version}</version>
            </dependency>
            <!-- 连接池 -->
            <dependency>
                <groupId>com.alibaba</groupId>
                <artifactId>druid</artifactId>
                <version>${druid.version}</version>
            </dependency>
            <!-- 文件上传组件 -->
            <dependency>
                <groupId>commons-fileupload</groupId>
                <artifactId>commons-fileupload</artifactId>
                <version>${commons-fileupload.version}</version>
            </dependency>
            <!--POI报表（EXCEL）-->
            <dependency>
                <groupId>org.apache.poi</groupId>
                <artifactId>poi</artifactId>
                <version>${poi.version}</version>
            </dependency>
            <dependency>
                <groupId>org.apache.poi</groupId>
                <artifactId>poi-ooxml</artifactId>
                <version>${poi.version}</version>
            </dependency>
            <!--redis-->
            <dependency>
                <groupId>redis.clients</groupId>
                <artifactId>jedis</artifactId>
                <version>${jedis.version}</version>
            </dependency>
            <!-- spring security安全框架 -->
            <dependency>
                <groupId>org.springframework.security</groupId>
                <artifactId>spring-security-web</artifactId>
                <version>${spring.security.version}</version>
            </dependency>
            <dependency>
                <groupId>org.springframework.security</groupId>
                <artifactId>spring-security-config</artifactId>
                <version>${spring.security.version}</version>
            </dependency>
            <!-- log日志 start -->

            <dependency>
                <groupId>org.slf4j</groupId>
                <artifactId>slf4j-log4j12</artifactId>
                <version>${slf4j.version}</version>
            </dependency>
            <!-- log end -->
            <!--任务调度-->
            <dependency>
                <groupId>org.quartz-scheduler</groupId>
                <artifactId>quartz</artifactId>
                <version>${quartz.version}</version>
            </dependency>
            <dependency>
                <groupId>org.quartz-scheduler</groupId>
                <artifactId>quartz-jobs</artifactId>
                <version>${quartz.version}</version>
            </dependency>
            <!--七牛云服务平台，第三方服务（图片上传）-->
            <dependency>
                <groupId>com.qiniu</groupId>
                <artifactId>qiniu-java-sdk</artifactId>
                <version>${qiniu.version}</version>
            </dependency>

            <!--jsp-api-->
            <dependency>
                <groupId>javax.servlet.jsp</groupId>
                <artifactId>javax.servlet.jsp-api</artifactId>
                <version>${jsp-api.version}</version>
                <scope>provided</scope>
            </dependency>

            <!--servlet-api-->
            <dependency>
                <groupId>javax.servlet</groupId>
                <artifactId>javax.servlet-api</artifactId>
                <version>${servlet-api.version}</version>

                <scope>provided</scope>
            </dependency>
        </dependencies>
    </dependencyManagement>
    <build>
        <plugins>
            <!-- java编译插件 -->
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.2</version>
                <configuration>
                    <source>1.8</source>
                    <target>1.8</target>
                    <encoding>UTF-8</encoding>
                </configuration>
            </plugin>
            <plugin>
                <groupId>org.apache.tomcat.maven</groupId>
                <artifactId>tomcat7-maven-plugin</artifactId>
                <version>2.2</version>
                <configuration>
                    <path>/</path>
                    <port>83</port>
                    <uriEncoding>utf-8</uriEncoding>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>
```

##### 3.2.2. **health_common**

【路径】

1：创建工程

2：导入坐标（继承父工程、导入所有jar包）

【讲解】

1：创建health_common，子工程，打包方式为jar，存放通用组件，例如工具类等

![img](./img/012.png) 

2：pom.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>health_parent</artifactId>
        <groupId>com.itheima</groupId>
        <version>1.0-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>

    <artifactId>health_common</artifactId>

      <!--1. 打包方式-->
    <packaging>jar</packaging>

    <!--2. 依赖管理-->
    <dependencies>
        <dependency>
            <groupId>com.github.pagehelper</groupId>
            <artifactId>pagehelper</artifactId>
        </dependency>
        <!-- Mybatis -->
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis</artifactId>
        </dependency>
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis-spring</artifactId>
        </dependency>
        <!-- MySql -->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
        </dependency>
        <!-- 连接池 -->
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid</artifactId>
        </dependency>
        <dependency>
            <groupId>commons-fileupload</groupId>
            <artifactId>commons-fileupload</artifactId>
        </dependency>
        <!-- Spring -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-beans</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-webmvc</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-jdbc</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-aspects</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context-support</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-test</artifactId>
        </dependency>

        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
        </dependency>
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>fastjson</artifactId>
        </dependency>
        <dependency>
            <groupId>javassist</groupId>
            <artifactId>javassist</artifactId>
        </dependency>
        <dependency>
            <groupId>commons-codec</groupId>
            <artifactId>commons-codec</artifactId>
        </dependency>
        <!--POI报表-->
        <dependency>
            <groupId>org.apache.poi</groupId>
            <artifactId>poi</artifactId>
        </dependency>
        <dependency>
            <groupId>org.apache.poi</groupId>
            <artifactId>poi-ooxml</artifactId>
        </dependency>
        <!--Redis-->
        <dependency>
            <groupId>redis.clients</groupId>
            <artifactId>jedis</artifactId>
        </dependency>
        <!--springSecurity-->
        <dependency>
            <groupId>org.springframework.security</groupId>
            <artifactId>spring-security-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.security</groupId>
            <artifactId>spring-security-config</artifactId>
        </dependency>
        <!-- log日志 start -->

        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-log4j12</artifactId>
        </dependency>
        <!-- log end -->
        <dependency>
            <groupId>com.qiniu</groupId>
            <artifactId>qiniu-java-sdk</artifactId>
        </dependency>
        <!--jsp-api-->
        <dependency>
            <groupId>javax.servlet.jsp</groupId>
            <artifactId>javax.servlet.jsp-api</artifactId>
            <scope>provided</scope>
        </dependency>
        <!--servlet-api-->
        <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>javax.servlet-api</artifactId>
            <scope>provided</scope>
        </dependency>

    </dependencies>
</project>
```

##### 3.2.3. **health_pojo**

【路径】

1：创建工程

2：导入坐标（继承父工程、依赖health_common）

【讲解】

1：创建health_pojo，子工程，打包方式为jar，存放POJO实体类

![img](./img/013.png) 

2：pom.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>health_parent</artifactId>
        <groupId>com.itheima</groupId>
        <version>1.0-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>
    <packaging>jar</packaging>
    <artifactId>health_pojo</artifactId>
    <dependencies>
        <dependency>
            <groupId>com.itheima</groupId>
            <artifactId>health_common</artifactId>
            <version>1.0-SNAPSHOT</version>
        </dependency>
    </dependencies>
</project>
```

##### 3.2.4. **health_dao**

【路径】

1：创建工程

2：导入坐标（继承父工程、依赖health_pojo）

3：sqlMapConfig.xml（mybatis的配置文件）

4：applicationContext-dao.xml（spring整合mybatis）

5：接口类（后续添加实体后，再创建）

6：接口类对应的映射文件（后续添加实体后，再创建）

【讲解】

1：创建health_dao，子工程，打包方式为jar，存放Dao接口和Mybatis映射文件

![img](./img/014.png) 

2：pom.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>health_parent</artifactId>
        <groupId>com.itheima</groupId>
        <version>1.0-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>
    <packaging>jar</packaging>
    <artifactId>health_dao</artifactId>
    <dependencies>
        <dependency>
            <groupId>com.itheima</groupId>
            <artifactId>health_pojo</artifactId>
            <version>1.0-SNAPSHOT</version>
        </dependency>
    </dependencies>
</project>
```

 3：sqlMapConfig.xml

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
    
    <!--只需要配置分页插件即可-->
    <plugins>
        <plugin interceptor="com.github.pagehelper.PageHelper">
            <!-- 设置数据库类型 Oracle,Mysql,MariaDB,SQLite,Hsqldb,PostgreSQL 六种数据库-->
            <property name="dialect" value="mysql"/>
        </plugin>
    </plugins>
    
</configuration>
```

4：applicationContext-dao.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd">


    <!--1. 数据源-->
    <context:property-placeholder location="classpath:db.properties"/>
    <bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource">
        <property name="driverClassName" value="${db.driverClassName}"/>
        <property name="url" value="${db.url}"/>
        <property name="username" value="${db.username}"/>
        <property name="password" value="${db.password}"/>
    </bean>


    <!--2.sqlsessionfactorybean-->
    <bean class="org.mybatis.spring.SqlSessionFactoryBean">
        <!--1. 指定数据源-->
        <property name="dataSource" ref="dataSource"/>

        <!--2. 创建别名-->
        <property name="typeAliasesPackage" value="com.itheima.health.pojo"/>

        <!--3. 导入sqlmapconfig 配置文件，里面有分页插件-->
        <property name="configLocation" value="classpath:SqlMapConfig.xml"/>
    </bean>

    <!--3. 扫描bao-->
    <bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
        <property name="basePackage" value="com.itheima.dao"/>
    </bean>

</beans>
```

##### 3.2.5. **health_service**

【路径】

1：创建工程

2：导入坐标（继承父工程、依赖health_dao）（jar包）

3：applicationContext-service.xml（spring的声明式事务处理）

【讲解】

1：创建health_service，子工程，打包方式为jar，作为业务逻辑处理层，存放业务实现类

![img](./img/016.png) 

2：pom.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>health_parent</artifactId>
        <groupId>com.itheima</groupId>
        <version>1.0-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>

    <artifactId>health_service</artifactId>
    <dependencies>
        <dependency>
            <groupId>com.itheima</groupId>
            <artifactId>health_dao</artifactId>
            <version>1.0-SNAPSHOT</version>
        </dependency>
    </dependencies>
</project>
```

3：applicationContext-service.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:tx="http://www.springframework.org/schema/tx"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
                        http://www.springframework.org/schema/beans/spring-beans.xsd
                        http://www.springframework.org/schema/tx
                        http://www.springframework.org/schema/tx/spring-tx.xsd
                        http://www.springframework.org/schema/context
                        http://www.springframework.org/schema/context/spring-context.xsd">
    <!-- 事务管理器  -->
    <bean id="transactionManager"
          class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
        <property name="dataSource" ref="dataSource"/>
    </bean>
    <!--
        开启事务控制的注解支持
    -->
    <tx:annotation-driven transaction-manager="transactionManager"/>

    <!--包扫描-->
    <context:component-scan base-package="com.itheima.service"/>

    <!--import dao.xml-->
    <import resource="classpath:applicationContext-dao.xml"/>
</beans>
```

##### 3.2.6. **health_web**

【路径】

1：创建工程

2：导入坐标（继承父工程、依赖health_service）

3：log4j.properties

4：springmvc.xml（springmvc的配置、上传组件）

5：web.xml（springmvc的核心控制器，当web容器启动的时候，自动加载springmvc.xml）

【讲解】

1：创建health_web，子模块，打包方式为war，存放Controller

![img](./img/017.png) 

2：pom.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>health_parent</artifactId>
        <groupId>com.itheima</groupId>
        <version>1.0-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>
    <artifactId>health_web</artifactId>
    <packaging>war</packaging>
    <dependencies>
        <dependency>
            <groupId>com.itheima</groupId>
            <artifactId>health_service</artifactId>
            <version>1.0-SNAPSHOT</version>
        </dependency>
    </dependencies>
</project>
```

3：log4j.properties

> 放在resources文件夹下

```properties
### direct log messages to stdout ###
log4j.appender.stdout=org.apache.log4j.ConsoleAppender
log4j.appender.stdout.Target=System.err
log4j.appender.stdout.layout=org.apache.log4j.PatternLayout
log4j.appender.stdout.layout.ConversionPattern=%d{ABSOLUTE} %5p %c{1}:%L - %m%n

### direct messages to file mylog.log ###
log4j.appender.file=org.apache.log4j.FileAppender
log4j.appender.file.File=c:\\mylog.log
log4j.appender.file.layout=org.apache.log4j.PatternLayout
log4j.appender.file.layout.ConversionPattern=%d{ABSOLUTE} %5p %c{1}:%L - %m%n

### set log levels - for more verbose logging change 'info' to 'debug' ###

log4j.rootLogger=debug, stdout
```

4：springmvc.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:mvc="http://www.springframework.org/schema/mvc"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
       http://www.springframework.org/schema/mvc http://www.springframework.org/schema/mvc/spring-mvc.xsd
        http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd
    ">

    <!--注解驱动-->
    <mvc:annotation-driven>
        <mvc:message-converters register-defaults="true">
            <!--不需要视图解析器，项目中的所有的请求都返回json数据结构-->
            <bean class="com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter">
                <property name="supportedMediaTypes" value="application/json"/>
                <property name="features">
                    <list>
                        <!--User(username,age) user(username=zs,age=null) -> {username:zs}   age=null 不出来-->
                        <!--Map类型格式化，接收参数允许空值-->
                        <!--WriteMapNullValue后:
                        User(username,age) user(username=zs,age=null) -> {username:zs,age:null}   null的属性也会出来
                        -->
                        <value>WriteMapNullValue</value>
                        <!--日期类型格式化-->
                        <!--java日期-> 前端 long毫秒值 16100123123, 转成yyyy-MM-dd HH:mm:ss-->
                        <value>WriteDateUseDateFormat</value>
                    </list>
                </property>
            </bean>
        </mvc:message-converters>
    </mvc:annotation-driven>
    <!--文件上传组件-->
    <bean id="multipartResolver"
          class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
        <property name="maxUploadSize" value="104857600" />
        <property name="maxInMemorySize" value="4096" />
        <property name="defaultEncoding" value="UTF-8"/>
    </bean>
    <context:component-scan base-package="com.itheima.controller"/>
    <!--import service.xml -->
    <import resource="classpath:applicationContext-service.xml"/>
</beans>
```

FastJsonHttpMessageConverter配置定义了 @ResponseBody 支持的返回类型， json对空键值的处理方式 和 统一的日期返回格式（格式：yyyy-MM-dd）

5：web.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xmlns="http://java.sun.com/xml/ns/javaee"
         xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd"
         id="WebApp_ID" version="3.0">
    <display-name>Archetype Created Web Application</display-name>
    <!-- 解决post乱码 -->
    <filter>
        <filter-name>CharacterEncodingFilter</filter-name>
        <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
        <init-param>
            <param-name>encoding</param-name>
            <param-value>utf-8</param-value>
        </init-param>
        <init-param>
            <param-name>forceEncoding</param-name>
            <param-value>true</param-value>
        </init-param>
    </filter>
    <filter-mapping>
        <filter-name>CharacterEncodingFilter</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>
    <servlet>
        <servlet-name>springmvc</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        <!-- 指定加载的配置文件 ，通过参数contextConfigLocation加载 -->
        <init-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>classpath:springmvc.xml</param-value>
        </init-param>
        <load-on-startup>1</load-on-startup>
    </servlet>
    <servlet-mapping>
        <servlet-name>springmvc</servlet-name>
        <url-pattern>*.do</url-pattern>
    </servlet-mapping>
</web-app>
```

 这里，我们使用<url-pattern>*.do</url-pattern>的方式，表示只拦截.do结尾的url。

搭建完成后如下：

![img](./img/018.png) 

##### 3.2.7. **测试**

导入后台管理系统的页面(资料\07_公共资源\页面端静态资源)，放到health_web工程中webapp目录下

再启动health_web测试 

### 4.小结

1. 掌握工程模块拆分

2. 掌握每个工程模块的作用

## 案例-完善基础环境搭建

### 1.目标

完善基础环境搭建

### 2.路径

1：导入项目所需模块数据表

2：导入项目所需模块实体类

3：导入项目所需公共资源

### 3.讲解

#### 3.1. **导入项目所需模块数据表**

推荐使用：

 ![image-20210204113026583](img/image-20210204113026583.png)

操作步骤：

（1）根据资料中提供的itcastpdm文件导出SQL脚本

![img](./img/0012.png) 

![img](./img/0013.png) 

（2）在SQLYog中，执行crebas.sql

![img](./img/0014.png) 

#### 3.2. **导入项目所需模块实体类**

将资料中提供的POJO实体类复制到health_pojo工程中。 

![img](./img/0016.png) 

#### 3.3. **导入项目所需公共资源**

项目开发过程中一般会提供一些公共资源，供多个模块或者系统来使用。

本章节我们导入的公共资源有：

（1）返回消息常量类MessageConstant.java，放到health_common工程中

```java
package com.itheima.constant;

/**
 * 消息常量, 给前端提示用的
 */
public interface MessageConstant {
    static final String DELETE_CHECKITEM_FAIL = "删除检查项失败";
    static final String DELETE_CHECKITEM_SUCCESS = "删除检查项成功";
    static final String ADD_CHECKITEM_SUCCESS = "新增检查项成功";
    static final String ADD_CHECKITEM_FAIL = "新增检查项失败";
    static final String EDIT_CHECKITEM_FAIL = "编辑检查项失败";
    static final String EDIT_CHECKITEM_SUCCESS = "编辑检查项成功";
    static final String QUERY_CHECKITEM_SUCCESS = "查询检查项成功";
    static final String QUERY_CHECKITEM_FAIL = "查询检查项失败";
    static final String UPLOAD_SUCCESS = "上传成功";
    static final String ADD_CHECKGROUP_FAIL = "新增检查组失败";
    static final String ADD_CHECKGROUP_SUCCESS = "新增检查组成功";
    static final String DELETE_CHECKGROUP_FAIL = "删除检查组失败";
    static final String DELETE_CHECKGROUP_SUCCESS = "删除检查组成功";
    static final String QUERY_CHECKGROUP_SUCCESS = "查询检查组成功";
    static final String QUERY_CHECKGROUP_FAIL = "查询检查组失败";
    static final String EDIT_CHECKGROUP_FAIL = "编辑检查组失败";
    static final String EDIT_CHECKGROUP_SUCCESS = "编辑检查组成功";
    static final String PIC_UPLOAD_SUCCESS = "图片上传成功";
    static final String PIC_UPLOAD_FAIL = "图片上传失败";
    static final String ADD_SETMEAL_FAIL = "新增套餐失败";
    static final String ADD_SETMEAL_SUCCESS = "新增套餐成功";
    static final String IMPORT_ORDERSETTING_FAIL = "批量导入预约设置数据失败";
    static final String IMPORT_ORDERSETTING_SUCCESS = "批量导入预约设置数据成功";
    static final String GET_ORDERSETTING_SUCCESS = "获取预约设置数据成功";
    static final String GET_ORDERSETTING_FAIL = "获取预约设置数据失败";
    static final String ORDERSETTING_SUCCESS = "预约设置成功";
    static final String ORDERSETTING_FAIL = "预约设置失败";
    static final String ADD_MEMBER_FAIL = "新增会员失败";
    static final String ADD_MEMBER_SUCCESS = "新增会员成功";
    static final String DELETE_MEMBER_FAIL = "删除会员失败";
    static final String DELETE_MEMBER_SUCCESS = "删除会员成功";
    static final String EDIT_MEMBER_FAIL = "编辑会员失败";
    static final String EDIT_MEMBER_SUCCESS = "编辑会员成功";
    static final String TELEPHONE_VALIDATECODE_NOTNULL = "手机号和验证码都不能为空";
    static final String LOGIN_SUCCESS = "登录成功";
    static final String VALIDATECODE_ERROR = "验证码输入错误";
    static final String QUERY_ORDER_SUCCESS = "查询预约信息成功";
    static final String QUERY_ORDER_FAIL = "查询预约信息失败";
    static final String QUERY_SETMEALLIST_SUCCESS = "查询套餐列表数据成功";
    static final String QUERY_SETMEALLIST_FAIL = "查询套餐列表数据失败";
    static final String QUERY_SETMEAL_SUCCESS = "查询套餐数据成功";
    static final String QUERY_SETMEAL_FAIL = "查询套餐数据失败";
    static final String SEND_VALIDATECODE_FAIL = "验证码发送失败";
    static final String SEND_VALIDATECODE_SUCCESS = "验证码发送成功";
    static final String SELECTED_DATE_CANNOT_ORDER = "所选日期不能进行体检预约";
    static final String ORDER_FULL = "预约已满";
    static final String HAS_ORDERED = "已经完成预约，不能重复预约";
    static final String ORDER_SUCCESS = "预约成功";
    static final String GET_USERNAME_SUCCESS = "获取当前登录用户名称成功";
    static final String GET_USERNAME_FAIL = "获取当前登录用户名称失败";
    static final String GET_MENU_SUCCESS = "获取当前登录用户菜单成功";
    static final String GET_MENU_FAIL = "获取当前登录用户菜单失败";
    static final String GET_MEMBER_NUMBER_REPORT_SUCCESS = "获取会员统计数据成功";
    static final String GET_MEMBER_NUMBER_REPORT_FAIL = "获取会员统计数据失败";
    static final String GET_SETMEAL_COUNT_REPORT_SUCCESS = "获取套餐统计数据成功";
    static final String GET_SETMEAL_COUNT_REPORT_FAIL = "获取套餐统计数据失败";
    static final String GET_BUSINESS_REPORT_SUCCESS = "获取运营统计数据成功";
    static final String GET_BUSINESS_REPORT_FAIL = "获取运营统计数据失败";
    static final String GET_SETMEAL_LIST_SUCCESS = "查询套餐列表数据成功";
    static final String GET_SETMEAL_LIST_FAIL = "查询套餐列表数据失败";
}
```

 

（2）返回结果Result和PageResult类，放到health_pojo工程中

【1】Result.java

处理响应结果集

```java
package com.itheima.entity;

import java.io.Serializable;

/**
 * 封装返回页面结果格式 {flag:true, message:'xxx', data:数据}
 */
public class Result implements Serializable{
    private boolean flag;//执行结果，true为执行成功 false为执行失败
    private String message;//返回结果信息
    private Object data;//返回数据
    public Result(boolean flag, String message) { // 保存、修改保存
        super();
        this.flag = flag;
        this.message = message;
    }

    public Result(boolean flag, String message, Object data) {// 查询回显
        this.flag = flag;
        this.message = message;
        this.data = data;
    }

    public boolean isFlag() {
        return flag;
    }
    public void setFlag(boolean flag) {
        this.flag = flag;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
```

【2】PageResult.java

处理分页列表结果集。

```java
package com.itheima.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 分页结果封装对象
 */
public class PageResult<T> implements Serializable{
    private Long total;//总记录数
    private List<T> rows;//当前页结果
    public PageResult(Long total, List<T> rows) {
        super();
        this.total = total;
        this.rows = rows;
    }
    public Long getTotal() {
        return total;
    }
    public void setTotal(Long total) {
        this.total = total;
    }
    public List<T> getRows() {
        return rows;
    }
    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
```

（3）封装查询条件的QueryPageBean类，放到health_pojo工程中

用于封装查询条件

```java
package com.itheima.entity;

import java.io.Serializable;

/**
 * 封装前端查询条件， controller就可以用这个实体类来接收前端过来的参数
 */
public class QueryPageBean implements Serializable{
    private Integer currentPage;//页码
    private Integer pageSize;//每页记录数
    private String queryString;//查询条件

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getQueryString() {
        return queryString;
    }

    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }
} 
```

（4）安装health_parent  启动health_web（tomcat7:run）

![img](./img/0018.png) 

（5）main.html页面介绍

* 使用ElementUI

注意：后续随着项目开发还会陆续导入其他一些公共资源。

### 4.小结

1. 导入项目所需模块数据表

2. 导入项目所需模块实体类 

3. 导入项目所需公共资源

   （1）MessageConstant.java：返回消息常量类

   （2）Result.java：处理响应结果集

   （3）PageResult.java：处理分页列表结果集。

   （4）QueryPageBean.java：封装分页查询条件

# 第四章 - 检查项模块

## 案例-新增检查项

本章节完成的功能开发是预约管理功能，包括检查项管理（身高，体重）、检查组管理（外科）、体检套餐管理（公司健康体检）、预约设置等（参见产品原型）。预约管理属于系统的基础功能，主要就是管理一些体检的基础数据。

### 1. 目标

新增检查项

### 2. 路径

1. checkitem.html 给【新建】按钮绑定事件，重置表单，弹出【新增检查项】的窗口dialogFormVisible=true。
2. 填入数据，点击【确定】按钮（新增窗口），绑定事件，校验表单，成功后，提交数据，发送axios.post提交formData。响应结果：不管成功与失败，都提示操作的结果。如果成功：关闭【新增窗口】，刷新列表数据。
3. 在health_web创建CheckItemController, 设置映射路径@RequestMapping，添加add方法，用CheckItem接收formData，调用service.add(checkItem)，构建结果再返回给页面。
4. 在Health_service创建CheckItemService接口与实现类，提供add(CheckItem), 调用dao添加
5. 在Health_dao创建CheckItemDao接口与映射文件， 提供add方法，映射文件添加insert into...

### 3. 讲解

#### 3.1. 前台代码

检查项管理页面对应的是checkitem.html页面，根据产品设计的原型已经完成了页面基本结构的编写，现在需要完善页面动态效果。

##### 3.1.1. 弹出新增窗口

页面中已经提供了新增窗口，只是处于隐藏状态。只需要将控制展示状态的属性dialogFormVisible改为true就可以显示出新增窗口。

新建按钮绑定的方法为handleCreate，所以在handleCreate方法中修改dialogFormVisible属性的值为true即可。同时为了增加用户体验度，需要每次点击新建按钮时清空表单输入项。

```json
// 重置表单
resetForm() {
    this.formData = {};
},
// 弹出添加窗口
handleCreate() {
    this.resetForm();
    this.dialogFormVisible = true;
},
```

##### 3.1.2. 输入校验

```javascript
rules: {//校验规则
    code: [{ required: true, message: '项目编码为必填项', trigger: 'blur' }],
    name: [{ required: true, message: '项目名称为必填项', trigger: 'blur' }]
}
```

##### 3.1.3. 提交表单数据

点击新增窗口中的确定按钮时，触发handleAdd方法，所以需要在handleAdd方法中进行完善。

```javascript
//添加
                handleAdd () {
                    /*
                        校验数据，如果校验通过了，我们就发请求到后台去。
                            1. 使用$refs[] 来找到form表单
                            2. 调用validate方法来进行校验 ， 校验的规则在vue对象里面定义的rules里面
                            3. 校验成功即为true, 校验失败即为false, 它使用valid这个字段来接收校验结果

                     */
                    this.$refs['dataAddForm'].validate((valid)=>{
                        if(valid){
                            //this.$message.success("校验成功，可以提交数据")
                            console.log("新增检查项的参数：");
                            console.log(this.formData);
                            //发请求
                            axios.post("/checkitem/add.do" , this.formData).then(response=>{
                                if(response.data.flag){
                                    this.$message.success(response.data.message);

                                    //添加成功了之后，就要查询最新的列表数据出来显示了。
                                    this.findPage();
                                } else{
                                    this.$message.error(response.data.message);
                                }

                                //关闭对话框
                                this.dialogFormVisible = false;
                            });
                        }
                    })
                },
```

#### 3.2. **后台代码**

##### 3.2.1. **Controller**

在health_web工程中创建CheckItemController

```java
package com.itheima.controller;

import com.itheima.constant.MessageConstant;
import com.itheima.entity.Result;
import com.itheima.health.pojo.CheckItem;
import com.itheima.service.CheckItemService;
import com.qiniu.util.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/*
    @Controller :
        1. 表示这个是一个组件，会被spring管理起来
        2. 默认所有的方法返回值都会被当成是页面的名字

    @RestController ：
        1. 等于 @Controller + @ResponseBody。
        2. 在类身上加上@RestController，即表示给所有的方法都加上了@ResponseBody
            等于告诉springmvc，所有的方法返回值都是字符串，不是页面的名字。
 */
//@Controller +  @ResponseBody  =  @RestController
@RestController
@RequestMapping("/checkitem")
public class CheckItemController {

    @Autowired
    private CheckItemService cs;

    /**
     * 添加 检查项
     * @param checkItem
     * @return
     */
    @RequestMapping("/add")
    public Result add(@RequestBody CheckItem checkItem ){

        //1. 调用service就可以了。
        int row = cs.add(checkItem);

        //2. 判断结果
        Result result = null;
        if(row > 0 ){ //添加成功
            result = new Result(true , MessageConstant.ADD_CHECKITEM_SUCCESS);
        }else{ //添加失败
            result = new Result(false , MessageConstant.ADD_CHECKITEM_FAIL);
        }

        //3. 把result对象给页面返回！
        return result;
    }
}

```

 

##### 3.2.2. Service层服务实现类

在health_service工程中创建CheckItemService接口

```java
package com.itheima.service;

import com.itheima.health.pojo.CheckItem;

public interface CheckItemService {
    /**
     * 新增检查项
     * @param checkItem
     * @return
     */
    int add(CheckItem checkItem);
}

```

在health_service工程中创建CheckItemServiceImpl实现类

```java
package com.itheima.service.impl;

import com.itheima.dao.CheckItemDao;
import com.itheima.health.pojo.CheckItem;
import com.itheima.service.CheckItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/*
    1. 把这个类交给spring托管，需要加上注解 @Service
    2. 考虑使用事务，在类身上加上注解 @Transactional
    3. 调用dao即可
 */

@Service
@Transactional
public class CheckItemServiceImpl implements CheckItemService {

    //注入dao
    @Autowired
    private CheckItemDao dao;

    /**
     * 新增检查项
     * @param checkItem
     * @return
     */
    @Override
    public int add(CheckItem checkItem) {
        return dao.add(checkItem);
    }
}

```

##### 3.2.3. **Dao接口**

在health_dao工程中创建CheckItemDao接口，本项目是基于Mybatis的Mapper代理技术实现持久层操作，故只需要提供接口和Mapper映射文件，无须提供实现类

```java
package com.itheima.dao;

import com.itheima.health.pojo.CheckItem;

public interface CheckItemDao {

    /**
     * 新增检查项
     * @return
     */
    int add(CheckItem checkItem);
}

```

##### 3.2.4. **Mapper映射文件**

在health_dao工程中创建CheckItemDao.xml映射文件，需要和CheckItemDao接口在同一目录下

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.itheima.dao.CheckItemDao">

    <!--新增检查项-->
    <insert id="add" parameterType="checkItem" >
        insert into t_checkitem values (null , #{code} , #{name} ,#{sex} , #{age} , #{price} , #{type} , #{attention} , #{remark})
    </insert>
</mapper>
```

### 4.小结

1. 前台代码

   （1）弹出新增窗口

   只需要将控制展示状态的属性dialogFormVisible改为true就可以显示出新增窗口。

   （2）输入校验（了解）

   使用 ElementUI的Form表单校验

   （3）提交表单数据

   ajax提交

   ```js
   axios.post("/checkitem/add.do",this.formData).then((response)=> {
   
   })
   ```

2. 后台代码

   （1）CheckItemController.java

   （2）CheckItemService.java（服务接口）

   （3）CheckItemServiceImpl.java（服务实现类）

   （4）CheckItemDao.java（Dao接口）

   （5）CheckItemDao.xml（Mapper映射文件）

   



**仓库地址：https://gitee.com/teacher_qin/javaweb113.git**

