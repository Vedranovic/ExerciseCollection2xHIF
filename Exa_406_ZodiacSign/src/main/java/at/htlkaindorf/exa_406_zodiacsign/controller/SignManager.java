package at.htlkaindorf.exa_406_zodiacsign.controller;

import at.htlkaindorf.exa_406_zodiacsign.pojos.Sign;

public class SignManager {
    private Sign[] signs;
    private static final int NUM = 10;
    private int size;

    public SignManager() {
        this.size = 0;
        this.signs = new Sign[NUM];
    }

    public void addSign(Sign sign) {
        if (size > 9) {
            throw new ArrayIndexOutOfBoundsException("No more signs can be added");
        }

        signs[size] = sign;
        size++;
    }

    public Sign[] getSigns() {
        return signs;
    }
}
