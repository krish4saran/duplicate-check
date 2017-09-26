package com.example.demo.main;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**This class method provides services to check for duplicates
 * @author saranjithkrishnan
 *
 */
@Component
public class DuplicateCheckServiceImpl implements DuplicateCheckService{

	private Set<String> words = ConcurrentHashMap.newKeySet();

	
	/**Checks if the value passed in is a duplicate
	 * @param checkValue
	 * @return checkValuetrue if string was passed before else false
	 * @throws UnsupportedOperationException
	 */
	@Override
	public boolean isDuplicate(String checkValue) throws UnsupportedOperationException{
		if(StringUtils.isEmpty(checkValue)) {
			throw new UnsupportedOperationException("Please provide valid values");
		}
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
