
interface ICommand {
    void execute();
}

class Executor {
    public void showMessageA() {
        System.out.println("Message A");
    }

    public void showMessageB() {
        System.out.println("Message B");
    }
}

class CommandA implements ICommand {
    private Executor executor = null;

    public CommandA(Executor executor) {
        this.executor = executor;
    }

    public void execute() {
        this.executor.showMessageA();
    }
}

class CommandB implements ICommand {
    private Executor executor = null;

    public CommandB(Executor executor) {
        this.executor = executor;
    }

    public void execute() {
        this.executor.showMessageB();
    }
}


class Invoker {
    private ICommand command_1 = null;
    private ICommand command_2 = null;

    public Invoker(ICommand btn1, ICommand btn2) {
        command_1 = btn1;
        command_2 = btn2;
    }

    public void pressBtnA() {
        command_1.execute();
    }

    public void pressBtnB() {
        command_2.execute();
    }
}

public class Command {



    public static void main(String args[]) {
        Executor executor = new Executor();
        CommandA btn1 = new CommandA(executor);
        CommandB btn2 = new CommandB(executor);

        Invoker ink = new Invoker(btn1, btn2);
        ink.pressBtnA();
        ink.pressBtnB();

    }
}