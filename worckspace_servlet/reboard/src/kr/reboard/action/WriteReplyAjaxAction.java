package kr.reboard.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.ObjectMapper;

import kr.controller.Action;
import kr.reboard.dao.BoardDao;
import kr.reboard.domain.BoardReply;

public class WriteReplyAjaxAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//HashMap ����
		Map<String,String> map = new HashMap<String,String>();
		
		//�α��� ���� üũ
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("user_id");
		
		if(user_id == null) {//�α��� �� ��
			map.put("result", "logout");
		}else {// �α��� ��
			//���۵� �����Ϳ� ���� ���ڵ� ó��
			request.setCharacterEncoding("utf-8");
			
			//�ڹٺ� ����
			BoardReply reply = new BoardReply();
			reply.setRe_content(
					request.getParameter("re_content"));
			reply.setRe_ip(request.getRemoteAddr());
			//�θ�۹�ȣ
			reply.setNum(Integer.parseInt(
					      request.getParameter("num")));
			//�ۼ���
			reply.setId(user_id);
			
			//BoardDao ȣ��
			BoardDao dao = BoardDao.getInstance();
			dao.replyInsertBoard(reply);
			
			//��� ����� �����ϸ� ������ ������ ����
			map.put("result", "success");
		}
		
		//JSON ������ ����
		ObjectMapper mapper = new ObjectMapper();
		String jsonData = mapper.writeValueAsString(map);
		
		request.setAttribute("jsonData", jsonData);
		
		return "/views/common/ajaxView.jsp";
	}

}







