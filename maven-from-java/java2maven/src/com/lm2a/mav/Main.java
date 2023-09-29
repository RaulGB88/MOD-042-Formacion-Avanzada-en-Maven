package com.lm2a.mav;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class Main {
	
	static Logger log = Logger.getLogger(Main.class.getName());

	public static void main(String[] args) {
		
		BasicConfigurator.configure();
		
		log.debug("ESto es un logger de debugging");
		log.info("ESto es un logger de INFO");

	}

}
