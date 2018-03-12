package kr.spring.finalp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.finalp.domain.AcademyCommand;
import kr.spring.finalp.domain.LikedAcademyCommand;
import kr.spring.finalp.service.AcademyService;
import kr.spring.util.PagingUtil;
import kr.spring.util.StringUtil;

@Controller
public class AcademyController {

   private Logger log = Logger.getLogger(this.getClass());


   private int rowCount =10;
   private int pageCount = 10;


   @Resource
   private AcademyService academyService;


   //Ŀ�ǵ� ��ü �ʱ�ȭ
   @ModelAttribute("command")
   public AcademyCommand initCommand() {
      return new AcademyCommand();

   }
   //�п� �Ұ� ����(����Ʈ ����)
   @RequestMapping("/academy/academyMain.do")
   public ModelAndView academyMain(@RequestParam(value="pageNum",defaultValue="1")int currentPage,@RequestParam(value="keyfield",defaultValue="a_name")String keyfield,@RequestParam(value="keyword",defaultValue="")String keyword,HttpSession session) {
	   	
	   Integer m_num = (Integer) session.getAttribute("user_num");
	   if(m_num == null) m_num = 0;  
	   
      if(log.isDebugEnabled()) {
         log.debug("<<pageNum>> : " + currentPage);
         log.debug("<<keyfield>> : " + keyfield);
         log.debug("<<keyword>> : " + keyword);
      }

      Map<String, Object> map = new HashMap<String, Object>();
      map.put("keyfield", keyfield);
      map.put("keyword", keyword);

      //�� ���� ���� �Ǵ� �˻��� ���� ����
      int count = academyService.getRowCount(map);
      if(count>0) {

      }
      if(log.isDebugEnabled()) {
    	  log.debug("<<count>> : " + count);
    	  log.debug("<<m_num>> : " + m_num);
      }

      PagingUtil page = new PagingUtil(keyfield,keyword,currentPage,count,rowCount,pageCount,"academyMain.do");
      map.put("start", page.getStartCount());
      map.put("end",page.getEndCount());
      map.put("m_num", m_num);

      List<AcademyCommand> topList = null;
      List<AcademyCommand> myLikedList = null;
      
      
      if(count>0) {
         topList = academyService.topListAcademy(map);
         myLikedList = academyService.myLikedAcademy(map);
      }   
      
      System.out.println("\ntopList: " + topList + "\nmyLikedList: " + myLikedList);

      ModelAndView mav = new ModelAndView();
      mav.setViewName("academyMain");
      mav.addObject("count",count);
      mav.addObject("topList", topList);
      mav.addObject("myLikedList", myLikedList);
      mav.addObject("pagingHtml",page.getPagingHtml());

      System.out.println(page.getPagingHtml());

      return mav;

   }
   //�п� �Ұ� �� ����
   @RequestMapping("/academy/academyDetail.do")
   public ModelAndView academyDetail(@RequestParam("a_num") int a_num) {
      if(log.isDebugEnabled()) {
         log.debug("<<num>> : " + a_num);
      }

      AcademyCommand academy = academyService.selectAcademyDetail(a_num);
      academy.setA_name(StringUtil.useBrNoHtml(academy.getA_name()));
      academy.setA_content(StringUtil.useBrNoHtml(academy.getA_content()));

      return new ModelAndView("academyDetail", "academy", academy);
   }

   //�� �п� ���� �� ����
   @RequestMapping("/academy/academyInfo.do")
   public String academyInfo(HttpSession session,Model model) {
     
      String id = (String)session.getAttribute("user_id");
      
      AcademyCommand academy = academyService.selectAcademy(id);
      System.out.println(academy);
      model.addAttribute("academy",academy);
      
      return "academyInfo";
   }


   //�п� ��� ��
   @RequestMapping(value="/academy/insert.do",method=RequestMethod.GET)
   public String insertForm(HttpSession session,Model model) {
      String id = (String)session.getAttribute("user_id");

      System.out.println("ID"+(String)session.getAttribute("user_id"));
      AcademyCommand academy = academyService.selectAM(id);

      model.addAttribute("command",academy);
      System.out.println(academy);
      return "academyInsert";
   }

   //�п� ���
   @RequestMapping(value="/academy/insert.do",method=RequestMethod.POST)
   //   �ڿ����� �ڹٺ��� ���� �޽����� @Valid�� ������
   public String insertSubmit(@ModelAttribute("command") @Valid AcademyCommand academyCommand,BindingResult result) {
      if(log.isDebugEnabled()) {
         log.debug("<<academyCommand>> : " + academyCommand);
      } 
      
//      if(result.hasErrors()) {
//         return "academyInsert"; 
//      }
      
      //�п� ���
      academyService.insertAcademy(academyCommand);
      
      return "redirect:/main/main.do";
   }

   //�п� ���� ��
   @RequestMapping(value="/academy/modify.do",method=RequestMethod.GET)
   public String modifyForm(HttpSession session,Model model) {
      String id = (String)session.getAttribute("user_id");
      System.out.println("id"+id);
      AcademyCommand academy = academyService.selectAcademy(id);

      model.addAttribute("command",academy);
      System.out.println(academy);
      return "academyModify";
   }
   
   //�п� ����
   @RequestMapping(value="/academy/modify.do",method=RequestMethod.POST)
   //   �ڿ����� �ڹٺ��� ���� �޽����� @Valid�� ������
   public String modifySubmit(@ModelAttribute("command") @Valid AcademyCommand academyCommand,BindingResult result) {
      if(log.isDebugEnabled()) {
         log.debug("<<academyCommand>> : " + academyCommand);
      } 
      /*if(result.hasErrors()) {
            return insertForm(); 
         }
       */

      //�п� ����
      academyService.updateAcademy(academyCommand);
      return "redirect:/academy/academyInfo.do";
   }
   
   //���ƿ� ��ư Ajax
   @RequestMapping("/academy/likedAcademy.do")
   @ResponseBody
   public Map<String,Object> onLikedBtn(final @RequestParam("a_num") int a_num, @RequestParam("currentClass") String currentClass, HttpSession session, HttpServletRequest request){
      System.out.println("AcademyController in Ajax method !!");
      
      Map<String, Object> map = new HashMap<String, Object>();
      
      
      if(log.isDebugEnabled()) {
         log.debug("<<a_num>> : " + a_num);
         log.debug("<<currentClass>> : " + currentClass);
      }
      
      Integer m_num = (Integer)session.getAttribute("user_num");
      System.out.println("<<m_num>> : " + m_num);
      
      
      if(m_num == null) {
         //�α��� �ȵ�
         map.put("result", "logout");
      }else {
          System.out.println("outer start!");
          
    	  LikedAcademyCommand likedAcademy  = academyService.getLikedAcademy(a_num, m_num);
          System.out.println(likedAcademy);
          
         if(likedAcademy == null) {
        	System.out.println("if block!");
            
            academyService.updateLike(a_num,m_num);
            map.put("changeClass", "fas fa-thumbs-up");
            
            System.out.println("a_good >> "+academyService.getAcademy(a_num).getA_good());
            
         }else{
            System.out.println("else if block!");
            academyService.updateLikeMinus(a_num, m_num);
            map.put("changeClass", "far fa-thumbs-up");
            
         }
         
         System.out.println("outer block!");
         AcademyCommand academy = academyService.getAcademy(a_num);
         map.put("result", "success");
         map.put("likedCount", academy.getA_good());
         
      }
      
      return map;
   }
   
   

   
}