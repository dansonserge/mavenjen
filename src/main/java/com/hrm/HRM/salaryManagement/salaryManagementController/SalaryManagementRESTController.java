package com.hrm.HRM.salaryManagement.salaryManagementController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hrm.HRM.salaryManagement.SalaryManagementVO.SalaryAdvanceVO;
import com.hrm.HRM.userManagement.userManagementService.UserManagementService;
import com.hrm.HRM.userManagement.userManagementVO.ContractVO;
import com.hrm.HRM.userManagement.userManagementVO.EmployeeVO;


@RestController
public class SalaryManagementRESTController {
	@Autowired
	UserManagementService userManagementService;

	
	//New Salary Advance request
	@RequestMapping(value="/request-salary-advance", method=RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> requestSalaryAdvance(@RequestParam Map<String, String> mapper, 
			HttpServletRequest request){
		Map<String, Object> map = new HashMap<String, Object>();
		
		//get Request data
		String amount = mapper.get("amount");
		String dueDate =mapper.get("due_date");
		String endPaymentDate =  mapper.get("end_payment_date");
		String reason =  mapper.get("reason");
		String requestDate = "";
		
		SalaryAdvanceVO salaryAdvance= new SalaryAdvanceVO();
		
		try {
			String email = request.getRemoteUser();
			EmployeeVO userprofile = userManagementService.getEmployeeByEmail(email);
			
			//Call a service that gets current contract by employee
			ContractVO currentContract = userManagementService.findEmployeeActiveContract(userprofile);
			
			//CHECK IF EMPLOYEE IS ELIGIBLE FOR SALARY ADVANCE REQUESTED
			if( Integer.parseInt(amount) > Integer.parseInt(currentContract.getMonthlySalary())) {
			    map.put("success", 0);
				map.put("message", "You are not eligible to request salary that is above "+currentContract.getMonthlySalary() );
				return new ResponseEntity<Map<String, Object>> (map, HttpStatus.BAD_REQUEST);
			}
			
			//CHECK IF EMPLOYEE HAS ALREADY REQUEST SALARY ADVANCE IN THIS YEAR
			
			
			
			
			
			salaryAdvance.setAmount(amount);
			salaryAdvance.setDueDate(dueDate.toString());
			salaryAdvance.setReason(reason);
			salaryAdvance.setRequestDate(requestDate);
			salaryAdvance.setEndPaymentDate(endPaymentDate.toString());
			//salaryAdvance.setContractVO(currentContract);
			map.put("success", 1);
			
			
			
		 return new ResponseEntity<Map<String, Object>> (map, HttpStatus.OK);
		 
		}catch(Exception e) {
			
		 map.put("success", 0);
			
		 map.put("error", e);
		 return new ResponseEntity<Map<String, Object>> (map, HttpStatus.BAD_REQUEST);
			
		}
		
	}
	
	//View list of salary advance requests given employee contract
	
	//View Salary Advance details BY ID
	
	//Delete Salary Advance request if none has approved
	
	//Update Salary Advance if none has approved
	
	//Toggle approve Salary Advance(CHR, CFO, CEO)
	
	

}
