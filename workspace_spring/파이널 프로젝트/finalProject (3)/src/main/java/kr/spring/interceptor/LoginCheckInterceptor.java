package kr.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

//프리핸들을 상속 받아서 정의 해 중간에 낚아챔
public class LoginCheckInterceptor extends HandlerInterceptorAdapter{
	
	private Logger log = Logger.getLogger(this.getClass());
	
	//컨트롤러가 독작되고 난 후에 작동되는 메서드
	/*@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
	}*/
	
	//컨트롤러가 동작되기 전에 작동되는 메서드
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if(log.isDebugEnabled()) {
			log.debug("<<LoginCheck>> : LoginCheckInterceptor 진입 ");
		}
		//로그인 여부 검사
		HttpSession session = request.getSession();
		
		if(session.getAttribute("user_id")==null) {
			if(log.isDebugEnabled()) {
				log.debug("<<LoginCheck>> : 로그인 되지 않음 ");
			}
			response.sendRedirect(request.getContextPath()+"/member/login.do");
			return false;
		}
		if(log.isDebugEnabled()) {
			log.debug("<<LoginCheck>> : 로그인 됨 ");
		}
		return true;//true 반환시 원래 동작되어야 하는 메서드가 동작됨
	}
}

























