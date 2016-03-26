package interviewguide.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestWordByPeriodicTableElements {

	static List<String> symbolList = new ArrayList<String>();
	
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
	
	public static void main(String[] args) {
		String[] symbolArray = {"a","ab","bc","d"};
		symbolList = Arrays.asList(symbolArray);
		String word = "abcd";
		LongestWordByPeriodicTableElements longestWord = new LongestWordByPeriodicTableElements();
		System.out.println(longestWord.checkSymbol(word, 0));		
	}

}
