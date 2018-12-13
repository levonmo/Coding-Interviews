/**
 * 属于动态规划
 *
 * 题目描述:
 *  一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 *
 */
public class 跳台阶 {
    public static void main(String[] args) {
        int i = JumpFloor3(10);
        System.out.println(i);
    }


    /**
     * 第一种方法:
     *
     * 时间复杂度是: 2^n
     *
     * 比如n=10，当最后一步就到10级台阶的时候，那么 跳10级台阶的走法=跳9级台阶的走法+跳8级台阶的走法
     * 那么将问题分解: 跳9级台阶的走法=跳8级台阶的走法+跳7级台阶的走法
     *
     */
    public static int JumpFloor(int n) {
        if (n < 1) return 0;
        else if (n == 1) return 1;
        else if (n == 2) return 2;//一次跳一级共两次和一次两级
        else {
            return JumpFloor(n - 1) + JumpFloor(n - 2);
        }
    }

    /**
     * 第二种方法:
     *
     * 时间复杂度是: O(n)
     *
     * 动态规划: 备忘录算法
     * 原理: 也是递归，只是弄多一个Hash表来存储计算过的值
     *
     */
    public static int JumpFloor2(int n) {
        if (n < 1) return 0;
        int[] arr = new int[n + 1];//下标为0的不用，所以要多传入的n多一个元素
        for (int i = 1; i <= n; i++) {
            //初始化数组，当内容为零的时候，就是还没有被赋值
            arr[i] = -1;
        }
        return jump2(arr,n);
    }
    private static int jump2(int[] arr,int n) {
        if (n < 1) return 0;
        else if (n == 1) return 1;
        else if (n == 2) return 2;
        else {
            if (arr[n] != -1){
                return arr[n];
            }else {
                arr[n] = jump2(arr, n - 1) + jump2(arr, n - 2);
                return arr[n];
            }
        }
    }

    /**
     * 第三种方法:
     *
     * 自底向上:
     * 原理: 不是递归，把方法二中的Hash弄掉
     */
    public static int JumpFloor3(int n) {
        if (n <= 0) return 0;
        else if (n == 1) return 1;
        else if (n == 2) return 2;
        else {
            int f_1 = 1;
            int f_2 = 2;
            int total = 0;
            for (int i = 2; i < n; i++) {
                total = f_1 + f_2;
                f_1 = f_2;
                f_2 = total;
            }
            return total;
        }
    }

}
