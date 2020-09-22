import java.util.Scanner;

class Hello {
    public static void main (String args[]){
        Scanner in = new Scanner (System.in);
        String name = in.nextLine();
        System.out.print("Hello "+ name);
    }
}