package by.training.xml.parser;

import by.training.xml.parser.dom.MedicinesDomBuilder;
import by.training.xml.parser.sax.MedicinesSAXBuilder;
import by.training.xml.parser.stax.MedicinesStAXBuilder;

public class MedicineBuilderFactory {
    private enum TypeParser {
        SAX, STAX, DOM
    }
    public AbstractMedicinesBuilder createMedicineBuilder(String typeParser) {
        TypeParser type = TypeParser.valueOf(typeParser.toUpperCase());
        switch (type) {
            case DOM:
                return new MedicinesDomBuilder();
            case STAX:
                return new MedicinesStAXBuilder();
            case SAX:
                return new MedicinesSAXBuilder();
            default:
                throw new EnumConstantNotPresentException (type.getDeclaringClass(), type.name());
        }
    }
}
