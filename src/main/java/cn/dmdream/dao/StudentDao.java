package cn.dmdream.dao;

import cn.dmdream.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDao extends JpaRepository<Student,Integer> {
    public Student findBySName(String sName);
}
