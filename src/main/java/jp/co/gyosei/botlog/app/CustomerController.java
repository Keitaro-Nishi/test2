package jp.co.gyosei.botlog.app;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import jp.co.gyosei.botlog.domain.service.CustinfoService;
import jp.co.gyosei.botlog.domain.repository.CustinfoRepository;
import jp.co.gyosei.botlog.domain.form.CustomerForm;



@Controller
public class CustomerController {
	

	
	@Autowired
    CustinfoService custinfoService;
	
	@Autowired
	CustinfoRepository custinfoRepository;
	
	@GetMapping("/Customer")
    public String signup(Model model) {
        model.addAttribute("customerForm", new CustomerForm());
        return "Customer";
    }
	
	@PostMapping("/Customer")
    public String customerPost(Model model, @Valid CustomerForm customerForm, BindingResult bindingResult, HttpServletRequest request) {
		custinfoService.registerCustomer(customerForm.getNo(),customerForm.getCustid(),customerForm.getCustname(),customerForm.getOrgname(),customerForm.getPassword(),"1","USER");
		return "Customer";
	}
	
}

