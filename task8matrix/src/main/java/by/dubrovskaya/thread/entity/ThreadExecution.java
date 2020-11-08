package by.dubrovskaya.thread.entity;

public enum ThreadExecution {
    LOCKER("locker"),
    SEMAPHORE("semaphore"),
    EXECUTOR("executor");

    private final String execution;

    ThreadExecution(String execution) {
        this.execution = execution;
    }

    public static ThreadExecution getEnum(String string) {
        for (ThreadExecution info : values()) {
            if (info.getExecution().equals(string)) {
                return info;
            }
        }
        throw new IllegalArgumentException("No enum found with string: [" + string + "]");
    }

    public String getExecution() {
        return execution;
    }
}
