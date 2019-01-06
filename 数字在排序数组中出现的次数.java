/**
 * 统计一个数字在排序数组中出现的次数。
 */
public class 数字在排序数组中出现的次数 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7,7,7,7,7,8,9,9,12,12,12,12,44,45,46,46,46,46};
        int i = GetNumberOfK(arr, 1);
        System.out.println(i);
    }

    /**
     *
     * 解题思路:
     *  使用二分查找定位到要查找的数，再用两个指针分别向前和向后 查找是否存在k值
     *
     */
    public static int GetNumberOfK(int [] array , int k) {
        int search = search(array, k);
        if (search == -1) return 0;
        int count = 1;
        int i1 = search, i2 = search;
        while (i1 >= 0 || i2 < array.length) {
            i1--;
            if (i1 >= 0 && array[i1] == k) {
                count++;
            }
            i2++;
            if (i2 < array.length && array[i2] == k) {
                count++;
            }
        }
        return count;
    }

    public static int search(int[] arr,int k) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == k) {
                return mid;
            } else if (arr[mid] > k) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}

