package cn.dmdream.service.impl;

import cn.dmdream.dao.DictDao;
import cn.dmdream.entity.DictEntity;
import cn.dmdream.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DictServiceImpl implements DictService {


    @Autowired
    private DictDao dictDao;

    @Override
    public List<DictEntity> findAllByTypeNum(Integer typeNum) {
        try {
            List<DictEntity> list = dictDao.findAllByTypeNum(typeNum);
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<DictEntity> findAllByTypeName(String typeName) {
        try {
            List<DictEntity> list = dictDao.findAllByTypeName(typeName);
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
