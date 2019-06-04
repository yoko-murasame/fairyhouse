package cn.dmdream.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 小区实体类
 */
public class Community {

    private Integer id;
    private Integer communityId;
    private Double longitude;           //经度
    private Double latitude;            //纬度
    private String addressHead;         //地址的前缀，固定了的，是外键
    private String address;             //小区地址（例：(西城广安门)广安门外大街305号八区）
    private Double avgPrice;            //成交均价（例：121506元/平米）
    private String age;                  //建筑年代（例：2003年建成）
    private String type;                 //建筑类型（例：塔楼）
    private String propertyFee;         //物业费用（例：2.5至3.2元/平米/月）
    private String propertyCompany;    //物业公司（例：北京长城物业管理有限公司）
    private String developers;          //开发商  （例：北京荣丰房地产开发有限公司）
    private Integer buildingCounts;    //楼栋总数（例：18栋）
    private Integer houseCounts;       //房屋总数（例：6000户）
    private List<Store> nearbyStores = new ArrayList<>();  //附近门店（例：荣丰小区一店/宣武区广安门外大街305号）
    private List<House> houses = new ArrayList<>();         //小区里的房子
    private List<String> showPics = new ArrayList<>();     //展示照片
    private Set<Agent> agentSet = new HashSet<>();         //经纪人，多对多

    /**
     * 用于搜索的字段
     */
    private String avgType;         //均价
    private String houseType;       //例如：塔楼、板楼、塔板结合
    private String ageType;         //楼龄

    /**
     * 用于记录访问量
     */
    private Long traffic;           //访问量
    private Long collectNumber;    //收藏数

}
