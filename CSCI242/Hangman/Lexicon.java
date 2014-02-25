
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Lexicon {
    
    @SuppressWarnings("FieldMayBeFinal")
    private ArrayList<String> wordList;
    private BufferedReader file;
    private String currentLine;
    
    public Lexicon(String filename){
        //Initialize wordList
        wordList = new ArrayList<> ();
        
        //Populate wordList
        //Add each word in file to array list
        try {
            file = new BufferedReader(new FileReader(filename));
            
            while(true) {
                currentLine = file.readLine();
                
                if (currentLine == null) {
                    break;
                }
                
                wordList.add(currentLine);
            }
            
            file.close();
            
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } catch (IOException ex) {
            System.out.println("Error reading file.");
        }
    }
    
    //Get number of words in list
    public int getWordCount() {
        return wordList.size();
    }
    
    //Get the current word's index
    public String getWord(int index) {
        return wordList.get(index);
    }
}