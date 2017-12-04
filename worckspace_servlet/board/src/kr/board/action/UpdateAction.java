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
		
		//�α��� ���� üũ
		HttpSession session = req.getSession();
		String user_id = (String) session.getAttribute("user_id");
		if(user_id == null) return "redirect:/member/loginForm.do";
		
		//FileUtil.createFile�� request �Ѱܼ� ���۵� �����͸� ó��
		MultipartRequest multi = FileUtil.createFile(req);
		//�۹�ȣ(�⺻Ű) ����
		int num = Integer.parseInt(multi.getParameter("num"));
		//���۵� ���ϸ� ���� / ���۵� ������ ������ null ��ȯ
		String filename = multi.getFilesystemName("filename");
		
		//BoardDao ȣ��
		BoardDao dao = BoardDao.getInstance();
		//���� �� ������ -> ���� ������ ���ϸ��� �˾Ƴ��� ������
		BoardDto dbBoard = dao.getBoard(num);
	
		//�α����� ���̵�� �� �ۼ��� ���̵� �ٸ� ���
		if(user_id != null && !user_id.equals(dbBoard.getId())) {
			//���۵� ������ ���� ��� ����
			if(filename!=null) {
				FileUtil.removeFile(filename);
			}
			
			req.setAttribute("accessMsg", "Ÿ���� ���� ������ �� �����ϴ�.");
			return "/views/common/notice.jsp";
		}
		
		//�ڹٺ� ����
		BoardDto board = new BoardDto();
		//���۵� �����͸� �ڹٺ� ����
		board.setNum(num);
		board.setTitle(multi.getParameter("title"));
		board.setContent(multi.getParameter("content"));
		board.setIp(req.getRemoteAddr());
		
		if(filename!=null) { //�� �̹����� ��ü
			board.setFilename(filename);
		}else { //���۵� �̹����� ���� ���
			board.setFilename(dbBoard.getFilename());
		}
		
		//updateBoard�� �ڹٺ� ����
		dao.updateBoard(board);
		
		//�� �̹����� ��ü�� �� ���� �̹��� ���� -> ���ʿ��� ������ �޸𸮿��� ����!
		if(filename!=null) {
			FileUtil.removeFile(dbBoard.getFilename());
		}
		
		return "redirect:/board/list.do";
	}

}
