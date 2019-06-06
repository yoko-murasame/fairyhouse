package cn.dmdream.utils;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestEmptyUtils {

    @Test
    public void test() {
        String str = "";
        List list = new ArrayList();
        System.out.println(EmptyUtils.isEmpty(list));
    }
}
