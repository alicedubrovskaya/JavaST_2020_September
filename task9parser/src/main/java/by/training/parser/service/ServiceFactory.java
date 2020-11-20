package by.training.parser.service;

import by.training.parser.service.implementation.FileServiceImpl;
import by.training.parser.service.implementation.LexemeServiceImpl;
import by.training.parser.service.implementation.SortServiceImpl;
import by.training.parser.service.implementation.TextServiceImpl;

public class ServiceFactory {
    private static final ServiceFactory INSTANCE = new ServiceFactory();

    private final FileService fileService = new FileServiceImpl();
    private final LexemeService lexemeService = new LexemeServiceImpl();
    private final SortService sortService = new SortServiceImpl();
    private final TextService textService = new TextServiceImpl();

    private ServiceFactory() {
    }

    public static ServiceFactory getINSTANCE() {
        return INSTANCE;
    }

    public FileService getFileService() {
        return fileService;
    }

    public LexemeService getLexemeService() {
        return lexemeService;
    }

    public SortService getSortService() {
        return sortService;
    }

    public TextService getTextService() {
        return textService;
    }
}
