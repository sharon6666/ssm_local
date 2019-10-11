package com.javese.io;

import java.io.FileInputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: ssm
 * @Package: com.io
 * @Description: note
 * @Author:
 * @CreateDate: 2019-8-20 13:52
 * @UpdateUser:
 * @UpdateDate: 2019-8-20 13:52
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 **/
public class TestIntBuffer {
    public static void main(String[] args) throws Exception {
        // 分配新的int缓冲区，参数为缓冲区容量
        // 新缓冲区的当前位置将为零，其界限(限制位置)将为其容量。它将具有一个底层实现数组，其数组偏移量将为零。

        IntBuffer buffer = IntBuffer.allocate(10);
        for(int i=0;i<buffer.capacity();i++){
            int j = 2*(i+1);			// 将给定整数写入此缓冲区的当前位置，当前位置递增

            buffer.put(j);
        }
        // 重设此缓冲区，将限制设置为当前位置，然后将当前位置设置为0
        buffer.flip();

        //查看在当前位置和限制位置之间是否有元素
        while (buffer.hasRemaining()){
            int j = buffer.get();
            System.out.print(j + "  ,");
        }

//        getData();
        writeData();
    }

    //简单的使用NIO从文件中读取数据的例子：
    private static void getData() throws Exception{
        FileInputStream fis = new FileInputStream("d:\\法律题.txt");
        FileChannel fc = fis.getChannel();
        ByteBuffer bb = ByteBuffer.allocate(1024);
        int count = fc.read(bb);
        System.out.println();

        while (count != -1) {
            bb.flip();
            CharBuffer charBuffer = CharBuffer.allocate(1024);
            Charset charset = Charset.forName("GBK");
            CharsetDecoder decoder = charset.newDecoder();
            decoder.decode(bb, charBuffer, true);
            charBuffer.flip();
            while (charBuffer.hasRemaining()){
                System.out.print(charBuffer.get());
            }
            bb.clear();
            count = fc.read(bb);
        }
        fc.close();
        fis.close();
    }

    private static void writeData() throws Exception{
        RandomAccessFile file = new RandomAccessFile("d:\\法律题1.txt", "rw");
        FileChannel fc = file.getChannel();
        ByteBuffer bb = ByteBuffer.allocate(1024);
        bb.put("10.2号结婚".getBytes("GBK"));
        bb.flip();
        fc.write(bb);
        fc.close();
        file.close();
    }
}
