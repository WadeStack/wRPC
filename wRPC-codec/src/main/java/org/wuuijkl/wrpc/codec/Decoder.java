package org.wuuijkl.wrpc.codec;

/**
 * @Author wade
 * @Date 2022/3/19 21:46
 * @Description 反序列化
 */
public interface Decoder {
    <T> T decode(byte[] bytes, Class<T> clazz);
}
