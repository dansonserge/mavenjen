package com.hrm.HRM.userManagement.userManagementController;
import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hrm.HRM.userManagement.userManagementService.UserManagementService;
import com.hrm.HRM.userManagement.userManagementVO.ContractTypeVO;
import com.hrm.HRM.userManagement.userManagementVO.DepartmentVO;
import com.hrm.HRM.userManagement.userManagementVO.EmployeeVO;
import com.hrm.HRM.userManagement.userManagementVO.PositionVO;
import com.hrm.HRM.utils.WebUtils;


@Controller
public class UserManagementController {
	
	@Autowired
	UserManagementService userManagementService;
	
	@RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
    public String loginPage(Model model) {
     
        return "login";
    }
	
	
	@RequestMapping(value = { "employee" }, method = RequestMethod.GET)
    public String employee(Model model, HttpServletRequest request) throws Exception {
		
		String email = request.getRemoteUser();
		EmployeeVO Userprofile = userManagementService.getEmployeeByEmail(email);
		model.addAttribute("Userprofile", Userprofile); 

        return "employee";
    }
	
	@RequestMapping(value ="/employee_profile/{userId}", method = RequestMethod.GET)
    public String employeeProfile(@PathVariable("userId") long userId, Model model, HttpServletRequest request) throws Exception {
		
		String email = request.getRemoteUser();
		EmployeeVO Userprofile = userManagementService.getEmployeeByEmail(email);
		model.addAttribute("Userprofile", Userprofile); 
		
		//get user by user id
		EmployeeVO userInfo = userManagementService.getEmployeeById(userId);
		model.addAttribute("userInfo", userInfo);

        return "employee_profile";
    }
	
	@RequestMapping(value="/userAccount", method=RequestMethod.GET)
	public String Employees (Model model, HttpServletRequest request) throws Exception {
		
		String email = request.getRemoteUser();
		EmployeeVO Userprofile = userManagementService.getEmployeeByEmail(email);
		model.addAttribute("Userprofile", Userprofile); 

		return "employee"; 
	}
	@RequestMapping(value="/add_employee", method=RequestMethod.GET)
	public String AddEmployees (Model model, HttpServletRequest request) throws Exception {
		String email = request.getRemoteUser();
		EmployeeVO Userprofile = userManagementService.getEmployeeByEmail(email);
		model.addAttribute("Userprofile", Userprofile); 

		//GET LIST OF CONTRACT TYPE
		List<ContractTypeVO> contractType =userManagementService.getAllContractTypeList();
		model.addAttribute("contractType", contractType);
		//GET LIST OF DEPARTMENT
		List<DepartmentVO> departments =userManagementService.getAllDepartmentList();
		model.addAttribute("departments", departments);
		//GET LIST OF POSITION
		List<PositionVO> positions =userManagementService.getAllPositionList();
		model.addAttribute("positions", positions);
		
		return "add_employee";
	}

	// get user by email
	@RequestMapping(value = "/userByEmail", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> getUserInforByEmail(@RequestParam("email") String email) {

		EmployeeVO emp = new EmployeeVO();
		try {
			
			System.out.println("Employee Email:"+ email);
			
			emp = userManagementService.getEmployeeByEmail(email);
			//System.out.println("FETCHED EMP"+emp.getFistName());
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("ERROR" + e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		if (emp == null || emp.isEnabled() == false) {
			return new ResponseEntity<String>("False", HttpStatus.OK);
		}
		return new ResponseEntity<String>("True", HttpStatus.OK);

	}

	@RequestMapping(value = "/user_dashboard", method = RequestMethod.GET)
	public String userDashboard (Model model, HttpServletRequest request) throws Exception {
		
		String email = request.getRemoteUser();
		EmployeeVO Userprofile = userManagementService.getEmployeeByEmail(email);
		model.addAttribute("Userprofile", Userprofile);
		
		return "user_dashboard";
	}

	@RequestMapping(value = "/setting", method = RequestMethod.GET)
	public String setitings(Model model, HttpServletRequest request) throws Exception {
		
		String email = request.getRemoteUser();
		EmployeeVO Userprofile = userManagementService.getEmployeeByEmail(email);
		model.addAttribute("Userprofile", Userprofile); 

		return "setting";
	}
	
    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied(Model model, Principal principal) {
 
        if (principal != null) {
            User loginedUser = (User) ((Authentication) principal).getPrincipal();
 
            String employee = WebUtils.toString(loginedUser);
 
            model.addAttribute("employee", employee);
 
            String message = "Hi " + principal.getName() //
                    + "<br> You do not have permission to access this page!";
            model.addAttribute("message", message);
 
        }
 
        return "/login";
    }
    @RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
    public String logoutSuccessfulPage(Model model) {
        model.addAttribute("title", "Logout");
        return "redirect:/login";
    }
}
