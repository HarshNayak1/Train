package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Train {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int tid;
	
	
	private  String tname;
	
	private String tsource;
	private String tdest;
	private float tprice;
	private String tarrival;
	private String tdept;
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getTsource() {
		return tsource;
	}
	public void setTsource(String tsource) {
		this.tsource = tsource;
	}
	public String getTdest() {
		return tdest;
	}
	public void setTdest(String tdest) {
		this.tdest = tdest;
	}
	public float getTprice() {
		return tprice;
	}
	public void setTprice(float tprice) {
		this.tprice = tprice;
	}
	public String getTarrival() {
		return tarrival;
	}
	public void setTarrival(String tarrival) {
		this.tarrival = tarrival;
	}
	public String getTdept() {
		return tdept;
	}
	public void setTdept(String tdept) {
		this.tdept = tdept;
	}
	@Override
	public String toString() {
		return "Train [tid=" + tid + ", tname=" + tname + ", tsource=" + tsource + ", tdest=" + tdest + ", tprice="
				+ tprice + ", tarrival=" + tarrival + ", tdept=" + tdept + "]";
	}
	
}