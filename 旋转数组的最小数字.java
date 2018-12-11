public class 旋转数组的最小数字 {

    public int minNumberInRotateArray(int[] array) {
        if (array.length == 0) return 0;
        for (int i = 1; i < array.length; i++) {
            if (array[0] > array[i]) {
                return array[i];
            }
        }
        return array[0];
    }
}
