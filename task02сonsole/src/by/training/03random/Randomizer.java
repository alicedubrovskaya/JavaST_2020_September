import java.util.Scanner;

public class Randomizer{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter count of numbers: ");
        int count = in.nextInt();
        System.out.println("1- with a new line; 2- without a new line");
        int presenceOfNewLine = in.nextInt();

        for (int i=0; i<count; i++){
            int number = (int) (Math.random()*100);
            if (presenceOfNewLine==1){
                System.out.println(number);
            }
            else {
                System.out.print(number+ " ");
            }
            
        }
    }
    
} 