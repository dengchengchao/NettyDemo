package com.dengchengchao.demo.netty.client;

import com.dengchengchao.demo.netty.common.LoginRequestPacket;
import com.dengchengchao.demo.netty.common.PacketCode;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.ByteBuffer;
import java.util.Random;
import java.util.UUID;

/**
 * @author dengchengchao
 * @date 2020/9/27 21:06
 */
public class ClientHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        LoginRequestPacket packet = new LoginRequestPacket();
        packet.setUserName("dcc");
        packet.setPassword("123456");
        packet.setUserId(UUID.randomUUID().toString());
        ByteBuf byteBuf = PacketCode.Instance.encode(packet);
        ctx.channel().writeAndFlush(byteBuf);
        System.out.println("发送登录消息....");
    }
}
