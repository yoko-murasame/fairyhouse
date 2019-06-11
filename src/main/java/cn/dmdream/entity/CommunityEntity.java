package cn.dmdream.entity;

import cn.dmdream.entity.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 小区实体类
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tab_community")
public class CommunityEntity extends BaseEntity {

    @Column
    private String title;

    @Column(nullable = false)
    private Double longitude;           //经度
    @Column(nullable = false)
    private Double latitude;            //纬度

    @OneToOne(optional = false,fetch = FetchType.EAGER)
    @JoinColumn(name = "addressHead",nullable = false)
    private AddressEntity addressHead;         //地址的前缀，固定了的，是外键
    @Column(nullable = false)
    private String address;     //小区地址（例：(西城广安门)广安门外大街305号八区）

    @Column
    private BigDecimal avgPrice;            //成交均价（例：121506元/平米）
    @Column
    private String age;                 //建筑年代（例：2003年建成）
    @Column
    private String type;                 //建筑类型（例：塔楼）
    @Column
    private String propertyFee;         //物业费用（例：2.5至3.2元/平米/月）
    @Column
    private String propertyCompany;    //物业公司（例：北京长城物业管理有限公司）
    @Column
    private String developers;          //开发商  （例：北京荣丰房地产开发有限公司）
    @Column
    private Integer buildingCounts;    //楼栋总数（例：18栋）
    @Column
    private Integer houseCounts;       //房屋总数（例：6000户）

    //一对多，被维护方
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "communityEntity")
    private Set<StoreEntity> nearbyStoreEntities = new HashSet<>();  //附近门店（例：荣丰小区一店/宣武区广安门外大街305号）

    //一对多，被维护方
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "communityEntity",fetch = FetchType.LAZY)
    private Set<HouseEntity> houseEntities = new HashSet<>();         //小区里的房子

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "communityEntity")
    private Set<PictureEntity> showPics = new HashSet<>();  //展示照片

    //小区的负责经纪人，多对多,被维护方,无级联操作
    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "communities")
    private Set<AgentEntity> agentEntitySet = new HashSet<>();

    //小区的评价 一对多 全部级联关系
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "communityEntity",fetch = FetchType.LAZY)
    private Set<EvaluationEntity> evaluations = new HashSet<>();

    /**
     * 用于搜索的字段
     */

    @OneToOne
    @JoinColumn(name = "avgType",columnDefinition = "int comment '均价类型'")
    private DictEntity avgType; //均价

    @OneToOne
    @JoinColumn(name = "houseType",columnDefinition = "int comment '楼房类型'")
    private DictEntity houseType;       //例如：塔楼、板楼、塔板结合

    @OneToOne
    @JoinColumn(name = "ageType",columnDefinition = "int comment '楼龄类型'")
    private DictEntity ageType;         //楼龄

    /**
     * 用于记录访问量
     */
    @Column
    private Long traffic;           //访问量

    //收藏客户集合,多对多,不维护关系,无级联操作
    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "commCollections")
    private Set<ClientEntity> clientEntities = new HashSet<>();


    @Override
    public String toString() {
        return "CommunityEntity{" +
                "title='" + title + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", addressHead=" + addressHead +
                ", address='" + address + '\'' +
                ", avgPrice=" + avgPrice +
                ", age='" + age + '\'' +
                ", type='" + type + '\'' +
                ", propertyFee='" + propertyFee + '\'' +
                ", propertyCompany='" + propertyCompany + '\'' +
                ", developers='" + developers + '\'' +
                ", buildingCounts=" + buildingCounts +
                ", houseCounts=" + houseCounts +
                ", showPics=" + showPics +
                ", avgType=" + avgType +
                ", houseType=" + houseType +
                ", ageType=" + ageType +
                ", traffic=" + traffic +
                '}';
    }
}
