package com.dengchengchao.demo.netty.command;

import lombok.Getter;
import lombok.Setter;

/**
 * @author dengchengchao
 * @date 2020/9/26 22:50
 */
@Getter
@Setter
public class LoginRequestPacket extends Packet {

    private String userId;

    private String userName;

    private String password;

    @Override
    public Byte getCommand() {
        return Command.LOGIN_REQUEST;
    }

}
