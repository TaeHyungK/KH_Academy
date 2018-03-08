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

import kr.spring.finalp.domain.ClassCommand;
import kr.spring.finalp.service.ClassService;
import kr.spring.util.PagingUtil;

@Controller
public class ClassController {

	private Logger log = Logger.getLogger(this.getClass());


	private int rowCount =10;
	private int pageCount = 10;
	

	@Resource
	private ClassService classService;
	
	//커맨드 객체 초기화
	@ModelAttribute("command")
	public ClassCommand initCommand() {
		return new ClassCommand();

	}
	
	//강의 목록 메인
		@RequestMapping("/class/classMain.do")
		public ModelAndView classMain(HttpSession session,Model model,ClassCommand classCommand,
				@RequestParam(value="pageNum",defaultValue="1")int currentPage,
				@RequestParam(value="keyfield",defaultValue="")String keyfield,
				@RequestParam(value="keyword",defaultValue="")String keyword) {

			//접속되어있는 아이디 구하기
			String id = (String)session.getAttribute("user_id");
			
			System.out.println("ID"+(String)session.getAttribute("user_id"));
			
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("m_id", id);
			map.put("keyfield", keyfield);
			map.put("keyword", keyword);
			
			//총글의 갯수 또는 검색됨 글의 갯수
			int count = classService.getRowCount(map);
			
			System.out.println(count);
			
			if(log.isDebugEnabled()) {
				log.debug("<<count>> : " + count);
			}
			
			
			PagingUtil page = new PagingUtil(keyfield,keyword,currentPage,count,rowCount,pageCount,"classMain.do");
			map.put("start", page.getStartCount());
			map.put("end",page.getEndCount());
			
			
			List<ClassCommand> list = null;
			
			
			if(count>0) {
				list = classService.listClass(map);
				System.out.println(list);
			}
			ModelAndView mav = new ModelAndView();
			mav.setViewName("classMain");
			mav.addObject("count",count);
			mav.addObject("command",list);
			mav.addObject("pagingHtml",page.getPagingHtml());
			System.out.println(mav);
			
			return mav;
		}

	
	//강의 등록 폼
	@RequestMapping(value="/class/insert.do",method=RequestMethod.GET)
	public String insertForm(HttpSession session,Model model, ClassCommand classCommand) {
		String id = (String)session.getAttribute("user_id");
		
		System.out.println("ID"+(String)session.getAttribute("user_id"));
		
		ClassCommand aclass = classService.selectCM(id);
		
		model.addAttribute("command",aclass);
		System.out.println(aclass);
		return "classInsert";
	}
	


		//강의 등록
	@RequestMapping(value="/class/insert.do",method=RequestMethod.POST)
	//	뒤에오는 자바빈의 에러 메시지를 @Valid에 저장함
	public String insertSubmit(@ModelAttribute("command") @Valid ClassCommand classCommand,BindingResult result) {
		if(log.isDebugEnabled()) {
			log.debug("<<academyCommand>> : " + classCommand);
		} 
		/*if(result.hasErrors()) {
			
			return insertForm();
		}*/

		System.out.println("?");
		
		//강의 등록
		classService.insertClass(classCommand);
		return "redirect:/main/main.do";
	}
	
	
	
	
}
