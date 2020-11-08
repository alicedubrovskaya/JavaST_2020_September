package by.dubrovskaya.thread.entity;

/**
 * Enumeration class for types of invoking commands
 */
public enum CommandType {
    LOAD_MATRIX("load matrix"),
    INITIALIZE_DIAGONAL("initialize diagonal"),
    SUM_OF_ELEMENTS("sum"),
    INIT_THREADS("init threads");

    private final String commandType;

    CommandType(String execution) {
        this.commandType = execution;
    }

    public static CommandType getEnum(String string) {
        for (CommandType info : values()) {
            if (info.getCommandType().equals(string)) {
                return info;
            }
        }
        throw new IllegalArgumentException("No enum found with string: [" + string + "]");
    }

    public String getCommandType() {
        return commandType;
    }
}
