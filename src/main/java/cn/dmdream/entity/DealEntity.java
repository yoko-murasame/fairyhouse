package cn.dmdream.entity;

import cn.dmdream.entity.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * 成交记录表
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tab_deal")
public class DealEntity extends BaseEntity {

    //交易号、订单号
    @Column(name = "dealNumber",nullable = false,unique = true,length = 64,columnDefinition = "varchar" +
            "(64) comment'交易号、订单号'")
    private String dealNumber;

    //成交时间
    @Column(name = "dealDate",columnDefinition = "DATETIME comment'成交时间'")
    private Date dealDate;

    //完成交易的客户,多对一，维护方，无级联操作，不可为空
    @ManyToOne(fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "client",nullable = false,columnDefinition = "int comment '交易客户'")
    private ClientEntity client;

    //交易完成的房子 一对一 单向
    @OneToOne(targetEntity = HouseEntity.class,fetch = FetchType.EAGER,cascade = {CascadeType.MERGE,CascadeType
            .REFRESH,CascadeType.DETACH})
    private HouseEntity house;

    //交易见证的经纪人，多对一，维护方，无级联操作，不可为空
    @ManyToOne(fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "agent",nullable = false,columnDefinition = "int comment '见证的经纪人'")
    private AgentEntity agent;

    @Override
    public String toString() {
        return "DealEntity{" +
                "dealNumber='" + dealNumber + '\'' +
                ", dealDate=" + dealDate +
                ", client=" + client +
                ", house=" + house +
                ", agent=" + agent +
                '}';
    }
}
