package kr.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.board.dao.BoardDao;
import kr.board.domain.BoardDto;
import kr.controller.Action;

public class UpdateFormAction implements Action{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		//로그인 여부 체크
		HttpSession session = req.getSession();
		String user_id = (String) session.getAttribute("user_id");
		if(user_id == null) return "redirect:/member/loginForm.do";
		
		//전송된 글번호 반환
		int num = Integer.parseInt(req.getParameter("num"));
		BoardDao dao = BoardDao.getInstance();
		BoardDto board = dao.getBoard(num);
		
		//로그인한 아이디가 작성자 아이디와 일치 여부 체크
		if(user_id!=null && !user_id.equals(board.getId())) {
			req.setAttribute("accessMsg", "타인의 글은 수정할 수 없습니다.");
			return "/views/common/notice.jsp";
		}
		
		req.setAttribute("board", board);
		
		return "/views/board/updateForm.jsp";
	}

}
