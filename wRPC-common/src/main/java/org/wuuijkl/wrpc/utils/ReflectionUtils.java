package org.wuuijkl.wrpc.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author wade
 * @Date 2022/3/19 21:14
 * # @Description 反射工具类
 */
public class ReflectionUtils {

    /**
     * 根据class创建对象
     *
     * @param clazz 待创建对象的类
     * @param <T>   对象类型
     * @return 创建好的对象
     */
    public static <T> T newInstance(Class<T> clazz) {
        try {
            return clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取某个class的所有public方法
     * @param clazz
     * @return 当前类声明的public方法
     */
    public static List<Method> getPublicMethods(Class clazz) {
        Method[] methods = clazz.getDeclaredMethods();
        return Arrays.stream(methods).filter(m -> Modifier.isPublic(m.getModifiers()))
                .collect(Collectors.toList());
    }

    /**
     *调用指定对象的制定方法
     * @param obj 被调用的对象
     * @param method 被调用的方法
     * @param args 可变参数列表
     * @return
     */
    public static Object invoke(Object obj, Method method,Object... args){
        try {
            return method.invoke(obj,args);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

}
