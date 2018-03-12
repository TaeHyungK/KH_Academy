package kr.spring.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.spring.finalp.domain.StudyCommand;
import kr.spring.finalp.service.StudyService;

public class StudyWriterCheckInterceptor extends HandlerInterceptorAdapter{
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	StudyService studyService;
	
	@Override
	public boolean preHandle(HttpServletRequest request,
							 		HttpServletResponse response,
							 		Object handler)throws Exception{
		if(log.isDebugEnabled()) {
			log.debug("====�α��ξ��̵�� �ۼ��ھ��̵� ��ġ ���� üũ====");
		}
		
		int sb_num = Integer.parseInt(request.getParameter("sb_num"));
		StudyCommand study = studyService.selectNum(sb_num);
		
		//�α��ξ��̵�� �ۼ��ھ��̵� ��ġ ���� üũ
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("user_id");
		
		if(log.isDebugEnabled()) {
			log.debug("<<user_id>> : " + user_id);
			log.debug("<<writer_id>> : " + study.getM_id());
		}
		
		if(user_id == null || !user_id.equals(study.getM_id())) {
			if(log.isDebugEnabled()) {
				log.debug("<<�α��� ���̵�� �ۼ��� ���̵� ����ġ>>");
			}
			response.sendRedirect(request.getContextPath()+"/study/sblist.do");
			return false;
		}
		log.debug("<<�α��� ���̵�� �ۼ��� ���̵� ��ġ>>");
		return true;
	}
}
