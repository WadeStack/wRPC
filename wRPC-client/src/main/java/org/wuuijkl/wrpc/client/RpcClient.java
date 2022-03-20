package org.wuuijkl.wrpc.client;

import org.wuuijkl.wrpc.codec.Decoder;
import org.wuuijkl.wrpc.codec.Encoder;
import org.wuuijkl.wrpc.utils.ReflectionUtils;

import java.lang.reflect.Proxy;

/**
 * @Author wade
 * @Date 2022/3/20 11:45
 * @Description
 */
public class RpcClient {
    private RpcClientConfig config;
    private Encoder encoder;
    private Decoder decoder;
    private TransportSelector selector;

    public RpcClient() {
        this(new RpcClientConfig());
    }

    public RpcClient(RpcClientConfig config) {
        this.config = config;

        this.encoder = ReflectionUtils.newInstance(
                config.getEncodeClass()
        );
        this.decoder = ReflectionUtils.newInstance(
                config.getDecodeClass()
        );
        this.selector = ReflectionUtils.newInstance(
                config.getSelectorClass()
        );
        this.selector.init(
                this.config.getSevers(),
                this.config.getConnectCount(),
                this.config.getTransportClass()
        );

    }

    public <T> T getProxy(Class clazz) {
        return (T) Proxy.newProxyInstance(
                getClass().getClassLoader(),
                new Class[]{clazz},
                new RemoteInvoker(clazz, encoder, decoder, selector)
        );
    }
}
