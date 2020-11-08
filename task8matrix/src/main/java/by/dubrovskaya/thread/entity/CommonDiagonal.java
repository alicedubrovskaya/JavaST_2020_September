package by.dubrovskaya.thread.entity;

public class CommonDiagonal {
    private int index;
    private int countOfElements;

    public CommonDiagonal(int countOfElements) {
        this.index = 0;
        this.countOfElements = countOfElements;
    }

    public int getIndex() {
        return index;
    }

    public int getCountOfElements() {
        return countOfElements;
    }

    public void incrementIndex() {
        index++;
    }
}
