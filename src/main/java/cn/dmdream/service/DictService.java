package cn.dmdream.service;

import cn.dmdream.entity.DictEntity;

import java.util.List;

public interface DictService {

    List<DictEntity> findAllByTypeNum(Integer typeNum);

    List<DictEntity> findAllByTypeName(String typeName);
}
