package com.hrm.HRM.leaveManagement.leaveManagementController;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrm.HRM.leaveManagement.leaveManagementService.LeaveManagementService;
import com.hrm.HRM.leaveManagement.leaveManagementService.PeriodService;
import com.hrm.HRM.leaveManagement.leaveManagementVO.LeaveRequestVO;
import com.hrm.HRM.leaveManagement.leaveManagementVO.LongLeaveRequestDetails;
import com.hrm.HRM.leaveManagement.leaveManagementVO.ShortLeaveRequestDetails;

@RestController
@RequestMapping("/api/Leave")
public class LeaveManagementRestController {

	@Autowired
	LeaveManagementService leaveManagementService;
	@Autowired
	PeriodService periodService;
	
	@PostMapping("/addLong")
	public ResponseEntity<?> addLeaveDetails(@ModelAttribute LongLeaveRequestDetails longLeaveRequestDetails) throws IOException{
		
		LeaveRequestVO leaveRequestVO = new LeaveRequestVO();
		
		leaveRequestVO.setBackupPerson(longLeaveRequestDetails.getBacupP());
		leaveRequestVO.setComment(longLeaveRequestDetails.getComment());
		leaveRequestVO.setCreatedDate(new Timestamp(new Date().getTime()));
		leaveRequestVO.setEmployeeVO(longLeaveRequestDetails.getEmpId());
		leaveRequestVO.setLeaveCategoryVO(longLeaveRequestDetails.getLeaveCateg());
		leaveRequestVO.setLeaveDate(longLeaveRequestDetails.getDateToGo().toString());
		leaveRequestVO.setRetunDate(longLeaveRequestDetails.getReturnDate().toString());
		leaveRequestVO.setPeriodVO(leaveRequestVO.getPeriodVO());
		leaveRequestVO.setLeaveType("Long");
		leaveRequestVO.setPeriodVO(longLeaveRequestDetails.getPeriod());
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date dataToGo = dateFormat.parse(longLeaveRequestDetails.getDateToGo());
			Date dateToReturn = dateFormat.parse(longLeaveRequestDetails.getReturnDate());
			long dateDiff = dateToReturn.getTime() - dataToGo.getTime();
			
			long daysDiff = TimeUnit.DAYS.convert(dateDiff, TimeUnit.MILLISECONDS);
			long hoursDiff = daysDiff * 24;
			
			leaveRequestVO.setDays(daysDiff);
			leaveRequestVO.setHours(hoursDiff);
			leaveManagementService.createLeave(leaveRequestVO);
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("ERROR"+e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		System.out.println("Back up person Name:"+leaveRequestVO.getDays());
		return new ResponseEntity<String>("OK", HttpStatus.OK);
	}
	
	@PostMapping("/addShort")
	public ResponseEntity<?> addShortLeaveDetails(@ModelAttribute ShortLeaveRequestDetails shortLeaveRequestDetails) throws IOException{
		
		LeaveRequestVO leaveRequestVO = new LeaveRequestVO();
		
		leaveRequestVO.setCreatedDate(new Timestamp(new Date().getTime()));
		leaveRequestVO.setBackupPerson(shortLeaveRequestDetails.getBacupP());
		leaveRequestVO.setReason(shortLeaveRequestDetails.getReason());
		leaveRequestVO.setEmployeeVO(shortLeaveRequestDetails.getEmpId());
		leaveRequestVO.setHours(shortLeaveRequestDetails.getHoursTaken());
		leaveRequestVO.setLeaveDate(shortLeaveRequestDetails.getDateToGo());
		leaveRequestVO.setLeaveType("Short");
		leaveRequestVO.setPeriodVO(shortLeaveRequestDetails.getPeriod());
		leaveRequestVO.setReason(shortLeaveRequestDetails.getReason());
		leaveRequestVO.setRetunDate(shortLeaveRequestDetails.getDateToGo());
		leaveRequestVO.setDays((long) 0);

		try {
			leaveManagementService.createLeave(leaveRequestVO);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("ERROR"+e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		System.out.println("Back up person Name:"+leaveRequestVO.getBackupPerson());
		return new ResponseEntity<String>("OK", HttpStatus.OK);
	}

}
