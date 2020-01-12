
class Params {
    public int id;
    public String name;
    public int age;
    public char sex;
}

interface Handler {
    void handle(Params params);
}

abstract class BaseHandler extends Params {
    protected BaseHandler next = null;

    public BaseHandler(BaseHandler next) {
        this.next = next;
    }

    abstract void handler(Params params);
}

class ProcessMen extends BaseHandler {
    public ProcessMen(BaseHandler baseHandler) {
        super(baseHandler);
    }

    public void handler(Params params) {
        if (params.sex == 'M')
            System.out.println("Just men here!");

        if (next != null)
            this.next.handler(params);
    }
}

class ProcessWomen extends BaseHandler {
    public ProcessWomen(BaseHandler next) {
        super(next);
    }

    public void handler(Params params) {
        if (params.sex == 'F')
            System.out.println("Just women here!");

        if (next != null)
            this.next.handler(params);
    }

}

class GotoArmy extends BaseHandler {
    public GotoArmy(BaseHandler next) {
        super(next);
    }

    public void handler(Params params) {
        if (params.sex == 'M' && params.age >= 18) {
            System.out.println("You can go to army forces.");
        }

        if (next != null)
            next.handler(params);
    }
}

public class ChainOfResponsability {

    public static void main(String args[]) {
        BaseHandler handlerChain = new ProcessMen(new ProcessWomen(new GotoArmy(null)));

        Params params = new Params();
        params.age = 18;
        params.id = 1;
        params.name = "Matheus";
        params.sex = 'M';

        Params paramsB = new Params();
        paramsB.age = 19;
        paramsB.id = 2;
        paramsB.name = "Girl";
        paramsB.sex = 'F';

        handlerChain.handler(params);
        handlerChain.handler(paramsB);
    }
}