package com.nkia.xeus.entity.billing.charge;

import java.util.List;

public class BillChargeSimulationVO {
	public String cntrCd;  //센터코드   //필수
	public String vtrlCd; 	//가상화코드  //필수
	public String afltCd; 	//관계사 코드 //필수
	public String osCd; 	//osCd  	 //필수
	
	
	public double 	coreCnt; 		//공통(통합인프라/DR) core 개수  -- SW라이센스 가격 조회시는 필수
	public long 	cpuCnt; 		//공통(통합인프라/DR) CPU 개수(default : 2)   -- SW라이센스 가격 조회시는 필수 
	public double	memSz; 			//공통(통합인프라/DR) memory 사이즈
	
	public long 	osLocDskSz; 	//통합인프라 LOCAL 디스크 OS용 디스크
	public long 	dataLocDskSz; 	//통합인프라 LOCAL 디스크 DATA 용 디스크
	public long 	osDskSz;		//통합인프라 VNX OS 디스크         		
	public long 	dataDskSz;		//통합인프라 VNX DATA 디스크 
	public long 	osV7000Sz;		//통합인프라 V7000 OS 디스크 
	public long 	dataV7000Sz;	//통합인프라 V7000 DATA 디스크
	public long 	osVmaxSz;		//통합인프라 VMAX OS 디스크
	public long 	dataVmaxSz;		//통합인프라 VMAX DAT 디스크
	public boolean isHa;			//통합인프라 HA 서비스 	
	
	public long 	osEioSz  ;  	//DR  OS 디스크 사이즈
	public long 	unixDiskSz; 	//DR  UNIX 용 데이터 disk - VMAX
	public long 	vCloudDiskSz; 	//DR  X86용 데이터 disk - VNX
	public long 	exaDiskSz; 		//공통(통합인프라/DR) exa disk  사이즈  
	public long 	pubNasSz; 		//DR 공용NAS 사이즈
	public long 	realTimeSz; 	//DR 실시간복제사이즈
	public long 	symantecBackupSz;	//DR 소산사이즈
	
	public boolean isTcpIpOs;  	//DR 센터간 회선 실시간DR 대상
	public long 	tcpIpNasSz;  	//DR 센터간 회선 NAS 복제
	public long 	tcpIpAdgSz;  	//DR 센터간 회선 ADG 
	public long 	tcpIpArkSz;  	//DR 센터간 회선 ARK\
	public long 	tcpIpFcSz;  	//DR 센터간 회선 실시간복제 -FC
	public boolean isTcpIpInternet;//DR 센터간 회선 인터넷 
	public long 	tcpIpBackupSz; 	//DR 센터간 회선 소산
	
	public boolean isNwNetwork; 	//DR 공용네트워크 네트워크
	public boolean isNwSecurity; 	//DR 공용네트워크  보안
	public boolean isNwSan; 		//DR 공용네트워크 유지운영
	
	public long 	nutanixOsDskSz;		//통합인프라/DR Nutanix OS 디스크         		
	public long 	nutanixDataDskSz;		//통합인프라/DR Nutanix DATA 디스크
	
	public List<ActSvcUseDtlVO> swDtl;  //공통(통합인프라/DR) option코드만 셋팅하면 됩니다.  mmExcptAmt에 월예상금액 셋팅 
	
	// 리턴값 정리
	//해당 서비스 가격
	public long 	cpuPrice;		//CPU 가격	
	public long 	cpuUnitPrice; 	//CPU 단가
	public String 	cpuErrMsg;		//에러 메세지
	
	public long 	memPrice;		//메모리 가격 
	public long 	memUnitPrice;	//메모리 단가
	public String 	memErrMsg;		//에러 메세지
	
	public long 	osLocDskPrice;		//통합인프라 LOCAL 디스크 OS용 디스크 가격
	public long 	osLocDskUnitPrice;	//통합인프라 LOCAL 디스크 OS용 디스크 단가
	public long 	osLocDskValUnit;	//통합인프라 LOCAL 디스크 OS용 디스크 과금 단위	
	public String 	osLocDskErrMsg; 	//통합인프라 LOCAL 디스크 OS용 디스크 에러메세지	
	
	public long 	dataLocDskPrice;	//통합인프라 LOCAL 디스크 데이터용 디스크 가격
	public long 	dataLocDskUnitPrice;//통합인프라 LOCAL 디스크 데이터용 디스크 단가
	public long 	dataLocDskValUnit;//통합인프라 LOCAL 디스크 데이터용 디스크 과금단위
	public String 	dataLocDskErrMsg; 	//통합인프라 LOCAL 디스크 데이터용 디스크 에러메세지
	
	
	public long 	osDskPrice;			//통합인프라 VNX OS 디스크 가격      		
	public long 	osDskUnitPrice;		//통합인프라 VNX OS 디스크 단가
	public long 	osDskValUnit;		//통합인프라 VNX OS 디스크 과금 단위
	public String 	osDskErrMsg;		//통합인프라 VNX OS 디스크 에러메세지
	
	public long 	dataDskPrice;		//통합인프라 VNX DATA 디스크 가격
	public long 	dataDskUnitPrice;	//통합인프라 VNX DATA 디스크 단가
	public long 	dataDskValUnit;		//통합인프라 VNX DATA 디스크 과금 단위
	public String 	dataDskErrMsg;		//통합인프라 VNX DATA 디스크 에러메세지
	
	public long 	osV7000Price;		//통합인프라 V7000 OS 디스크 가격 
	public long 	osV7000UnitPrice;	//통합인프라 V7000 OS 디스크 단가
	public long 	osV7000ValUnit;		//통합인프라 V7000 OS 디스크 과금 단위
	public String 	osV7000ErrMsg;		//통합인프라 V7000 OS 디스크 에러메세지
	
	public long 	dataV7000Price;		//통합인프라 V7000 DATA 디스크 가격 
	public long 	dataV7000UnitPrice;	//통합인프라 V7000 DATA 디스크 단가 
	public long 	dataV7000ValUnit;	//통합인프라 V7000 DATA 디스크 과금 단위
	public String 	dataV7000ErrMsg;	//통합인프라 V7000 DATA 디스크 에러메세지 
	
	public long 	osVmaxPrice;		//통합인프라 VMAX OS 디스크 가격
	public long 	osVmaxUnitPrice;	//통합인프라 VMAX OS 디스크 단가
	public long 	osVmaxValUnit;		//통합인프라 VMAX OS 디스크 과금 단위
	public String 	osVmaxErrMsg;		//통합인프라 VMAX OS 디스크 에러메세지
	
	public long 	dataVmaxPrice;		//통합인프라 VMAX DATA 디스크 가격
	public long 	dataVmaxUnitPrice;	//통합인프라 VMAX DATA 디스크 단가
	public long 	dataVmaxValUnit;	//통합인프라 VMAX DATA 디스크 과금 단위
	public String 	dataVmaxErrMsg;		//통합인프라 VMAX DATA 디스크 에러메세지
	
	public long 	haPrice;			//통합인프라 HA 서비스 가격 
	public long 	haUnitPrice;		//통합인프라 HA 서비스 단가
	public String 	haErrMsg;			//통합인프라 HA 서비스 에러메세지
	
	public long 	dataDiskTot;		//디스크 총 용량
	
	public long		osEioPrice;			//DR OS 디스크 가격
	public long 	osEioUnitPrice;		//DR OS 디스크 단가
	public long 	osEioValUnit;		//DR OS 디스크 과금 단위
	public String 	osEioErrMsg; 		//DR OS 디스크 에러메세지
	
	public long		unixDiskPrice;		//DR UNIX 용 데이터 디스크(VMAX) 가격	
	public long 	unixDiskUnitPrice;	//DR UNIX 용 데이터 디스크(VMAX) 단가 
	public long 	unixDiskValUnit;	//DR UNIX 용 데이터 디스크(VMAX) 과금 단위 
	public String 	unixDiskErrMsg; 	//DR UNIX 용 데이터 디스크(VMAX) 에러메세지
	
	public long		vCloudDiskPrice;	//DR X86용 데이터 디스크(VNX) 가격	
	public long 	vCloudDiskUnitPrice;//DR X86용 데이터 디스크(VNX) 단가 
	public long 	vCloudDiskValUnit;	//DR X86용 데이터 디스크(VNX) 과금 단위 
	public String 	vCloudDiskErrMsg; 	//DR X86용 데이터 디스크(VNX) 에러메세지
	
	public long 	exaDiskPrice; 		//공통(통합인프라/DR) exa 디스크 가격
	public long 	exaDiskUnitPrice;	//공통(통합인프라/DR) exa 디스크 단가
	public long 	exaDiskValUnit;		//공통(통합인프라/DR) exa 디스크 과금 단위
	public String 	exaDiskErrMsg; 		//공통(통합인프라/DR) exa 디스크 에러메세지
	
	public long 	pubNasPrice;		//DR 공용NAS 가격
	public long 	pubNasUnitPrice;	//DR 공용NAS 단가
	public String 	pubNasErrMsg;		//DR 공용NAS 에러메세지
	
	public long 	realTimePrice;		//DR 실시간복제 가격
	public long 	realTimeUnitPrice;	//DR 실시간복제 단가 
	public String 	realTimeErrMsg;		//DR 실시간복제 에러메세지 
	
	public long 	symantecBackupPrice;	//DR 소산가격
	public long 	symantecBackupUnitPrice;//DR 소산단가
	public String 	symantecBackupErrMsg;	//DR 소산에러메세지

	public long 	tcpIpOsPrice;		//DR 센터간 회선  실시간DR 대상 가격
	public long 	tcpIpOsUnitPrice;	//DR 센터간 회선  실시간DR 대상 단가
	public String 	tcpIpOsErrMsg;		//DR 센터간 회선  실시간DR 대상 에러메세지
	
	public long 	tcpIpNasPrice;		//DR 센터간 회선 NAS 복제 가격
	public long 	tcpIpNasUnitPrice;	//DR 센터간 회선 NAS 복제 단가
	public String 	tcpIpNasErrMsg;		//DR 센터간 회선 NAS 복제 에러메세지
	
	public long 	tcpIpAdgPrice;		//DR 센터간 회선 ADG 가격	
	public long 	tcpIpAdgUnitPrice;	//DR 센터간 회선 ADG 단가
	public String 	tcpIpAdgErrMsg;		//DR 센터간 회선 ADG 에러메세지
	
	public long 	tcpIpArkPrice;		//DR 센터간 회선 ARK 가격	
	public long 	tcpIpArkUnitPrice;	//DR 센터간 회선 ARK 단가
	public String 	tcpIpArkErrMsg;		//DR 센터간 회선 ARK 에러메세지
	
	public long 	tcpIpFcPrice;		//DR 센터간 회선 -실시간복제 가격
	public long 	tcpIpFcUnitPrice;   //DR 센터간 회선 -실시간복제 단가
	public String 	tcpIpFcErrMsg;		//DR 센터간 회선 -실시간복제 에러메세지 
	
	
	public long 	tcpIpInternetPrice;		//DR 센터간 회선인터넷 가격 
	public long 	tcpIpInternetUnitPrice;	//DR 센터간 회선인터넷 단가
	public String 	tcpIpInternetErrMsg;	//DR 센터간 회선인터넷 에러메세지
	
	public long 	tcpIpBackupPrice;		//DR 센터간 회선-소산 가격
	public long 	tcpIpBackupUnitPrice;	//DR 센터간 회선-소산 단가
	public String 	tcpIpBackupErrMsg;		//DR 센터간 회선-소산 에러메세지
	
	
	public long 	nwNetworkPrice;			//DR 공용네트워크 네트워크 가격
	public long 	nwNetworkUnitPrice;		//DR 공용네트워크 네트워크 단가
	public String 	nwNetworkErrMsg;		//DR 공용네트워크 네트워크 에러메세지
	
	public long 	nwSecurityPrice;		//DR 공용네트워크 보안 가격
	public long 	nwSecurityUnitPrice;	//DR 공용네트워크 보안 단가
	public String 	nwSecurityErrMsg;		//DR 공용네트워크 보안 에러메세지
	
	public long 	nwSanPrice;				//DR 공용네트워크 네트워크/보안 유지운영 가격
	public long 	nwSanUnitPrice;			//DR 공용네트워크 네트워크/보안 유지운영 단가 
	public String 	nwSanErrMsg;			//DR 공용네트워크 네트워크/보안 유지운영 에러메세지	
	
	public long 	swTotPrice;				//SW 전체가격			
	public long 	totAmt;					//전체 가격
	
	public long 	nutanixOsDskPrice;		//통합인프라/DR Nutanix 디스크 OS용 디스크 가격
	public long 	nutanixOsDskUnitPrice;	//통합인프라/DR Nutanix 디스크 OS용 디스크 단가
	public long 	nutanixOsDskValUnit;	//통합인프라/DR Nutanix 디스크 OS용 디스크 과금 단위
	public String 	nutanixOsDskErrMsg; 	//통합인프라/DR Nutanix 디스크 OS용 디스크 에러메세지
	
	public long 	nutanixDataDskPrice;	//통합인프라/DR Nutanix 디스크 데이터용 디스크 가격
	public long 	nutanixDataDskUnitPrice;//통합인프라/DR Nutanix 디스크 데이터용 디스크 단가
	public long 	nutanixDataDskValUnit;	//통합인프라/DR Nutanix 디스크 데이터용 디스크 과금 단위
	public String 	nutanixDataDskErrMsg; 	//통합인프라/DR Nutanix 디스크 데이터용 디스크 에러메세지
	
	
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
