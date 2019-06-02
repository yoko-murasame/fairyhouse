package cn.dmdream.dao;

import cn.dmdream.entity.Course;
import cn.dmdream.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ManyToManyTest {

    @Test
    public void contextLoads() {
    }

    @Autowired
    private StudentDao studentDao;
    @Autowired
    private CourseDao courseDao;
    /**
     * 仅将被维护方对象添加进维护方对象Set中
     * 保存维护方对象
     */
    @Test
    public void 多对多插入1() {
        Student s = new Student();
        s.setSName("二狗");
        Course c = new Course();
        c.setCName("语文");
        s.getCourses().add(c);
        studentDao.save(s);//由于操作对象是维护方，成功地在student、course以及中间表student_courses中分别添加了数据
    }

    /**
     * 仅将维护方对象添加进被维护方对象Set中
     * 保存被维护方对象
     */
    @Test
    public void 多对多插入2() {
        Student s = new Student();
        s.setSName("三汪");
        Course c = new Course();
        c.setCName("英语");
        c.getStudents().add(s);
        courseDao.save(c);//操作对象在这里换成了被维护方。不负众望，出问题了。保存的时候，student表和course表倒是都成功地插入了数据，但是中间表中，并未产生对两者数据的关联。
    }

    /**
     * 将双方对象均添加进双方Set中
     * 保存被维护方对象
     */
    @Test
    public void 多对多插入3() {
        Student s = new Student();
        s.setSName("一晌");
        Course c = new Course();
        c.setCName("数学");
        s.getCourses().add(c);
        c.getStudents().add(s);
        courseDao.save(c);//将双方对象均添加进双方Set中，操作对象是被维护方，操作结果与第一组相同
    }

    /**
     * 删除维护方对象
     */
    @Test
    public void 多对多删除1(){
        Student s = studentDao.findBySName("二狗");
        System.out.println(s);
        System.out.println(s.getCourses());//报错解决方式：实体采用立即加载fetch=FetchType.EAGER
        studentDao.delete(s);//操作对象是维护方，成功删除三张表数据
    }

    /**
     * 删除被维护方对象
     */
    @Test
    public void 多对多删除2(){
        //Course c = courseDao.findByCName("英语");//操作对象是被维护方，在删除的时候只删除了course中的数据
        Course c = courseDao.findByCName("数学");//操作对象是被维护方，但双方对象均添加进双方Set中，成功删除三张表数据
        courseDao.delete(c);
    }
}
