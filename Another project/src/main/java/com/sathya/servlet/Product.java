package com.sathya.servlet;
import java.sql.Date;


public class Product 
{
	private String proId;
	private String proName;
	private double proPrice;
	private String proBrand;
	private String proMadein;
	private Date proMfgDate;
	private Date proExpDate;
	private byte[] proImage;
	private byte[] proVideo;
	private byte[] proAudio;
	
	
	
	public byte[] getProVideo() {
		return proVideo;
	}
	public void setProVideo(byte[] proVideo) {
		this.proVideo = proVideo;
	}
	public byte[] getProAudio() {
		return proAudio;
	}
	public void setProAudio(byte[] proAudio) {
		this.proAudio = proAudio;
	}
	public String getProId() {
		return proId;
	}
	public void setProId(String proId) {
		this.proId = proId;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public double getProPrice() {
		return proPrice;
	}
	public void setProPrice(double proPrice) {
		this.proPrice = proPrice;
	}
	public String getProBrand() {
		return proBrand;
	}
	public void setProBrand(String proBrand) {
		this.proBrand = proBrand;
	}
	public String getProMadein() {
		return proMadein;
	}
	public void setProMadein(String proMadein) {
		this.proMadein = proMadein;
	}
	public Date getProMfgDate() {
		return proMfgDate;
	}
	public void setProMfgDate(Date proMfgDate) {
		this.proMfgDate = proMfgDate;
	}
	public Date getProExpDate() {
		return proExpDate;
	}
	public void setProExpDate(Date proExpDate) {
		this.proExpDate = proExpDate;
	}
	public byte[] getProImage() {
		return proImage;
	}
	public void setProImage(byte[] proImage) {
		this.proImage = proImage;
	}
	
	
			
	
}
