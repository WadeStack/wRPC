package org.wuuijkl.wrpc.codec;

/**
 * @Author wade
 * @Date 2022/3/19 21:44
 * @Description 序列化
 */
public interface Encoder {
    byte[] encode (Object obj);
}
