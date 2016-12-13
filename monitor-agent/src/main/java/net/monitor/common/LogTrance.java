package net.monitor.common;

import org.apache.commons.logging.LogFactory;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

public class LogTrance {

    private static org.apache.commons.logging.Log log = LogFactory.getLog("");

    public static void debug(Object param) {
        log.debug(param);
    }

    public static void info(Object param) {
        log.info(param);
    }

    public static void warn(Object param) {
        log.warn(param);
    }

    public static void error(Object param) {
        log.error(param);
    }

    public static void fatal(Object param) {
        log.fatal(param);
    }

    public static void out(Object param) {
        log.info(param);
    }

    public static String getTrace(Throwable t) {
        StringWriter stringWriter = null;
        StringBuffer buffer;
        try {
            stringWriter = new StringWriter();
            t.printStackTrace(new PrintWriter(stringWriter));
            buffer = stringWriter.getBuffer();
        } finally {
            try {
                if (stringWriter != null)
                    stringWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return buffer.toString();
    }
}