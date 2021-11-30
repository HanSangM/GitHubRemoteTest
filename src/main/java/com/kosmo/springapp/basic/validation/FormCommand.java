package com.kosmo.springapp.basic.validation;

public class FormCommand {
	//폼의 파라미터명과 같게 속성(멤버변수) 정의]
	private String name;
	private String years;//나이는 int로 해도되지만 String으로 하면 더 편하다.
	private String gender;
	private String[] inters;
	private String grade;
	private String self;
	
	//게터 / 세터]
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getYears() {
		return years;
	}
	public void setYears(String years) {
		this.years = years;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String[] getInters() {
		return inters;
	}
	public void setInters(String[] inters) {
		this.inters = inters;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getSelf() {
		return self;
	}
	public void setSelf(String self) {
		this.self = self;
	}
	
	
	
	
	
}
