package org.wuuijkl.wrpc.server;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.lang.reflect.Method;

/**
 * @Author wade
 * @Date 2022/3/19 22:53
 * @Description 表示一个具体服务
 */
@Data
@AllArgsConstructor
public class ServiceInstance {
    private Object target;
    private Method method;
}
