package javacode.codes;

import java.util.Date;

class Memento {
    private Date when = new Date();
    private String text = "";

    public State getState() {
        return new State(when, text);
    }

    public void changeText(String text) {
        this.text = text;
        when = new Date();
    }

    public String getText() {
        return text;
    }

    public Date getWhen() {
        return when;
    }

    public void recorverState(State state) {
        this.when = state.getDate();
        this.text = state.getText();
    }

    public class State {
        private Date date;
        private String text;

        public State(Date date, String text) {
            this.date = date;
            this.text = text;
        }



        public Date getDate() {
            return date;
        }

        public String getText() {
            return text;
        }

    }
}

public class MementoPattern {
    public static <T, U> void print(T data, U when) {
        System.out.println(data + " " + when);
    }

    public static void main(String args[]) {
        Memento memento = new Memento();
        memento.changeText("Matheus Cândido Teixeira");
        print(memento.getText(), memento.getWhen());
        Memento.State state = memento.getState();

        memento.changeText("Teixeira, Matheus Cândido");
        print(memento.getText(), memento.getWhen());

        memento.recorverState(state);
        print(memento.getText(), memento.getWhen());
    }
}