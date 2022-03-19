package org.wuuijkl.wrpc.codec;

import com.alibaba.fastjson.JSON;

/**
 * @Author wade
 * @Date 2022/3/19 21:49
 * @Description 基于json的序列化实现
 */
public class JSONEncoder implements Encoder {
    @Override
    public byte[] encode(Object obj) {
        return JSON.toJSONBytes(obj);
    }
}
