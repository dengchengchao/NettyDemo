package com.dengchengchao.demo.netty.command;

/**
 * @author dengchengchao
 * @date 2020/9/28 12:00
 */
public class MessageResponsePacket extends Packet {

    String message;

    @Override
    public Byte getCommand() {
        return Command.MESSAGE_RESPONSE;
    }
}
