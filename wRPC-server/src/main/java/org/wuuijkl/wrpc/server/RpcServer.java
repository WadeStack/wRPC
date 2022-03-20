package org.wuuijkl.wrpc.server;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.wuuijkl.wrpc.Request;
import org.wuuijkl.wrpc.Response;
import org.wuuijkl.wrpc.codec.Decoder;
import org.wuuijkl.wrpc.codec.Encoder;
import org.wuuijkl.wrpc.transport.RequestHandler;
import org.wuuijkl.wrpc.transport.TransportServer;
import org.wuuijkl.wrpc.utils.ReflectionUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @Author wade
 * @Date 2022/3/20 9:43
 * @Description
 */
@Slf4j
public class RpcServer {
    private RpcServerConfig config;
    private TransportServer net;
    private Encoder encoder;
    private Decoder decoder;
    private ServiceManager serviceManager;
    private ServiceInvoker serviceInvoker;

    private RequestHandler handler = new RequestHandler() {
        @Override
        public void onRequest(InputStream receive, OutputStream toResp) {
            Response response = new Response();
            try {
                byte[] inBytes = IOUtils.readFully(receive, receive.available());
                Request request = decoder.decode(inBytes, Request.class);
                log.info("get request: {}", request);
                ServiceInstance sis = serviceManager.lookup(request);
                Object ret = serviceInvoker.invoke(sis, request);
                response.setData(ret);
            } catch (Exception e) {
                log.warn(e.getMessage(), e);
                response.setCode(1);
                response.setMessage("RpcServer got error:"
                        + e.getClass().getName()
                        + " : " + e.getMessage());
            } finally {
                try {
                    byte[] outBytes = encoder.encode(response);
                    toResp.write(outBytes);
                    log.info("response client");
                } catch (IOException e) {
                    log.warn(e.getMessage(), e);
                }
            }
        }
    };

    public RpcServer() {
        this(new RpcServerConfig());
    }

    public <T> void register(Class<T> interfaceClass, T bean) {
        serviceManager.register(interfaceClass, bean);
    }

    public void start() {
        this.net.start();
    }

    public void stop() {
        this.net.stop();
    }

    public RpcServer(RpcServerConfig config) {
        this.config = config;

        // net
        this.net = ReflectionUtils.newInstance(
                config.getTransportClass()
        );
        this.net.init(config.getPort(), this.handler);

        // codec
        this.encoder = ReflectionUtils.newInstance(
                config.getEncoderClass()
        );
        this.decoder = ReflectionUtils.newInstance(
                config.getDecoderClass()
        );

        // service
        this.serviceManager = new ServiceManager();
        this.serviceInvoker = new ServiceInvoker();
    }
}
