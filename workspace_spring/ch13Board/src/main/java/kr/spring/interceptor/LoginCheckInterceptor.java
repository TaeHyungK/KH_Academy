package kr.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginCheckInterceptor extends HandlerInterceptorAdapter{

	private Logger log = Logger.getLogger(this.getClass());
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		if(log.isDebugEnabled()) {
			log.debug("<<LoginCheck>> : LoginCheckInterceptor 진입");
		}
		
		//로그인 여부 검사
		HttpSession session = request.getSession();
		if(session.getAttribute("user_id") == null) {
			if(log.isDebugEnabled()) {
				log.debug("<<LoginCheck>> : 로그인 되지 않음");
			}
			
			response.sendRedirect(request.getContextPath()+"/member/login.do");	
			return false;
		}
		
		if(log.isDebugEnabled()) {
			log.debug("<<LoginCheck>> : 로그인 됨");
		}
		
		return true; //true: 원래 동작되던 메소드를 마저 실행. false: 원래 동작되던 메소드 동작이 진행되지 않음
	}
	
	

}
