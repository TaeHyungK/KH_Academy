package kr.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

//�����ڵ��� ��� �޾Ƽ� ���� �� �߰��� ����è
public class LoginCheckInterceptor extends HandlerInterceptorAdapter{
	
	private Logger log = Logger.getLogger(this.getClass());
	
	//��Ʈ�ѷ��� ���۵ǰ� �� �Ŀ� �۵��Ǵ� �޼���
	/*@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
	}*/
	
	//��Ʈ�ѷ��� ���۵Ǳ� ���� �۵��Ǵ� �޼���
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if(log.isDebugEnabled()) {
			log.debug("<<LoginCheck>> : LoginCheckInterceptor ���� ");
		}
		//�α��� ���� �˻�
		HttpSession session = request.getSession();
		
		if(session.getAttribute("user_id")==null) {
			if(log.isDebugEnabled()) {
				log.debug("<<LoginCheck>> : �α��� ���� ���� ");
			}
			response.sendRedirect(request.getContextPath()+"/member/login.do");
			return false;
		}
		if(log.isDebugEnabled()) {
			log.debug("<<LoginCheck>> : �α��� �� ");
		}
		return true;//true ��ȯ�� ���� ���۵Ǿ�� �ϴ� �޼��尡 ���۵�
	}
}

























