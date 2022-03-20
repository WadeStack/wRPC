package org.wuuijkl.wrpc.server;

import lombok.Data;
import org.wuuijkl.wrpc.codec.Decoder;
import org.wuuijkl.wrpc.codec.Encoder;
import org.wuuijkl.wrpc.codec.JSONDecoder;
import org.wuuijkl.wrpc.codec.JSONEncoder;
import org.wuuijkl.wrpc.transport.HTTPTransportServer;
import org.wuuijkl.wrpc.transport.TransportServer;

/**
 * @Author wade
 * @Date 2022/3/19 22:49
 * @Description
 */
@Data
public class RpcServerConfig {
    private Class<? extends TransportServer> transportClass = HTTPTransportServer.class;
    private Class<? extends Encoder> encoderClass = JSONEncoder.class;
    private Class<? extends Decoder> decoderClass = JSONDecoder.class;
    private int port = 3000;
}
