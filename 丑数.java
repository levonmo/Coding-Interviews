import java.util.ArrayList;

/**
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */
public class 丑数 {

    /**
     * 解题思路:
     *   用一个list保持有序的丑数
     *   用三个指针计算出 保持list最后一个的下一个丑数(最小的那个就是)
     *
     *   我们只用比较3个数：用于乘2的最小的数、用于乘3的最小的数，用于乘5的最小的
     *
     *  另一种解题思路
     *     1）初始化array和队列：Q2 Q3 Q5
     *     2）将1插入array
     *     3）分别将1*2、1*3 、1*5插入Q2 Q3 Q5
     *     4)令x为Q2 Q3 Q5中的最小值，将x添加至array尾部
     *     5）若x存在于：
     *       Q2：将 x * 2、x * 3、x*5 分别放入Q2 Q3 Q5，从Q2中移除x
     *       Q3：将 x * 3、x*5 分别放入Q3 Q5，从Q3中移除x
     *       Q5：将 x * 5放入Q5，从Q5中移除x
     *     6）重复步骤4~6，知道找到第k个元素
     */

    public static int GetUglyNumber_Solution(int index) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        int i1 = 0, i2 = 0, i3 = 0;
        while (list.size() < index) {
            int n1 = list.get(i1) * 2;
            int n2 = list.get(i2) * 3;
            int n3 = list.get(i3) * 5;
            //返回三个值中的最小的一个
            int min = (n1 < n2) ? (n1 < n3 ? n1 : n3 ) : (n2 < n3 ? n2 : n3);
            if (min == n1) i1++;
            if (min == n2) i2++;
            if (min == n3) i3++;
        }
        return list.get(list.size() - 1);
    }

}