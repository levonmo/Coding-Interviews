public class 自底向上的动态规划_斐波那契数列 {
    public static int fib(int n) {
        if (n <= 0) return n;
        else if (n <= 2) return 1;
        int f_1 = 1;
        int f_2 = 1;
        int f_3 = 3;
        for (int i = 2; i < n; i++) {
            f_3 = f_1 + f_2;
            f_1 = f_2;
            f_2 = f_3;
        }
        return f_3;
    }
}
