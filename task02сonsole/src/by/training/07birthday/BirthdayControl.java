import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class BirthdayControl {
    public static void main(String[] args) throws ParseException {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter your birthday ");
        String birthday = in.nextLine();

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

        //  birthday format: = "11-Jan-2000";
        Date date = formatter.parse(birthday);
        Calendar birthDay = Calendar.getInstance();
        birthDay.setTime(date);
        int dayOfWeek = birthDay.get(Calendar.DAY_OF_WEEK);
        System.out.println("The day you were born: " + dayOfWeek);

        Calendar today = Calendar.getInstance();
        int age = today.get(Calendar.YEAR) - birthDay.get(Calendar.YEAR);
        if (today.get(Calendar.DAY_OF_YEAR) <= birthDay.get(Calendar.DAY_OF_YEAR)) {
            age--;
        }
        System.out.println("Your age is: " + age);

        if (today.get(Calendar.DAY_OF_YEAR) == birthDay.get(Calendar.DAY_OF_YEAR)) {
            System.out.println("Happy birthday!");
        }
    }
}