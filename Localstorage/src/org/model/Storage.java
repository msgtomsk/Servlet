package org.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Storage_tbl")
public class Storage {
	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "data")	
	private String data;

	public Storage() {
		super();
		// TODO Auto-generated constructor stub
	}	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
}