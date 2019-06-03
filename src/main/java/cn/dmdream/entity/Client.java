package cn.dmdream.entity;


import java.util.List;

/**
 * 客户实体类
 */
public class Client extends User {
    private Integer id;
    private Integer clientId;
    private String nicPic;      //个人头像
    private List<Agent> agents;     //有联系的经纪人
    private List<History> browsingHistories;        //看房的记录（实地的）
    private List<Community> commCollections;        //关注的小区
    private List<House> houseCollections;           //关注的房源
    private List<House> houseSales;                 //要销售的房源
    private List<Evaluation> evaluations;           //用户的评价
}
