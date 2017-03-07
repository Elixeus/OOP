package textgen;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** 
 * An implementation of the MTG interface that uses a list of lists.
 * @author UC San Diego Intermediate Programming MOOC team
 * @author Xia's own implementation
 */
public class MarkovTextGeneratorLoL implements MarkovTextGenerator {

	// The list of words with their next words
	private List<ListNode> wordList; 
	
	// The starting "word"
	private String starter;
	
	// The random number generator
	private Random rnGenerator;
	
	public MarkovTextGeneratorLoL(Random generator)
	{
		wordList = new LinkedList<ListNode>();
		starter = "";
		rnGenerator = generator;
	}
	
	
	/** Train the generator by adding the sourceText */
	@Override
	public void train(String sourceText)
	{
		// TODO: Implement this method
		// parse the text
		if(sourceText.equals("")){
			System.out.println("");
		}
			else{
			ArrayList<String> words = new ArrayList<String>();
			Pattern pat = Pattern.compile("[a-zA-Z0-9]+[,.!:]{0,1}");
			Matcher m = pat.matcher(sourceText);
			while(m.find()){
				words.add(m.group());
			}
			// set "starter" to be the first word in the text
			starter = words.get(0);
			// set prevWord to be starter
			String prevWord = starter;
			for (String w: words.subList(1, words.size())){
				// create an array list named test of all the words in the wordList
				ArrayList<String> test = new ArrayList<String>();
				for (ListNode x: wordList){
					test.add(x.getWord());
				}
				// use the test variable to verify if prevWord is in the wordList
				if (test.contains(prevWord)){
					wordList.get(test.indexOf(prevWord)).addNextWord(w);;
				}
				else{
					ListNode prevNode = new ListNode(prevWord);
					prevNode.addNextWord(w);
					wordList.add(prevNode);
				}
				prevWord = w;
			}
			// TODO: need to check if the word of the last node is already in the wordList
			//       if so, add the last word to the nextList of that node
			ArrayList<String> allWords = new ArrayList<String>();
			for (ListNode n: wordList){
				allWords.add(n.getWord());
			}
			String lastWord = words.get(words.size()-1);
			if (allWords.contains(lastWord)){
				ListNode lastNode = wordList.get(allWords.indexOf(lastWord));
				lastNode.addNextWord(starter);
			}
			else{
				ListNode last = new ListNode(lastWord);
				last.addNextWord(starter);
				wordList.add(last);
			}
		}
	}
	
	/** 
	 * Generate the number of words requested.
	 */
	@Override
	public String generateText(int numWords) {
	    // TODO: Implement this method
		// if the generator has not been trained
		if(wordList.isEmpty()){
			return "";
		}
		else if(numWords==0){
			return "";
		}
		// if the generator has been trained
		else{
			int numAdded = 1;
			starter = wordList.get(0).getWord();
			String currWord = starter;
			String output = "";
			output += currWord;
			ArrayList<String> words = new ArrayList<String>();
			for (ListNode n: wordList){
				words.add(n.getWord());
			}
			while(numAdded<numWords){
				ListNode curr;
				curr = wordList.get(words.indexOf(currWord));
				String w = curr.getRandomNextWord(rnGenerator);
				output = output + " " + w;
				currWord = w;
				numAdded++;
			}
			return output;
		}
	}
	
	
	// Can be helpful for debugging
	@Override
	public String toString()
	{
		String toReturn = "";
		for (ListNode n : wordList)
		{
			toReturn += n.toString();
		}
		return toReturn;
	}
	
	/** Retrain the generator from scratch on the source text */
	@Override
	public void retrain(String sourceText)
	{
		// TODO: Implement this method.
		if (sourceText.equals("")){
			System.out.println("");
		}
		else{
			resetVariables();
			train(sourceText);
			}
	}
	
	// TODO: Add any private helper methods you need here.
	private void resetVariables(){
		wordList = new LinkedList<ListNode>();
		starter = "";
	}
	/**
	 * This is a minimal set of tests.  Note that it can be difficult
	 * to test methods/classes with randomized behavior.   
	 * @param args
	 */
	public static void main(String[] args)
	{
		// feed the generator a fixed random value for repeatable behavior
		MarkovTextGeneratorLoL x = new MarkovTextGeneratorLoL(new Random(2));
		String aaa = "hi there hi Leo ";
		x.train(aaa);
		System.out.println(x);
		String y = x.generateText(20);
		System.out.println(y);
		x.resetVariables();
		System.out.println(x.wordList);
		x.retrain("the baby the brother are baby");
		y = x.generateText(20);
		System.out.println(y);
		
		MarkovTextGeneratorLoL gen = new MarkovTextGeneratorLoL(new Random(42));
		String textString = "Hello.  Hello there.  This is a test.  Hello there.  Hello Bob.  Test again.";
		System.out.println(textString);
		gen.train(textString);
		System.out.println(gen);
		System.out.println(gen.generateText(20));
		String textString2 = "You say yes, I say no, "+
				"You say stop, and I say go, go, go, "+
				"Oh no. You say goodbye and I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello. "+
				"I say high, you say low, "+
				"You say why, and I say I don't know. "+
				"Oh no. "+
				"You say goodbye and I say hello, hello, hello. "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello. "+
				"Why, why, why, why, why, why, "+
				"Do you say goodbye. "+
				"Oh no. "+
				"You say goodbye and I say hello, hello, hello. "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello. "+
				"You say yes, I say no, "+
				"You say stop and I say go, go, go. "+
				"Oh, oh no. "+
				"You say goodbye and I say hello, hello, hello. "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello, hello, hello,";
		System.out.println(textString2);
		gen.retrain(textString2);
		System.out.println(gen);
		System.out.println(gen.generateText(20));
	}

}

/** Links a word to the next words in the list 
 * You should use this class in your implementation. */
class ListNode
{
    // The word that is linking to the next words
	private String word;
	
	// The next words that could follow it
	private List<String> nextWords;
	
	ListNode(String word)
	{
		this.word = word;
		nextWords = new LinkedList<String>();
	}
	
	public String getWord()
	{
		return word;
	}

	public void addNextWord(String nextWord)
	{
		nextWords.add(nextWord);
	}
	
	public String getRandomNextWord(Random generator)
	{
		// TODO: Implement this method
	    // The random number generator should be passed from 
	    // the MarkovTextGeneratorLoL class
	    int rnd = generator.nextInt(nextWords.size());
	    return nextWords.get(rnd);
	}

	public String toString()
	{
		String toReturn = word + ": ";
		for (String s : nextWords) {
			toReturn += s + "->";
		}
		toReturn += "\n";
		return toReturn;
	}
	
}


