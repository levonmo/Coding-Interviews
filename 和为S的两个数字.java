import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 */
public class 和为S的两个数字 {

    /**
     *
     * 解题思路:
     *  遍历数组，依次取出数字b，a = sum - b，用二分查找在数组中是否存在a，存在的话就将这两个数存储到map中
     *  后面再从map中取出乘积最小的就行，比较简单
     */
    public static ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < array.length; i++) {
            int a = sum - array[i];
            int k = Arrays.binarySearch(array, a);
            if (k < 0) {
                continue;
            }
            int b = array[k];
            map.put(array[i], b);
        }
        if (map.size() == 0) return new ArrayList<Integer>();
        int totalMin = 0;
        int minKey = 0;
        boolean ff = true;
        for (Integer i : map.keySet()) {
            if (ff){
                totalMin = map.get(i) * i;
                minKey = i;
                ff = false;
                continue;
            }
            int total = i * map.get(i);
            if (total < totalMin) {
                minKey = i;
                totalMin = total;
            }
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(map.get(minKey) < minKey ? map.get(minKey) : minKey);
        list.add(totalMin / list.get(0));
        return list;
    }

}