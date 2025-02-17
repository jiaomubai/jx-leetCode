package islandPerimeter;

/**
 * @ClassName: IslandPerimeter
 * @Description: leetCode-463: 岛屿的周长
 * @Author: jiaoxian
 * @Date: 2025-02-06 13:50:37
 * @Version: 1.0
 **/

public class IslandPerimeter {

    // 循环数组非边界部分, 若 grid[i][j] == 1, 则判断其上下左右, 若为水域, 则岛屿总周长+1, 即 grid[i-1][j](左) == 0, grid[i+1][j](右) == 0, grid[i][j-1](上) == 0, grid[i][j+1](下) == 0 时, 总周长+1
    // 数组边界部分单独处理, 若为陆地, 则+1
    public int islandPerimeter(int[][] grid) {
        int result = 0;
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // 若为陆地
                if (grid[i][j] == 1) {
                    // 处理边界部分
                    if (i == 0 || i == row - 1 || j == 0 || j == col - 1) {
                        if (i == 0) {
                            result++;
                            // 上边界, 判断左、右、下是否为水域
                            // 其中左上角, 即 i == 0 && j == 0 只需要判断右、下是否为水域
                            // 其中右上角, 即 i == 0 && j == col - 1 只需要判断左、下是否为水域
                            if (i != row - 1) {
                                if (grid[i + 1][j] == 0) {
                                    // 下边为水域
                                    result++;
                                }
                            } else {
                                result++;
                            }
                            if (j != col - 1) {
                                if (grid[i][j + 1] == 0) {
                                    // 右边为水域
                                    result++;
                                }
                            } else {
                                result++;
                            }
                            if (j != 0) {
                                if (grid[i][j - 1] == 0) {
                                    // 左边为水域
                                    result++;
                                }
                            } else {
                                result++;
                            }
                            continue;
                        }
                        if (i == row - 1) {
                            result++;
                            // 下边界, 判断左、右、上是否为水域
                            // 其中左下角, 即 i == row - 1 && j == 0 只需要判断右、上是否为水域
                            // 其中右下角, 即 i == row - 1 && j == col - 1 只需要判断左、上是否为水域
                            if (i != 0) {
                                if (grid[i - 1][j] == 0) {
                                    // 上边为水域
                                    result++;
                                }
                            } else {
                                result++;
                            }
                            if (j != col - 1) {
                                if (grid[i][j + 1] == 0) {
                                    // 右边为水域
                                    result++;
                                }
                            } else {
                                result++;
                            }
                            if (j != 0) {
                                if (grid[i][j - 1] == 0) {
                                    // 左边为水域
                                    result++;
                                }
                            } else {
                                result++;
                            }
                            continue;
                        }
                        if (j == 0) {
                            result++;
                            // 左边界, 判断上、下、右是否为水域
                            // 其中左上角, 即 i == 0 && j == 0 只需要判断右、下是否为水域
                            // 其中左下角, 即 i == row - 1 && j == 0 只需要判断右、上是否为水域
                            if (j != col - 1) {
                                if (grid[i][j + 1] == 0) {
                                    // 右边为水域
                                    result++;
                                }
                            } else {
                                result++;
                            }
                            if (i != 0) {
                                if (grid[i - 1][j] == 0) {
                                    // 上边为水域
                                    result++;
                                }
                            }
                            if (i != row - 1) {
                                if (grid[i + 1][j] == 0) {
                                    // 下边为水域
                                    result++;
                                }
                            }
                            continue;
                        }
                        if (j == col - 1) {
                            result++;
                            // 右边界, 判断上、下、左是否为水域
                            // 其中右上角, 即 i == 0 && j == col - 1 只需要判断左、下是否为水域
                            // 其中右下角, 即 i == row - 1 && j == col - 1 只需要判断左、上是否为水域
                            if ( j != 0) {
                                if (grid[i][j - 1] == 0) {
                                    // 左边为水域
                                    result++;
                                }
                            } else {
                                result++;
                            }
                            if (i != 0) {
                                if (grid[i - 1][j] == 0) {
                                    // 上边为水域
                                    result++;
                                }
                            }
                            if (i != row - 1) {
                                if (grid[i + 1][j] == 0) {
                                    // 下边为水域
                                    result++;
                                }
                            }
                        }
                    } else {
                        // 非边界部分
                        if (grid[i - 1][j] == 0) {
                            // 左边为水域
                            result++;
                        }
                        if (grid[i + 1][j] == 0) {
                            // 右边为水域
                            result++;
                        }
                        if (grid[i][j - 1] == 0) {
                            // 上边为水域
                            result++;
                        }
                        if (grid[i][j + 1] == 0) {
                            // 下边为水域
                            result++;
                        }
                    }
                }
            }
            System.out.println("i = " + i + ", 周长 = " + result);
        }
        return result;
    }

    public int islandPerimeter2(int[][] grid) {
        int result = 0;
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int add = 4;    //方格初始周长
                if (grid[i][j] == 1) {
                    if (i - 1 >= 0 && grid[i - 1][j] == 1) add--;  //上
                    if (i + 1 < m && grid[i + 1][j] == 1) add--;   //下
                    if (j - 1 >= 0 && grid[i][j - 1] == 1) add--;  //左
                    if (j + 1 < n && grid[i][j + 1] == 1) add--;   //右
                    result += add;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] grid = {{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
        int[][] grid1 = {{0}, {1}, {0}};
        System.out.println(new IslandPerimeter().islandPerimeter2(grid1));


    }

}
