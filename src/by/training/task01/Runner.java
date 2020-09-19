package by.training.task01;

import by.training.task01.receiver.NumberGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {

        NumberService numberService=new NumberService();
        NumberGenerator numberGenerator=new NumberGenerator();

        List<Number> numbers = new ArrayList<>();

        numbers=numberGenerator.getGeneratedNumbers();
        for (Number number: numbers){
            System.out.print(number.getValue()+" ");
        }

    /*    Scanner in = new Scanner(System.in);


        for (int i = 0; i < 4; i++) {
            numbers.add(new Number(in.nextInt()));
        }

     */


        if (numberService.hasAtLeastTwoEvenNumbers(numbers))
            System.out.print("True");
        else System.out.print("False");

     //   in.close();
    }
}
