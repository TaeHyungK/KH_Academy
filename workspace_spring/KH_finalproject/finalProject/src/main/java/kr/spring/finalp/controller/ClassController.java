package kr.spring.finalp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

import kr.spring.finalp.domain.ClassCommand;
import kr.spring.finalp.service.AcademyService;
import kr.spring.finalp.service.ClassService;
import kr.spring.util.PagingUtil;

@Controller
public class ClassController {

	private Logger log = Logger.getLogger(this.getClass());


	private int rowCount =10;
	private int pageCount = 10;


	@Resource
	private ClassService classService;
	@Resource
	private AcademyService academyService;

	//커맨드 객체 초기화
	@ModelAttribute("command")
	public ClassCommand initCommand() {
		return new ClassCommand();

	}
	//강의 목록(강의 소개)
	@RequestMapping("/class/classList.do")
	public ModelAndView classList(Model model,ClassCommand classCommand,
			HttpSession session,
			@RequestParam(value="pageNum",defaultValue="1")int currentPage,
			@RequestParam(value="keyfield",defaultValue="")String keyfield,
			@RequestParam(value="keyword",defaultValue="")String keyword) {

		//접속되어있는 아이디 구하기
		String id = (String)session.getAttribute("user_id");
		System.out.println("ID"+(String)session.getAttribute("user_id"));


		System.out.println("Keyfield : " + keyfield);

		Map<String,Object> map = new HashMap<String,Object>();
		map.put("keyfield", keyfield);
		map.put("keyword", keyword);

		//총글의 갯수 또는 검색됨 글의 갯수
		int count = classService.getListRowCount(map);

		System.out.println(count);

		if(log.isDebugEnabled()) {
			log.debug("<<count>> : " + count);
		}


		PagingUtil page = new PagingUtil(keyfield,keyword,currentPage,count,rowCount,pageCount,"classList.do");
		map.put("start", page.getStartCount());
		map.put("end",page.getEndCount());

		List<ClassCommand> list = null;

		String a_logo = null;
		if(count>0) {
			list = classService.selectClass(map);

			for(int i =0;i<list.size();i++) {
				Integer a_num = list.get(i).getA_num();
				a_logo = academyService.selectAcademyDetail(a_num).getA_logo();
				list.get(i).setA_logo(a_logo);
				
		        String contents = list.get(i).getC_content();
		        contents = contents.replace("\r\n", "<br>");
				list.get(i).setC_content(contents);
			}

			System.out.println(list);
		}

		ModelAndView mav = new ModelAndView();
		mav.setViewName("classList");
		mav.addObject("count",count);
		mav.addObject("command",list);
		mav.addObject("pagingHtml",page.getPagingHtml());

		return mav;
	}

	//강의 정보 메인(내정보관리)
	@RequestMapping("/class/classMain.do")
	public ModelAndView classMain(HttpSession session,Model model,ClassCommand classCommand,
			@RequestParam(value="pageNum",defaultValue="1")int currentPage,
			@RequestParam(value="keyfield",defaultValue="c_name")String keyfield,
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

			//커맨드에 이미지정보 추가
			for(int i =0;i<list.size();i++) {
				Integer a_num = list.get(i).getA_num();
				String a_logo = academyService.selectAcademyDetail(a_num).getA_logo();
				list.get(i).setA_logo(a_logo);
				
				String contents = list.get(i).getC_content();
		        contents = contents.replace("\r\n", "<br>");
				list.get(i).setC_content(contents);
			}

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

		List<ClassCommand> list = null;
		list = classService.listTnum(id);
		System.out.println(classService.listTnum(id));
		System.out.println(list);

		model.addAttribute("command",aclass);
		model.addAttribute("list",list);
		System.out.println(aclass);

		return "classInsert";
	}



	//강의 등록
	@RequestMapping(value="/class/insert.do",method=RequestMethod.POST)
	//	뒤에오는 자바빈의 에러 메시지를 @Valid에 저장함
	public String insertSubmit(@ModelAttribute("command") @Valid ClassCommand classCommand,BindingResult result, HttpServletRequest request) {

		if(log.isDebugEnabled()) {

			log.debug("<<classCommand>> : " + classCommand);
		} 
		/*if(result.hasErrors()) {

			return insertForm();
		}*/

		System.out.println("?");

		//강의 등록
		try {
			String content = classCommand.getC_content();
	        content = content.replace("\r\n", "<br>");
	        classCommand.setC_content(content);
			classService.insertClass(classCommand);
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("message", "모든 정보를 입력해주세요.");
			request.setAttribute("url", "../class/insert.do");
			return "common/messageUrl";
		}
		return "redirect:/class/classMain.do";
	}

	//강의 수정 폼
	@RequestMapping(value="/class/updateClass.do",method=RequestMethod.GET)
	public String updateForm(HttpSession session,Model model, ClassCommand classCommand, @RequestParam("c_num") int c_num,
			@RequestParam("a_num") int a_num) {

		String id = (String)session.getAttribute("user_id");

		System.out.println("a"+a_num);


		HashMap<Object, Object> map = new HashMap<Object, Object>();
		map.put("a_num", a_num);
		map.put("c_num", c_num);

		//해당학원 불러오기
		ClassCommand upclass = classService.updateCompare(map);

		List<ClassCommand> list = null;
		list = classService.listTnum(id);
		System.out.println(classService.listTnum(id));
		System.out.println(list);

		model.addAttribute("command",upclass);
		model.addAttribute("list",list);
		System.out.println(upclass);

		return "classUpdate";
	}
	//강의 수정
	@RequestMapping(value="/class/updateClass.do",method=RequestMethod.POST)
	public String updateSubmit(HttpSession session,Model model, ClassCommand classCommand,
			@RequestParam("c_num") int c_num,
			@RequestParam("a_num") int a_num) {


		System.out.println("a"+a_num);

		//해당학원 수정
		classService.updateClass(classCommand);

		return "redirect:/class/classMain.do";
	}

	//강의 삭제
	@RequestMapping("/class/deleteClass.do")
	public String deleteSubmit(HttpSession session,Model model, ClassCommand classCommand,
			@RequestParam("c_num") int c_num,
			@RequestParam("a_num") int a_num,
			HttpServletRequest request) {

		System.out.println("a"+a_num);
		
		Integer m_num = (Integer) session.getAttribute("user_num");

		System.out.println("<<m_num>> : " + m_num);
		
		HashMap<Object, Object> map = new HashMap<Object, Object>();
		map.put("c_num", c_num);
		map.put("a_num",a_num);
		
		int checkedComplete = classService.compareComplete(c_num);
		System.out.println("<<checkedComplete>> : " + checkedComplete);
		
		if(checkedComplete > 0) {
			request.setAttribute("message", "수강신청이 진행된 강의는 삭제하실 수 없습니다.");
			request.setAttribute("url", "../class/classMain.do");
			return "common/messageUrl";
		}
		
		//해당학원 수정
		classService.deleteClass(map);
		System.out.println("ff");
		
		
		return "redirect:/class/classMain.do";
	}

	//내가 찜한 강의 담기
	@RequestMapping("/class/classGet.do")
	//	뒤에오는 자바빈의 에러 메시지를 @Valid에 저장함
	public String classGet(@ModelAttribute("command") @Valid ClassCommand classCommand,
			BindingResult result,
			@RequestParam("m_num") int m_num,
			@RequestParam("c_num") int c_num,
			HttpServletRequest request, HttpServletResponse response)throws Exception {
		
		if(log.isDebugEnabled()) {
			log.debug("hh<<classCommand>> : " + classCommand);
		} 

		if(result.hasErrors()) {
			System.out.println(result.toString());
			return "redirect:/class/classList.do";
		}

		Map<Object,Object> map = new HashMap<Object,Object>();
		map.put("m_num", m_num);
		map.put("c_num", c_num);

		//찜목록에 있는지 비교
		int compare = 0; 
		compare = classService.compareClass(map);
		if(compare >0) {
			request.setAttribute("message", "이미 담겨있는 강의입니다.");
			request.setAttribute("url", "../class/classList.do");
			return "common/messageUrl";

			//return "redirect:/class/classList.do";
		}else {
			//강의 찜하기
			classService.getClass(classCommand);

			return "redirect:/class/myClass.do"; 
		}


	}


	//내가 찜한 강의 목록
	@RequestMapping("/class/myClass.do")
	public String GetForm(HttpSession session,Model model, ClassCommand classCommand) {

		String id = (String)session.getAttribute("user_id");

		int count = 1;
		System.out.println("ID"+(String)session.getAttribute("user_id"));


		List<ClassCommand> list = classService.selectGet(id);

		System.out.println("get "+list);

		model.addAttribute("list",list);
		model.addAttribute("count",count);

		return "myClass";
	}


	//내가 찜한 강의 목록에서 삭제
	@RequestMapping("/class/classDelete.do")
	@ResponseBody
	public Map<Object,Object> deleteMyclass(@RequestParam("my_num") int my_num,
			@Valid ClassCommand classCommand,
			BindingResult result,
			HttpSession session
			) {
		System.out.println("ajax로 삭제하기");
		if(log.isDebugEnabled()) {
			log.debug("<<num>> : " + my_num);
		}

		Map<Object,Object> map = 
				new HashMap<Object,Object>();
		String user_id = (String)session.getAttribute("user_id");
		if(user_id==null) {
			//로그인이 되어있지 않음
			map.put("result", "logout");
			System.out.println("삭제가 되나1");
		}else {
			//찜목록에서 강의 삭제하기
			classService.deleteMyClass(my_num);
			map.put("result", "success");
			System.out.println("삭제가 되나2");
		}
		System.out.println("삭제가 되나3");
		return map;
	}

	//수강신청
	@RequestMapping("/class/classComplete.do")
	@ResponseBody
	public String classComplete(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value="my_num",required=true) List<String> my_num,
			@RequestParam(value="m_num",required=true) List<String> m_num,
			@RequestParam(value="c_num",required=true) List<String> c_num,
			@RequestParam(value="total_price",required=true) int total_price) throws Exception {

		log.debug( ">>> param size : " + my_num.size());
		log.debug( ">>> param size : " + m_num.size());
		log.debug( ">>> param size : " + c_num.size());
		log.debug( ">>> param size : " + total_price);
		
		Map<Object,Object> map = new HashMap<Object, Object>();
		map.put("total_price", total_price);
		
		for(int i=0; i<my_num.size(); i++) {
			map.put("my_num", Integer.parseInt(my_num.get(i)));
			map.put("m_num", Integer.parseInt(m_num.get(i)));
			map.put("c_num", Integer.parseInt(c_num.get(i)));
			//수강신청완료목록에 있는지 비교
			/*				
			compare = classService.compareComplete(map);
			System.out.println(compare);
			if(compare >0) {
				request.setAttribute("message", "이미 수강신청 완료 된 강의가 포함되어 있습니다.");
				request.setAttribute("url", "../class/myClass.do");
				System.out.println("com"+compare);
				return "common/messageUrl";

			}else {
			*/
			System.out.println("map"+map);  
			classService.classComplete(map); 
			classService.deleteMyClass(Integer.parseInt(my_num.get(i)));
			classService.updateC_count(Integer.parseInt(c_num.get(i)));
			System.out.println(Integer.parseInt(c_num.get(i)));
			/*}*/
		}

		System.out.println("수강신청11");

		return "success";
	}

	//수강 신청 완료 목록  
	@RequestMapping("/class/classCompleteList.do")
	public String completeForm(HttpSession session,Model model, ClassCommand classCommand) {

		int m_num = (Integer)session.getAttribute("user_num");

		List<ClassCommand> list = classService.selectComplete(m_num);

		System.out.println("get "+list);

		model.addAttribute("list",list);

		return "classCompleteList";
	}


}
