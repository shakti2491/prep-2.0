package designpatterns.behavioral.command;

import java.util.LinkedList;
import java.util.List;

public class MailTasksRunner implements Runnable{
    private List<ICommand> pendingCommands;
    private boolean stop;
    private Thread runner;
    private static final MailTasksRunner RUNNER = new MailTasksRunner();

    private MailTasksRunner(){
        pendingCommands = new LinkedList<>();
        runner = new Thread(this);
    }
    @Override
    public void run() {

    }
}
