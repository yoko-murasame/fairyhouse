package cn.dmdream.service.impl;

import cn.dmdream.dao.ClientDao;
import cn.dmdream.entity.ClientEntity;
import cn.dmdream.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientDao clientDao;

    @Override
    public ClientEntity findByPhone(String phone) {

        try {
            ClientEntity client = clientDao.findByPhoneIs(phone);
            return client;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public ClientEntity save(ClientEntity clientEntity) {
        try {
            ClientEntity save = clientDao.save(clientEntity);
            return save;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
