package cn.dmdream.dao;

import cn.dmdream.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseDao extends JpaRepository<Course,Integer> {
    public Course findByCName(String cName);
}
