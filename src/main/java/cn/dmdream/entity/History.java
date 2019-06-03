package cn.dmdream.entity;

/**
 * 看房历史记录
 */
public class History {

    private Integer id;
    private Integer historyId;
    private Agent agent;            //带看房的经纪人
    private Client client;          //看房的客户
    private Community community;    //房源所在的小区
    private House house;            //房源
    private String date;            //看房日期

}
