package com.dengchengchao.demo.netty.common;


/**
 * @author dengchengchao
 * @date 2020/9/27 21:56
 */
public interface Serializer {


    Serializer DEFAULT = new JsonSerializer();

    /**
     * 序列化算法
     *
     * @return
     */
    byte getSerializerAlgorithm();

    /**
     * java 对象转换成二进制
     */
    byte[] serialize(Object object);

    /**
     * 二进制转换成 java 对象
     */
    <T> T deserialize(Class<T> clazz, byte[] bytes);
}
