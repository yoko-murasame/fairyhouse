package cn.dmdream.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//用了下面Hibernate提供的生成器来做主键
    //@GenericGenerator(name = "idGenerator", strategy = "uuid")//Hibernate的通用主键生成器，生成策略时uuid
    private Integer id;
    private String sName;
    @ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    private Set<Course> courses = new HashSet<>();//这里直接new了空对象方便直接设置
}