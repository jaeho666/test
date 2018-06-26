package com.nkia.xeus.entity.billing.charge;

import java.util.List;

public class BillChargeSimulationVO {
	public String cntrCd;  //�����ڵ�   //�ʼ�
	public String vtrlCd; 	//����ȭ�ڵ�  //�ʼ�
	public String afltCd; 	//���� �ڵ� //�ʼ�
	public String osCd; 	//osCd  	 //�ʼ�
	
	
	public double 	coreCnt; 		//����(����������/DR) core ����  -- SW���̼��� ���� ��ȸ�ô� �ʼ�
	public long 	cpuCnt; 		//����(����������/DR) CPU ����(default : 2)   -- SW���̼��� ���� ��ȸ�ô� �ʼ� 
	public double	memSz; 			//����(����������/DR) memory ������
	
	public long 	osLocDskSz; 	//���������� LOCAL ��ũ OS�� ��ũ
	public long 	dataLocDskSz; 	//���������� LOCAL ��ũ DATA �� ��ũ
	public long 	osDskSz;		//���������� VNX OS ��ũ         		
	public long 	dataDskSz;		//���������� VNX DATA ��ũ 
	public long 	osV7000Sz;		//���������� V7000 OS ��ũ 
	public long 	dataV7000Sz;	//���������� V7000 DATA ��ũ
	public long 	osVmaxSz;		//���������� VMAX OS ��ũ
	public long 	dataVmaxSz;		//���������� VMAX DAT ��ũ
	public boolean isHa;			//���������� HA ���� 	
	
	public long 	osEioSz  ;  	//DR  OS ��ũ ������
	public long 	unixDiskSz; 	//DR  UNIX �� ������ disk - VMAX
	public long 	vCloudDiskSz; 	//DR  X86�� ������ disk - VNX
	public long 	exaDiskSz; 		//����(����������/DR) exa disk  ������  
	public long 	pubNasSz; 		//DR ���NAS ������
	public long 	realTimeSz; 	//DR �ǽð�����������
	public long 	symantecBackupSz;	//DR �һ������
	
	public boolean isTcpIpOs;  	//DR ���Ͱ� ȸ�� �ǽð�DR ���
	public long 	tcpIpNasSz;  	//DR ���Ͱ� ȸ�� NAS ����
	public long 	tcpIpAdgSz;  	//DR ���Ͱ� ȸ�� ADG 
	public long 	tcpIpArkSz;  	//DR ���Ͱ� ȸ�� ARK\
	public long 	tcpIpFcSz;  	//DR ���Ͱ� ȸ�� �ǽð����� -FC
	public boolean isTcpIpInternet;//DR ���Ͱ� ȸ�� ���ͳ� 
	public long 	tcpIpBackupSz; 	//DR ���Ͱ� ȸ�� �һ�
	
	public boolean isNwNetwork; 	//DR ����Ʈ��ũ ��Ʈ��ũ
	public boolean isNwSecurity; 	//DR ����Ʈ��ũ  ����
	public boolean isNwSan; 		//DR ����Ʈ��ũ �����
	
	public long 	nutanixOsDskSz;		//����������/DR Nutanix OS ��ũ         		
	public long 	nutanixDataDskSz;		//����������/DR Nutanix DATA ��ũ
	
	public List<ActSvcUseDtlVO> swDtl;  //����(����������/DR) option�ڵ常 �����ϸ� �˴ϴ�.  mmExcptAmt�� ���ݾ� ���� 
	
	// ���ϰ� ����
	//�ش� ���� ����
	public long 	cpuPrice;		//CPU ����	
	public long 	cpuUnitPrice; 	//CPU �ܰ�
	public String 	cpuErrMsg;		//���� �޼���
	
	public long 	memPrice;		//�޸� ���� 
	public long 	memUnitPrice;	//�޸� �ܰ�
	public String 	memErrMsg;		//���� �޼���
	
	public long 	osLocDskPrice;		//���������� LOCAL ��ũ OS�� ��ũ ����
	public long 	osLocDskUnitPrice;	//���������� LOCAL ��ũ OS�� ��ũ �ܰ�
	public long 	osLocDskValUnit;	//���������� LOCAL ��ũ OS�� ��ũ ��� ����	
	public String 	osLocDskErrMsg; 	//���������� LOCAL ��ũ OS�� ��ũ �����޼���	
	
	public long 	dataLocDskPrice;	//���������� LOCAL ��ũ �����Ϳ� ��ũ ����
	public long 	dataLocDskUnitPrice;//���������� LOCAL ��ũ �����Ϳ� ��ũ �ܰ�
	public long 	dataLocDskValUnit;//���������� LOCAL ��ũ �����Ϳ� ��ũ ��ݴ���
	public String 	dataLocDskErrMsg; 	//���������� LOCAL ��ũ �����Ϳ� ��ũ �����޼���
	
	
	public long 	osDskPrice;			//���������� VNX OS ��ũ ����      		
	public long 	osDskUnitPrice;		//���������� VNX OS ��ũ �ܰ�
	public long 	osDskValUnit;		//���������� VNX OS ��ũ ��� ����
	public String 	osDskErrMsg;		//���������� VNX OS ��ũ �����޼���
	
	public long 	dataDskPrice;		//���������� VNX DATA ��ũ ����
	public long 	dataDskUnitPrice;	//���������� VNX DATA ��ũ �ܰ�
	public long 	dataDskValUnit;		//���������� VNX DATA ��ũ ��� ����
	public String 	dataDskErrMsg;		//���������� VNX DATA ��ũ �����޼���
	
	public long 	osV7000Price;		//���������� V7000 OS ��ũ ���� 
	public long 	osV7000UnitPrice;	//���������� V7000 OS ��ũ �ܰ�
	public long 	osV7000ValUnit;		//���������� V7000 OS ��ũ ��� ����
	public String 	osV7000ErrMsg;		//���������� V7000 OS ��ũ �����޼���
	
	public long 	dataV7000Price;		//���������� V7000 DATA ��ũ ���� 
	public long 	dataV7000UnitPrice;	//���������� V7000 DATA ��ũ �ܰ� 
	public long 	dataV7000ValUnit;	//���������� V7000 DATA ��ũ ��� ����
	public String 	dataV7000ErrMsg;	//���������� V7000 DATA ��ũ �����޼��� 
	
	public long 	osVmaxPrice;		//���������� VMAX OS ��ũ ����
	public long 	osVmaxUnitPrice;	//���������� VMAX OS ��ũ �ܰ�
	public long 	osVmaxValUnit;		//���������� VMAX OS ��ũ ��� ����
	public String 	osVmaxErrMsg;		//���������� VMAX OS ��ũ �����޼���
	
	public long 	dataVmaxPrice;		//���������� VMAX DATA ��ũ ����
	public long 	dataVmaxUnitPrice;	//���������� VMAX DATA ��ũ �ܰ�
	public long 	dataVmaxValUnit;	//���������� VMAX DATA ��ũ ��� ����
	public String 	dataVmaxErrMsg;		//���������� VMAX DATA ��ũ �����޼���
	
	public long 	haPrice;			//���������� HA ���� ���� 
	public long 	haUnitPrice;		//���������� HA ���� �ܰ�
	public String 	haErrMsg;			//���������� HA ���� �����޼���
	
	public long 	dataDiskTot;		//��ũ �� �뷮
	
	public long		osEioPrice;			//DR OS ��ũ ����
	public long 	osEioUnitPrice;		//DR OS ��ũ �ܰ�
	public long 	osEioValUnit;		//DR OS ��ũ ��� ����
	public String 	osEioErrMsg; 		//DR OS ��ũ �����޼���
	
	public long		unixDiskPrice;		//DR UNIX �� ������ ��ũ(VMAX) ����	
	public long 	unixDiskUnitPrice;	//DR UNIX �� ������ ��ũ(VMAX) �ܰ� 
	public long 	unixDiskValUnit;	//DR UNIX �� ������ ��ũ(VMAX) ��� ���� 
	public String 	unixDiskErrMsg; 	//DR UNIX �� ������ ��ũ(VMAX) �����޼���
	
	public long		vCloudDiskPrice;	//DR X86�� ������ ��ũ(VNX) ����	
	public long 	vCloudDiskUnitPrice;//DR X86�� ������ ��ũ(VNX) �ܰ� 
	public long 	vCloudDiskValUnit;	//DR X86�� ������ ��ũ(VNX) ��� ���� 
	public String 	vCloudDiskErrMsg; 	//DR X86�� ������ ��ũ(VNX) �����޼���
	
	public long 	exaDiskPrice; 		//����(����������/DR) exa ��ũ ����
	public long 	exaDiskUnitPrice;	//����(����������/DR) exa ��ũ �ܰ�
	public long 	exaDiskValUnit;		//����(����������/DR) exa ��ũ ��� ����
	public String 	exaDiskErrMsg; 		//����(����������/DR) exa ��ũ �����޼���
	
	public long 	pubNasPrice;		//DR ���NAS ����
	public long 	pubNasUnitPrice;	//DR ���NAS �ܰ�
	public String 	pubNasErrMsg;		//DR ���NAS �����޼���
	
	public long 	realTimePrice;		//DR �ǽð����� ����
	public long 	realTimeUnitPrice;	//DR �ǽð����� �ܰ� 
	public String 	realTimeErrMsg;		//DR �ǽð����� �����޼��� 
	
	public long 	symantecBackupPrice;	//DR �һ갡��
	public long 	symantecBackupUnitPrice;//DR �һ�ܰ�
	public String 	symantecBackupErrMsg;	//DR �һ꿡���޼���

	public long 	tcpIpOsPrice;		//DR ���Ͱ� ȸ��  �ǽð�DR ��� ����
	public long 	tcpIpOsUnitPrice;	//DR ���Ͱ� ȸ��  �ǽð�DR ��� �ܰ�
	public String 	tcpIpOsErrMsg;		//DR ���Ͱ� ȸ��  �ǽð�DR ��� �����޼���
	
	public long 	tcpIpNasPrice;		//DR ���Ͱ� ȸ�� NAS ���� ����
	public long 	tcpIpNasUnitPrice;	//DR ���Ͱ� ȸ�� NAS ���� �ܰ�
	public String 	tcpIpNasErrMsg;		//DR ���Ͱ� ȸ�� NAS ���� �����޼���
	
	public long 	tcpIpAdgPrice;		//DR ���Ͱ� ȸ�� ADG ����	
	public long 	tcpIpAdgUnitPrice;	//DR ���Ͱ� ȸ�� ADG �ܰ�
	public String 	tcpIpAdgErrMsg;		//DR ���Ͱ� ȸ�� ADG �����޼���
	
	public long 	tcpIpArkPrice;		//DR ���Ͱ� ȸ�� ARK ����	
	public long 	tcpIpArkUnitPrice;	//DR ���Ͱ� ȸ�� ARK �ܰ�
	public String 	tcpIpArkErrMsg;		//DR ���Ͱ� ȸ�� ARK �����޼���
	
	public long 	tcpIpFcPrice;		//DR ���Ͱ� ȸ�� -�ǽð����� ����
	public long 	tcpIpFcUnitPrice;   //DR ���Ͱ� ȸ�� -�ǽð����� �ܰ�
	public String 	tcpIpFcErrMsg;		//DR ���Ͱ� ȸ�� -�ǽð����� �����޼��� 
	
	
	public long 	tcpIpInternetPrice;		//DR ���Ͱ� ȸ�����ͳ� ���� 
	public long 	tcpIpInternetUnitPrice;	//DR ���Ͱ� ȸ�����ͳ� �ܰ�
	public String 	tcpIpInternetErrMsg;	//DR ���Ͱ� ȸ�����ͳ� �����޼���
	
	public long 	tcpIpBackupPrice;		//DR ���Ͱ� ȸ��-�һ� ����
	public long 	tcpIpBackupUnitPrice;	//DR ���Ͱ� ȸ��-�һ� �ܰ�
	public String 	tcpIpBackupErrMsg;		//DR ���Ͱ� ȸ��-�һ� �����޼���
	
	
	public long 	nwNetworkPrice;			//DR ����Ʈ��ũ ��Ʈ��ũ ����
	public long 	nwNetworkUnitPrice;		//DR ����Ʈ��ũ ��Ʈ��ũ �ܰ�
	public String 	nwNetworkErrMsg;		//DR ����Ʈ��ũ ��Ʈ��ũ �����޼���
	
	public long 	nwSecurityPrice;		//DR ����Ʈ��ũ ���� ����
	public long 	nwSecurityUnitPrice;	//DR ����Ʈ��ũ ���� �ܰ�
	public String 	nwSecurityErrMsg;		//DR ����Ʈ��ũ ���� �����޼���
	
	public long 	nwSanPrice;				//DR ����Ʈ��ũ ��Ʈ��ũ/���� ����� ����
	public long 	nwSanUnitPrice;			//DR ����Ʈ��ũ ��Ʈ��ũ/���� ����� �ܰ� 
	public String 	nwSanErrMsg;			//DR ����Ʈ��ũ ��Ʈ��ũ/���� ����� �����޼���	
	
	public long 	swTotPrice;				//SW ��ü����			
	public long 	totAmt;					//��ü ����
	
	public long 	nutanixOsDskPrice;		//����������/DR Nutanix ��ũ OS�� ��ũ ����
	public long 	nutanixOsDskUnitPrice;	//����������/DR Nutanix ��ũ OS�� ��ũ �ܰ�
	public long 	nutanixOsDskValUnit;	//����������/DR Nutanix ��ũ OS�� ��ũ ��� ����
	public String 	nutanixOsDskErrMsg; 	//����������/DR Nutanix ��ũ OS�� ��ũ �����޼���
	
	public long 	nutanixDataDskPrice;	//����������/DR Nutanix ��ũ �����Ϳ� ��ũ ����
	public long 	nutanixDataDskUnitPrice;//����������/DR Nutanix ��ũ �����Ϳ� ��ũ �ܰ�
	public long 	nutanixDataDskValUnit;	//����������/DR Nutanix ��ũ �����Ϳ� ��ũ ��� ����
	public String 	nutanixDataDskErrMsg; 	//����������/DR Nutanix ��ũ �����Ϳ� ��ũ �����޼���
	
	
	/**
	 * @return the tcpIpAdgSz
	 */
	public long getTcpIpAdgSz() {
		return tcpIpAdgSz;
	}

	/**
	 * @param tcpIpAdgSz the tcpIpAdgSz to set
	 */
	public void setTcpIpAdgSz(long tcpIpAdgSz) {
		this.tcpIpAdgSz = tcpIpAdgSz;
	}

	/**
	 * @return the tcpIpArkSz
	 */
	public long getTcpIpArkSz() {
		return tcpIpArkSz;
	}

	/**
	 * @param tcpIpArkSz the tcpIpArkSz to set
	 */
	public void setTcpIpArkSz(long tcpIpArkSz) {
		this.tcpIpArkSz = tcpIpArkSz;
	}

	

	/**
	 * @return the unixDiskSz
	 */
	public long getUnixDiskSz() {
		return unixDiskSz;
	}

	/**
	 * @param unixDiskSz the unixDiskSz to set
	 */
	public void setUnixDiskSz(long unixDiskSz) {
		this.unixDiskSz = unixDiskSz;
	}

	/**
	 * @return the vCloudDiskSz
	 */
	public long getvCloudDiskSz() {
		return vCloudDiskSz;
	}

	/**
	 * @param vCloudDiskSz the vCloudDiskSz to set
	 */
	public void setvCloudDiskSz(long vCloudDiskSz) {
		this.vCloudDiskSz = vCloudDiskSz;
	}

	/**
	 * @return the tcpIpNasSz
	 */
	public long getTcpIpNasSz() {
		return tcpIpNasSz;
	}

	/**
	 * @param tcpIpNasSz the tcpIpNasSz to set
	 */
	public void setTcpIpNasSz(long tcpIpNasSz) {
		this.tcpIpNasSz = tcpIpNasSz;
	}

	

	/**
	 * @return the tcpIpFcSz
	 */
	public long getTcpIpFcSz() {
		return tcpIpFcSz;
	}

	/**
	 * @param tcpIpFcSz the tcpIpFcSz to set
	 */
	public void setTcpIpFcSz(long tcpIpFcSz) {
		this.tcpIpFcSz = tcpIpFcSz;
	}

	/**
	 * @return the isTcpIpInternet
	 */
	public boolean isTcpIpInternet() {
		return isTcpIpInternet;
	}

	/**
	 * @param isTcpIpInternet the isTcpIpInternet to set
	 */
	public void setTcpIpInternet(boolean isTcpIpInternet) {
		this.isTcpIpInternet = isTcpIpInternet;
	}

	/**
	 * @return the tcpIpBackupSz
	 */
	public long getTcpIpBackupSz() {
		return tcpIpBackupSz;
	}

	/**
	 * @param tcpIpBackupSz the tcpIpBackupSz to set
	 */
	public void setTcpIpBackupSz(long tcpIpBackupSz) {
		this.tcpIpBackupSz = tcpIpBackupSz;
	}

	/**
	 * @return the isNwNetwork
	 */
	public boolean isNwNetwork() {
		return isNwNetwork;
	}

	/**
	 * @param isNwNetwork the isNwNetwork to set
	 */
	public void setNwNetwork(boolean isNwNetwork) {
		this.isNwNetwork = isNwNetwork;
	}

	/**
	 * @return the unixDiskPrice
	 */
	public long getUnixDiskPrice() {
		return unixDiskPrice;
	}

	/**
	 * @param unixDiskPrice the unixDiskPrice to set
	 */
	public void setUnixDiskPrice(long unixDiskPrice) {
		this.unixDiskPrice = unixDiskPrice;
	}

	/**
	 * @return the unixDiskUnitPrice
	 */
	public long getUnixDiskUnitPrice() {
		return unixDiskUnitPrice;
	}

	/**
	 * @param unixDiskUnitPrice the unixDiskUnitPrice to set
	 */
	public void setUnixDiskUnitPrice(long unixDiskUnitPrice) {
		this.unixDiskUnitPrice = unixDiskUnitPrice;
	}

	/**
	 * @return the unixDiskErrMsg
	 */
	public String getUnixDiskErrMsg() {
		return unixDiskErrMsg;
	}

	/**
	 * @param unixDiskErrMsg the unixDiskErrMsg to set
	 */
	public void setUnixDiskErrMsg(String unixDiskErrMsg) {
		this.unixDiskErrMsg = unixDiskErrMsg;
	}

	/**
	 * @return the vCloudDiskPrice
	 */
	public long getvCloudDiskPrice() {
		return vCloudDiskPrice;
	}

	/**
	 * @param vCloudDiskPrice the vCloudDiskPrice to set
	 */
	public void setvCloudDiskPrice(long vCloudDiskPrice) {
		this.vCloudDiskPrice = vCloudDiskPrice;
	}

	/**
	 * @return the vCloudDiskUnitPrice
	 */
	public long getvCloudDiskUnitPrice() {
		return vCloudDiskUnitPrice;
	}

	/**
	 * @param vCloudDiskUnitPrice the vCloudDiskUnitPrice to set
	 */
	public void setvCloudDiskUnitPrice(long vCloudDiskUnitPrice) {
		this.vCloudDiskUnitPrice = vCloudDiskUnitPrice;
	}

	/**
	 * @return the vCloudDiskErrMsg
	 */
	public String getvCloudDiskErrMsg() {
		return vCloudDiskErrMsg;
	}

	/**
	 * @param vCloudDiskErrMsg the vCloudDiskErrMsg to set
	 */
	public void setvCloudDiskErrMsg(String vCloudDiskErrMsg) {
		this.vCloudDiskErrMsg = vCloudDiskErrMsg;
	}

	/**
	 * @return the tcpIpNasPrice
	 */
	public long getTcpIpNasPrice() {
		return tcpIpNasPrice;
	}

	/**
	 * @param tcpIpNasPrice the tcpIpNasPrice to set
	 */
	public void setTcpIpNasPrice(long tcpIpNasPrice) {
		this.tcpIpNasPrice = tcpIpNasPrice;
	}

	/**
	 * @return the tcpIpNasUnitPrice
	 */
	public long getTcpIpNasUnitPrice() {
		return tcpIpNasUnitPrice;
	}

	/**
	 * @param tcpIpNasUnitPrice the tcpIpNasUnitPrice to set
	 */
	public void setTcpIpNasUnitPrice(long tcpIpNasUnitPrice) {
		this.tcpIpNasUnitPrice = tcpIpNasUnitPrice;
	}

	/**
	 * @return the tcpIpNasErrMsg
	 */
	public String getTcpIpNasErrMsg() {
		return tcpIpNasErrMsg;
	}

	/**
	 * @param tcpIpNasErrMsg the tcpIpNasErrMsg to set
	 */
	public void setTcpIpNasErrMsg(String tcpIpNasErrMsg) {
		this.tcpIpNasErrMsg = tcpIpNasErrMsg;
	}

	/**
	 * @return the tcpAdgPrice
	 */
	public long getTcpIpAdgPrice() {
		return tcpIpAdgPrice;
	}

	
	
	/**
	 * @return the tcpIpAdgUnitPrice
	 */
	public long getTcpIpAdgUnitPrice() {
		return tcpIpAdgUnitPrice;
	}

	/**
	 * @param tcpIpAdgUnitPrice the tcpIpAdgUnitPrice to set
	 */
	public void setTcpIpAdgUnitPrice(long tcpIpAdgUnitPrice) {
		this.tcpIpAdgUnitPrice = tcpIpAdgUnitPrice;
	}

	/**
	 * @return the tcpIpAdgErrMsg
	 */
	public String getTcpIpAdgErrMsg() {
		return tcpIpAdgErrMsg;
	}

	/**
	 * @param tcpIpAdgErrMsg the tcpIpAdgErrMsg to set
	 */
	public void setTcpIpAdgErrMsg(String tcpIpAdgErrMsg) {
		this.tcpIpAdgErrMsg = tcpIpAdgErrMsg;
	}

	/**
	 * @return the tcpIpArkPrice
	 */
	public long getTcpIpArkPrice() {
		return tcpIpArkPrice;
	}

	/**
	 * @param tcpIpArkPrice the tcpIpArkPrice to set
	 */
	public void setTcpIpArkPrice(long tcpIpArkPrice) {
		this.tcpIpArkPrice = tcpIpArkPrice;
	}

	/**
	 * @return the tcpIpArkUnitPrice
	 */
	public long getTcpIpArkUnitPrice() {
		return tcpIpArkUnitPrice;
	}

	/**
	 * @param tcpIpArkUnitPrice the tcpIpArkUnitPrice to set
	 */
	public void setTcpIpArkUnitPrice(long tcpIpArkUnitPrice) {
		this.tcpIpArkUnitPrice = tcpIpArkUnitPrice;
	}

	/**
	 * @return the tcpIpArkErrMsg
	 */
	public String getTcpIpArkErrMsg() {
		return tcpIpArkErrMsg;
	}

	/**
	 * @param tcpIpArkErrMsg the tcpIpArkErrMsg to set
	 */
	public void setTcpIpArkErrMsg(String tcpIpArkErrMsg) {
		this.tcpIpArkErrMsg = tcpIpArkErrMsg;
	}

	/**
	 * @param tcpIpAdgPrice the tcpIpAdgPrice to set
	 */
	public void setTcpIpAdgPrice(long tcpIpAdgPrice) {
		this.tcpIpAdgPrice = tcpIpAdgPrice;
	}

	/**
	 * @return the tcpIpInternetPrice
	 */
	public long getTcpIpInternetPrice() {
		return tcpIpInternetPrice;
	}

	/**
	 * @param tcpIpInternetPrice the tcpIpInternetPrice to set
	 */
	public void setTcpIpInternetPrice(long tcpIpInternetPrice) {
		this.tcpIpInternetPrice = tcpIpInternetPrice;
	}

	/**
	 * @return the tcpIpInternetUnitPrice
	 */
	public long getTcpIpInternetUnitPrice() {
		return tcpIpInternetUnitPrice;
	}

	/**
	 * @param tcpIpInternetUnitPrice the tcpIpInternetUnitPrice to set
	 */
	public void setTcpIpInternetUnitPrice(long tcpIpInternetUnitPrice) {
		this.tcpIpInternetUnitPrice = tcpIpInternetUnitPrice;
	}

	/**
	 * @return the tcpIpInternetErrMsg
	 */
	public String getTcpIpInternetErrMsg() {
		return tcpIpInternetErrMsg;
	}

	/**
	 * @param tcpIpInternetErrMsg the tcpIpInternetErrMsg to set
	 */
	public void setTcpIpInternetErrMsg(String tcpIpInternetErrMsg) {
		this.tcpIpInternetErrMsg = tcpIpInternetErrMsg;
	}

	/**
	 * @return the nwNetworkPrice
	 */
	public long getNwNetworkPrice() {
		return nwNetworkPrice;
	}

	/**
	 * @param nwNetworkPrice the nwNetworkPrice to set
	 */
	public void setNwNetworkPrice(long nwNetworkPrice) {
		this.nwNetworkPrice = nwNetworkPrice;
	}

	/**
	 * @return the nwNetworkUnitPrice
	 */
	public long getNwNetworkUnitPrice() {
		return nwNetworkUnitPrice;
	}

	/**
	 * @param nwNetworkUnitPrice the nwNetworkUnitPrice to set
	 */
	public void setNwNetworkUnitPrice(long nwNetworkUnitPrice) {
		this.nwNetworkUnitPrice = nwNetworkUnitPrice;
	}

	/**
	 * @return the nwNetworkErrMsg
	 */
	public String getNwNetworkErrMsg() {
		return nwNetworkErrMsg;
	}

	/**
	 * @param nwNetworkErrMsg the nwNetworkErrMsg to set
	 */
	public void setNwNetworkErrMsg(String nwNetworkErrMsg) {
		this.nwNetworkErrMsg = nwNetworkErrMsg;
	}

	/**
	 * @return the osLocDskUnitPrice
	 */
	public long getOsLocDskUnitPrice() {
		return osLocDskUnitPrice;
	}

	/**
	 * @param osLocDskUnitPrice the osLocDskUnitPrice to set
	 */
	public void setOsLocDskUnitPrice(long osLocDskUnitPrice) {
		this.osLocDskUnitPrice = osLocDskUnitPrice;
	}

	/**
	 * @return the osLocDskErrMsg
	 */
	public String getOsLocDskErrMsg() {
		return osLocDskErrMsg;
	}

	/**
	 * @param osLocDskErrMsg the osLocDskErrMsg to set
	 */
	public void setOsLocDskErrMsg(String osLocDskErrMsg) {
		this.osLocDskErrMsg = osLocDskErrMsg;
	}

	


	/**
	 * @return the dataLocDskUnitPrice
	 */
	public long getDataLocDskUnitPrice() {
		return dataLocDskUnitPrice;
	}

	/**
	 * @param dataLocDskUnitPrice the dataLocDskUnitPrice to set
	 */
	public void setDataLocDskUnitPrice(long dataLocDskUnitPrice) {
		this.dataLocDskUnitPrice = dataLocDskUnitPrice;
	}

	/**
	 * @return the dataLocDskErrMsg
	 */
	public String getDataLocDskErrMsg() {
		return dataLocDskErrMsg;
	}

	/**
	 * @param dataLocDskErrMsg the dataLocDskErrMsg to set
	 */
	public void setDataLocDskErrMsg(String dataLocDskErrMsg) {
		this.dataLocDskErrMsg = dataLocDskErrMsg;
	}

	/**
	 * @return the osEioUnitPrice
	 */
	public long getOsEioUnitPrice() {
		return osEioUnitPrice;
	}

	/**
	 * @param osEioUnitPrice the osEioUnitPrice to set
	 */
	public void setOsEioUnitPrice(long osEioUnitPrice) {
		this.osEioUnitPrice = osEioUnitPrice;
	}

	/**
	 * @return the osEioErrMsg
	 */
	public String getOsEioErrMsg() {
		return osEioErrMsg;
	}

	/**
	 * @param osEioErrMsg the osEioErrMsg to set
	 */
	public void setOsEioErrMsg(String osEioErrMsg) {
		this.osEioErrMsg = osEioErrMsg;
	}

	/**
	 * @return the osDskUnitPrice
	 */
	public long getOsDskUnitPrice() {
		return osDskUnitPrice;
	}

	/**
	 * @param osDskUnitPrice the osDskUnitPrice to set
	 */
	public void setOsDskUnitPrice(long osDskUnitPrice) {
		this.osDskUnitPrice = osDskUnitPrice;
	}

	/**
	 * @return the osDskErrMsg
	 */
	public String getOsDskErrMsg() {
		return osDskErrMsg;
	}

	/**
	 * @param osDskErrMsg the osDskErrMsg to set
	 */
	public void setOsDskErrMsg(String osDskErrMsg) {
		this.osDskErrMsg = osDskErrMsg;
	}

	/**
	 * @return the dataDskUnitPrice
	 */
	public long getDataDskUnitPrice() {
		return dataDskUnitPrice;
	}

	/**
	 * @param dataDskUnitPrice the dataDskUnitPrice to set
	 */
	public void setDataDskUnitPrice(long dataDskUnitPrice) {
		this.dataDskUnitPrice = dataDskUnitPrice;
	}

	/**
	 * @return the dataDskErrMsg
	 */
	public String getDataDskErrMsg() {
		return dataDskErrMsg;
	}

	/**
	 * @param dataDskErrMsg the dataDskErrMsg to set
	 */
	public void setDataDskErrMsg(String dataDskErrMsg) {
		this.dataDskErrMsg = dataDskErrMsg;
	}

	/**
	 * @return the osV7000UnitPrice
	 */
	public long getOsV7000UnitPrice() {
		return osV7000UnitPrice;
	}

	/**
	 * @param osV7000UnitPrice the osV7000UnitPrice to set
	 */
	public void setOsV7000UnitPrice(long osV7000UnitPrice) {
		this.osV7000UnitPrice = osV7000UnitPrice;
	}

	/**
	 * @return the osV7000ErrMsg
	 */
	public String getOsV7000ErrMsg() {
		return osV7000ErrMsg;
	}

	/**
	 * @param osV7000ErrMsg the osV7000ErrMsg to set
	 */
	public void setOsV7000ErrMsg(String osV7000ErrMsg) {
		this.osV7000ErrMsg = osV7000ErrMsg;
	}

	/**
	 * @return the dataV7000UnitPrice
	 */
	public long getDataV7000UnitPrice() {
		return dataV7000UnitPrice;
	}

	/**
	 * @param dataV7000UnitPrice the dataV7000UnitPrice to set
	 */
	public void setDataV7000UnitPrice(long dataV7000UnitPrice) {
		this.dataV7000UnitPrice = dataV7000UnitPrice;
	}

	/**
	 * @return the dataV7000ErrMsg
	 */
	public String getDataV7000ErrMsg() {
		return dataV7000ErrMsg;
	}

	/**
	 * @param dataV7000ErrMsg the dataV7000ErrMsg to set
	 */
	public void setDataV7000ErrMsg(String dataV7000ErrMsg) {
		this.dataV7000ErrMsg = dataV7000ErrMsg;
	}

	/**
	 * @return the osVmaxUnitPrice
	 */
	public long getOsVmaxUnitPrice() {
		return osVmaxUnitPrice;
	}

	/**
	 * @param osVmaxUnitPrice the osVmaxUnitPrice to set
	 */
	public void setOsVmaxUnitPrice(long osVmaxUnitPrice) {
		this.osVmaxUnitPrice = osVmaxUnitPrice;
	}

	/**
	 * @return the osVmaxErrMsg
	 */
	public String getOsVmaxErrMsg() {
		return osVmaxErrMsg;
	}

	/**
	 * @param osVmaxErrMsg the osVmaxErrMsg to set
	 */
	public void setOsVmaxErrMsg(String osVmaxErrMsg) {
		this.osVmaxErrMsg = osVmaxErrMsg;
	}

	/**
	 * @return the dataVmaxUnitPrice
	 */
	public long getDataVmaxUnitPrice() {
		return dataVmaxUnitPrice;
	}

	/**
	 * @param dataVmaxUnitPrice the dataVmaxUnitPrice to set
	 */
	public void setDataVmaxUnitPrice(long dataVmaxUnitPrice) {
		this.dataVmaxUnitPrice = dataVmaxUnitPrice;
	}

	/**
	 * @return the dataVmaxErrMsg
	 */
	public String getDataVmaxErrMsg() {
		return dataVmaxErrMsg;
	}

	/**
	 * @param dataVmaxErrMsg the dataVmaxErrMsg to set
	 */
	public void setDataVmaxErrMsg(String dataVmaxErrMsg) {
		this.dataVmaxErrMsg = dataVmaxErrMsg;
	}

	/**
	 * @return the haUnitPrice
	 */
	public long getHaUnitPrice() {
		return haUnitPrice;
	}

	/**
	 * @param haUnitPrice the haUnitPrice to set
	 */
	public void setHaUnitPrice(long haUnitPrice) {
		this.haUnitPrice = haUnitPrice;
	}

	/**
	 * @return the haErrMsg
	 */
	public String getHaErrMsg() {
		return haErrMsg;
	}

	/**
	 * @param haErrMsg the haErrMsg to set
	 */
	public void setHaErrMsg(String haErrMsg) {
		this.haErrMsg = haErrMsg;
	}

	/**
	 * @return the cpuUnitPrice
	 */
	public long getCpuUnitPrice() {
		return cpuUnitPrice;
	}

	/**
	 * @param cpuUnitPrice the cpuUnitPrice to set
	 */
	public void setCpuUnitPrice(long cpuUnitPrice) {
		this.cpuUnitPrice = cpuUnitPrice;
	}

	/**
	 * @return the cpuErrMsg
	 */
	public String getCpuErrMsg() {
		return cpuErrMsg;
	}

	/**
	 * @param cpuErrMsg the cpuErrMsg to set
	 */
	public void setCpuErrMsg(String cpuErrMsg) {
		this.cpuErrMsg = cpuErrMsg;
	}

	

	/**
	 * @return the memUnitPrice
	 */
	public long getMemUnitPrice() {
		return memUnitPrice;
	}

	/**
	 * @param memUnitPrice the memUnitPrice to set
	 */
	public void setMemUnitPrice(long memUnitPrice) {
		this.memUnitPrice = memUnitPrice;
	}

	/**
	 * @return the memErrMsg
	 */
	public String getMemErrMsg() {
		return memErrMsg;
	}

	/**
	 * @param memErrMsg the memErrMsg to set
	 */
	public void setMemErrMsg(String memErrMsg) {
		this.memErrMsg = memErrMsg;
	}

	/**
	 * @return the exaDiskUnitPrice
	 */
	public long getExaDiskUnitPrice() {
		return exaDiskUnitPrice;
	}

	/**
	 * @param exaDiskUnitPrice the exaDiskUnitPrice to set
	 */
	public void setExaDiskUnitPrice(long exaDiskUnitPrice) {
		this.exaDiskUnitPrice = exaDiskUnitPrice;
	}

	/**
	 * @return the exaDiskErrMsg
	 */
	public String getExaDiskErrMsg() {
		return exaDiskErrMsg;
	}

	/**
	 * @param exaDiskErrMsg the exaDiskErrMsg to set
	 */
	public void setExaDiskErrMsg(String exaDiskErrMsg) {
		this.exaDiskErrMsg = exaDiskErrMsg;
	}

	/**
	 * @return the symantecBackupUnitPrice
	 */
	public long getSymantecBackupUnitPrice() {
		return symantecBackupUnitPrice;
	}

	/**
	 * @param symantecBackupUnitPrice the symantecBackupUnitPrice to set
	 */
	public void setSymantecBackupUnitPrice(long symantecBackupUnitPrice) {
		this.symantecBackupUnitPrice = symantecBackupUnitPrice;
	}

	/**
	 * @return the symantecBackupErrMsg
	 */
	public String getSymantecBackupErrMsg() {
		return symantecBackupErrMsg;
	}

	/**
	 * @param symantecBackupErrMsg the symantecBackupErrMsg to set
	 */
	public void setSymantecBackupErrMsg(String symantecBackupErrMsg) {
		this.symantecBackupErrMsg = symantecBackupErrMsg;
	}

	

	/**
	 * @return the realTimeUnitPrice
	 */
	public long getRealTimeUnitPrice() {
		return realTimeUnitPrice;
	}

	/**
	 * @param realTimeUnitPrice the realTimeUnitPrice to set
	 */
	public void setRealTimeUnitPrice(long realTimeUnitPrice) {
		this.realTimeUnitPrice = realTimeUnitPrice;
	}

	/**
	 * @return the realTimeErrMsg
	 */
	public String getRealTimeErrMsg() {
		return realTimeErrMsg;
	}

	/**
	 * @param realTimeErrMsg the realTimeErrMsg to set
	 */
	public void setRealTimeErrMsg(String realTimeErrMsg) {
		this.realTimeErrMsg = realTimeErrMsg;
	}

	/**
	 * @return the tcpIpOsUnitPrice
	 */
	public long getTcpIpOsUnitPrice() {
		return tcpIpOsUnitPrice;
	}

	/**
	 * @param tcpIpOsUnitPrice the tcpIpOsUnitPrice to set
	 */
	public void setTcpIpOsUnitPrice(long tcpIpOsUnitPrice) {
		this.tcpIpOsUnitPrice = tcpIpOsUnitPrice;
	}

	/**
	 * @return the tcpIpOsErrMsg
	 */
	public String getTcpIpOsErrMsg() {
		return tcpIpOsErrMsg;
	}

	/**
	 * @param tcpIpOsErrMsg the tcpIpOsErrMsg to set
	 */
	public void setTcpIpOsErrMsg(String tcpIpOsErrMsg) {
		this.tcpIpOsErrMsg = tcpIpOsErrMsg;
	}



	/**
	 * @return the tcpIpBackupUnitPrice
	 */
	public long getTcpIpBackupUnitPrice() {
		return tcpIpBackupUnitPrice;
	}

	/**
	 * @param tcpIpBackupUnitPrice the tcpIpBackupUnitPrice to set
	 */
	public void setTcpIpBackupUnitPrice(long tcpIpBackupUnitPrice) {
		this.tcpIpBackupUnitPrice = tcpIpBackupUnitPrice;
	}

	/**
	 * @return the tcpIpBackupErrMsg
	 */
	public String getTcpIpBackupErrMsg() {
		return tcpIpBackupErrMsg;
	}

	/**
	 * @param tcpIpBackupErrMsg the tcpIpBackupErrMsg to set
	 */
	public void setTcpIpBackupErrMsg(String tcpIpBackupErrMsg) {
		this.tcpIpBackupErrMsg = tcpIpBackupErrMsg;
	}

	/**
	 * @return the tcpIpFcUnitPrice
	 */
	public long getTcpIpFcUnitPrice() {
		return tcpIpFcUnitPrice;
	}

	/**
	 * @param tcpIpFcUnitPrice the tcpIpFcUnitPrice to set
	 */
	public void setTcpIpFcUnitPrice(long tcpIpFcUnitPrice) {
		this.tcpIpFcUnitPrice = tcpIpFcUnitPrice;
	}

	/**
	 * @return the tcpIpFcErrMsg
	 */
	public String getTcpIpFcErrMsg() {
		return tcpIpFcErrMsg;
	}

	/**
	 * @param tcpIpFcErrMsg the tcpIpFcErrMsg to set
	 */
	public void setTcpIpFcErrMsg(String tcpIpFcErrMsg) {
		this.tcpIpFcErrMsg = tcpIpFcErrMsg;
	}

	/**
	 * @return the pubNasUnitPrice
	 */
	public long getPubNasUnitPrice() {
		return pubNasUnitPrice;
	}

	/**
	 * @param pubNasUnitPrice the pubNasUnitPrice to set
	 */
	public void setPubNasUnitPrice(long pubNasUnitPrice) {
		this.pubNasUnitPrice = pubNasUnitPrice;
	}

	/**
	 * @return the pubNasErrMsg
	 */
	public String getPubNasErrMsg() {
		return pubNasErrMsg;
	}

	/**
	 * @param pubNasErrMsg the pubNasErrMsg to set
	 */
	public void setPubNasErrMsg(String pubNasErrMsg) {
		this.pubNasErrMsg = pubNasErrMsg;
	}

	/**
	 * @return the nwSecurityUnitPrice
	 */
	public long getNwSecurityUnitPrice() {
		return nwSecurityUnitPrice;
	}

	/**
	 * @param nwSecurityUnitPrice the nwSecurityUnitPrice to set
	 */
	public void setNwSecurityUnitPrice(long nwSecurityUnitPrice) {
		this.nwSecurityUnitPrice = nwSecurityUnitPrice;
	}

	/**
	 * @return the nwSecurityErrMsg
	 */
	public String getNwSecurityErrMsg() {
		return nwSecurityErrMsg;
	}

	/**
	 * @param nwSecurityErrMsg the nwSecurityErrMsg to set
	 */
	public void setNwSecurityErrMsg(String nwSecurityErrMsg) {
		this.nwSecurityErrMsg = nwSecurityErrMsg;
	}

	/**
	 * @return the nwSanUnitPrice
	 */
	public long getNwSanUnitPrice() {
		return nwSanUnitPrice;
	}

	/**
	 * @param nwSanUnitPrice the nwSanUnitPrice to set
	 */
	public void setNwSanUnitPrice(long nwSanUnitPrice) {
		this.nwSanUnitPrice = nwSanUnitPrice;
	}

	/**
	 * @return the nwSanErrMsg
	 */
	public String getNwSanErrMsg() {
		return nwSanErrMsg;
	}

	/**
	 * @param nwSanErrMsg the nwSanErrMsg to set
	 */
	public void setNwSanErrMsg(String nwSanErrMsg) {
		this.nwSanErrMsg = nwSanErrMsg;
	}

	/**
	 * @return the osLocDskPrice
	 */
	public long getOsLocDskPrice() {
		return osLocDskPrice;
	}

	/**
	 * @param osLocDskPrice the osLocDskPrice to set
	 */
	public void setOsLocDskPrice(long osLocDskPrice) {
		this.osLocDskPrice = osLocDskPrice;
	}

	/**
	 * @return the dataLocDskPrice
	 */
	public long getDataLocDskPrice() {
		return dataLocDskPrice;
	}

	/**
	 * @param dataLocDskPrice the dataLocDskPrice to set
	 */
	public void setDataLocDskPrice(long dataLocDskPrice) {
		this.dataLocDskPrice = dataLocDskPrice;
	}
	
	/**
	 * @return the afltCd
	 */
	public String getAfltCd() {
		return afltCd;
	}
	
	/**
	 * @return the dataDiskTot
	 */
	public long getDataDiskTot() {
		return dataDiskTot;
	}

	/**
	 * @param dataDiskTot the dataDiskTot to set
	 */
	public void setDataDiskTot(long dataDiskTot) {
		this.dataDiskTot = dataDiskTot;
	}

	/**
	 * @param afltCd the afltCd to set
	 */
	public void setAfltCd(String afltCd) {
		this.afltCd = afltCd;
	}
	/**
	 * @return the dataDskPrice
	 */
	public long getDataDskPrice() {
		return dataDskPrice;
	}
	/**
	 * @param dataDskPrice the dataDskPrice to set
	 */
	public void setDataDskPrice(long dataDskPrice) {
		this.dataDskPrice = dataDskPrice;
	}
	/**
	 * @return the haPrice
	 */
	public long getHaPrice() {
		return haPrice;
	}
	/**
	 * @param haPrice the haPrice to set
	 */
	public void setHaPrice(long haPrice) {
		this.haPrice = haPrice;
	}
	/**
	 * @return the osLocDskSz
	 */
	public long getOsLocDskSz() {
		return osLocDskSz;
	}
	/**
	 * @param osLocDskSz the osLocDskSz to set
	 */
	public void setOsLocDskSz(long osLocDskSz) {
		this.osLocDskSz = osLocDskSz;
	}
	/**
	 * @return the dataLocDskSz
	 */
	public long getDataLocDskSz() {
		return dataLocDskSz;
	}
	/**
	 * @param dataLocDskSz the dataLocDskSz to set
	 */
	public void setDataLocDskSz(long dataLocDskSz) {
		this.dataLocDskSz = dataLocDskSz;
	}
	/**
	 * @return the locDskSz
	 */

	/**
	 * @return the osEioSz
	 */
	public long getOsEioSz() {
		return osEioSz;
	}
	/**
	 * @param osEioSz the osEioSz to set
	 */
	public void setOsEioSz(long osEioSz) {
		this.osEioSz = osEioSz;
	}
	/**
	 * @return the osDskSz
	 */
	public long getOsDskSz() {
		return osDskSz;
	}
	/**
	 * @param osDskSz the osDskSz to set
	 */
	public void setOsDskSz(long osDskSz) {
		this.osDskSz = osDskSz;
	}
	/**
	 * @return the dataDskSz
	 */
	public long getDataDskSz() {
		return dataDskSz;
	}
	/**
	 * @param dataDskSz the dataDskSz to set
	 */
	public void setDataDskSz(long dataDskSz) {
		this.dataDskSz = dataDskSz;
	}
	/**
	 * @return the osV7000Sz
	 */
	public long getOsV7000Sz() {
		return osV7000Sz;
	}
	/**
	 * @param osV7000Sz the osV7000Sz to set
	 */
	public void setOsV7000Sz(long osV7000Sz) {
		this.osV7000Sz = osV7000Sz;
	}
	/**
	 * @return the dataV7000Sz
	 */
	public long getDataV7000Sz() {
		return dataV7000Sz;
	}
	/**
	 * @param dataV7000Sz the dataV7000Sz to set
	 */
	public void setDataV7000Sz(long dataV7000Sz) {
		this.dataV7000Sz = dataV7000Sz;
	}
	/**
	 * @return the osVmaxSz
	 */
	public long getOsVmaxSz() {
		return osVmaxSz;
	}
	/**
	 * @param osVmaxSz the osVmaxSz to set
	 */
	public void setOsVmaxSz(long osVmaxSz) {
		this.osVmaxSz = osVmaxSz;
	}
	/**
	 * @return the dataVmaxSz
	 */
	public long getDataVmaxSz() {
		return dataVmaxSz;
	}
	/**
	 * @param dataVmaxSz the dataVmaxSz to set
	 */
	public void setDataVmaxSz(long dataVmaxSz) {
		this.dataVmaxSz = dataVmaxSz;
	}
	/**
	 * @return the locDskPrice
	 */
	
	/**
	 * @return the osEioPrice
	 */
	public long getOsEioPrice() {
		return osEioPrice;
	}
	/**
	 * @param osEioPrice the osEioPrice to set
	 */
	public void setOsEioPrice(long osEioPrice) {
		this.osEioPrice = osEioPrice;
	}
	/**
	 * @return the osDskPrice
	 */
	public long getOsDskPrice() {
		return osDskPrice;
	}
	/**
	 * @param osDskPrice the osDskPrice to set
	 */
	public void setOsDskPrice(long osDskPrice) {
		this.osDskPrice = osDskPrice;
	}
	/**
	 * @return the osV7000Price
	 */
	public long getOsV7000Price() {
		return osV7000Price;
	}
	/**
	 * @param osV7000Price the osV7000Price to set
	 */
	public void setOsV7000Price(long osV7000Price) {
		this.osV7000Price = osV7000Price;
	}
	/**
	 * @return the dataV7000Price
	 */
	public long getDataV7000Price() {
		return dataV7000Price;
	}
	/**
	 * @param dataV7000Price the dataV7000Price to set
	 */
	public void setDataV7000Price(long dataV7000Price) {
		this.dataV7000Price = dataV7000Price;
	}
	/**
	 * @return the osVmaxPrice
	 */
	public long getOsVmaxPrice() {
		return osVmaxPrice;
	}
	/**
	 * @param osVmaxPrice the osVmaxPrice to set
	 */
	public void setOsVmaxPrice(long osVmaxPrice) {
		this.osVmaxPrice = osVmaxPrice;
	}
	/**
	 * @return the dataVmaxPrice
	 */
	public long getDataVmaxPrice() {
		return dataVmaxPrice;
	}
	/**
	 * @param dataVmaxPrice the dataVmaxPrice to set
	 */
	public void setDataVmaxPrice(long dataVmaxPrice) {
		this.dataVmaxPrice = dataVmaxPrice;
	}
	
	/**
	 * @return the isHa
	 */
	public boolean isHa() {
		return isHa;
	}
	/**
	 * @param isHa the isHa to set
	 */
	public void setHa(boolean isHa) {
		this.isHa = isHa;
	}
	/**
	 * @return the exaDiskPrice
	 */
	public long getExaDiskPrice() {
		return exaDiskPrice;
	}
	/**
	 * @param exaDiskPrice the exaDiskPrice to set
	 */
	public void setExaDiskPrice(long exaDiskPrice) {
		this.exaDiskPrice = exaDiskPrice;
	}
	
	public String getCntrCd() {
		return cntrCd;
	}
	public void setCntrCd(String cntrCd) {
		this.cntrCd = cntrCd;
	}
	public String getVtrlCd() {
		return vtrlCd;
	}
	public void setVtrlCd(String vtrlCd) {
		this.vtrlCd = vtrlCd;
	}
	public String getOsCd() {
		return osCd;
	}
	public void setOsCd(String osCd) {
		this.osCd = osCd;
	}
	public double getCoreCnt() {
		return coreCnt;
	}
	public void setCoreCnt(double coreCnt) {
		this.coreCnt = coreCnt;
	}
	public long getCpuCnt() {
		return cpuCnt;
	}
	public void setCpuCnt(long cpuCnt) {
		this.cpuCnt = cpuCnt;
	}
	public double getMemSz() {
		return memSz;
	}
	public void setMemSz(double memSz) {
		this.memSz = memSz;
	}
	

	public long getExaDiskSz() {
		return exaDiskSz;
	}
	public void setExaDiskSz(long exaDiskSz) {
		this.exaDiskSz = exaDiskSz;
	}
	public long getSymantecBackupSz() {
		return symantecBackupSz;
	}
	public void setSymantecBackupSz(long symantecBackupSz) {
		this.symantecBackupSz = symantecBackupSz;
	}
	
	
	/**
	 * @return the realTimeSz
	 */
	public long getRealTimeSz() {
		return realTimeSz;
	}

	/**
	 * @param realTimeSz the realTimeSz to set
	 */
	public void setRealTimeSz(long realTimeSz) {
		this.realTimeSz = realTimeSz;
	}

	public boolean isTcpIpOs() {
		return isTcpIpOs;
	}
	public void setTcpIpOs(boolean isTcpIpOs) {
		this.isTcpIpOs = isTcpIpOs;
	}
	
	public long getPubNasSz() {
		return pubNasSz;
	}
	public void setPubNasSz(long pubNasSz) {
		this.pubNasSz = pubNasSz;
	}
	public boolean isNwSecurity() {
		return isNwSecurity;
	}
	public void setNwSecurity(boolean isNwSecurity) {
		this.isNwSecurity = isNwSecurity;
	}
	public boolean isNwSan() {
		return isNwSan;
	}
	public void setNwSan(boolean isNwSan) {
		this.isNwSan = isNwSan;
	}
	
	public List<ActSvcUseDtlVO> getSwDtl() {
		return swDtl;
	}
	public void setSwDtl(List<ActSvcUseDtlVO> swDtl) {
		this.swDtl = swDtl;
	}
	public long getCpuPrice() {
		return cpuPrice;
	}
	public void setCpuPrice(long cpuPrice) {
		this.cpuPrice = cpuPrice;
	}
	public long getMemPrice() {
		return memPrice;
	}
	public void setMemPrice(long memPrice) {
		this.memPrice = memPrice;
	}
	/*
	public long getOsDiskPrice() {
		return osDiskPrice;
	}
	public void setOsDiskPrice(long osDiskPrice) {
		this.osDiskPrice = osDiskPrice;
	}
	*/
	public long getSymantecBackupPrice() {
		return symantecBackupPrice;
	}
	public void setSymantecBackupPrice(long symantecBackupPrice) {
		this.symantecBackupPrice = symantecBackupPrice;
	}
	
	public long getRealTimePrice() {
		return realTimePrice;
	}
	public void setRealTimePrice(long realTimePrice) {
		this.realTimePrice = realTimePrice;
	}
	public long getTcpIpOsPrice() {
		return tcpIpOsPrice;
	}
	public void setTcpIpOsPrice(long tcpIpOsPrice) {
		this.tcpIpOsPrice = tcpIpOsPrice;
	}
	
	public long getTcpIpBackupPrice() {
		return tcpIpBackupPrice;
	}
	public void setTcpIpBackupPrice(long tcpIpBackupPrice) {
		this.tcpIpBackupPrice = tcpIpBackupPrice;
	}
	public long getTcpIpFcPrice() {
		return tcpIpFcPrice;
	}
	public void setTcpIpFcPrice(long tcpIpFcPrice) {
		this.tcpIpFcPrice = tcpIpFcPrice;
	}
	public long getPubNasPrice() {
		return pubNasPrice;
	}
	public void setPubNasPrice(long pubNasPrice) {
		this.pubNasPrice = pubNasPrice;
	}
	public long getNwSecurityPrice() {
		return nwSecurityPrice;
	}
	public void setNwSecurityPrice(long nwSecurityPrice) {
		this.nwSecurityPrice = nwSecurityPrice;
	}
	public long getNwSanPrice() {
		return nwSanPrice;
	}
	public void setNwSanPrice(long nwSanPrice) {
		this.nwSanPrice = nwSanPrice;
	}
	public long getSwTotPrice() {
		return swTotPrice;
	}
	public void setSwTotPrice(long swTotPrice) {
		this.swTotPrice = swTotPrice;
	}
	public long getTotAmt() {
		return totAmt;
	}
	public void setTotAmt(long totAmt) {
		this.totAmt = totAmt;
	}
	
	/**
	 * @return the nutanixOsDskPrice
	 */
	public long getNutanixOsDskSz() {
		return nutanixOsDskSz;
	}
	
	/**
	 * @param nutanixOsDskSz the nutanixOsDskSz to set
	 */
	public void setNutanixOsDskSz(long nutanixOsDskSz) {
		this.nutanixOsDskSz = nutanixOsDskSz;
	}	
	
	/**
	 * @return the nutanixOsDskPrice
	 */
	public long getNutanixOsDskPrice() {
		return nutanixOsDskPrice;
	}
	/**
	 * @param nutanixOsDskPrice the nutanixOsDskPrice to set
	 */
	public void setNutanixOsDskPrice(long nutanixOsDskPrice) {
		this.nutanixOsDskPrice = nutanixOsDskPrice;
	}
	
	/**
	 * @return the nutanixOsDskUnitPrice
	 */
	public long getNutanixOsDskUnitPrice() {
		return nutanixOsDskUnitPrice;
	}
	/**
	 * @param nutanixOsDskUnitPrice the nutanixOsDskUnitPrice to set
	 */
	public void setNutanixOsDskUnitPrice(long nutanixOsDskUnitPrice) {
		this.nutanixOsDskUnitPrice = nutanixOsDskUnitPrice;
	}	
	
	/**
	 * @return the nutanixOsDskErrMsg
	 */
	public String getNutanixOsDskErrMsg() {
		return nutanixOsDskErrMsg;
	}
	/**
	 * @param nutanixOsDskErrMsg the nutanixOsDskErrMsg to set
	 */
	public void setNutanixOsDskErrMsg(String nutanixOsDskErrMsg) {
		this.nutanixOsDskErrMsg = nutanixOsDskErrMsg;
	}	
	
	/**
	 * @return the nutanixDataDskPrice
	 */
	public long getNutanixDataDskPrice() {
		return nutanixDataDskPrice;
	}
	/**
	 * @param nutanixDataDskPrice the nutanixDataDskPrice to set
	 */
	public void setNutanixDataDskPrice(long nutanixDataDskPrice) {
		this.nutanixDataDskPrice = nutanixDataDskPrice;
	}	
	
	/**
	 * @return the nutanixDataDskSz
	 */
	public long getNutanixDataDskSz() {
		return nutanixDataDskSz;
	}
	
	/**
	 * @param nutanixDataDskSz the nutanixDataDskSz to set
	 */
	public void setNutanixDataDskSz(long nutanixDataDskSz) {
		this.nutanixDataDskSz = nutanixDataDskSz;
	}	
	
	/**
	 * @return the nutanixDataDskUnitPrice
	 */
	public long getNutanixDataDskUnitPrice() {
		return nutanixDataDskUnitPrice;
	}
	/**
	 * @param nutanixDataDskUnitPrice the nutanixDataDskUnitPrice to set
	 */
	public void setNutanixDataDskUnitPrice(long nutanixDataDskUnitPrice) {
		this.nutanixDataDskUnitPrice = nutanixDataDskUnitPrice;
	}
	
	/**
	 * @return the nutanixDataDskErrMsg
	 */
	public String getNutanixDataDskErrMsg() {
		return this.nutanixDataDskErrMsg;
	}
	/**
	 * @param nutanixDataDskErrMsg the nutanixDataDskErrMsg to set
	 */
	public void setNutanixDataDskErrMsg(String nutanixDataDskErrMsg) {
		this.nutanixDataDskErrMsg = nutanixDataDskErrMsg;
	}		
	
	/**
	 * @return the osLocDskValUnit
	 */
	public long getOsLocDskValUnit() {
		return osLocDskValUnit;
	}

	/**
	 * @param osLocDskValUnit the osLocDskValUnit to set
	 */
	public void setOsLocDskValUnit(long osLocDskValUnit) {
		this.osLocDskValUnit = osLocDskValUnit;
	}

	/**
	 * @return the dataLocDskValUnit
	 */
	public long getDataLocDskValUnit() {
		return dataLocDskValUnit;
	}

	/**
	 * @param dataLocDskValUnit the dataLocDskValUnit to set
	 */
	public void setDataLocDskValUnit(long dataLocDskValUnit) {
		this.dataLocDskValUnit = dataLocDskValUnit;
	}

	/**
	 * @return the osDskValUnit
	 */
	public long getOsDskValUnit() {
		return osDskValUnit;
	}

	/**
	 * @param osDskValUnit the osDskValUnit to set
	 */
	public void setOsDskValUnit(long osDskValUnit) {
		this.osDskValUnit = osDskValUnit;
	}

	/**
	 * @return the dataDskValUnit
	 */
	public long getDataDskValUnit() {
		return dataDskValUnit;
	}

	/**
	 * @param dataDskValUnit the dataDskValUnit to set
	 */
	public void setDataDskValUnit(long dataDskValUnit) {
		this.dataDskValUnit = dataDskValUnit;
	}

	/**
	 * @return the osV7000ValUnit
	 */
	public long getOsV7000ValUnit() {
		return osV7000ValUnit;
	}

	/**
	 * @param osV7000ValUnit the osV7000ValUnit to set
	 */
	public void setOsV7000ValUnit(long osV7000ValUnit) {
		this.osV7000ValUnit = osV7000ValUnit;
	}

	/**
	 * @return the dataV7000ValUnit
	 */
	public long getDataV7000ValUnit() {
		return dataV7000ValUnit;
	}

	/**
	 * @param dataV7000ValUnit the dataV7000ValUnit to set
	 */
	public void setDataV7000ValUnit(long dataV7000ValUnit) {
		this.dataV7000ValUnit = dataV7000ValUnit;
	}

	/**
	 * @return the osVmaxValUnit
	 */
	public long getOsVmaxValUnit() {
		return osVmaxValUnit;
	}

	/**
	 * @param osVmaxValUnit the osVmaxValUnit to set
	 */
	public void setOsVmaxValUnit(long osVmaxValUnit) {
		this.osVmaxValUnit = osVmaxValUnit;
	}

	/**
	 * @return the dataVmaxValUnit
	 */
	public long getDataVmaxValUnit() {
		return dataVmaxValUnit;
	}

	/**
	 * @param dataVmaxValUnit the dataVmaxValUnit to set
	 */
	public void setDataVmaxValUnit(long dataVmaxValUnit) {
		this.dataVmaxValUnit = dataVmaxValUnit;
	}

	/**
	 * @return the osEioValUnit
	 */
	public long getOsEioValUnit() {
		return osEioValUnit;
	}

	/**
	 * @param osEioValUnit the osEioValUnit to set
	 */
	public void setOsEioValUnit(long osEioValUnit) {
		this.osEioValUnit = osEioValUnit;
	}

	/**
	 * @return the unixDiskValUnit
	 */
	public long getUnixDiskValUnit() {
		return unixDiskValUnit;
	}

	/**
	 * @param unixDiskValUnit the unixDiskValUnit to set
	 */
	public void setUnixDiskValUnit(long unixDiskValUnit) {
		this.unixDiskValUnit = unixDiskValUnit;
	}

	/**
	 * @return the vCloudDiskValUnit
	 */
	public long getvCloudDiskValUnit() {
		return vCloudDiskValUnit;
	}

	/**
	 * @param vCloudDiskValUnit the vCloudDiskValUnit to set
	 */
	public void setvCloudDiskValUnit(long vCloudDiskValUnit) {
		this.vCloudDiskValUnit = vCloudDiskValUnit;
	}

	/**
	 * @return the exaDiskValUnit
	 */
	public long getExaDiskValUnit() {
		return exaDiskValUnit;
	}

	/**
	 * @param exaDiskValUnit the exaDiskValUnit to set
	 */
	public void setExaDiskValUnit(long exaDiskValUnit) {
		this.exaDiskValUnit = exaDiskValUnit;
	}

	/**
	 * @return the nutanixOsDskValUnit
	 */
	public long getNutanixOsDskValUnit() {
		return nutanixOsDskValUnit;
	}

	/**
	 * @param nutanixOsDskValUnit the nutanixOsDskValUnit to set
	 */
	public void setNutanixOsDskValUnit(long nutanixOsDskValUnit) {
		this.nutanixOsDskValUnit = nutanixOsDskValUnit;
	}

	/**
	 * @return the nutanixDataDskValUnit
	 */
	public long getNutanixDataDskValUnit() {
		return nutanixDataDskValUnit;
	}

	/**
	 * @param nutanixDataDskValUnit the nutanixDataDskValUnit to set
	 */
	public void setNutanixDataDskValUnit(long nutanixDataDskValUnit) {
		this.nutanixDataDskValUnit = nutanixDataDskValUnit;
	}
	
	
}
