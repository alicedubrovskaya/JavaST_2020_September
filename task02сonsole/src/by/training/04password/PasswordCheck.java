import java.util.Scanner;

public class PasswordCheck{
    public static void main(String [] args){
        String NEEDED_PASSWORD = "password";
        Scanner in = new Scanner(System.in);
        System.out.print("Enter your password: ");
        String password = in.nextLine();

        if (NEEDED_PASSWORD.equals(password)){
            System.out.print("Matches");
        }
        else {
            System.out.print("Different passwords");
        }
    }
}