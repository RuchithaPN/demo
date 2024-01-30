/*package com.tsv.implementation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tsv.implementation.dao.UserRepository;
import com.tsv.implementation.dto.UserLoginDTO;
import com.tsv.implementation.model.User;
import com.tsv.implementation.service.DefaultUserService;



@Controller
@RequestMapping("/login")
public class LoginController {
	@Autowired
	private DefaultUserService userService;
	
	@Autowired
	UserRepository userRepo;
    
    @ModelAttribute("user")
    public UserLoginDTO userLoginDTO() {
        return new UserLoginDTO();
    }
    
	@GetMapping
	public String login() {
		return "login";
	}
	
	@PostMapping
	public void loginUser(@ModelAttribute("user") 
	UserLoginDTO userLoginDTO) {
		System.out.println("UserDTO"+userLoginDTO);
		 userService.loadUserByUsername(userLoginDTO.getUsername());
	}
	@GetMapping("/otpVerification")
	public String otpSent(Model model,UserLoginDTO userLoginDTO) {
		model.addAttribute("otpValue", userLoginDTO);
		return "otpScreen";
		
	}
	@PostMapping("/otpVerification")
	public String otpVerification(@ModelAttribute("otpValue") UserLoginDTO userLoginDTO) {
		SecurityContext securityContext = SecurityContextHolder.getContext();
		UserDetails user = (UserDetails) securityContext.getAuthentication().getPrincipal();
		User users = userRepo.findByEmail(user.getUsername());
		if(users.getOtp() == userLoginDTO.getOtp())
		return "redirect:/dashboard";
		else
			return "redirect:/login/otpVerification?error";
	}
	
}*/
package com.tsv.implementation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tsv.implementation.dao.UserRepository;
import com.tsv.implementation.dto.UserLoginDTO;
import com.tsv.implementation.model.User;
import com.tsv.implementation.service.DefaultUserService;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private DefaultUserService userService;

    @Autowired
    UserRepository userRepo;

    @PostMapping
    public ResponseEntity<String> loginUser(@RequestBody UserLoginDTO userLoginDTO) {
        System.out.println("UserDTO" + userLoginDTO);
        userService.loadUserByUsername(userLoginDTO.getUsername());
        return ResponseEntity.ok().build(); // Return HTTP 200 OK for successful login
    }

   /*@PostMapping("/otpVerification")
    public ResponseEntity<String> otpVerification(@RequestBody UserLoginDTO userLoginDTO) {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        UserDetails user = (UserDetails) securityContext.getAuthentication().getPrincipal();
        User users = userRepo.findByEmail(user.getUsername());
        if (users.getOtp() == userLoginDTO.getOtp()) {
            return ResponseEntity.ok().build(); // Return HTTP 200 OK for successful OTP verification
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build(); // Return HTTP 401 Unauthorized for unsuccessful OTP verification
        }
    }*/
    @PostMapping("/otpVerification")
    public ResponseEntity<String> otpVerification(@RequestBody UserLoginDTO userLoginDTO) {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        if (authentication.getPrincipal() instanceof UserDetails) {
            UserDetails user = (UserDetails) authentication.getPrincipal();
            User users = userRepo.findByEmail(user.getUsername());
            if (users.getOtp() == userLoginDTO.getOtp()) {
                return ResponseEntity.ok().build(); // Return HTTP 200 OK for successful OTP verification
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build(); // Return HTTP 401 Unauthorized for unsuccessful OTP verification
            }
        } else {
            // Handle the case where the Principal is not a UserDetails object
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // Return HTTP 500 Internal Server Error
        }
    }

}

