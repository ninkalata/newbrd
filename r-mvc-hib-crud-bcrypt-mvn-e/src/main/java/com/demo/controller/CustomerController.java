
package com.demo.controller;

import java.util.List;

import javax.security.auth.login.Configuration;
import javax.validation.Valid;
import java.util.Date;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.entity.Customer;
import com.demo.service.CustomerService;


@Controller
@RequestMapping("/customer")
public class CustomerController {


	@Autowired
	private CustomerService customerService;
@InitBinder
public void initBinder(WebDataBinder dataBinder)
{
	StringTrimmerEditor ste = new StringTrimmerEditor(true);
	dataBinder.registerCustomEditor(String.class,ste);
}

	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		theModel.addAttribute("customer", new Customer());
		// get customers from the service
		List<Customer> theCustomers = customerService.getCustomers();

		// add the customers to the model
		theModel.addAttribute("customers", theCustomers);

		return "list-customers";
	}

	@GetMapping("/showFormForAdd")

	public String showFormForAdd(Model theModel) {
		
		// create model 
		Customer theCustomer = new Customer();
	

		theModel.addAttribute("customer", theCustomer);

		return "customer-form";
	}

	@PostMapping("/saveCustomer")
	public String saveCustomer(@Valid @ModelAttribute("customer") Customer theCustomer ,BindingResult result) {

		if(result.hasErrors()) {
			return "customer-form";
		}
		else
		{
			// save the customer using our service
			customerService.saveCustomer(theCustomer);
		    return "redirect:/customer/list";
	}
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerCode") int thecode, Model theModel) {

		// get the customer from our service
		Customer theCustomer = customerService.getCustomer(thecode);


		// set customer as a model attribute to pre-populate the form
		theModel.addAttribute("customer", theCustomer);

		// send over to form
		return "customer-form";
	}

	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerCode") int thecode) {

		// delete the customer
		customerService.deleteCustomer(thecode);
		
		return "redirect:/customer/list";
	}

}
