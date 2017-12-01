package kr.member.action;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import kr.controller.Action;
import kr.member.dao.MemberDao;
import kr.member.domain.MemberDto;

public class CheckIdAjaxAction implements Action{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		//���۵� �����Ϳ� ���� ���ڵ� ó��
		req.setCharacterEncoding("UTF-8");
		//���۵� ������ ��ȯ
		String id = req.getParameter("id");
		
		MemberDao dao = MemberDao.getInstance();
		MemberDto member = dao.getMember(id);
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		if(member == null) {//���̵� ���ߺ�
			map.put("result", "idNotFound");
		}else { //���̵� �ߺ�
			map.put("result", "idDuplicated");
		}
		/*
		 * JSON �������� ��ȯ�ϱ⸦ ���ϴ� ���ڿ��� key�� value���·� HashMap�� �����ϰ�
		 * ObjectMapper�� �����ؼ� writeValueAsString �޼ҵ忡 �����ؼ�
		 * �Ϲ� ���ڿ� �����͸� JSON������ ���ڿ� �����ͷ� ��ȯ
		 */
		ObjectMapper mapper = new ObjectMapper();
		String jsonData = mapper.writeValueAsString(map); //map ��ü�� �ִ� key:value�� json������ key:value�� ��ȯ������
		
		req.setAttribute("jsonData", jsonData);
		
		
		return "/views/common/ajaxView.jsp";
	}

}
