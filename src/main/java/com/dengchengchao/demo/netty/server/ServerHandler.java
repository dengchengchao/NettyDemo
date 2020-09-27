package com.dengchengchao.demo.netty.server;

import com.dengchengchao.demo.netty.common.LoginRequestPacket;
import com.dengchengchao.demo.netty.common.Packet;
import com.dengchengchao.demo.netty.common.PacketCode;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author dengchengchao
 * @date 2020/9/27 22:27
 */
public class ServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteBuf=(ByteBuf)msg;
        Packet packet= PacketCode.Instance.decode(byteBuf);
        if (packet instanceof LoginRequestPacket){
            LoginRequestPacket logPacket = (LoginRequestPacket)packet;
            String userName = logPacket.getUserName();
            String password=logPacket.getPassword();
            if ("dcc".equals(userName) && "123456".equals(password) ){
                System.out.println("登录成功");
            }
        }
    }
}
