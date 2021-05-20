package com.rough;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class SampleLogger {
	
	public static void main(String args[]) {
	
	Logger log=LogManager.getLogger(SampleLogger.class);
	
	log.info("info level");
	log.error("error level");
	log.debug("debug level");
	log.trace("trace level");
	log.warn("warnlevel");
	log.fatal("fatal level");

}
}
