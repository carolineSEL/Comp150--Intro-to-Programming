// Import statements go here.  For example,
// import java.awt.Color;
import java.util.ArrayList;
// import java.util.Random;

/**
 *  Lab 5: Refactoring the Textual Analysis Project.
 *
 *  Analyzes the text from a given file.
 *
 *  This program counts the number of lines, number of words in a line, 
 *  number of characters in a word, and most frequent words along with their frequency..
 *
 *  @author Caroline Lamb
 *  @author [your partner's name]
 *  @author [with assistance from ... (including instructor/TAs)]
 *  @author [working side-by-side with ...]
 *  @version 7/24/2021
 */
public class TextAnalyzer
{
    // State: instance variables and shared class variables go here.
    private WordReader reader; 
    private ArrayList<String> distinctWords;

    // Constructors

    /**
     * Constructs a new object of this class.
     *      @param   String   takes the name of file to be read 
     */
    public TextAnalyzer(String filename)
    {
        // initialise instance variables
        this.reader = new WordReader(filename);
        this.distinctWords = this.reader.getFullWordList();
    }

    // Methods

    /**
     * Does something (replace this description with a one-sentence summary
     * of your own).
     * You may provide more details in later sentences, but note
     * that they will only appear in the Method Details section of
     * the class documentation, not the Method Summary section.
     *      @param  parameter a sample parameter for a method
     *      @return the attribute value
     */
    //public int sampleMethod(int parameter);

    //this.instVar = parameter;   // this would change value of instVar
    //return this.instVar;        // return new value of instVar

    /**
     * Reads and processes a line from the text.
     *  
     *      @return returns the length of the line and number of words in the
     *              line. 
     */
    public void processLine()
    {
        String lineRead = this.reader.getNextLine(); 
        ArrayList<String> listOfWords = this.reader.breakIntoWords(lineRead);
        System.out.println("The length of the line is " + lineRead.length() + 
            ". There are " + listOfWords.size() + " words in this line." );
    }

    /**
     * Skips through the given number of lines in the file. 
     * 
     *      @param  Takes number of lines to skip through as a parameter.  
     */
    public void skipLines(int numLines)
    {
        int lineCounter = 0;
        double lineLength = 0;
        for (int i = 0; i<= numLines; i++) {
            String lineRead = this.reader.getNextLine();
            lineCounter++;
            lineLength = lineLength + lineRead.length();
        }
    }

    /**
     * Calculates the average number of words per line and the average length
     * of words in the text. 
     * 
     *      @param  takes the number of lines to get averages from as a parameter.
     *      @return returns the average number of words per line and average
     *              length of words in the given number of lines. 
     */
    public void getAverages(int numLines) 
    {
        double wordLength = 0;
        double wordSum = 0;
        String lineRead = this.reader.getNextLine(); 
        ArrayList<String> listOfWords = this.reader.breakIntoWords(lineRead); 
        for (int i = 0; i < numLines; i++) {
            lineRead = this.reader.getNextLine();
            listOfWords = this.reader.breakIntoWords(lineRead);
            wordSum = wordSum + listOfWords.size();
            for ( String words: listOfWords) {
                wordLength = wordLength + words.length();
            }
        }
        System.out.println("There are about " + wordSum / numLines + " words per line." );

        System .out.println("Words are about " + wordLength/wordSum + " characters long.");

    }

    /**
     * Analyzes the text for total number of lines and words in the file,
     * the number of distinct words, the number of words used only once, and 
     * the number of long words. 
     * 
     *      @param  takes the minimum number of characters desired for a word
     *              to be considered long. 
     *      @return returns the total number of lines and words in the file, 
     *              number of distinct words, number of long words and a list
     *              of those words, and number of words that occur only once in
     *              the text. 
     */
    public void wordAnalysis(int numCharacters)
    {
        // A variable that will be used to count the number of lines.
        int lineCounter = 0;
        // A variable that will be used to count the total length of all
        // the lines. 
        double lineLength = 0;
        // A variable that will be used to count the total number of words. 
        double wordSum = 0;
        //  variable that will be used to count the average word length.
        double wordLength = 0;

        String lineRead = this.reader.getNextLine();
        ArrayList<String> listOfWords = this.reader.breakIntoWords(lineRead);
        int sizeOfList = listOfWords.size();

        String nextLine = this.reader.getNextLine();
        for ( nextLine = this.reader.getNextLine(); nextLine != null; 
        nextLine = this.reader.getNextLine() )
        {
            lineCounter ++;
            lineLength = lineLength + nextLine.length();
            listOfWords = this.reader.breakIntoWords(nextLine);
            sizeOfList = listOfWords.size();
            wordSum = wordSum + sizeOfList;
            for ( String words: listOfWords) {
                wordLength = wordLength + words.length();
            }
        }
        System.out.println("Including the title, TOC, and additional information about the book, the file contains "
            + wordSum + " words across " + lineCounter + "lines.");
        System.out.println("There are " + distinctWords.size() + " distinct words in the book.");
        int singletonWords = 0;
        int longWords = 0;
        System.out.println("Words that are more than " + numCharacters + " characters long: ");
        for (String word: distinctWords) {
            if (this.reader.getCountFor(word) == 1){
                singletonWords++;  
            }
            if (word.length() > numCharacters) {
                longWords++;
                System.out.print(word + " ");
            }
        }

        System.out.println();
        System.out.println("There are " + longWords + " words that are more than " + numCharacters + " characters long.");

        System.out.println("There are " + singletonWords + " words that occur only once in the text.");

    }

    /**
     * Analyzes text for words that contain the baseword in them.
     * 
     * 
     *      @param  takes the baseword as a parameter.
     *      @return returns list of words containing the baseword and the
     *      number of times they occur in the text. 
     */
    public void analyzeBaseWord(String baseword)
    {
        System.out.println("Words containing '" + baseword + "': ");
        for (String word: distinctWords) {
            if (word.contains(baseword)){
                System.out.print(word + " (" + this.reader.getCountFor(word) + "); ");
            }
        }
        System.out.println();
    }

    /**
     * Analyzes the text for the number of times a given character is mentioned. 
     * 
     *      @param  takes the name of the character to look for as a parameter.
     *      @return returns the number of times the character is mentioned in
     *              the text. 
     */
    public void measureCharacterImportance(String characterName)
    {
        int Character = 0;
        for (String word: distinctWords){
            if (word.equals(characterName)){
                Character = Character + this.reader.getCountFor(characterName);
            }
        }
        System.out.println();
        System.out.println("There are " + Character + " references to " + 
            characterName + " in the text.");
    }
    
    /**
     * Finds the most frequently used word in the text.

     *      @return returns the most frequently used word and the number of
     *              times it occurs in the text. 
     */
    public void mostFrequentWord() 
    {
        String frequentWord = null;
        int frequencyNum = -1;
        for (String word: distinctWords) {
            if (this.reader.getCountFor(word) > frequencyNum){
                frequentWord = word;
                frequencyNum = this.reader.getCountFor(frequentWord);
            }
        }
        System.out.println("The most frequently used word in the text is " + frequentWord +
            ". " + "It occurs " + frequencyNum + " times.");
    }
    
    /**
     * Finds multiple frequently used words and prints them. 
     * 
     *      @param  takes the number of frequently used words to find as a 
     *              parameter. 
     *      @return returns a list of the most frequently used words and the 
     *              number of times they are used in the text. 
     */
    public void mostFrequentWords(int numWords) 
    {
        ArrayList<String> frequentWords = new ArrayList<String>();
        int upperBound = 1850;
        // Gets 40 most frequently used words in a text. 
        for (int i = 0; i < numWords; i++){
            int frequencyNum = -1;
                for (String word: distinctWords){
                    if (this.reader.getCountFor(word) > frequencyNum && 
                    this.reader.getCountFor(word) < upperBound){
                    frequencyNum = this.reader.getCountFor(word);
                    }
                }
                for (String word: distinctWords){
                    if (this.reader.getCountFor(word) == frequencyNum){
                    frequentWords.add(word);
                    }
                }
            upperBound = frequencyNum;
        }
        
        System.out.println("The " + numWords + "  most frequently used word(s) are: ");
        for (String frequentWordsListed : frequentWords){
            System.out.println(frequentWordsListed  +  " ("  + 
            this.reader.getCountFor(frequentWordsListed) + ")");
        }
    }

    /**
     * Analyzes file passed to the reader using all methods of the TextAnalyzer
     * class. 
     
     *      @param  numLines:       takes the number of lines to read through
     *              numCharacters:  takes the minimum number of characters 
     *                              desired for a word to be considered long.
     *              baseword:       takes the baseword as a parameter.
     *              characterName:  takes the name of the character to look for 
     *                              as a parameter.
     *              numWords:       takes the number of frequently used words 
     *                              to find as a parameter.
     *                              
     *      @return returns the return of each previous method in the TextAnalysis
     *              class. 
     */
    public void analyzeBook(int numLines, int numCharacters, String baseword, 
                                String characterName, int numWords ) {
        processLine();
        skipLines(numLines);
        processLine();
        getAverages(numLines);
        wordAnalysis(numCharacters);
        analyzeBaseWord(baseword);
        measureCharacterImportance(characterName);
        mostFrequentWord();
        mostFrequentWords(numWords);                            
    }
}