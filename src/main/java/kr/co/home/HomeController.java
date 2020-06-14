package kr.co.home;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.dto.BoardVO;
import kr.co.dto.TestDto;
import kr.co.paging.PageNavigator;
import kr.co.service.BoardServiceImpl;
import kr.co.service.TestService;

@Controller
public class HomeController {

	@Autowired
	private TestService testService;
	
	@Autowired
	private BoardServiceImpl service;

	@PostMapping("/test")
	@RequestMapping(value="/test", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String insertName(TestDto dto, HttpServletRequest request, Model model) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		// DB에 dto.getName값이 저장 되어 있다면, true를 반환한다.
		boolean falg = testService.selectName(dto.getName());
		if (!falg) {
			// DB에 dto 객체를 저장한다.
			testService.insertId(dto);
			model.addAttribute("test", dto);
			return "plz korean";
		} else {
			return "home";
		}
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "home";
	}
	
	@GetMapping("/list")
	public String list(Model model) {
		// DB에 저장된 TestDto 객체들을 모두 보기 위해  List 클래스를 사용하였다.
		List<TestDto> list = testService.list();
		// DB에서 가져온 데이터들을 "list" 에 담아서 View(뷰)로 넘긴다.
		model.addAttribute("list", list);
		return "list";
	}
//	
	@GetMapping("/get")
	public String get(@PathVariable int bno, Model model, BoardVO board) {
		System.out.println("bno : "+board.getBno());
		model.addAttribute("board", board.getBno()); 
		return "get";
	}
	
	final static int COUNTPERPAGE = 6;
	final static int PAGEPERGROUP = 3;
	
	@GetMapping("get_list")
	public String get_list(Model model,@RequestParam(value = "page", 
	defaultValue = "1" ,required= false) int page) throws NumberFormatException, Exception {	
		
		PageNavigator navi = new PageNavigator(COUNTPERPAGE, PAGEPERGROUP, page, service.selectCount());
//		
//		service.getList(navi);
//		
//		model.addAttribute("list", service.getList(navi));
//		model.addAttribute("navi", navi);
		System.out.println("page : "+page);
		
		List<BoardVO> board = service.getList( 1, navi);
		model.addAttribute("list", board);
		return "get_list";
	}

	@GetMapping("/delete")
	public String delete(Model model, TestDto dto) {
		// DB에 dto.getName 데이터가 있을 시 true를 반환한다.
		boolean flag = testService.selectName(dto.getName());		
		if (flag) {
			// DB에 dto객체 데이터를 삭제한다.
			testService.delete(dto);			
			return "delete_success";
		} else {		
			return "redirect:/";
		}
	}

//	@GetMapping("/delete_success")
//	public ModelAndView delete_success() {
//		ModelAndView mv = new ModelAndView();		
//		mv.setViewName("delete_success");
//		return mv;
//	}
	
	@GetMapping("update")
	public String update(TestDto dto) {
		// DB에 dto.getName 데이터가 있을 시 true를 반환한다.
		boolean flag = testService.selectName(dto.getName()); 		
		if(flag) {			
			// DB에 dto객체 데이터를 수정한다.
			testService.update(dto);			
			return "update";
		}else {
			return "redirect:/";
		}
				
	}
}
