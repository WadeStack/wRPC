package org.wuuijkl.wrpc.server;

import junit.framework.TestCase;
import org.wuuijkl.wrpc.Request;
import org.wuuijkl.wrpc.ServiceDescriptor;
import org.wuuijkl.wrpc.utils.ReflectionUtils;

import java.lang.reflect.Method;

public class ServiceManagerTest extends TestCase {
    ServiceManager sm = new ServiceManager();


    public void testRegister() {
        TestInterface bean = new Test1Class();
        sm.register(TestInterface.class, bean);
    }

    public void testLookup() {
        TestInterface bean = new Test1Class();
        sm.register(TestInterface.class, bean);
        Method method = ReflectionUtils.getPublicMethods(TestInterface.class).get(0);
        ServiceDescriptor sdp = ServiceDescriptor.from(TestInterface.class, method);
        Request request = new Request();
        request.setService(sdp);

        ServiceInstance sis = sm.lookup(request);
        assertNotNull(sis);
    }
}