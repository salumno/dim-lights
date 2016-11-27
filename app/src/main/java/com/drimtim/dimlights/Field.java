package com.drimtim.dimlights;

import java.util.Random;

/**
 * Created by avispa on 27/11/2016.
 */

class Field {
    private final boolean[][] field;
    private final int SIZE = 5;

    public Field() {
        this.field = new boolean[SIZE][SIZE];
        Random rand = new Random();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                this.field[j][i] = Math.abs(rand.nextInt()) % 2 == 0;
            }
        }
    }

    public boolean click(int x, int y) {
        this.field[x][y] = !this.field[x][y];
        if (x - 1 >= 0) this.field[x - 1][y] = !this.field[x - 1][y];
        if (x + 1 < this.field.length) this.field[x + 1][y] = !this.field[x + 1][y];
        if (y - 1 >= 0) this.field[x][y - 1] = !this.field[x][y - 1];
        if (y + 1 < this.field.length) this.field[x][y + 1] = !this.field[x][y + 1];
        return checkWin();
    }

    private boolean checkWin() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (this.field[j][i]) return false;
            }
        }
        return true;
    }

    public boolean checkCell(int x, int y) {
        return this.field[x][y];
    }
}
