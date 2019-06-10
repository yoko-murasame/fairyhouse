package cn.dmdream.dao;

import cn.dmdream.entity.ClientEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestClientDao {

    @Autowired
    private ClientDao clientDao;

    @Test
    public void saveTest() {

        ClientEntity client = new ClientEntity();
        client.setUsername("yoko");
        client.setPhone("18989849258");
        client.setNickname("kuluSeky");
        client.setRealname("邵超浩");
        ClientEntity save = clientDao.save(client);
        System.out.println(save);
    }
}
