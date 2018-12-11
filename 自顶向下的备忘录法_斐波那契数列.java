public class 自顶向下的备忘录法_斐波那契数列 {
    public static int Fibonacci(int n) {
        if (n <= 0) return n;
        else {
            //下标为零的不用
            int[] arr = new int[n + 1];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = -1;
            }
            int fib = fib(n, arr);
            return fib;
        }
    }

    private static int fib(int n, int[] arr) {
        if (n <= 2) {
            return 1;
        } else if (arr[n] != -1) {
            return arr[n];
        } else {
            arr[n] = fib(n - 1, arr) + fib(n - 2, arr);
            return arr[n];
        }
    }


}
