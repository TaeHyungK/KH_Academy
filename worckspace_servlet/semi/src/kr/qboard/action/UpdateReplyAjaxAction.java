package kr.qboard.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.controller.Action;
import kr.qboard.dao.QboardDao;
import kr.qboard.domain.QboardReply;

public class UpdateReplyAjaxAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
		Map<String,String> map = new HashMap<String,String>();
        
		HttpSession session = request.getSession();
		//로그인한 ID
		String user_id = (String)session.getAttribute("user_id");

		System.out.println(user_id);
        int re_qnum = Integer.parseInt(request.getParameter("re_qnum"));
        
        if(user_id==null) {
        	map.put("result", "logout");
        }else if(user_id!=null && user_id.equals("admin")) {
        	
        	QboardDao dao = QboardDao.getInstance();
        	QboardReply qreply = new QboardReply();
        	qreply = dao.getQboardReply(re_qnum);
        	//댓글 업데이트        	
        	qreply.setQ_num(Integer.parseInt(request.getParameter("re_num")));
        	qreply.setRe_content(request.getParameter("re_content"));
        	
        	
            dao.updateReplyBoard(qreply);
            
            map.put("result", "success");
            
        }else {
        	map.put("result","wrongAccess");
        }
        
		return "/views/qboard/ajaxView.jsp";
	}

}
