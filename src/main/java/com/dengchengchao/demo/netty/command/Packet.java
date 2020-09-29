package com.dengchengchao.demo.netty.command;

import lombok.Data;
import lombok.Getter;

/**
 * @author dengchengchao
 * @date 2020/9/26 22:46
 */
@Data
public abstract class Packet {

    private Byte version = 1;

    public abstract Byte getCommand();
}
