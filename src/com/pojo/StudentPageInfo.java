package com.pojo;

import com.utils.PageInfo;

public class StudentPageInfo extends PageInfo<Student> {

	//ѧ������
	private String sname;
	//��ʦ����	
	private String tname;
	
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	@Override
	public String toString() {
		return "StudentPageInfo [sname=" + sname + ", tname=" + tname + "]";
	}
	
}
