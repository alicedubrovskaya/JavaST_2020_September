package by.training.thread18count;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tutor extends Thread {

    private Integer idTutor;

    private List<Student> list;

    public Tutor() {
        this.list = new ArrayList<>();
    }

    public Tutor(final List<Student> listNew) {
        this.list = listNew;
    }

    public Integer getIdTutor() {
        return idTutor;
    }

    public void setIdTutor(final Integer id) {
        this.idTutor = id;
    }

    public void run() {
        for (Student st : list) {
            // проверить, выданы ли студенту задания
            List<Task> tasks = st.getTaskList();
            for (Task current : tasks) {
                // проверить наличие ответа!
                int mark = 3 + new Random().nextInt(7);
                current.setMark(mark);
                System.out.println(mark + " for student N "
                        + st.getIdStudent());
                st.getCountDownLatch().countDown();
            }
            System.out.println("All estimates made for " + st.getIdStudent());
        }
    }
}
