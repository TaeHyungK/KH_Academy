package kr.spring.finalp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
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
import org.springframework.web.servlet.ModelAndView;

import kr.spring.board.domain.BoardCommand;
import kr.spring.finalp.domain.AcademyCommand;
import kr.spring.finalp.domain.TeacherCommand;
import kr.spring.finalp.service.TeacherService;
import kr.spring.util.PagingUtil;

@Controller
public class TeacherController {
	
	private Logger log = Logger.getLogger(this.getClass());
	

	private int rowCount =10;
	private int pageCount = 10;
	

	@Resource
	private TeacherService teacherService;
	
	//강사 목록 메인
		@RequestMapping("/teacher/teacherMain.do")
		public ModelAndView teacherMain(HttpSession session,Model model, TeacherCommand teacherCommand, 
				@RequestParam(value="pageNum",defaultValue="1")int currentPage,
				@RequestParam(value="keyfield",defaultValue="")String keyfield,
				@RequestParam(value="keyword",defaultValue="")String keyword){
			
			
			if(log.isDebugEnabled()) {
				log.debug("<<pageNum>> : " + currentPage);
				log.debug("<<keyfield>> : " + keyfield);
				log.debug("<<keyword>> : " + keyword);
			}

			//접속되어있는 아이디 구하기
			String id = (String)session.getAttribute("user_id");
			
			System.out.println("ID"+(String)session.getAttribute("user_id"));
			
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("m_id", id);
			map.put("keyfield", keyfield);
			map.put("keyword", keyword);
			
			//총글의 갯수 또는 검색됨 글의 갯수
			int count = teacherService.getRowCount(map);
			
			System.out.println(count);
			
			if(log.isDebugEnabled()) {
				log.debug("<<count>> : " + count);
			}
			
			
			PagingUtil page = new PagingUtil(keyfield,keyword,currentPage,count,rowCount,pageCount,"teacherMain.do");
			map.put("start", page.getStartCount());
			map.put("end",page.getEndCount());
			
			
			List<TeacherCommand> list = null;
			
			
			if(count>0) {
				list = teacherService.listTeacher(map);
				System.out.println(list);
			}
			ModelAndView mav = new ModelAndView();
			mav.setViewName("teacherMain");
			mav.addObject("count",count);
			mav.addObject("list",list);
			mav.addObject("pagingHtml",page.getPagingHtml());
			System.out.println(mav);
			
			return mav;
		}

	
	//강사 등록 폼
	@RequestMapping(value="/teacher/insert.do",method=RequestMethod.GET)
	public String insertForm(HttpSession session,Model model, TeacherCommand teacherCommand) {
		String id = (String)session.getAttribute("user_id");
		
		System.out.println("ID"+(String)session.getAttribute("user_id"));
		
		TeacherCommand teacher = teacherService.selectTM(id);
		
		model.addAttribute("teacher",teacher);
		System.out.println(teacher);
		return "teacherInsert";
	}
	


		//강사 등록
	@RequestMapping(value="/teacher/insert.do",method=RequestMethod.POST)
	//	뒤에오는 자바빈의 에러 메시지를 @Valid에 저장함
	public String insertSubmit(@ModelAttribute("command") @Valid TeacherCommand teacherCommand,BindingResult result) {
		if(log.isDebugEnabled()) {
			log.debug("<<academyCommand>> : " + teacherCommand);
		} 
		/*if(result.hasErrors()) {
			return insertForm(); 
		}
*/
		//강사 등록
		teacherService.insertTeacher(teacherCommand);
		return "redirect:/teacher/teacherMain.do";
	}
	
	

}
