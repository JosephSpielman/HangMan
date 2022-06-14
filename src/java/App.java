import java.util.*;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean gameRunning = true;
        ArrayList<Character> allGuesses = new ArrayList<>();
        ArrayList<Character> comparison = new ArrayList<>();
        ArrayList<Character> correctGuesses = new ArrayList<>();
        ArrayList<Character> incorrectGuesses = new ArrayList<>();


        while(gameRunning) {
            boolean inGame = true;
            int numIncorrect = 0;

            System.out.println("HANGMAN");

            incorrectGuesses.clear();
            allGuesses.clear();
            String generatedWord = Game.chooseWord();
            Game.fillPlaceholders(correctGuesses,generatedWord.length());
            Game.fillWordList(comparison,generatedWord);

            while(inGame) {
                    Game.hangManDisplay(numIncorrect);
                    System.out.println("Missed Guesses: " + Game.printList(incorrectGuesses));
                    System.out.println(Game.printList(correctGuesses));
                    char newGuess = 0;
                    boolean validInput = false;
                    while (!validInput) {
                        try {
                            System.out.println("Guess a letter:");
                            String input = sc.nextLine();
                            if (input.length() != 1) {
                                System.out.println("INVALID ENTRY! Please enter a single character.");
                            } else if (!input.matches("[[A-Z]a-z]")) {
                                System.out.println("INVALID ENTRY! Numbers are not allowed.");
                            } else if (Game.duplicateCheck(input, allGuesses)) {
                                System.out.println("INVALID ENTRY! You already guessed that letter.");
                            } else {
                                input = input.toLowerCase();
                                newGuess = input.charAt(0);
                                allGuesses.add(newGuess);
                                validInput = true;
                            }
                        } catch (Exception e) {
                            System.out.println("Input error!");
                        }
                    }
                    if (Game.guessMatch(newGuess, comparison)) {
                        ArrayList<Integer> indexes = (ArrayList<Integer>) Game.getIndexes(comparison,newGuess);
                        for(int index: indexes){
                            correctGuesses.set(index, newGuess);
                        }
                    } else {
                        incorrectGuesses.add(newGuess);
                        numIncorrect++;
                    }
                if(correctGuesses.equals(comparison)){
                    inGame = false;
                    System.out.println("You WIN! The correct word was "+generatedWord);
                } else if (numIncorrect ==7) {
                    Game.hangManDisplay(numIncorrect);
                    System.out.println("You lose! The correct word was "+generatedWord);
                    inGame = false;
                }
            }
            boolean replayResponse = false;
            while(!replayResponse) {
                try {
                    System.out.println("Would you like to play again? (yes or no)");
                    String input = sc.nextLine();
                    if(input.equalsIgnoreCase("yes")){
                        replayResponse = true;
                    } else if (input.equalsIgnoreCase("no")) {
                        gameRunning = false;
                        replayResponse = true;
                        System.out.println("Thanks for playing!");
                    }else{
                        System.out.println("Invalid Entry! Please enter yes or no.");
                    }
                } catch (Exception e) {
                    System.out.println("Input Error!");
                }
            }
        }
    }
}

