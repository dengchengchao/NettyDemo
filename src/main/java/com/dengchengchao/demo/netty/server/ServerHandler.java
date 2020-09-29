package com.dengchengchao.demo.netty.server;

import com.dengchengchao.demo.netty.command.LoginRequestPacket;
import com.dengchengchao.demo.netty.command.LoginResponsePacket;
import com.dengchengchao.demo.netty.command.MessageRequestPacket;
import com.dengchengchao.demo.netty.command.Packet;
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
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        ByteBuf byteBuf = (ByteBuf) msg;
        Packet packet = PacketCode.Instance.decode(byteBuf);
        if (packet instanceof LoginRequestPacket) {
            LoginRequestPacket logPacket = (LoginRequestPacket) packet;
            LoginResponsePacket responsePacket = new LoginResponsePacket();
            if (valid(logPacket)) {
                responsePacket.setCode("0000");
                responsePacket.setMessage("登录成功");
            } else {
                responsePacket.setCode("0001");
                responsePacket.setMessage("账号密码错误，请重试");
            }

            ByteBuf responseBuf = PacketCode.Instance.encode(responsePacket);
            ctx.channel().writeAndFlush(responseBuf);

        } else if (packet instanceof MessageRequestPacket) {
            MessageRequestPacket messageRequestPacket = (MessageRequestPacket) packet;
            System.out.println("收到客户端的消息：" + messageRequestPacket.getMessage());
        }
    }


    private boolean valid(LoginRequestPacket packet) {
        String userName = packet.getUserName();
        String password = packet.getPassword();
        return ("dcc".equals(userName) && "123456".equals(password));

    }
}
