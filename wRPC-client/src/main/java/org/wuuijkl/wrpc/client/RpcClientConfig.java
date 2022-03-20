package org.wuuijkl.wrpc.client;

import lombok.Data;
import org.wuuijkl.wrpc.Peer;
import org.wuuijkl.wrpc.codec.Decoder;
import org.wuuijkl.wrpc.codec.Encoder;
import org.wuuijkl.wrpc.codec.JSONDecoder;
import org.wuuijkl.wrpc.codec.JSONEncoder;
import org.wuuijkl.wrpc.transport.HTTPTransportClient;
import org.wuuijkl.wrpc.transport.TransportClient;

import java.util.Arrays;
import java.util.List;

/**
 * @Author wade
 * @Date 2022/3/20 10:17
 * @Description
 */
@Data
public class RpcClientConfig {
    private Class<? extends TransportClient> transportClass =
            HTTPTransportClient.class;

    private Class<? extends Encoder> encodeClass = JSONEncoder.class;
    private Class<? extends Decoder> decodeClass = JSONDecoder.class;

    private Class<? extends TransportSelector> selectorClass =
            RandomTransportSelector.class;

    private int connectCount = 1;

    private List<Peer> severs = Arrays.asList(
            new Peer("127.0.0.1", 3000)
    );
}
