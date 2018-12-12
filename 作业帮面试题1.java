import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,23,34,45,56,77,88,99,123,345,456,567,678};
        int method = method(arr, 3);
        System.out.println(method);
    }

    //作业帮面试题: 输入一个有序的数组，和一个数字S，求从数组中取出两个数，使得这两个数相加等于S，如果有多对的话 返回 乘职最小的两个
    public static int method(int[] arr, int s) {
        ArrayList<Node> list = new ArrayList<Node>();
        for (int i = 0; i < arr.length; i++) {
            int one = arr[i];
            int two = s - one;
            int search = search(arr, two);
            if (search != -1) {
                Node node = new Node(one, two);
                list.add(node);
            } else {
                continue;
            }
        }

        Node node1 = list.get(0);
        int min = node1.a * node1.b;
        for (int i = 0; i < list.size(); i++) {
            Node node = list.get(i);
            int ii = node.a * node.b;
            if (ii < min) {
                min = ii;
            }
        }
        return min;
    }

    public static int search(int[] arr, int temp) {
        int start = 0;
        int end = arr.length;
        while (start <= end) {
            int mid = (start + end) >>> 1;
            if (arr[mid] == temp) return mid;
            else if (arr[mid] > temp) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}

class Node {
    int a;
    int b;

    public Node(int a, int b) {
        this.a = a;
        this.b = b;
    }
}