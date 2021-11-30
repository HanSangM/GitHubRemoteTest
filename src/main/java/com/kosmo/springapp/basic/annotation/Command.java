package com.kosmo.springapp.basic.annotation;

//[스프링에서는 DTO계열 클래스를 커맨드 객체라 한다.]
public class Command {
	/*※
	폼의 파라미터명과 속성(멤버변수)을 일치시켜야한다.
    체크박스 같은 경우는 타입을 String[]해도 무방
	String으로 받는 경우 ,(콤마)구분해서 선택된 모든 값들이
	저장된다.
	 */
	//속성들]
	private String name;
	private String years;
	private String gender;
	private String inters;//혹은 private String[] inters
	private String grade;
	private String self;
	
	//게터 세터
	
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
	public String getInters() {
		return inters;
	}
	public void setInters(String inters) {
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
	
	@Override
	public String toString() {
		return String.format("[이름:%s,나이:%s,성별:%s,관심사항:%s,학력:%s,자기소개:%s]",
				name,years,gender,inters,grade,self);
	}
	
	
	
	
	
	
	
}
