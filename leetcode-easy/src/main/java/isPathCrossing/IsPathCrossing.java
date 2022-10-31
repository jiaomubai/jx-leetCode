package isPathCrossing;

/**
 * @ClassName: IsPathCrossing
 * @Description: leetCode-1496: 判断路径是否相交
 * @Author: jiaoxian
 * @Date: 2022/9/29 14:05
 **/
public class IsPathCrossing {

    public boolean isPathCrossing(String path) {
        // 根据上北下南左西右东规定: 向北(N)代表数值 +2, 向东(E)代表数值 +1, 向南(S)代表数值 -2, 向西(W)代表数值 -1
        // 遍历 path, 使用 result1 记录南北方向的路径和, result2 记录东西方向的路径和, 如果南北方向或者东西方向的路径和等于 0, 则证明路径有相交, 直接返回 true
        int result1 = 0;
        int result2 = 0;
        for (int i = 0; i < path.length(); i++) {
            char c = path.charAt(i);
            if (c == 'N') {
                result1 += 2;
                if (result1 == 0) {
                    return true;
                }
            } else if (c == 'E'){
                result2 += 1;
                if (result2 == 0) {
                    return true;
                }
            } else if (c == 'S') {
                result1 -= 2;
                if (result1 == 0) {
                    return true;
                }
            } else {
                result2 -= 1;
                if (result2 == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        IsPathCrossing isPathCrossing = new IsPathCrossing();
        System.out.println(isPathCrossing.isPathCrossing("ES"));
    }

}
