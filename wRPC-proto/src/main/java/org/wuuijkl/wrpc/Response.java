package org.wuuijkl.wrpc;

import lombok.Data;

/**
 * @Author wade
 * @Date 2022/3/19 20:57
 * # @Description 表示RPC的返回
 */
@Data
public class Response {
    /**
     * 服务返回的状态码，0-成功，非0失败
     */
    private Integer code = 0;
    /**
     * 具体的错误信息
     */
    private String message = "ok";
    /**
     * 返回的数据
     */
    private Object Data;
}
