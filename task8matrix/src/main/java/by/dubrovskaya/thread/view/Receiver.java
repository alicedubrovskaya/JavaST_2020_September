package by.dubrovskaya.thread.view;

import by.dubrovskaya.thread.controller.MatrixController;
import by.dubrovskaya.thread.entity.CommandType;

import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * This interface is responsible for executing requests sent with the command
 *
 * @author Alisa Dubrovskaya
 */
public class Receiver {
    private MatrixController matrixController;
    private Scanner in;
    private ResourceBundle rb;

    public Receiver(MatrixController matrixController, ResourceBundle rb) {
        this.matrixController = matrixController;
        in = new Scanner(System.in);
        in.useDelimiter("\n");
        this.rb = rb;
    }

    public void action(CommandType option) {
        switch (option) {
            case LOAD_MATRIX:
                optionLoadMatrix();
                break;
            case INITIALIZE_DIAGONAL:
                optionInitializeDiagonal();
                break;
            case SUM_OF_ELEMENTS:
                optionSumOfElements();
                break;
            case INIT_THREADS:
                optionInitThreads();
                break;

            default:
        }
    }

    /**
     * Loads matrix
     */
    private void optionLoadMatrix() {
        matrixController.loadMatrix();
    }

    /**
     * Initializes diagonal of matrix
     */
    private void optionInitializeDiagonal() {
        matrixController.initializeDiagonal(in.nextLine());
    }

    /**
     * Finds sum of elements from diagonal
     */
    private void optionSumOfElements() {
        matrixController.sumOfElements();
    }

    /**
     * Loads threads
     */
    private void optionInitThreads() {
        System.out.println(rb.getString("thread.execution"));
        matrixController.initThreads(matrixController.loadValuesOfThreads(), in.nextLine());
    }
}
