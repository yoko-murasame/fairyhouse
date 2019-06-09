package cn.dmdream.utils;

import org.junit.Test;

import java.util.*;

public class TestEmptyUtils {

    @Test
    public void test() {
        String str = "  ";
        String str2 = null;
        String str3 = "123";
        List list = new ArrayList();
        list.add(1);
        Set set = new HashSet();
        Map map = new HashMap();
        System.out.println(EmptyUtils.isEmpty(set));
        System.out.println(EmptyUtils.isEmpty(list));
        System.out.println(EmptyUtils.isEmpty(map));
        System.out.println(EmptyUtils.isEmpty(str));
        System.out.println(EmptyUtils.isEmpty(str2));
        System.out.println(EmptyUtils.isEmpty(str3));

    }
}
