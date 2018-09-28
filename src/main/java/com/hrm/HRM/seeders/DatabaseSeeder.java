package com.hrm.HRM.seeders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.JdbcTemplate;

import com.hrm.HRM.userManagement.userManagementDAO.ContractTypeDAO;
import com.hrm.HRM.userManagement.userManagementDAO.DepartmentDAO;
import com.hrm.HRM.userManagement.userManagementDAO.PositionDAO;
import com.hrm.HRM.userManagement.userManagementDAO.UserManagementDAO;
import com.hrm.HRM.userManagement.userManagementVO.ContractTypeVO;
import com.hrm.HRM.userManagement.userManagementVO.DepartmentVO;
import com.hrm.HRM.userManagement.userManagementVO.PositionVO;

import java.util.List;

import org.apache.log4j.Logger;


@Component
public class DatabaseSeeder {
	 private Logger logger = Logger.getLogger(DatabaseSeeder.class);
     //private UserManagementDAO userManagementDAO;
     private ContractTypeDAO contractTypeDAO;
	 private DepartmentDAO departmentDAO;
	 private PositionDAO positionDAO;

	 
	 
	@Autowired
	public DatabaseSeeder(
            UserManagementDAO userManagementDAO,
            ContractTypeDAO contractTypeDAO,
			DepartmentDAO departmentDAO,
			PositionDAO positionDAO,
			
			JdbcTemplate jdbcTemplate
			) {
        //this.userManagementDAO = userManagementDAO;
        this.contractTypeDAO = contractTypeDAO;
		this.departmentDAO = departmentDAO;
		this.positionDAO= positionDAO;
		
	}
	
	
	@EventListener
	 public void seed(ContextRefreshedEvent event) {
       //seedEmployeesTable();
       //seedContractsTable();
	   seedContractType();
	   seedDepartment();
	   seedPosition();
   }
	
   
   private void seedPosition(){
	   List<PositionVO> u = (List<PositionVO>) positionDAO.findAll();

	   if(u.isEmpty() == true){

		PositionVO p1 = new PositionVO();
		PositionVO p2 = new PositionVO();
		PositionVO p3 = new PositionVO();


		p1.setPositionId(1);
		p1.setDescription("Employee");
		p1.setAbbreviation("EMP");

		p2.setPositionId(2);
		p2.setDescription("Chief of Human Resource Officer");
		p2.setAbbreviation("CHRO");

		p2.setPositionId(3);
		p2.setDescription("Head of Department");
		p2.setAbbreviation("HOD");

		positionDAO.save(p1);
		positionDAO.save(p2);
		positionDAO.save(p3);

			logger.info("position added");
	   }else{
			logger.trace("Position Seeding Not Required");

	   }
   }
   private void seedDepartment(){
    List<DepartmentVO> u = (List<DepartmentVO>) departmentDAO.findAll();
        if(u.isEmpty() == true){
			  
			DepartmentVO d1 = new DepartmentVO();
			DepartmentVO d2 = new DepartmentVO();
			DepartmentVO d3 = new DepartmentVO();

			d1.setDepartmentId(1);
			d1.setDepartmentName("Software Engineering");
			d1.setDepartmentAbrev("SE");


			d2.setDepartmentId(2);
			d2.setDepartmentName("Human Resource");
			d2.setDepartmentAbrev("HR");
			
			d3.setDepartmentId(3);
			d3.setDepartmentName("Finance");
			d3.setDepartmentAbrev("FI");

            departmentDAO.save(d1);
            departmentDAO.save(d2);
            departmentDAO.save(d3);


			logger.info("departments added added");
			
        }else{

			logger.trace("Department Seeding Not Required");

        }

   }
   
   private void seedContractType(){

       List<ContractTypeVO> u = (List<ContractTypeVO>) contractTypeDAO.findAll();

	        if(u.isEmpty() == true) {

                    ContractTypeVO c1 = new ContractTypeVO();
                    ContractTypeVO c2 = new ContractTypeVO();
                    ContractTypeVO c3 = new ContractTypeVO();
                    

                    c1.setContractTypeId(1);
                    c1.setDescription("Part time");


                    c2.setContractTypeId(2);
                    c2.setDescription("Permanent");

                    c3.setContractTypeId(3);
                    c3.setDescription("Temporary");


                    contractTypeDAO.save(c1);
                    logger.info("Part time contract added");

                    contractTypeDAO.save(c2);
                    logger.info("Permanent contract added");

                    contractTypeDAO.save(c3);
                    logger.info("Temporary contract added");
            }else{
                    logger.trace("contract Seeding Not Required");
            }
   }
	/*  private void seedEmployeesTable() {
		 
		 EmployeeVO u = userManagementDAO.findEmployeeVOByContactEmail("chr@aos.rw");
	        if(u == null) {
	             EmployeeVO chr = new EmployeeVO();
	             EmployeeVO cfo = new EmployeeVO();
	             EmployeeVO line_manager = new EmployeeVO();
	             EmployeeVO ceo = new EmployeeVO();
	             EmployeeVO employee = new EmployeeVO();
	             
	             chr.setFistName("Jane");
	             chr.setLastName("Doe");
	             chr.setContactEmail("chr@aos.rw");
	             chr.setEncrytedPassword(new BCryptPasswordEncoder().encode("123"));
				 chr.setTitle("CHR");
				 chr.setEnabled(true);
				 
				 cfo.setFistName("Peter");
	             cfo.setLastName("Doe");
	             cfo.setContactEmail("cfo@aos.rw");
	             cfo.setEncrytedPassword(new BCryptPasswordEncoder().encode("123"));
				 cfo.setTitle("CFO");
				 cfo.setEnabled(true);
				 
				 line_manager.setFistName("Gatuza");
	             line_manager.setLastName("Doe");
	             line_manager.setContactEmail("gatuza@aos.rw");
	             line_manager.setEncrytedPassword(new BCryptPasswordEncoder().encode("123"));
				 line_manager.setTitle("LINE_MANAGER");
				 line_manager.setEnabled(true);
				 
				 
				 ceo.setFistName("John");
	             ceo.setLastName("Doe");
	             ceo.setContactEmail("ceo@aos.rw");
	             ceo.setEncrytedPassword(new BCryptPasswordEncoder().encode("123"));
				 ceo.setTitle("CEO");
				 ceo.setEnabled(true);
				 
				 
				 employee.setFistName("Steve");
	             employee.setLastName("Doe");
	             employee.setContactEmail("employee@aos.rw");
	             employee.setEncrytedPassword(new BCryptPasswordEncoder().encode("123"));
				 employee.setTitle("EMPLOYEE");
				 employee.setEnabled(true);
	             
				 
				 userManagementDAO.save(chr);
				 logger.info("CHR Seed Added");
				 
				 userManagementDAO.save(cfo);
				 logger.info("CFO Seed Added");
				 
				 userManagementDAO.save(line_manager);
				 logger.info("Line Manager Seed Added");
				 
				 userManagementDAO.save(ceo);
				 logger.info("CEO seed added");
				 
				 userManagementDAO.save(employee);
				 logger.info("Employee Seed added");
	        
	        } else {
	            logger.trace("Users Seeding Not Required");
	        }
	    } */
	 


}
