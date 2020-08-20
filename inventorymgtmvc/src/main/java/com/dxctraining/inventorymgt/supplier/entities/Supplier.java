package com.dxctraining.inventorymgt.supplier.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.dxctraining.inventorymgt.item.entities.Item;

@Entity
@Table(name = "suppliers")
public class Supplier {

	@Id
	@GeneratedValue
	private int id;
	private String name;
	
	@ManyToOne
	private Item item;

	public Supplier(String name, Item item) {
		this.name = name;
		this.item = item;
	}
	
	public Supplier(){}

	@Override
	public int hashCode() {
		return id;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Supplier that = (Supplier) o;
		return id == that.id;

	}

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