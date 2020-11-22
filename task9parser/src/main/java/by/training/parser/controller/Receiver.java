package by.training.parser.controller;


import by.training.parser.entity.CommandType;
import by.training.parser.entity.Composite;
import by.training.parser.service.FileService;
import by.training.parser.service.ServiceFactory;
import by.training.parser.service.SortService;
import by.training.parser.service.TextService;

import java.util.Scanner;

public class Receiver {
    private Scanner in;
    private FileService fileService;
    private TextService textService;
    private SortService sortService;

    public Receiver() {
        this.in = new Scanner(System.in);
        this.in.useDelimiter("\n");
        ServiceFactory serviceFactory = ServiceFactory.getINSTANCE();
        this.fileService = serviceFactory.getFileService();
        this.textService = serviceFactory.getTextService();
        this.sortService = serviceFactory.getSortService();
    }

    public void action(CommandType option) {
        switch (option) {
            case PARSE:
                parseString();
                break;
            case LOAD:
                loadData();
                break;
            case RECOVER:
                recoverText();
                break;
            case SORT_PARAGRAPHS:
                sortParagraphsByCountOfSentences();
                break;
            case SORT_WORDS:
                sortWordsInSentencesByLength();
                break;
            case SORT_LEXEMES:
                sortLexemesByOccurrencesOfSymbolAndAlphabet();
                break;
            default:
        }
    }

    /**
     * "My naame is Frank... I am   from London.\n How   are you?\tHello..."
     */
    public void parseString() {
        textService.parse(in.nextLine());
    }

    /**
     * "task9parser/src/main/resources/text.txt"
     */
    public void loadData() {
        textService.saveText(fileService.read(in.nextLine()));
    }

    public void recoverText() {
        System.out.println(textService.recoverText(textService.readText()));
    }

    public void sortParagraphsByCountOfSentences() {
        Composite result = sortService.sortParagraphsByCountOfSentences(textService.readText());
        System.out.println(textService.recoverText(result));
    }

    public void sortWordsInSentencesByLength() {
        Composite result = sortService.sortWordsInSentencesByLength(textService.readText());
        System.out.println(textService.recoverText(result));
    }


    public void sortLexemesByOccurrencesOfSymbolAndAlphabet() {
        Composite result = sortService.sortLexemesByOccurrencesOfSymbolAndAlphabet(
                textService.readText(), in.nextLine().charAt(0));
        System.out.println(textService.recoverText(result));
    }
}
