public class 九大排序算法 {


    public static void main(String[] args) {
        int[] arr = new int[]{2,132,123,234,33,5,6,21,123,55,414,4353,7};
        print(arr);
//        selectionSort(arr);
//        bubbleSort(arr);
//
        insertionSort(arr);
        print(arr);

    }


    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
        System.out.println();
    }

    //选择排序,每次选出最小的往已排序的数字中插入
    public static int[] selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int ii = i + 1; ii < arr.length; ii++) {
                if (arr[ii] < arr[min]) {
                    min = ii;
                }
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }

    //冒泡排序,每每相临两个交换元素，一轮循环之后冒出未排序的数中的最大一个
    public static int[] bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int ii = 0; ii < arr.length - 1 - i; ii++) {
                if (arr[ii] > arr[ii + 1]) {
                    int temp = arr[ii];
                    arr[ii] = arr[ii + 1];
                    arr[ii + 1] = temp;
                }
            }
        }
        return arr;
    }

    //插入排序，每次从后面选取一个数向前面已经排好序的数组 选择合适的位置插入,对于有序的数组该算法的效率比较高
    public static int[] insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int ii = i; ii > 0; ii--) {
                if (arr[ii] < arr[ii - 1]) {
                    int temp = arr[ii];
                    arr[ii] = arr[ii - 1];
                    arr[ii - 1] = temp;
                } else {
                    break;
                }
            }
        }
        return arr;
    }

}
