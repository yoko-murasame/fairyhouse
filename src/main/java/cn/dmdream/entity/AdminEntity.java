package cn.dmdream.entity;

import cn.dmdream.entity.base.BaseUserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity//交给jpa管理实体，并设置映射到数据库的表名
@Table(name = "tab_admin")
public class AdminEntity extends BaseUserEntity {

    @Column(name = "password",length = 100,nullable = false,columnDefinition = "varchar(100) comment '管理员密码'")
    private String password;

    @Override
    public String toString() {
        return "AdminEntity{" +
                "password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", realname='" + realname + '\'' +
                ", nickname='" + nickname + '\'' +
                ", nickpic='" + nickpic + '\'' +
                '}';
    }
}