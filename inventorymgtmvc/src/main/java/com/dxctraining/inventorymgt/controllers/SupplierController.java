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

	@PostConstruct
	public void init() {

		System.out.println("******SPrint 1 is working");
		Supplier supplier1 = new Supplier("mohan");
		supplier1 = supplierService.add(supplier1);
		Item item1 = new Item("iphone", supplier1);
		item1 = itemService.addItem(item1);

		Supplier supplier2 = new Supplier("sohan");
		supplier2 = supplierService.add(supplier2);
		Item item2 = new Item("samsung", supplier2);
		item2 = itemService.addItem(item2);

		Supplier supplier3 = new Supplier("Rohan");
		supplier3 = supplierService.add(supplier3);
		Item item3 = new Item("oneplus", supplier3);
		item3 = itemService.addItem(item3);

		System.out.println("******Sprint 2 is working");

		Phone phone1 = new Phone("IPhone7+", supplier1, 101);
		phone1 = (Phone) itemService.addItem(phone1);

		Phone phone2 = new Phone("OnePlusNord", supplier2, 103);
		phone2 = (Phone) itemService.addItem(phone2);

		System.out.println("******Sprint 3 is working");

		Computer computer1 = new Computer("HP", supplier3, "512GB");
		computer1 = (Computer) itemService.addItem(computer1);
		Computer computer2 = new Computer("LG", supplier2, "1TB");
		computer2 = (Computer) itemService.addItem(computer2);

		System.out.println("******Sprint 4 is working");

	}

	/*
	 * @GetMapping("/profile") public ModelAndView
	 * supplierDetails(@RequestParam("id")int id){ Supplier sup =
	 * supplierService.findSupplierById(id); ModelAndView modelAndView=new
	 * ModelAndView("details","supplier",sup); return modelAndView; }
	 */
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

	@GetMapping("/supplierslist")
	public ModelAndView allSupliers() {
		List<Supplier> values = supplierService.allSuppliers();
		ModelAndView modelAndView = new ModelAndView("supplierlist", "suppliers", values);
		return modelAndView;

	}

}
