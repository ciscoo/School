/*
 * Simple Hangman game
 *
 * @author Francisco Mateo
 *
*/
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Hangman {
    
    @SuppressWarnings("FieldMayBeFinal")
    private Lexicon lexicon;
    
    @SuppressWarnings("FieldMayBeFinal")
    private String word;
    
    private String currentState;
    
    @SuppressWarnings("FieldMayBeFinal")
    private ArrayList<Character> guessedLetters;
    
    @SuppressWarnings("FieldMayBeFinal")
    private int incorrectGuesses;
    
    @SuppressWarnings("FieldMayBeFinal")
    private int allowedGuesses;
    
    private int compare;
    
    Random randomGen = new Random();
    
    public Scanner input;
    public String guess;
    public final CharSequence checker;
    
    @SuppressWarnings("OverridableMethodCallInConstructor")
    public Hangman(String filename) {
        
        //Dash is used for checkCurrentState().
        checker = "-";
       
        //Instatiate new scanne for input
        input = new Scanner(System.in);
       
        //Prevent first char as null
        currentState = "";
        guess = "";
        
        incorrectGuesses = 0;
        allowedGuesses = 8;
        
        lexicon = new Lexicon(filename);
        word = getRandomWord();
        setCurrentState();
        guessedLetters = new ArrayList<> ();
    }
    
    //Method that plays the Hangman game
    public void play() {
        System.out.println("Please enter your guess: ");
    
        while (!(gameOver())) {
            
            guess = input.nextLine();
            guess = guess.toUpperCase();
            update(guess.charAt(0));
            if (!(checkCurrentState(checker))) break;
            
        }
        if (gameOver()) {
            System.out.println(gameOverMessage());
        } else {
            System.out.println("You win!");
        }
    }
    
    public void setCompare (int n) {
        compare = n;
    }
    
    public int getCompare() {
        return compare;
    }
    
    //Method that updates current game status
    public void update(char guess) {
        //Add guessed letter to ArrayList<>
        guessedLetters.add(guess);
        
        //Check if letter is in word
        //If true, replace char at position i with guessed letter
        checkState(guess);
        
        //Decrement guesses
        allowedGuesses -= 1;
        
        System.out.println("");
        System.out.println("Guesses remaining: " + getIncorrectGuessesRemaining());
        System.out.println("Guessed letters: " + getGuessedLetters());
        System.out.println("Current state: " + getCurrentState());
        //System.out.println(getWord());
    }
    
    public void checkState(char guess) {
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == guess) {
                currentState = currentState.substring(0,i) + guess + currentState.substring(i+1);    
            }
        }
    }
    
    //Method to random select a word from Lexicon
    @SuppressWarnings("FinalPrivateMethod")
    private final String getRandomWord() {
        int randomIndex = randomGen.nextInt(lexicon.getWordCount());
        word = lexicon.getWord(randomIndex);
        return word;
    }
    
    public String getWord() {
        return word;
    }
    
    //Method to set current state
    //Get word length, creates string of dashes to length of word
    public void setCurrentState() {
        for (int i = 0; i < word.length(); i++) {
            currentState += "-";
        }
    }
    
    //Boolean to see if user has guessed all letters in word
    //If true, currentState still has dashes, false it does not.
    public boolean checkCurrentState(CharSequence dash) {
        return getCurrentState().contains(dash);
    }
    
    public String getCurrentState() {
        return currentState;
    }
    
    public ArrayList<Character> getGuessedLetters() {
        return guessedLetters;
    }
    
    public int getIncorrectGuessesRemaining() {
        return allowedGuesses;
    }
    
    public boolean gameOver() {
        return !currentState.contains("-") || incorrectGuesses >= allowedGuesses;
    }
    
    public String gameOverMessage() {
        return "You lose! \n Word was: " + getWord();
    }
        
    public int getIncorrentGuessesMade() {
        return incorrectGuesses;
    }
    
    public static void main(String[] args) {
        Hangman game = new Hangman("HangmanLexicon.txt");
        //Hangman game = new Hangman("ShorterLexicon.txt");
        game.play();
    }
    
}