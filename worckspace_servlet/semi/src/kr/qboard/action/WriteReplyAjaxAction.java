package kr.qboard.action;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.ObjectMapper;

import kr.controller.Action;
import kr.qboard.dao.QboardDao;
import kr.qboard.domain.QboardReply;

public class WriteReplyAjaxAction implements Action{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//Hashmap ����
		 HashMap<String,String> map = new HashMap<String,String>();
        //�α��� ���� üũ��
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("user_id");
		if(!user_id.equals("admin")) {//�α��� �ȵ�
		 map.put("result", "logout");
	     }else {
			 //������ �α���
			 //���۵� �����Ϳ� ���� ���ڵ� ó��
			 request.setCharacterEncoding("utf-8");
			 //�ڹٺ� ����
			 QboardReply qreply = new QboardReply();
			 
			 qreply.setQ_id(request.getParameter("q_id"));
			 qreply.setRe_content(request.getParameter("re_content"));
			 qreply.setQ_num(Integer.parseInt(request.getParameter("q_num")));
			 qreply.setQ_id(user_id);
			 //QboardDao ȣ��
			 QboardDao dao = QboardDao.getInstance();
			 dao.replyInsertBoard(qreply);
			 
			//��� ����� �����ϸ� ������ ������ ����
			 map.put("result","success");
			 
		 }
		 
		 //JSON ������ ����
		 ObjectMapper mapper = new ObjectMapper();
		 String jsonData = mapper.writeValueAsString(map);
		 
		 request.setAttribute("jsonData", jsonData);
		
		return "/views/qboard/ajaxView.jsp";
	}

}
