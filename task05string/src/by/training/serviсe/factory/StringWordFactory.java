package by.training.serviсe.factory;

import by.training.serviсe.StringWordService;
import by.training.serviсe.implementation.RegexWordServiceImpl;
import by.training.serviсe.implementation.StringWordServiceImpl;

public class StringWordFactory {
    final String STRING = "STRING";
    final String REGEX = "REGEX";

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
