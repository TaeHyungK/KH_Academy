package kr.qboard.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.controller.Action;
import kr.qboard.dao.QboardDao;
import kr.qboard.domain.QboardDto;


public class UpdateAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		/*//로그인 여부 확인
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("user_id");
		if(user_id ==null) {
				return "redirect:/member/loginForm.do";
		}*/
		request.setCharacterEncoding("utf-8");
		
		int q_num = Integer.parseInt(request.getParameter("q_num"));
		
		//QboardDao 호출
		QboardDao dao = QboardDao.getInstance();
		
		/*//로그인한 아이디와 작성자 아이디가 다를 경우
		if(user_id!=null && !user_id.equals(qoard.getQ_id())) {
			   request.setAttribute("accessMsg", "타인의 글은 수정할수 없습니다");
			return "/views/common/notice.jsp";
		}*/
		
		QboardDto qboard = new QboardDto();
		//전송된 데이터를 자바빈에 저장
		qboard.setQ_num(q_num);
		qboard.setQ_title(request.getParameter("q_title"));
		qboard.setQ_content(request.getParameter("q_content"));
		
		//updateBoard에 자바빈 전당
		dao.updateBoard(qboard);
		
		return "redirect:/qboard/qlist.do";
	}

}
