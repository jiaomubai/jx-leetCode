package validIPAddress;

/**
 * @ClassName: ValidIPAddress
 * @Author: jiaoxian
 * @Date: 2022/5/29 09:25
 * @Description: leetCode-468: 验证IP地址
 */
public class ValidIPAddress {

    private final static int IPV4_LENGTH = 4;

    private final static int IPV6_LENGTH = 8;

    public static String validIPAddress(String queryIP) {
        if (isIpv4Address(queryIP)) {
            return "IPv4";
        } else if (isIpv6Address(queryIP)) {
            return "IPv6";
        } else {
            return "Neither";
        }
    }

    private static boolean isIpv4Address(String queryIp) {
        String[] partIps = queryIp.split("\\.", -1);
        if (partIps.length != IPV4_LENGTH) {
            return false;
        }
        for (String partIp : partIps) {
            if (partIp.length() > 1 && partIp.startsWith("0")) {
                return false;
            }
            if (partIp.length() > 3 || partIp.length() < 1) {
                return false;
            }
            for (char c : partIp.toCharArray()) {
                if (!Character.isDigit(c)) {
                    return false;
                }
            }
            if (Integer.parseInt(partIp) > 255) {
                return false;
            }
        }
        return true;
    }

    private static boolean isIpv6Address(String queryIp) {
        String[] partIps = queryIp.split(":", -1);
        if (partIps.length != IPV6_LENGTH) {
            return false;
        }
        for (String partIp : partIps) {
            partIp = partIp.toLowerCase();
            if (partIp.length() > 4 || partIp.length() < 1) {
                return false;
            }
            for (char c : partIp.toCharArray()) {
                boolean flag = (c >= '0' && c <= '9') || (c >= 'a' && c <= 'f');
                if (!flag) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String queryIpv4 = "1.0.1.";
        System.out.println(validIPAddress(queryIpv4));
        String queryIpv6 = "2001:0db8:85a3:0:0:8A2E:0370:7334:";
        System.out.println(validIPAddress(queryIpv6));
    }

}
