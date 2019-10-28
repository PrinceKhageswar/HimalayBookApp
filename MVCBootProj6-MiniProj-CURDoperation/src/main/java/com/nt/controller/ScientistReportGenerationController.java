package com.nt.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nt.command.ScientistCommand;
import com.nt.dto.ScientistDTO;
import com.nt.service.ScientistMgmtService;

@Controller
public class ScientistReportGenerationController{
	@Autowired
	private ScientistMgmtService service;
	
	@RequestMapping("/home.htm")
	public String showHome() {
		return "welcome";		
	}//showhome
	@RequestMapping("/report.htm")
    public String showReport(Map<String,Object> map) throws Exception {
		List<ScientistDTO> listDTO=null;
		//use service
		listDTO=service.fetchAllScientist();
		map.put("listDTO", listDTO);
		//return mav obj
		return "report";	 
	}//showreport
	
	@RequestMapping(value="/edit.htm",method=RequestMethod.GET)
	public String showEditForm(HttpServletRequest req,@ModelAttribute("scCmd") ScientistCommand cmd) throws Exception {
		int id=0;
		ScientistDTO dto=null;
		//read req param value
		id=Integer.parseInt(req.getParameter("id"));
		//use service
		dto=service.fetchScientistById(id);
		//copy dto to cmd obj
		BeanUtils.copyProperties(dto, cmd);
		return "edit_scientist";
	}//show edit from
	
	@RequestMapping(value="/edit.htm",method=RequestMethod.POST)
	public String processEditForm(Map<String,Object> map,@ModelAttribute("scCmd") ScientistCommand cmd,
			BindingResult errors) throws Exception {
		
		ScientistDTO dto=null;
		String resultMsg=null;
		ModelAndView mav=null;
		List<ScientistDTO> listDTO=null;
		//convert command obj to dto
		dto=new ScientistDTO();
		BeanUtils.copyProperties(cmd, dto);
		//use service
		resultMsg=service.modifyScientistById(dto);
		listDTO = service.fetchAllScientist();
		//create and return mav obj
		
		map.put("resultMsg", resultMsg);
		map.put("listDTO",listDTO);
		return "report";
	
	}//process edit form

	@RequestMapping("/delete.htm")
	public String deleteScientist(HttpServletRequest req,Map<String,Object> map)
			throws Exception {
		int id=0;
		String resultMsg=null;
		List<ScientistDTO> listDTO=null;
		ModelAndView mav=null;
		//read the request param value
		id=Integer.parseInt(req.getParameter("id"));
		//use service
		resultMsg=service.removeScientistById(id);
		listDTO=service.fetchAllScientist();
		//create and return mav obj
		mav=new ModelAndView();
		map.put("resultMsg", resultMsg);
		map.put("listDTO", listDTO);
		return "report";
	}//delete 
	
	@RequestMapping(value="/add.htm",method=RequestMethod.GET)
	public String showForm(@ModelAttribute("scCmd") ScientistCommand cmd) {
		return "add_scientist";
	
	}
	
	@RequestMapping(value="/add.htm",method=RequestMethod.POST)
	public String processForm(Map<String,Object> map,@ModelAttribute("userCmd") ScientistCommand cmd,BindingResult errors) {
		
		
		ScientistDTO dto=null;
		List<ScientistDTO> listDTO=null;
		String resultMsg=null;
		//convert cmd to dto
				dto=new ScientistDTO();
				BeanUtils.copyProperties(cmd, dto);
				//use service
				resultMsg=service.registerScientist(dto);
				listDTO=service.fetchAllScientist();
				map.put("resultMsg",resultMsg);
				map.put("listDTO",listDTO);
		
		return "report";
	}
	
}
