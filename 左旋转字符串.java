/**
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
 */
public class 左旋转字符串 {

    /**
     * 比较简单就不写解题思路了
     */
    public static String LeftRotateString(String str,int n) {
        if (str == null || str.equals("")) return "";
        char[] chars = str.toCharArray();
        for (int i = 0; i < n; i++) {
            char temp = chars[0];
            for (int k = 0; k < chars.length - 1; k++) {
                chars[k] = chars[k + 1];
            }
            chars[chars.length - 1] = temp;
        }
        return  String.valueOf(chars);
    }
}
