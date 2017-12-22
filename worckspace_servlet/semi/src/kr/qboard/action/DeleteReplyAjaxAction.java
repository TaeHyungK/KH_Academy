package kr.qboard.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.ObjectMapper;

import kr.controller.Action;
import kr.qboard.dao.QboardDao;
import kr.qboard.domain.QboardReply;


public class DeleteReplyAjaxAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
         Map<String,String> map = new HashMap<String,String>();
        
        HttpSession session = request.getSession();
        String user_id = (String)session.getAttribute("user_id");
        
       
        //댓글 번호
        int re_qnum = Integer.parseInt(request.getParameter("re_qnum"));
        System.out.println(re_qnum);
        
        if(user_id == null) {
        	map.put("result","logout");
        }else if(user_id != null && user_id.equals("admin")) {
        	//로그인한 id와 작성자 id가 같음 삭제 허용
        	QboardDao dao = QboardDao.getInstance();
        	dao.deleteReplyBoard(re_qnum);
        	
        	map.put("result", "success");
        }else {
        	//로그인한 id와 작성자 id가 다름
        	map.put("result", "wrongAccess");
        }
        //JSON 데이터로 변환 
        ObjectMapper mapper = new ObjectMapper();
        String jsonData = mapper.writeValueAsString(map);
        
        request.setAttribute("jsonData", jsonData);
        
        
		return "/views/qboard/ajaxView.jsp";
	}

}
