package com.mindtree.utility;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

import com.mindtree.reusable.ReusableMethod;


public class Log {

	public static void logMethod(Logger log) {
		PatternLayout layout = new PatternLayout();
		String logPath = PropertyFileReader.loadFile().getProperty("log");
		layout.setConversionPattern("%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1} - %m%n");
		try {
			FileAppender file = new FileAppender(layout,
					logPath + PropertyFileReader.loadFile().getProperty("className")
					+ "_" + ReusableMethod.setDateTime() + "log", true);
			log.addAppender(file);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("rawtypes")
	public static Logger logger(Class name) {
		Logger log = Logger.getLogger(name);
		return log;
	}
	public static void logInfo(Logger log, String message) {
		log.info(message);
	}
	public static void logDebug(Logger log, String message) {
		log.debug(message);
	}
	public static void logError(Logger log, String message) {
		log.error(message);
	}
	public static void logFatal(Logger log, String message) {
		log.fatal(message);
	}
	public static void logWarn(Logger log, String message) {
		log.warn(message);
	}
}
