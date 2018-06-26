package com.nkia.xeus.service.billing.charge;
 
import java.util.ArrayList;
import java.util.List;

import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Service;

import com.nkia.common.NNPLogger;
import com.nkia.xeus.entity.billing.charge.ActSvcUseDtlVO;
import com.nkia.xeus.entity.billing.charge.BillChargeSimulationVO;

@ManagedResource(objectName = "xeus:name=BillChargeSimulationService,type=service")
@Service("BillChargeSimulationService")
/**
 * <p>요금계산기 기능을 구현
 * 
 */
public class BillChargeSimulationInterfaceImpl implements BillChargeSimulationInterface {
	NNPLogger log = NNPLogger.getLogger(BillChargeSimulationInterfaceImpl.class);
	//long price = 0;
	private BillChargeSimulationVO chrgSimul; 
	private List<ActSvcUseDtlVO> svcUseDtlList = new ArrayList<ActSvcUseDtlVO>();
	
	/**
	 * <p>전체 월 예상금액 조회  
	 * @param BillChargeSimulationVO: 요금계산기신청내역
	 * @return BillChargeSimulationVO 요금계산기신청내역 + 월예상금액+에러메세지
	 * @throws Exception
	 */
	public BillChargeSimulationVO  getMmExptChargePrice(BillChargeSimulationVO svcDtl) throws Exception{
		log.info("BillChargeSimulationInterfaceImpl.getMmExptChargePrice start #######################");
		BillChargeSimulationVO resultVo = new BillChargeSimulationVO();
		try{
			 resultVo = caluSimulation(svcDtl);
		}catch(Exception e){
			throw new Exception(e.getMessage());
		}

		log.info("BillChargeSimulationInterfaceImpl.getMmExptChargePrice end #######################");
		return svcDtl;
	}
	/**
	 * <p>cpu 월 예상금액 조회  
	 * @param BillChargeSimulationVO: 요금계산기신청내역
	 * @return BillChargeSimulationVO 요금계산기신청내역 + 월예상금액+에러메세지
	 * @throws Exception
	 */
	public BillChargeSimulationVO caluSimulation(BillChargeSimulationVO svcDtl)throws Exception{
		log.info("BillChargeSimulationInterfaceImpl.caluSimulation start #######################");
		BillChargeSimulationVO resultVo = svcDtl;
		long totAmt = 0l;
		try{
			//cpu 요금계산
			if(svcDtl.getCoreCnt() > 0 ){
				resultVo = this.getCorePrice( resultVo);
				totAmt += resultVo.getCpuPrice();
				//log.info("totAmt:" +totAmt );
			}
			//mem 요금계산
			if(svcDtl.getMemSz() > 0 ){
				resultVo = this.getMemoryPrice(resultVo);
				totAmt +=resultVo.getMemPrice();
				//log.info("totAmt:" +totAmt );
			}
			// local os  디스크
			if(svcDtl.getOsLocDskSz() > 0 ){
				resultVo = this.getOsLocalDiskPrice(resultVo);
				totAmt +=resultVo.getOsLocDskPrice();
						
				//log.info("totAmt:" +totAmt );
			}
			// local data  디스크
			if(svcDtl.getDataLocDskSz() > 0 ){
				log.info("getDataLocDskSz:" +svcDtl.getDataLocDskSz() );
				resultVo = this.getDataLocalDiskPrice(resultVo);
				totAmt +=resultVo.getDataLocDskPrice();
				//log.info("totAmt:" +totAmt );
			}
			
			// vnx os 디스크
			if(svcDtl.getOsDskSz() > 0 ){
				resultVo = this.getOsDiskPrice(resultVo);
				totAmt +=resultVo.getOsDskPrice();
				//log.info("totAmt:" +totAmt );
			}
			
			// vnx data 디스크
			if(svcDtl.getDataDskSz() > 0 ){
				resultVo = this.getDataDiskPrice(resultVo);
				totAmt +=resultVo.getDataDskPrice();
				//log.info("totAmt:" +totAmt );
			}
						
			// v7000 os 디스크
			if(svcDtl.getOsV7000Sz() > 0 ){
				resultVo = this.getOsV7000DiskPrice(resultVo);
				totAmt +=resultVo.getOsV7000Price();
				//log.info("totAmt:" +totAmt );
			}
						
			// v7000 data 디스크
			if(svcDtl.getDataV7000Sz() > 0 ){
				resultVo = this.getDataV7000DiskPrice(resultVo);
				totAmt +=resultVo.getDataV7000Price();
				//log.info("totAmt:" +totAmt );
			}
			
			// vmax os 디스크
			if(svcDtl.getOsVmaxSz() > 0 ){
				resultVo = this.getOsVmaxDiskPrice(resultVo);
				totAmt +=resultVo.getOsVmaxPrice();
				//log.info("totAmt:" +totAmt );
			}
						
			// vmax data 디스크
			if(svcDtl.getDataVmaxSz() > 0 ){
				resultVo = this.getDataVmaxDiskPrice(resultVo);
				totAmt +=resultVo.getDataVmaxPrice();
				//log.info("totAmt:" +totAmt );
			}
		
			//HA서비스
			if(svcDtl.isHa() ){
				resultVo = this.getHaPrice(resultVo);
				totAmt +=resultVo.getHaPrice();
				//log.info("totAmt:" +totAmt );
			}
			
			
			// Nutanix os 디스크
			if(svcDtl.getNutanixOsDskSz() > 0 ){
				resultVo = this.getNutanixOsDiskPrice(resultVo);
				totAmt +=resultVo.getNutanixOsDskPrice();
				//log.info("totAmt:" +totAmt );
			}
			
			// Nutanix data 디스크
			if(svcDtl.getNutanixDataDskSz() > 0 ){
				resultVo = this.getNutanixDataDiskPrice(resultVo);
				totAmt +=resultVo.getNutanixDataDskPrice();
				//log.info("totAmt:" +totAmt );
			}			
			
			//////////////////////////////////////////////////////////////////////////
			
			//DR  OS 디스크 사이즈
			if(svcDtl.getOsEioSz() > 0 ){
				resultVo = this.getEioDiskPrice(resultVo);
				totAmt += resultVo.getOsEioPrice();
			}
			//DR  unix 디스크 사이즈
			if(svcDtl.getUnixDiskSz() > 0 ){
				resultVo = this.getUnixDiskPrice(resultVo);
				totAmt += resultVo.getUnixDiskPrice();
			}
			
			//DR  vCloud 디스크 사이즈
			if(svcDtl.getvCloudDiskSz() > 0 ){
				resultVo = this.getVcloudDiskPrice(resultVo);
				totAmt += resultVo.getvCloudDiskPrice();
			}
			
			//exa disk
			if(svcDtl.getExaDiskSz() > 0 ){
				resultVo = this.getExaDiskPrice(resultVo);
				totAmt += resultVo.getExaDiskPrice();
				//log.info("totAmt:" +totAmt );
			}
			
			//DR 공용nas
			//공용NAS 사이즈
			if(svcDtl.getPubNasSz() > 0 ){
				resultVo = this.getpubNasPrice(resultVo);
				totAmt +=resultVo.getPubNasPrice();
			}
			
			//실시간 복제
			if(svcDtl.getRealTimeSz() > 0){
				resultVo = this.getRealTimePrice(resultVo);
				totAmt +=resultVo.getRealTimePrice();
			}
			
			//symantecBackupSz 소산
			if(svcDtl.getSymantecBackupSz() > 0 ){
				resultVo = this.getSymantecBackupPrice(resultVo);
				totAmt += resultVo.getSymantecBackupPrice();
			}
			
			//센터간 회선  -os
			if(svcDtl.isTcpIpOs() ){
				resultVo = this.getTcpIpOsPrice(resultVo);
				totAmt +=resultVo.getTcpIpOsPrice();
			}
			
			//센터간 회선- NAS 
			if(svcDtl.getTcpIpNasSz() > 0 ){
				resultVo = this.getTcpIpNasPrice(resultVo);
				totAmt +=resultVo.getTcpIpNasPrice();
			}
			
			//센터간 회선 - ADG
			if(svcDtl.getTcpIpAdgSz() > 0 ){
				resultVo = this.getTcpIpAdgPrice(resultVo);
				totAmt +=resultVo.getTcpIpAdgPrice();
			}
			
			//센터간 회선 - ARK
			if(svcDtl.getTcpIpArkSz() > 0 ){
				resultVo = this.getTcpIpArkPrice(resultVo);
				totAmt +=resultVo.getTcpIpArkPrice();
			}
			
			//센터간 회선  -소산
			if(svcDtl.getTcpIpBackupSz() > 0 ){
				resultVo = this.getTcpIpBackupPrice(resultVo);
				totAmt +=resultVo.getTcpIpBackupPrice();
			}
			
			///센터간 회선 -실시간복제
			if(svcDtl.getTcpIpFcSz() > 0 ){
				resultVo = this.getTcpIpFcPrice(resultVo);
				totAmt +=resultVo.getTcpIpFcPrice();
			}
			
			//인터넷 
			if(svcDtl.isTcpIpInternet() ){
				resultVo = this.getTcpIpInternetPrice(resultVo);
				totAmt +=resultVo.getTcpIpInternetPrice();
			}
			
			//공용네트워크  네트워크 
			if(svcDtl.isNwNetwork()){
				resultVo = this.getNwNetworkPrice(resultVo);
				totAmt +=resultVo.getNwNetworkPrice();
			}
			
			//공용네트워크  보안
			if(svcDtl.isNwSecurity()){
				resultVo = this.getNwSecurityPrice(resultVo);
				totAmt +=resultVo.getNwSecurityPrice();
			}
			//공용네트워크 네트워크/보안 유지운영
			if(svcDtl.isNwSan()){
				resultVo = this.getNwSanPrice(resultVo);
				totAmt += resultVo.getNwSanPrice();
			}
			
			if(svcDtl.getSwDtl() != null){
				log.info("svcDtl.getSwDtl().size() : "+ svcDtl.getSwDtl().size());
				//sw비용
				if(svcDtl.getSwDtl().size() > 0){
					resultVo = this.getSwPrice(resultVo);
					totAmt +=resultVo.getSwTotPrice();
				}
			}
			
			
			
			log.info("resultVo.setTotAmt(totAmt) : "+ totAmt);
			resultVo.setTotAmt(totAmt);
			
		}catch(Exception e){
			log.error("BillChargeSimulationService Error : " + e.getMessage());
			throw new Exception(e.getMessage());
		}
		log.info("BillChargeSimulationInterfaceImpl.caluSimulation end #######################");
		return resultVo;
	}
	
	//서비스항목 생성
	public void createSvcUseDtl() throws Exception{
		/*
		ActSvcUseDtlVO svcUseDtl = new ActSvcUseDtlVO();
		//int iCnt = 0;
		//센터코드
		svcUseDtl.setCntrCd(this.chrgSimul.getCntrCd());
		//가상화코드
		svcUseDtl.setVrtlCd(this.chrgSimul.getVtrlCd());
		//OS코드
		svcUseDtl.setOsCd(this.chrgSimul.getOsCd());
		
		//cpu 셋팅
		log.info(" core : " + this.chrgSimul.getCoreCnt());
		if(this.chrgSimul.getCoreCnt() > 0 ){
			svcUseDtl.setTypCd(BillingConstants.TYP_CD_CPU);
			svcUseDtl.setOptCd(BillingConstants.OPT_CD_VCORE);
			svcUseDtlList.add(svcUseDtl);
		}
		
		//MEMORY 셋팅
		log.info(" memory : " + this.chrgSimul.getMemSz());
		if(this.chrgSimul.getMemSz() > 0 ){
			
			svcUseDtl.setTypCd(BillingConstants.TYP_CD_MEMORY);
			svcUseDtl.setOptCd(BillingConstants.OPT_CD_TOTAL_SIZE);
			svcUseDtlList.add(svcUseDtl);
		}
		//x86OsDiskSz
		log.info(" x86OsDiskSz : " + this.chrgSimul.getX86OsDiskSz());
		if(this.chrgSimul.getX86OsDiskSz() > 0 ){
			svcUseDtl.setTypCd(BillingConstants.TYP_CD_DISK);
			svcUseDtl.setOptCd(BillingConstants.OPT_CD_X86_OS_DISK);
			svcUseDtlList.add(svcUseDtl);
		}
		log.info(" unixOsDiskSz : " + this.chrgSimul.getUnixOsDiskSz());
		if(this.chrgSimul.getUnixOsDiskSz() > 0 ){
			svcUseDtl.setTypCd(BillingConstants.TYP_CD_DISK);
			svcUseDtl.setOptCd(BillingConstants.OPT_CD_UNIX_OS_DISK);
			svcUseDtlList.add(svcUseDtl);
		}
		log.info(" x86ExtDiskSz : " + this.chrgSimul.getX86ExtDiskSz());
		if(this.chrgSimul.getX86ExtDiskSz() > 0 ){
			svcUseDtl.setTypCd(BillingConstants.TYP_CD_DISK);
			svcUseDtl.setOptCd(BillingConstants.OPT_CD_X86_EXTERNAL_DISK);
			svcUseDtlList.add(svcUseDtl);
		}
		log.info(" unixExtDiskSz : " + this.chrgSimul.getX86ExtDiskSz());
		if(this.chrgSimul.getX86ExtDiskSz() > 0 ){
			svcUseDtl.setTypCd(BillingConstants.TYP_CD_DISK);
			svcUseDtl.setOptCd(BillingConstants.OPT_CD_UNIX_EXTERNAL_DISK);
			svcUseDtlList.add(svcUseDtl);
		}
		//EXA DISK
		log.info(" exaDiskSz : " + this.chrgSimul.getExaDiskSz());
		if(this.chrgSimul.getExaDiskSz() > 0 ){
			svcUseDtl.setTypCd(BillingConstants.TYP_CD_DISK);
			svcUseDtl.setOptCd(BillingConstants.OPT_CD_EXADATA_DISK);
			svcUseDtlList.add(svcUseDtl);
		}
		
		//소산 사이즈
		log.info(" symantecBackupSz : " + this.chrgSimul.getSymantecBackupSz());
		if(this.chrgSimul.getExaDiskSz() > 0 ){
			svcUseDtl.setTypCd(BillingConstants.TYP_CD_BACKUP);
			svcUseDtl.setOptCd(BillingConstants.OPT_CD_SYMANTEC);
			svcUseDtlList.add(svcUseDtl);
		}
		//시점백업여부
		log.info(" isRecoverPoint : " + this.chrgSimul.isRecoverPoint());
		if(this.chrgSimul.isRecoverPoint()){
			svcUseDtl.setTypCd(BillingConstants.TYP_CD_BACKUP);
			svcUseDtl.setOptCd(BillingConstants.OPT_CD_RECOVERPOINT);
			svcUseDtlList.add(svcUseDtl);
		}
		//실시간복제여부
		log.info(" isRealTime : " + this.chrgSimul.isRealTime());
		if(this.chrgSimul.isRealTime()){
			svcUseDtl.setTypCd(BillingConstants.TYP_CD_DR_DUPLICATE);
			svcUseDtl.setOptCd(BillingConstants.OPT_CD_REALTIME);
			svcUseDtlList.add(svcUseDtl);
		}
		//센터간 회선  -os부
		log.info(" isTcpIpOs : " + this.chrgSimul.isTcpIpOs());
		if(this.chrgSimul.isTcpIpOs()){
			svcUseDtl.setTypCd(BillingConstants.TYP_CD_DR_CIRCUIT);
			svcUseDtl.setOptCd(BillingConstants.OPT_CD_TCP_IP_OS);
			svcUseDtlList.add(svcUseDtl);
		}
		//센터간 회선  -exa부
		log.info(" isTcpIpExaData : " + this.chrgSimul.isTcpIpExaData());
		if(this.chrgSimul.isTcpIpExaData()){
			svcUseDtl.setTypCd(BillingConstants.TYP_CD_DR_CIRCUIT);
			svcUseDtl.setOptCd(BillingConstants.OPT_CD_TCP_IP_EXADATA);
			svcUseDtlList.add(svcUseDtl);
		}
		//센터간 회선  -소산
		log.info(" isTcpIpBackup : " + this.chrgSimul.isTcpIpBackup());
		if(this.chrgSimul.isTcpIpBackup()){
			svcUseDtl.setTypCd(BillingConstants.TYP_CD_DR_CIRCUIT);
			svcUseDtl.setOptCd(BillingConstants.OPT_CD_TCP_IP_BACKUP);
			svcUseDtlList.add(svcUseDtl);
		}
		//센터간 회선  - 실시간복제
		log.info(" isTcpIpFc : " + this.chrgSimul.isTcpIpFc());
		if(this.chrgSimul.isTcpIpFc()){
			svcUseDtl.setTypCd(BillingConstants.TYP_CD_DR_CIRCUIT);
			svcUseDtl.setOptCd(BillingConstants.OPT_CD_TCP_IP_FC);
			svcUseDtlList.add(svcUseDtl);
		}
		
		//센터간 회선 - 공용NAS
		log.info(" pubNasSz : " + this.chrgSimul.getPubNasSz());
		if(this.chrgSimul.getPubNasSz() > 0){
			svcUseDtl.setTypCd(BillingConstants.TYP_CD_NAS_PUBLIC);
			svcUseDtl.setOptCd(BillingConstants.OPT_CD_NAS);
			svcUseDtlList.add(svcUseDtl);
		}
		
		//센터간 회선 -  보안
		log.info(" isNwSecurity : " + this.chrgSimul.isNwSecurity());
		if(this.chrgSimul.isNwSecurity()){
			svcUseDtl.setTypCd(BillingConstants.TYP_CD_NAS_PUBLIC);
			svcUseDtl.setOptCd(BillingConstants.OPT_CD_NW_SECCURITY);
			svcUseDtlList.add(svcUseDtl);
		}
		//센터간 회선 -  보안
		log.info(" isNwSecurity : " + this.chrgSimul.isNwSan());
		if(this.chrgSimul.isNwSan()){
			svcUseDtl.setTypCd(BillingConstants.TYP_CD_NAS_PUBLIC);
			svcUseDtl.setOptCd(BillingConstants.OPT_CD_NW_SAN);
			svcUseDtlList.add(svcUseDtl);
		}
		*/
	}

	/**
	 * <p>cpu 월 예상금액 조회  
	 * @param BillChargeSimulationVO: 요금계산기신청내역
	 * @return BillChargeSimulationVO 요금계산기신청내역 + 월예상금액+에러메세지
	 * @throws Exception
	 */
	public BillChargeSimulationVO getCorePrice(BillChargeSimulationVO svcDtl)throws  Exception{
		log.info("BillChargeSimulationInterfaceImpl.getCorePrice start #######################");
		ActSvcUseDtlVO svcUseDtl = new ActSvcUseDtlVO();
		BillChargeSimulationVO resultVo = svcDtl;
		long mmExptPrice =0;
		//chrgSimul = svcDtl ;
		//int iCnt = 0;
		//센터코드
		try{
			svcUseDtl.setCntrCd(resultVo.getCntrCd());
			//가상화코드
			svcUseDtl.setVrtlCd(resultVo.getVtrlCd());
			//OS코드
			svcUseDtl.setOsCd(resultVo.getOsCd());
			//관계사 코드 
			svcUseDtl.setAfltCd(resultVo.getAfltCd());
			
			//cpu 셋팅
			log.info(" core : " + resultVo.getCoreCnt());
			if(resultVo.getCoreCnt() > 0 ){
				svcUseDtl.setTypCd(BillingConstants.TYP_CD_CPU);
				svcUseDtl.setOptCd(BillingConstants.OPT_CD_VCORE);
				svcUseDtl.setDoubleQts(resultVo.getCoreCnt());
				//svcUseDtlList.add(svcUseDtl);
			}
			//해당 서비스 월예상금액 조회
			ChargeCalcSimulation simuCalc = new ChargeCalcSimulation(svcUseDtl);
			simuCalc.calcOfAllocQts();
			mmExptPrice = simuCalc.getSvcAmt();
			long unitPrice = simuCalc.getUnitPrice();
			
			log.info(svcUseDtl.getOptCd() + " : "+ mmExptPrice);
			resultVo.setCpuUnitPrice(unitPrice);
			resultVo.setCpuPrice(mmExptPrice);
		}catch(NotFoundUnitPriceException e){
			log.error("notFound unitPirce : "+e.getMessage());
			resultVo.setCpuErrMsg(e.getMessage());
		}catch(Exception e){
			log.error(e.getMessage());
			//throw new Exception("BillChargeSimulationInterfaceImpl.getCorePrice():" + e.getMessage());
			
		}finally{
			log.info("BillChargeSimulationInterfaceImpl.getCorePrice end #######################");
		}
		return resultVo;	
	}
	
	/**
	 * <p>메모리 월 예상금액 조회  
	 * @param BillChargeSimulationVO: 요금계산기신청내역
	  * @return BillChargeSimulationVO 요금계산기신청내역 + 월예상금액+에러메세지
	 * @throws Exception
	 */
	public BillChargeSimulationVO getMemoryPrice(BillChargeSimulationVO svcDtl)throws Exception{
		log.info("BillChargeSimulationInterfaceImpl.getMemoryPrice start #######################");
		ActSvcUseDtlVO svcUseDtl = new ActSvcUseDtlVO();
		BillChargeSimulationVO resultVo = svcDtl;
		long mmExptPrice =0;
		//chrgSimul = svcDtl ;
		//int iCnt = 0;
		try{
			//센터코드
			svcUseDtl.setCntrCd(resultVo.getCntrCd());
			//가상화코드
			svcUseDtl.setVrtlCd(resultVo.getVtrlCd());
			//OS코드
			svcUseDtl.setOsCd(resultVo.getOsCd());
			//관계사 코드 
			svcUseDtl.setAfltCd(resultVo.getAfltCd());
			//cpu 셋팅
			log.info(" mem : " + resultVo.getMemSz());
			if(resultVo.getMemSz() > 0 ){
				svcUseDtl.setTypCd(BillingConstants.TYP_CD_MEMORY);
				svcUseDtl.setOptCd(BillingConstants.OPT_CD_TOTAL_SIZE);
				svcUseDtl.setDoubleQts(resultVo.getMemSz());
				//svcUseDtlList.add(svcUseDtl);
			}
			//해당 서비스 월예상금액 조회
			ChargeCalcSimulation simuCalc = new ChargeCalcSimulation(svcUseDtl);
			simuCalc.calcOfAllocQts();
			mmExptPrice = simuCalc.getSvcAmt();
			long unitPrice = simuCalc.getUnitPrice();
			log.info(svcUseDtl.getOptCd() + " : "+ mmExptPrice);
			resultVo.setMemUnitPrice(unitPrice);
			resultVo.setMemPrice(mmExptPrice);
		
		}catch(NotFoundUnitPriceException e){
			log.error("notFound unitPirce : "+e.getMessage());
			resultVo.setMemErrMsg(e.getMessage());	
		}catch(Exception e){
			log.error(e.getMessage());
			//throw new Exception("BillChargeSimulationInterfaceImpl.getMemoryPrice():" + e.getMessage());
		}finally{
			log.info("BillChargeSimulationInterfaceImpl.getMemoryPrice end #######################");
		}
		return resultVo;
	}
	
	/**
	 * <p>exa disk 월 예상금액 조회  
	 * @param BillChargeSimulationVO: 요금계산기신청내역
	 * @return BillChargeSimulationVO 요금계산기신청내역 + 월예상금액+에러메세지
	 * @throws Exception
	 */
	public BillChargeSimulationVO getExaDiskPrice(BillChargeSimulationVO svcDtl)throws Exception{
		log.info("BillChargeSimulationInterfaceImpl.getExaDiskPrice start #######################");
		ActSvcUseDtlVO svcUseDtl = new ActSvcUseDtlVO();
		BillChargeSimulationVO resultVo = svcDtl;
		long mmExptPrice =0;
		try{
			//int iCnt = 0;
			//센터코드
			svcUseDtl.setCntrCd(resultVo.getCntrCd());
			//가상화코드
			svcUseDtl.setVrtlCd(resultVo.getVtrlCd());
			//OS코드
			svcUseDtl.setOsCd(resultVo.getOsCd());
			//관계사 코드 
			svcUseDtl.setAfltCd(resultVo.getAfltCd());
			//ExaDiskSz 셋팅
			log.info(" OPT_CD_EXT_EXADATA_DISK SZ : " + resultVo.getExaDiskSz());
			if(resultVo.getExaDiskSz() > 0 ){
				svcUseDtl.setTypCd(BillingConstants.TYP_CD_DISK);
				svcUseDtl.setOptCd(BillingConstants.OPT_CD_EXT_EXADATA_DISK);
				svcUseDtl.setQts(resultVo.getExaDiskSz() );
			}
			ChargeCalcSimulation simuCalc = new ChargeCalcSimulation(svcUseDtl);
			simuCalc.calcOfAllocQts();
			mmExptPrice = simuCalc.getSvcAmt();
			
			long unitPrice = simuCalc.getUnitPrice();
			long valUnit = simuCalc.getValUnit();
			log.info(svcUseDtl.getOptCd() + " : "+ mmExptPrice);
			resultVo.setExaDiskUnitPrice(unitPrice);
			resultVo.setExaDiskValUnit(valUnit);
			resultVo.setExaDiskPrice(mmExptPrice);
			
		}catch(NotFoundUnitPriceException e){
			log.error("notFound unitPirce : "+e.getMessage());
			resultVo.setExaDiskErrMsg(e.getMessage());	
		}catch(Exception e){
			log.error(e.getMessage());
			throw new Exception("BillChargeSimulationInterfaceImpl.getExaDiskPrice():" + e.getMessage());
		}finally{
			log.info("BillChargeSimulationInterfaceImpl.getExaDiskPrice end #######################");
		}
		
		return resultVo;
	}
	
	
	/**
	 * <p>os local disk 월 예상금액 조회  
	 * @param BillChargeSimulationVO: 요금계산기신청내역
	 * @return BillChargeSimulationVO 요금계산기신청내역 + 월예상금액+에러메세지
	 * @throws Exception
	 */
	public BillChargeSimulationVO getOsLocalDiskPrice(BillChargeSimulationVO svcDtl)throws Exception{
		log.info("BillChargeSimulationInterfaceImpl.getOsLocalDiskPrice start #######################");
		ActSvcUseDtlVO svcUseDtl = new ActSvcUseDtlVO();
		BillChargeSimulationVO resultVo = svcDtl;
		long mmExptPrice =0;
		try{
			//int iCnt = 0;
			//센터코드
			svcUseDtl.setCntrCd(resultVo.getCntrCd());
			//가상화코드
			svcUseDtl.setVrtlCd(resultVo.getVtrlCd());
			//OS코드
			svcUseDtl.setOsCd(resultVo.getOsCd());
			//관계사 코드 
			svcUseDtl.setAfltCd(resultVo.getAfltCd());
			//x86OsDiskSz 셋팅
			log.info(" OPT_CD_INT_OS_DISK SZ : " + resultVo.getOsLocDskSz());
			if(resultVo.getOsLocDskSz() > 0 ){
				svcUseDtl.setTypCd(BillingConstants.TYP_CD_DISK);
				svcUseDtl.setOptCd(BillingConstants.OPT_CD_INT_OS_DISK);
				svcUseDtl.setQts(resultVo.getOsLocDskSz() );
				//svcUseDtlList.add(svcUseDtl);
			}
			
			log.info(" ################## TYP CD : " + svcUseDtl.getTypCd());
			ChargeCalcSimulation simuCalc = new ChargeCalcSimulation(svcUseDtl);
			simuCalc.calcOfAllocQts();
			mmExptPrice = simuCalc.getSvcAmt();
			
			long unitPrice = simuCalc.getUnitPrice();
			long valUnit	= simuCalc.getValUnit();
			log.info(svcUseDtl.getOptCd() + " : "+ mmExptPrice);
			resultVo.setOsLocDskUnitPrice(unitPrice);
			resultVo.setOsLocDskValUnit(valUnit);
			resultVo.setOsLocDskPrice(mmExptPrice);
			
		}catch(NotFoundUnitPriceException e){
			log.error("notFound unitPirce : "+e.getMessage());
			resultVo.setOsLocDskErrMsg(e.getMessage());		
		}catch(Exception e){
			log.error(e.getMessage());
			throw new Exception("BillChargeSimulationInterfaceImpl.getOsLocalDiskPrice():" + e.getMessage());
		}finally{
			log.info("BillChargeSimulationInterfaceImpl.getOsLocalDiskPrice end #######################");
		}
		return resultVo;
		
	}
	
	
	/**
	 * <p>data local disk 월 예상금액 조회  
	 * @param BillChargeSimulationVO: 요금계산기신청내역
	 * @return BillChargeSimulationVO 요금계산기신청내역 + 월예상금액+에러메세지
	 * @throws Exception
	 */
	public BillChargeSimulationVO getDataLocalDiskPrice(BillChargeSimulationVO svcDtl)throws Exception{
		log.info("BillChargeSimulationInterfaceImpl.getDataLocalDiskPrice start #######################");
		ActSvcUseDtlVO svcUseDtl = new ActSvcUseDtlVO();
		BillChargeSimulationVO resultVo = svcDtl;
		long mmExptPrice =0;
		try{
			//int iCnt = 0;
			//센터코드
			svcUseDtl.setCntrCd(resultVo.getCntrCd());
			//가상화코드
			svcUseDtl.setVrtlCd(resultVo.getVtrlCd());
			//OS코드
			svcUseDtl.setOsCd(resultVo.getOsCd());
			//관계사 코드 
			svcUseDtl.setAfltCd(resultVo.getAfltCd());
			//x86OsDiskSz 셋팅
			log.info(" OPT_CD_INT_DATA_DISK SZ : " + resultVo.getDataLocDskSz());
			if(resultVo.getDataLocDskSz() > 0 ){
				svcUseDtl.setTypCd(BillingConstants.TYP_CD_DISK);
				svcUseDtl.setOptCd(BillingConstants.OPT_CD_INT_DATA_DISK);				
				svcUseDtl.setQts(resultVo.getDataLocDskSz() );
				//svcUseDtlList.add(svcUseDtl);
			}
			ChargeCalcSimulation simuCalc = new ChargeCalcSimulation(svcUseDtl);
			simuCalc.calcOfAllocQts();
			mmExptPrice = simuCalc.getSvcAmt();
			
			long unitPrice = simuCalc.getUnitPrice();
			long valUnit = simuCalc.getValUnit();
			log.info(svcUseDtl.getOptCd() + " : "+ mmExptPrice);
			resultVo.setDataLocDskUnitPrice(unitPrice);
			resultVo.setOsLocDskValUnit(valUnit);
			resultVo.setDataLocDskPrice(mmExptPrice);
			
			
		}catch(NotFoundUnitPriceException e){
			log.error("notFound unitPirce : "+e.getMessage());
			resultVo.setDataLocDskErrMsg(e.getMessage());	
		}catch(Exception e){
			log.error(e.getMessage());
			throw new Exception("BillChargeSimulationInterfaceImpl.getDataLocalDiskPrice():" + e.getMessage());
		}finally{
			log.info("BillChargeSimulationInterfaceImpl.getDataLocalDiskPrice end #######################");
		}
		return resultVo;
	}
	
	
	/**
	 * <p>//OS DISK(VNX) 월 예상금액 조회  
	 * @param BillChargeSimulationVO: 요금계산기신청내역
	 * @return BillChargeSimulationVO 요금계산기신청내역 + 월예상금액+에러메세지
	 * @throws Exception
	 */
	public BillChargeSimulationVO getOsDiskPrice(BillChargeSimulationVO svcDtl)throws Exception{
		log.info("BillChargeSimulationInterfaceImpl.getOsDiskPrice start #######################");
		ActSvcUseDtlVO svcUseDtl = new ActSvcUseDtlVO();
		BillChargeSimulationVO resultVo = svcDtl;
		long mmExptPrice =0;
		try{
			//int iCnt = 0;
			//센터코드
			svcUseDtl.setCntrCd(resultVo.getCntrCd());
			//가상화코드
			svcUseDtl.setVrtlCd(resultVo.getVtrlCd());
			//OS코드
			svcUseDtl.setOsCd(resultVo.getOsCd());
			//관계사 코드 
			svcUseDtl.setAfltCd(resultVo.getAfltCd());
			//OPT_CD_EXT_OS_VNX 셋팅
			log.info(" OPT_CD_EXT_OS_VNX : " + resultVo.getOsDskSz());
			if(resultVo.getOsDskSz() > 0 ){
				svcUseDtl.setTypCd(BillingConstants.TYP_CD_DISK);
				svcUseDtl.setOptCd(BillingConstants.OPT_CD_EXT_OS_VNX);
				svcUseDtl.setQts(resultVo.getOsDskSz() );
			}
			ChargeCalcSimulation simuCalc = new ChargeCalcSimulation(svcUseDtl);
			simuCalc.calcOfAllocQts();
			mmExptPrice = simuCalc.getSvcAmt();
			
			long unitPrice = simuCalc.getUnitPrice();
			long vlaUnit	= simuCalc.getValUnit();
			log.info(svcUseDtl.getOptCd() + " : "+ mmExptPrice);
			resultVo.setOsDskUnitPrice(unitPrice);
			resultVo.setOsDskValUnit(vlaUnit);
			resultVo.setOsDskPrice(mmExptPrice);
			
		}catch(NotFoundUnitPriceException e){
			log.error("notFound unitPirce : "+e.getMessage());
			resultVo.setOsDskErrMsg(e.getMessage());		
		}catch(Exception e){
			log.error(e.getMessage());
			throw new Exception("BillChargeSimulationInterfaceImpl.getOsDiskPrice():" + e.getMessage());
		}finally{
			log.info("BillChargeSimulationInterfaceImpl.getOsDiskPrice end #######################");
		}
		return resultVo;
	}
	
	/**
	 * <p>//data DISK(VNX) 월 예상금액 조회  
	 * @param BillChargeSimulationVO: 요금계산기신청내역
	 * @return BillChargeSimulationVO 요금계산기신청내역 + 월예상금액+에러메세지
	 * @throws Exception
	 */
	public BillChargeSimulationVO getDataDiskPrice(BillChargeSimulationVO svcDtl)throws Exception{
		log.info("BillChargeSimulationInterfaceImpl.getDataDiskPrice start #######################");
		ActSvcUseDtlVO svcUseDtl = new ActSvcUseDtlVO();
		BillChargeSimulationVO resultVo = svcDtl;
		long mmExptPrice =0;
		try{
			//int iCnt = 0;
			//센터코드
			svcUseDtl.setCntrCd(resultVo.getCntrCd());
			//가상화코드
			svcUseDtl.setVrtlCd(resultVo.getVtrlCd());
			//OS코드
			svcUseDtl.setOsCd(resultVo.getOsCd());
			//관계사 코드 
			svcUseDtl.setAfltCd(resultVo.getAfltCd());
			//OPT_CD_EXT_OS_VNX 셋팅
			log.info(" OPT_CD_EXT_DATA_VNX : " + resultVo.getDataDskSz());
			if(resultVo.getDataDskSz() > 0 ){
				svcUseDtl.setTypCd(BillingConstants.TYP_CD_DISK);
				svcUseDtl.setOptCd(BillingConstants.OPT_CD_EXT_DATA_VNX);
				svcUseDtl.setQts(resultVo.getDataDskSz());
			}
			ChargeCalcSimulation simuCalc = new ChargeCalcSimulation(svcUseDtl);
			simuCalc.calcOfAllocQts();
			mmExptPrice = simuCalc.getSvcAmt();
			
			long unitPrice = simuCalc.getUnitPrice();
			long valUnit = simuCalc.getValUnit();
			log.info(svcUseDtl.getOptCd() + " : "+ mmExptPrice);
			resultVo.setDataDskUnitPrice(unitPrice);
			resultVo.setDataDskValUnit(valUnit);
			resultVo.setDataDskPrice(mmExptPrice);
			
		}catch(NotFoundUnitPriceException e){
			log.error("notFound unitPirce : "+e.getMessage());
			resultVo.setDataDskErrMsg(e.getMessage());	
		}catch(Exception e){
			log.error(e.getMessage());
			throw new Exception("BillChargeSimulationInterfaceImpl.getDataDiskPrice():" + e.getMessage());
		}finally{
			log.info("BillChargeSimulationInterfaceImpl.getDataDiskPrice end #######################");
		}
		return resultVo;
	}
	
	/**
	 * <p>OsV7000 월 예상금액 조회  
	 * @param BillChargeSimulationVO: 요금계산기신청내역
	 * @return BillChargeSimulationVO 요금계산기신청내역 + 월예상금액+에러메세지
	 * @throws Exception
	 */
	public BillChargeSimulationVO getOsV7000DiskPrice(BillChargeSimulationVO svcDtl)throws Exception{
		log.info("BillChargeSimulationInterfaceImpl.getOsV7000SzPrice start #######################");
		ActSvcUseDtlVO svcUseDtl = new ActSvcUseDtlVO();
		BillChargeSimulationVO resultVo = svcDtl;
		long mmExptPrice =0;
		
		try{
			//센터코드
			svcUseDtl.setCntrCd(resultVo.getCntrCd());
			//가상화코드
			svcUseDtl.setVrtlCd(resultVo.getVtrlCd());
			//OS코드
			svcUseDtl.setOsCd(resultVo.getOsCd());
			//관계사 코드 
			svcUseDtl.setAfltCd(resultVo.getAfltCd());
			log.info(" OPT_CD_EXT_OS_V7K : " + resultVo.getOsV7000Sz());
			if(resultVo.getOsV7000Sz() > 0 ){
				svcUseDtl.setTypCd(BillingConstants.TYP_CD_DISK);
				svcUseDtl.setOptCd(BillingConstants.OPT_CD_EXT_OS_V7K);
				svcUseDtl.setQts(resultVo.getOsV7000Sz() );
			}
			ChargeCalcSimulation simuCalc = new ChargeCalcSimulation(svcUseDtl);
			simuCalc.calcOfAllocQts();
			mmExptPrice = simuCalc.getSvcAmt();
			
			long unitPrice = simuCalc.getUnitPrice();
			long valUnit	= simuCalc.getValUnit();
			log.info(svcUseDtl.getOptCd() + " : "+ mmExptPrice);
			resultVo.setOsV7000UnitPrice(unitPrice);
			resultVo.setOsV7000ValUnit(valUnit);
			resultVo.setOsV7000Price(mmExptPrice);
			
			
		}catch(NotFoundUnitPriceException e){
			log.error("notFound unitPirce : "+e.getMessage());
			resultVo.setOsV7000ErrMsg(e.getMessage());	

		}catch(Exception e){
			log.error(e.getMessage());
			throw new Exception("BillChargeSimulationInterfaceImpl.getOsV7000SzPrice():" + e.getMessage());
		}finally{
			log.info("BillChargeSimulationInterfaceImpl.getOsV7000SzPrice end #######################");
		}
		return resultVo;
	}
	
	/**
	 * <p>DataV7000 월 예상금액 조회  
	 * @param BillChargeSimulationVO: 요금계산기신청내역
	 * @return BillChargeSimulationVO 요금계산기신청내역 + 월예상금액+에러메세지
	 * @throws Exception
	 */
	public BillChargeSimulationVO getDataV7000DiskPrice(BillChargeSimulationVO svcDtl)throws Exception{
		log.info("BillChargeSimulationInterfaceImpl.getDataV7000DiskPrice start #######################");
		ActSvcUseDtlVO svcUseDtl = new ActSvcUseDtlVO();
		BillChargeSimulationVO resultVo = svcDtl;
		long mmExptPrice =0;
		try{
			//int iCnt = 0;
			//센터코드
			svcUseDtl.setCntrCd(resultVo.getCntrCd());
			//가상화코드
			svcUseDtl.setVrtlCd(resultVo.getVtrlCd());
			//OS코드
			svcUseDtl.setOsCd(resultVo.getOsCd());
			//관계사 코드 
			svcUseDtl.setAfltCd(resultVo.getAfltCd());
			log.info(" OPT_CD_EXT_DATA_V7K : " + resultVo.getDataV7000Sz());
			if(resultVo.getDataV7000Sz() > 0 ){
				svcUseDtl.setTypCd(BillingConstants.TYP_CD_DISK);
				svcUseDtl.setOptCd(BillingConstants.OPT_CD_EXT_DATA_V7K);
				svcUseDtl.setQts(resultVo.getDataV7000Sz());
				//svcUseDtlList.add(svcUseDtl);
			}
			//ChargeSimulationCalcService simuCalc = new ChargeSimulationCalcService(svcUseDtl);
			ChargeCalcSimulation simuCalc = new ChargeCalcSimulation(svcUseDtl) ;
			
			simuCalc.calcOfAllocQts();
			mmExptPrice = simuCalc.getSvcAmt();
			long unitPrice = simuCalc.getUnitPrice();
			long valUnit = simuCalc.getValUnit();
			log.info(svcUseDtl.getOptCd() + " : "+ mmExptPrice);
			resultVo.setDataV7000Price(mmExptPrice);
			resultVo.setDataV7000ValUnit(valUnit);
			resultVo.setDataV7000UnitPrice(unitPrice);
			
		}catch(NotFoundUnitPriceException e){
			log.error("notFound unitPirce : "+e.getMessage());
			resultVo.setDataV7000ErrMsg(e.getMessage());	
		}catch(Exception e){
			log.error(e.getMessage());
			throw new Exception("BillChargeSimulationInterfaceImpl.getDataV7000DiskPrice():" + e.getMessage());
		}finally{
			log.info("BillChargeSimulationInterfaceImpl.getDataV7000DiskPrice end #######################");
		}
		return resultVo;
		/////////////////////////////////////////////////////////////////////////////
		
	}
	/**
	 * <p>OS VMAX 월 예상금액 조회  
	 * @param BillChargeSimulationVO: 요금계산기신청내역
	 * @return BillChargeSimulationVO 요금계산기신청내역 + 월예상금액+에러메세지
	 * @throws Exception
	 */
	public BillChargeSimulationVO getOsVmaxDiskPrice(BillChargeSimulationVO svcDtl)throws Exception{
		log.info("BillChargeSimulationInterfaceImpl.getOsVmaxDiskPrice start #######################");
		ActSvcUseDtlVO svcUseDtl = new ActSvcUseDtlVO();
		BillChargeSimulationVO resultVo = svcDtl;
		long mmExptPrice =0;
		try{
			//int iCnt = 0;
			//센터코드
			svcUseDtl.setCntrCd(resultVo.getCntrCd());
			//가상화코드
			svcUseDtl.setVrtlCd(resultVo.getVtrlCd());
			//OS코드
			svcUseDtl.setOsCd(resultVo.getOsCd());
			//관계사 코드 
			svcUseDtl.setAfltCd(resultVo.getAfltCd());
			log.info(" OPT_CD_EXT_OS_VMAX : " + resultVo.getOsVmaxSz());
			if(resultVo.getOsVmaxSz() > 0 ){
				svcUseDtl.setTypCd(BillingConstants.TYP_CD_DISK);
				svcUseDtl.setOptCd(BillingConstants.OPT_CD_EXT_OS_VMAX);
				svcUseDtl.setQts(resultVo.getOsVmaxSz() );
				//svcUseDtlList.add(svcUseDtl);
			}
			ChargeCalcSimulation simuCalc = new ChargeCalcSimulation(svcUseDtl);
			simuCalc.calcOfAllocQts();
			mmExptPrice = simuCalc.getSvcAmt();
			log.info(svcUseDtl.getOptCd() + " : "+ mmExptPrice);
			resultVo.setOsVmaxPrice(mmExptPrice);
			
			long unitPrice = simuCalc.getUnitPrice();
			long valUnit = simuCalc.getValUnit();
			log.info(svcUseDtl.getOptCd() + " : "+ mmExptPrice);
			resultVo.setOsVmaxPrice(mmExptPrice);
			resultVo.setOsVmaxValUnit(valUnit);
			resultVo.setOsVmaxUnitPrice(unitPrice);
			
		}catch(NotFoundUnitPriceException e){
			log.error("notFound unitPirce : "+e.getMessage());
			resultVo.setOsVmaxErrMsg(e.getMessage());		
		}catch(Exception e){
			log.error(e.getMessage());
			throw new Exception("BillChargeSimulationInterfaceImpl.getOsVmaxDiskPrice():" + e.getMessage());
		}finally{
			log.info("BillChargeSimulationInterfaceImpl.getOsVmaxDiskPrice end #######################");
		}
		return resultVo;
	}
	
	/**
	 * <p>data VMAX 월 예상금액 조회  
	 * @param BillChargeSimulationVO: 요금계산기신청내역
	 * @return BillChargeSimulationVO 요금계산기신청내역 + 월예상금액+에러메세지
	 * @throws Exception
	 */
	public BillChargeSimulationVO getDataVmaxDiskPrice(BillChargeSimulationVO svcDtl)throws Exception{
		log.info("BillChargeSimulationInterfaceImpl.getDataVmaxDiskPrice start #######################");
		ActSvcUseDtlVO svcUseDtl = new ActSvcUseDtlVO();
		BillChargeSimulationVO resultVo = svcDtl;
		long mmExptPrice =0;
		try{
			//int iCnt = 0;
			//센터코드
			svcUseDtl.setCntrCd(resultVo.getCntrCd());
			//가상화코드
			svcUseDtl.setVrtlCd(resultVo.getVtrlCd());
			//OS코드
			svcUseDtl.setOsCd(resultVo.getOsCd());
			//관계사 코드 
			svcUseDtl.setAfltCd(resultVo.getAfltCd());
			log.info(" OPT_CD_EXT_DATA_VMAX : " + resultVo.getDataVmaxSz());
			if(resultVo.getDataVmaxSz() > 0 ){
				svcUseDtl.setTypCd(BillingConstants.TYP_CD_DISK);
				svcUseDtl.setOptCd(BillingConstants.OPT_CD_EXT_DATA_VMAX);
				svcUseDtl.setQts(resultVo.getDataVmaxSz());
				//svcUseDtlList.add(svcUseDtl);
			}
			ChargeCalcSimulation simuCalc = new ChargeCalcSimulation(svcUseDtl);
			simuCalc.calcOfAllocQts();
			mmExptPrice = simuCalc.getSvcAmt();
			
			long unitPrice = simuCalc.getUnitPrice();
			long valUnit = simuCalc.getValUnit();
			log.info(svcUseDtl.getOptCd() + " : "+ mmExptPrice);
			resultVo.setDataVmaxPrice(mmExptPrice);
			resultVo.setDataVmaxValUnit(valUnit);
			resultVo.setDataVmaxUnitPrice(unitPrice);
			
		}catch(NotFoundUnitPriceException e){
			log.error("notFound unitPirce : "+e.getMessage());
			resultVo.setDataVmaxErrMsg(e.getMessage());			
		}catch(Exception e){
			log.error(e.getMessage());
			throw new Exception("BillChargeSimulationInterfaceImpl.getDataVmaxPrice():" + e.getMessage());
		}finally{
			log.info("BillChargeSimulationInterfaceImpl.getDataVmaxDiskPrice end #######################");
		}
		return resultVo;
	}
	
	/**
	 * <p>OS Nutanix 월 예상금액 조회  
	 * @param BillChargeSimulationVO: 요금계산기신청내역
	 * @return BillChargeSimulationVO 요금계산기신청내역 + 월예상금액+에러메세지
	 * @throws Exception
	 */
	public BillChargeSimulationVO getNutanixOsDiskPrice(BillChargeSimulationVO svcDtl)throws Exception{
		log.info("BillChargeSimulationInterfaceImpl.getNutanixOsDiskPrice start #######################");
		ActSvcUseDtlVO svcUseDtl = new ActSvcUseDtlVO();
		BillChargeSimulationVO resultVo = svcDtl;
		long mmExptPrice =0;
		try{
			//int iCnt = 0;
			//센터코드
			svcUseDtl.setCntrCd(resultVo.getCntrCd());
			//가상화코드
			svcUseDtl.setVrtlCd(resultVo.getVtrlCd());
			//OS코드
			svcUseDtl.setOsCd(resultVo.getOsCd());
			//관계사 코드 
			svcUseDtl.setAfltCd(resultVo.getAfltCd());
			log.info(" OPT_CD_NTX_OS_DISK : " + resultVo.getNutanixOsDskSz());
			if(resultVo.getNutanixOsDskSz() > 0 ){
				svcUseDtl.setTypCd(BillingConstants.TYP_CD_DISK);
				svcUseDtl.setOptCd(BillingConstants.OPT_CD_NTX_OS_DISK);
				svcUseDtl.setQts(resultVo.getNutanixOsDskSz());
				//svcUseDtlList.add(svcUseDtl);
			}
			ChargeCalcSimulation simuCalc = new ChargeCalcSimulation(svcUseDtl);
			simuCalc.calcOfAllocQts();
			mmExptPrice = simuCalc.getSvcAmt();
			
			long unitPrice = simuCalc.getUnitPrice();
			long valUnit = simuCalc.getValUnit();
			log.info(svcUseDtl.getOptCd() + " : "+ mmExptPrice);
			resultVo.setNutanixOsDskPrice(mmExptPrice);
			resultVo.setNutanixOsDskValUnit(valUnit);
			resultVo.setNutanixOsDskUnitPrice(unitPrice);
			
		}catch(NotFoundUnitPriceException e){
			log.error("notFound unitPirce : "+e.getMessage());
			resultVo.setNutanixOsDskErrMsg(e.getMessage());			
		}catch(Exception e){
			log.error(e.getMessage());
			throw new Exception("BillChargeSimulationInterfaceImpl.getNutanixOsDiskPrice():" + e.getMessage());
		}finally{
			log.info("BillChargeSimulationInterfaceImpl.getNutanixOsDiskPrice end #######################");
		}
		return resultVo;
	}	
	
	
	/**
	 * <p>Data Nutanix 월 예상금액 조회  
	 * @param BillChargeSimulationVO: 요금계산기신청내역
	 * @return BillChargeSimulationVO 요금계산기신청내역 + 월예상금액+에러메세지
	 * @throws Exception
	 */
	public BillChargeSimulationVO getNutanixDataDiskPrice(BillChargeSimulationVO svcDtl)throws Exception{
		log.info("BillChargeSimulationInterfaceImpl.getDataVmaxDiskPrice start #######################");
		ActSvcUseDtlVO svcUseDtl = new ActSvcUseDtlVO();
		BillChargeSimulationVO resultVo = svcDtl;
		long mmExptPrice =0;
		try{
			//int iCnt = 0;
			//센터코드
			svcUseDtl.setCntrCd(resultVo.getCntrCd());
			//가상화코드
			svcUseDtl.setVrtlCd(resultVo.getVtrlCd());
			//OS코드
			svcUseDtl.setOsCd(resultVo.getOsCd());
			//관계사 코드 
			svcUseDtl.setAfltCd(resultVo.getAfltCd());
			log.info(" OPT_CD_NTX_DATA_DISK : " + resultVo.getNutanixDataDskSz());
			if(resultVo.getNutanixDataDskSz() > 0 ){
				svcUseDtl.setTypCd(BillingConstants.TYP_CD_DISK);
				svcUseDtl.setOptCd(BillingConstants.OPT_CD_NTX_DATA_DISK);
				svcUseDtl.setQts(resultVo.getNutanixDataDskSz());
				//svcUseDtlList.add(svcUseDtl);
			}
			ChargeCalcSimulation simuCalc = new ChargeCalcSimulation(svcUseDtl);
			simuCalc.calcOfAllocQts();
			mmExptPrice = simuCalc.getSvcAmt();
			
			long unitPrice = simuCalc.getUnitPrice();
			long valUint = simuCalc.getValUnit();
			log.info(svcUseDtl.getOptCd() + " : "+ mmExptPrice);
			resultVo.setNutanixDataDskPrice(mmExptPrice);
			resultVo.setNutanixDataDskValUnit(valUint);
			resultVo.setNutanixDataDskUnitPrice(unitPrice);
			
		}catch(NotFoundUnitPriceException e){
			log.error("notFound unitPirce : "+e.getMessage());
			resultVo.setNutanixDataDskErrMsg(e.getMessage());			
		}catch(Exception e){
			log.error(e.getMessage());
			throw new Exception("BillChargeSimulationInterfaceImpl.getNutanixDataDiskPrice():" + e.getMessage());
		}finally{
			log.info("BillChargeSimulationInterfaceImpl.getNutanixDataDiskPrice end #######################");
		}
		return resultVo;
	}	
	
	/**
	 * <p>ha service 월 예상금액 조회  
	 * @param BillChargeSimulationVO: 요금계산기신청내역
	 * @return BillChargeSimulationVO 요금계산기신청내역 + 월예상금액+에러메세지
	 * @throws Exception
	 */
	public BillChargeSimulationVO getHaPrice(BillChargeSimulationVO svcDtl)throws Exception{
		log.info("BillChargeSimulationInterfaceImpl.getHaPrice start #######################");
		ActSvcUseDtlVO svcUseDtl = new ActSvcUseDtlVO();
		BillChargeSimulationVO resultVo = svcDtl;
		long mmExptPrice =0;
		try{
			//int iCnt = 0;
			//센터코드
			svcUseDtl.setCntrCd(resultVo.getCntrCd());
			//가상화코드
			svcUseDtl.setVrtlCd(resultVo.getVtrlCd());
			//OS코드
			svcUseDtl.setOsCd(resultVo.getOsCd());
			//관계사 코드 
			svcUseDtl.setAfltCd(resultVo.getAfltCd());
			log.info(" OPT_CD_HA_SERVICE : " + resultVo.isHa());
			if(resultVo.isHa() ){
				svcUseDtl.setTypCd(BillingConstants.TYP_CD_HA);
				svcUseDtl.setOptCd(BillingConstants.OPT_CD_HA_SERVICE);
				svcUseDtl.setDoubleQts(resultVo.getCoreCnt());
				//svcUseDtlList.add(svcUseDtl);
			}
			ChargeCalcSimulation simuCalc = new ChargeCalcSimulation(svcUseDtl);
			simuCalc.calcOfAllocQts();
			mmExptPrice = simuCalc.getSvcAmt();
		
			
			long unitPrice = simuCalc.getUnitPrice();
			log.info(svcUseDtl.getOptCd() + " : "+ mmExptPrice);
			resultVo.setHaPrice(mmExptPrice);
			resultVo.setHaUnitPrice(unitPrice);
			
		}catch(NotFoundUnitPriceException e){
			log.error("notFound unitPirce : "+e.getMessage());
			resultVo.setHaErrMsg(e.getMessage());				
		}catch(Exception e){
			log.error(e.getMessage());
			throw new Exception("BillChargeSimulationInterfaceImpl.getHaPrice():" + e.getMessage());
		}finally{
			log.info("BillChargeSimulationInterfaceImpl.getHaPrice end #######################");
		}
		return resultVo;
	}
	
	//////////////////////////////////////////////////////////////////////////////////

	/**
	 * <p>DR  OS 디스크 (EXtreamIO)  월 예상금액 조회  
	 * @param BillChargeSimulationVO: 요금계산기신청내역
	 * @return BillChargeSimulationVO 요금계산기신청내역 + 월예상금액+에러메세지
	 * @throws Exception
	 */
	public BillChargeSimulationVO getEioDiskPrice(BillChargeSimulationVO svcDtl)throws Exception{
		log.info("BillChargeSimulationInterfaceImpl.getEioDiskPrice start #######################");
		ActSvcUseDtlVO svcUseDtl = new ActSvcUseDtlVO();
		BillChargeSimulationVO resultVo = svcDtl;
		long mmExptPrice =0;
		try{
			//int iCnt = 0;
			//센터코드
			svcUseDtl.setCntrCd(resultVo.getCntrCd());
			//가상화코드
			svcUseDtl.setVrtlCd(resultVo.getVtrlCd());
			//OS코드
			svcUseDtl.setOsCd(resultVo.getOsCd());
			//관계사 코드 
			svcUseDtl.setAfltCd(resultVo.getAfltCd());
			log.info(" OPT_CD_EXT_OS_EIO : " + resultVo.getOsEioSz());
			if(resultVo.getOsEioSz() > 0 ){
				svcUseDtl.setTypCd(BillingConstants.TYP_CD_DISK);
				svcUseDtl.setOptCd(BillingConstants.OPT_CD_EXT_OS_EIO);
				svcUseDtl.setQts(resultVo.getOsEioSz());
			}
			ChargeCalcSimulation simuCalc = new ChargeCalcSimulation(svcUseDtl);
			simuCalc.calcOfAllocQts();
			mmExptPrice = simuCalc.getSvcAmt();
			
			long unitPrice = simuCalc.getUnitPrice();
			long valUnit = simuCalc.getValUnit();
			log.info(svcUseDtl.getOptCd() + " : "+ mmExptPrice);
			resultVo.setOsEioPrice(mmExptPrice);
			resultVo.setOsEioValUnit(valUnit);
			resultVo.setOsEioUnitPrice(unitPrice);
			
		}catch(NotFoundUnitPriceException e){
			log.error("notFound unitPirce : "+e.getMessage());
			resultVo.setOsDskErrMsg(e.getMessage());			
		}catch(Exception e){
			log.error(e.getMessage());
			throw new Exception("BillChargeSimulationInterfaceImpl.getEioDiskPrice():" + e.getMessage());
		}finally{
			log.info("BillChargeSimulationInterfaceImpl.getEioDiskPrice end #######################");
		}
		
		return resultVo;
	}
	

	/**
	 * <p>DR UNIX 용 데이터 디스크(VMAX)   월 예상금액 조회  
	 * @param BillChargeSimulationVO: 요금계산기신청내역
	 * @return BillChargeSimulationVO 요금계산기신청내역 + 월예상금액+에러메세지
	 * @throws Exception
	 */
	public BillChargeSimulationVO getUnixDiskPrice(BillChargeSimulationVO svcDtl)throws Exception{
		log.info("BillChargeSimulationInterfaceImpl.getUinxPrice start #######################");
		ActSvcUseDtlVO svcUseDtl = new ActSvcUseDtlVO();
		BillChargeSimulationVO resultVo = svcDtl;
		long mmExptPrice =0;
		try{
			//센터코드
			svcUseDtl.setCntrCd(resultVo.getCntrCd());
			//가상화코드
			svcUseDtl.setVrtlCd(resultVo.getVtrlCd());
			//OS코드
			svcUseDtl.setOsCd(resultVo.getOsCd());
			//관계사 코드 
			svcUseDtl.setAfltCd(resultVo.getAfltCd());
			
			log.info(" DR - OPT_CD_EXT_DATA_VMAX : " + resultVo.getUnixDiskSz());
			if(resultVo.getUnixDiskSz() > 0 ){
				svcUseDtl.setTypCd(BillingConstants.TYP_CD_DISK);
				svcUseDtl.setOptCd(BillingConstants.OPT_CD_EXT_DATA_VMAX);
				svcUseDtl.setQts(resultVo.getUnixDiskSz());
			}
			ChargeCalcSimulation simuCalc = new ChargeCalcSimulation(svcUseDtl);
			simuCalc.calcOfAllocQts();
			mmExptPrice = simuCalc.getSvcAmt();
			
			long unitPrice = simuCalc.getUnitPrice();
			long valUnit = simuCalc.getValUnit();
			log.info(svcUseDtl.getOptCd() + " : "+ mmExptPrice);
			resultVo.setUnixDiskPrice(mmExptPrice);
			resultVo.setUnixDiskValUnit(valUnit);
			resultVo.setUnixDiskUnitPrice(unitPrice);
			
		}catch(NotFoundUnitPriceException e){
			log.error("notFound unitPirce : "+e.getMessage());
			resultVo.setUnixDiskErrMsg(e.getMessage());			
		}catch(Exception e){
			log.error(e.getMessage());
			throw new Exception("BillChargeSimulationInterfaceImpl.getUinxPrice():" + e.getMessage());
		}finally{
			log.info("BillChargeSimulationInterfaceImpl.getUinxPrice end #######################");
		}
		
		return resultVo;
	}
	
	/**
	 * <p>DDR X86용 데이터 디스크(VNX)   월 예상금액 조회  
	 * @param BillChargeSimulationVO: 요금계산기신청내역
	 * @return BillChargeSimulationVO 요금계산기신청내역 + 월예상금액+에러메세지
	 * @throws Exception
	 */
	public BillChargeSimulationVO getVcloudDiskPrice(BillChargeSimulationVO svcDtl)throws Exception{
		log.info("BillChargeSimulationInterfaceImpl.getVcloudDiskPrice start #######################");
		ActSvcUseDtlVO svcUseDtl = new ActSvcUseDtlVO();
		BillChargeSimulationVO resultVo = svcDtl;
		long mmExptPrice =0;
		try{
			//int iCnt = 0;
			//센터코드
			svcUseDtl.setCntrCd(resultVo.getCntrCd());
			//가상화코드
			svcUseDtl.setVrtlCd(resultVo.getVtrlCd());
			//OS코드
			svcUseDtl.setOsCd(resultVo.getOsCd());
			//관계사 코드 
			svcUseDtl.setAfltCd(resultVo.getAfltCd());
			//OPT_CD_EXT_OS_VNX 셋팅
			log.info(" OPT_CD_EXT_DATA_VNX(VCLOUD) : " + resultVo.getvCloudDiskSz());
			if(resultVo.getvCloudDiskSz() > 0 ){
				svcUseDtl.setTypCd(BillingConstants.TYP_CD_DISK);
				svcUseDtl.setOptCd(BillingConstants.OPT_CD_EXT_DATA_VNX);
				svcUseDtl.setQts(resultVo.getvCloudDiskSz());
			}
			ChargeCalcSimulation simuCalc = new ChargeCalcSimulation(svcUseDtl);
			simuCalc.calcOfAllocQts();
			mmExptPrice = simuCalc.getSvcAmt();
			
			long unitPrice = simuCalc.getUnitPrice();
			long valUnit = simuCalc.getValUnit();
			log.info(svcUseDtl.getOptCd() + " : "+ mmExptPrice);
			resultVo.setvCloudDiskUnitPrice(unitPrice);
			resultVo.setvCloudDiskValUnit(valUnit);
			resultVo.setvCloudDiskPrice(mmExptPrice);
			
		}catch(NotFoundUnitPriceException e){
			log.error("notFound unitPirce : "+e.getMessage());
			resultVo.setDataDskErrMsg(e.getMessage());	
		}catch(Exception e){
			log.error(e.getMessage());
			throw new Exception("BillChargeSimulationInterfaceImpl.getVcloudDiskPrice():" + e.getMessage());
		}finally{
			log.info("BillChargeSimulationInterfaceImpl.getVcloudDiskPrice end #######################");
		}
		return resultVo;
	}

	/**
	 * <p>공용 NAS   월 예상금액 조회  
	 * @param BillChargeSimulationVO: 요금계산기신청내역
	 * @return BillChargeSimulationVO 요금계산기신청내역 + 월예상금액+에러메세지
	 * @throws Exception
	 */
	public BillChargeSimulationVO getpubNasPrice(BillChargeSimulationVO svcDtl)throws Exception{
		log.info("BillChargeSimulationInterfaceImpl.getpubNasPrice start #######################");
		ActSvcUseDtlVO svcUseDtl = new ActSvcUseDtlVO();
		BillChargeSimulationVO resultVo = svcDtl;
		long mmExptPrice =0;
		
		try{
			//센터코드
			svcUseDtl.setCntrCd(resultVo.getCntrCd());
			//가상화코드
			svcUseDtl.setVrtlCd(resultVo.getVtrlCd());
			//OS코드
			svcUseDtl.setOsCd(resultVo.getOsCd());
			//관계사 코드 
			svcUseDtl.setAfltCd(resultVo.getAfltCd());
			//센터간 회선 - 공용NAS
			log.info(" pubNasSz : " + resultVo.getPubNasSz());
			if(resultVo.getPubNasSz() > 0){
				svcUseDtl.setTypCd(BillingConstants.TYP_CD_NAS_SHARED);
				svcUseDtl.setOptCd(BillingConstants.OPT_CD_TOTAL_SIZE);
				svcUseDtl.setQts(resultVo.getPubNasSz());
			}		
			ChargeCalcSimulation simuCalc = new ChargeCalcSimulation(svcUseDtl);
			simuCalc.calcOfAllocQts();
			mmExptPrice = simuCalc.getSvcAmt();
			
			long unitPrice = simuCalc.getUnitPrice();
			log.info(svcUseDtl.getOptCd() + " : "+ mmExptPrice);
			resultVo.setPubNasPrice(mmExptPrice);
			resultVo.setPubNasUnitPrice(unitPrice);
		
		}catch(NotFoundUnitPriceException e){
			log.error("notFound unitPirce : "+e.getMessage());
			resultVo.setPubNasErrMsg(e.getMessage());		
		}catch(Exception e){
			log.error(e.getMessage());
			throw new Exception("BillChargeSimulationInterfaceImpl.getpubNasPrice():" + e.getMessage());
		}finally{
			log.info("BillChargeSimulationInterfaceImpl.getpubNasPrice end #######################");
		}
		return resultVo;
	}
		
	
	/**
	 * <p>RealTime 실시간복제  월 예상금액 조회  
	 * @param BillChargeSimulationVO: 요금계산기신청내역
	 * @return BillChargeSimulationVO 요금계산기신청내역 + 월예상금액+에러메세지
	 * @throws Exception
	 */
	public BillChargeSimulationVO getRealTimePrice(BillChargeSimulationVO svcDtl)throws Exception{
		log.info("BillChargeSimulationInterfaceImpl.getRealTimePrice start #######################");
		ActSvcUseDtlVO svcUseDtl = new ActSvcUseDtlVO();
		BillChargeSimulationVO resultVo = svcDtl;
		long mmExptPrice =0;
		
		try{
			//센터코드
			svcUseDtl.setCntrCd(resultVo.getCntrCd());
			//가상화코드
			svcUseDtl.setVrtlCd(resultVo.getVtrlCd());
			//OS코드
			svcUseDtl.setOsCd(resultVo.getOsCd());
			//관계사 코드 
			svcUseDtl.setAfltCd(resultVo.getAfltCd());
			//실시간복제여부
			log.info(" RealTime sz : " + resultVo.getRealTimeSz());
			if(resultVo.getRealTimeSz() > 0){
				svcUseDtl.setTypCd(BillingConstants.TYP_CD_DUPLICATE);
				svcUseDtl.setOptCd(BillingConstants.OPT_CD_REALTIME);
				svcUseDtl.setQts(resultVo.getRealTimeSz());
			}
			ChargeCalcSimulation simuCalc = new ChargeCalcSimulation(svcUseDtl);
			simuCalc.calcOfAllocQts();
			mmExptPrice = simuCalc.getSvcAmt();
			long unitPrice = simuCalc.getUnitPrice();
			
			log.info(svcUseDtl.getOptCd() + " : "+ mmExptPrice);
			resultVo.setRealTimePrice(mmExptPrice);
			resultVo.setRealTimeUnitPrice(unitPrice);
		
		}catch(NotFoundUnitPriceException e){
			log.error("notFound unitPirce : "+e.getMessage());
			resultVo.setRealTimeErrMsg(e.getMessage());				
		
		}catch(Exception e){
			log.error(e.getMessage());
			throw new Exception("BillChargeSimulationInterfaceImpl.getRealTimePrice():" + e.getMessage());
		}finally{
			log.info("BillChargeSimulationInterfaceImpl.getRealTimePrice end #######################");
		}
		return resultVo;
	}

	/**
	 * <p>symantecBackup 소산 월 예상금액 조회  
	 * @param BillChargeSimulationVO: 요금계산기신청내역
	 * @return BillChargeSimulationVO 요금계산기신청내역 + 월예상금액+에러메세지
	 * @throws Exception
	 */
	public BillChargeSimulationVO getSymantecBackupPrice(BillChargeSimulationVO svcDtl)throws Exception{
		log.info("BillChargeSimulationInterfaceImpl.getSymantecBackupPrice start #######################");
		ActSvcUseDtlVO svcUseDtl = new ActSvcUseDtlVO();
		BillChargeSimulationVO resultVo = svcDtl;
		long mmExptPrice =0;
		try{
			//int iCnt = 0;
			//센터코드
			svcUseDtl.setCntrCd(resultVo.getCntrCd());
			//가상화코드
			svcUseDtl.setVrtlCd(resultVo.getVtrlCd());
			//OS코드
			svcUseDtl.setOsCd(resultVo.getOsCd());
			//관계사 코드 
			svcUseDtl.setAfltCd(resultVo.getAfltCd());
			//소산 백업용량
			log.info(" SymantecBackupSz : " + resultVo.getSymantecBackupSz());
			if(resultVo.getSymantecBackupSz() > 0 ){
				svcUseDtl.setTypCd(BillingConstants.TYP_CD_DUPLICATE);
				svcUseDtl.setOptCd(BillingConstants.OPT_CD_TOTAL_SIZE);
				//소산은 백업용량의 3벌을 보관하므로 백업용량의 3배의 용량이 과금되어야함.
				svcUseDtl.setQts(resultVo.getSymantecBackupSz() * 3);
			}
			ChargeCalcSimulation simuCalc = new ChargeCalcSimulation(svcUseDtl);
			simuCalc.calcOfAllocQts();
			mmExptPrice = simuCalc.getSvcAmt();
			log.info(svcUseDtl.getOptCd() + " : "+ mmExptPrice);
			resultVo.setSymantecBackupPrice(mmExptPrice);
			
			long unitPrice = simuCalc.getUnitPrice();
			log.info(svcUseDtl.getOptCd() + " : "+ mmExptPrice);
			resultVo.setSymantecBackupPrice(mmExptPrice);
			resultVo.setSymantecBackupUnitPrice(unitPrice);
		}catch(NotFoundUnitPriceException e){
			log.error("notFound unitPirce : "+e.getMessage());
			resultVo.setSymantecBackupErrMsg(e.getMessage());				
		
		}catch(Exception e){
			log.error(e.getMessage());
			throw new Exception("BillChargeSimulationInterfaceImpl.getSymantecBackupPrice():" + e.getMessage());
		}finally{
			log.info("BillChargeSimulationInterfaceImpl.getSymantecBackupPrice end #######################");
		}
		return resultVo;
	}
	

	/**
	 * <p>TcpIp 실시간 DR 대상 월 예상금액 조회  
	 * @param BillChargeSimulationVO: 요금계산기신청내역
	 * @return BillChargeSimulationVO 요금계산기신청내역 + 월예상금액+에러메세지
	 * @throws Exception
	 */
	public BillChargeSimulationVO getTcpIpOsPrice(BillChargeSimulationVO svcDtl)throws Exception{
		log.info("BillChargeSimulationInterfaceImpl.getTcpIpOsPrice start #######################");
		ActSvcUseDtlVO svcUseDtl = new ActSvcUseDtlVO();
		BillChargeSimulationVO resultVo = svcDtl;
		long mmExptPrice =0;
		
		try{
			//int iCnt = 0;
			//센터코드
			svcUseDtl.setCntrCd(resultVo.getCntrCd());
			//가상화코드
			svcUseDtl.setVrtlCd(resultVo.getVtrlCd());
			//OS코드
			svcUseDtl.setOsCd(resultVo.getOsCd());
			//관계사 코드 
			svcUseDtl.setAfltCd(resultVo.getAfltCd());
			 //센터간 회선 - 실시간 DR- 신규생성
			log.info(" isTcpIpOs : " + resultVo.isTcpIpOs());
			if(resultVo.isTcpIpOs()){
				svcUseDtl.setTypCd(BillingConstants.TYP_CD_DR_CIRCUIT);
				svcUseDtl.setOptCd(BillingConstants.OPT_CD_TCP_IP_OS);
			}
			ChargeCalcSimulation simuCalc = new ChargeCalcSimulation(svcUseDtl);
			simuCalc.calcOfAllocQts();
			mmExptPrice = simuCalc.getSvcAmt();
			long unitPrice = simuCalc.getUnitPrice();
			log.info(svcUseDtl.getOptCd() + " : "+ mmExptPrice);
			resultVo.setTcpIpOsPrice(mmExptPrice);
			resultVo.setTcpIpOsUnitPrice(unitPrice);
			
		}catch(NotFoundUnitPriceException e){
			log.error("notFound unitPirce : "+e.getMessage());
			resultVo.setTcpIpOsErrMsg(e.getMessage());			
		}catch(Exception e){
			log.error(e.getMessage());
			throw new Exception("BillChargeSimulationInterfaceImpl.getTcpIpOsPrice():" + e.getMessage());
		}finally{
			log.info("BillChargeSimulationInterfaceImpl.getTcpIpOsPrice end #######################");
		}
		return resultVo;
	}

	/**
	 * <p>TCPIP NAS; 월 예상금액 조회  
	 * @param BillChargeSimulationVO: 요금계산기신청내역
	 * @return BillChargeSimulationVO 요금계산기신청내역 + 월예상금액+에러메세지
	 * @throws Exception
	 */ 
	public BillChargeSimulationVO getTcpIpNasPrice(BillChargeSimulationVO svcDtl)throws Exception{
		log.info("BillChargeSimulationInterfaceImpl.getTcpIpNasPrice start #######################");
		ActSvcUseDtlVO svcUseDtl = new ActSvcUseDtlVO();
		BillChargeSimulationVO resultVo = svcDtl;
		long mmExptPrice =0;
		
		try{
			//센터코드
			svcUseDtl.setCntrCd(resultVo.getCntrCd());
			//가상화코드
			svcUseDtl.setVrtlCd(resultVo.getVtrlCd());
			//OS코드
			svcUseDtl.setOsCd(resultVo.getOsCd());
			//관계사 코드 
			svcUseDtl.setAfltCd(resultVo.getAfltCd());
			//센터간 회선 - 공용NAS
			log.info(" TcpIpNasSz : " + resultVo.getTcpIpNasSz());
			if(resultVo.getPubNasSz() > 0){
				svcUseDtl.setTypCd(BillingConstants.TYP_CD_DR_CIRCUIT);
				svcUseDtl.setOptCd(BillingConstants.OPT_CD_TCP_IP_NAS);
				svcUseDtl.setQts(resultVo.getTcpIpNasSz());
			}		
			ChargeCalcSimulation simuCalc = new ChargeCalcSimulation(svcUseDtl);
			simuCalc.calcOfAllocQts();
			mmExptPrice = simuCalc.getSvcAmt();
			
			long unitPrice = simuCalc.getUnitPrice();
			log.info(svcUseDtl.getOptCd() + " : "+ mmExptPrice);
			resultVo.setTcpIpNasPrice(mmExptPrice);
			resultVo.setTcpIpNasUnitPrice(unitPrice);
		
		}catch(NotFoundUnitPriceException e){
			log.error("notFound unitPirce : "+e.getMessage());
			resultVo.setPubNasErrMsg(e.getMessage());		
		}catch(Exception e){
			log.error(e.getMessage());
			throw new Exception("BillChargeSimulationInterfaceImpl.getTcpIpNasPrice():" + e.getMessage());
		}finally{
			log.info("BillChargeSimulationInterfaceImpl.getTcpIpNasPrice end #######################");
		}
		return resultVo;
	}
	
	/**
	 * <p>TcpIp Adg 월 예상금액 조회  
	 * @param BillChargeSimulationVO: 요금계산기신청내역
	 * @return BillChargeSimulationVO 요금계산기신청내역 + 월예상금액+에러메세지
	 * @throws Exception
	 */
	public BillChargeSimulationVO getTcpIpAdgPrice(BillChargeSimulationVO svcDtl)throws Exception{
		log.info("BillChargeSimulationInterfaceImpl.getTcpIpAdgPrice start #######################");
		ActSvcUseDtlVO svcUseDtl = new ActSvcUseDtlVO();
		BillChargeSimulationVO resultVo = svcDtl;
		long mmExptPrice =0;
		
		try{
			//센터코드
			svcUseDtl.setCntrCd(resultVo.getCntrCd());
			//가상화코드
			svcUseDtl.setVrtlCd(resultVo.getVtrlCd());
			//OS코드
			svcUseDtl.setOsCd(resultVo.getOsCd());
			//관계사 코드 
			svcUseDtl.setAfltCd(resultVo.getAfltCd());
			//센터간 회선  -exa
			log.info(" TcpIpAdg : " + resultVo.getTcpIpAdgSz());
			if(resultVo.getTcpIpAdgSz() > 0){
				svcUseDtl.setTypCd(BillingConstants.TYP_CD_DR_CIRCUIT);
				svcUseDtl.setOptCd(BillingConstants.OPT_CD_TCP_IP_ADG);
				svcUseDtl.setQts(resultVo.getTcpIpAdgSz());
			}
			ChargeCalcSimulation simuCalc = new ChargeCalcSimulation(svcUseDtl);
			simuCalc.calcOfAllocQts();
			mmExptPrice = simuCalc.getSvcAmt();
			
			long unitPrice = simuCalc.getUnitPrice();
			log.info(svcUseDtl.getOptCd() + " : "+ mmExptPrice);
			resultVo.setTcpIpAdgPrice(mmExptPrice);
			resultVo.setTcpIpAdgUnitPrice(unitPrice);
			
		}catch(NotFoundUnitPriceException e){
			log.error("notFound unitPirce : "+e.getMessage());
			resultVo.setTcpIpAdgErrMsg(e.getMessage());		
		}catch(Exception e){
			log.error(e.getMessage());
			throw new Exception("BillChargeSimulationInterfaceImpl.getTcpIpAdgPrice():" + e.getMessage());
		}finally{
			log.info("BillChargeSimulationInterfaceImpl.getTcpIpAdgPrice end #######################");
		}
		return resultVo;
	}
	
	/**
	 * <p>TcpIpArk 월 예상금액 조회  
	 * @param BillChargeSimulationVO: 요금계산기신청내역
	 * @return BillChargeSimulationVO 요금계산기신청내역 + 월예상금액+에러메세지
	 * @throws Exception
	 */
	public BillChargeSimulationVO getTcpIpArkPrice(BillChargeSimulationVO svcDtl)throws Exception{
		log.info("BillChargeSimulationInterfaceImpl.getTcpIpArkPrice start #######################");
		ActSvcUseDtlVO svcUseDtl = new ActSvcUseDtlVO();
		BillChargeSimulationVO resultVo = svcDtl;
		long mmExptPrice =0;
		
		try{
			//센터코드
			svcUseDtl.setCntrCd(resultVo.getCntrCd());
			//가상화코드
			svcUseDtl.setVrtlCd(resultVo.getVtrlCd());
			//OS코드
			svcUseDtl.setOsCd(resultVo.getOsCd());
			//관계사 코드 
			svcUseDtl.setAfltCd(resultVo.getAfltCd());
			//센터간 회선 
			log.info(" TcpIpArk : " + resultVo.getTcpIpArkSz());
			if(resultVo.getTcpIpArkSz() > 0){
				svcUseDtl.setTypCd(BillingConstants.TYP_CD_DR_CIRCUIT);
				svcUseDtl.setOptCd(BillingConstants.OPT_CD_TCP_IP_ARK);
				svcUseDtl.setQts(resultVo.getTcpIpArkSz());
			}
			ChargeCalcSimulation simuCalc = new ChargeCalcSimulation(svcUseDtl);
			simuCalc.calcOfAllocQts();
			mmExptPrice = simuCalc.getSvcAmt();
			
			long unitPrice = simuCalc.getUnitPrice();
			log.info(svcUseDtl.getOptCd() + " : "+ mmExptPrice);
			resultVo.setTcpIpArkPrice(mmExptPrice);
			resultVo.setTcpIpArkUnitPrice(unitPrice);
			
		}catch(NotFoundUnitPriceException e){
			log.error("notFound unitPirce : "+e.getMessage());
			resultVo.setTcpIpArkErrMsg(e.getMessage());		
		}catch(Exception e){
			log.error(e.getMessage());
			throw new Exception("BillChargeSimulationInterfaceImpl.getTcpIpArkPrice():" + e.getMessage());
		}finally{
			log.info("BillChargeSimulationInterfaceImpl.getTcpIpArkPrice end #######################");
		}
		return resultVo;
	}
	
	/**
	 * <p>TcpIpBackup 소산 월 예상금액 조회  
	 * @param BillChargeSimulationVO: 요금계산기신청내역
	 * @return BillChargeSimulationVO 요금계산기신청내역 + 월예상금액+에러메세지
	 * @throws Exception
	 */
	public BillChargeSimulationVO getTcpIpBackupPrice(BillChargeSimulationVO svcDtl)throws Exception{
		log.info("BillChargeSimulationInterfaceImpl.getTcpIpBackupPrice start #######################");
		ActSvcUseDtlVO svcUseDtl = new ActSvcUseDtlVO();
		BillChargeSimulationVO resultVo = svcDtl;
		long mmExptPrice =0;
		
		try{
			//센터코드
			svcUseDtl.setCntrCd(resultVo.getCntrCd());
			//가상화코드
			svcUseDtl.setVrtlCd(resultVo.getVtrlCd());
			//OS코드
			svcUseDtl.setOsCd(resultVo.getOsCd());
			//관계사 코드 
			svcUseDtl.setAfltCd(resultVo.getAfltCd());
			//센터간 회선  -소산용량으로 함 
			log.info("소산용량:"+ resultVo.getTcpIpBackupSz());
			if(resultVo.getTcpIpBackupSz() > 0){
				svcUseDtl.setTypCd(BillingConstants.TYP_CD_DR_CIRCUIT);
				svcUseDtl.setOptCd(BillingConstants.OPT_CD_TCP_IP_BACKUP);
				svcUseDtl.setQts(resultVo.getTcpIpBackupSz());
			}
			ChargeCalcSimulation simuCalc = new ChargeCalcSimulation(svcUseDtl);
			simuCalc.calcOfAllocQts();
			mmExptPrice = simuCalc.getSvcAmt();
			
			long unitPrice = simuCalc.getUnitPrice();
			log.info(svcUseDtl.getOptCd() + " : "+ mmExptPrice);
			resultVo.setTcpIpBackupPrice(mmExptPrice);
			resultVo.setTcpIpBackupUnitPrice(unitPrice);
		}catch(NotFoundUnitPriceException e){
			log.error("notFound unitPirce : "+e.getMessage());
			resultVo.setTcpIpBackupErrMsg(e.getMessage());		
		}catch(Exception e){
			log.error(e.getMessage());
			throw new Exception("BillChargeSimulationInterfaceImpl.getTcpIpBackupPrice():" + e.getMessage());
		}finally{
			log.info("BillChargeSimulationInterfaceImpl.getTcpIpBackupPrice end #######################");
		}
		return resultVo;
	}
	
	/**
	 * <p>TcpIpFc; 실시간 복제 월 예상금액 조회  
	 * @param BillChargeSimulationVO: 요금계산기신청내역
	 * @return BillChargeSimulationVO 요금계산기신청내역 + 월예상금액+에러메세지
	 * @throws Exception
	 */
	public BillChargeSimulationVO getTcpIpFcPrice(BillChargeSimulationVO svcDtl)throws Exception{
		log.info("BillChargeSimulationInterfaceImpl.getTcpIpFcPrice start #######################");
		ActSvcUseDtlVO svcUseDtl = new ActSvcUseDtlVO();
		BillChargeSimulationVO resultVo = svcDtl;
		long mmExptPrice =0;
		
		try{
			//센터코드
			svcUseDtl.setCntrCd(resultVo.getCntrCd());
			//가상화코드
			svcUseDtl.setVrtlCd(resultVo.getVtrlCd());
			//OS코드
			svcUseDtl.setOsCd(resultVo.getOsCd());
			//관계사 코드 
			svcUseDtl.setAfltCd(resultVo.getAfltCd());
			//센터간 회선  - 실시간복제
			log.info(" TcpIpFc : " + resultVo.getTcpIpFcSz());
			if(resultVo.getTcpIpFcSz() > 0 ){
				svcUseDtl.setTypCd(BillingConstants.TYP_CD_DR_CIRCUIT);
				svcUseDtl.setOptCd(BillingConstants.OPT_CD_TCP_IP_FC);
				svcUseDtl.setQts(resultVo.getTcpIpFcSz());
			}		
			ChargeCalcSimulation simuCalc = new ChargeCalcSimulation(svcUseDtl);
			simuCalc.calcOfAllocQts();
			mmExptPrice = simuCalc.getSvcAmt();
			
			
			long unitPrice = simuCalc.getUnitPrice();
			log.info(svcUseDtl.getOptCd() + " : "+ mmExptPrice);
			resultVo.setTcpIpFcPrice(mmExptPrice);
			resultVo.setTcpIpFcUnitPrice(unitPrice);
			
		}catch(NotFoundUnitPriceException e){
			log.error("notFound unitPirce : "+e.getMessage());
			resultVo.setTcpIpFcErrMsg(e.getMessage());		
		}catch(Exception e){
			log.error(e.getMessage());
			throw new Exception("BillChargeSimulationInterfaceImpl.getTcpIpFcPrice():" + e.getMessage());
		}finally{
			log.info("BillChargeSimulationInterfaceImpl.getTcpIpFcPrice end #######################");
		}
		return resultVo;
	}

	/**
	 * <p>TcpIp 인터넷 월 예상금액 조회  
	 * @param BillChargeSimulationVO: 요금계산기신청내역
	 * @return BillChargeSimulationVO 요금계산기신청내역 + 월예상금액+에러메세지
	 * @throws Exception
	 */
	public BillChargeSimulationVO getTcpIpInternetPrice(BillChargeSimulationVO svcDtl)throws Exception{
		log.info("BillChargeSimulationInterfaceImpl.getTcpIpInternetPrice start #######################");
		ActSvcUseDtlVO svcUseDtl = new ActSvcUseDtlVO();
		BillChargeSimulationVO resultVo = svcDtl;
		long mmExptPrice =0;
		
		try{
			//int iCnt = 0;
			//센터코드
			svcUseDtl.setCntrCd(resultVo.getCntrCd());
			//가상화코드
			svcUseDtl.setVrtlCd(resultVo.getVtrlCd());
			//OS코드
			svcUseDtl.setOsCd(resultVo.getOsCd());
			//관계사 코드 
			svcUseDtl.setAfltCd(resultVo.getAfltCd());
			 //센터간 회선 - 실시간 DR- 신규생성
			log.info(" isTcpIpInternet : " + resultVo.isTcpIpInternet());
			if(resultVo.isTcpIpInternet()){
				svcUseDtl.setTypCd(BillingConstants.TYP_CD_DR_CIRCUIT);
				svcUseDtl.setOptCd(BillingConstants.OPT_CD_INTERNET);
			}
			ChargeCalcSimulation simuCalc = new ChargeCalcSimulation(svcUseDtl);
			simuCalc.calcOfAllocQts();
			mmExptPrice = simuCalc.getSvcAmt();
			long unitPrice = simuCalc.getUnitPrice();
			log.info(svcUseDtl.getOptCd() + " : "+ mmExptPrice);
			resultVo.setTcpIpInternetPrice(mmExptPrice);
			resultVo.setTcpIpInternetUnitPrice(unitPrice);
			
		}catch(NotFoundUnitPriceException e){
			log.error("notFound unitPirce : "+e.getMessage());
			resultVo.setTcpIpInternetErrMsg(e.getMessage());			
		}catch(Exception e){
			log.error(e.getMessage());
			throw new Exception("BillChargeSimulationInterfaceImpl.getTcpIpInternetPrice():" + e.getMessage());
		}finally{
			log.info("BillChargeSimulationInterfaceImpl.getTcpIpInternetPrice end #######################");
		}
		return resultVo;
	}
	
	/**
	 * <p>NwNework 네트워크 월 예상금액 조회  
	 * @param BillChargeSimulationVO: 요금계산기신청내역
	 * @return BillChargeSimulationVO 요금계산기신청내역 + 월예상금액+에러메세지
	 * @throws Exception
	 */
	public BillChargeSimulationVO getNwNetworkPrice(BillChargeSimulationVO svcDtl)throws Exception{
		log.info("BillChargeSimulationInterfaceImpl.getNwSecurityPrice start #######################");
		ActSvcUseDtlVO svcUseDtl = new ActSvcUseDtlVO();
		BillChargeSimulationVO resultVo = svcDtl;
		long mmExptPrice =0;
		
		try{
			//센터코드
			svcUseDtl.setCntrCd(resultVo.getCntrCd());
			//가상화코드
			svcUseDtl.setVrtlCd(resultVo.getVtrlCd());
			//OS코드
			svcUseDtl.setOsCd(resultVo.getOsCd());
			//관계사 코드 
			svcUseDtl.setAfltCd(resultVo.getAfltCd());
			//센터간 회선 -  보안
			log.info(" isNwSecurity : " + resultVo.isNwSecurity());
			if(resultVo.isNwSecurity()){
				svcUseDtl.setTypCd(BillingConstants.TYP_CD_NETWORK_PUBLIC);
				svcUseDtl.setOptCd(BillingConstants.OPT_CD_NW_NETWORK);
			}		
			ChargeCalcSimulation simuCalc = new ChargeCalcSimulation(svcUseDtl);
			simuCalc.calcOfAllocQts();
			mmExptPrice = simuCalc.getSvcAmt();
			
			long unitPrice = simuCalc.getUnitPrice();
			log.info(svcUseDtl.getOptCd() + " : "+ mmExptPrice);
			resultVo.setNwNetworkPrice(mmExptPrice);
			resultVo.setNwNetworkUnitPrice(unitPrice);
			
		}catch(NotFoundUnitPriceException e){
			log.error("notFound unitPirce : "+e.getMessage());
			resultVo.setNwSecurityErrMsg(e.getMessage());		
		}catch(Exception e){
			log.error(e.getMessage());
			throw new Exception("BillChargeSimulationInterfaceImpl.getNwSecurityPrice():" + e.getMessage());
		}finally{
			log.info("BillChargeSimulationInterfaceImpl.getNwSecurityPrice end #######################");
		}
		return resultVo;
	}
	
	
	/**
	 * <p>NwSecurity nw보안 월 예상금액 조회  
	 * @param BillChargeSimulationVO: 요금계산기신청내역
	 * @return BillChargeSimulationVO 요금계산기신청내역 + 월예상금액+에러메세지
	 * @throws Exception
	 */
	public BillChargeSimulationVO getNwSecurityPrice(BillChargeSimulationVO svcDtl)throws Exception{
		log.info("BillChargeSimulationInterfaceImpl.getNwSecurityPrice start #######################");
		ActSvcUseDtlVO svcUseDtl = new ActSvcUseDtlVO();
		BillChargeSimulationVO resultVo = svcDtl;
		long mmExptPrice =0;
		
		try{
			//센터코드
			svcUseDtl.setCntrCd(resultVo.getCntrCd());
			//가상화코드
			svcUseDtl.setVrtlCd(resultVo.getVtrlCd());
			//OS코드
			svcUseDtl.setOsCd(resultVo.getOsCd());
			//관계사 코드 
			svcUseDtl.setAfltCd(resultVo.getAfltCd());
			//센터간 회선 -  보안
			log.info(" isNwSecurity : " + resultVo.isNwSecurity());
			if(resultVo.isNwSecurity()){
				svcUseDtl.setTypCd(BillingConstants.TYP_CD_NETWORK_PUBLIC);
				svcUseDtl.setOptCd(BillingConstants.OPT_CD_NW_SECCURITY);
			}		
			ChargeCalcSimulation simuCalc = new ChargeCalcSimulation(svcUseDtl);
			simuCalc.calcOfAllocQts();
			mmExptPrice = simuCalc.getSvcAmt();
			
			
			long unitPrice = simuCalc.getUnitPrice();
			log.info(svcUseDtl.getOptCd() + " : "+ mmExptPrice);
			resultVo.setNwSecurityPrice(mmExptPrice);
			resultVo.setNwSecurityUnitPrice(unitPrice);
			
		}catch(NotFoundUnitPriceException e){
			log.error("notFound unitPirce : "+e.getMessage());
			resultVo.setNwSecurityErrMsg(e.getMessage());		
		}catch(Exception e){
			log.error(e.getMessage());
			throw new Exception("BillChargeSimulationInterfaceImpl.getNwSecurityPrice():" + e.getMessage());
		}finally{
			log.info("BillChargeSimulationInterfaceImpl.getNwSecurityPrice end #######################");
		}
		
		return resultVo;
	}
			
	/**
	 * <p>NwSan nw 유지운영 월 예상금액 조회  
	 * @param BillChargeSimulationVO: 요금계산기신청내역
	 * @return BillChargeSimulationVO 요금계산기신청내역 + 월예상금액+에러메세지
	 * @throws Exception
	 */
	public BillChargeSimulationVO getNwSanPrice(BillChargeSimulationVO svcDtl)throws Exception{
		log.info("BillChargeSimulationInterfaceImpl.getNwSanPrice start #######################");
		ActSvcUseDtlVO svcUseDtl = new ActSvcUseDtlVO();
		BillChargeSimulationVO resultVo = svcDtl;
		long mmExptPrice =0;
		
		try{
			//센터코드
			svcUseDtl.setCntrCd(resultVo.getCntrCd());
			//가상화코드
			svcUseDtl.setVrtlCd(resultVo.getVtrlCd());
			//OS코드
			svcUseDtl.setOsCd(resultVo.getOsCd());
			//관계사 코드 
			svcUseDtl.setAfltCd(resultVo.getAfltCd());
			//공용네트워크/보안 유지운영
			log.info(" isNwSan : " + resultVo.isNwSan());
			if(resultVo.isNwSan()){
				svcUseDtl.setTypCd(BillingConstants.TYP_CD_NETWORK_PUBLIC);
				svcUseDtl.setOptCd(BillingConstants.OPT_CD_NW_SAN);
			}
			ChargeCalcSimulation simuCalc = new ChargeCalcSimulation(svcUseDtl);
			simuCalc.calcOfAllocQts();
			mmExptPrice = simuCalc.getSvcAmt();
			
			long unitPrice = simuCalc.getUnitPrice();
			log.info(svcUseDtl.getOptCd() + " : "+ mmExptPrice);
			resultVo.setNwSanPrice(mmExptPrice);
			resultVo.setNwSanUnitPrice(unitPrice);
			
		}catch(NotFoundUnitPriceException e){
			log.error("notFound unitPirce : "+e.getMessage());
			resultVo.setNwSanErrMsg(e.getMessage());		
		}catch(Exception e){
			log.error(e.getMessage());
			throw new Exception("BillChargeSimulationInterfaceImpl.getNwSanPrice():" + e.getMessage());
		}finally{
			log.info("BillChargeSimulationInterfaceImpl.getNwSanPrice end #######################");
		}
		return resultVo;
	}
	
	/**
	 * <p>SW라이센스 월 예상금액 조회  
	 * @param BillChargeSimulationVO: 요금계산기신청내역
	 * @return BillChargeSimulationVO 요금계산기신청내역 + 월예상금액+에러메세지
	 * @throws Exception
	 */
	public BillChargeSimulationVO getSwPrice(BillChargeSimulationVO svcDtl)throws Exception{
		log.info("BillChargeSimulationInterfaceImpl.getSwPrice start #######################");
		
		BillChargeSimulationVO resultVo = svcDtl;
		List<ActSvcUseDtlVO> swDtl = new ArrayList<ActSvcUseDtlVO>(); 
		swDtl = svcDtl.getSwDtl();
		if (swDtl.size() == 0 ){
			return resultVo;
		}
		//type 코드  셋팅
		for(int i =0; i<swDtl.size(); i++){
			log.info(" SOFTWARE OPT_CD : " +swDtl.get(i).getOptCd() );
			swDtl.get(i).setCntrCd(resultVo.getCntrCd());
			swDtl.get(i).setVrtlCd(resultVo.getVtrlCd());
			swDtl.get(i).setOsCd( resultVo.getOsCd());
			//관계사 코드 
			swDtl.get(i).setAfltCd(resultVo.getAfltCd());
			swDtl.get(i).setTypCd(BillingConstants.TYP_CD_SOFTWARE);
			swDtl.get(i).setOsCd( resultVo.getOsCd());
			log.info(" resultVo.getCoreCnt() " +resultVo.getCoreCnt() );
			swDtl.get(i).setCoreCnt(resultVo.getCoreCnt());
		}
		
		ChargeCalcSimulationSwLcns simulClsSw = new ChargeCalcSimulationSwLcns(swDtl);
		simulClsSw.calcOfAllocQts();
		swDtl = simulClsSw.getActSvcUseDtl();
		//SW비용
		long totSwAmt = 0;
		for(int i =0; i<swDtl.size(); i++){
			log.info(swDtl.get(i).getOptCd() + " swAtmt : " + swDtl.get(i).getMmExcptAmt());
			totSwAmt += swDtl.get(i).getMmExcptAmt();
		} 
		resultVo.setSwTotPrice(totSwAmt);
		resultVo.setSwDtl(swDtl);
		log.info(" totSwAmt : " + totSwAmt);
		log.info("BillChargeSimulationInterfaceImpl.getSwPrice end #######################");
		return resultVo;
	}
}
