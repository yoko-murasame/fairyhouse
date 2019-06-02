package cn.dmdream.entity;

import lombok.Data;

import javax.persistence.*;

@Data
//@ToString(exclude = {"admin"})
@Entity
@Table(name = "tab_cat")
public class FairyCat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer catId;
    @Column(nullable = false)
    private String catName;

    //多的一方
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH},fetch = FetchType.EAGER)
    private FairyAdmin admin;
}
