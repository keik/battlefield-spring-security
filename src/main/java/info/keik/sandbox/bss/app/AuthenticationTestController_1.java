package info.keik.sandbox.bss.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/method_authentication_1")
public class AuthenticationTestController_1 {

	@ResponseBody
	@RequestMapping(method = RequestMethod.GET)
	public String get(@RequestParam(value = "a", defaultValue = "", required = false) String a) {
		return "get:" + a;
	}

	@ResponseBody
	@RequestMapping(method = RequestMethod.POST)
	public String post(@RequestParam(value = "a", defaultValue = "", required = false) String a) {
		return "post:" + a;
	}

	@ResponseBody
	@RequestMapping(method = RequestMethod.PUT)
	public String put() {
		return "put";
	}

	@ResponseBody
	@RequestMapping(method = RequestMethod.DELETE)
	public String delete() {
		return "delete";
	}

}
