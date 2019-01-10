import java.util.HashMap;

/**
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 */
public class 字符流中第一个不重复的字符 {

    private HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    private  int count = 0;//输入的字符流字符个数

    //Insert one char from stringstream
    public  void Insert(char ch) {
        Integer i = map.get(ch);
        if (i != null) {
            map.put(ch, -1);
        } else {
            map.put(ch, count++);
        }
    }
    //return the first appearence once char in current stringstream
    public  char FirstAppearingOnce() {
        int min = count + 1;
        char a = '#';
        for (Character c : map.keySet()) {
            Integer integer = map.get(c);
            if (integer.equals(-1)) {
                continue;
            } else {
                if (integer < min) {
                    min = integer;
                    a = c;
                }
            }
        }
        return a;
    }
}
