package com.mehmetberkan.logspherepro.util;

import com.mehmetberkan.logspherepro.controller.ProductController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class ServerIpUtil {

    private static final Logger logger = LoggerFactory.getLogger(ServerIpUtil.class);

    public static String getServerIp() {
        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            return inetAddress.getHostAddress();
        } catch (UnknownHostException e) {
            logger.error("Unable to get the server IP address: ", e);
            return "SERVER_IP_NOT_FOUND";
        }
    }
}
