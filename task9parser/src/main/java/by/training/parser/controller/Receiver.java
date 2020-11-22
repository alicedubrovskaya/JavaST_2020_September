package by.training.parser.controller;


import by.training.parser.entity.CommandType;
import by.training.parser.entity.Composite;
import by.training.parser.service.FileService;
import by.training.parser.service.ServiceFactory;
import by.training.parser.service.SortService;
import by.training.parser.service.TextService;

import java.util.Scanner;


/**
 * This interface is responsible for executing requests sent with the command
 *
 * @author Alisa Dubrovskaya
 */
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
     * Parsers string
     */
    public void parseString() {
        textService.parse(in.nextLine());
    }

    /**
     * Loads data to storage
     * File path example: "task9parser/src/main/resources/text.txt"
     */
    public void loadData() {
        textService.saveText(fileService.read(in.nextLine()));
    }

    /**
     * Recovers text from string to Composite
     */
    public void recoverText() {
        System.out.println(textService.recoverText(textService.readText()));
    }

    /**
     * Sorts paragraphs by count of sentences
     */
    public void sortParagraphsByCountOfSentences() {
        Composite result = sortService.sortParagraphsByCountOfSentences(textService.readText());
        System.out.println(textService.recoverText(result));
    }

    /**
     * Sort words in sentences by length
     */
    public void sortWordsInSentencesByLength() {
        Composite result = sortService.sortWordsInSentencesByLength(textService.readText());
        System.out.println(textService.recoverText(result));
    }

    /**
     * Sort lexemes by occurrences of symbol and alphabet
     */
    public void sortLexemesByOccurrencesOfSymbolAndAlphabet() {
        Composite result = sortService.sortLexemesByOccurrencesOfSymbolAndAlphabet(
                textService.readText(), in.nextLine().charAt(0));
        System.out.println(textService.recoverText(result));
    }
}
