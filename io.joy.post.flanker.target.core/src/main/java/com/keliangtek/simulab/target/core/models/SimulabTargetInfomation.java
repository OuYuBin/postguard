package com.keliangtek.simulab.target.core.models;

/**
 * 下位机资源信息
 * 
 * @author robin
 *
 */
public class SimulabTargetInfomation {

	/**
	 * 版本信息
	 */
	String osVersion;

	/**
	 * simulab版本信息
	 */
	String simulabVersion;

	/**
	 * 系统架构
	 */
	String sysArchitecture;

	/**
	 * cpu频率
	 */
	int cpuSpeed;

	/**
	 * 硬盘剩余空间
	 */
	int freeDiskSpace;

	/**
	 * 内存
	 */
	int memory;

	/**
	 * 板卡信息
	 */
	int ioCardCount;

	/**
	 * 厂商ID
	 */
	String vendorID;

	/**
	 * 设备ID
	 */
	String deviceID;

	/**
	 * 厂商名
	 */
	String vendor;

	/**
	 * 设备名
	 */
	String device;

	/**
	 * mac地址
	 */
	String mac;

	/**
	 * 板卡信息集合
	 */
	SimulabTargetIOCard[] simulabTargetIOCards;
	
	
	public SimulabTargetInfomation(){
		
	}

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	public String getOsVersion() {
		return osVersion;
	}

	public void setOsVersion(String osVersion) {
		this.osVersion = osVersion;
	}

	public String getSimulabVersion() {
		return simulabVersion;
	}

	public void setSimulabVersion(String simulabVersion) {
		this.simulabVersion = simulabVersion;
	}

	public String getSysArchitecture() {
		return sysArchitecture;
	}

	public void setSysArchitecture(String sysArchitecture) {
		this.sysArchitecture = sysArchitecture;
	}

	public int getCpuSpeed() {
		return cpuSpeed;
	}

	public void setCpuSpeed(int cpuSpeed) {
		this.cpuSpeed = cpuSpeed;
	}

	public int getFreeDiskSpace() {
		return freeDiskSpace;
	}

	public void setFreeDiskSpace(int freeDiskSpace) {
		this.freeDiskSpace = freeDiskSpace;
	}

	public int getMemory() {
		return memory;
	}

	public void setMemory(int memory) {
		this.memory = memory;
	}

	public int getIoCardCount() {
		return ioCardCount;
	}

	public void setIoCardCount(int ioCardCount) {
		this.ioCardCount = ioCardCount;
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

	public SimulabTargetIOCard[] getSimulabTargetIOCards() {
		return simulabTargetIOCards;
	}

	public void setSimulabTargetIOCards(
			SimulabTargetIOCard[] simulabTargetIOCards) {
		this.simulabTargetIOCards = simulabTargetIOCards;
	}

}
