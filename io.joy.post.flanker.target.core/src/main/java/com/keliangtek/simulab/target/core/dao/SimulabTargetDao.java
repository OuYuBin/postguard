package com.keliangtek.simulab.target.core.dao;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

//import com.keliangtek.simulab.socket.SimulabSocketCommandResponseType;
//import com.keliangtek.simulab.socket.exception.SimulabConnectionException;
import com.keliangtek.simulab.target.core.models.SimulabTarget;
import com.keliangtek.simulab.target.core.models.SimulabTargetIOCard;
import com.keliangtek.simulab.target.core.models.SimulabTargetInfomation;

/**
 * 下位机目标信息数据存取父对象
 * 
 * @author robin
 *
 */
public class SimulabTargetDao extends AbstractSimulabTargetDao {

	public SimulabTargetDao() {
		super();
	}

//	/**
//	 * 
//	 * @return
//	 * @throws SimulabConnectionException
//	 * @throws IOException
//	 */
//	public synchronized Map<SimulabSocketCommandResponseType, SimulabTarget> getSimulabTargetInfo()
//			throws SimulabConnectionException {
//		Map<SimulabSocketCommandResponseType, SimulabTarget> map = new HashMap<SimulabSocketCommandResponseType, SimulabTarget>();
//		SimulabTarget simulabTarget = null;
//		try {
//			byte[] bytes = simulabDatagramSocketConnection.doReceive();
//			// --获取响应结果状态
//			byte[] cmdTypeBytes = new byte[4];
//			System.arraycopy(bytes, 12, cmdTypeBytes, 0, 4);
//			StringBuilder stringbuilder = new StringBuilder(
//					cmdTypeBytes.length * 2);
//			String tmp = null;
//
//			for (int i = cmdTypeBytes.length; i > 0; i--) {
//				tmp = Integer.toHexString(0xFF & cmdTypeBytes[i - 1]);
//				if (tmp.length() == 1) {
//					tmp = "0" + tmp;
//				}
//				stringbuilder.append(tmp);
//			}
//			//System.out.println("响应类型: " + stringbuilder.toString());
//			for (SimulabSocketCommandResponseType simulabMultiCastCommandResponseType : SimulabSocketCommandResponseType
//					.values()) {
//				if (simulabMultiCastCommandResponseType.getCode().equals(
//						stringbuilder.toString())) {
//					simulabTarget = getSimulabTargetInfo(bytes,
//							simulabMultiCastCommandResponseType);
//					map.put(simulabMultiCastCommandResponseType, simulabTarget);
//					break;
//				}
//			}
//		} catch (IOException e) {
//			throw new SimulabConnectionException(e);
//		}
//		return map;
//	}
//
//	private SimulabTarget getSimulabTargetInfo(byte[] bytes,
//			SimulabSocketCommandResponseType simulabMultiCastCommandResponseType) {
//		SimulabTarget simulabTarget = null;
//		StringBuilder stringbuilder = null;
//		switch (simulabMultiCastCommandResponseType) {
//		case IDE_MULTICAST_SELF_RESPONSE: {
//			// --获取桢体长度
//			byte[] msglengthBytes = new byte[4];
//			System.arraycopy(bytes, 16, msglengthBytes, 0, 4);
//			int msgLength = msglengthBytes[0] & 0xFF
//					| (msglengthBytes[1] & 0xFF) << 8
//					| (msglengthBytes[2] & 0xFF) << 16
//					| (msglengthBytes[3] & 0xFF) << 24;
//			if (msgLength == 6) {
//				// --环回信息
//				simulabTarget = new SimulabTarget();
//				byte[] serialBytes = new byte[1];
//				System.arraycopy(bytes, 32, serialBytes, 0, 1);
//				String serial = new String(serialBytes);
//				byte[] hostBytes = new byte[4];
//				System.arraycopy(bytes, 33, hostBytes, 0, 4);
//				stringbuilder = new StringBuilder();
//				stringbuilder.append(hostBytes[0] & 0xFF);
//				stringbuilder.append(".");
//				stringbuilder.append(hostBytes[1] & 0xFF);
//				stringbuilder.append(".");
//				stringbuilder.append(hostBytes[2] & 0xFF);
//				stringbuilder.append(".");
//				stringbuilder.append(hostBytes[3] & 0xFF);
//				String host = stringbuilder.toString();
//				//System.out.println("Host:-->" + host);
//				simulabTarget.setHost(host);
//				byte[] statusBytes = new byte[1];
//				System.arraycopy(bytes, 37, statusBytes, 0, 1);
//				simulabTarget.setStatus(String.valueOf(statusBytes[0] & 0xFF));
//			}
//		}
//			break;
//		case HEART_BEAT_RESPONSE: {
//			byte[] msglengthBytes = new byte[4];
//			System.arraycopy(bytes, 16, msglengthBytes, 0, 4);
//			int msgLength = msglengthBytes[0] & 0xFF
//					| (msglengthBytes[1] & 0xFF) << 8
//					| (msglengthBytes[2] & 0xFF) << 16
//					| (msglengthBytes[3] & 0xFF) << 24;
//			//System.out.println("接收到的桢长度-->" + msgLength);
//			simulabTarget = new SimulabTarget();
//			simulabTarget.setStatus("1");
//			byte[] serialBytes = new byte[1];
//			System.arraycopy(bytes, 32, serialBytes, 0, 1);
//			// String serial = new String(serialBytes);
//			byte[] hostBytes = new byte[4];
//			System.arraycopy(bytes, 33, hostBytes, 0, 4);
//			stringbuilder = new StringBuilder();
//			stringbuilder.append(hostBytes[0] & 0xFF);
//			stringbuilder.append(".");
//			stringbuilder.append(hostBytes[1] & 0xFF);
//			stringbuilder.append(".");
//			stringbuilder.append(hostBytes[2] & 0xFF);
//			stringbuilder.append(".");
//			stringbuilder.append(hostBytes[3] & 0xFF);
//			String host = stringbuilder.toString();
//			//System.out.println("Host:-->" + host);
//			simulabTarget.setHost(host);
//			byte[] statusBytes = new byte[1];
//			System.arraycopy(bytes, 37, statusBytes, 0, 1);
//			simulabTarget.setStatus(String.valueOf(statusBytes[0] & 0xFF));
//			byte[] numberOfCpuBytes = new byte[4];
//			System.arraycopy(bytes, 38, numberOfCpuBytes, 0, 4);
//			int numberOfCpu = numberOfCpuBytes[0] & 0xFF
//					| (numberOfCpuBytes[1] & 0xFF) << 8
//					| (numberOfCpuBytes[2] & 0xFF) << 16
//					| (numberOfCpuBytes[3] & 0xFF) << 24;
//			//System.out.println("numberOfCpu:-->" + numberOfCpu);
//			simulabTarget.setNumberOfCPU(numberOfCpu);
//			byte[] platformBytes = new byte[32];
//			System.arraycopy(bytes, 42, platformBytes, 0, 32);
//			String platform = new String(platformBytes);
//			simulabTarget.setPlatform(platform);
//			//System.out.println("platform:-->" + platform);
//		}
//			break;
//		case HEART_BEAT_WITH_HARDWARE_RESPONSE: {
//			simulabTarget = new SimulabTarget();
//			simulabTarget.setStatus("1");
//			// --ip地址
//			byte[] ipBytes = new byte[4];
//			stringbuilder = new StringBuilder();
//			System.arraycopy(bytes, 32, ipBytes, 0, 4);
//			stringbuilder.append(ipBytes[0] & 0xFF);
//			stringbuilder.append(".");
//			stringbuilder.append(ipBytes[1] & 0xFF);
//			stringbuilder.append(".");
//			stringbuilder.append(ipBytes[2] & 0xFF);
//			stringbuilder.append(".");
//			stringbuilder.append(ipBytes[3] & 0xFF);
//			String ip = stringbuilder.toString();
//			// System.out.println(ip);
//			simulabTarget.setHost(ip);
//			// --主机名称
//			byte[] nameBytes = new byte[32];
//			System.arraycopy(bytes, 36, nameBytes, 0, 32);
//			try {
//				String name = new String(nameBytes, "UTF-8");
//				//System.out.println("name:" + name);
//			} catch (UnsupportedEncodingException e) {
//				e.printStackTrace();
//			}
//
//			SimulabTargetInfomation simulabTargetInfomation = new SimulabTargetInfomation();
//			byte[] macBytes = new byte[32];
//			System.arraycopy(bytes, 68, macBytes, 0, 32);
//			String mac = new String(macBytes);
//			simulabTargetInfomation.setMac(mac);
//			//System.out.println("mac:" + mac);
//
//			byte[] platformBytes = new byte[32];
//			System.arraycopy(bytes, 100, platformBytes, 0, 32);
//			String platform = new String(platformBytes);
//			simulabTarget.setPlatform(platform);
//			//System.out.println("platform:" + platform);
//			// return simulabTarget;
//			byte[] osVersionBytes = new byte[64];
//			System.arraycopy(bytes, 132, osVersionBytes, 0, 64);
//			String osVersion = new String(osVersionBytes);
//			simulabTargetInfomation.setOsVersion(osVersion);
//			//System.out.println("osVersion:" + osVersion);
//
//			byte[] simulabVersionBytes = new byte[64];
//			System.arraycopy(bytes, 196, simulabVersionBytes, 0, 64);
//			String simulabVersion = new String(simulabVersionBytes);
//			simulabTargetInfomation.setSimulabVersion(simulabVersion);
//			//System.out.println("simulabVersion:" + simulabVersion);
//
//			byte[] sysArchitectureBytes = new byte[32];
//			System.arraycopy(bytes, 260, sysArchitectureBytes, 0, 32);
//			String sysArchitecture = new String(sysArchitectureBytes);
//			simulabTargetInfomation.setSysArchitecture(sysArchitecture);
//			//System.out.println("sysArchitecture:" + sysArchitecture);
//
//			byte[] numberOfCpuBytes = new byte[4];
//			System.arraycopy(bytes, 292, numberOfCpuBytes, 0, 4);
//			int numberOfCpu = numberOfCpuBytes[0] & 0xFF
//					| (numberOfCpuBytes[1] & 0xFF) << 8
//					| (numberOfCpuBytes[2] & 0xFF) << 16
//					| (numberOfCpuBytes[3] & 0xFF) << 24;
//			//System.out.println("numberOfCpu:" + numberOfCpu);
//			simulabTarget.setNumberOfCPU(numberOfCpu);
//
//			byte[] cpuSpeedBytes = new byte[4];
//			System.arraycopy(bytes, 296, cpuSpeedBytes, 0, 4);
//			int cpuSpeed = cpuSpeedBytes[0] & 0xFF
//					| (cpuSpeedBytes[1] & 0xFF) << 8
//					| (cpuSpeedBytes[2] & 0xFF) << 16
//					| (cpuSpeedBytes[3] & 0xFF) << 24;
//			simulabTargetInfomation.setCpuSpeed(cpuSpeed);
//			//System.out.println("cpuSpeed:" + cpuSpeed);
//
//			byte[] freeDiskSpaceBytes = new byte[4];
//			System.arraycopy(bytes, 300, freeDiskSpaceBytes, 0, 4);
//			int freeDiskSpace = freeDiskSpaceBytes[0] & 0xFF
//					| (freeDiskSpaceBytes[1] & 0xFF) << 8
//					| (freeDiskSpaceBytes[2] & 0xFF) << 16
//					| (freeDiskSpaceBytes[3] & 0xFF) << 24;
//			simulabTargetInfomation.setFreeDiskSpace(freeDiskSpace);
//			//System.out.println("freeDiskSpace:" + freeDiskSpace);
//
//			byte[] memoryBytes = new byte[4];
//			System.arraycopy(bytes, 304, memoryBytes, 0, 4);
//			int memory = memoryBytes[0] & 0xFF | (memoryBytes[1] & 0xFF) << 8
//					| (memoryBytes[2] & 0xFF) << 16
//					| (memoryBytes[3] & 0xFF) << 24;
//			simulabTargetInfomation.setMemory(memory);
//			//System.out.println("memory:" + memory);
//
//			byte[] ioCardCountBytes = new byte[4];
//			System.arraycopy(bytes, 308, ioCardCountBytes, 0, 4);
//			int ioCardCount = ioCardCountBytes[0] & 0xFF
//					| (ioCardCountBytes[1] & 0xFF) << 8
//					| (ioCardCountBytes[2] & 0xFF) << 16
//					| (ioCardCountBytes[3] & 0xFF) << 24;
//			simulabTargetInfomation.setIoCardCount(ioCardCount);
//			//System.out.println("ioCardCount:" + ioCardCount);
//			// --守护板卡数量
//			SimulabTargetIOCard[] simulabTargetIOCards = new SimulabTargetIOCard[ioCardCount];
//			// int i = simulabTargetIOCards.length;
//			// --切分集合信息
//			// int ioCardBytesLength = 164;
//			int ioCardBeginOffset = 312;
//			int j = 0;
//			int i = 1;
//			for (SimulabTargetIOCard simulabTargetIOCard : simulabTargetIOCards) {
//				simulabTargetIOCard = new SimulabTargetIOCard();
//				simulabTargetIOCard.setId(i);
//				byte[] vendorIDBytes = new byte[16];
//				System.arraycopy(bytes, ioCardBeginOffset, vendorIDBytes, 0, 16);
//				String venderID = new String(vendorIDBytes);
//				simulabTargetIOCard.setVendorID(venderID);
//
//				ioCardBeginOffset += 16;
//
//				byte[] deviceIDBytes = new byte[16];
//				System.arraycopy(bytes, ioCardBeginOffset, deviceIDBytes, 0, 16);
//				String deviceID = new String(deviceIDBytes);
//				simulabTargetIOCard.setDeviceID(deviceID);
//
//				ioCardBeginOffset += 16;
//
//				byte[] cardNumBytes = new byte[4];
//				System.arraycopy(bytes, ioCardBeginOffset, cardNumBytes, 0, 4);
//				int cardNum = cardNumBytes[0] & 0xFF
//						| (cardNumBytes[1] & 0xFF) << 8
//						| (cardNumBytes[2] & 0xFF) << 16
//						| (cardNumBytes[3] & 0xFF) << 24;
//				simulabTargetIOCard.setCardNum(cardNum);
//
//				ioCardBeginOffset += 4;
//
//				byte[] vendorBytes = new byte[64];
//				System.arraycopy(bytes, ioCardBeginOffset, vendorBytes, 0, 64);
//				String vendor = new String(vendorBytes);
//				simulabTargetIOCard.setVendor(vendor);
//
//				ioCardBeginOffset += 64;
//
//				byte[] deviceBytes = new byte[64];
//				System.arraycopy(bytes, ioCardBeginOffset, deviceBytes, 0, 64);
//				String device = new String(deviceBytes);
//				simulabTargetIOCard.setDevice(device);
//
//				ioCardBeginOffset += 64;
//
//				byte[] descBytes = new byte[128];
//				System.arraycopy(bytes, ioCardBeginOffset, descBytes, 0, 128);
//				String desc = new String(descBytes);
//				simulabTargetIOCard.setDesc(desc);
//				
//				ioCardBeginOffset+=128;
//
//				simulabTargetIOCards[j] = simulabTargetIOCard;
//				++j;
//				++i;
//			}
//			simulabTargetInfomation
//					.setSimulabTargetIOCards(simulabTargetIOCards);
//			simulabTarget.setSimulabTargetInfomation(simulabTargetInfomation);
//		}
//			break;
//		}
//		return simulabTarget;
//	}

}
