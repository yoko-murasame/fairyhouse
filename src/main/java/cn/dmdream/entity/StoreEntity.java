package cn.dmdream.entity;

import cn.dmdream.entity.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * 门店实体类
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tab_store")
public class StoreEntity extends BaseEntity {

    @Column(columnDefinition = "varchar(255) comment '门店名称'")
    private String storeName;  //门店名称
    @Column(columnDefinition = "double comment '经度'")
    private Double longitude;   //经度
    @Column(columnDefinition = "double comment '维度'")
    private Double latitude;    //纬度

    //所属小区 维护方
    @ManyToOne(fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "communityEntity",nullable = false,columnDefinition = "int comment '所属小区'")
    private CommunityEntity communityEntity;

    @Override
    public String toString() {
        return "StoreEntity{" +
                "storeName=" + storeName +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", communityEntity=" + communityEntity +
                '}';
    }
}
