package kr.qboard.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.ObjectMapper;

import kr.controller.Action;
import kr.qboard.dao.QboardDao;
import kr.qboard.domain.QboardReply;


public class DeleteReplyAjaxAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
         Map<String,String> map = new HashMap<String,String>();
        
        HttpSession session = request.getSession();
        String user_id = (String)session.getAttribute("user_id");
        
       
        //��� ��ȣ
        int re_qnum = Integer.parseInt(request.getParameter("re_qnum"));
        System.out.println(re_qnum);
        
        if(user_id == null) {
        	map.put("result","logout");
        }else if(user_id != null && user_id.equals("admin")) {
        	//�α����� id�� �ۼ��� id�� ���� ���� ���
        	QboardDao dao = QboardDao.getInstance();
        	dao.deleteReplyBoard(re_qnum);
        	
        	map.put("result", "success");
        }else {
        	//�α����� id�� �ۼ��� id�� �ٸ�
        	map.put("result", "wrongAccess");
        }
        //JSON �����ͷ� ��ȯ 
        ObjectMapper mapper = new ObjectMapper();
        String jsonData = mapper.writeValueAsString(map);
        
        request.setAttribute("jsonData", jsonData);
        
        
		return "/views/qboard/ajaxView.jsp";
	}

}
