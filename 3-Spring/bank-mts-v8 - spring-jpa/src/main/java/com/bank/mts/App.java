package com.bank.mts;


import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bank.mts.config.Bank_mts;
import com.bank.mts.service.TxrService;

public class App {

	public static void main(String[] args) {

		// Init phase
		// -----------------------------------------
		ConfigurableApplicationContext context = null; 
		context = new AnnotationConfigApplicationContext(Bank_mts.class);
		// -----------------------------------------

		// use phase
		// -----------------------------------------
		try {
			TxrService txrService = context.getBean("txrService", TxrService.class);
			txrService.txr(1000.00, "2", "1");
			System.out.println("Txr-success..");
		} catch (Exception e) {
			System.out.println("Txr-Failed..");
		}
		// -----------------------------------------

		// destroy phase
		// -----------------------------------------
		context.close();
		// -----------------------------------------
		

	}

}
