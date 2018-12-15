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
        for (int i = 0; i < 32; i++) {
            // & --> 遇到0为0，没0为1
            // 与 n 的个位进行比较，当个位为1是，n&1=1，否则n&1=0,再整体>>一位，再次比较个位，这样就可以得到二进制数1的位数了
            int ii = n & 1;
            if (ii == 1) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }

}
