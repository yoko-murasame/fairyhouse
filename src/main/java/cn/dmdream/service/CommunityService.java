package cn.dmdream.service;

import cn.dmdream.entity.CommunityEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

public interface CommunityService {

    CommunityEntity save(CommunityEntity communityEntity);

    boolean saveAll(Iterable<CommunityEntity> communityEntities);

    boolean delete(CommunityEntity communityEntity);

    boolean deleteById(Long id);

    boolean deleteAll(Iterable<CommunityEntity> communityEntities);

    CommunityEntity update(CommunityEntity communityEntity);

    Page<CommunityEntity> findByCommunityByPage(CommunityEntity communityEntity, Sort sort, Integer page, Integer
            pageSize);

}
