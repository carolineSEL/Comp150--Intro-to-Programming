// Import statements go here.  For example,
// import java.awt.Color;
// import java.util.ArrayList;
// import java.util.Random;

/**
 *  Lab 5: Refactoring the Textual Analysis Project
 *
 *  The NewWordCounterApp provides a new main method to execute the textual
 *  analysis functions from the WordCounterApp.
 *
 *  The program analyzes text from "AliceInWonderland.txt", 
 *  "TheMischievousTypesetter.txt", and "DarkDestiny.txt".
 *
 *  @author Caroline Lamb
 *  @author [your partner's name]
 *  @author [with assistance from ... (including instructor/TAs)]
 *  @author [working side-by-side with ...]
 *  @version 7/24/2021
 */
public class NewWordCounterApp
{
    /**
     *  The main function initiates execution of this program.
     *    @param    String[] args not used in this program
     *              (but main methods always need this parameter)
     **/
    public static void main(String[] args)
    {
        System.out.println ("Welcome to Programming Project X.");
        
        TextAnalyzer analyzer = new TextAnalyzer("AliceInWonderland.txt");
        analyzer.analyzeBook(33, 12, "time", "alice", 30);
        
        
        TextAnalyzer analyzerB = new TextAnalyzer("DarkDestiny.txt");
        analyzerB.analyzeBook(33, 12, "time", "namboina", 30);
        
        TextAnalyzer analyzerC = new TextAnalyzer("TheMischievousTypesetter.txt");
        analyzerC.analyzeBook(33, 12, "time", "arturius", 30);
        
        System.out.println ("Program done.");

    }//end main

}//end class
