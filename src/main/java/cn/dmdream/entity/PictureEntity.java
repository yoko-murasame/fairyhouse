package cn.dmdream.entity;

import cn.dmdream.entity.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tab_pictures")
public class PictureEntity extends BaseEntity {

    @Column(columnDefinition = "varchar(255) comment '图片地址'")
    private String picUrl;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "house",columnDefinition = "int comment '图片所属的房子'")
    private HouseEntity house;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "communityEntity",columnDefinition = "int comment '图片所属的小区'")
    private CommunityEntity communityEntity;
}
