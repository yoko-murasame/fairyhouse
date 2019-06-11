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
