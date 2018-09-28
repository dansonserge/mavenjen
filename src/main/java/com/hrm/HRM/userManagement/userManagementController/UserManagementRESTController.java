package com.hrm.HRM.userManagement.userManagementController;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hrm.HRM.userManagement.userManagementService.UserManagementService;
import com.hrm.HRM.userManagement.userManagementVO.ContractVO;
import com.hrm.HRM.userManagement.userManagementVO.EmployeeAllDetailsVO;
import com.hrm.HRM.userManagement.userManagementVO.EmployeeVO;
import com.hrm.HRM.utils.RandomPassGenerator;
import com.hrm.HRM.utils.UploadFilesUtils;

@RestController
@RequestMapping("/api/employee")
public class UserManagementRESTController {
	
	@Autowired
	UserManagementService userManagementService;
	
	@Autowired
	UploadFilesUtils uploadFilesUtils;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@PostMapping("/add")
	public ResponseEntity<?> addEmployeeDetails(@ModelAttribute EmployeeAllDetailsVO employeeAllDetailsVO) throws Exception{
		
		EmployeeVO employeeVO = new EmployeeVO();
		
		employeeVO.setFistName(employeeAllDetailsVO.getFname());
		employeeVO.setMiddleName(employeeAllDetailsVO.getMname());
		employeeVO.setLastName(employeeAllDetailsVO.getLname());
		employeeVO.setDob(employeeAllDetailsVO.getDob());
		employeeVO.setMstatus(employeeAllDetailsVO.getMstatus());
		employeeVO.setContactEmail(employeeAllDetailsVO.getEmaddress());
		employeeVO.setContactPhone(employeeAllDetailsVO.getPhone());
		employeeVO.setNationality(employeeAllDetailsVO.getNationality());
		employeeVO.setPositionVO(userManagementService.getPositionById(employeeAllDetailsVO.getPosition()));
		employeeVO.setNid(employeeAllDetailsVO.getNid());
		employeeVO.setAddress(employeeAllDetailsVO.getLocation());
		//set user role as employee as default
		
		//set Departement information
		employeeVO.setDepartmentVO(userManagementService.getDepartmentById(employeeAllDetailsVO.getDepartment()));
		
		//generate random passoword
		employeeVO.setEncrytedPassword(bCryptPasswordEncoder.encode(new RandomPassGenerator().randomPassword(8)));
		//enable user by default
		employeeVO.setEnabled(true);
		
		employeeVO.setSignatureAttachFileName(employeeAllDetailsVO.getSignature().getOriginalFilename());
		
		//Create user folder
		//if(new File("employee/").exists()){
			//new File(employeeAllDetailsVO.getFname()+"/signature").mkdirs();
		//}else {
			new File("employee/"+employeeAllDetailsVO.getFname()+"/signature").mkdirs();
		//}
		
		//System.out.println("Folder Created:"+cuserFolder);
		
		
		String signatureFilePath = uploadFilesUtils.uploadSignatureFile(employeeAllDetailsVO.getSignature(), "employee/"+employeeAllDetailsVO.getFname()+"/signature");
		employeeVO.setSignatureAttachFilePath(signatureFilePath);
		employeeVO.setSignatureAttachFileSize(String.valueOf(employeeAllDetailsVO.getSignature().getSize()));
		
		//create contract information
		
		ContractVO contract = new ContractVO();
		contract.setStartDate(employeeAllDetailsVO.getSartDate());
		contract.setEndDate(employeeAllDetailsVO.getEndDate());
		contract.setMonthlySalary(employeeAllDetailsVO.getMsalary());
		//save contract type information
		contract.setContractTypeVO(userManagementService.getContractTypeById(employeeAllDetailsVO.getContractType()));
		contract.setStatus("ACTIVE");
		
		contract.setContractAttachFileName(employeeAllDetailsVO.getCfile().getOriginalFilename());
		
		//create contract folder for employee if it is not created
		
		new File("employee/"+employeeAllDetailsVO.getFname()+"/contract").mkdirs();
		String contractFilePath = uploadFilesUtils.uploadSignatureFile(employeeAllDetailsVO.getCfile(), "employee/"+employeeAllDetailsVO.getFname()+"/contract");
		contract.setContractAttachFileSize(String.valueOf(employeeAllDetailsVO.getCfile().getSize()));
		contract.setContractAttachFilePath(contractFilePath);
		
		//set employe details information to the contract information
		contract.setEmployeeVO(employeeVO);
		
		//set contract type information
		contract.setContractTypeVO(userManagementService.getContractTypeById(employeeAllDetailsVO.getContractType()));
		
		try {
			//create new employee information
			userManagementService.createEmployee(employeeVO);
			//create contract information
			userManagementService.createContract(contract);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<String>("ERROR"+e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		
		System.out.println("Employe Name:"+employeeAllDetailsVO.getFname());
		return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		
	}
    @GetMapping("/getEmployeeList")
    @ResponseBody
    public List<EmployeeVO> getAllEmployeeList(){
        List<EmployeeVO> employeeVOList = new ArrayList<EmployeeVO>();
        try {
        	for(EmployeeVO emp: userManagementService.getAllEmployeeList()){
        		if(emp.isEnabled() == true){
        			employeeVOList.add(emp);
        		}
        	} 
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("getAllEmployeeList : "+ e.getMessage());
        }
        return employeeVOList;
    }
    
//    //delete Employee mapping
//    @DeleteMapping("/deleteEmployee")
//    @ResponseBody
//    public ResponseEntity<?> deleteEmployeeInfo(@RequestBody long[] ids){
//    	try {
//			userManagementService.deleteBulkOfEmployee(ids);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return new ResponseEntity<String>("ERROR", HttpStatus.BAD_REQUEST);
//		}
//		return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
//    	
//    }
//    
//
//	
}
