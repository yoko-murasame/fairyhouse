package cn.dmdream.entity;

import cn.dmdream.entity.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tab_address_head")
public class AddressEntity {

    @Id
    @Column(name = "area_id")
    private Integer areaId;

    @Column(name = "area_name")
    private String areaName;

    @Column(name = "parent_id")
    private String parent;

    @Column(name = "abbreviation")
    private String abbreviation;//简称

    @Column(name = "level")
    private String level;

    @Column(name = "sequence")
    private String sequence;//该级的序列号

    @Column(name = "totalCount",columnDefinition = "bigint comment '区域房屋数量'")
    private Long totalCount;//房屋数量

    @Column(name = "avgPrice",columnDefinition = "decimal(10, 2) comment '区域的平均房价价'")
    private BigDecimal avgPrice;//区域的平均房价价


}
