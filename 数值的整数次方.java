/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 */
public class 数值的整数次方 {

    /**
     * 1.全面考察指数的正负、底数是否为零等情况。
     * 2.写出指数的二进制表达，例如13表达为二进制1101。
     * 3.举例:10^1101 = 10^0001*10^0100*10^1000。
     * 4.通过&1和>>1来逐位读取1101，为1时将该位代表的乘数累乘到最终结果。
     */
    public static double Power(double base, int n) {
        double result = 1; double curr = base;
        int exponent;
        if (n > 0) {
            exponent = n;
        } else if (n < 0) {
            exponent = -n;
        } else { //n=0
            return 1;
        }
        while (exponent != 0) {
            if ((exponent & 1) == 1) {
                result *= curr;
            }
            curr *= curr;
            exponent >>= 1;
        }
        return n > 0 ? result : (1 / result);
    }

}
