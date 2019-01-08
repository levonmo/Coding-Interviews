/**
 * 将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，但是string不符合数字要求时返回0)
 * 要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0。
 */
public class 把字符串转换成整数 {

    public static int StrToInt(String str) {
        if (str == null || str.trim().equals("")) return 0;
        int total = 0;
        char[] chars = str.toCharArray();
        for (int i = chars.length - 1,ii = 0; i >= 0; i--,ii++) {
            int a = chars[i] - 48;
            if (a > 9 || a < 0) {
                if (i == 0 && ((chars[i] == '+' || chars[i] == '-'))) break;
                return 0;
            }
            total += a * Math.pow(10, ii);
        }
        if (chars[0] == '-') {
            total *= -1;
            //防止溢出
            if (str.equals("-2147483648")) {
                total -= 1;
            }
        }
        return total;
    }
}

