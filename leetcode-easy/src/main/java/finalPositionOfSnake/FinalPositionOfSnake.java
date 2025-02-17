package finalPositionOfSnake;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @ClassName: FinalPositionOfSnake
 * @Description: leetCode-3248:矩阵中的蛇
 * @Author: jiaoxian
 * @Date: 2025-01-10 15:05:09
 * @Version: 1.0
 **/

public class FinalPositionOfSnake {

    public int finalPositionOfSnake(int n, List<String> commands) {
        int i = 0, j = 0;
        for (String command : commands) {
            if (Objects.equals(command, "UP")) {
                i--;
                continue;
            }
            if (Objects.equals(command, "DOWN")) {
                i++;
                continue;
            }
            if (Objects.equals(command, "LEFT")) {
                j--;
                continue;
            }
            if (Objects.equals(command, "RIGHT")) {
                j++;
                continue;
            }
        }
        return (i * n) + j;
    }

    public static void main(String[] args) {
        int n = 3;
        List<String> commands = new ArrayList<>();
        commands.add("DOWN");
        commands.add("RIGHT");
        commands.add("UP");
        commands.add("LEFT");
        System.out.println(new FinalPositionOfSnake().finalPositionOfSnake(n, commands));
    }

}
