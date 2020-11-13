package by.dubrovskaya.thread.entity.state;

import by.dubrovskaya.thread.entity.Element;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CreatedState implements State {
    private final Logger logger = LogManager.getLogger(getClass().getName());

    @Override
    public void synchronize(Element element) {
        logger.info("Status of element changed from Created to Synchronized");
        element.setCurrentElementState(new SynchronizedState());
    }

    @Override
    public void initialize(Element element) {
        logger.info("Status of element changed from Created to Initialized");
        element.setCurrentElementState(new InitializedState());
    }
}
