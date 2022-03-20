package org.wuuijkl.wrpc.utils;

import junit.framework.TestCase;

import java.lang.reflect.Method;
import java.util.List;

public class ReflectionUtilsTest extends TestCase {

    public void testNewInstance() {
        TestClass t = ReflectionUtils.newInstance(TestClass.class);
        assertNotNull(t);
    }

    public void testGetPublicMethods() {
        List<Method> methods = ReflectionUtils.getPublicMethods(TestClass.class);
        assertNotNull(methods);
        assertEquals(2, methods.size());
        assertEquals("e", methods.get(0).getName());
    }

    public void testInvoke() {
        List<Method> methods = ReflectionUtils.getPublicMethods(TestClass.class);
        Method methodB = methods.get(0);
        TestClass t = new TestClass();
        Object res = ReflectionUtils.invoke(t, methodB);
        assertEquals("e", res);
    }
}