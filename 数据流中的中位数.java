import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 */
public class 数据流中的中位数 {

    /**
     *
     * 解题思路:
     *  使用两个堆: 一个最小堆和最大堆,
     *  最大堆保存中位数的前半截数据，最小堆保存中位数的后半截数据(最小堆的元素全部大于最大堆的元素)
     *  两个堆的元素之差不能超过1
     *  每次插入元素,先判断应该插入到那个堆，再插入堆的时候要注意，是否需要从另一个堆中poll一个元素出来
     *      比如: 要插入到最大堆，那么就要将要插入的元素b 与最小堆中最小元素n比较，如果b大于n，
     *          那么就要将n移除出来插入到最大堆中，将b插入到最小堆，
     */

    //每次取出都是最小值
    private  PriorityQueue<Integer> smallHead = new PriorityQueue<>();
    //每次取出都是最大值
    private  PriorityQueue<Integer> bigHead = new PriorityQueue<Integer>(new Comparator<Integer>() {
        public int compare(Integer o1, Integer o2) {
            if ((Integer) o1 <= (Integer) o2) {
                return 1;
            } else {
                return -1;
            }
        }
    });

    public void Insert(Integer num) {
        //最小堆中的元素都必须比最大堆中的都大
        if (bigHead.size() == 0) {
            bigHead.add(num);
        } else {
            //判断放在最大堆还是最小堆
            if (bigHead.size() <= smallHead.size()) {
                //放在最大堆
                Integer peek = smallHead.peek();
                if (peek < num) {
                    Integer poll = smallHead.poll();
                    bigHead.offer(poll);
                    smallHead.offer(num);
                } else {
                    bigHead.offer(num);
                }
            } else {
                //放在最小堆
                Integer peek = bigHead.peek();
                if (peek > num) {
                    Integer poll = bigHead.poll();
                    smallHead.offer(poll);
                    bigHead.offer(num);
                } else {
                    smallHead.offer(num);
                }
            }
        }
    }

    public Double GetMedian() {
        if (smallHead.size() == bigHead.size()) {
            return Double.valueOf(smallHead.peek() + bigHead.peek()) / 2;
        } else if (smallHead.size() > bigHead.size()) {
            return Double.valueOf(smallHead.peek());
        } else {
            return Double.valueOf(bigHead.peek());
        }
    }

}
