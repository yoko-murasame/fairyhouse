package cn.dmdream.entity;

import java.util.List;

public class House {

    /**
     * 固有属性
     */
    private Integer id;
    private Integer houseId;
    private Double longitude;       //经度
    private Double latitude;        //纬度
    private String address;         //地址，具体到户
    private Double price;           //价格
    private Double area;            //面积
    private Integer floor;          //所在楼层
    private Integer age;            //房龄
    private List<String> showPics;  //展示照片
    private Agent agent;            //经纪人
    private Community community;   //所在小区
    private Integer status;        //当前房屋状态：

    /**
     * 以下属性专门用于搜索
     */
    private String priceType;       //售价范围（详见TypeDic）
    private String houseType;       //房屋类型（详见TypeDic）
    private String areaType;       //面积类型
    private String floorType;       //楼层类型（详见TypeDic）
    private String orieType;        //房屋朝向
    private String ageType;         //楼龄

}
