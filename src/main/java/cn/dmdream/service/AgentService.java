package cn.dmdream.service;

import cn.dmdream.entity.AgentEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

public interface AgentService {

    Boolean deleteById(Long id);

    Boolean deleteAll(Iterable agents);

    AgentEntity update(AgentEntity agent);

    AgentEntity save(AgentEntity agent);

    Boolean saveAll(Iterable agents);

    AgentEntity findById(Long id);

    Page<AgentEntity> findAllByPage(AgentEntity agent, Sort sort, Integer page, Integer pageSize);

}
