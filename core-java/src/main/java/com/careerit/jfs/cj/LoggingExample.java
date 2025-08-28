package com.careerit.jfs.cj;

import java.util.logging.Logger;

public class LoggingExample {

    private static final Logger log = Logger.getLogger(LoggingExample.class.getName());
    public static void main(String[] args) {

        log.fine("This is fine message");
        log.info("This is info message");
        log.warning("This is warning message");
        log.severe("This is severe message");


    }
}
