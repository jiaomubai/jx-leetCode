package countNicePairs;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author jiaoxian
 * @name countNicePairs
 * @date 2023/1/17 9:02
 * @description leetCode-1814: 统计一个数组中好对子的数目
 */
public class CountNicePairs {


    public int countNicePairs(int[] nums) {

//        System.out.println(count);
//        return count % 1000000007;
        return 0;
    }



    public int getRecv(int num) {
        StringBuilder numStringBuilder = new StringBuilder(String.valueOf(num));
        return Integer.parseInt(numStringBuilder.reverse().toString());
    }

    public static void main(String[] args) {

//        try {
//            Socket socket = new Socket();
//            OutputStream outputStream = null;
//            InputStream inputStream = null;
//            DataInputStream dataInputStream = null;
//            DataOutputStream dataOutputStream = null;
//
//            socket = new Socket("127.0.0.1", 8080);
//            System.out.println("---客户端---");
//            String request = "你好aaaa";
//            System.out.println("客户端发送：" + request);
//            outputStream = socket.getOutputStream();
//            dataOutputStream = new DataOutputStream(outputStream);
//            dataOutputStream.writeUTF(request);
//
//
////        接收服务器返回内容
//            inputStream = socket.getInputStream();
//            dataInputStream = new DataInputStream(inputStream);
//            dataInputStream.toString();
//            String response = dataInputStream.readUTF();
//            System.out.println("服务器响应：" + response);
//
//
////        释放资源
//            socket.close();
//            outputStream.close();
//            inputStream.close();
//            dataInputStream.close();
//            dataOutputStream.close();
//        } catch(Exception e) {
//
//        }



        try {

            InetAddress inetAddress = InetAddress.getByName("");
            byte[] data = "".getBytes("GBK");

            // 发送
            DatagramPacket packet = new DatagramPacket(data, data.length, inetAddress, 0);
            DatagramSocket datagramSocket = new DatagramSocket();
            datagramSocket.send(packet);

            // 接收
            byte[] recvData = new byte[1024];
            DatagramPacket recvPacket = new DatagramPacket(recvData, recvData.length);
            datagramSocket.receive(recvPacket);
            String info = new String(recvData, 0, recvPacket.getLength());
//            logger.info("接收到的信息为:" + info);

            datagramSocket.close();


        } catch (Exception e) {

            e.printStackTrace();
        }


    }

}
