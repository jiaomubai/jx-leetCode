package structure.queue;

/**
 * @ClassName: Queue
 * @Author: jiaomubai
 * @Date: 2022/1/30 14:59
 * @Description:
 */
public class Queue {

    private int[] dataArray;
    private int front;
    private int rear;

    public Queue(int capacity) {
        this.dataArray = new int[capacity];
    }

    public void enQueue(int element) {
        if ((rear + 1) % dataArray.length == front) {
            System.out.println("队已满");
            System.out.println();
            return;
        }
        dataArray[rear] = element;
        rear = (rear + 1) % dataArray.length;
        System.out.println("入队后队头元素为:" + dataArray[front]);
        System.out.println("入队后队尾元素为:" + element);
        System.out.println();
    }

    public int deQueue() {
        if (rear == front) {
            System.out.println("队已空");
            System.out.println();
        }
        int deQueueElement = dataArray[front];
        front = (front + 1) % dataArray.length;
        System.out.println("出队后队头元素为:" + dataArray[front]);
        System.out.println("出队后队尾元素为:" + dataArray[rear - 1]);
        System.out.println();
        return deQueueElement;
    }

    public void print() {
        for (int i = front; i != rear - 1; i = (i + 1) % dataArray.length) {
            System.out.print(dataArray[i] + " --> ");
        }
        System.out.println(dataArray[rear - 1]);
        System.out.println();
    }

    public static void main(String[] args) {
        Queue queue = new Queue(6);
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.enQueue(4);
        queue.enQueue(5);
        queue.enQueue(6);
        queue.print();
        queue.deQueue();
        queue.deQueue();
        queue.deQueue();
        queue.print();
        queue.enQueue(6);
        queue.enQueue(7);
        queue.print();
    }

}
