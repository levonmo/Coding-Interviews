import java.util.Arrays;

/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了偶数次。请写程序找出这两个只出现一次的数字。
 *
 */
public class 数组中只出现一次的数字 {

    //num1,num2分别为长度为1的数组。传出参数
    //将num1[0],num2[0]设置为返回结果
    public static void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        Arrays.sort(array);
        for (int i = 0; i < array.length - 1;) {
            if (array[i] == array[i + 1]) {
                i = i + 2;
            } else {
                if (num1[0] == 0) {
                    num1[0] = array[i];
                } else {
                    num2[0] = array[i];
                }
                i++;
            }
        }
        if (array[array.length - 1] != array[array.length - 2]) {
            num2[0] = array[array.length - 1];
        }
    }

}
