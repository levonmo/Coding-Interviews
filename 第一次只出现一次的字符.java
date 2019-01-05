import java.util.HashMap;

/**
 *
 *  在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）
 *
 */

public class 第一次只出现一次的字符 {

    public static void main(String[] args) {
        int google = FirstNotRepeatingChar("google");
        System.out.println(google);
    }

    /**
     *
     * 解题思路:
     *  遍历字符串，用一个map保存，遇到第一次字符，就保存其下标位置。当第二次遇到相同的字符时候就将Value置为-1。
     */
    public static int FirstNotRepeatingChar(String str) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            Integer ii = map.get(String.valueOf(chars[i]));
            if (ii == null) {
                map.put(String.valueOf(chars[i]), i);
            } else {
                if (ii.equals(-1)) continue;
                map.put(String.valueOf(chars[i]), -1);
            }
        }
        int min = -1;
        for (String s : map.keySet()) {
            Integer i = map.get(s);
            if (!i.equals(-1)) {
                if (min == -1) {
                    min = i;
                } else {
                    if (min > i) {
                        min = i;
                    }
                }
            }
        }
        return min;
    }

}
