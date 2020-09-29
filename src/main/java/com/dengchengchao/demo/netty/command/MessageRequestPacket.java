package com.dengchengchao.demo.netty.command;

import lombok.Data;

/**
 * @author dengchengchao
 * @date 2020/9/28 10:06
 */
@Data
public class MessageRequestPacket extends Packet {

    String message;

    @Override
    public Byte getCommand() {
        return Command.MESSAGE_REQUEST;
    }
}
