package cn.dmdream.entity;

import cn.dmdream.entity.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * 看房历史记录
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tab_history")
public class HistoryEntity extends BaseEntity {

    //带看房的经纪人
    @ManyToOne(fetch = FetchType.EAGER,optional = false)
    @JoinColumn(nullable = false,name = "agent",columnDefinition = "int comment '带看房的经纪人'")
    private AgentEntity agentEntity;

    //看房的客户,多对一,多方,维护外键,立即加载,不能为空
    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH,CascadeType.DETACH},fetch = FetchType.EAGER,optional
            = false)
    @JoinColumn(nullable = false,name = "client",columnDefinition = "int comment '看房的客户'")
    private ClientEntity clientEntity;

    //看房的房源 多对一 多方，维护外键，不为空
    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH,CascadeType.DETACH},fetch = FetchType.EAGER,optional
            = false)
    @JoinColumn(nullable = false,name = "house",columnDefinition = "int comment '看房记录的房源'")
    private HouseEntity houseEntity;

    @Column(columnDefinition = "DATETIME comment '看房日期'")
    private Date date;            //看房日期

    @Override
    public String toString() {
        return "HistoryEntity{" +
                "agentEntity=" + agentEntity +
                ", clientEntity=" + clientEntity +
                ", houseEntity=" + houseEntity +
                ", date=" + date +
                '}';
    }
}
