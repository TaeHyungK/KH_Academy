package kr.spring.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.spring.finalp.domain.InforCommand;
import kr.spring.finalp.service.InforService;
  
public class InforWriterCheckInterceptor extends
                       HandlerInterceptorAdapter{
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	InforService inforService;
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			                 HttpServletResponse response,
			                 Object handler)throws Exception{
		
		if(log.isDebugEnabled()){
			log.debug("====로그인아이디와 작성자아이디 일치 여부 체크====");
		}
		
		int ib_num = Integer.parseInt(request.getParameter("ib_num"));
		InforCommand infor = inforService.selectNum(ib_num);
		
		//로그인아이디와 작성자아이디 일치 여부 체크
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("user_id");
		
		if(log.isDebugEnabled()){
			log.debug("<<user_id>> : " + user_id);
			log.debug("<<writer_id>> : " + infor.getM_id());
		}
		
		if(user_id==null || !user_id.equals(infor.getM_id())){
			if(log.isDebugEnabled()){
				log.debug("<<로그인 아이디와 작성자 아이디 불일치>>");
			}
			response.sendRedirect(
					request.getContextPath()+"/board/list.do");
			return false;
		}
		log.debug("<<로그인 아이디와 작성자 아이디 일치>>");
		return true;
	}
}








