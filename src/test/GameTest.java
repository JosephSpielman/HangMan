import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {


    @org.junit.jupiter.api.Test
    void printList() {
        ArrayList<Character> in = new ArrayList<>();
        in.add('c');
        in.add('a');
        in.add('t');
        assertEquals("cat",Game.printList(in));
    }

    @org.junit.jupiter.api.Test
    void duplicateCheckTrue() {
        ArrayList<Character> in = new ArrayList<>();
        in.add('c');
        in.add('a');
        in.add('t');
        assertTrue(Game.duplicateCheck("c",in));
    }

    @org.junit.jupiter.api.Test
    void duplicateCheckFalse() {
        ArrayList<Character> in = new ArrayList<>();
        in.add('c');
        in.add('a');
        in.add('t');
        assertFalse(Game.duplicateCheck("q",in));
    }

    @org.junit.jupiter.api.Test
    void guessMatchTrue() {
        ArrayList<Character> in = new ArrayList<>();
        in.add('c');
        in.add('a');
        in.add('t');
        assertTrue(Game.guessMatch('c',in));
    }

    @org.junit.jupiter.api.Test
    void guessMatchFalse() {
        ArrayList<Character> in = new ArrayList<>();
        in.add('c');
        in.add('a');
        in.add('t');
        assertFalse(Game.guessMatch('q',in));
    }
}