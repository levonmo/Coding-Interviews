/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 *
 */

public class 变态跳台阶 {

    /**
     *  计算的原理:
     *      1. f(n) = f(n-1)+f(n-2)+f(n-3)+...+f(1)
     *      2. f(n-1) = f(n-2)+(n-3)+...+f(1)
     *      两式相减可以得到: f(n)=2f(n-1)
     *
     */
    public static int JumpFloorII(int n) {
        if (n < 0) return 0;
        else if (n == 1 || n == 2) return n;
        else {
            return 2 * JumpFloorII(n - 1);
        }
    }

}
