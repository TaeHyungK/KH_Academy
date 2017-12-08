package kr.reboard.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.ObjectMapper;

import kr.controller.Action;
import kr.reboard.dao.BoardDao;

public class DeleteReplyAjaxAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Map<String,String> map = 
				new HashMap<String,String>();
		
		//로그인 여부 체크
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("user_id");
		
		//댓글 번호
		int re_num = Integer.parseInt(
				     request.getParameter("re_num"));
		//작성자 아이디
		String writer_id = request.getParameter("id");
		
		if(user_id == null) {
			map.put("result", "logout");
		}else if(user_id != null 
				&& user_id.equals(writer_id)) {
			//로그인한 id와 작성자 id가 같음,삭제 허용
			BoardDao dao = BoardDao.getInstance();
			dao.deleteReplyBoard(re_num);
			
			map.put("result", "success");
		}else {
			//로그인한 id와 작성자 id가 다름,삭제 불허
			map.put("result", "wrongAccess");
		}
		
		//JSON 데이터로 변환
		ObjectMapper mapper = new ObjectMapper();
		String jsonData = mapper.writeValueAsString(map);
		
		request.setAttribute("jsonData", jsonData);
		
		return "/views/common/ajaxView.jsp";
	}

}






