package cn.dmdream.entity;


import cn.dmdream.entity.base.BaseUserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 客户实体类
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tab_client")
public class ClientEntity extends BaseUserEntity {

    //经纪人列表,多对多,被维护方,由经纪人维护关系
    @ManyToMany(cascade = {CascadeType.MERGE,CascadeType.REFRESH,CascadeType.DETACH},fetch = FetchType.LAZY,mappedBy = "clientEntities")
    private Set<AgentEntity> agentEntities = new HashSet<>();

    //看房的记录（实地的）,一对多,被维护方,除删除外的所有级联权限
    @OneToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.DETACH},fetch =
            FetchType.LAZY,mappedBy
            = "clientEntity")
    private List<HistoryEntity> browsingHistories = new ArrayList<>();

    //关注的小区,多对多,维护方,不可级联操作
    @ManyToMany(fetch = FetchType.LAZY)
    private Set<CommunityEntity> commCollections  = new HashSet<>();

    //收藏的房源,多对多,维护方,不可级联操作
    @ManyToMany(fetch = FetchType.LAZY)
    private Set<HouseEntity> houseEntityCollections = new HashSet<>();

    //要销售的房源(客户的房源),一对多,被维护方,全部级联操作
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "houseOwner")
    private Set<HouseEntity> houseEntitySales = new HashSet<>();

    //房源的交易记录,一对多，被维护方，不可级联操作
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "client")
    private Set<DealEntity> dealEntities = new HashSet<>();


    //用户自己的评价,一对多,被维护方,全部级联操作
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "commClient")
    private Set<EvaluationEntity> evaluationEntities = new HashSet<>();

    //这里可以扩展属性,qq,微信号等等
    @Column(name = "weChat",unique = true,columnDefinition = "varchar(255) comment '微信号'")
    private String weChat;

    @Override
    public String toString() {
        return "ClientEntity{" +
                "weChat='" + weChat + '\'' +
                ", username='" + username + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", realname='" + realname + '\'' +
                ", nickname='" + nickname + '\'' +
                ", nickpic='" + nickpic + '\'' +
                '}';
    }
}
