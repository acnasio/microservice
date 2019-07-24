/*
 * 
 */
package com.acnas.loan.app.data.es.cqrs.service.test;

import java.util.List;
import java.util.Map.Entry;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

 

// TODO: Auto-generated Javadoc
/**
 * The Class LoanAppServiceIntTest.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class LoanAppServiceIntTest {

	/** The Constant LOGGER. */
	private final static Logger LOGGER = LoggerFactory.getLogger(LoanAppServiceIntTest.class);

	/** The rest template. */
	@Autowired
	private TestRestTemplate restTemplate;
	
	 
	
	/**
	 * Test.
	 */
	@Test
	public void test() {
		
	}
	
	 
	
}
