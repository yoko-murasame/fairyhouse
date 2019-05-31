package cn.dmdream.entity;

import lombok.Data;
import lombok.Generated;
import lombok.ToString;

import javax.persistence.*;

@Data
//@ToString(exclude = {"admin"})
@Entity(name = "tab_cat")
public class FairyCat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer catId;
    @Column(nullable = false)
    private String catName;

    //多的一方
    @ManyToOne(targetEntity = FairyAdmin.class)
    @JoinColumn(name = "fore_admin",referencedColumnName = "adminId")
    private FairyAdmin admin;
}
