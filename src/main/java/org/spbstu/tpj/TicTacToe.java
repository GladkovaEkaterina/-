package org.spbstu.tpj;

import java.util.Arrays;

public class TicTacToe {

    enum FieldValues {
        X,
        O,
        Empty
    }

    private final int size;
    private FieldValues[][] field;

    public TicTacToe(int sizeNew) {
        size = sizeNew;
        field = new FieldValues[size][size];
        for (FieldValues[] line : field) {
            Arrays.fill(line, FieldValues.Empty);
        }
    }

    private boolean setValue(FieldValues something, int width, int height)
    {
        if (width >= size || height >= size ) {
            return false;
        }
        if (something != FieldValues.Empty && field[width][height] != FieldValues.Empty){
            return false;
        }
        field[width][height] = something;
        return true;
    }

    public boolean setX(int width, int height) {
        return setValue(FieldValues.X, width, height);
    }

    public boolean setO(int width, int height) {
        return setValue(FieldValues.O, width, height);
    }

    public boolean clearCell(int width, int height) { return setValue(FieldValues.Empty, width, height); }

    public int getLongestX() {
        return getLongestSomething(FieldValues.X);
    }

    public int getLongestO() {
        return getLongestSomething(FieldValues.O);
    }

    private int getLongestSomething(FieldValues something) {
        int count = 0;
        //horizontal check
        for (FieldValues[] cellLine : field) {
            int tempCount = 0;
            for (FieldValues cell : cellLine) {
                if (cell == something) {
                    tempCount++;
                } else {
                    if (tempCount > count) {
                        count = tempCount;
                    }
                    tempCount = 0;
                }
            }
            if (tempCount > count) {
                count = tempCount;
            }
        }
        //vertical check
        for (int i = 0; i < size; i++) {
            int tempCount = 0;
            for (int j = 0; j < size; j++) {
                if (field[j][i] == something) {
                    tempCount++;
                } else {
                    if (tempCount > count) {
                        count = tempCount;
                    }
                    tempCount = 0;
                }
            }
            if (tempCount > count) {
                count = tempCount;
            }
        }
        //diagonal (\) check
        for (int i = 0; i < size; i++) {
            int upTempCount = 0;
            int downTempCount = 0;
            for (int j = i; j < size; j++) {
                if (field[j-i][j] == something) {
                    upTempCount++;
                } else {
                    if (upTempCount > count) {
                        count = upTempCount;
                    }
                    upTempCount = 0;
                }
                if (field[j][j-i] == something) {
                    downTempCount++;
                } else {
                    if (downTempCount > count) {
                        count = downTempCount;
                    }
                    downTempCount = 0;
                }
            }
            if (upTempCount > count) {
                count = upTempCount;
            }
            if (downTempCount > count) {
                count = downTempCount;
            }
        }
        //diagonal (/) check
        for (int i = size-1; i >= 0; i--) {
            int upTempCount = 0;
            int downTempCount = 0;
            for (int j = 0; j < i+1; j++) {
                if (field[i-j][j] == something) {
                    upTempCount++;
                } else {
                    if (upTempCount > count) {
                        count = upTempCount;
                    }
                    upTempCount = 0;
                }
                if (field[j][i-j] == something) {
                    downTempCount++;
                } else {
                    if (downTempCount > count) {
                        count = downTempCount;
                    }
                    downTempCount = 0;
                }
            }
            if (upTempCount > count) {
                count = upTempCount;
            }
            if (downTempCount > count) {
                count = downTempCount;
            }
        }
        return count;
    }
}