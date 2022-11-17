# SSM
基于SSM的学生选课系统
[TOC]



## 一、SSM框架介绍

SSM框架是spring、springMVC 、和mybatis框架的整合。标准的SSM框架有四层，分别是dao层（mapper），service层，controller层和View层。使用spring实现业务对象管理，使用spring MVC负责请求的转发和视图管理，mybatis作为数据对象的持久化引擎。

### 1、持久层：dao层（mapper）层

主要是做数据持久层的工作，负责与数据库进行联络的一些任务都封装在此。通过jdbc连接操作数据库。提供Service层操作数据库的接口，实现类定义在Spring中。

### 2、业务层：Service层

Service层主要负责业务模块的逻辑应用设计。向上(Controller)层提供接口，向下（Mapper）调用持久层实现数据库等操作。

### 3、**表现层：Controller层**

负责具体的业务模块流程的控制。调用Service层提供的接口来控制业务流程。

### 4、**View层**

主要和控制层紧密结合，主要负责前台页面的表示。

### 5、SSM框架的作用

这SSM中，spring实现业务对象管理，springMVC负责请求的转发和视图管理，mybatis作为数据对象的持久化引擎。或者可以说是spring整合了springMVC和mybaitis，形成了一个更加完善的框架。框架都是越来越简单的，使用spring整合后，可以大大减少配置文件。

**spring中，最重要的两个思想——IOC和AOP**。IOC就是控制反转，可以装载bean，有了这个机制，我们就不用在每次使用这个类的时候为它初始化，很少看到关键字new。AOP则是面向切面，可以将不连续的非核心代码提取出来，让程序员只关心核心代码的实现，还能减少代码的重复。本质上这两种思想都是为了降低业务逻辑各部分之间的耦合，提高程序可重用性，提高开发效率。

**springMVC负责请求的转发和视图管理**，具体实现如下（网上找的图）.

![1](https://cdn.jsdelivr.net/gh/xiaoli-guan/MyPicGo/img/202211180022304.png)

**Mybatis的核心则是SqlSession**，本质上，mybatis是对jdbc的封装，它让数据库底层操作变的透明。mybatis通过配置文件关联到各实体类的Mapper文件，Mapper文件中配置了每个类对数据库所需进行的sql语句映射。在每次与数据库交互时，通过sqlSessionFactory拿到一个sqlSession，再执行sql命令。spring整合mybatis后，mybatis的核心配置文件基本就没什么内容了，spring配置文件中配置了mapper接口的扫描，可以将指定包下所有的mapper接口，通过SqlSession创建代理实现类对象，并将这些对象交给IOC容器管理。

### 6、请求流程

1. 客户端发送请求到DispacherServlet（分发器）

2. 由DispacherServlet控制器查询HanderMapping，找到处理请求的Controller

3. Controller调⽤Service业务逻辑层处理后返回结果到Controllerc层

    * 如果Service需要调用数据库，则调用Mapper接口处理

    * Mapper层找到对应的映射文件执行SQL语句返回结果

4. Controller将结果转到ModelAndView的视图解析器，将结果返回到分发器，再显示结果。

## 二、项目需求分析

### 1、项目要求：

学生选课系统：要求具有**学生**、**教师**、**管理员**角色，并实现如下基础功能

* 学生管理：学生的增删改查

* 课程管理：课程的增删改查

* 教师管理：教师的增删改查，一名教师可以教授1~n门课程

* 选课管理：选课的增删改查，每位学生可以选择1~n门课程

### 2、需求分析

**登录界面**：

>  首先这个选课系统有三个不同的角色，不同的角色之间的权限应该是不一样的，所以必须要有登录功能，当用户登录自己的账号时，跳到不同角色的主页。

**主页**：

学生主页：

>  可以查看并修改自己的信息，可以查看所有的选课信息但不能修改，可以查看已选课程和选修新的课程但不能修改。

教师主页：

> 可以查看并修改自己的信息，可以查看所有的选课信息但不能修改，可以查看授课的班级及班级的学生信息，可以修改学生的成绩,可以申请新的课程。该申请需要得到管理员的同意，学生才能选这一门课。

管理员主页：

> 可以查看所有学生和教师的信息并进行增删改，可以对课程信息进行增删改，可以对选课信息进行增删改，处理教师发起的上课请求。

**信息显示页面：**

> 信息显示页面应该有分页功能，不让数据太多了不好看。还需要有查询功能，应该支持多条件组合和模糊查询。

**更改信息页面**：

> 更改信息时，应该要将原本的数据回写出来，再让用户修改。

**退出功能**

> 每个页面都应该都返回上一页的按钮，主页应该有退出登录按钮。

**数据库方面**

> 应该设计6张表：
>
> * student，学生信息表
> * course：课程信息表
> * teacher：教师信息表
> * tc:教师-课程表，用来储存教师的授课信息
> * sc：学生-课程表，用来储存学生的上课信息及成绩
> * user：用户表，用来储存用户账号密码和身份
>
> 实体完整性：各表之间要保证实体完整性，student的sno，course的cno等应该作为主键。
>
> 参照完整性：建立各表之间的联系，比如sc的sno、cno是student.sno和course.cno的外键。user表里的用户只能是student或者teacher里的唯一标识。

## 三、项目演示

### 1、数据库表演示：

![1](https://cdn.jsdelivr.net/gh/xiaoli-guan/MyPicGo/img/202211180022027.png)



## ![2](https://cdn.jsdelivr.net/gh/xiaoli-guan/MyPicGo/img/202211180022715.png)![3](https://cdn.jsdelivr.net/gh/xiaoli-guan/MyPicGo/img/202211180022764.png)![4](https://cdn.jsdelivr.net/gh/xiaoli-guan/MyPicGo/img/202211180024536.png)![5](https://cdn.jsdelivr.net/gh/xiaoli-guan/MyPicGo/img/202211180024872.png)![6](https://cdn.jsdelivr.net/gh/xiaoli-guan/MyPicGo/img/202211180024914.png)

### 2、Web界面演示

**管理员角色**

![37](https://cdn.jsdelivr.net/gh/xiaoli-guan/MyPicGo/img/202211180025066.png)

![38](https://cdn.jsdelivr.net/gh/xiaoli-guan/MyPicGo/img/202211180025834.png)

![39](https://cdn.jsdelivr.net/gh/xiaoli-guan/MyPicGo/img/202211180025519.png)

![40](https://cdn.jsdelivr.net/gh/xiaoli-guan/MyPicGo/img/202211180025335.png)

![41](https://cdn.jsdelivr.net/gh/xiaoli-guan/MyPicGo/img/202211180025298.png)

![42](https://cdn.jsdelivr.net/gh/xiaoli-guan/MyPicGo/img/202211180025479.png)

![43](https://cdn.jsdelivr.net/gh/xiaoli-guan/MyPicGo/img/202211180025828.png)

![44.5](https://cdn.jsdelivr.net/gh/xiaoli-guan/MyPicGo/img/202211180025553.png)

![44](https://cdn.jsdelivr.net/gh/xiaoli-guan/MyPicGo/img/202211180025181.png)



**教师角色**

![45](https://cdn.jsdelivr.net/gh/xiaoli-guan/MyPicGo/img/202211180025607.png)

![46](https://cdn.jsdelivr.net/gh/xiaoli-guan/MyPicGo/img/202211180025461.png)

![47](https://cdn.jsdelivr.net/gh/xiaoli-guan/MyPicGo/img/202211180025196.png)

![49](https://cdn.jsdelivr.net/gh/xiaoli-guan/MyPicGo/img/202211180025216.png)

![50](https://cdn.jsdelivr.net/gh/xiaoli-guan/MyPicGo/img/202211180025631.png)





**学生角色**

![51](https://cdn.jsdelivr.net/gh/xiaoli-guan/MyPicGo/img/202211180026037.png)

![52](https://cdn.jsdelivr.net/gh/xiaoli-guan/MyPicGo/img/202211180026404.png)

## 四、项目实现细节

### 1、各种配置文件

#### 1、**pom.xml**

> 新建maven项目时我们的第一个配置文件就是我们的pom.xml了。它主要负责引入我们需要的各种jar包（依赖），统一管理依赖的版本。在本次项目中，需要引入spring、springMVC、mybatis核心、log4j、Mysql驱动、ServletAPI、Spring5和Thymeleaf整合包、逆向工程的核心依赖等等依赖。

![2](https://cdn.jsdelivr.net/gh/xiaoli-guan/MyPicGo/img/202211180026471.png)

#### 2、web.xml

> web.xml主要配置Spring的编码过滤器、配置处理请求方式的过滤器、配置SpringMVC的前端控制器DispatcherServlet、配置SpringMVC的前端控制器DispatcherServlet和设置Spring配置文件自定义的位置和名称

#### 3、SpringMVC.xml

> 首先要负责设置扫描控制层组件的包、配置视图解析器、配置默认的servlet处理静态资源、开启mvc的注解驱动、配置视图控制器。一些不用Controller层处理请求的页面就可以配置在视图控制器里。

#### 4、Spring.xml

> Spring负责整合Mybatis和SpringMVC，一些Mybatis里的配置我也放在Spring.xml里了。
>
> 首先就是为自动装配的扫描配置包路径，我这个项目使用的是半注解开发，需要注解+扫描的方式装配bean。
>
> 然后引入jdbc.properties，jdbc.properties里的是我的数据库信息，包括driver、url和数据库用户名和密码等。将它们从Spring.xml分割开是为了更好地维护，降低耦合。
>
> 然后配置数据源，使用的是德鲁伊。
>
> 再然后配置事务管理器，开启事务的注解驱动，将使用注解@Transactional标识的方法或类中所有的方法进行事务管理。
>
> 之后配置SqlSessionFactoryBean，可以直接在Spring的IOC中获取SqlSessionFactory
>
> 最后就是配置mapper接口的扫描，可以将指定包下所有的mapper接口通过SqlSession创建代理实现类对象，并将这些对象交给IOC容器管理。

#### 5、Mybatis-config.xml

> 现在的mybatis核心配置文件基本就成光杆司令了，原本在mybatis核心配置文件里的各种标签都在Spring.xml里配置过了。
>
> 我只在Mybatis-config.xml配置了两个标签，一个是将下划线映射为驼峰，数据库里的属性名我采用的是下划线命名方式，java类里我用小驼峰命名。需要用 setings 标签将它们对应起来。还有一个标签是分页插件，这个可以超级方便地实现分页功能。

### 2、搭建SSM框架
#### 1、（Mapper层）Mybatis逆向工程

逆向工程就是，先创建数据库表，由框架负责根据数据库表，反向生成如下资源：

* Java实体类

* Mapper接口

* Mapper映射文件

超级方便，单表查询的SQL语句基本都自动生成了，框架的作用之一——减少重复、固定的代码这一思想实在是妙啊。

但涉及到多表查询时的SQL语句依旧要自己编写。除此之外我还发现了一点，就是逆向工程生成的Mapper方法不支持数据类型为整形的属性的模糊搜索，这一点我就有点不理解了，为啥Mybatis不自动生成呢？还得自己写一遍。

逆向工程的配置文件名必须是**generatorConfig.xml**

逆向工程是通过插件实现的，等写好配置文件后，点击这个插件就是自动生成了。

![3](https://cdn.jsdelivr.net/gh/xiaoli-guan/MyPicGo/img/202211180026813.png)

#### 2、Service层

Mapper层基本搭建完毕，接下来我们开始搭建Service层。一般有几个表就建多少个xxxService.java，xxx是表名，实现类则是接口名后＋Impl。

要在service的实现类前面加上注解**@Service**，不然Spring扫描不到。实现类里面还有有一个成员变量——mapper的接口类，并在前面加入注解**@Autowired**，自动装配。这是为了通过SqlSession创建代理实现类对象，并将这些对象交给IOC容器管理。

![4](https://cdn.jsdelivr.net/gh/xiaoli-guan/MyPicGo/img/202211180026080.png)

在Service层内需要使用数据库时，只需要调用成员变量Mapper接口即可完成。

#### 3、Controller层

接下来我们搭建Controller层。有几个表就建几个Java类，与Service层对应起来。在类前面一样要加上注解**@Controller**,也要有成员变量——对应的Service层接口

![5](https://cdn.jsdelivr.net/gh/xiaoli-guan/MyPicGo/img/202211180026340.png)

业务逻辑的实现需要调用Service层的接口实现。

#### 4、View层

view层主要负责前台页面的显示。前端通过请求地址和请求方式，把请求发到Controller层，然后SpringMVC会根据请求地址和请求方式，找到对应的请求控制器。

前端页面一般写在webapp/WEB_INF下。

我还引入了一些静态资源，css、js的一些样式，可以使页面更美观。



**至此，SSM框架基本搭建完成，剩下的就是添砖加瓦的工作了**

### 3、参数传输方式

框架搭建完成了，接下来的一件重要的问题就是——前端的参数如何传到后端处理，处理的结果又如何返回？

首先是前端的参数传给后端，我一般使用form表单。如果传递的参数比较少，只有一两个，且是隐式传参的话，我一般将参数拼接在请求地址后面。

后端返回数据给前端就简单了，我一般使用Model类的addAttribute方法将数据共享到共享域，前端根据名字就能直接访问。

### 4、登录页面

登录页面我们需要根据情况跳转到四个不同的页面（学生、教师、管理员、账号或密码错误）。将账号密码等传到后端，Controller层调用Service层查询数据库的user表，将用户返回。Controller根据返回的结果返回不同的页面。将有以下四种情况

* 返回的结果为空，则账号或密码错误，返回登录失败页面。
* 返回的结果中的身份标志为学生，返回学生主页页面。
* 返回的结果中的身份标志为教师，返回教师主页页面。
* 返回的结果中的身份标志为管理员，返回管理员主页页面。

### 5、页面跳转

不同主页的功能虽然不太一样，但基本的逻辑是相同的。

写好一个页面，通过超链接或者按钮标签等方式，连接请求地址。当浏览器发送请求时，会自动匹配相同的请求地址和请求方式，找到对应的Controller层方法，Controller会调用对应的Service运算业务逻辑，需要执行SQL语句时也是由Service层调用Mapper接口实现。

根据功能的不同，设置不同的请求地址和请求方式，即可实现跳转到不同的页面。

**@RequestMapping注解的作用就是将请求和处理请求的控制器方法关联起来，建立映射关系。SpringMVC 接收到指定的请求，就会来找到在映射关系中对应的控制器方法来处理这个请求。**

@RequestMapping注解的**value属性通过请求的请求地址匹配请求映射，method属性通过请求的请求方式（get或post）匹配请求映射**

### 6、数据分页

当数据的条数太多时，分页会时页面更加简洁，如下

![6](https://cdn.jsdelivr.net/gh/xiaoli-guan/MyPicGo/img/202211180026416.png)

~~（当前，分页可以由前端做，但我不会啊）~~

我使用的是Mybatis的分页插件

![7](https://cdn.jsdelivr.net/gh/xiaoli-guan/MyPicGo/img/202211180026218.png)

使用它可以设置每页显示的数据条数、导航分页的页码数等，超级方便。

![8](https://cdn.jsdelivr.net/gh/xiaoli-guan/MyPicGo/img/202211180026664.png)

返回的PageInfo，还有很多信息,格式如下

> PageInfo{
>
> pageNum=8, pageSize=4, size=2, startRow=29, endRow=30, total=30, pages=8,
>
> list=Page{count=true, pageNum=8, pageSize=4, startRow=28, endRow=32, total=30,
>
> pages=8, reasonable=false, pageSizeZero=false},
>
> prePage=7, nextPage=0, isFirstPage=false, isLastPage=true, hasPreviousPage=true,
>
> hasNextPage=false, navigatePages=5, navigateFirstPage4, navigateLastPage8,
>
> navigatepageNums=[4, 5, 6, 7, 8]
>
> }

各属性的意义如下：

> pageNum：当前页的页码
>
> pageSize：每页显示的条数
>
> size：当前页显示的真实条数
>
> total：总记录数
>
> pages：总页数
>
> prePage：上一页的页码
>
> nextPage：下一页的页码
>
> isFirstPage/isLastPage：是否为第一页/最后一页
>
> hasPreviousPage/hasNextPage：是否存在上一页/下一页
>
> navigatePages：导航分页的页码数
>
> navigatepageNums：导航分页的页码，[1,2,3,4,5]

有了这些信息，就能快速实现**上一页**、**下一页**、**首页、末页**等等功能。

### 7、多条件组合模糊查询

Mybatis逆向工程没有提供整型属性的模糊搜索，所以还需要我们自己写。由于是多条件组合，所以需要用到动态组合的SQL语句，我使用的**where标签和if标签**

> if标签可通过test属性的表达式进行判断，若表达式的结果为true，则标签中的内容会执行；反之标签中的内容不会执行
>
> where和if一般结合使用：
>
> * 若where标签中的if条件都不满足，则where标签没有任何功能，即不会添加where关键字
>
> * 若where标签中的if条件满足，则where标签会自动添加where关键字，并将条件最前方多余的and去掉

例如下面

```xml
<!--List<Course> selectByCourseLike(Course course);-->
  <select id="selectByCourseLike" resultType="Course">
    select Cno cno,Cname cname,Cpno cpno,Ccredit ccredit from course
    <where>
      <if test="cno != '' and cno != null">
        cno like '%${cno}%'
      </if>
      <if test="cname != '' and cname != null">
        and cname like '%${cname}%'
      </if>
      <if test="cpno != '' and cpno != null">
        and cpno like '%${cpno}%'
      </if>
    </where>
  </select>
```

### 8、应用层保证参照完整性

在实际的web开发中，一般不会在数据库层面保证参照完整性，也就是尽量不会对表设置外键和级联。

> **阿里巴巴开发手册中说到：**【强制】不得使用外键级联，一切外键概念必须在应用层解决。

在应用层保证数据库的参照完整性就行了，比如在插入SC表之前要先查询有没有这个学生等等。

## 五、总结、项目的不足与改进

本次项目是由我一人完成的，但我基本可以说没有一点儿基础，前端、后端都不会，甚至连java都是现学的。单单学习SSM框架就花费了大量时间，导致留给项目的时间不多，页面也是依葫芦画瓢，只会用固定的几个标签。

这个项目还有很大的改进空间，还有很多想实现的内容没能添加上去，比如**找回密码的机制、针对单个同学的完整课程展示（以周为单位的课程表）、更加完善的选课机制**等等。页面也不够美观。

**最致命的一点是，我感觉我的程序十分地不安全，所有的页面都是通过请求地址+请求方式访问，没有完善的验证机制。**这就导致了用户可以通过修改网址，访问到其他不该访问的页面。目前，我已经有了解决的方法。

接下来，我会继续完善这个项目，使这个项目更加完整。

总的来说，这个项目对我的帮助十分大，不仅接触到了目前最流行的Web框架SSM，还学到了不少东西，对于制作Web页面更加得心应手。


