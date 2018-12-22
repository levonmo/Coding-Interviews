import java.util.ArrayList;
import java.util.Arrays;

/**
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */
public class 最小的k个数 {


    public static void main(String[] args) {
        int [] arr = new int[]{4,5,1,6,2,7,3,8};
        ArrayList<Integer> list = GetLeastNumbers_Solution(arr, 8);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + ",");
        }
    }

    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if (k > input.length) {
            return new ArrayList<Integer>();
        }
        Arrays.sort(input);
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0,j = 0; i < input.length && j < k; i++) {
            if (input[i] != input[i + 1]) {
                list.add(input[i]);
                if (i == input.length - 2) {
                    list.add(input[input.length - 1]);
                    break;
                }
                j++;
            }
        }
        return list;
    }


}
