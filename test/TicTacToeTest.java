import org.junit.Test;

import static org.junit.Assert.assertEquals;

class TicTacToeTest {

}

/**public class Main {
    public void  getTest(){
     TicTacToe example = new TicTacToe(6);
     example.setO(6, 6);
     example.setO(5, 6);
     assertEquals(2, example.getLongestO());
    }

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
 */