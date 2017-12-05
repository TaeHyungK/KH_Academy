package kr.reboard.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.controller.Action;
import kr.reboard.dao.BoardDao;
import kr.reboard.domain.BoardDto;

public class WriteAction implements Action{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		//로그인 여부 체크
		HttpSession session = req.getSession();
		String user_id = (String) session.getAttribute("user_id");
		if(user_id == null) {
			return "redirect:/member/loginForm.do";
		}
		
		//전송된 데이터에 인코딩 처리
		req.setCharacterEncoding("UTF-8");
		//자바빈 생성
		BoardDto board = new BoardDto();
		//자바빈에 전송된 데이터 저장
		//title, content, ip, id
		board.setTitle(req.getParameter("title"));
		board.setContent(req.getParameter("content"));
		board.setIp(req.getRemoteAddr());
		board.setId(user_id);
		//BoardDao호출
		BoardDao dao = BoardDao.getInstance();
		//insertReboard()에 자바빈 전달
		dao.insertReboard(board);
		
		return "/views/reboard/write.jsp";
	}

}
