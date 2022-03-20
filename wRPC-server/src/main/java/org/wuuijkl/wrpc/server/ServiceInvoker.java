package org.wuuijkl.wrpc.server;

import org.wuuijkl.wrpc.Request;
import org.wuuijkl.wrpc.utils.ReflectionUtils;

/**
 * @Author wade
 * @Date 2022/3/20 9:41
 * @Description 调用具体服务
 */
public class ServiceInvoker {
    public Object invoke(ServiceInstance service, Request request) {
        return ReflectionUtils.invoke(
                service.getTarget(),
                service.getMethod(),
                request.getParameters()
        );
    }
}
