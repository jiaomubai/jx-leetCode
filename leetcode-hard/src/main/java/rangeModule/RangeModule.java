package rangeModule;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * @ClassName: RangeModule
 * @Author: jiaoxian
 * @Date: 2022/6/20 08:52
 * @Description:
 */
public class RangeModule {

    List<Integer> rangeList;

    public RangeModule() {
        rangeList = new ArrayList<>();
    }

    public void addRange(int left, int right) {
        for (int i = left; i < right; i++) {
            if (rangeList.contains(i)) {
                continue;
            }
            rangeList.add(i);
        }
        Collections.sort(rangeList);
    }

    public boolean queryRange(int left, int right) {
        for (int i = left; i < right; i++) {
            if (!rangeList.contains(i)) {
                System.out.println(false);
                return false;
            }
        }
        System.out.println(true);
        return true;
    }

    public void removeRange(int left, int right) {
        for (int i = left; i < right; i++) {
            Iterator<Integer> iterator = rangeList.iterator();
            while (iterator.hasNext()) {
                Integer value = iterator.next();
                if(value.equals(i)) {
                    iterator.remove();
                    break;
                }
            }
        }
    }

    public void display() {
        for (int i = 0; i < rangeList.size(); i++) {
            System.out.print(rangeList.get(i) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        RangeModule rangeModule = new RangeModule();
        rangeModule.addRange(5, 7);
        rangeModule.display();
        rangeModule.queryRange(2, 7);
        rangeModule.display();
        rangeModule.addRange(6, 9);
        rangeModule.display();
        rangeModule.queryRange(2, 9);
        rangeModule.display();
        rangeModule.addRange(2, 7);
        rangeModule.display();
        rangeModule.removeRange(3, 10);
        rangeModule.display();
        rangeModule.removeRange(1, 8);
        rangeModule.display();
        rangeModule.removeRange(1, 10);
        rangeModule.display();
        rangeModule.queryRange(4, 7);
        rangeModule.display();
    }

}
