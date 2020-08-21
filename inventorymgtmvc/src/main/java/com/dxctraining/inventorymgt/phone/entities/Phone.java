package com.dxctraining.inventorymgt.phone.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.dxctraining.inventorymgt.item.entities.Item;
import com.dxctraining.inventorymgt.supplier.entities.Supplier;

@Entity
@Table(name = "phones")
public class Phone extends Item {
	private String name;

	private int storageSize;
	
	public Phone() {}
	
	public Phone(String name, int storageSize) {
		this.name=name;
		this.storageSize = storageSize;
	}

	public int getStorageSize() {
		return storageSize;
	}

	public void setStorageSize(int storageSize) {
		this.storageSize = storageSize;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Phone that = (Phone) o;
		return that.getId() == this.getId();
	}

	@Override
	public int hashCode() {
		return this.getId();
	}

}
