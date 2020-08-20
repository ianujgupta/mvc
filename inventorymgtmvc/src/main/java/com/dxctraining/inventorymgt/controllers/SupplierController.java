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
    public void init(){
    
    			System.out.println("******SPrint 1 is working");

    			Item item1 = new Item(11, "iphone");
    			item1 = itemService.addItem(item1);
    			Supplier supplier1 = new Supplier("mohan", item1);
    			supplier1 = supplierService.add(supplier1);

    			Item item2 = new Item(22, "samsung");
    			item2 = itemService.addItem(item2);
    			Supplier supplier2 = new Supplier("sohan", item2);
    			supplier2 = supplierService.add(supplier2);

    			Item item3 = new Item(33, "oneplus");
    			item3 = itemService.addItem(item3);
    			Supplier supplier3 = new Supplier("Rohan", item3);
    			supplier3 = supplierService.add(supplier3);

    			System.out.println("******Sprint 2 is working");

    			Phone phone1 = new Phone(101, "IPhone7+", 64);
    			phone1 = phoneService.add(phone1);
    			Phone phone2 = new Phone(202, "OnePlusNord", 128);
    			phone2 = phoneService.add(phone2);

    			System.out.println("******Sprint 3 is working");

    			Computer computer1 = new Computer(1011, "HP", "512GB");
    			computer1 = computerService.addComputer(computer1);
    			Computer computer2 = new Computer(1012, "LG", "1TB");
    			computer2 = computerService.addComputer(computer2);

    			System.out.println("******Sprint 4 is working");

    		}
    
    	@GetMapping("/profile")
        public ModelAndView employeeDetails(@RequestParam("id")int id){
    		Supplier sup = supplierService.findSupplierById(id);
    	    ModelAndView modelAndView=new ModelAndView("details","supplier",sup);
    	    return modelAndView;
    	}
    	
    	@GetMapping("/listall")
    	public ModelAndView all(){
    		List<Supplier> values = supplierService.allSuppliers();
    		ModelAndView modelAndView = new ModelAndView("list","suppliers",values);
    		return modelAndView;
    		
    	}
    	@GetMapping("/logout")
    	public ModelAndView logout(){
    		ModelAndView modelAndView = new ModelAndView("login");
    		return modelAndView;
    	}
    }
	
