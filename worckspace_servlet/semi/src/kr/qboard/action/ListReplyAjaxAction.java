package kr.qboard.action;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import kr.controller.Action;
import kr.qboard.dao.QboardDao;
import kr.qboard.domain.QboardReply;
import kr.util.PagingUtil;

public class ListReplyAjaxAction implements Action{

   @Override
   public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
      Map<String,Object> map = new HashMap<String,Object>();
      //페이지 번호
      String pageNum = request.getParameter("pageNum");
          if(pageNum == null) {
         pageNum = "1";
         }
      
      //부모 글번호
      System.out.println("request : " + request.getParameter("q_num"));
      int q_num = Integer.parseInt(request.getParameter("q_num"));
      
      System.out.println("parsing: " + q_num);
      
      int rowCount = 10;
      int pageCount = 10;
      int currentPage = Integer.parseInt(pageNum);
      
      //QboardDao 호출
      QboardDao dao = QboardDao.getInstance();
      int count = dao.getReplyBoardCount(q_num);
      
      PagingUtil page = new PagingUtil(currentPage,count,rowCount,pageCount,null);
      List<QboardReply> list = null;
      if(count >0 ) {
         list = dao.getListreplyBoard(page.getStartCount(), page.getEndCount(), q_num);
      }else {
         list = Collections.emptyList();
      }
      
      map.put("count", count);
      map.put("rowCount", rowCount);
      map.put("list", list);
      
      //json데이터로 변환
      ObjectMapper mapper = new ObjectMapper();
      String jsonData = mapper.writeValueAsString(map);
      request.setAttribute("jsonData", jsonData);
      
      return "/views/qboard/ajaxView.jsp";
   }

}