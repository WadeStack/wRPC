package org.wuuijkl.wrpc.codec;

/**
 * @Author wade
 * @Date 2022/3/19 21:46
 * @Description εεΊεε
 */
public interface Decoder {
    <T> T decode(byte[] bytes, Class<T> clazz);
}
