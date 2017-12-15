package kr.qboard.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import kr.controller.Action;
import kr.qboard.dao.QboardDao;
import kr.qboard.domain.QboardDto;
import kr.util.StringUtil;

public class DetailAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//글번호 반환
		int q_num = Integer.parseInt(request.getParameter("q_num"));
		//QboardDao 객체 생성
		QboardDao dao = QboardDao.getInstance();
		
		//getBoard메서드 호출
		//글번호와 매칭되는 레코드(데이터) 반환
		QboardDto qboard = dao.getBoard(q_num);
		
		//HTML를 불허하면서 줄바꿈 처리
		qboard.setQ_title(StringUtil.useNoHtml(qboard.getQ_title()));
		qboard.setQ_content(StringUtil.useBrNoHtml(qboard.getQ_content()));

		//request에 board 속성명으로 자바빈 생성
		request.setAttribute("qboard", qboard);
		
		return "/views/qboard/detail.jsp";
	}

}
