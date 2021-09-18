package com.keliangtek.simulab.target.core.services;

import com.keliangtek.simulab.target.core.models.ISimulabTarget;

/**
 * 
 * @author robin
 *
 */
public class TargetDetectService 
//implements ITargetDetectService,
//		ISimulabTargetVistor 
{
	//SimulabDatagramSocketConnection simulabDatagramSocketConnection;

	public TargetDetectService() {
//		this.simulabDatagramSocketConnection = SimulabDatagramManager
//				.getInstance().getSendSimulabDatagramSocketConnection();
	}

//	/**
//	 * 检测请求
//	 */
//	@Override
//	public void detectRequest() {
//		ScheduledFuture future=SimulabTargetConnectionManager.getInstance().getSendExecute()
//				.scheduleWithFixedDelay((new Runnable() {
//
//					@Override
//					public void run() {
//						SimulabTargetResourceManager
//								.getInstance()
//								.getSimulabTargetTopology()
//								.getSimulabTargets()
//								.stream()
//								.filter(simulabTarget -> !simulabTarget
//										.getHost().equals("127.0.0.1"))
//								.forEach(
//										simulabTarget -> {
//											String ip = simulabTarget.getHost();
//											byte[] bytes = new byte[6];
//											bytes[0] = Integer.valueOf(0)
//													.byteValue();
//											bytes[1] = Integer.valueOf(
//													ip.split("\\.")[0])
//													.byteValue();
//											bytes[2] = Integer.valueOf(
//													ip.split("\\.")[1])
//													.byteValue();
//											bytes[3] = Integer.valueOf(
//													ip.split("\\.")[2])
//													.byteValue();
//											bytes[4] = Integer.valueOf(
//													ip.split("\\.")[3])
//													.byteValue();
//											bytes[5] = new Byte(String
//													.valueOf("1"));
//											try {
//												simulabDatagramSocketConnection
//														.doSend(SimulabSocketCommandRequestType.HEART_BEAT_REQUEST,
//																ip, bytes);
//											} catch (Exception e) {
//												e.printStackTrace();
//											}
//										});
//					}
//				}), 0, 500, TimeUnit.MILLISECONDS);
//
//	}
//
//	/**
//	 * 检测回应
//	 */
//	@Override
//	public void detectResponse() {
//		SimulabTargetConnectionManager.getInstance().getReceiveExecute()
//				.scheduleWithFixedDelay(new Runnable() {
//
//					@Override
//					public void run() {
//						Map<SimulabSocketCommandResponseType, SimulabTarget> map = new HashMap<SimulabSocketCommandResponseType, SimulabTarget>();
//						SimulabTargetDao simulabTargetDao = new SimulabTargetDao();
//						try {
//							map = simulabTargetDao.getSimulabTargetInfo();
//						} catch (SimulabConnectionException e) {
//							// --组播服务异常,下位机全部下线
//							List<ISimulabTarget> targets = SimulabTargetCore
//									.loadSimulabTargetTopology()
//									.getSimulabTargets()
//									.stream()
//									.filter(target -> !target.getHost().equals(
//											"127.0.0.1"))
//									.collect(Collectors.toList());
//							targets.forEach(target -> {
//								target.setStatus("0");
//								SimulabTargetResourceManager.getInstance()
//										.chageTargetStatus(target);
//							});
//							e.printStackTrace();
//						}
//
//						for (Iterator<Entry<SimulabSocketCommandResponseType, SimulabTarget>> iter = map
//								.entrySet().iterator(); iter.hasNext();) {
//							Map.Entry<SimulabSocketCommandResponseType, SimulabTarget> entry = iter
//									.next();
//							SimulabSocketCommandResponseType simulabMultiCastCommandResponseType = entry
//									.getKey();
//							switch (simulabMultiCastCommandResponseType) {
//							case IDE_MULTICAST_SELF_RESPONSE:
//								if (entry.getValue() != null) {
//									SimulabTarget simulabTarget = entry
//											.getValue();
//									Map<Boolean, List<ISimulabTarget>> targets = SimulabTargetCore
//											.loadSimulabTargetTopology()
//											.getSimulabTargets()
//											.stream()
//											.collect(
//													Collectors
//															.partitioningBy(target -> target
//																	.getHost()
//																	.equals(simulabTarget
//																			.getHost())));
//									targets.get(true)
//											.forEach(
//													target -> {
//														if (target
//																.getStatusTimer() > TARGET_OFFLINE_CHECK_COUNT) {
//															target.setStatus("0");
//															target.setPlatform(null);
//															target.setNumberOfCPU(0);
//															SimulabTargetResourceManager
//																	.getInstance()
//																	.chageTargetStatus(
//																			target);
//														} else {
//															target.accept(TargetDetectService.this);
//														}
//													});
//
//								}
//								break;
//							case HEART_BEAT_RESPONSE:
//								if (entry.getValue() != null) {
//									SimulabTarget simulabTarget = entry
//											.getValue();
//									String targetStatus = simulabTarget
//											.getStatus();
//									Map<Boolean, List<ISimulabTarget>> targets = SimulabTargetCore
//											.loadSimulabTargetTopology()
//											.getSimulabTargets()
//											.stream()
//											.collect(
//													Collectors
//															.partitioningBy(target -> target
//																	.getHost()
//																	.equals(simulabTarget
//																			.getHost())));
//									targets.get(true).forEach(target -> {
//										// --状态定时器清除
//											target.setStatusTimer(0);
//											target.setStatus(targetStatus);
//											target.setPlatform(simulabTarget
//													.getPlatform());
//											target.setNumberOfCPU(simulabTarget
//													.getNumberOfCPU());
//											SimulabTargetResourceManager
//													.getInstance()
//													.chageTargetStatus(target);
//										});
//									targets.get(false)
//											.forEach(
//													target -> {
//														if (target
//																.getStatusTimer() > TARGET_OFFLINE_CHECK_COUNT) {
//															target.setStatus("0");
//															target.setPlatform(null);
//															target.setNumberOfCPU(0);
//															SimulabTargetResourceManager
//																	.getInstance()
//																	.chageTargetStatus(
//																			target);
//														} else {
//															target.accept(TargetDetectService.this);
//														}
//													});
//								}
//
//								break;
//							case HEART_BEAT_WITH_HARDWARE_RESPONSE:
//								if (entry.getValue() != null) {
//									SimulabTarget simulabTarget = entry
//											.getValue();
//									SimulabTargetResourceManager.getInstance()
//											.chageTargetStatus(simulabTarget);
//								}
//								break;
//							}
//
//						}
//					}
//				}, 0, 100, TimeUnit.MILLISECONDS);

//	}

//	@Override
//	public void vist(ISimulabTarget simulabTarget) {
//		int currentStautsTimer = simulabTarget.getStatusTimer();
//		simulabTarget.setStatusTimer(++currentStautsTimer);
//	}

}
