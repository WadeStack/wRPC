package org.wuuijkl.wrpc;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author wade
 * @Date 2022/3/19 20:51
 * @Description 表示网络传输的一个端点
 */
@Data
@AllArgsConstructor
public class Peer {
    private String host;
    private Integer port;

}
