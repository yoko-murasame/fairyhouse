package cn.dmdream.entity;

/**
 * 评价实体类
 */
public class Evaluation {

    private Integer id;
    private Integer evaluationId;
    private String evaluation;      //客户评价的详情
    private String date;            //评价日期
    private Integer score;          //客户给的评分
    private Client client;          //评价的客户
    private Agent agent;            //被评价的经纪人
    private House house;            //被评价的房源
    private Community community;    //被评价的小区

}
