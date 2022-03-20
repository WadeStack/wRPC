package org.wuuijkl.wrpc.transport;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * @Author wade
 * @Date 2022/3/19 22:09
 * @Description 处理网络请求的handler
 */
public interface RequestHandler {
    void onRequest(InputStream receive, OutputStream toResp);
}
