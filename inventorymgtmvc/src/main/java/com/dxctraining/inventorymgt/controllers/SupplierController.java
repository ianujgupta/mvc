package com.dxctraining.inventorymgt.controllers;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dxctraining.inventorymgt.computer.entities.Computer;
import com.dxctraining.inventorymgt.computer.services.IComputerService;
import com.dxctraining.inventorymgt.item.entities.Item;
import com.dxctraining.inventorymgt.item.services.IItemService;
import com.dxctraining.inventorymgt.phone.entities.Phone;
import com.dxctraining.inventorymgt.phone.services.IPhoneService;
import com.dxctraining.inventorymgt.supplier.dto.SessionData;
import com.dxctraining.inventorymgt.supplier.entities.Supplier;
import com.dxctraining.inventorymgt.supplier.services.ISupplierService;

@Controller
public class SupplierController {

	@Autowired
	private IComputerService computerService;

	@Autowired
	private IPhoneService phoneService;

	@Autowired
	private IItemService itemService;

	@Autowired
	private ISupplierService supplierService;

	@Autowired
	private SessionData sessionData;

	@PostConstruct
	public void init() {

		System.out.println("******SPrint 1 is working");
		Supplier supplier1 = new Supplier("mohan", "11111");
		supplier1 = supplierService.add(supplier1);
		Item item1 = new Item("iphone", supplier1);
		item1 = itemService.addItem(item1);

		Supplier supplier2 = new Supplier("sohan", "22222");
		supplier2 = supplierService.add(supplier2);
		Item item2 = new Item("samsung", supplier2);
		item2 = itemService.addItem(item2);

		Supplier supplier3 = new Supplier("Rohan", "33333");
		supplier3 = supplierService.add(supplier3);
		Item item3 = new Item("oneplus", supplier3);
		item3 = itemService.addItem(item3);

		System.out.println("******Sprint 2 is working");

//		Phone phone1 = new Phone("IPhone7+", supplier1, 101);
//		phone1 = (Phone) itemService.addItem(phone1);
//
//		Phone phone2 = new Phone("OnePlusNord", supplier2, 103);
//		phone2 = (Phone) itemService.addItem(phone2);
//
//		System.out.println("******Sprint 3 is working");
//
//		Computer computer1 = new Computer("HP", supplier3, "512GB");
//		computer1 = (Computer) itemService.addItem(computer1);
//		Computer computer2 = new Computer("LG", supplier2, "1TB");
//		computer2 = (Computer) itemService.addItem(computer2);
//
//		System.out.println("******Sprint 4 is working");

	}
/*
	@GetMapping("/phoneregister")
	public ModelAndView addPhones() {
		ModelAndView modelAndView = new ModelAndView("registerphone");
		return modelAndView;
	}
	
	@GetMapping("/addedphones")
	public ModelAndView phoneRegister(@RequestParam("name") String name, @RequestParam("supplier") Supplier supplier,@RequestParam("storagesize") int storagesize) {
		System.out.println("inside phone register method, name=" + name);
		Phone phone = new Phone(name, supplier,storagesize);
		List <Phone> values = (List<Phone>) itemService.addItem(phone);
		ModelAndView mv = new ModelAndView("addPhones", "phone", values);
		return mv;
	}
*/
	/*
	@GetMapping("/phoneslist")
	public ModelAndView allPhones() {
		List<Phone> values = phoneService.allPhones();
		ModelAndView modelAndView = new ModelAndView("phonelist", "phones", values);
		return modelAndView;
	}

	@GetMapping("/computerslist")
	public ModelAndView allComputers() {
		List<Computer> values = computerService.allComputers();
		ModelAndView modelAndView = new ModelAndView("computerlist", "computers", values);
		return modelAndView;
	}

	@GetMapping("/itemslist")
	public ModelAndView allItems() {
		List<Item> values = itemService.allItems();
		ModelAndView modelAndView = new ModelAndView("itemlist", "items", values);
		return modelAndView;
	}
*/
	@GetMapping("/supplierslist")
	public ModelAndView allSupliers() {
		List<Supplier> values = supplierService.allSuppliers();
		ModelAndView modelAndView = new ModelAndView("supplierlist", "suppliers", values);
		return modelAndView;

	}

	@GetMapping("/supplier")
	public ModelAndView supplierDetails(@RequestParam("id") int id) {
		Supplier supplier = supplierService.findSupplierById(id);
		ModelAndView modelAndView = new ModelAndView("supplierdetails", "supplier", supplier);
		return modelAndView;
	}

	@GetMapping("/register")
	public ModelAndView registerSupplier() {
		ModelAndView mv = new ModelAndView("register");
		return mv;
	}

	@GetMapping("/processregister")
	public ModelAndView processRegister(@RequestParam("name") String name, @RequestParam("password") String password) {
		System.out.println("inside processregister method, name=" + name);
		Supplier supplier = new Supplier(name, password);
		supplier = supplierService.add(supplier);
		ModelAndView mv = new ModelAndView("supplierdetails", "supplier", supplier);
		return mv;
	}

	@GetMapping("/processlogin")
	public ModelAndView processLogin(@RequestParam("id") int id, @RequestParam("password") String password) {
		boolean correct = supplierService.authenticate(id, password);
		if (!correct) {
			ModelAndView modelAndView = new ModelAndView("login");
			return modelAndView;
		}
		sessionData.saveLogin(id);
		Supplier supplier = supplierService.findSupplierById(id);
		ModelAndView mv = new ModelAndView("details", "supplier", supplier);
		return mv;
	}

	@GetMapping("/login")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView("login");
		return mv;
	}

	@GetMapping("/logout")
	public ModelAndView logout() {
		sessionData.clear();
		ModelAndView mv = new ModelAndView("login");
		return mv;
	}

}
