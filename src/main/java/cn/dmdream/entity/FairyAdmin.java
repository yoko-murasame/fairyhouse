package cn.dmdream.entity;

import lombok.Data;
import lombok.ToString;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Data
@ToString(exclude = "catList")
@Entity(name = "tab_admin")
public class FairyAdmin {

    @Id //主键
    @Column(name = "adminId",unique = true,nullable = false) //name属性不写默认和字段一样
    @GeneratedValue(strategy = GenerationType.IDENTITY)//主键由数据库自动生成（主要是自动增长型）
    private Integer adminId;
    @Column(length = 100,unique = true)
    private String adminUsername;
    @Column(length = 100)
    private String adminPassword;
    @Column(length = 100)
    private String adminNickname;
    @Column(length = 255)
    private String adminNicpic;

    //一的一方
    @OneToMany(targetEntity = FairyCat.class,mappedBy = "admin",cascade = CascadeType.ALL)
    private List<FairyCat> catList;

}
