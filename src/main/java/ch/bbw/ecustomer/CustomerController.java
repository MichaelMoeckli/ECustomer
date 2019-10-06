package ch.bbw.ecustomer;

import java.io.Serializable;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.annotation.RequestScope;

@Controller
@RequestScope
public class CustomerController implements Serializable {
	private static Logger log = Logger.getLogger(CustomerDao.class.getSimpleName());
	private static final long serialVersionUID = 1L;
	// DAO Implementation
	@Autowired
	private CustomerDao customerDao;

	@PostConstruct
	public void init() {
		// customerDao = new CustomerDao();
		log.info("im init");
	}

	@GetMapping("/customers")
	public String getCustomers(Model model) {
		// List<Customer> customers = null;
		// if (customerDao != null) {
		// customers = customerDao.getCustomers();
		// log.info("getCustomers");
		// }
		//
		// model.addAttribute("customers", customers); // Spring - DI
		model.addAttribute("customers", customerDao.getCustomers()); // Spring - DI
		log.info("hello from Controller - getCustomers");
		return "customers";
	}
}
