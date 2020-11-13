package by.dubrovskaya.thread.entity.state;

import by.dubrovskaya.thread.entity.Element;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SynchronizedState implements State {
    private final Logger logger = LogManager.getLogger(getClass().getName());

    @Override
    public void synchronize(Element element) {
        logger.info("Is already synchronized");
    }

    @Override
    public void initialize(Element element) {
        logger.info("Status of element changed from Synchronized to Initialized");
        element.setCurrentElementState(new InitializedState());
    }
}
