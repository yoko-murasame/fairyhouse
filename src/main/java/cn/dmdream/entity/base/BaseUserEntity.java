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
