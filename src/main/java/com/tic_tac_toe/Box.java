package com.tic_tac_toe;

public class Box {
    private char value = ' ';  

    public boolean isEmpty() {
        return value == ' ';
    }

    public void setValue(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }
}
