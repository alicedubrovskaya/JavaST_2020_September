package by.dubrovskaya.thread.entity.state;

import by.dubrovskaya.thread.entity.Element;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InitializedState implements State {
    private final Logger logger = LogManager.getLogger(getClass().getName());

    @Override
    public void synchronize(Element element) {
        logger.info("Status of element cannot be changed, because it is initialized");
    }

    @Override
    public void initialize(Element element) {
        try {
            throw new UnsupportedOperationException("Is already initialized");
        } catch (UnsupportedOperationException e) {
            logger.error(e.getMessage());
        }
    }
}
