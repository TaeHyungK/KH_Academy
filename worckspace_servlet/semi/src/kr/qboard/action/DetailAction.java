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
		//�۹�ȣ ��ȯ
		int q_num = Integer.parseInt(request.getParameter("q_num"));
		//QboardDao ��ü ����
		QboardDao dao = QboardDao.getInstance();
		
		//getBoard�޼��� ȣ��
		//�۹�ȣ�� ��Ī�Ǵ� ���ڵ�(������) ��ȯ
		QboardDto qboard = dao.getBoard(q_num);
		
		//HTML�� �����ϸ鼭 �ٹٲ� ó��
		qboard.setQ_title(StringUtil.useNoHtml(qboard.getQ_title()));
		qboard.setQ_content(StringUtil.useBrNoHtml(qboard.getQ_content()));

		//request�� board �Ӽ������� �ڹٺ� ����
		request.setAttribute("qboard", qboard);
		
		return "/views/qboard/detail.jsp";
	}

}
