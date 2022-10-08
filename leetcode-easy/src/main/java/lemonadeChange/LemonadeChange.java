package lemonadeChange;

/**
 * @ClassName: LemonadeChange
 * @Description: leetCode-860: 柠檬水找零
 * @Author: jiaoxian
 * @Date: 2022/10/8 15:43
 **/
public class LemonadeChange {

    // 暴力（贪心解法）
    // 由于顾客只可能给三个面值的钞票, 而且我们一开始没有任何钞票, 因此我们拥有的钞票面值只可能是 5 美元, 10 美元和 20 美元三种.
    // 基于此, 我们可以进行分类讨论.
    // 如果顾客给的是 5 美元, 由于柠檬水的价格也为 5 美元, 因此我们直接收下即可;
    // 如果顾客给的是 10 美元, 我们需要找回 5 美元, 如果没有 5 美元面值的钞票, 则无法正确找零;
    // 如果顾客给的是 20 美元, 我们需要找回 15 美元, 此时有两种组合方式, 一种是一张 10 美元和一张 5 美元的钞票, 一种是 3 张 5 美元的钞票,
    // 如果两种组合方式都没有, 则无法正确找零. 当可以正确找零时, 两种找零的方式中我们更倾向于第一种, 即如果存在 5 美元和 10 美元, 我们就按第一种方式找零,否则按第二种方式找零, 因为需要使用 5 美元的找零场景会比需要使用 10 美元的找零场景多, 我们需要尽可能保留 5 美元的钞票.
    // 因此我们维护两个变量 five 和 ten 来分别记录 5 美元和 10 美元钞票的数量, 之后从前往后遍历 bills[] 进行分类讨论即可
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        for (int bill : bills) {
            if (bill == 5) {
                // 如果是 5 美元, 则不需要找零, 同时 5 美元钞票的数量加 1 即可
                five++;
            } else if (bill == 10) {
                // 如果是 10 美元, 则需要找零
                if (five == 0) {
                    // 需要找回顾客 5 美元的情况下, 如果 5 美元的数量为 0, 则无法找零, 返回 false 即可
                    return false;
                }
                // 找零之后, 5 美元钞票的数量减 1, 10 美元钞票的数量加 1
                five--;
                ten++;
            } else {
                // 如果是 20 美元, 则需要找零
                if (five > 0 && ten > 0) {
                    // 需要找零的情况下, 优先考虑采用一张 10 美元和一张 5 美元的方式找零
                    five--;
                    ten--;
                } else if (five >= 3) {
                    // 如果 10 美元加 5 美元的组合不存在, 则考虑使用三张 5 美元的方式找零
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LemonadeChange lemonadeChange = new LemonadeChange();
        int[] bills = new int[]{5,5,20,20};
        System.out.println(lemonadeChange.lemonadeChange(bills));
    }

}
