package com.dxctraining.inventorymgt.controllers;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dxctraining.inventorymgt.item.entities.Item;
import com.dxctraining.inventorymgt.item.services.IItemService;
import com.dxctraining.inventorymgt.phone.entities.Phone;
import com.dxctraining.inventorymgt.phone.services.IPhoneService;
import com.dxctraining.inventorymgt.supplier.entities.Supplier;
import com.dxctraining.inventorymgt.supplier.services.ISupplierService;

@Controller
public class PhoneController extends Item {

	@Autowired
	private IPhoneService phoneService;

	@Autowired
	private ISupplierService supplierService;

	@Autowired
	private IItemService itemService;

	@PostConstruct
	public void init() {
/*
		Supplier supplier1 = new Supplier("Anmol", "AAA");
		supplier1 = supplierService.add(supplier1);

		Supplier supplier2 = new Supplier("John", "BBB");
		supplier2 = supplierService.add(supplier2);
*/
		Phone phone1 = new Phone("Samsung note", 12);
		phone1 = (Phone) itemService.addItem(phone1);
		Phone phone2 = new Phone("AMD Nitro 5", 228);
		phone2 = (Phone) itemService.addItem(phone2);

	}

	@GetMapping("/phone")
	public ModelAndView phoneDetails(@RequestParam("id") int id) {
		Phone phone = (Phone) itemService.findItemById(id);
		ModelAndView modelAndView = new ModelAndView("phonedetails", "phone", phone);
		return modelAndView;
	}

	@GetMapping("/allphones")
	public ModelAndView allPhones() {
		List<Phone> values = phoneService.allPhones();
		ModelAndView modelAndView = new ModelAndView("phonelist", "phones", values);
		return modelAndView;
	}

	@GetMapping("/phoneregister")
	public ModelAndView registerphone() {
		ModelAndView mv = new ModelAndView("phoneregister");
		return mv;
	}

	@GetMapping("/phoneprocessregister")
	public ModelAndView processRegister(@RequestParam("name") String name,
			@RequestParam("storageSize") int storageSize) {
		System.out.println("inside processregister method, name=" + name);
		Phone phone = new Phone(name, storageSize);
		phone = (Phone) itemService.addItem(phone);
		ModelAndView mv = new ModelAndView("phonedetails", "phone", phone);
		return mv;
	}
}