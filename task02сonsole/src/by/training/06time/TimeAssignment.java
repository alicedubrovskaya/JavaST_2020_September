import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class TimeAssignment {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter your last name: ");
        String lastName = in.nextLine();
        System.out.print("Enter count of days you need to do this task: ");
        short neededDays = in.nextShort();

        Calendar calendar = new GregorianCalendar();
        Date currentTime = calendar.getTime();
        System.out.println("Dear "+lastName+"\nThe current time is: "+ currentTime);


        calendar.add(Calendar.DATE, neededDays);
        System.out.println("Deadline: "+calendar.getTime());
    }
}

