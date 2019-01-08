/**
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法
 */
public class 构建乘积数组 {

    //比较简单
    public static int[] multiply(int[] A) {
        int[] B = new int[A.length];
        for (int i = 0; i < B.length; i++) B[i] = 1;
        for (int i = 0; i < B.length; i++) {
            int total = 1;
            for (int k = 0; k < B.length; k++) {
                if (k == i) continue;
                total *= A[k];
            }
            B[i] = total;
        }
        return B;
    }
}
