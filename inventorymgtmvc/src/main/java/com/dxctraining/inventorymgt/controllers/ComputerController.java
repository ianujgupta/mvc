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
import com.dxctraining.inventorymgt.supplier.entities.Supplier;
import com.dxctraining.inventorymgt.supplier.services.ISupplierService;

@Controller
public class ComputerController extends Item{

	@Autowired
	private IComputerService computerService;

	@Autowired
	private ISupplierService supplierService;

	@Autowired 
	private IItemService itemService;
	
	@PostConstruct
	public void init() {

		Supplier supplier1 = new Supplier("Govind", "AAA");
		supplier1 = supplierService.add(supplier1);

		Supplier supplier2 = new Supplier("Tom", "BBB");
		supplier2 = supplierService.add(supplier2);
		
		Computer computer1 = new Computer("HP Elitebook 765","12GB");
		computer1 =(Computer) itemService.addItem(computer1);
		Computer computer2 = new Computer("AMD Nitro 5" ,"228GB");
		computer2 = (Computer)itemService.addItem(computer2);

	}
	@GetMapping("/computer")
	public ModelAndView computerDetails(@RequestParam("id") int id) {
		Computer computer =(Computer) itemService.findItemById(id);
		ModelAndView modelAndView = new ModelAndView("computerdetails", "computer", computer);
		return modelAndView;
	}
	
	@GetMapping("/allcomputers")
	public ModelAndView allComputers() {
		List<Computer> values = computerService.allComputers();
		ModelAndView modelAndView = new ModelAndView("computerlist", "computers", values);
		return modelAndView;
	}
	@GetMapping("/computerregister")
	public ModelAndView registerComputerr() {
		ModelAndView mv = new ModelAndView("computerregister");
		return mv;
	}

	@GetMapping("/computerprocessregister")
	public ModelAndView processRegister(@RequestParam("name") String name, @RequestParam("diskSize") String diskSize) {
		System.out.println("inside processregister method, name=" + name);
		Computer computer = new Computer(name,diskSize);
		computer =(Computer) itemService.addItem(computer);
		ModelAndView mv = new ModelAndView("computerdetails", "computer", computer);
		return mv;
	}
}