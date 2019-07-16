[TOC]

# 玲珑之家——架构设计
在线演示视频：http://img.dmdream.cn/fairyhouse.mp4
### 一、统一环境

* 开发IDE尽量使用IDEA

* 项目使用SpringBoot搭建

  * 运行时直接通过入口类 XXXApplication.java 直接运行main函数即可

  * 若需要修改本地端口号，在 `resources/application.properties` 中设置

    ```properties
    #Tomcat端口，修改成你自己的没被占用的端口号
    server.port=80
    ```

* 在数据库框架方面，使用了Spring Data JPA技术，是一个对象关系映射框架，后面文档会介绍


##### 1.实体类使用lombok

**Idea中的使用** 

1. Idea中  File—setting—plugin–搜索lombok–安装 重启便可以了

2. 在项目中，导入坐标，工程pom文件坐标我都已经导入好了，你们只需要安装第一步的插件即可

   ```xml
   <!-- 最新版本https://mvnrepository.com/artifact/org.projectlombok/lombok -->
   <dependency>
       <groupId>org.projectlombok</groupId>
       <artifactId>lombok</artifactId>
       <version>1.18.8</version>
       <scope>provided</scope>
   </dependency>
   <!-- lombok这个版本使用的人最多，建议使用此版本 -->
   <dependency>
       <groupId>org.projectlombok</groupId>
       <artifactId>lombok</artifactId>
       <version>1.16.20</version>
       <scope>provided</scope>
   </dependency>
   ```

3. 在实体类上使用注解 @Data即可自动生成GetSet等方法，示例如下：

   ```java
   @Data
   @ToString(exclude = "catList")//toString方法一定要注意排除会出现死循环的属性
   public class FairyAdmin {
       ...
       private List<FairyCat> catList;
   }
   ```

4. @Data会默认设置所有基本方法，而且不能有重载的构造方法，因此一般不用

   ```java
   //以下注解分别是：Getter、Setter、无参构造、全参构造，注意自己写toString
   @Getter
   @Setter
   @NoArgsConstructor
   @AllArgsConstructor
   ```

   

**eclipse中的使用（了解）**

1. 先下载[lombok](http://mvnrepository.com/artifact/org.projectlombok/lombok) jar包。使用cmd命令`java -jar 你的lombok jar路径`，然后会弹出一个框 这里会自动搜索你的eclipse安装路径（如果搜索不到，自行选择）

2. 安装完成后在你的eclipse安装路径下回有一个lombok.jar。同时你也可以看看ecliipse.ini里面是否多了个lombok

3. 在项目中引入

   ```xml
   <dependency>
       <groupId>org.projectlombok</groupId>
       <artifactId>lombok</artifactId>
       <version>1.16.20</version>
       <scope>provided</scope>
   </dependency>
   ```

   



##### 2.Spring Boot pom坐标

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.1.5.RELEASE</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>
    <groupId>cn.dmdream</groupId>
    <artifactId>fairyhouse</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>fairyhouse</name>
    <packaging>war</packaging><!--指定项目类型，打包生成的是war包-->
    <description>玲珑之家</description>

    <properties>
        <!--声明java版本-->
        <java.version>1.8</java.version>
    </properties>

    <dependencies>
        <!--Spring Data Jpa，会自动导入依赖的包如hibernate的实现类-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <!--Spring Data Redis，会自动注入RedisTemplate模板对象-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-redis</artifactId>
        </dependency>
        <!--Spring boot的web模块依赖-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <!--maven引入lombok依赖，IDE也需要安装插件-->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>
        <!--Spring Boot测试模块-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <!--Mysql，指定了5.XX版本，JPA依赖此包-->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>5.1.47</version>
        </dependency>
        <!-- 热部署，IDEA中需要开启配置才能使用，要不ctrl+F9手动编译 -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <!-- optional=true,依赖不会往下传递，如果有项目依赖本项目，并且想要使用devtools，需要重新引入 -->
            <optional>true</optional>
            <!-- scope=true ,计算用于编译，测试等的各种classpath路径,有助于确定在项目分布中需要导入的依赖-->
            <scope>true</scope>
        </dependency>
        <!--jsp支持-核心-->
        <dependency>
            <groupId>org.apache.tomcat.embed</groupId>
            <artifactId>tomcat-embed-jasper</artifactId>
        </dependency>
        <!--jsp支持-JSTL表达式-->
        <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>jstl</artifactId>
        </dependency>
        <!--七牛云SDK，用到了短信sms和对象储存-->
        <dependency>
            <groupId>com.qiniu</groupId>
            <artifactId>qiniu-java-sdk</artifactId>
            <version>7.2.0</version><!--最新版本-->
        </dependency>
        <!--腾讯云短信-->
        <dependency>
            <groupId>com.github.qcloudsms</groupId>
            <artifactId>qcloudsms</artifactId>
            <version>1.0.6</version>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <!--SpringBoot的Maven插件，在编译、打包时都会需要-->
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <configuration>
                    <!-- 用于决定当前运行的进程是否被（分叉）管理，此设置在以下两种情况下会被自动启用：1.有明确的指定jvm参数路径或工作路径 2.存在devtools  -->
                    <fork>true</fork><!-- 如果没有该配置，热部署的devtools不生效 PS：按照上面的说明其实这里默认会配置的 -->
                </configuration>
            </plugin>
            <!-- 自定义配置spring Boot使用的JDK版本，用于编译 -->
            <plugin>
                <artifactId>maven-compiler-plugin</artifactId>
                <configuration>
                    <source>1.8</source>
                    <target>1.8</target>
                </configuration>
            </plugin>
            <!--maven使用package命令导出项目时都会自己运行一遍测试类，此设置可以忽略测试-->
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <configuration>
                    <testFailureIgnore>true</testFailureIgnore>
                </configuration>
            </plugin>
        </plugins>
    </build>

</project>
```



##### 3.properties配置

```properties
#Tomcat端口
server.port=80

#日志级别
logging.level.root=info

#数据库连接设置
spring.datasource.url=jdbc:mysql://你的地址:3306/fairyhouse?useUnicode=true&characterEncoding=utf8&useSSL=false&allowMultiQueries=true
spring.datasource.username=root
spring.datasource.password=你的密码
spring.datasource.driver-class-name=com.mysql.jdbc.Driver

#JPA自动建表
spring.jpa.database=mysql
## update：若数据接表不存在，则自动创建表，若存在，不做表创建操作
spring.jpa.hibernate.ddl-auto=update
## 是否注册OpenEntityManagerInViewInterceptor。将JPA EntityManager绑定到用于整个请求处理的线程。
## true可以解决web测试下懒加载的session关闭问题
spring.jpa.open-in-view=true
## 非web环境下的懒加载解决方案
spring.jpa.properties.hibernate.enable_lazy_load_no_trans=true
## 是否显示sql语句
spring.jpa.show-sql=false
## 其中spring.jpa.hibernate.naming.physical-strategy是为了修改生成的表和属性的命名策略
## 默认是自动转成小写和下划线形式，versionCode就变成了version_code，其实这种命名策略是比较好的。
## 但是有时候我们可能更加希望属性名称和数据库名称统一，所以增加这个配置后生成的表和属性就和Java类一致
spring.jpa.hibernate.naming.physical-strategy=org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl

#springMVC相关页面解析器配置
spring.mvc.view.prefix=/WEB-INF/jsp/
spring.mvc.view.suffix=.jsp

#Redis
spring.redis.host=193.112.41.124
spring.redis.port=6379
spring.redis.password=你的密码
spring.redis.database=0
spring.redis.jedis.pool.max-idle=100
```



##### 4.SpringBoot热部署了解

* 开启SpringBoot的热部署后，启动spring项目，新增代码后无需重启项目，springboot会自动帮你编译发布

**如何使用：** 

> PS：前两步在pom文件中我都已经配置好了，如果你们用的是idea，**直接做第四步的设置**
>
> [参考博客](<https://blog.csdn.net/sinat_25305411/article/details/81030503>) 

1. 在Maven的pom.xml文件添加dependency依赖

   ```xml
   <!-- 热部署 -->
   <dependency>
       <groupId>org.springframework.boot</groupId>
       <artifactId>spring-boot-devtools</artifactId>
       <!-- optional=true,依赖不会往下传递，如果有项目依赖本项目，并且想要使用devtools，需要重新引入 -->
       <optional>true</optional>
       <!-- scope=true ,对编译、测试等的各种classpath路径进行计算,有助于在项目分布中确定需要导入的依赖-->
       <scope>true</scope>
   </dependency>
   ```

2. 继续在Maven的pom.xml文件添加插件配置

   ```xml
   <build>
       <plugins>
           <plugin>
               <groupId>org.springframework.boot</groupId>
               <artifactId>spring-boot-maven-plugin</artifactId>
               <configuration>
                   <!-- 用于决定当前运行的进程是否被（分叉）管理，此设置在以下两种情况下会被自动启用：1.有明确的指定jvm参数路径或工作路径 2.存在devtools  -->
                   <fork>true</fork><!-- 如果没有该配置，热部署的devtools不生效 PS：按照上面的说明其实这里默认会配置的 -->
               </configuration>
           </plugin>
           <!-- 自定义配置spring Boot使用的JDK版本 -->
           <plugin>
               <artifactId>maven-compiler-plugin</artifactId>
               <configuration>
                   <source>1.8</source>
                   <target>1.8</target>
               </configuration>
           </plugin>
       </plugins>
   </build>
   ```

3. 如果是Eclipse，配置到这里，只要重启服务，热部署就会生效了

4. idea需要继续设置

   1. 手动方式

      **修改完代码，按快捷键Ctrl+F9，手动构建项目**，或者只修改单个类文件的话，按Ctrl+Shift+F9，重新编译该类文件，即可触发重启服务。

   2. 自动方式

      1. **File -> Settings -> Compiler，勾选 Build Project automatically** 
      2. **按快捷键Ctrl+Shift+Alt+/，选择1.Registry...** 
      3. **勾选 compiler.automake.allow.when.app.running 即可** 



---

### 二、实体类

##### 1.抽取公共基类

BaseEntity（用于继承，因此是抽象类）

```java
package cn.dmdream.entity.base;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass//表明这是父类，可以将属性映射到子类中使用JPA生成表
public abstract class BaseEntity implements Serializable {

    @Getter @Setter
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",columnDefinition = "bigint(30) comment '无意义自增主键'")
    protected Long id;//无意义自增主键

    @Getter @Setter
    @Column(name="createTime",columnDefinition="DATETIME comment '创建时间'")
    protected Date createTime = new Date(); //创建时间

    @Getter @Setter
    @Column(name="destroyTime",columnDefinition="DATETIME comment '销毁时间'")
    protected Date destroyTime; //销毁时间

    @Getter @Setter
    @Version @Column(name="version",nullable=false,columnDefinition="int(20) default 1 comment '版本号'")
    protected Integer version = 1;//乐观锁，使用@Version注解标明

    @Getter @Setter
    @Column(length=1,name="isValid",nullable=false,columnDefinition="int(1) default 1 comment '是否启用，1:启用  0:不启用'")
    protected Integer isValid = 1; //是否启用

    @Getter @Setter
    @Transient//不被映射到数据库
    protected String createTimeStart;  //创建时间的开始点

    @Getter @Setter
    @Transient//不被映射到数据库
    protected String createTimeEnd; //创建时间的结束点

}

```



##### 2.抽取用户公共基类

BaseUserEntity

```java
package cn.dmdream.entity.base;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * User和Admin的父类信息
 */
@MappedSuperclass
public abstract class BaseUserEntity extends BaseEntity{

    @Getter @Setter
    @Column(length = 32,name = "username",nullable = false,unique = true,columnDefinition = "varchar(32) unique " +
            "comment '用户名'")
    protected String username;//用户名不为空，唯一，长度32

    @Getter @Setter
    @Column(length = 11,name = "phone",nullable = false,unique = true,columnDefinition = "varchar(11) unique " +
            "comment '手机号'")
    protected String phone;//手机号不为空，唯一，长度11

    @Getter @Setter
    @Column(length = 64,name = "email",columnDefinition = "varchar(64) comment '邮箱'")
    protected String email;//邮箱

    @Getter @Setter
    @Column(length = 32,name = "realname",columnDefinition = "varchar(32) comment '真实姓名'")
    protected String realname;//真实姓名

    @Getter @Setter
    @Column(length = 32,name = "nickname",columnDefinition = "varchar(32) comment '昵称'")
    protected String nickname;//昵称

    @Getter @Setter
    @Column(name = "nickpic",columnDefinition = "varchar(255) comment '头像地址'")
    protected String nickpic;//头像地址

}

```



---

### 三、Dao层

> 想要自学可以我的博客—— [Spring Data JPA（超详细自学笔记！从小白到入门）](<https://blog.csdn.net/SerikaOnoe/article/details/91662599#t0>) 

##### 1.继承接口

* JpaRepositoryImplementation<AdminEntity,Long> {//两个参数，一个是对应的实体类，一个是该实体类主键的类型}



##### 2.增删改查示例

AdminDao

```java
package cn.dmdream.dao;

import cn.dmdream.entity.AdminEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminDao extends JpaRepositoryImplementation<AdminEntity,Long> {//两个参数，一个是对应的实体类，一个是该实体类主键的类型

    AdminEntity findByUsernameIsAndPasswordIs(String username, String password);

    AdminEntity findByPhoneIsAndPasswordIs(String phone, String password);
}
```

TestFairyAdminDao

```java
package cn.dmdream.dao;

import cn.dmdream.entity.FairyAdmin;
import cn.dmdream.entity.FairyCat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)//指定测试运行类
@SpringBootTest(properties = {"classpath:application.properties"})//使用springboot测试
public class TestFairyAdminDao {

    @Autowired
    private FairyAdminDao fairyAdminDao;

    @Test//新增
    public void saveTest() {
        FairyAdmin admin = new FairyAdmin();
        admin.setAdminUsername("yoko");
        FairyCat cat = new FairyCat();
        cat.setCatName("yoko_Cat");
        cat.setAdmin(admin);//双向关联保存
        admin.getCatList().add(cat);
        fairyAdminDao.save(admin);
    }

    //按用户名查询
    @Test
    public void findByUsernameTest() {
        FairyAdmin admin = fairyAdminDao.findByAdminUsername("yoko");
        System.out.println(admin);
        System.out.println(admin.getCatList());//关联查询
    }

    //修改
    @Test
    public void updateTest() {
        FairyAdmin admin = fairyAdminDao.findByAdminUsername("yoko");
        admin.setAdminNickname("yokoNicname");
        admin.setAdminPassword("yokoPassword");
        admin.getCatList().get(0).setCatName("yoko_cat_edit1");
        fairyAdminDao.save(admin);//这里会自动根据主键判断是否是更新
    }

    //删除
    @Test
    public void deleteTest() {
        FairyAdmin admin = fairyAdminDao.findByAdminUsername("yoko");
        fairyAdminDao.delete(admin);//级联删除，猫也会被删除
    }

    //批量保存
    @Test
    public void saveListTest() {
        List<FairyAdmin> list = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            FairyAdmin admin = new FairyAdmin();
            admin.setAdminUsername("yoko_" + i);
            FairyCat cat = new FairyCat();
            cat.setCatName("yoko_cat_" + i);
            cat.setAdmin(admin);//双向关联保存
            admin.getCatList().add(cat);
            list.add(admin);
        }
        fairyAdminDao.saveAll(list);
    }

    //查询所有
    @Test
    public void findAllTest() {
        List<FairyAdmin> list = fairyAdminDao.findAll();
        list.forEach(System.out::println);
    }

    //原生查询语句测试
    @Test
    public void myFindAllByUsernameLikeTest() {
        List<FairyAdmin> list = fairyAdminDao.myFindAllByUsernameLike("yoko_1");
        list.forEach(System.out::println);
    }

    //JPQL查询语句测试
    @Test
    public void myFindAllByUsernameLike_JPQLTest() {
        List<FairyAdmin> list = fairyAdminDao.myFindAllByUsernameLike_JPQL("yoko_1");
        list.forEach(System.out::println);
    }

    //排序和分页
    @Test
    public void sortAndPageSearchTest() {

        //排序的几种方式

        //方式一：多字段排序查询，无法自定义顺序，输出语句...order by adminId desc, adminUsername desc
        //Sort sort = new Sort(Sort.Direction.DESC,"adminId","adminUsername");

        //方式二：多字段排序查询，可自定义顺序，x输出语句：...order by adminUsername asc, adminId desc
        Sort sort = new Sort(Sort.Direction.DESC,"adminId");//第一个参数，排序类型：ASC/DESC，第二个参数：按照排序的字段，可以设置多个
        Sort sort1 = new Sort(Sort.Direction.ASC,"adminUsername");
        final Sort mergeSort = sort1.and(sort);

        //方式三：多字段排序查询，先创建order对象，再构造sort
        List<Sort.Order> orders = new ArrayList<Sort.Order>();
        Sort.Order order1 = new Sort.Order(Sort.Direction.DESC,"adminId");
        Sort.Order order2 = new Sort.Order(Sort.Direction.ASC,"adminUsername");
        //可以直接单对象创建
        Sort orderSort = Sort.by(order2);//...order by adminUsername asc
        //可以使用order列表创建
        orders.add(order1);
        orders.add(order2);
        Sort orderListSort = Sort.by(orders);//...order by adminId desc, adminUsername desc


        //需要注意的是：page从0开始，不是从1开始！
        PageRequest pageRequest = PageRequest.of(0,5, orderListSort);
        Page<FairyAdmin> content = fairyAdminDao.findAll(pageRequest);
        if (content.hasContent()) {
            System.out.println("总记录数："+content.getTotalElements());
            System.out.println("总页数："+content.getTotalPages());
            System.out.println("当前页："+(content.getPageable().getPageNumber()+1));
            System.out.println("当前页面大小："+content.getPageable().getPageSize());
            List<FairyAdmin> list = content.getContent();
            list.forEach(System.out::println);
            System.out.println(content);
        }
        System.out.println("==========================================");
    }

    //测试Example查询，简单测试
    @Test
    public void exampleQueryTest() {
        FairyAdmin admin = new FairyAdmin();
        admin.setAdminUsername("yoko_5");//精确匹配
        Example<FairyAdmin> example = Example.of(admin);//默认会忽略空值的字段
        List<FairyAdmin> list = fairyAdminDao.findAll(example);
        list.forEach(System.out::println);
    }

    //测试Example查询，多条件
    @Test
    public void exampleQueryTest2() {
        FairyAdmin admin = new FairyAdmin();
        admin.setAdminUsername("YOKO");
        admin.setAdminPassword("123");
        //ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreCase("adminUsername").withMatcher("adminUsername", ExampleMatcher.GenericPropertyMatchers.startsWith()).withIgnorePaths("adminPassword");
        //忽略adminUsername，模糊查询开头匹配，忽略adminPassword（无论是否由值都忽略）
        //使用lambda版本
        ExampleMatcher matcher1 = ExampleMatcher.matching().withIgnoreCase().withMatcher("adminUsername", matcher ->
                matcher.startsWith())
                .withIgnorePaths("adminPassword");
        Example<FairyAdmin> example = Example.of(admin,matcher1);
        List<FairyAdmin> list = fairyAdminDao.findAll(example);
        list.forEach(System.out::println);
    }

    //测试Criteria查询
    @Test
    public void criteriaQueryTest() {

        //1.新建排序
        Sort sort = new Sort(Sort.Direction.DESC,"adminUsername");
        //2.新建分页
        PageRequest pageRequest = PageRequest.of(0, 5, sort);
        //3.实现接口方法specification，添加条件
        Specification<FairyAdmin> specification = new Specification<FairyAdmin>() {
            @Override
            public Predicate toPredicate(Root<FairyAdmin> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                //3.1.混合条件查询
                Path<String> path1 = root.get("adminUsername");//一定要类型匹配
                //Path<String> path2 = root.get("adminPassword");//可以像下面直接写到参数里
                Predicate predicate = cb.and(cb.like(path1, "%yoko%"),cb.like(root.get("adminPassword"),
                        "%456%"));

                //3.2.多表查询
                //Join<FairyAdmin, FairyCat> join = root.join("catList", JoinType.INNER);
                Join<FairyAdmin, FairyCat> join = root.join(root.getModel().getList("catList",FairyCat.class), JoinType
                        .INNER);
                Path<String> catName = join.get("catName");
                Predicate predicate2 = cb.and(cb.like(path1, "%yoko%"),cb.like(root.get("adminPassword"),
                        "%456%"),cb.like(catName,"%cat%"));
                //输3.2.1出语句...inner join tab_cat c on adminId=c.admin_adminId where
                // (adminUsername like ?) and (adminPassword like ?) and (c.catName like ?) order by adminUsername
                // desc limit ?,?

                //return predicate2;

                //3.3.使用CriteriaQuery直接设置条件,不再需要返回值
                query.where(predicate2);//这里可以设置任意条查询条件
                return null;//这种方式使用JPA的API设置了查询条件，所以不需要再返回查询条件Predicate给Spring Data Jpa，故最后return null
            }
        };
        //4.执行查询
        List<FairyAdmin> list = fairyAdminDao.findAll(specification, pageRequest).getContent();
        //list.forEach(System.out::println);
        for (FairyAdmin admin:
             list) {
            System.out.println(admin);
            System.out.println(admin.getCatList());//设置了级联关系，默认自动查询了
        }
    }
}

```

---

### 四、Service

##### 1.三表外连接动态查询

> 多：级联关系中的多方；一：级联关系中的一方
>
> 双向：双向关联；单向：单向关联

**业务场景：**

* 实体HouseEntity（多，双向）中有实体CommunityEntity（一，双向）

  * 实体CommunityEntity（一，单向）中有实体AddressEntity（一）
    * 实体AddressEntity中的字段areaName表示精确到区/县的地址（如杭州市的江干区/西湖区之类的）
    * **需求：**要根据areaName查询实体HouseEntity，因此要使用到三张表的关联

* Dao层继承接口

  ```java
  @Repository
  public interface HouseDao extends JpaRepositoryImplementation<HouseEntity, Long> {}
  ```

* Service编写动态查询方法

  ```java
  /**
   * 动态创建条件
   */
  private Specification<HouseEntity> getWhereClause(final HouseEntity house) {
      return new Specification<HouseEntity>() {
          @Override
          public Predicate toPredicate(Root<HouseEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
              List<Predicate> predicates = new ArrayList<>();
              //地址head查询，三表联查
              if (!EmptyUtils.isEmpty(house.getCommunityEntity())&&!EmptyUtils.isEmpty(house.getCommunityEntity().getAddressHead()) && !EmptyUtils.isEmpty(house.getCommunityEntity().getAddressHead().getAreaName())) {//三个判空操作
                  Join<HouseEntity, CommunityEntity> entityJoin = root.join("communityEntity", JoinType.LEFT);
                  Join<Object, AddressEntity> JoinThird = entityJoin.join("addressHead", JoinType.LEFT);
                  predicates.add(cb.like(JoinThird.get("areaName").as(String.class), "%"+house.getCommunityEntity().getAddressHead().getAreaName()+"%"));
              }
              
              //售价范围，两表联查
              if (!EmptyUtils.isEmpty(house.getPriceType()) && !EmptyUtils.isEmpty(house.getPriceType().getId())) {
                  Join<HouseEntity, DictEntity> join = root.join("priceType", JoinType.LEFT);
                  predicates.add(cb.equal(join.get("id").as(Long.class), house.getPriceType().getId()));
              }
              
              //其它查询条件略······
  
              Predicate[] array = new Predicate[predicates.size()];
              return query.where(predicates.toArray(array)).getRestriction();
          }
      };
  }
  /**
   * 查询方法
   * @param houseEntity
   * @param sort
   * @param page
   * @param pageSize
   * @return
   */
  @Override
  public Page<HouseEntity> findByHouseByPage(HouseEntity houseEntity, Sort sort, Integer page, Integer pageSize) {
  
      try {
          PageRequest pageRequest = PageRequest.of(page - 1, pageSize, sort);
          Specification<HouseEntity> specification = getWhereClause(houseEntity);
          Page<HouseEntity> pageModel = houseDao.findAll(specification, pageRequest);
          return pageModel;
      } catch (Exception e) {
          e.printStackTrace();
          return null;
      }
  }
  ```

  Controller

  ```java
  @Autowired
  private HouseService houseService;
  
  @RequestMapping("toSecondList")
  public ModelAndView toSecondListPage(HouseEntity houseSearch, @RequestParam(value = "sortField", defaultValue = "createTime") String sortField, @RequestParam(defaultValue = "DESC") String order) {
      //仅显示关键代码，其余略······
      
      //2.2.设置排序,三个循环防止判断攻击
      Sort sort = null;
      if (order.equalsIgnoreCase("DESC")) {
          sort = Sort.by(Sort.Direction.DESC, sortField);
      } else if (order.equalsIgnoreCase("ASC")) {
          sort = Sort.by(Sort.Direction.ASC, sortField);
      } else {
          sort = Sort.by(Sort.Direction.DESC, sortField);
      }
  
      //3.执行动态查询
      Page<HouseEntity> pageModel = houseService.findByHouseByPage(houseSearch, sort, 1, 10);
      List<HouseEntity> list = pageModel.getContent();
      for (HouseEntity h :
              list) {
          System.out.println(h);
          System.out.println(h.getCommunityEntity().getAddressHead().getAreaName());
      }
  
      //4.返回视图模型
      ModelAndView modelAndView = new ModelAndView("user/SecondHousePage");
      //4.1.分页对象存入域
      modelAndView.addObject("pageModel", pageModel);
  
      return modelAndView;
  }
  ```



##### 2.房源字典表信息Redis处理

1. 实体对象需要序列化

   - 在父类BaseEntity中继承Serializable

     ```java
     @MappedSuperclass//表明这是父类，可以将属性映射到子类中使用JPA生成表
     public abstract class BaseEntity implements Serializable
     ```

2. SecondHouseController

   ```java
   @Autowired
   private RedisTemplate redisTemplate;
   
   //首页搜索进入二手房列表
   @RequestMapping("toSecondList")
   public ModelAndView toSecondListPage(HouseEntity houseSearch, @RequestParam(value = "sortField", defaultValue = "createTime") String sortField, @RequestParam(defaultValue = "DESC") String order) {
   
       //1.初始化houseDict,从Redis获取,Redis无从数据库获取
       Map<String, List<DictEntity>> dictMap = null;
       try {
           dictMap = (Map<String, List<DictEntity>>) redisTemplate.opsForValue().get("houseDict");
           if (dictMap == null) {
               dictMap = this.handleSearchMap();
               System.out.println("字典表从数据库查询的");
               redisTemplate.opsForValue().set("houseDict",dictMap);
           } else {
               System.out.println("字典表从Redis查询的");
           }
       } catch (Exception e) {
           e.printStackTrace();
       }
       
    	//这里其它代码省略······
       
       //4.3.字典表存入域
       modelAndView.addObject("dictMap", dictMap);
   
       return modelAndView;
   }
   ```



###### Redis扩展

> [SpringBoot整合Redis及Redis工具类撰写](https://www.cnblogs.com/zeng1994/p/03303c805731afc9aa9c60dbbd32a323.html) 
>
> [RedisTemplate用法详解](<https://blog.csdn.net/weixin_40461281/article/details/82011670>) 
>
> [Redis官方API](<https://docs.spring.io/spring-data/redis/docs/current/api/org/springframework/data/redis/core/RedisTemplate.html>) 
>
> [W3C文档](<https://www.runoob.com/redis/lists-ltrim.html>) 

* Redis Ltrim 命令

  > Redis Ltrim 对一个列表进行修剪(trim)，就是说，让列表只保留指定区间内的元素，不在指定区间之内的元素都将被删除。
  >
  > 下标 0 表示列表的第一个元素，以 1 表示列表的第二个元素，以此类推。 你也可以使用负数下标，以 -1 表示列表的最后一个元素， -2 表示列表的倒数第二个元素，以此类推。



##### 3.双表外连接动态查询

Service

```java
@Override
public Page<AgentEntity> findAllByPage(AgentEntity agent,Sort sort, Integer page, Integer pageSize) {

    //1.创建排序，交给Controller创建了
    //2.创建分页对象,page是从0开始
    PageRequest pageRequest = PageRequest.of(page - 1, pageSize, sort);
    //3.查询<1.条件对象:下面的方法getWhereClause已经封装好 2.page对象:里面有分页信息和排序信息> 返回pageBean
    Page<AgentEntity> pageModel = agentDao.findAll(getWhereClause(agent), pageRequest);
    return pageModel;
}

/**
 * 动态创建条件
 */
private Specification<AgentEntity> getWhereClause(final AgentEntity searchAgent) {
    return new Specification<AgentEntity>() {
        @Override
        public Predicate toPredicate(Root<AgentEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

            //1.创建条件列表
            List<Predicate> predicates = new ArrayList<Predicate>();
            //2.遍历对象依次增加条件
            
            //-----普通字段开始-----
            //2.1.其它字段略······
            //2.2.按手机号phone
            if (!EmptyUtils.isEmpty(searchAgent.getPhone())) {
                predicates.add(cb.equal(root.get("phone").as(String.class), searchAgent.getPhone()));
            }
            //2.3.按用户名username模糊查询
            if (!EmptyUtils.isEmpty(searchAgent.getUsername())) {
                predicates.add(cb.like(root.get("username").as(String.class),"%"+searchAgent.getUsername()+"%"));
            }
            //-----普通字段结束-----

            //-----一对一的实体属性开始-----
            //2.5.按级别grade
            if (!EmptyUtils.isEmpty(searchAgent.getGrade())) {
                Join<AgentEntity,DictEntity> entityJoin = root.join("grade",JoinType.LEFT);
                //方式一：做好左外连接后，根据连接实体中的id（实际上是连接的实体DictEntity的id）获取表达式
                predicates.add(cb.equal(entityJoin.get("id").as(Long.class), searchAgent.getGrade().getId()));
            }
            //2.6.按能力值abilityTag
            if (!EmptyUtils.isEmpty(searchAgent.getAbilityTag())) {
                Join<AgentEntity,DictEntity> entityJoin = root.join("abilityTag",JoinType.LEFT);
                //方式二：做好左外连接后，直接根据连接实体的类获取表达式
                predicates.add(cb.equal(root.get("abilityTag").as(DictEntity.class), searchAgent.getAbilityTag()
                        .getId()));
            }
            //2.7.其它条件略······
            //-----一对一的实体属性结束-----
            
            //3.将条件转化返回
            Predicate[] predicateArray = new Predicate[predicates.size()];
            return query.where(predicates.toArray(predicateArray)).getRestriction();
        }
    };
}
```

Controller

```java
@RequestMapping("user/personalAgent")
public ModelAndView toPersonalAgent(Model model) {
    AgentEntity test = new AgentEntity();
    test.setUsername("yoko");
    //创建排序对象，使用字段“score”降序
    Sort sort = Sort.by(Sort.Direction.DESC, "score");
    Page<AgentEntity> pageModel = agentService.findAllByPage(test, sort, 1, 5);//查询
    List<AgentEntity> list = pageModel.getContent();//获取实体列表
    list.forEach(System.out::println);
    model.addAttribute("list", list);//添加到域
    return new ModelAndView("user/personal-center-agent");//转发
}
```



---

### 五、Controller

##### 1.CDN

开发版

```html
<link href="https://cdn.bootcss.com/twitter-bootstrap/3.4.0/css/bootstrap.css" rel="stylesheet">
<script src="https://cdn.bootcss.com/jquery/3.4.0/jquery.js"></script>
<script src="https://cdn.bootcss.com/twitter-bootstrap/3.4.0/js/bootstrap.js"></script>
```

生产版

```html
<link href="https://cdn.bootcss.com/twitter-bootstrap/3.4.0/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.bootcss.com/jquery/3.4.0/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/twitter-bootstrap/3.4.0/js/bootstrap.min.js"></script>
```

七牛云js

```html
<script src="https://unpkg.com/qiniu-js@2.5.4/dist/qiniu.min.js"></script>
```



##### 2.a标签转post方式

```html
<ul class="list-inline" >
        <%--添加隐藏表单将a标签转换成form--%>
        <form action="/second/toSecondList" method="post" id="a-form">
            <input type="hidden " name="communityEntity.addressHead.areaName" value="${houseSearch.communityEntity.addressHead.areaName}">
            <input type="hidden" name="sortField">
        </form>
        <script>
            function atoForm(obj) {
                var field = $(obj).attr("data-field");
                $("#a-form").children("input[name='sortField']").val(field);
                console.log($("#a-form").children("input[name='sortField']").val())
                $("#a-form").submit();
                return false;
            }
        </script>
        <li id="fist_li" class="li">
            <a class="sencondary-a" href="#" onclick="atoForm(this)" id="fist_a">默认排序</a>
        </li>
        <li class="li">
            <a class="sencondary-a" href="#" data-field="createTime" onclick="atoForm(this)">最新</a>
        </li>
        <li class="li">
            <a class="sencondary-a" data-field="price" href="#" onclick="atoForm(this)">价格</a>
        </li>
        <li class="li">
            <a class="sencondary-a" data-field="traffic" href="#" onclick="atoForm(this)">访问量最多</a>
        </li>
</ul>
```



##### 3.JPA Sort使用关联表的字段进行排序

> [jpa Sort 使用关联表的字段排序](<https://www.twblogs.net/a/5b89f8db2b71775d1ce4c064/zh-cn>) 

* 直接`实体属性名.该实体的属性` 即可

  CommunityEntity

  ```java
  public class CommunityEntity{
      private AddressEntity addressHead;
  }
  ```

  AddressEntity

  ```java
  public class AddressEntity{
      private Date createTime;
  }
  ```

  Controller

  ```java
  Sort sort = Sort.by(Sort.Direction.DESC, "addressHead.createTime");
  ```



##### 4.页面动态导航

controller

```java
package cn.dmdream.controller;

import cn.dmdream.entity.AddressEntity;
import cn.dmdream.entity.CommunityEntity;
import cn.dmdream.entity.DictEntity;
import cn.dmdream.entity.HouseEntity;
import cn.dmdream.service.CommunityService;
import cn.dmdream.service.DictService;
import cn.dmdream.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/second")
public class SecondHouseController {

    @Autowired
    private HouseService houseService;
    @Autowired
    private CommunityService communityService;
    @Autowired
    private DictService dictService;
    @Autowired
    private RedisTemplate redisTemplate;

    //首页搜索进入二手房列表
    @RequestMapping("toSecondList")
    public ModelAndView toSecondListPage(HouseEntity houseSearch, @RequestParam(value = "sortField", defaultValue = "createTime") String sortField, @RequestParam(defaultValue = "DESC") String order) {

        //1.初始化houseDict,从Redis获取,Redis无从数据库获取
        Map<String, List<DictEntity>> dictMap = null;
        try {
            dictMap = (Map<String, List<DictEntity>>) redisTemplate.opsForValue().get("houseDict");
            if (dictMap == null) {
                dictMap = this.handleSearchMap();
                System.out.println("字典表从数据库查询的");
                redisTemplate.opsForValue().set("houseDict",dictMap);
            } else {
                System.out.println("字典表从Redis查询的");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //System.out.println(dictMap);

        //2.执行实体的条件封装

        //System.out.println(houseSearch);

        //2.1.地址关键字查询

        //2.2.设置排序,三个循环防止判断攻击
        Sort sort = null;
        if (order.equalsIgnoreCase("DESC")) {
            sort = Sort.by(Sort.Direction.DESC, sortField);
        } else if (order.equalsIgnoreCase("ASC")) {
            sort = Sort.by(Sort.Direction.ASC, sortField);
        } else {
            sort = Sort.by(Sort.Direction.DESC, sortField);
        }
        System.out.println(sortField);
        System.out.println(order);

        //3.执行动态查询
        Page<HouseEntity> pageModel = houseService.findByHouseByPage(houseSearch, sort, 1, 10);
        List<HouseEntity> list = pageModel.getContent();
        for (HouseEntity h :
                list) {
            System.out.println(h);
            System.out.println(h.getCommunityEntity().getAddressHead().getAreaName());
        }

        //4.返回视图模型
        ModelAndView modelAndView = new ModelAndView("user/SecondHousePage");
        //4.1.分页对象存入域
        modelAndView.addObject("pageModel", pageModel);
        //4.2.将house存入域
        modelAndView.addObject("houseSearch", houseSearch);
        //4.3.字典表存入域
        modelAndView.addObject("dictMap", dictMap);
        //4.4.搜索域存入域
        modelAndView.addObject("sortField", sortField);

        return modelAndView;
    }

    //动态导航数据查询
    public Map<String, List<DictEntity>> handleSearchMap() {
        Map<String, List<DictEntity>> map = new HashMap<String, List<DictEntity>>();
        //楼层
        List<DictEntity> loucen = dictService.findAllByTypeNum(100001);
        map.put("楼层", loucen);
        //朝向
        List<DictEntity> chaoxiang = dictService.findAllByTypeNum(100002);
        map.put("朝向", chaoxiang);
        //楼龄
        List<DictEntity> louling = dictService.findAllByTypeNum(100003);
        map.put("楼龄", louling);
        //售价
        List<DictEntity> shoujia = dictService.findAllByTypeNum(100004);
        map.put("售价", shoujia);
        //房型
        List<DictEntity> fangxing = dictService.findAllByTypeNum(100005);
        map.put("房型", fangxing);
        //面积
        List<DictEntity> mianji = dictService.findAllByTypeNum(100006);
        map.put("面积", mianji);
        //用途
        List<DictEntity> yongtu = dictService.findAllByTypeNum(100007);
        map.put("用途", yongtu);
        //电梯
        List<DictEntity> dianti = dictService.findAllByTypeNum(100008);
        map.put("电梯", dianti);
        //装修
        List<DictEntity> zhuangxiu = dictService.findAllByTypeNum(100009);
        map.put("装修", zhuangxiu);
        //供暖
        List<DictEntity> gongnuan = dictService.findAllByTypeNum(100010);
        map.put("供暖", gongnuan);
        //权属
        List<DictEntity> quanshu = dictService.findAllByTypeNum(100011);
        map.put("权属", quanshu);
        //楼房类型
        List<DictEntity> houseType = dictService.findAllByTypeNum(100015);
        map.put("楼房类型", houseType);

        return map;
    }

}
```

jsp

```jsp
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" %>
<%@page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title></title>
    <link rel="stylesheet" type="text/css" href="../../../css/bootstrap.css"/>
    <link rel="stylesheet" type="text/css" href="../../../css/crumbs.css"/>
</head>

<body>
<div id="crumbs-table-container" style="width: 70%;">
    <form action="/second/toSecondList" method="post" id="multi-form">
        <input type="hidden" name="communityEntity.addressHead.areaName"
               value="${houseSearch.communityEntity.addressHead.areaName}">
        <input type="hidden" name="priceType.id" value="${houseSearch.priceType.id}">
        <input type="hidden" name="houseType.id" value="${houseSearch.houseType.id}">
        <input type="hidden" name="areaType.id" value="${houseSearch.areaType.id}">
        <input type="hidden" name="floorType.id" value="${houseSearch.floorType.id}">
        <input type="hidden" name="orieType.id" value="${houseSearch.orieType.id}">
        <input type="hidden" name="ageType.id" value="${houseSearch.ageType.id}">
        <input type="hidden" name="sortField" value="${sortField}">

        <table class="table table-bordered" id="crumbs">
            <tr>
                <th>位置</th>
                <td>区域</td>
            </tr>
            <tr id="district-level">
                <th></th>
                <td>朝阳区</td>
                <td>二道区</td>
                <td>高新区</td>
                <td>经开区</td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
            </tr>
            <tr>
                <th>楼层</th>
                <c:forEach items="${dictMap['楼层']}" var="dict">
                    <td>
                        <input
                                <c:if test="${houseSearch.floorType.id == dict.id}">checked</c:if>
                                data-typeNum="${dict.typeNum}" data-id="${dict.id}" type="checkbox">
                        <span>${dict.typeDescription}</span>
                    </td>
                </c:forEach>
            </tr>
            <tr>
                <th>朝向</th>
                <c:forEach items="${dictMap['朝向']}" var="dict">
                    <td>
                        <input
                                <c:if test="${houseSearch.orieType.id == dict.id}">checked</c:if>
                                data-typeNum="${dict.typeNum}" data-id="${dict.id}" type="checkbox">
                        <span>${dict.typeDescription}</span>
                    </td>
                </c:forEach>
            </tr>
            <tr>
                <th>楼龄</th>
                <c:forEach items="${dictMap['楼龄']}" var="dict">
                    <td>
                        <input
                                <c:if test="${houseSearch.ageType.id == dict.id}">checked</c:if>
                                data-typeNum="${dict.typeNum}" data-id="${dict.id}" type="checkbox">
                        <span>${dict.typeDescription}</span>
                    </td>
                </c:forEach>
            </tr>
            <tr>
                <th>售价</th>
                <c:forEach items="${dictMap['售价']}" var="dict">
                    <td>
                        <input
                                <c:if test="${houseSearch.priceType.id == dict.id}">checked</c:if>
                                data-typeNum="${dict.typeNum}" data-id="${dict.id}" type="checkbox">
                        <span>${dict.typeDescription}</span>
                    </td>
                </c:forEach>
            </tr>
            <tr>
                <th>房型</th>
                <c:forEach items="${dictMap['房型']}" var="dict">
                    <td>
                        <input
                                <c:if test="${houseSearch.houseType.id == dict.id}">checked</c:if>
                                data-typeNum="${dict.typeNum}" data-id="${dict.id}" type="checkbox">
                        <span>${dict.typeDescription}</span>
                    </td>
                </c:forEach>
            </tr>
            <tr>
                <th>面积</th>
                <c:forEach items="${dictMap['面积']}" var="dict">
                    <td>
                        <input
                                <c:if test="${houseSearch.areaType.id == dict.id}">checked</c:if>
                                data-typeNum="${dict.typeNum}" data-id="${dict.id}" type="checkbox">
                        <span>${dict.typeDescription}</span>
                    </td>
                </c:forEach>
            </tr>
        </table>
    </form>
</div>
<script src="../../../js/crumbs.js" type="text/javascript" charset="utf-8"></script>
</body>

</html>
```

js

```js
$(function() {
	$(".table-bordered>tbody>tr>td").click(function() {
		var flag = $(this).children("input").is(':checked');
		if(!flag)
			$(this).children("input").prop("checked", true);
		if(flag)
			$(this).children("input").prop("checked", false);

        var id = $(this).children("input").attr("data-id");
        var typeNum = $(this).children("input").attr("data-typeNum");
        console.log(id, typeNum);
		if(!flag){
            if(typeNum == 100001){
                $("#multi-form").children("input[name='floorType.id']").val(id);
                console.log("表单成功赋值:"+$("#multi-form").children("input[name='floorType.id']").val());
            }
            if(typeNum == 100002){
                $("#multi-form").children("input[name='orieType.id']").val(id);
                console.log("表单成功赋值:"+$("#multi-form").children("input[name='orieType.id']").val());
            }
            if(typeNum == 100003){
                $("#multi-form").children("input[name='ageType.id']").val(id);
                console.log("表单成功赋值:"+$("#multi-form").children("input[name='ageType.id']").val());
            }
            if(typeNum == 100004){
                $("#multi-form").children("input[name='priceType.id']").val(id);
                console.log("表单成功赋值:"+$("#multi-form").children("input[name='priceType.id']").val());
            }
            if(typeNum == 100005){
                $("#multi-form").children("input[name='houseType.id']").val(id);
                console.log("表单成功赋值:"+$("#multi-form").children("input[name='houseType.id']").val());
            }
            if(typeNum == 100006){
                $("#multi-form").children("input[name='areaType.id']").val(id);
            }
		}else{
            if(typeNum == 100001){
                $("#multi-form").children("input[name='floorType.id']").val(null);
            }
            if(typeNum == 100002){
                $("#multi-form").children("input[name='orieType.id']").val(null);
            }
            if(typeNum == 100003){
                $("#multi-form").children("input[name='ageType.id']").val(null);
            }
            if(typeNum == 100004){
                $("#multi-form").children("input[name='priceType.id']").val(null);
            }
            if(typeNum == 100005){
                $("#multi-form").children("input[name='houseType.id']").val(null);
            }
            if(typeNum == 100006){
                $("#multi-form").children("input[name='areaType.id']").val(null);
            }
        }
        $("#multi-form").submit();
	});

});
```





### 六、Utils

##### 1.腾讯云短信

导包

- maven

  ```xml
  <!--腾讯云短信-->
  <dependency>
      <groupId>com.github.qcloudsms</groupId>
      <artifactId>qcloudsms</artifactId>
      <version>1.0.6</version>
  </dependency>
  ```

工具类

```java
package cn.dmdream.utils;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import org.json.JSONException;

import java.io.IOException;

public class SmsUtilsTencent {

    // 短信应用 SDK AppID
    private static final int appid = 不告诉你; // SDK AppID 以1400开头

    // 短信应用 SDK AppKey
    private static final String appkey = "不告诉你";

    // 注册短信模板 ID，需要在短信应用中申请
    private static final int templateIdRegister = 不告诉你; // NOTE: 这里的模板 ID`7839`只是示例，真实的模板 ID 需要在短信控制台中申请

    // 登录短信模板
    private static final int templateIdLogin = 不告诉你; // NOTE: 这里的模板 ID`7839`只是示例，真实的模板 ID 需要在短信控制台中申请

    // 签名
    private static final String smsSign = "不告诉你"; // NOTE: 签名参数使用的是`签名内容`，而不是`签名ID`。这里的签名"腾讯云"只是示例，真实的签名需要在短信控制台申请

    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {

        //发送注册验证码
        //String code = SmsUtilsTencent.sentRegisterSms("18989849258");
        //发送登录验证码
        String code = SmsUtilsTencent.sentLoginSms("18989849258");
        System.out.println(code);
    }

    /**
     * 发送注册短信
     * @param phone
     * @return 激活校验码
     */
    public static String sentRegisterSms(String phone) {

        String code = String.valueOf(genCode());
        try {
            String[] params = {code,"5"};
            SmsSingleSender ssender = new SmsSingleSender(appid, appkey);
            /**
             * 指定模板单发
             * @param nationCode 国家码，如 86 为中国
             * @param phoneNumber 不带国家码的手机号
             * @param templateId 信息内容
             * @param params 模板参数列表，如模板 {1}...{2}...{3}，那么需要带三个参数
             * @param sign 签名，如果填空，系统会使用默认签名
             * @param extend 扩展码，可填空
             * @param ext 服务端原样返回的参数，可填空
             */
            SmsSingleSenderResult result = ssender.sendWithParam("86", phone,
                    templateIdRegister, params, smsSign, "", "");  // 签名参数未提供或者为空时，会使用默认签名发送短信
            System.out.println(result);//
            return code;
        } catch (HTTPException e) {
            // HTTP 响应码错误
            e.printStackTrace();
        } catch (JSONException e) {
            // JSON 解析错误
            e.printStackTrace();
        } catch (IOException e) {
            // 网络 IO 错误
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 发送登录短信
     * @param phone
     * @return 激活校验码
     */
    public static String sentLoginSms(String phone) {

        String code = String.valueOf(genCode());
        try {
            String[] params = {code,"5"};
            SmsSingleSender ssender = new SmsSingleSender(appid, appkey);
            SmsSingleSenderResult result = ssender.sendWithParam("86", phone,
                    templateIdLogin, params, smsSign, "", "");
            System.out.println(result);//
            return code;
        } catch (HTTPException e) {
            // HTTP 响应码错误
            e.printStackTrace();
        } catch (JSONException e) {
            // JSON 解析错误
            e.printStackTrace();
        } catch (IOException e) {
            // 网络 IO 错误
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 随机生成6位校验码
     * @return
     */
    public static int genCode(){
        int code = (int)((Math.random()*9+1)*100000);
        return code;
    }

}

```



##### 2.七牛云对象储存

> [上传图片到七牛云（前端和后端）](<https://blog.csdn.net/Code_shadow/article/details/81454334>) 
>
> [七牛云 上传图片到七牛云并返回图片URL-后端](<https://blog.csdn.net/weixin_37264997/article/details/82285343>) 

- 存储空间名称

  fairyhouse

- 外链域名

  有两个，都可以

  1. img.dmdream.cn
  2. pspq953ox.bkt.clouddn.com

- 授权密钥

  ```java
  // ******的内容需要查看七牛云账号的相关信息
  private static final String accessKey = "不告诉你";    //访问秘钥
  private static final String secretKey = "不告诉你";    //授权秘钥
  private static final String bucket = "fairyhouse";       //存储空间名称
  private static final String domain = "不告诉你";       //外链域名
  ```



###### 1.前端API文档

> <https://developer.qiniu.com/kodo/sdk/1283/javascript> 



###### 2.示例代码(前端)

1.pom.xml

```xml
<!--最新-->
<dependency>
  <groupId>com.qiniu</groupId>
  <artifactId>qiniu-java-sdk</artifactId>
  <version>[7.2.0, 7.2.99]</version>
</dependency>
```

2.Controller

```java
package cn.dmdream.controller;

import com.qiniu.util.Auth;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
public class QiniuUpload {

    // ******的内容需要查看七牛云账号的相关信息
    private static final String accessKey = "不告诉你";    //访问秘钥
    private static final String secretKey = "不告诉你";    //授权秘钥
    private static final String bucket = "fairyhouse";       //存储空间名称
    private static final String domain = "http://不告诉你/";       //外链域名


    /**
     * 跳转页面
     */
    @RequestMapping("/file")
    public ModelAndView toFilePage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("jsp/fileUpload.jsp");
        //modelAndView.setViewName("jsp/helloworld.jsp");
        return modelAndView;
    }

    /**
     * 七牛云上传生成凭证
     *
     * @throws Exception
     */
    @RequestMapping("/QiniuUpToken")
    @ResponseBody
    public Map<String, Object> QiniuUpToken(@RequestParam String suffix) throws Exception{
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            //验证七牛云身份是否通过
            Auth auth = Auth.create(accessKey, secretKey);
            //生成凭证
            String upToken = auth.uploadToken(bucket);
            result.put("token", upToken);
            //存入外链默认域名，用于拼接完整的资源外链路径
            result.put("domain", domain);

            // 是否可以上传的图片格式
            /*boolean flag = false;
            String[] imgTypes = new String[]{"jpg","jpeg","bmp","gif","png"};
            for(String fileSuffix : imgTypes) {
                if(suffix.substring(suffix.lastIndexOf(".") + 1).equalsIgnoreCase(fileSuffix)) {
                    flag = true;
                    break;
                }
            }
            if(!flag) {
                throw new Exception("图片：" + suffix + " 上传格式不对！");
            }*/

            //生成实际路径名
            String randomFileName ="house/" + UUID.randomUUID().toString() + suffix;
            result.put("imgUrl", randomFileName);
            result.put("success", 1);
        } catch (Exception e) {
            result.put("message", "获取凭证失败，"+e.getMessage());
            result.put("success", 0);
        } finally {
            return result;
        }
    }

}

```

3.jsp

```jsp
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>七牛云前端方式图片上传</title>
    <script src="https://cdn.bootcss.com/jquery/3.4.0/jquery.min.js"></script>
    <script src="https://unpkg.com/qiniu-js@2.5.4/dist/qiniu.min.js"></script>
</head>
<body>

<input type="file" name="image" id="file" accept="image/*">
<input type="button" id="upload" value="upload">
<div id="processImg"></div>
<img id="image" src="#" alt="">

</body>
<script type="text/javascript">

    $(function () {
        $("#upload").on("click", function () {
            var obj = $("#file");
            var fileName = obj.val();		                                           //上传的本地文件绝对路径
            var suffix = fileName.substring(fileName.lastIndexOf("."), fileName.length);//后缀名
            var file = obj.get(0).files[0];	                                           //上传的文件
            var size = file.size > 1024 ? file.size / 1024 > 1024 ? file.size / (1024 * 1024) > 1024 ? (file.size / (1024 * 1024 * 1024)).toFixed(2) + 'GB' : (file.size
                / (1024 * 1024)).toFixed(2) + 'MB' : (file.size
                / 1024).toFixed(2) + 'KB' : (file.size).toFixed(2) + 'B';		   //文件上传大小
            //七牛云上传
            $.ajax({
                type: 'post',
                url: "/QiniuUpToken",
                data: {"suffix": suffix},
                dataType: 'json',
                success: function (result) {
                    if (result.success == 1) {
                        var observer = {                         //设置上传过程的监听函数
                            next(result) {                        //上传中(result参数带有total字段的 object，包含loaded、total、percent三个属性)
                                var process = Math.floor(result.total.percent);//查看进度[loaded:已上传大小(字节);total:本次上传总大小;percent:当前上传进度(0-100)]
                                $("#processImg").html(process);
                            },
                            error(err) {                          //失败后
                                alert(err.message);
                            },
                            complete(res) {                       //成功后
                                // ?imageView2/2/h/100：展示缩略图，不加显示原图
                                // ?vframe/jpg/offset/0/w/480/h/360：用于获取视频截图的后缀，0：秒，w：宽，h：高
                                //$("#image").attr("src", result.domain + result.imgUrl + "?imageView2/2/w/400/h/400/q/100");
                                console.log("上传成功的结果:")
                                //返回了hash和文件地址后半部分
                                //{hash: "FgO9AXuUxlXPRxvYIDheZKeXYvHM", key: "house/90b20d91-fcbd-4a7a-96e4-e63fcaa5a60d.png"}
                                console.log(res);
                                $("#image").attr("src", result.domain + result.imgUrl + "?imageslim");//图片压缩
                            }
                        };
                        var putExtra = {
                            fname: "",                          //原文件名
                            //fname: fileName,
                            params: {},                         //用来放置自定义变量
                            //params: {"username" : "1"},
                            mimeType: ["image/png", "image/jpeg", "image/gif"]
                            //mimeType: null                      //限制上传文件类型
                        };
                        var config = {
                            region: qiniu.region.z0,             //存储区域(z0:代表华东;z2:代表华南,不写默认自动识别)
                            concurrentRequestLimit: 3            //分片上传的并发请求量
                        };
                        var observable = qiniu.upload(file, result.imgUrl, result.token, putExtra, config);
                        var subscription = observable.subscribe(observer);          // 上传开始
                        // 取消上传
                        // subscription.unsubscribe();
                    } else {
                        alert(result.message);                  //获取凭证失败
                    }
                }, error: function () {                             //服务器响应失败处理函数
                    alert("服务器繁忙");
                }
            });
        })
    })
</script>
</html>
```





##### 3.空对象判断

```java
package cn.dmdream.utils;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EmptyUtils {

    /**
     * 判断对象是否为空
     * @param object
     * @return
     */
    public static boolean isEmpty(Object object) {

        try {
            //普通对象
            if (object == null) {
                return true;
            }

            //字符串
            if (object instanceof String){
                if (object.toString().trim().equals("") || object == null) {
                    return true;
                }
            }

            //集合
            if (object instanceof Collection || object instanceof Map) {

                if (object instanceof Map) {
                    return ((Map) object).isEmpty();
                }

                if (((Collection) object).size() == 0){
                    return true;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }
}

```



##### 4.Json交互实体

JsonMsg

```java
package cn.dmdream.utils;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JsonMsg {

    public final static int STATUS_SUCCESS = 200;//成功标志
    public final static int STATUS_FAIL = 400;//失败标志
    public final static int STATUS_ERROR = 500;//服务出错
    public final static int STATUS_AUTH = 100;//未授权服务

    private int status;//标志位,代表处理结果
    private String msg;//提示信息
    private Object data;//数据

    /*
     * 成功方法
     */
    public static JsonMsg makeSuccess(String msg, Object data){
        JsonMsg jsonMsg = new JsonMsg();
        jsonMsg.setStatus(STATUS_SUCCESS);
        jsonMsg.setData(data);
        jsonMsg.setMsg(msg);
        return jsonMsg;
    }
    /*
     * 失败方法
     */
    public static JsonMsg makeFail (String msg, Object data){
        JsonMsg jsonMsg = new JsonMsg();
        jsonMsg.setStatus(STATUS_FAIL);
        jsonMsg.setData(data);
        jsonMsg.setMsg(msg);
        return jsonMsg;
    }
    /*
     * 系统错误
     */
    public static JsonMsg makeError (String msg, Object data){
        JsonMsg jsonMsg = new JsonMsg();
        jsonMsg.setStatus(STATUS_ERROR);
        jsonMsg.setData(data);
        jsonMsg.setMsg(msg);
        return jsonMsg;
    }
    /*
     * 无权限
     */
    public static JsonMsg makeAuth (String msg, Object data){
        JsonMsg jsonMsg = new JsonMsg();
        jsonMsg.setStatus(STATUS_AUTH);
        jsonMsg.setData(data);
        jsonMsg.setMsg(msg);
        return jsonMsg;
    }
}

```



##### 5.分页模型

PageModel

```java
package cn.dmdream.utils;

import java.util.List;

/*
 * 页面模型,用于封装页面的数据
 * 包含了数据对象
 * 包含了页面的基础信息 比如说 页面大小 当前页面 总页面 总记录条数
 */
public class PageModel<E> {

    //结果
    private List<E> list;
    //记录总条数
    private int totalCount;
    //当前页
    private int currPage;
    //页面大小
    private int pageSize;
    //总页数
    private int totalPage;
    public List<E> getList() {
        return list;
    }
    public void setList(List<E> list) {
        this.list = list;
    }
    public int getTotalCount() {
        return totalCount;
    }
    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
    public int getCurrPage() {
        if (currPage < 1)
            currPage = 1;
        if (currPage > totalPage)
            currPage = totalPage;
        return currPage;
    }
    public void setCurrPage(int currPage) {
        this.currPage = currPage;
    }
    public int getPageSize() {
        if (pageSize < 1)
            pageSize = 1;
        return pageSize;
    }
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    public int getTotalPage() {
        return totalPage;
    }
    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    /**
     * 自动包装计算PageModel
     * @param currPage 设定默认的page首页/开始页信息
     * @param pageSize 设定默认的pageSize信息
     * @param totalCount 设定总记录数
     * @param list 数据集
     * @param pageModel 要包装的PageModel
     */
    public static void wrapPageModel(int currPage , int pageSize,int totalCount,List list,PageModel<?> pageModel){
        //计算总页数
        int totalPage = totalCount%pageSize > 0 ? totalCount/pageSize + 1: totalCount/pageSize;
        //封装分页参数
        pageModel.setCurrPage(currPage);
        pageModel.setPageSize(pageSize);
        pageModel.setTotalCount(totalCount);
        pageModel.setTotalPage(totalPage);
        pageModel.setList(list);
    }
    @Override
    public String toString() {
        return "PageModel [list=" + list + ", totalCount=" + totalCount + ", currPage=" + currPage + ", pageSize="
                + pageSize + ", totalPage=" + totalPage + "]";
    }

}

```



##### 6.封装Ajax

1. 新建独立的 `common.js` 

   ```js
   //通用ajax请求函数,需要用promise接收
   function getPostAjaxPromise(url,data){
   	
   	return new Promise(function(res,rej){
   		$.ajax({
   			url: url,
   			data: data,
   			type: "POST",
   			success: function(data) {
   				res(data);
   			}
   		});
   	});
   }
   //通用ajax请求函数,数组版本,需要用promise接收
   function getPostAjaxPromiseForArray(url,data){
   	
   	return new Promise(function(res,rej){
   		$.ajax({
   			url: url,
   			data: data,
   			type: "POST",
   			dataType: "json",
   			traditional: true,
   			success: function(data) {
   				res(data);
   			}
   		});		
   	});
   }
   //通用ajax请求函数,文件上传版本,需要用promise接收
   function getPostAjaxPromiseForForm(url,form){
   	
   	return new Promise(function(res,rej){
   		$.ajax({
   			url: url,
   			data: form,
   			type: "POST",
   			dataType: "json",
   			contentType : false,
   			processData : false,
   			success: function(data) {
   				res(data);
   			}
   		});
   	});
   }
   ```

2. 页面请求方式

   1. 传统请求

      ```js
      //保存方法(save和update通用)
      function novelSave(novelObj, modalId) {
          var promiseObj = getPostAjaxPromise("${pageContext.request.contextPath}/adminNovel.do?method=addNovel", novelObj);
          promiseObj.then(function(res){
              console.log(res);
              if(res.status == 200) {
                  showGritter('成功', res.msg);
                  $(modalId).modal("hide");
                  setTimeout(function() {
                      window.location.reload();
                  }, 500);
              } else {
                  showGritter('失败', res.msg);
              }
          });
      }
      ```

   2. 数据含有数组对象

      ```js
      //删除函数
      function delNovels(ids, modalId) {
          var promiseObj = getPostAjaxPromiseForArray("${pageContext.request.contextPath}/adminNovel.do?method=delNovel",{novelIds:ids});
          promiseObj.then(function(res){
              console.log(res);
              if(res.status == 200) {
                  showGritter('成功', res.msg);
                  $(modalId).modal("hide");
                  setTimeout(function() {
                      window.location.reload();
                  }, 1000);
              } else {
                  showGritter('失败', res.msg);
                  $(modalId).modal("hide");
              }
          });
      }
      ```

   3. 数据为表单(文件上传必须)

      ```html
      <!-- 小说上传js -->
      <script type="text/javascript">
          var dragImgUpload = new DragImgUpload("#novelUpload", {
              callback : function(files) {
                  //回调函数，可以传递给后台等等
                  var file = files[0];
                  console.log(file.name);
                  var form = new FormData();
                  form.append("file", file);
                  if(/\.(txt|TXT|epub|EPUB|pdf|PDF|rar|RAR|zip|ZIP|7z|7Z)$/.test(file.name)){
                      showStikyGritter('消息', "正在上传文件······");
                      var formPromiseObj = getPostAjaxPromiseForForm("${pageContext.request.contextPath}/adminNovel.do?method=ajaxFileUpload",form);
                      formPromiseObj.then(function(res){
                          removeAllGritters()
                          setTimeout(function() {showGritter('消息', "文件上传成功！");}, 500);
                          console.log(res);
                          $("#novelDownloadurlId").val(res.data)
                          $("#reShowFileNamelId").val(file.name);
                          $("#reShowFileNamelId").attr("type","text");
                      });
                  }else{
                      showGritter('错误',"不支持的文件格式!支持以下格式:txt、epub、pdf、rar、zip、7z")
                      return false;
                  }
              //格式判断完毕
              }
              //回调函数完毕
          })
      </script>
      <!-- 封面上传js -->
      <script type="text/javascript">
          var dragImgUpload = new DragImgUpload("#picUpload", {
              callback : function(files) {
                  //回调函数，可以传递给后台等等
                  var file = files[0];
                  console.log(file.name);
                  var form = new FormData();
                  form.append("file", file);
                  if(/\.(gif|jpg|jpeg|png|GIF|JPG|PNG)$/.test(file.name)){
                      showStikyGritter('消息',"正在上传图片······");
                      var formPromiseObj = getPostAjaxPromiseForForm("${pageContext.request.contextPath}/adminNovel.do?method=ajaxFileUpload",form);
                      formPromiseObj.then(function(res){
                          removeAllGritters();
                          setTimeout(function() {showGritter('消息',"图片上传成功！");}, 500);
                          console.log(res);
                          $("#novelCoverId").val(res.data)
                      });
                  }else{
                      showGritter('错误',"不支持的图片格式!支持以下格式:gif、jpg、jpeg、png");
                      return false;
                  }
              //格式判断完毕
              }
              //回调函数完毕
          })
      </script>
      ```



##### 7.图片验证码生成工具

```java
package cn.dmdream.utils;


import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class VeriCode {

    public static void drawPic(HttpServletRequest request,HttpServletResponse response) {
        // 使用java图形界面技术绘制一张图片

        int charNum = 4;
        int width = 30 * 4;
        int height = 30;

        // 1. 创建一张内存图片
        BufferedImage bufferedImage = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_RGB);

        // 2.获得绘图对象
        Graphics graphics = bufferedImage.getGraphics();

        // 3、绘制背景颜色
        graphics.setColor(Color.YELLOW);
        graphics.fillRect(0, 0, width, height);

        // 4、绘制图片边框
        graphics.setColor(Color.BLUE);
        graphics.drawRect(0, 0, width - 1, height - 1);

        // 5、输出验证码内容
        graphics.setColor(Color.RED);
        graphics.setFont(new Font("宋体", Font.BOLD, 20));

        // 随机输出4个字符
        Graphics2D graphics2d = (Graphics2D) graphics;
        String s = "ABCDEFGHGKLMNPQRSTUVWXYZ23456789";
        Random random = new Random();
        //session中要用到
        String msg="";
        int x = 5;
        for (int i = 0; i < 4; i++) {
            int index = random.nextInt(32);
            String content = String.valueOf(s.charAt(index));
            msg+=content;
            double theta = random.nextInt(45) * Math.PI / 180;
            //让字体扭曲
            graphics2d.rotate(theta, x, 18);
            graphics2d.drawString(content, x, 18);
            graphics2d.rotate(-theta, x, 18);
            x += 30;
        }

        // 6、绘制干扰线
        graphics.setColor(Color.GRAY);
        for (int i = 0; i < 5; i++) {
            int x1 = random.nextInt(width);
            int x2 = random.nextInt(width);

            int y1 = random.nextInt(height);
            int y2 = random.nextInt(height);
            graphics.drawLine(x1, y1, x2, y2);
        }

        // 释放资源
        graphics.dispose();

        // 图片输出 ImageIO
        try {
            request.getSession().removeAttribute("veriCode");
            request.getSession().setAttribute("veriCode",msg);
            System.out.println(request.getSession().getAttribute("veriCode"));
            ImageIO.write(bufferedImage, "jpg", response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

```

Controller

```java
package cn.dmdream.controller;

import cn.dmdream.utils.VeriCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/utils")
public class UtilsController {

    @GetMapping("code")
    public void getCode(HttpServletRequest request,HttpServletResponse response) {
        VeriCode.drawPic(request,response);
    }

}

```



##### 8.gritter提示

* 导入资源

  ```jsp
  <link href="https://cdn.bootcss.com/twitter-bootstrap/3.4.0/css/bootstrap.css" rel="stylesheet">
  <script src="https://cdn.bootcss.com/jquery/3.4.0/jquery.js"></script>
  <script src="https://cdn.bootcss.com/twitter-bootstrap/3.4.0/js/bootstrap.js"></script>
  <link rel="stylesheet" type="text/css" href="../../../js/gritter/css/jquery.gritter.css" />
  <script type="text/javascript" src="../../../js/gritter/js/jquery.gritter.js"></script>
  <script type="text/javascript" src="../../../js/common.js"></script>
  ```

* common.js编写函数

  ```js
  //gritter抽取
  //显示自动隐藏的gritter
  function showGritter(title,text){
      $.gritter.add({
          title: title,
          text: text,
          sticky: false,
          time: 3000
      });
      return false;
  }
  //不会隐藏的gritter
  function showStikyGritter(title,text){
      $.gritter.add({
          title: title,
          text: text,
          sticky: false,
          time: 3000
      });
      return false;
  }
  //隐藏所有gritter
  function removeAllGritters(){
      $.gritter.removeAll();
      return false;
  }
  ```

* 页面使用

  ```jsp
  <script>
  showGritter("消息","手机号不正确!");
  </script>
  ```

  



---

### 七、发布

* 端口 8099

  > http://你的地址:8099/ 

* nohup java -jar fairyhouse.war > fairy.txt &

* 错误一：忽略test（There are test failures）

  ```xml
  <plugin>
      <groupId>org.apache.maven.plugins</groupId>
      <artifactId>maven-surefire-plugin</artifactId>
      <configuration>
          <testFailureIgnore>true</testFailureIgnore>
      </configuration>
  </plugin>
  ```

* 错误二：五webapps文件夹

  > [【Maven】在pom.xml文件中使用resources插件的小作用](https://www.cnblogs.com/sxdcgaq8080/p/7715427.html) 

  ```xml
  <packaging>war</packaging><!--将打包声明成war-->
  ```

  

---

### 八、开发问题

##### 1.SpringBoot目录不在同级包不被扫描

> <https://blog.csdn.net/shouldnotappearcalm/article/details/78014921> 

```java
//解决:指定包扫描
package cn.dmdream.fairyhouse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"cn.dmdream"})
public class FairyhouseApplication {

    public static void main(String[] args) {
        SpringApplication.run(FairyhouseApplication.class, args);
    }

}

```



##### 2.SpringDataJPA不自动创建表

* 方式一：将spring boot的运行入口类放在**顶级包目录**下，entity、dao、service等包结构在**其子目录下**，包结构如下所示：

  * cn.dmdream
    * 入口类FairyhouseApplication.java
    * entity
    * dao
    * service
    * 。。。其它包

* 方式二：在入口类使用注解

  ```java
  @EnableJpaRepositories(basePackages = {"cn.dmdream.dao"})
  @EntityScan(basePackages = {"cn.dmdream.entity"})//注意此注解
  ```




##### 3.JPA多对一删除的问题

> [JPA根据ID删除只发出select的解决方法](<https://blog.csdn.net/liusanyu/article/details/78213169>) 

```java
/**
 * 删除维护方对象，这里维护方（cat）未设置级联删除
 */
@Test
public void 多对一删除1() {
    FairyCat cat = fairyCatDao.findByCatName("Kuku");
    System.out.println(cat);
    cat.getAdmin().getCatList().remove(cat);//由于二级缓存机制，要清空级联对象中的自己对象，要不无法删除，不会有删除语句
    //可以看到在进行上一步设置后，成功有了删除语句delete from tab_cat where catId=?
    fairyCatDao.delete(cat);//删除结果：由于未设置级联删除，即便删除的是维护方对象，也只删除了自己，不能删除Admin
}
```



##### 4.Spring Data JPA中使用JPQL语句查询问题

旧版（BUG版）实体类

```java
@Data//自动生成get/set/tostring
@Entity(name = "tab_admin")//交给jpa管理实体，并设置映射到数据库的表名（坑）
public class FairyAdmin {
	//字段省略...
}
```

Dao

```java
@Repository
public interface FairyAdminDao extends JpaRepository<FairyAdmin,Integer> {

    //使用JPQL查询
    //@Query(value = "select a from FairyAdmin a where a.adminUsername like %?1%")
    //public List<FairyAdmin> myFindAllByUsernameLike_JPQL(String username);

    @Query("select a from FairyAdmin a")
    List<FairyAdmin> myFind();
}
```

看起来一切OK？

结果：测试运行时一直提示错误

```java
java.lang.IllegalArgumentException: org.hibernate.hql.internal.ast.QuerySyntaxException
org.hibernate.hql.internal.ast.QuerySyntaxException: XXX is not mapped
```

反复的检查JPQL语法，没问题啊，网上查找类似的问题，也就是一直说需要写上实体类的类名，我也写上了啊，（我甚至还考虑到是不是LomBok的锅。。徒劳。。）但为什么还是出错呢？

**终极原因**

在JPQL语法中，`select a from 类名 a`  这语句中的`类名`其实不只是参照你的实体类名，他会优先参照的是你在实体类上使用的注解`@Entity(name = "tab_admin")`中的自定义name字段，因此，修改JPQL语句

```java
@Query("select a from tab_admin a")
List<FairyAdmin> myFind();
```

这样子终于能查询出来了！好坑啊有木有！！！花了2小时找这BUG真的难受。。。网上怎么没人和我一样碰到呢，QAQ。。

还有个建议，在实体类上不要使用`@Entity(name = "tab_admin")`来标注名称，需要指定映射的数据库名，最好使用`@Table(name="XXX")`。



##### 5.Spring Boot的JSP视图解析失败

* 遇到视图解析失败（html页面无法访问）

  > 先确定所有路径是正确的

  1. Controller上的注解@RestController 的关系

     @RestController= @Controller+ @ResponseBody。@RestController返回的是json，如果用了@RestController则不要用@Responsebody

     @ResponseBody 表示该方法的返回不会被解析为跳转, 而是直接写入http响应正文

  2. 解决方式一：

     Controller类换成@Controller注解，这是返回String视图将会正确转发页面

     ```java
     @Controller
     public class HelloWorld {
     
         @RequestMapping("/")
         public String index(){
             return "/index.html";
         }
     }
     ```

  3. 解决方式二：

     如果一定要使用@RestController注解，那不能直接返回String类型，方法修改成返回ModelAndView，这种方式也能正确进行转发

     ```java
     @RestController
     public class HelloWorld {
     
         @RequestMapping("/")
         public ModelAndView index(){
             ModelAndView mav = new ModelAndView();
             mav.setViewName("/index.html");
             return mav;
         }
     }
     ```

* Spring Boot默认是不支持JSP的，想要使用JSP，需要：

  > [Spring Boot jsp页面无法跳转问题](https://www.cnblogs.com/allinfocus/p/9830414.html) 
  * 导入jsp支持依赖，坐标

    ```xml
    <dependency>
        <groupId>org.apache.tomcat.embed</groupId>
        <artifactId>tomcat-embed-jasper</artifactId>
    </dependency>
    ```

  * 导入jstl依赖

    ```xml
    <dependency>
        <groupId>javax.servlet</groupId>
        <artifactId>jstl</artifactId>
    </dependency>
    ```




##### 6.JPA建表失败

* 在实体类使用注解@columnDefinition的时候，注意一定要按 类型开头进行定义，下面就是正确的

  ```java
  @Column(name="createTime",columnDefinition="DATETIME comment '创建时间'")
  protected Date createTime; //创建时间
  ```

* 如果定义成下面这样，就会报错误，分析sql语句可以知道，使用该注解就不会帮你默认添加类型了！

  ```java
  @Column(name="createTime",columnDefinition="comment '创建时间'")//是不会自己判断添加类型了
  protected Date createTime; //创建时间
  ```




##### 7.JPA双向关联时Json序列化失败

> <https://blog.csdn.net/tomcat_2014/article/details/50624869> 

* 在双向关系的某一方属性上使用注解

  @JsonIgnore



##### 8.EL取Set值

* 无法直接取值

* 使用循环

  ```jsp
  <c:forEach items="${house.showPics}" var="pic" begin="0" end="1">
      <img class="img" src="${pic.picUrl}" alt="${house.title}">
  </c:forEach>
  ```



##### 9.JSTL c:If 空格出错

> <https://blog.csdn.net/love_sel/article/details/80656007> 



##### 10.JPA普通保存和立即保存

- save不会立刻提交到数据库，flush则立刻提交生效，save可能只是修改在内存中的



---

### 九、其它扩展阅读

##### 1.数据库相关

* [DQL、DML、DDL、DCL的概念与区别](https://www.cnblogs.com/fan-yuan/p/7879353.html) 

* [什么是CRUD](<https://blog.csdn.net/qq_42672839/article/details/81584172>) 
  * CRUD：create 添加数据read读取数据 update 修改数据delete删除数据



##### 2.IDEA快捷使用

> [十大Intellij IDEA快捷键](<https://blog.csdn.net/dc_726/article/details/42784275>) 



##### 3.Lombok相关

> [Lombok插件的安装与使用](<https://blog.csdn.net/qq_26118603/article/details/78944704>) 
>
> [Lombok介绍、使用方法和总结](https://www.cnblogs.com/heyonggang/p/8638374.html) 
>
> [maven插件lombok](<https://blog.csdn.net/su_chunlong/article/details/78689926>) 



##### 4.IdeaGit冲突解决

> [IDEA解决git冲突](https://www.cnblogs.com/daiyanren/p/9615698.html) 



##### 5.thymeleaf

* [thymeleaf使用基础教程](<https://blog.csdn.net/quuqu/article/details/52511933>) 



---

