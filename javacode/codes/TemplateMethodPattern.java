package javacode.codes;

abstract class TemplateMethod {
    public TemplateMethod() {

    }

    public void baseMethod() {
        System.out.println("Initializing...");
        detailMethodA();
        detailMethodB();
        detailMethodC();
        System.out.println("Work done!");
    }

    public abstract void detailMethodA();
    public abstract void detailMethodB();
    public abstract void detailMethodC();
}

class ConcreteA extends TemplateMethod {
    public ConcreteA() {
        super();
    }

    @Override
    public void detailMethodA() {
        System.out.println("ConcreteA.detailMethodA()");
    }

    @Override
    public void detailMethodB() {
        System.out.println("ConcreteA.detailMethodB()");
    }

    @Override
    public void detailMethodC() {
        System.out.println("ConcreteA.detailMethodC()");
    }
}

class ConcreteB extends TemplateMethod {
    public ConcreteB() {
        super();
    }

    @Override
    public void detailMethodA() {
        System.out.println("ConcreteB.detailMethodA()");
    }

    @Override
    public void detailMethodB() {
        System.out.println("ConcreteB.detailMethodB()");
    }

    @Override
    public void detailMethodC() {
        System.out.println("ConcreteB.detailMethodC()");
    }
}

public class TemplateMethodPattern {
    public static void main(String args[]) {
        TemplateMethod templateMethod = null;

        templateMethod = new ConcreteA();
        templateMethod.baseMethod();

        templateMethod = new ConcreteB();
        templateMethod.baseMethod();
    }
}