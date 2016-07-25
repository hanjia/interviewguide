package interviewguide.dp;

import java.util.Arrays;
import java.util.List;

public class LongestWordByPeriodicTableElements {

	static List<String> symbolList;
	
	public boolean checkSymbol(String word, int index){
		if(index >= word.length()) {
			return true;
		}
		boolean valid = symbolList.contains(word.substring(index, index + 1)) && checkSymbol(word, index + 1);
		if(index < word.length() - 1){
			valid = valid || (symbolList.contains(word.substring(index, index + 2)) && checkSymbol(word, index + 2));
		}
		return valid;
	}
	
	//Assume the dictionary is a sorted array of words based on word length
	public String findLongestWordInDict(String[] dict){
		String longestWord = "";
		for (String word: dict) {
			if ((word.length() > longestWord.length()) && checkSymbol(word, 0))
				longestWord = word;
		}
		return longestWord;
	}
	
	public static void main(String[] args) {
		String[] symbolArray = {"a","ab","bc","d"};
		LongestWordByPeriodicTableElements.symbolList = Arrays.asList(symbolArray);
		String[] words = {"aasbwebwesdbwew", "abwefscd", "abcadbc", "abc"};
		
		LongestWordByPeriodicTableElements longestWord = new LongestWordByPeriodicTableElements();
		System.out.println(longestWord.findLongestWordInDict(words));		
	}

}
