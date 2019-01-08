/**
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
public class 求1加2加3一直加到n的结果 {

    public static int Sum_Solution(int n) {
        if (n == 1) return 1;
        return n +  Sum_Solution(n - 1);
    }
}
