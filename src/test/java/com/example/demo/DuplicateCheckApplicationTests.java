package com.example.demo;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.main.DuplicateCheckService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DuplicateCheckApplicationTests {
	
	@Rule
    public ExpectedException thrown= ExpectedException.none();

	
	@Autowired
	private DuplicateCheckService duplicateCheckService;
	
	@Before
	public void setUp(){
		duplicateCheckService.getWords().clear();
	}
	
	@Test
	public void testDuplicateCheckForNewWords(){
		assertFalse(duplicateCheckService.isDuplicate("Hello"));
	}
	
	@Test
	public void testDuplicateCheckForExistingWords(){
		duplicateCheckService.isDuplicate("Hello");
		assertTrue(duplicateCheckService.isDuplicate("Hello"));
	}
	
	@Test
	public void testDuplicateCheckForNull(){
		thrown.expect(UnsupportedOperationException.class);
		thrown.expectMessage("Please provide valid values");
		duplicateCheckService.isDuplicate(null);
		
	}
	
	@Test
	public void testDuplicateCheckForBlank(){
		
		thrown.expect(UnsupportedOperationException.class);
		thrown.expectMessage("Please provide valid values");
		duplicateCheckService.isDuplicate("");
	}
	
	@Test
	public void testDuplicateCheckForMultipleWords(){
		
		assertFalse(duplicateCheckService.isDuplicate("Hello"));
		assertFalse(duplicateCheckService.isDuplicate("My"));
		assertFalse(duplicateCheckService.isDuplicate("name"));
		assertFalse(duplicateCheckService.isDuplicate("is"));
		assertFalse(duplicateCheckService.isDuplicate("Saranjith Krishnan"));
		assertFalse(duplicateCheckService.isDuplicate("."));
		assertTrue(duplicateCheckService.isDuplicate("Hello"));
		
	}
}
