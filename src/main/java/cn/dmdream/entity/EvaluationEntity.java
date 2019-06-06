package cn.dmdream.entity;

import cn.dmdream.entity.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * 评价实体类
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tab_evaluation")
public class EvaluationEntity extends BaseEntity {

    @Column(columnDefinition = "longtext COMMENT '客户评价的详情'")
    private String evaluation;      //客户评价的详情
    @Column(columnDefinition = "DATETIME comment '评价日期'")
    private Date commentDate;            //评价日期
    @Column(columnDefinition = "int comment '客户给的评分'")
    private Integer score;          //客户给的评分

    //评论人(客户),多对一,维护方,无级联操作,不可为空
    @ManyToOne(fetch = FetchType.EAGER,optional = false)
    @JoinColumn(nullable = false,name = "commClient")
    private ClientEntity commClient;

    //被评价的经纪人 多对一,维护方,无级联操作,可选的
    @ManyToOne(fetch = FetchType.EAGER)
    private AgentEntity agentEntity;

    //被评价的房源 多对一，维护方，无级联
    @ManyToOne(fetch = FetchType.EAGER)
    private HouseEntity houseEntity;

    //被评价的小区 多对一 ， 维护方 ， 无级联
    @ManyToOne(fetch = FetchType.LAZY)
    private CommunityEntity communityEntity;

    @Override
    public String toString() {
        return "EvaluationEntity{" +
                "evaluation='" + evaluation + '\'' +
                ", commentDate=" + commentDate +
                ", score=" + score +
                ", commClient=" + commClient +
                ", agentEntity=" + agentEntity +
                ", houseEntity=" + houseEntity +
                ", communityEntity=" + communityEntity +
                '}';
    }
}
