// Import statements go here.  For example,
// import java.awt.Color;
import java.util.ArrayList;
// import java.util.Random;

/**
 *  Lab 2: Reading from a File<br>
 *
 *  The WordCounterApp class provides a main method
 *  for a program that analyzes text.
 *
 *  This program reads and analyzes text from the books "Alice in Wonderland",
 *  "A Mischievous Type", and "Dark Destiny". It counts the number of lines, 
 *  number of words in a line, number of characters in a word, and most frequent
 *  words along with their frequency.
 *
 *  @author Caroline Lamb
 *  @author [your partner's name]
 *  @author with assistance from Nikola Bogoevich, Dr. Cutter, and Dr. Brady
 *  @author [working side-by-side with ...]
 *  @version 7/21/2021
 */
public class WordCounterApp
{
    /**
     *  The main function initiates execution of this program.
     *    @param    String[] args not used in this program
     *              (but main methods always need this parameter)
     **/
    public static void main(String[] args)
    {
        System.out.println ("Welcome to the Word Counting Program.");

        // Construct one or more objects, then invoke one or more
        // methods to get the program started.  For example:
        //   SomeClass obj = new SomeClass(someParameter);
        //   obj.modifyObject(aDifferentParameter);
        //   int anInteger = obj.getSomeIntAttribute();

        // A class that reads text from the book "Alice in Wonderland. "
        WordReader AinW = new WordReader("AliceInWonderland.txt");
        // A class that reads text from the book "A Mischievous Typesetter".
        WordReader MisType = new WordReader("TheMischievousTypesetter.txt");
        // A class that reads text from the book "Dark Destiny".
        WordReader DarkDes = new WordReader("DarkDestiny.txt");

        // A variable that will be used to count the number of lines.
        int lineCounter = 0;
        // A variable that will be used to count the total length of all
        // the lines. 
        double lineLength = 0;
        // A variable that will be used to count the total number of words. 
        double wordSum = 0;
        //  variable that will be used to count the average word length.
        double wordLength = 0;

        // Reads in the first line of text from the book.     
        String lineRead= AinW.getNextLine();
        // Increments the total number of lines.
        lineCounter ++;
        System.out.println("Line " + lineCounter + ": " + lineRead);
        // Increments the total length of lines.
        lineLength = lineRead.length();
        
        // Creates an array list of words from a line.
        ArrayList<String> listOfWords = AinW.breakIntoWords(lineRead);
        // gets the size of the previous array list. 
        int sizeOfList = listOfWords.size();

        System.out.println("The length of the first line is " + lineLength + 
            ". There are " + sizeOfList + " words in this line." );

        // Skips through 6o lines and counts the number of lines and length of those lines and increments those counters.
        for (int i = 0; i<= 60; i++) {
            lineRead = AinW.getNextLine();
            System.out.print(".");
            lineCounter ++;
            lineLength = lineLength + lineRead.length();
        }

        System.out.println("Skipping 60 lines: .........");
        lineRead = AinW.getNextLine();
        
        // Gets length of the first line printed after skipping loop.
        double lineLength62 = lineRead.length();
        System.out.println("Line " + lineCounter + ": " + lineRead);

        // Creates array list of all of the words used in the text "Alice in Wonderland".
        listOfWords = AinW.breakIntoWords(lineRead);
        sizeOfList = listOfWords.size();

        System.out.println("The length of the 60th line is " + 
                            lineLength62 + ". There are " + sizeOfList + 
                            " words in this line.");

        lineLength = lineLength + lineLength62;

        // Reads & prints next 20 lines of text and information about that text.
        for (int i = 1; i< 21; i++) {
            lineRead = AinW.getNextLine(); 
            lineCounter ++;
            System.out.println("Line " + lineCounter + ": " + lineRead);
            lineLength = lineLength + lineRead.length();
            listOfWords = AinW.breakIntoWords(lineRead);
            sizeOfList = listOfWords.size();
            wordSum = wordSum + sizeOfList;
            for ( String words: listOfWords) {
                wordLength = wordLength + words.length();
            }
        } 

        System.out.println("The average number of words per line in the last 20 lines is " 
            + wordSum/20.0  +  ".");

        System.out.println("The average length of words in the last 20 lines is "
            + wordLength/wordSum + "."); 

        System.out.println("The average line length of the printed and skipped lines is " 
            + lineLength / lineCounter );

        // Reads through and analyzes entire text. 
        String nextLine = AinW.getNextLine();
        for ( nextLine = AinW.getNextLine(); nextLine != null; 
        nextLine = AinW.getNextLine() )
        {
            lineCounter ++;
            lineLength = lineLength + nextLine.length();
            listOfWords = AinW.breakIntoWords(nextLine);
            sizeOfList = listOfWords.size();
            wordSum = wordSum + sizeOfList;
            for ( String words: listOfWords) {
                wordLength = wordLength + words.length();
            }
        }

        System.out.println("Including the title, TOC, and additional information about the book, AliceInWonderland.txt has "
            + wordSum + " words across " + lineCounter + "lines.");

        System.out.println("The average line length for the entire book is " + 
            lineLength / lineCounter);

        System.out.println("There are about " + wordSum / lineCounter + " words per line." );

        System .out.println("Words are about " + wordLength/wordSum + " characters long.");

        // Creates array list of words and distinct words from the text "A Mischievous Typesetter". 
        ArrayList<String> listOfWords2 = MisType.breakIntoWords(MisType.getNextLine());
        ArrayList<String> distinctWords2 = MisType.getFullWordList();

        // New set of exercises begins here.
        System.out.println(" ");
        System.out.println("......................................New Exercises.........................................");
        System.out.println(" ");

        // Creates an array list of all distinct words in the text "Alice in Wonderland".
        ArrayList<String> distinctWords = AinW.getFullWordList();
        System.out.println("There are " + distinctWords.size() + " distinct words in the book.");

        // A variable to count the number of words that appear only once in the text.
        int singletonWords = 0;
        // A variable to count the number of words that are longer than 14 letters.
        int longWords = 0;

        // Finds all words that appear only once in the text or that are longer than 14 characters.
        System.out.println("Words that are more than 14 characters long in AliceInWonderland.txt: ");
        for (String word: distinctWords) {
            if (AinW.getCountFor(word) == 1){
                singletonWords++;  
            }
            if (word.length() > 14) {
                longWords++;
                System.out.print(word + " ");
            }
        }

        System.out.println();
        System.out.println("AliceInWonderland.txt has " + longWords + " words that are more than 14 characters long.");

        System.out.println("There are " + singletonWords + " words that occur only once in AliceInWonderland.txt.");

        System.out.println("Words containing 'house': ");
        for (String word: distinctWords) {
            if (word.contains("house")){
                System.out.print(word + " (" + AinW.getCountFor(word) + "); ");
            }
        }
        System.out.println();
        System.out.println("Words containing 'time': ");
        for (String word: distinctWords) {
            if (word.contains("time")){
                System.out.print(word + " (" + AinW.getCountFor(word) + "); ");
            }
        }
        System.out.println();
        System.out.println("Words containing 'fall': ");
        for (String word: distinctWords) {
            if (word.contains("fall")){
                System.out.print(word + " (" + AinW.getCountFor(word) + "); ");
            }
        }
        System.out.println();
        System.out.println("Words containing 'hole': ");
        for (String word: distinctWords) {
            if (word.contains("hole")){
                System.out.print(word + " (" + AinW.getCountFor(word) + "); ");
            }
        }
        System.out.println();
        System.out.println("Words containing 'rabbit': ");
        for (String word: distinctWords) {
            if (word.contains("rabbit")){
                System.out.print(word + " (" + AinW.getCountFor(word) + "); ");
            }
        }

        int Alice = 0;
        int MadHatter = 0;
        int QueenOfHearts = 0;
        int CheshireCat = 0;
        int WhiteRabbit = 0;
        int Caterpillar = 0;
        // Finds number of times specific characters are mentioned in the text. Prints those numbers after the loop.
        for (String word: distinctWords){
            if (word.equals("alice")){
                Alice = Alice + AinW.getCountFor("alice");
            }
            if (word.equals("hatter")){
                MadHatter = MadHatter + AinW.getCountFor("hatter");
            }
            if (word.equals("queen")){
                QueenOfHearts =  QueenOfHearts + AinW.getCountFor("queen");
            }
            if (word.equals("cheshire")) {
                CheshireCat = CheshireCat + AinW.getCountFor("cheshire");
            }
            if (word.equals("rabbit")){
                WhiteRabbit = WhiteRabbit + AinW.getCountFor("rabbit");
            }
            if (word.equals("caterpillar")){
                Caterpillar = Caterpillar + AinW.getCountFor("caterpillar");
            }
        }
        System.out.println();
        System.out.println("There are " + Alice + " references to Alice in AliceInWonderland.txt.");
        System.out.println("There are " + QueenOfHearts + " references to Queen of Hearts in AliceInWonderland.txt.");
        System.out.println("There are " + MadHatter + " references to Mad Hatter in AliceInWonderland.txt.");
        System.out.println("There are " + CheshireCat + " references to the Cheshire Cat in AliceInWonderland.txt.");
        System.out.println("There are " + WhiteRabbit + " references to the White Rabbit in AliceInWonderland.txt.");
        System.out.println("There are " + Caterpillar + " references to the Caterpillar in AliceInWonderland.txt.");

        // Beginning new exercises.
        System.out.println();
        System.out.println("..........................................New Exercises .....................................");
        System.out.println();

        // A variable to calculate the most frequently used word. (For the book Alice in Wonderland).
        String frequentWord = null;
        // A variable to calculate the number of times the most frequently used word is used. (For the book Alice in Wonderland).
        int frequencyNum = -1;
        // Gets most frequently used word in the text "Alice in Wonderland" and counts how many times it is used. 
        for (String word: distinctWords) {
            if (AinW.getCountFor(word) > frequencyNum){
                frequentWord = word;
                frequencyNum = AinW.getCountFor(frequentWord);
            }
        }
        System.out.println("The most frequently used word in AliceInWonderland.txt is " + frequentWord +
            ". " + "It occurs " + frequencyNum + " times.");

        // A variable to calculate the most frequently used word. (For the book A Mischievous Type).
        int frequencyNum2 = -1;
        // A variable to calculate the number of times the most frequently used word is used. (For the book A Mischievous Type).
        String frequentWord2 = null;
        // Gets most frequently used word in the text "A Mischievous Type" and counts how many times it is used.
        for (String book2Words: distinctWords2) {
            if (MisType.getCountFor(book2Words) > frequencyNum2){
                frequentWord2 = book2Words;
                frequencyNum2 = MisType.getCountFor(frequentWord2);
            }
        }                    
        System.out.println("The most frequently used word in TheMischievousType.txt is " + frequentWord2 +
            ". " + "It occurs " + frequencyNum2 + " times.");
        
        // Creates an array list with all distinct words in the text "Dark Destiny".
        ArrayList<String> distinctWords3 = DarkDes.getFullWordList();    
        // Creates an array list of the most frequent words. 
        ArrayList<String> frequentWords = new ArrayList<String>();
        int upperBound = 1850;
        // Gets 40 most frequently used words in a text. 
        for (int i = 0; i < 40; i++){
            int frequencyNum3 = -1;
                for (String word: distinctWords3){
                    if (DarkDes.getCountFor(word) > frequencyNum3 && 
                    DarkDes.getCountFor(word) < upperBound){
                    frequencyNum3 = DarkDes.getCountFor(word);
                    }
                }
                for (String word: distinctWords3){
                    if (DarkDes.getCountFor(word) == frequencyNum3){
                    frequentWords.add(word);
                    }
                }
            upperBound = frequencyNum3;
        }
        
        System.out.println("The 40 most frequently used word(s) are: ");
        for (String frequentWordsListed : frequentWords){
            System.out.println(frequentWordsListed  +  " ("  + 
            DarkDes.getCountFor(frequentWordsListed) + ")");
        }

        System.out.println();
        System.out.println ("Program done.");

    }//end main
}//end class
