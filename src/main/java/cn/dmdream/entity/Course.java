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
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@GenericGenerator(name = "idGenerator", strategy = "uuid")
    private Integer id;
    private String cName;
    @ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="courses")//cascade（级联关系）fetch（加载策略）mappedBy（声明关系的维护方）mappedBy出现在哪一方意味着哪一方不用维护外键关系了
    private Set<Student> students= new HashSet<>();//这里直接new了空对象方便直接设置
}
/*
mappedBy声明于关系的被维护方，声明的值为关系的维护方的关系对象属性名。
在实例中，mappedBy被声明于Course类中，其值为Student类中的Set对象"courses"。即，Student为关系维护方，Course为被维护方。
*/