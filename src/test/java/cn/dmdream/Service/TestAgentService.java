package cn.dmdream.Service;

import cn.dmdream.entity.AgentEntity;
import cn.dmdream.service.AgentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;
import sun.management.resources.agent;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestAgentService {


    @Autowired
    private AgentService agentService;

    @Test
    public void saveTest() {

        ArrayList<AgentEntity> list = new ArrayList<>();
        for (int i = 20; i <22 ; i++) {
            AgentEntity agent = new AgentEntity();
            agent.setPhone("1898858585" + (i%10));
            agent.setUsername("Mr.Shao_" + i);
            agent.setScore((double) (i%5));
            list.add(agent);
        }

    }
    @Test
    public void saveOneTest() {

        AgentEntity agent = new AgentEntity();
        agent.setPhone("18988585844" );
        agent.setUsername("Mr.Shao_10");
        agent.setScore(5.0);
        AgentEntity agentSaved = agentService.save(agent);
        System.out.println(agentSaved);

    }

    @Test
    public void updateTest() {
        AgentEntity agent = agentService.findById(1l);
        agent.setScore(5.0);
        AgentEntity update = agentService.update(agent);
        System.out.println(agent);
    }

    @Test
    public void findAllTest() {
        Page<AgentEntity> page = agentService.findAllByPage(new AgentEntity(), 1, 5);

        page.getContent().forEach(System.out::println);
    }

}
