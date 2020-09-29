package com.dengchengchao.demo.netty.command;

import lombok.Data;

/**
 * @author dengchengchao
 * @date 2020/9/28 10:34
 */
@Data
public class LoginResponsePacket extends Packet{

    private String code;

    private String message;

    @Override
    public Byte getCommand() {
        return Command.LOGIN_RESPONSE;
    }
}
