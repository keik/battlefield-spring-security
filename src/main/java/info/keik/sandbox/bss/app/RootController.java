package info.keik.sandbox.bss.app;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RootController {

	@RequestMapping("/")
	public String root(HttpServletRequest req,
			Principal p1,
			@AuthenticationPrincipal Principal p2,
			Authentication a1,
			@AuthenticationPrincipal Authentication a2
			) {

		// UserDetails from HttpServletRequest
		System.out.println(((UserDetails) ((Authentication) req.getUserPrincipal()).getPrincipal()).getUsername());

		// UserDetails from Implicit Principal argument
		System.out.println(((UserDetails) ((Authentication) p1).getPrincipal()).getUsername());

		// UserDetails from explicit Principal argument
		System.out.println(((UserDetails) ((Authentication) p2).getPrincipal()).getUsername());

		// UserDetails from implicit Authentication argument
		System.out.println(((UserDetails) a1.getPrincipal()).getUsername());

		// UserDetails from explicit Authentication argument
		System.out.println(((UserDetails) a2.getPrincipal()).getUsername());

		// UserDetails from SecurityContextHolder
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		System.out.println(userDetails.getUsername());

		return "index";
	}
}
