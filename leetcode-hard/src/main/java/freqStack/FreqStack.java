package freqStack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jiaoxian
 * @name freqStack
 * @date 2022/12/2 15:01
 * @description leetCode-895: 最大频率栈
 */
public class FreqStack {

    // 将栈序列分解为多个频率不同的栈序列, 每个栈维护同一频率的元素。
    // 当元素入栈时频率增加, 将元素加入到更高频率的栈中, 低频率栈中的元素不需要出栈。
    // 当元素出栈时, 将频率最高的栈的栈顶元素出栈即可。

    // 记录每个元素出现的频率
    private Map<Integer, Integer> freqMap;
    // 不同频率的栈的集合
    private Map<Integer, Deque<Integer>> groupMap;
    // 当前最大频率为 0
    private int maxFreq;

    /**
     * @description 无参构造方法, 初始化
     * @author jiaoxian
     * @date 2022/12/2 15:02
     */
    public FreqStack() {
        freqMap = new HashMap<>();
        groupMap = new HashMap<Integer, Deque<Integer>>();
        maxFreq = 0;
    }

    /**
     * @description push 方法
     * @author jiaoxian
     * @date 2022/12/2 15:02
     * @param val 待入栈的值
     */
    public void push(int val) {
        // 元素入栈时, 更新 freqMap 中该元素的频率值
        freqMap.put(val, freqMap.getOrDefault(val, 0) + 1);
        // 将当前元素按照频率存储进相应的 groupMap 中
        // ArrayDeque: 双端队列
        // arrayDeque.add() 尾插
        // arrayDeque.push() 头插
        groupMap.putIfAbsent(freqMap.get(val), new ArrayDeque<>());
        groupMap.get(freqMap.get(val)).push(val);
        // 更新最大频率
        maxFreq = Math.max(maxFreq, freqMap.get(val));
    }

    /**
     * @description 弹栈
     * @author jiaoxian
     * @date 2022/12/2 15:03
     * @return int
     */
    public int pop() {
        // 弹栈时, 先获取到最大频率的栈顶元素
        int val = groupMap.get(maxFreq).peek();
        // 更新最大频率的元素在 freqMap 中的频率值
        freqMap.put(val, freqMap.get(val) - 1);
        // 将最大频率值对应的元素弹栈
        groupMap.get(maxFreq).pop();
        if (groupMap.get(maxFreq).isEmpty()) {
            // 更新最大频率值
            maxFreq--;
        }
        return val;
    }

    public static void main(String[] args) {
        FreqStack freqStack = new FreqStack();
        freqStack.push(5);
        freqStack.push(7);
        freqStack.push(5);
        freqStack.push(7);
        freqStack.push(4);
        freqStack.push(5);
        System.out.println(freqStack.pop());    // 5
        System.out.println(freqStack.pop());    // 7
        System.out.println(freqStack.pop());    // 5
        System.out.println(freqStack.pop());    // 4
    }

}
