package ducdmd.testing;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/SpringMVCTest")
public class SpringMVCTest {
	@RequestMapping("/welcome")
	public String showPage() {
		return "test/welcome";
	}
}
