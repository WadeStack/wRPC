package org.wuuijkl.wrpc.transport;

import org.wuuijkl.wrpc.Peer;

import java.io.InputStream;

/**
 * @Author wade
 * @Date 2022/3/19 22:04
 * @Description
 * @Step: 1、创建连接
 * 2、发送数据，并且等待响应
 * 3、关闭连接
 */
public interface TransportClient {
    void connect(Peer peer);

    InputStream write(InputStream data);

    void close();
}
