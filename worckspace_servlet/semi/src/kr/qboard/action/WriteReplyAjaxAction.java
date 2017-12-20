package kr.qboard.action;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.ObjectMapper;

import kr.controller.Action;
import kr.qboard.dao.QboardDao;
import kr.qboard.domain.QboardReply;

public class WriteReplyAjaxAction implements Action{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//Hashmap 생성
		 HashMap<String,String> map = new HashMap<String,String>();
        //로그인 여부 체크인
		// HttpSession session = request.getSession();
		// String user_id = (String)session.getAttribute("user_id");
		// if(user_id == "admin") {//로그인 안됨
		//	 map.put("result", "logout");
		// }else {
			 //관리자 로그인
			 //전송된 데이터에 대한 인코딩 처리
			 request.setCharacterEncoding("utf-8");
			 //자바빈 생성
			 QboardReply qreply = new QboardReply();
			 //부모 글번호
			 qreply.setRe_qnum(Integer.parseInt(request.getParameter("re_qnum")));
			 qreply.setQ_id(request.getParameter("id"));
			 qreply.setRe_content(request.getParameter("re_content"));
			 //QboardDao 호출
			 QboardDao dao = QboardDao.getInstance();
			 dao.replyInsertBoard(qreply);
			 
			//댓글 등록이 성공하면 전송할 데이터 셋팅
			 map.put("result","success");
			 
		// }
		 
		 //JSON 데이터 생성
		 ObjectMapper mapper = new ObjectMapper();
		 String jsonData = mapper.writeValueAsString(map);
		 
		 request.setAttribute("jsonData", jsonData);
		
		return "/views/qboard/ajaxView.jsp";
	}

}
