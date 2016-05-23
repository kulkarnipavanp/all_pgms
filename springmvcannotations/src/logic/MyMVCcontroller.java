package logic;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
@Controller
@RequestMapping("/first")
public class MyMVCcontroller  
{
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView helloWorldget() 
	{
		
		ModelAndView model = new ModelAndView("success");
			model.addObject("msg", "hello world get method");			
		return model;
	}		
	
	@RequestMapping(method = RequestMethod.POST)	
	public ModelAndView helloWorldpost() 
	{
		ModelAndView model = new ModelAndView("post");
			model.addObject("msg", "hello world post method");
		return model;
	}
		
}
