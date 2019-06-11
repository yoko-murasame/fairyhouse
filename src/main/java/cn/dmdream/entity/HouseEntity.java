package cn.dmdream.entity;

import cn.dmdream.entity.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tab_house")
public class HouseEntity extends BaseEntity {

    /**
     * 固有属性
     */
    @Column(columnDefinition = "varchar(255) comment '房源标题'")
    private String title;
    @Column(columnDefinition = "double comment '经度'")
    private Double longitude;       //经度
    @Column(columnDefinition = "double comment '纬度'")
    private Double latitude;        //纬度
    @Column(columnDefinition = "varchar(255) comment '小区里的户地址，精确到XX楼XX号'")
    private String address;         //地址，具体到户
    @Column(columnDefinition = "decimal(10,2) comment '价格'")
    private BigDecimal price;           //价格
    @Column(columnDefinition = "double comment '面积'")
    private Double area;            //面积
    @Column(columnDefinition = "int comment '所在楼层'")
    private Integer floor;          //所在楼层
    @Column(columnDefinition = "int comment '房龄'")
    private Integer age;            //房龄

    //经纪人 多对一 多的一方 维护外键
    @ManyToOne(fetch = FetchType.EAGER)
    private AgentEntity agentEntity;

    //所在小区 多对一
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.DETACH})
    @JoinColumn(name = "communityEntity",columnDefinition = "int comment '所属的小区'")
    private CommunityEntity communityEntity;

    @Column(columnDefinition = "int comment '当前房屋状态'")
    private Integer status;        //当前房屋状态：

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "house")
    private Set<PictureEntity> showPics = new HashSet<>();  //展示照片

    //房屋评价 一对多 全部级联权限
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "houseEntity")
    private Set<EvaluationEntity> evaluations = new HashSet<>();

    /**
     * 以下属性专门用于搜索
     */
    @OneToOne
    @JoinColumn(columnDefinition = "int comment '售价范围'")
    private DictEntity priceType;       //售价范围（详见TypeDic）
    @OneToOne
    @JoinColumn(columnDefinition = "int comment '房屋类型'")
    private DictEntity houseType;       //房屋类型（详见TypeDic）
    @OneToOne
    @JoinColumn(columnDefinition = "int comment '面积类型'")
    private DictEntity areaType;       //面积类型
    @OneToOne
    @JoinColumn(columnDefinition = "int comment '楼层类型'")
    private DictEntity floorType;       //楼层类型（详见TypeDic）
    @OneToOne
    @JoinColumn(columnDefinition = "int comment '房屋朝向'")
    private DictEntity orieType;        //房屋朝向
    @OneToOne
    @JoinColumn(columnDefinition = "int comment '楼龄'")
    private DictEntity ageType;         //楼龄

    /**
     * 用于记录访问量
     */
    @Column(columnDefinition = "bigint comment '当前房源访问量'")
    private Long traffic;//访问量

    //房子关注者集合,多对多,被维护方,无级联操作
    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "houseEntityCollections")
    private Set<ClientEntity> clientEntities = new HashSet<>();

    //房子所属人(拥有者),多对一,维护方,不可为空
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.DETACH},fetch =
            FetchType.EAGER,optional = false)
    @JoinColumn(nullable = false,columnDefinition = "int comment '房子的拥有者'")
    private ClientEntity houseOwner;

    @Override
    public String toString() {
        return "HouseEntity{" +
                "title='" + title + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", address='" + address + '\'' +
                ", price=" + price +
                ", area=" + area +
                ", floor=" + floor +
                ", age=" + age +
                ", agentEntity=" + agentEntity +
                ", communityEntity=" + communityEntity +
                ", status=" + status +
                ", showPics=" + showPics +
                ", evaluations=" + evaluations +
                ", priceType=" + priceType +
                ", houseType=" + houseType +
                ", areaType=" + areaType +
                ", floorType=" + floorType +
                ", orieType=" + orieType +
                ", ageType=" + ageType +
                ", traffic=" + traffic +
                ", clientEntities=" + clientEntities +
                ", houseOwner=" + houseOwner +
                '}';
    }
}
