package by.dubrovskaya.thread.entity;

import by.dubrovskaya.thread.entity.state.CreatedState;
import by.dubrovskaya.thread.entity.state.State;

public class Element {
    private int value;
    private State currentElementState;

    public Element(int value) {
        this.value = value;
        currentElementState = new CreatedState();
    }

    public void initialize() {
        currentElementState.initialize(this);
    }

    public void synchronize(){
        currentElementState.synchronize(this);
    }

    public void setCurrentElementState(State currentElementState) {
        this.currentElementState = currentElementState;
    }

    public State getCurrentElementState() {
        return currentElementState;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
