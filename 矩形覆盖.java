/**
 *
 *  我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 *
 */
public class 矩形覆盖 {

    /**
     *
     * 理解: 由 f(3) = f(2)+f(1) 可得
     *         f(n) = f(n-1)+f(n-2)
     *  所以这又是一个动态规划的问题
     *  解决这类的动态规划有三种方法
     *      1.直接使用递归
     *      2.备忘录法 (新建一个数组保存计算过的值，来减少递归的次数)
     *      3.自底向上
     *
     */

    //1.直接使用递归
    public int RectCover(int n) {
        if (n <= 0) return 0;
        else if (n <= 2) return n;
        else {
            return RectCover(n - 1) + RectCover(n - 2);
        }
    }

    //2.备忘录法
    public static int RectCover2(int n) {
        if (n <= 0) return 0;
        int[] arr = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            arr[i] = -1;
        }
        return rect2(arr, n);
    }

    private static int rect2(int[] arr, int n) {
        if (n == 1 || n == 2) return n;
        else if (arr[n] != -1) {
            return arr[n];
        } else {
           return rect2(arr, n - 1) + rect2(arr, n - 2);
        }
    }

    //3.自底向上
    public static int RectCover3(int n) {
        if (n <= 0) return 0;
        else if (n == 1 || n == 2) return n;
        else {
            int f_1 = 1;
            int f_2 = 2;
            int total = 3;
            for (int i = 3; i <= n; i++) {
                total = f_1 + f_2;
                f_1 = f_2;
                f_2 = total;
            }
            return total;
        }
    }


}
