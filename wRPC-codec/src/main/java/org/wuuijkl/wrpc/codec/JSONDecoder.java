package org.wuuijkl.wrpc.codec;

import com.alibaba.fastjson.JSON;

/**
 * @Author wade
 * @Date 2022/3/19 21:50
 * @Description 基于json的反序列化
 */
public class JSONDecoder implements Decoder {
    @Override
    public <T> T decode(byte[] bytes, Class<T> clazz) {
        return JSON.parseObject(bytes, clazz);
    }
}
