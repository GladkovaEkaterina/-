import java.util.Arrays;

/**
 * main
 * 
 * run with javac Main.java && java -ea Main
 */

class TicTacToe {
    public TicTacToe(int size_) {
        size = size_;
        field = new FieldValues[size][size];
        for (FieldValues[] line : field) {
            Arrays.fill(line, FieldValues.Empty);
        }
    }

    public void setX(int width, int height) {
        field[width][height] = FieldValues.X;
    }

    public void setO(int width, int height) {
        field[width][height] = FieldValues.O;
    }

    public void clearCell(int width, int height) {
        field[width][height] = FieldValues.Empty;
    }

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
            int temp_count = 0;
            for (FieldValues cell : cellLine) {
                if (cell == something) {
                    temp_count++;
                } else {
                    if (temp_count > count) {
                        count = temp_count;
                    }
                    temp_count = 0;
                }
            }
            if (temp_count > count) {
                count = temp_count;
            }
        }
        //vertical check
        for (int i = 0; i < size; i++) {
            int temp_count = 0;
            for (int j = 0; j < size; j++) {
                if (field[j][i] == something) {
                    temp_count++;
                } else {
                    if (temp_count > count) {
                        count = temp_count;
                    }
                    temp_count = 0;
                }
            }
            if (temp_count > count) {
                count = temp_count;
            }
        }
        //dioganal (\) check
        for (int i = 0; i < size; i++) {
            int up_temp_count = 0;
            int down_temp_count = 0;
            for (int j = i; j < size; j++) {
                if (field[j-i][j] == something) {
                    up_temp_count++;
                } else {
                    if (up_temp_count > count) {
                        count = up_temp_count;
                    }
                    up_temp_count = 0;
                }
                if (field[j][j-i] == something) {
                    down_temp_count++;
                } else {
                    if (down_temp_count > count) {
                        count = down_temp_count;
                    }
                    down_temp_count = 0;
                }
            }
            if (up_temp_count > count) {
                count = up_temp_count;
            }
            if (down_temp_count > count) {
                count = down_temp_count;
            }            
        }
        //dioganal (/) check
        for (int i = size-1; i >= 0; i--) {
            int up_temp_count = 0;
            int down_temp_count = 0;
            for (int j = 0; j < i+1; j++) {
                if (field[i-j][j] == something) {
                    up_temp_count++;
                } else {
                    if (up_temp_count > count) {
                        count = up_temp_count;
                    }
                    up_temp_count = 0;
                }
                if (field[j][i-j] == something) {
                    down_temp_count++;
                } else {
                    if (down_temp_count > count) {
                        count = down_temp_count;
                    }
                    down_temp_count = 0;
                }
            }
            if (up_temp_count > count) {
                count = up_temp_count;
            }
            if (down_temp_count > count) {
                count = down_temp_count;
            }  
        }
        return count;
    }

    enum FieldValues {
        X,
        O,
        Empty;
    }

    private int size;
    private FieldValues [][] field;
}

public class Main {

    public static void main(String[] args) {
        // Horizontal test
        {
            TicTacToe game = new TicTacToe(4);
            game.setX(0, 0);
            // game.setX(0, 1);
            game.setX(0, 2);
            game.setX(0, 3);
            assert game.getLongestX() == 2;
        }
        // Vertical test
        {
            TicTacToe game = new TicTacToe(5);
            game.setX(0, 0);
            game.setX(1, 0);
            game.setX(2, 0);
            game.setX(3, 0);
            assert game.getLongestX() == 4;
        }
        // Diagonal test (\)
        {
            TicTacToe game = new TicTacToe(5);
            game.setX(0, 0);
            game.setX(1, 1);
            game.setX(2, 2);
            // game.setX(3, 3);
            assert game.getLongestX() == 3;
        }
        // Diagonal test (/)
        {
            TicTacToe game = new TicTacToe(5);
            game.setX(0, 2);
            game.setX(1, 1);
            game.setX(2, 0);
            assert game.getLongestX() == 3;
        }
    }
}