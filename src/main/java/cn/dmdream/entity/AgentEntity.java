package cn.dmdream.entity;

import cn.dmdream.entity.base.BaseUserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


/**
 * 经纪人实体类
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tab_agent")
public class AgentEntity extends BaseUserEntity {

    //经纪人级别：高级店经理、资深经纪人、综合经纪人等,一对一
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "grade",columnDefinition = "int comment '经纪人级别'")
    private DictEntity grade;

    //能力标签:  海外顾问 销售达人 房东信赖 带看活跃
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "abilityTag",columnDefinition = "int comment '经纪人能力标签'")
    private DictEntity abilityTag;

    //服务平台年限:  4-5年
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "seniority",columnDefinition = "int comment '经纪人服务平台年限'")
    private DictEntity seniority;

    //主营板块:  海淀公主坟 海淀万寿路 海淀五棵松
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "major",columnDefinition = "int comment '经纪人主营板块'")
    private DictEntity major;

    //负责小区:翠微东里 翠微北里 颐源居小区 多对多,维护方,级联修改
    @ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.MERGE,CascadeType.REFRESH,CascadeType.DETACH})
    private Set<CommunityEntity> communities = new HashSet<>();

    //负责房源 一对多 被维护方
    @OneToMany(cascade = {CascadeType.MERGE,CascadeType.REFRESH,CascadeType.DETACH},fetch = FetchType.LAZY,mappedBy = "agentEntity")
    private Set<HouseEntity> houses = new HashSet<>();

    //客户列表,多对多,维护方
    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.DETACH},fetch = FetchType.LAZY)
    private Set<ClientEntity> clientEntities = new HashSet<>();

    /**
     * 用于搜索的字段
     */

    //客户对经纪人的评价,一对多,被维护方,不可级联操作
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "agentEntity")
    private Set<EvaluationEntity> clientEvaluations = new HashSet<>();

    //综合评分 自动统计计算
    @Column(name = "score",columnDefinition = "double comment '需要计算的综合评分'")
    private Double score;

    //历史成交记录集合 一对多，被维护方，无级联
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "agent")
    private Set<DealEntity> dealEntities = new HashSet<>();

    //带看房记录 一对多，被维护方，级联保存
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST,mappedBy = "agentEntity")
    private Set<HistoryEntity> historyEntities = new HashSet<>();

    @Override
    public String toString() {
        return "AgentEntity{" +
                "score=" + score +
                ", username='" + username + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", realname='" + realname + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
