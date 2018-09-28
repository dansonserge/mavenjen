package com.hrm.HRM.leaveManagement.leaveManagementController;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hrm.HRM.leaveManagement.leaveManagementService.LeaveManagementService;
import com.hrm.HRM.leaveManagement.leaveManagementService.PeriodService;
import com.hrm.HRM.leaveManagement.leaveManagementVO.LeaveCategoryVO;
import com.hrm.HRM.leaveManagement.leaveManagementVO.PeriodVO;
import com.hrm.HRM.userManagement.userManagementService.UserManagementService;
import com.hrm.HRM.userManagement.userManagementVO.EmployeeVO;

@Controller
public class LeaveManagementController {

	@Autowired
	UserManagementService userManagementService;
	@Autowired
	LeaveManagementService  leaveMnagementService;
	
	@Autowired
	PeriodService periodService;
	
	@RequestMapping(value="/leave_request", method=RequestMethod.GET)
	public String RequestLeave  (Model model, HttpServletRequest request) throws Exception {
		
		String email = request.getRemoteUser();
		EmployeeVO Userprofile = userManagementService.getEmployeeByEmail(email);
		model.addAttribute("Userprofile", Userprofile); 

		return "leave_request";
	}

	@RequestMapping(value="/long_leave", method=RequestMethod.GET)
	public String addLongLeave  (Model model, HttpServletRequest request,String status) throws Exception {
//		PeriodVO periodVO =new PeriodVO();
		String email = request.getRemoteUser();
		EmployeeVO Userprofile = userManagementService.getEmployeeByEmail(email);
		model.addAttribute("Userprofile", Userprofile);
		List<LeaveCategoryVO> leaveCategList= leaveMnagementService.listCategoryList();
		model.addAttribute("leaveCategList", leaveCategList);
		List<PeriodVO> perioList=periodService.listPeriodList();
		for(PeriodVO p:perioList) {
			if(p.getStatus().equals("Active")) {
			model.addAttribute("p", p);
			}
		}
		return "long_leave";
	}
		
	@RequestMapping(value="/short_leave", method=RequestMethod.GET)
	public String addShortLeave  (Model model, HttpServletRequest request) throws Exception {
		String email = request.getRemoteUser();
		EmployeeVO Userprofile = userManagementService.getEmployeeByEmail(email);
		model.addAttribute("Userprofile", Userprofile); 

		return "short_leave";
	}
	

	@RequestMapping(value = "/add_leave", method = RequestMethod.GET)
	public String addLeave(Model model, HttpServletRequest request) throws Exception {
		
		String email = request.getRemoteUser();
		EmployeeVO Userprofile = userManagementService.getEmployeeByEmail(email);
		model.addAttribute("Userprofile", Userprofile); 
		
		return "add_leave";
	}

	@RequestMapping(value = "/approve_leave", method = RequestMethod.GET)
	public String ApproveLeave(Model model, HttpServletRequest request) throws Exception {
		
		String email = request.getRemoteUser();
		EmployeeVO Userprofile = userManagementService.getEmployeeByEmail(email);
		model.addAttribute("Userprofile", Userprofile); 
        
		return "approve_leave";
	}
	
	@RequestMapping(value = "/leave_dashboard", method = RequestMethod.GET)
	public String LeaveDashboard(Model model, HttpServletRequest request) throws Exception {
		
		String email = request.getRemoteUser();
		EmployeeVO Userprofile = userManagementService.getEmployeeByEmail(email);
		model.addAttribute("Userprofile", Userprofile); 
        
		return "leave_dashboard";
	}
}
