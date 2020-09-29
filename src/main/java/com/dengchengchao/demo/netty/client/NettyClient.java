package com.dengchengchao.demo.netty.client;

import com.dengchengchao.demo.netty.command.MessageRequestPacket;
import com.dengchengchao.demo.netty.common.PacketCode;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringEncoder;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * @author dengchengchao
 * @date 2020/9/26 12:15
 */
public class NettyClient {

    public static void connect() {
        Bootstrap bootstrap = new Bootstrap();
        NioEventLoopGroup group = new NioEventLoopGroup();

        bootstrap.group(group).channel(NioSocketChannel.class).
                handler(new ChannelInitializer<Channel>() {
                    @Override
                    protected void initChannel(Channel ch) {
                        ch.pipeline().addLast(new ClientHandler());
                    }
                });

        bootstrap.connect("localhost", 8089).addListener(future-> startConsoleThread(((ChannelFuture) future).channel()));

    }

    private static void startConsoleThread(Channel channel) {
        new Thread(() -> {
            while (!Thread.interrupted()) {
                    System.out.println("输入消息发送至服务端: ");
                    Scanner sc = new Scanner(System.in);
                    String line = sc.nextLine();

                    MessageRequestPacket packet = new MessageRequestPacket();
                    packet.setMessage(line);
                    ByteBuf byteBuf = PacketCode.Instance.encode(packet);
                    channel.writeAndFlush(byteBuf);

            }
        }).start();
    }


    public static void main(String[] args) {
        connect();
    }
}
