package com.keliangtek.simulab.target.core.models;

/**
 * 
 * @author robin
 *
 */
public class SimulabTargetIOCard {

	/**
	 * 厂商ID
	 */
	String vendorID;

	/**
	 * 设备ID
	 */
	String deviceID;

	/**
	 * 板卡个数
	 */
	int cardNum;

	/**
	 * 厂商名
	 */
	String vendor;

	/**
	 * 设备名
	 */
	String device;

	/**
	 * 序号
	 */
	int id;
	
	String desc;

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public SimulabTargetIOCard() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVendorID() {
		return vendorID;
	}

	public void setVendorID(String vendorID) {
		this.vendorID = vendorID;
	}

	public String getDeviceID() {
		return deviceID;
	}

	public void setDeviceID(String deviceID) {
		this.deviceID = deviceID;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public int getCardNum() {
		return cardNum;
	}

	public void setCardNum(int cardNum) {
		this.cardNum = cardNum;
	}

}
