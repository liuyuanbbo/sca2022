package org.netty4.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class TestConnectClient {
    public static void main(String[] args) {
        NioEventLoopGroup clientGroup = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();

        try {
            ChannelFuture cf = bootstrap.group(clientGroup)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) {
                            ch.pipeline()
                                    .addLast(new Auth1Handler());
                        }
                    })
                    //.connect("106.14.223.10", 8500);
                    .connect("localhost", 9999).sync();
            cf.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            clientGroup.shutdownGracefully();
        }

    }

    static class Auth1Handler extends ChannelInboundHandlerAdapter {

        @Override
        public void channelActive(ChannelHandlerContext ctx) {
            String auth = """
                    <?xml version="1.0" encoding="UTF-8"?>
                    <root>
                      <common>
                        <building_id>PTJK2022617</building_id>
                        <gateway_id>00010C31BDDE1C60</gateway_id>
                        <type>id_validate</type>
                      </common>
                      <id_validate operation="request">
                      </id_validate>
                    </root>                                        
                    """;
            byte[] bytes = auth.getBytes();

            ByteBuf byteBuf = ByteBufAllocator.DEFAULT.directBuffer();

            //2 个字节的头
            //byteBuf.writeShort(0x1F1F);
            //1 个字节的消息类型
            //byteBuf.writeByte(0x1);
            //byteBuf.writeInt(bytes.length);
            byteBuf.writeBytes(bytes);
            ctx.channel().writeAndFlush(byteBuf);
        }

        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) {
            ByteBuf buf = (ByteBuf) msg;
            try {
                byte[] bytes = new byte[buf.readableBytes()];
                buf.readBytes(bytes);
                System.out.println(new String(bytes));
            } finally {
                buf.release();
            }
        }
    }
}
