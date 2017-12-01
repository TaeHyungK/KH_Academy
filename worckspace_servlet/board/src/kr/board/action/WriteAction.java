package kr.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;

import kr.board.dao.BoardDao;
import kr.board.domain.BoardDto;
import kr.controller.Action;
import kr.util.FileUtil;

public class WriteAction implements Action{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		//로그인 체크 여부
		HttpSession session = req.getSession();
		String user_id = (String) session.getAttribute("user_id");
		if(user_id==null) {
			return "redirect:/member/loginForm.do";
		}
		
		//전송된 데이터에 파일이 포함되어 있으면
		MultipartRequest multi = FileUtil.createFile(req);
		BoardDto board = new BoardDto();
		board.setTitle(multi.getParameter("title"));
		board.setContent(multi.getParameter("content"));
		board.setIp(req.getRemoteAddr());
		board.setFilename(multi.getFilesystemName("filename"));
		board.setId(user_id);
		
		BoardDao dao = BoardDao.getInstance();
		dao.insertBoard(board);
		
		return "/views/board/write.jsp";
	}

}
