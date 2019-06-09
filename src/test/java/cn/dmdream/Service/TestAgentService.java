package cn.dmdream.Service;

import cn.dmdream.dao.DictDao;
import cn.dmdream.entity.AgentEntity;
import cn.dmdream.entity.DictEntity;
import cn.dmdream.service.AgentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;
import sun.management.resources.agent;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestAgentService {


    @Autowired
    private AgentService agentService;

    @Autowired
    private DictDao dictDao;

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

        Optional<DictEntity> dic1 = dictDao.findById((long) 61);
        Optional<DictEntity> dic2 = dictDao.findById((long) 62);

        AgentEntity entity = new AgentEntity();
        //entity.setScore(3d);
        //entity.setUsername("3");
        entity.setGrade(dic1.get());
        entity.setAbilityTag(dic2.get());
        Sort sort = Sort.by(Sort.Direction.DESC,"score");
        Page<AgentEntity> page = agentService.findAllByPage(entity, sort, 1, 5);
        page.getContent().forEach(System.out::println);
    }

}
