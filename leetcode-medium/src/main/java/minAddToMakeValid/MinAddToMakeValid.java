package minAddToMakeValid;

/**
 * @ClassName: MinAddToMakeValid
 * @Description: leetCode-921: 使括号有效的最少添加
 * @Author: jiaoxian
 * @Date: 2022/10/8 17:57
 **/
public class MinAddToMakeValid {

    // 贪心
    // 循环遍历字符串 s, 使用 left 记录左括号的数量, result 记录需要添加的括号的数量
    // 如果是左括号, 则直接 left 加 1; 如果是右括号, 则涉及到左右括号匹配的问题.
    // 则如果遍历到的是右括号, 且此时左括号数量不为 0, 则认为左右括号是匹配的, 所以此时 left 减 1
    // 如果此时左括号数量为 0, 则认为左右括号不匹配, 且需要添加一个左括号才能正确匹配, 则此时 result 加 1
    // 最后返回 result + left 即为需要最少添加的次数

    public int minAddToMakeValid(String s) {
        int left = 0;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                if (left < 1) {
                    result++;
                } else {
                    left--;
                }
            }
        }
        return result + left;
    }

    public static void main(String[] args) {
        MinAddToMakeValid minAddToMakeValid = new MinAddToMakeValid();
        String s = "()())((()";
        System.out.println(minAddToMakeValid.minAddToMakeValid(s));
    }

}
