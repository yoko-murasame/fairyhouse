package cn.dmdream.service;

import cn.dmdream.entity.ClientEntity;

public interface ClientService {

    ClientEntity findByPhone(String phone);

    ClientEntity save(ClientEntity clientEntity);
}
