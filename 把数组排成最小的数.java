/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class 把数组排成最小的数 {

    /**
     *
     * 解题思路:
     *      例如: 3，32 --> 先计算那个组合比较大，332 > 323，所以叫3与32交换位置。32，3
     *      用一个冒泡排序依次这样比较，等到一个数组，将最大的冒到最后。这样遍历数组就等待题意的答案了
     */
    public static String PrintMinNumber(int [] arr) {
        for (int i = 0; i < arr.length; i++ ){
            for (int ii = 0; ii < arr.length - i - 1; ii++) {
                long a = Long.parseLong(arr[ii] + "" + arr[ii + 1]);
                long b = Long.parseLong(arr[ii + 1] + "" + arr[ii]);
                if (a > b) {
                    int temp = arr[ii];
                    arr[ii] = arr[ii + 1];
                    arr[ii + 1] = temp;
                }
            }
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }
        return sb.toString();
    }
}
