package cn.dmdream.dao;

import cn.dmdream.entity.DictEntity;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DictDao extends JpaRepositoryImplementation<DictEntity, Long> {

    List<DictEntity> findAllByTypeNum(Integer typeNum);

    List<DictEntity> findAllByTypeName(String typeName);
}
