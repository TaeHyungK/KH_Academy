package kr.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;

import kr.board.dao.BoardDao;
import kr.board.domain.BoardDto;
import kr.controller.Action;
import kr.util.FileUtil;

public class UpdateAction implements Action{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		//로그인 여부 체크
		HttpSession session = req.getSession();
		String user_id = (String) session.getAttribute("user_id");
		if(user_id == null) return "redirect:/member/loginForm.do";
		
		//FileUtil.createFile에 request 넘겨서 전송된 데이터를 처리
		MultipartRequest multi = FileUtil.createFile(req);
		//글번호(기본키) 저장
		int num = Integer.parseInt(multi.getParameter("num"));
		//전송된 파일명 저장 / 전송된 파일이 없으면 null 반환
		String filename = multi.getFilesystemName("filename");
		
		//BoardDao 호출
		BoardDao dao = BoardDao.getInstance();
		//수정 전 데이터 -> 원래 파일의 파일명을 알아내기 위해함
		BoardDto dbBoard = dao.getBoard(num);
	
		//로그인한 아이디와 글 작성자 아이디가 다를 경우
		if(user_id != null && !user_id.equals(dbBoard.getId())) {
			//전송된 파일이 있을 경우 삭제
			if(filename!=null) {
				FileUtil.removeFile(filename);
			}
			
			req.setAttribute("accessMsg", "타인의 글은 수정할 수 없습니다.");
			return "/views/common/notice.jsp";
		}
		
		//자바빈 생성
		BoardDto board = new BoardDto();
		//전송된 데이터를 자바빈에 저장
		board.setNum(num);
		board.setTitle(multi.getParameter("title"));
		board.setContent(multi.getParameter("content"));
		board.setIp(req.getRemoteAddr());
		
		if(filename!=null) { //새 이미지로 교체
			board.setFilename(filename);
		}else { //전송된 이미지가 없을 경우
			board.setFilename(dbBoard.getFilename());
		}
		
		//updateBoard에 자바빈 전달
		dao.updateBoard(board);
		
		//새 이미지로 교체할 때 원래 이미지 제거 -> 불필요한 파일을 메모리에서 제거!
		if(filename!=null) {
			FileUtil.removeFile(dbBoard.getFilename());
		}
		
		return "redirect:/board/list.do";
	}

}
