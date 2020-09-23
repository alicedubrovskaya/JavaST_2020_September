
public class NumberSum {
    public static void main(String[] args) {
        int sum = 0;
        for (String string : args) {
            sum += Integer.parseInt(string);
        }
        System.out.println("Sum: " + sum);
    }
}