import org.junit.Before;
import org.junit.Test;
import spbstu.tpj.TicTacToe;

import static org.junit.Assert.*;

public class TicTacToeTest {
    private TicTacToe example;
    @Before
    public void before(){
        example = new TicTacToe(6);
    }
    @Test
    public void testGetLongestX1() {
        example.setX(0, 0);
        example.setX(1, 0);
        example.setX(2, 0);
        example.setX(3, 0);
        assertEquals(4, example.getLongestX());
    }
    @Test
    public void testClearCell() {
        example.setO(5, 5);
        assertEquals(1, example.getLongestO());
        example.clearCell(5, 5);
        assertEquals(0, example.getLongestO());
    }
    @Test
    public void testGetLongestX2(){
        example.setX(0, 0);
        example.setX(1, 0);
        example.setX(2, 1);
        example.setX(3, 2);
        assertEquals(3, example.getLongestX());
    }
    @Test
    public void testGetLongestX3(){
        example.setX(0, 0);
        example.setX(1, 1);
        example.setX(1, 0);
        example.setX(2, 1);
        example.setX(3, 2);
        assertEquals(3, example.getLongestX());
    }
    @Test
    public void testGetLongestX4(){
        example.setX(0, 0);
        example.setX(1, 1);
        example.setX(0, 1);
        example.setX(1, 2);
        example.setX(2, 3);
        assertEquals(3, example.getLongestX());
    }
    @Test
    public void testGetLongestX5(){
        example.setX(5, 5);
        example.setX(4, 4);
        example.setX(1, 0);
        example.setX(2, 1);
        example.setX(3, 2);
        assertEquals(3, example.getLongestX());
    }
}