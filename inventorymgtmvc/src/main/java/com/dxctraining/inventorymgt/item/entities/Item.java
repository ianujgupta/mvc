package com.dxctraining.inventorymgt.item.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.InheritanceType;
import javax.persistence.Inheritance;
//import javax.persistence.OneToMany;
//import javax.persistence.Inheritance;
//import javax.persistence.InheritanceType;
//import javax.persistence.ManyToOne;
import javax.persistence.Table;

//import com.dxctraining.inventorymgt.supplier.entities.Supplier;
@Table(name="items")
@Inheritance(strategy= InheritanceType.JOINED)
@Entity
public class Item {
	@Id
	private int id;
	private String name;
	
	public Item() {}
	
	public Item(int id,String name) {
		this.id=id;
		this.name=name;
	}
	
//	public Supplier getSupplier() {
//		return supplier;
//	}
//
//	public void setSupplier(Supplier supplier) {
//		this.supplier = supplier;
//	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
