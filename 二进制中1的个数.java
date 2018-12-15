import java.math.BigInteger;

/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 *
 */
public class 二进制中1的个数 {

    public static void main(String[] args) {
        int i = NumberOf1(-2147483648);
        System.out.println(i);

    }

    /**
     * 这里的最高为符号位不算入 1 的个数
     *
     */
    public static int NumberOf1(int n) {
        int count = 0;
        int nn = n;
        for (int i = 0; i < 32; i++) {
            int ii = n & 1;
            if (ii == 1) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }


}
