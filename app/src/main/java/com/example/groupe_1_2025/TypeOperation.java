package com.example.groupe_1_2025;

public enum TypeOperation {
    ADD("+"),
    SUBSTRACT("-"),
    MULTIPLY("x"),
    DIVIDE("/");

    private String symbole;

    TypeOperation(String symbole) {
        this.symbole = symbole;
    }

    public String getSymbole() {
        return symbole;
    }
}
