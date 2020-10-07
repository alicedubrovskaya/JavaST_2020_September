package training.by.exception;

public class MatrixCannotBeTransposedException extends Exception {
    public MatrixCannotBeTransposedException(int id){
        super(String.format("Matrix cannot be transposed with id : '%s'", id));
    }
}
