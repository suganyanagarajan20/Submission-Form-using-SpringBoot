package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FormController {
	@Autowired
	CustomersRepo repo;
	@RequestMapping("/")
	public String details()
	{
		return "customer";
	}
	@RequestMapping("details")
	public String display_details(Customer customer)
	{
		repo.save(customer);
		return "customer";
	}
	@RequestMapping("getdetails")
	public String get_Details()
	{
		return "ViewDetails";
	}
	
	/*@PostMapping("details")
	public String viewDetails(@RequestParam("cid")String cid,
							  @RequestParam("cname")String cname,
							  @RequestParam("cemail")String cemail,
							  ModelMap modelmap)
	{
		modelmap.put("cid", cid);
		modelmap.put("cname", cname);
		modelmap.put("cemail", cemail);
		return "ViewDetails";
	}*/
	@PostMapping("getdetails")
	public ModelAndView viewDetails(@RequestParam int cid)
	{
		ModelAndView mv = new ModelAndView("Retrieve"); //Retrieve.jsp
		Customer customer = repo.findById(cid).orElse(null);
		mv.addObject(customer);
		return mv;
	}
	

}
