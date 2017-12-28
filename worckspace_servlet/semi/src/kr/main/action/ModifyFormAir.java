package kr.main.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.air.dao.AirDao;
import kr.air.domain.AirDto;
import kr.controller.Action;

public class ModifyFormAir implements Action{

   @Override
   public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
      
      req.setCharacterEncoding("utf-8");
      int snum = Integer.parseInt(req.getParameter("snum"));
      AirDao dao = AirDao.getInstance();
      AirDto ad = dao.selectAir(snum);
      List<AirDto> list = dao.AirplaneList();
      req.setAttribute("ad", ad);
      req.setAttribute("list", list);
      return "/views/admin/adminModifyForm.jsp";
   }
}