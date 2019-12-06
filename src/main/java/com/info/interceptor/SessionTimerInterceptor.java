package com.info.interceptor;

import java.util.HashSet;
import java.util.Set;

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

	private static final long MAX_INACTIVE_SESSION_TIME = 600 * 1000;
	private static final Set<String> paths = new HashSet<>();
	static {
		paths.add("");
		paths.add("index");
		paths.add("adminloginform");
		paths.add("userloginform");
		paths.add("suggestions");
		paths.add("logo");
		paths.add("userLogin");
		paths.add("signupForm");
		paths.add("forgotPassword");
		paths.add("signupEmployee");
		paths.add("resetPassword");
		paths.add("logout");
	}

	@Autowired
	private HttpSession session;

	/**
	 * Executed before actual handler is executed
	 **/
	@Override
	public boolean preHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler)
			throws Exception {
		log.info("Pre handle method - check handling start time");
//		String contextPath = request.get
		long startTime = System.currentTimeMillis();
		request.setAttribute("executionTime", startTime);
		if (isSessionValid(request)) {
			session = request.getSession();
			log.info("Time since last request in this session: {} ms"
					+ (System.currentTimeMillis() - request.getSession().getLastAccessedTime()));
			if (System.currentTimeMillis() - session.getLastAccessedTime() > MAX_INACTIVE_SESSION_TIME) {
				log.warn("Logging out, due to inactive session");
				SecurityContextHolder.clearContext();
				request.logout();
				response.sendRedirect("index");
			}
		} 
		else {
			String requestPath = "";
			if (request.getRequestURI().contains(";")) {
				log.warn("request.getRequestURI()::" + request.getRequestURI()
						.substring(request.getRequestURI().lastIndexOf('/') + 1, request.getRequestURI().indexOf(';')));
				requestPath = request.getRequestURI().substring(request.getRequestURI().lastIndexOf('/') + 1,
						request.getRequestURI().indexOf(';'));
			} else {
				log.warn("request.getRequestURI()::" + request.getRequestURI().replace("/Office-Communicator/", ""));
				requestPath = request.getRequestURI().replace("/Office-Communicator/", "");
			}
			if (!paths.contains(requestPath)) {
					log.warn("Logging out, due to invalid session!!!!!!!!");
					SecurityContextHolder.clearContext();
					request.logout();
					response.sendRedirect("index");
				}
			
		}
		return true;
	}

	/**
	 * Executed before after handler is executed
	 **/
	@Override
	public void postHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler,
			final ModelAndView model) throws Exception {
		log.info("Post handle method - check execution time of handling");
		long startTime = (Long) request.getAttribute("executionTime");
		log.info("Execution time for handling the request was: {} ms" + (System.currentTimeMillis() - startTime));
	}

	/*
	 * public static boolean isUserLogged() { try { return
	 * !SecurityContextHolder.getContext().getAuthentication().getName().equals(
	 * "anonymousUser") ||
	 * !SecurityContextHolder.getContext().getAuthentication().getName().equals(
	 * ""); } catch (Exception e) { return false; } }
	 */

	private boolean isSessionValid(HttpServletRequest request) {
		try {
			return (request.getSession() != null && request.getSession().getAttribute("user") != null);
		} catch (Exception e) {
			return false;
		}
	}

}
