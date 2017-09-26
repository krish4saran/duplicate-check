package com.example.demo.main;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

/**This class method provides services to check for duplicates
 * @author saranjithkrishnan
 *
 */
@Component
public class DuplicateCheckService {

	private Set<String> words = ConcurrentHashMap.newKeySet();

	
	/**Checks if the value passed in is a duplicate
	 * @param checkValue
	 * @return checkValuetrue if string was passed before else false
	 * @throws UnsupportedOperationException
	 */
	public boolean isDuplicate(String checkValue) throws UnsupportedOperationException{
		if(checkValue == null) 
			throw new UnsupportedOperationException("Please provide valid values");
		
		if(words.contains(checkValue)){
			return true;
		}else{
			words.add(checkValue);
			return false;
		}
		
	}


	public Set<String> getWords() {
		return words;
	}


	public void setWords(Set<String> words) {
		this.words = words;
	}
	
	
	
}
