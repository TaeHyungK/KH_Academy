package kr.reboard.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.controller.Action;
import kr.reboard.dao.BoardDao;
import kr.reboard.domain.BoardDto;

public class UpdateAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//로그인 여부 체크
		HttpSession session = request.getSession();
		String user_id = 
				(String)session.getAttribute("user_id");
		if(user_id == null) {
			return "redirect:/member/loginForm.do";
		}
		
		//전송된 데이터에 대한 인코딩 처리
		request.setCharacterEncoding("utf-8");
		//전송된 글번호 반환
		int num = 
		Integer.parseInt(request.getParameter("num"));
		
		//BoardDao 호출
		BoardDao dao = BoardDao.getInstance();
		//수정전 데이터를 반환 받음
		BoardDto dbBoard = dao.getReboard(num);
		
		//로그인한 아이디와 글 작성자 아이디 체크
		if(user_id!=null && 
				!user_id.equals(dbBoard.getId())) {
			request.setAttribute("accessMsg", 
					"타인의 글은 수정할 수 없습니다.");
			return "/views/common/notice.jsp";
		}
		//자바빈 생성
		BoardDto board = new BoardDto();
		//자바빈에 전송된 데이터를 저장
		board.setNum(num);
		board.setTitle(request.getParameter("title"));
		board.setContent(request.getParameter("content"));
		board.setIp(request.getRemoteAddr());
		
		//updateBoard 에 자바빈 전달
		dao.updateReboard(board);
		
		return "redirect:/board/list.do";
	}

}









