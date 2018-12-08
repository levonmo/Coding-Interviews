public class 没有bug的二分查找 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,4,6,7,8,12,34,55,66,77,89,343};
        int index = search(arr, 78);
        System.out.println(index);
    }

    public static int search(int[] arr,int temp) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            //int mid = (start + end) / 2;//这样有bug，(start + end)有可能溢出
            int mid = start + (end - start) / 2;
            //int mid = (low + high) >>> 1; //这个也可以，位运算效率更高
            if (arr[mid] == temp) {
                return mid;
            } else if (arr[mid] > temp) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return - (start + 1);
    }

}
