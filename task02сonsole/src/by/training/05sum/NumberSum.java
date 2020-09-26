
public class NumberSum {
    public static void main(String[] args) {
        short sum = 0;
        boolean overflowing = false;
        for (String string : args) {
            int arg = Integer.parseInt(string);
            if (sum + arg > 32767 || sum + arg < -32768) {
                overflowing = true;
                break;
            } else {
                sum += arg;
            }
        }
        System.out.println(overflowing ? "Sum exceeds the norm" : "Sum: " + sum);
    }
}