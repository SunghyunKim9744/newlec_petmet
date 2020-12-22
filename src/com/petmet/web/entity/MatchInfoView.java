package com.petmet.web.entity;

import java.util.Date;

public class MatchInfoView extends MatchInfo{

	private String name;
	private String kind;
	private int gender;
	private int neut;
	private Date birth;
	private int weight;
	private String content;
	private String character;
	private String files;
	private int masterGender;
	private String address;
	
//				부모		dogId					regPub			content
	public MatchInfoView(int id, Date regDate, int pub, String matchContent,
			String name, String kind, int gender, int neut, Date birth, int weight, String content, String character, String files, int masterGender, String address) {
		super(id, regDate, pub, matchContent);
		this.name = name;
		this.kind = kind;
		this.gender = gender;
		this.neut = neut;
		this.birth = birth;
		this.weight = weight;
		this.content = content;
		this.character = character;
		this.files = files;
		this.masterGender = masterGender;
		this.address = address;
	}
	
	public int getId() {
		return super.getDogId();
	}
	
	public void setId(int dogId) {
		 super.setDogId(dogId);
	}
	
	public int getPub() {
		return super.getRegPub();
	}
	
	public void setPub(int regPub) {
		 super.setRegPub(regPub);
	}
	
	public String getMatchContent() {
		return super.getContent();
	}
	
	public void setMatchContent(String content) {
		 super.setContent(content);
	}
	
	public String getKind() {
		return kind;
	}


	public void setKind(String kind) {
		this.kind = kind;
	}


	public int getGender() {
		return gender;
	}


	public void setGender(int gender) {
		this.gender = gender;
	}


	public int getNeut() {
		return neut;
	}


	public void setNeut(int neut) {
		this.neut = neut;
	}


	public Date getBirth() {
		return birth;
	}


	public void setBirth(Date birth) {
		this.birth = birth;
	}


	public int getWeight() {
		return weight;
	}


	public void setWeight(int weight) {
		this.weight = weight;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getCharacter() {
		return character;
	}


	public void setCharacter(String character) {
		this.character = character;
	}


	public String getFiles() {
		return files;
	}


	public void setFiles(String files) {
		this.files = files;
	}


	public int getMasterGender() {
		return masterGender;
	}


	public void setMasterGender(int masterGender) {
		this.masterGender = masterGender;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "MatchInfoView [name=" + name + ", kind=" + kind + ", gender=" + gender + ", neut=" + neut + ", birth="
				+ birth + ", weight=" + weight + ", content=" + content + ", character=" + character + ", files="
				+ files + ", masterGender=" + masterGender + ", address=" + address + ", toString()=" + super.toString()
				+ "]";
	}
	
	


}
