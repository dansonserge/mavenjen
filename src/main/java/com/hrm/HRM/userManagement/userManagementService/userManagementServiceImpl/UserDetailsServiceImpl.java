package com.hrm.HRM.userManagement.userManagementService.userManagementServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hrm.HRM.userManagement.userManagementDAO.UserManagementDAO;
import com.hrm.HRM.userManagement.userManagementVO.EmployeeVO;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
 
    @Autowired
    private UserManagementDAO userManagementDAO;
 
//    @Autowired
//    private TitleDAO titleDAO;
 
    @Override
    public UserDetails loadUserByUsername(String contactEmail) throws UsernameNotFoundException {
    	EmployeeVO appUser = this.userManagementDAO.findEmployeeVOByContactEmail(contactEmail);
 
        if (appUser == null) {
            System.out.println("User not found! " + contactEmail);
            throw new UsernameNotFoundException("User " + contactEmail + " was not found in the database");
        }
 
        System.out.println("Found User: " + appUser);
 
        
//        List<String> titleNames = this.titleDAO.getTitleNames(appUser.getEmployeeId());
 
        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
//        if (titleNames != null) {
//            for (String role : titleNames) {
//              
//                GrantedAuthority authority = new SimpleGrantedAuthority(role);
//                grantList.add(authority);
//            }
//        }
 
        UserDetails userDetails = (UserDetails) new User(appUser.getContactEmail(), //
                appUser.getEncrytedPassword(), grantList);
 
        return userDetails;
    }
}