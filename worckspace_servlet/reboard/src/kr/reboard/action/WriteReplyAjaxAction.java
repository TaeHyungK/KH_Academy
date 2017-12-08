package kr.reboard.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.ObjectMapper;

import kr.controller.Action;
import kr.reboard.dao.BoardDao;
import kr.reboard.domain.BoardReply;

public class WriteReplyAjaxAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//HashMap 생성
		Map<String,String> map = new HashMap<String,String>();
		
		//로그인 여부 체크
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("user_id");
		
		if(user_id == null) {//로그인 안 됨
			map.put("result", "logout");
		}else {// 로그인 됨
			//전송된 데이터에 대한 인코딩 처리
			request.setCharacterEncoding("utf-8");
			
			//자바빈 생성
			BoardReply reply = new BoardReply();
			reply.setRe_content(
					request.getParameter("re_content"));
			reply.setRe_ip(request.getRemoteAddr());
			//부모글번호
			reply.setNum(Integer.parseInt(
					      request.getParameter("num")));
			//작성자
			reply.setId(user_id);
			
			//BoardDao 호출
			BoardDao dao = BoardDao.getInstance();
			dao.replyInsertBoard(reply);
			
			//댓글 등록이 성공하면 전송할 데이터 셋팅
			map.put("result", "success");
		}
		
		//JSON 데이터 생성
		ObjectMapper mapper = new ObjectMapper();
		String jsonData = mapper.writeValueAsString(map);
		
		request.setAttribute("jsonData", jsonData);
		
		return "/views/common/ajaxView.jsp";
	}

}







