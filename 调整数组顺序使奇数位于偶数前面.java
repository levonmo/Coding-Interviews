/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class 调整数组顺序使奇数位于偶数前面 {

    public static void reOrderArray(int [] array) {
        for (int i = 0; i < array.length; i++) {
            //从零开始选择奇数,遇到单数就进入for循环,单数跟前一个进行比较，如果是复数就互换位置，如果是单数就结束该单数的插入,进入剩余单数的for循环
            if ((array[i] % 2) != 0) {
                for (int ii = i; ii > 0; ii--) {
                    //遇到复数交换位置
                    if ((array[ii - 1] % 2) == 0) {
                        int temp = array[ii - 1];
                        array[ii - 1] = array[ii];
                        array[ii] = temp;
                    } else {
                        break;
                    }
                }
            } else {
                continue;
            }
        }
    }

}
