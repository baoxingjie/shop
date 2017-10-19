package com.testgo.springboot.shop.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

/**
 * Created by tianqiao on 17/2/13.
 */
public class ExceptionUtil {
    
    public static String getStackTrace(Exception e)
    {
        Writer w = new StringWriter();
        e.printStackTrace(new PrintWriter(w));
        return w.toString();
    }
}
