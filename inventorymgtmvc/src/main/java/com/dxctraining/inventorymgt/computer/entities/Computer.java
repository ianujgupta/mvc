package com.dxctraining.inventorymgt.computer.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.dxctraining.inventorymgt.item.entities.Item;

@Entity
@Table(name = "computers")
public class Computer extends Item {

	private String diskSize;

	public Computer(int id, String name, String diskSize) {
		super(id, name);
		this.diskSize = diskSize;
	}

	public String getDiskSize() {
		return diskSize;
	}

	public void setDiskSize(String diskSize) {
		this.diskSize = diskSize;
	}

}
