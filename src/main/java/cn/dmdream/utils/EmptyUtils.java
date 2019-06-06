package cn.dmdream.utils;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EmptyUtils {

    /**
     * 判断对象是否为空
     * @param object
     * @return
     */
    public static boolean isEmpty(Object object) {

        try {
            //普通对象
            if (object == null) {
                return true;
            }

            //字符串
            if (object instanceof String){
                if (object.toString().equals("") || object == null) {
                    return true;
                }
            }

            //集合
            if (object instanceof Collection || object instanceof List || object instanceof Map || object instanceof
                    Set) {
                if (((Collection) object).size() == 0){
                    return false;
                }
            }

            if(object instanceof List){
                if (((Collection) object).size() == 0){
                    return false;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}
