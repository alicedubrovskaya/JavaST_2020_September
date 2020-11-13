package by.dubrovskaya.thread.entity.state;

import by.dubrovskaya.thread.entity.Element;

public interface State {
    void synchronize(Element element);

    void initialize(Element element);
}
