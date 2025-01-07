package com.mehmetberkan.logspherepro.interceptor;

import com.mehmetberkan.logspherepro.util.ServerIpUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class RequestInfoInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String ipAddress = request.getHeader("X-Forwarded-For");
        if (ipAddress == null) {
            ipAddress = request.getRemoteAddr();
        }

        String os = System.getProperty("os.name");
        String javaVersion = System.getProperty("java.version");

        MDC.put("OS", os);
        MDC.put("javaVersion", javaVersion);
        MDC.put("clientIp", ipAddress);
        MDC.put("serverIp", ServerIpUtil.getServerIp());

        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        MDC.remove("clientIp");
        MDC.remove("OS");
        MDC.remove("javaVersion");
        MDC.remove("ServerIp");
    }
}
