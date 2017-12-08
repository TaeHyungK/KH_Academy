package kr.reboard.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.ObjectMapper;

import kr.controller.Action;
import kr.reboard.dao.BoardDao;

public class DeleteReplyAjaxAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Map<String,String> map = 
				new HashMap<String,String>();
		
		//�α��� ���� üũ
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("user_id");
		
		//��� ��ȣ
		int re_num = Integer.parseInt(
				     request.getParameter("re_num"));
		//�ۼ��� ���̵�
		String writer_id = request.getParameter("id");
		
		if(user_id == null) {
			map.put("result", "logout");
		}else if(user_id != null 
				&& user_id.equals(writer_id)) {
			//�α����� id�� �ۼ��� id�� ����,���� ���
			BoardDao dao = BoardDao.getInstance();
			dao.deleteReplyBoard(re_num);
			
			map.put("result", "success");
		}else {
			//�α����� id�� �ۼ��� id�� �ٸ�,���� ����
			map.put("result", "wrongAccess");
		}
		
		//JSON �����ͷ� ��ȯ
		ObjectMapper mapper = new ObjectMapper();
		String jsonData = mapper.writeValueAsString(map);
		
		request.setAttribute("jsonData", jsonData);
		
		return "/views/common/ajaxView.jsp";
	}

}






