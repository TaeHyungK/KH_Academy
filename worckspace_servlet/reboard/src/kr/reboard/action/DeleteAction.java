package kr.reboard.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.controller.Action;
import kr.reboard.dao.BoardDao;
import kr.reboard.domain.BoardDto;

public class DeleteAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//로그인 여부 체크
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("user_id");
		if(user_id==null) {
			return "redirect:/member/loginForm.do";
		}
		//전송된 글번호 반환
		int num = Integer.parseInt(request.getParameter("num"));
		//BoardDao 호출
		BoardDao dao = BoardDao.getInstance();
		//getBoard에 num 전달 자바빈 반환
		BoardDto board = dao.getReboard(num);
		//로그인한 아이디와 글 작성자 아이디 체크
		if(user_id!=null && 
				!user_id.equals(board.getId())) {
			request.setAttribute("accessMsg", 
					"타인의 글은 삭제할 수 없습니다.");
			return "/views/common/notice.jsp";
		}
		//글 삭제
		dao.deleteReboard(num);
		
		return "redirect:/board/list.do";
	}

}



