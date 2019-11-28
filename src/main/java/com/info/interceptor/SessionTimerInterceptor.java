package com.info.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SessionTimerInterceptor extends HandlerInterceptorAdapter {
	
	private static Logger log = Logger.getLogger(SessionTimerInterceptor.class);

    private static final long MAX_INACTIVE_SESSION_TIME = 5 * 10000;

    @Autowired
    private HttpSession session;

    /**
     * Executed before actual handler is executed
     **/
    @Override
    public boolean preHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler) throws Exception {
        log.info("Pre handle method - check handling start time");
        long startTime = System.currentTimeMillis();
        request.setAttribute("executionTime", startTime);
        if (isUserLogged()) {
            session = request.getSession();
            log.info("Time since last request in this session: {} ms"+ (System.currentTimeMillis() - request.getSession().getLastAccessedTime()));
            if (System.currentTimeMillis() - session.getLastAccessedTime() > MAX_INACTIVE_SESSION_TIME) {
                log.warn("Logging out, due to inactive session");
                SecurityContextHolder.clearContext();
                request.logout();
                response.sendRedirect("/index");
            }
        }
        return true;
    }

    /**
     * Executed before after handler is executed
     **/
    @Override
    public void postHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler, final ModelAndView model) throws Exception {
        log.info("Post handle method - check execution time of handling");
        long startTime = (Long) request.getAttribute("executionTime");
        log.info("Execution time for handling the request was: {} ms" +( System.currentTimeMillis() - startTime));
    }
    
    
    public static boolean isUserLogged() {
        try {
            return !SecurityContextHolder.getContext().getAuthentication().getName().equals("anonymousUser") ||
            		!SecurityContextHolder.getContext().getAuthentication().getName().equals("");
        } catch (Exception e) {
            return false;
        }
    }

}
