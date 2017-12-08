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

public class UpdateReplyAjaxAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Map<String,String> map = new HashMap<String,String>();
		
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("user_id");
		
		//작성자 아이디
		String writer_id = request.getParameter("id");
		
		if(user_id==null) {
			map.put("result", "logout");
		}else if(user_id!=null && user_id.equals(writer_id)) {
			//댓글 업데이트
			BoardReply board = new BoardReply();
			board.setRe_num(Integer.parseInt(request.getParameter("re_num")));
			board.setRe_content(request.getParameter("re_content"));
			board.setRe_ip(request.getRemoteAddr());
			
			BoardDao dao = BoardDao.getInstance();
			dao.updateReplyBoard(board);
			
			map.put("result", "success");			
		}else {
			map.put("result", "wrongAccess");
		}
		
		//JSON 데이터로 변환
		ObjectMapper mapper = new ObjectMapper();
		String jsonData = mapper.writeValueAsString(map);
		
		request.setAttribute("jsonData", jsonData);
		
		return "/views/common/ajaxView.jsp";
	}

}





