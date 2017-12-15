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
		//���۵� �����Ϳ� ���� ���ڵ�
				req.setCharacterEncoding("utf-8");
				//���۵� ������ ��ȯ
				String id = req.getParameter("id");
				
				MemberDao dao = MemberDao.getInstance();
				MemberDto member = dao.checkId(id);
				
				HashMap<String,String> map = new HashMap<String,String>();
				if(member == null) {//���̵� ���ߺ�
					map.put("result", "OK");
				}else {//���̵� �ߺ�
					map.put("result", "idDuplicated");
				}
				
				/*
				 * JSON�������� ��ȯ�ϱ⸦ ���ϴ� ���ڿ���
				 * key�� value���·� HashMap�� �����ϰ�
				 * ObjectMapper�� �����ؼ�
				 * writeValueAsString �޼��忡 �����ؼ�
				 * �Ϲ� ���ڿ� �����͸� JSON������ ���ڿ� ������
				 * �� ��ȯ
				 */
				ObjectMapper mapper = new ObjectMapper();
				String jsonData = mapper.writeValueAsString(map);
				
				req.setAttribute("jsonData", jsonData);
				
				return "/views/common/ajaxView.jsp";
	}

}
