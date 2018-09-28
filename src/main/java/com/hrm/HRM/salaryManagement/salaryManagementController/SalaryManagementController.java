package com.hrm.HRM.salaryManagement.salaryManagementController;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hrm.HRM.userManagement.userManagementService.UserManagementService;
import com.hrm.HRM.userManagement.userManagementVO.EmployeeVO;

@Controller
public class SalaryManagementController {
	@Autowired
	UserManagementService userManagementService;
	
	@RequestMapping(value="/salary_request", method=RequestMethod.GET)
	public String SalaryApprove (Model model, HttpServletRequest request) throws Exception {
		
		String email = request.getRemoteUser();
		EmployeeVO Userprofile = userManagementService.getEmployeeByEmail(email);
		model.addAttribute("Userprofile", Userprofile); 

		return "salary_request";
	}
	
	@RequestMapping(value="/approve_salary", method=RequestMethod.GET)
	public String loginPage (Model model, HttpServletRequest request) throws Exception {
		
		String email = request.getRemoteUser();
		EmployeeVO Userprofile = userManagementService.getEmployeeByEmail(email);
		model.addAttribute("Userprofile", Userprofile); 

		return "approve_salary";
	}
	
	@RequestMapping(value = "/salary_dashboard", method = RequestMethod.GET)
	public String salaryDasboard (Model model, HttpServletRequest request) throws Exception {
		
		String email = request.getRemoteUser();
		EmployeeVO Userprofile = userManagementService.getEmployeeByEmail(email);
		model.addAttribute("Userprofile", Userprofile); 
	
		return "salary_dashboard";
	}
}
