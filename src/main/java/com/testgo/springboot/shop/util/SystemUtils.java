package com.testgo.springboot.shop.util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by tianqiao on 17/3/14.
 */
public class SystemUtils {
    
    private static String ip = null;
    
    public static String getIp() {
        if(ip==null){
            InetAddress address = null;
            try {
                address = InetAddress.getLocalHost();
                ip = address.getHostAddress();
            } catch (UnknownHostException e) {
                ip = "unknown";
            }
        }
        return ip;
    }
    
    public static String getTime() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E").format(new Date());
    }
}
