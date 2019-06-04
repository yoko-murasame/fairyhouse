package cn.dmdream.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * 经纪人实体类
 */
public class Agent extends User {

    private Integer id;
    private Integer agentId;
    private String workPic;          //头像
    private String grade;            //经纪人级别：高级店经理、资深经纪人、综合经纪人等
    private String abilityTag;       //能力标签:  海外顾问 销售达人 房东信赖 带看活跃
    private String seniority;        //服务平台年限:  4-5年
    private String major;            //主营板块:  海淀公主坟 海淀万寿路 海淀五棵松
    private List<Community> communities;        //重点小区:  翠微东里 翠微北里 颐源居小区
    private Set<Client> clients = new HashSet<>();  //客户，多对多

    /**
     * 用于搜索的字段
     */
    private Double score;            //综合评分
    private Long dealRecords;       //历史成交记录
    private Long helps;             //带看量
}
