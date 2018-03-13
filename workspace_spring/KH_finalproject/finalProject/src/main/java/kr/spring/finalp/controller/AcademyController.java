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


   //커맨드 객체 초기화
   @ModelAttribute("command")
   public AcademyCommand initCommand() {
      return new AcademyCommand();

   }
   //학원 소개 메인(리스트 포함)
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

      //총 글의 갯수 또는 검색된 글의 갯수
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
   //학원 소개 상세 보기
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

   //내 학원 정보 상세 보기
   @RequestMapping("/academy/academyInfo.do")
   public String academyInfo(HttpSession session,Model model) {
     
      String id = (String)session.getAttribute("user_id");
      
      AcademyCommand academy = academyService.selectAcademy(id);
      System.out.println(academy);
      model.addAttribute("academy",academy);
      
      return "academyInfo";
   }


   //학원 등록 폼
   @RequestMapping(value="/academy/insert.do",method=RequestMethod.GET)
   public String insertForm(HttpSession session,Model model) {
      String id = (String)session.getAttribute("user_id");

      System.out.println("ID"+(String)session.getAttribute("user_id"));
      AcademyCommand academy = academyService.selectAM(id);

      model.addAttribute("command",academy);
      System.out.println(academy);
      return "academyInsert";
   }

   //학원 등록
   @RequestMapping(value="/academy/insert.do",method=RequestMethod.POST)
   //   뒤에오는 자바빈의 에러 메시지를 @Valid에 저장함
   public String insertSubmit(@ModelAttribute("command") @Valid AcademyCommand academyCommand,BindingResult result) {
      if(log.isDebugEnabled()) {
         log.debug("<<academyCommand>> : " + academyCommand);
      } 
      
//      if(result.hasErrors()) {
//         return "academyInsert"; 
//      }
      
      //학원 등록
      academyService.insertAcademy(academyCommand);
      
      return "redirect:/main/main.do";
   }

   //학원 수정 폼
   @RequestMapping(value="/academy/modify.do",method=RequestMethod.GET)
   public String modifyForm(HttpSession session,Model model) {
      String id = (String)session.getAttribute("user_id");
      System.out.println("id"+id);
      AcademyCommand academy = academyService.selectAcademy(id);

      model.addAttribute("command",academy);
      System.out.println(academy);
      return "academyModify";
   }
   
   //학원 수정
   @RequestMapping(value="/academy/modify.do",method=RequestMethod.POST)
   //   뒤에오는 자바빈의 에러 메시지를 @Valid에 저장함
   public String modifySubmit(@ModelAttribute("command") @Valid AcademyCommand academyCommand,BindingResult result) {
      if(log.isDebugEnabled()) {
         log.debug("<<academyCommand>> : " + academyCommand);
      } 
      /*if(result.hasErrors()) {
            return insertForm(); 
         }
       */

      //학원 수정
      academyService.updateAcademy(academyCommand);
      return "redirect:/academy/academyInfo.do";
   }
   
   //좋아요 버튼 Ajax
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
         //로그인 안됨
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