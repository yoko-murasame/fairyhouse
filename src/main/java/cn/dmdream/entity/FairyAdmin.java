package cn.dmdream.entity;
import lombok.Data;
import lombok.ToString;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Data//自动生成get/set/tostring
@ToString(exclude = "catList")//防止内存溢出
@Entity//交给jpa管理实体，并设置映射到数据库的表名
@Table(name = "tab_admin")
public class FairyAdmin {
    @Id //主键
    @Column(name = "adminId",unique = true,nullable = false) //name属性不写默认和字段一样
    @GeneratedValue(strategy = GenerationType.IDENTITY)//主键由数据库自动生成（主要是自动增长型）
    private Integer adminId;
    @Column(length = 100,unique = true)//设置长度和唯一性
    private String adminUsername;
    @Column(length = 100)
    private String adminPassword;
    @Column(length = 100)
    private String adminNickname;
    @Column(length = 255)
    private String adminNicpic;
    //一的一方
    @OneToMany(mappedBy = "admin",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<FairyCat> catList = new ArrayList<FairyCat>();
}