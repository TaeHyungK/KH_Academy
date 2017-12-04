package kr.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.board.dao.BoardDao;
import kr.board.domain.BoardDto;
import kr.controller.Action;
import kr.util.FileUtil;

public class DeleteAction implements Action{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		//�α��� ���� üũ
		HttpSession session = req.getSession();
		String user_id = (String)session.getAttribute("user_id");
		if(user_id == null) return "redirect:/member/loginForm.do";
		//���۵� ��ȣ�� ��ȯ
		int num = Integer.parseInt(req.getParameter("num"));
		//BoardDao ȣ��
		BoardDao dao = BoardDao.getInstance();
		//getBoard�� num�� �����ؼ� �ڹٺ� ��ȯ
		BoardDto board = dao.getBoard(num);
		//�α����� ���̵�� �� �ۼ��� ���̵� �ٸ� ���
		if(user_id!=null && !user_id.equals(board.getId())) {
			req.setAttribute("accessMsg", "Ÿ���� ���� ������ �� �����ϴ�.");
			return "/views/common/notice.jsp";
		}
		//�ۻ���
		dao.deleteBoard(num);
		//���� ����		
		FileUtil.removeFile(board.getFilename());
		
		return "redirect:/board/list.do";
	}

}
