import java.io.IOException;
import java.sql.Array;
import java.util.*;

public class Game {


    static void hangManDisplay(int counter){
        String head = "\t |";
        String body = "\t |";
        String legs = "\t |";

        if(counter >= 1){
            head = " 0 \t |";
        }
        if(counter >= 2){
            body = " | \t |";
        }
        if(counter >= 3){
            legs = " | \t |";
        }
        if(counter >= 4){
            body = "-| \t |";
        }
        if(counter >= 5){
            body = "-|-\t |";
        }
        if(counter >= 6){
            legs = "_| \t |";
        }
        if(counter >= 7){
            legs = "_|_\t |";
        }

        System.out.println("+----+");
        System.out.println(head);
        System.out.println(body);
        System.out.println(legs);
        System.out.println("\t===");
    }
     public static String chooseWord() {
        //String[] words = new String[]{"cat", "bat", "vat", "mat"};
         String[] words = new String[]{"cat","wombat"};

        Random rnd = new Random();
        int choice = rnd.nextInt(words.length);
        String out = words[choice];
        return out;
    }

    public static String printList(List in){
        String out = "";
        for(Object c : in){
            out += c;
        }
        return out;
    }
    public static void fillWordList(List in,String word){
        in.clear();
        char[] letters = word.toCharArray();
        for (char c: letters){
            in.add(c);
        }
    }
    public static void fillPlaceholders(List in,int length){
        in.clear();
        for(int x =0;x<length;x++){
            in.add('_');
        }
    }
    public static boolean duplicateCheck(String input,List guesses){
        input = input.toLowerCase();
        char cValue = input.charAt(0);
        for(Object o:guesses){
            if(o.equals(cValue)){
                return true;
            }
        }
        return false;
    }

    public static boolean guessMatch(char input, List comparison){
        for(Object o:comparison){
            if(o.equals(input)){
                return true;
            }
        }
        return false;
    }
}
