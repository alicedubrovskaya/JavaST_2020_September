package by.training.serviсe.factory;

import by.training.serviсe.StringWordService;
import by.training.serviсe.implementation.RegexWordServiceImpl;
import by.training.serviсe.implementation.StringWordServiceImpl;

/**
 * Class that represents Word Service factory for strings
 *
 * @author ALisa Dubrovskaya
 */
public class StringWordFactory {
    final String STRING = "STRING";
    final String REGEX = "REGEX";

    /**
     * Returns implementation of Word Service for strings depending on transmitted type
     * @param type
     * @return
     */
    public StringWordService getWordService(String type){
        if(STRING.equals(type)) {
            return new StringWordServiceImpl();
        }
        else if(REGEX.equals(type)){
            return new RegexWordServiceImpl();
        }
        return null;
    }
}
