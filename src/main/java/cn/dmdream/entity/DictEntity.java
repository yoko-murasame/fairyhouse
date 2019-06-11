package cn.dmdream.entity;

import cn.dmdream.entity.base.BaseEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tab_dict")
public class DictEntity extends BaseEntity {

    @Column(name = "typeNum",columnDefinition = "int comment '字典表类型编号'")
    private Integer typeNum;

    @Column(name = "typeName",columnDefinition = "varchar(255) comment '字典表类型名称'")
    private String typeName;

    @Column(name = "typeDescription",columnDefinition = "varchar(255) comment '字典表描述'")
    private String typeDescription;

    @Override
    public String toString() {
        return "DictEntity{" +
                "typeNum='" + typeNum + '\'' +
                ", typeName='" + typeName + '\'' +
                ", typeDescription='" + typeDescription + '\'' +
                '}';
    }
}
