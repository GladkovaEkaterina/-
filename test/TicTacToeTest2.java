import org.junit.Test;
import spbstu.tpj.TicTacToe;

import static org.junit.Assert.*;

public class TicTacToeTest2 {
    @Test
    public void test(){
        TicTacToe example = new TicTacToe(6);
        example.setO(5, 5);
        example.setO(4, 5);
        assertEquals(2, example.getLongestO());
    }
    {
        TicTacToe example = new TicTacToe(6);
        example.setX(0, 0);
        example.setX(1, 0);
        example.setX(2, 0);
        example.setX(3, 0);
        assertEquals(4, example.getLongestX());
    }
    {
        TicTacToe example = new TicTacToe(6);
        example.setO(5, 5);
        assertEquals(1, example.getLongestO());
        example.clearCell(5, 5);
        assertEquals(0, example.getLongestO());
    }
    {
        TicTacToe example = new TicTacToe(6);
        example.setX(0, 0);
        example.setX(1, 0);
        example.setX(2, 1);
        example.setX(3, 2);
        assertEquals(3, example.getLongestX());
    }
    {
        TicTacToe example = new TicTacToe(6);
        example.setX(0, 0);
        example.setX(1, 1);
        example.setX(1, 0);
        example.setX(2, 1);
        example.setX(3, 2);
        assertEquals(3, example.getLongestX());
    }
    {
        TicTacToe example = new TicTacToe(6);
        example.setX(0, 0);
        example.setX(1, 1);
        example.setX(0, 1);
        example.setX(1, 2);
        example.setX(2, 3);
        assertEquals(3, example.getLongestX());
    }
    {
        TicTacToe example = new TicTacToe(6);
        example.setX(5, 5);
        example.setX(4, 4);
        example.setX(1, 0);
        example.setX(2, 1);
        example.setX(3, 2);
        assertEquals(3, example.getLongestX());
    }

}