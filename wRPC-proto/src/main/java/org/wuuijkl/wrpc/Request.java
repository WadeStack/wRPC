package org.wuuijkl.wrpc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author wade
 * @Date 2022/3/19 20:56
 * # @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Request {
    private ServiceDescriptor service;
    private Object[] parameters;
}
