package io.github.ppetrbednar.cv01.controller;

public class SimpleBody {
    private String text;

    public SimpleBody() {
    }

    public SimpleBody(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "SimpleBody{" +
                "text='" + text + '\'' +
                '}';
    }
}
