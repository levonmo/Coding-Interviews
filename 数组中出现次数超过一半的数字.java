import java.util.Arrays;
import java.util.HashMap;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class 数组中出现次数超过一半的数字 {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,2,4,2,5,2,3};
        int i = MoreThanHalfNum_Solution(arr);
        System.out.println(i);
    }

    //先排序，后面再与中间的值进行比较，如果所有的值都进行对比了，相等的个数大于数组长度的一半的话，那么就是有符合题意的数字
    public static int MoreThanHalfNum_Solution(int[] array) {
        Arrays.sort(array);
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == array[array.length / 2]) {
                count++;
            }
        }
        if (count > array.length / 2) {
            return array[array.length / 2];
        } else {
            return 0;
        }
    }

    //HashMap方法
    public static int MoreThanHalfNum_Solution_HashMap(int [] array) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < array.length; i++) {
            int i1 = array[i];
            Integer integer = map.get(i1);
            if (integer != null) {
                map.put(array[i], ++integer);
            } else {
                map.put(array[i], 1);
            }
        }
        for (Integer ii : map.keySet()) {
            if (map.get(ii) > array.length / 2) {
                return ii;
            }
        }
        return -1;
    }

}
