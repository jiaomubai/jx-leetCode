//package socket;
//
//import java.io.*;
//import java.net.InetSocketAddress;
//import java.net.Socket;
//import java.net.SocketAddress;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Map;
//
///**
// * @author jiaoxian
// * @name socket
// * @date 2023/3/9 9:36
// * @description TODO
// */
//public class SocketTest {
//
//    private static Socket socket;
//    private static InputStream inputstream;
//    private static OutputStream outputstream;
//    private static BufferedInputStream bufferedinputstream;
//    private static BufferedOutputStream bufferedoutputstream;
//
//
//    /**
//     * 发送请求数据
//     *
//     * @param data
//     * @param start
//     * @param end
//     * @return
//     */
//    public int write(byte data[]) {
//        if (data == null || data.length == 0 || !connected) {
//            return 0;
//        }
//        try {
//            m_bufferedoutputstream.write(data, 0, data.length);
//            m_bufferedoutputstream.flush();
//        } catch (Exception e) {
//            return -1;
//        }
//        return 0;
//    }
//
//    /**
//     * 读取返回数据
//     *
//     * @return
//     */
//    public byte[] read() {
//        if (!connected) {
//            return null;
//        }
//        try {
//            return readStream(m_bufferedinputstream);
//        } catch (Exception e) {
//            return null;
//        }
//    }
//
//    /**
//     * @功能 读取流
//     * @param inStream
//     * @return 字节数组
//     * @throws Exception
//     */
//    public static byte[] readStream(InputStream inStream) throws Exception {
//        ByteArrayOutputStream outSteam = new ByteArrayOutputStream();
//        byte[] buffer = new byte[1024];
//        int len = -1;
//        while ((len = inStream.read(buffer)) != -1) {
//            outSteam.write(buffer, 0, len);
//        }
//        outSteam.close();
//        inStream.close();
//        return outSteam.toByteArray().toString();
//    }
//
//    public static void test() {
//        SocketClient client = new SocketClient();
//        // 建立socket对象
//        int iret = client.connect("192.168.1.105", 1234);
//        if (iret == 0) {
//            // 发送数据
//            client.write("helloworld".getBytes());
//            // 接收数据
//            byte data[] = client.read();
//            if ((data != null) && (data.length != 0)) {
//                // 处理接收结果
//                Utils.print("响应报文字节数组---->" + Arrays.toString(data));
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        String ip = "124.117.242.122";
//        int port = 54082;
//        String requestData = ctx.getCommandNew;
//
//// 初始化
//        try {
//            SocketAddress socketAddress = new InetSocketAddress(ip, port);
//            socket = new Socket();
//            socket.connect(socketAddress, 5000);
//            socket.setSoTimeout(60000);
//
//            inputstream = socket.getInputStream();
//            bufferedinputstream = new BufferedInputStream(inputstream);
//            outputstream = socket.getOutputStream();
//            bufferedoutputstream = new BufferedOutputStream(outputstream);
//        } catch (Exception e) {
////            logger.error("初始化异常：" + e.getMessage());
//            e.printStackTrace();
//        }
//
//// 发送数据
//        try {
//            if (requestData != null && requestData.length() > 0) {
//                byte[] data = requestData.getBytes("GBK");
//                bufferedoutputstream.write(data, 0, data.length);
//                bufferedoutputstream.flush();
//            }
//        } catch (Exception e) {
////            logger.error("发送银行异常：" + e.getMessage());
//            e.printStackTrace();
//        }
//
//// 接收数据
//        try {
//            ByteArrayOutputStream outSteam = new ByteArrayOutputStream();
//            byte[] buffer = new byte[1024];
//            int len = -1;
//            while ((len = bufferedinputstream.read(buffer)) != -1) {
//                outSteam.write(buffer, 0, len);
//            }
//            outSteam.close();
//            bufferedinputstream.close();
//            new String(outSteam.toByteArray());
////            return outSteam.toByteArray();
//        } catch (Exception e) {
////            logger.error("接收银行数据异常：" + e.getMessage());
//            e.printStackTrace();
//        }
//        String str = "";
//        str.getBytes("GBK").length;
//
//        List<Map<String, String>> list = new ArrayList<>();
//        list.size();
//        for (Map<String, String> map : list) {
//            map.size();
//        }
//    }
//
//}
