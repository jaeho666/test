package com.nkia.xeus.service.billing.charge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Service;

import com.nkia.common.NNPLogger;
import com.nkia.xeus.dao.ChargeBatchMasterDAO;
import com.nkia.xeus.service.mybatis.SqlSessionManager;
import com.nkia.xeus.util.DateUtil;
@ManagedResource(objectName = "xeus:name=ChargeBatchMasterInterfaceImpl,type=service")
@Service("ChargeBatchMasterInterfaceImpl")
/**
 * <p>과금배치 마스터 기능 구현 * 
 */
public class ChargeBatchMasterInterfaceImpl implements ChargeBatchMasterInterface {
	//static Logger log = Logger.getLogger(ChargeBatchMasterServiceImpl.class);
	//static Logger log = Logger.getLogger("charge");
	NNPLogger log = NNPLogger.getLogger(ChargeBatchMasterInterfaceImpl.class);
	/**
	 * <p>기준 과금년월을 조회한다.
	 * @param 없음
	 * @return String chargeYm : 과금년월
	 * @throws Exception
	 */
	public String  selectChargeYM() throws Exception{
		log.info("ChargeBatchMasterInterfaceImpl.selectChargeYM start ########################################");
		String strTempYYYYMM = DateUtil.getCurrentYyyymmdd();
		//String strTempYYYYMM = "201508";
		String strChargeYYYYMM= "";
		
		//매달 1일이면 전월에 대한 과금
		if("01".equals(strTempYYYYMM.substring(6))){
			//DateUtil.getOpDate(java.util.Calendar.DATE , 1, "20080101")
			strChargeYYYYMM =   (DateUtil.getOpDate(java.util.Calendar.MONTH, -1, strTempYYYYMM)).substring(0,6); 
		}else{ //당월에 대한 과금
			strChargeYYYYMM = strTempYYYYMM.substring(0, 6);
		}
		SqlSessionFactory sqlSessionFactory  = null;
		sqlSessionFactory = SqlSessionManager.getSqlSession();
		ChargeBatchMasterDAO batchMasterDao = new ChargeBatchMasterDAO(sqlSessionFactory);
		
		List<HashMap> lstResult = new ArrayList<HashMap>();
		String result = "";
		try{
			
			log.info("strChargeYYYYMM :::"+ strChargeYYYYMM);
			lstResult =  batchMasterDao.selectChargeYm(strChargeYYYYMM);
		}catch(Exception e){
			log.debug("selectChargeYM Error : "+ e.getMessage());
			throw new Exception (e.getMessage());
		}
	
		log.debug("lstResult :::"+ lstResult.toString());
		if(lstResult.size() == 0){
			//신규 배치 마스터 생성
			int iResult = batchMasterDao.insertChargeYm(strChargeYYYYMM);
			result = strChargeYYYYMM;
		}else{
			result = (String)((HashMap)lstResult.get(0)).get("CHRG_YM");
		}
		
		log.info("result :::"+ result.toString());
		log.info("ChargeBatchMasterInterfaceImpl.selectChargeYM end ########################################");
		return result;
	}
	
	
	/**
	 * <p>과금배치작업 상태 체크
	 * @param String chargeYm
	 * @return  void
	 * @throws Exception
	 */
	public boolean isChargeBatchRunning(String chargeYm) throws Exception{
	
		SqlSessionFactory sqlSessionFactory  = null;
		sqlSessionFactory = SqlSessionManager.getSqlSession();
		boolean bResult = false;
		ChargeBatchMasterDAO batchMasterDao = new ChargeBatchMasterDAO(sqlSessionFactory);
		List<HashMap> lstResult = new ArrayList<HashMap>();
		String result = "";
		log.debug("chargeYm :::"+ chargeYm);
		
		lstResult =  batchMasterDao.selectConfirmAndStat(chargeYm);
		
		result = (String)((HashMap)lstResult.get(0)).get("CHRG_STAT");
		//실행상태
		if (BillingConstants.RUN_STAT_RUNNING.equals(result)){
			bResult = true;	
		//해당 과금월에처음 실행하는 경우 --> 	
		} else if (BillingConstants.RUN_STAT_NOT_RUNNING.equals(result)){
			batchMasterDao.insertChargeYm(chargeYm);
		}
		
		return bResult;
	}
	
	
	/**
	 * <p>과금계산을 초기화 한다.(전일 과금내역을 삭제 처리합니다.)
	 * @param String chargeYm
	 * @return  void
	 * @throws Exception
	 */
	public void initializeChargeCalc(String chargeYm) throws Exception{
		log.info("ChargeBatchMasterInterfaceImpl.initializeChargeCalc start ########################################");
		SqlSessionFactory sqlSessionFactory  = null;
		sqlSessionFactory = SqlSessionManager.getSqlSession();
		
		ChargeBatchMasterDAO batchMasterDao = new ChargeBatchMasterDAO(sqlSessionFactory);
		long iResult = -1; 
		String result = "";
		log.debug("chargeYm :::"+ chargeYm);
		
		//과금마스터 실행상태 체크 
		
		/*
		String DEL_TBL_ACT_CHRG_SVR  = "ACT_CHRG_SVR"; //과금대상서버
		String DEL_TBL_ACT_SVC_USE_DTL  = "ACT_SVC_USE_DTL"; //서비스사용내역
		String DEL_TBL_ACT_SW_USE_DTL  = "ACT_SW_USE_DTL"; //SW 사용내역
		//String DEL_TBL_BILL_CHRG_MSTR  = "BILL_CHRG_MSTR"; //과금원장
		String DEL_TBL_BILL_SW_DTL  = "BILL_SW_DTL"; // 과금원장SW내역
		String DEL_TBL_BILL_COMM_BIZ_CHRG_DTL = "BILL_COMM_BIZ_CHRG_DTL"; //공통업무 과금내역
		
		String DEL_TBL_BILL_COMM_BIZ_DSTRBT = "BILL_COMM_BIZ_DSTRBT"; //공통업무배분내역
		String DEL_TBL_BILL_COMM_BIZ_DSTRBT_SMRY = "BILL_COMM_BIZ_DSTRBT_SMRY"; //공통업무 과금내역집계
		// 관계사단위 과금내역 
		String DEL_TBL_ACT_AFLT_SVC_USE_DTL  = "ACT_AFLT_SVC_USE_DTL"; //관계사단위의 서비스 사용내역//String DEL_TBL_BILL_BILL_MSTR = "BILL_BILL_MSTR"; //청구원장
		//관계사과금원장
		*/
		
		
		List<String> delTable = new ArrayList<String>();
		//VM단위과금데이터
		delTable.add(BillingConstants.DEL_TBL_ACT_CHRG_SVR);
		delTable.add(BillingConstants.DEL_TBL_ACT_SVC_USE_DTL);
		delTable.add(BillingConstants.DEL_TBL_ACT_SW_USE_DTL);
		delTable.add(BillingConstants.DEL_TBL_BILL_CHRG_MSTR);
		delTable.add(BillingConstants.DEL_TBL_BILL_SW_DTL);
		//사용량기반 데이터 --임시
		delTable.add(BillingConstants.DEL_TBL_ACT_USEVAL_BASED_CHRG_DTL);
		//delTable.add(BillingConstants.DEL_TBL_ACT_USEVAL_BASED_USE_DTL);
		
		
		//관계사단위과금데이터
		delTable.add(BillingConstants.DEL_TBL_ACT_AFLT_VAN_SVC_USE_DTL);
		delTable.add(BillingConstants.DEL_TBL_ACT_AFLT_SVC_USE_DTL);
		delTable.add(BillingConstants.DEL_TBL_BILL_AFLT_CHRG_MSTR);
		
		//관계사단위NAS 과금데이터 
		delTable.add(BillingConstants.DEL_TBL_ACT_AFLT_NAS_USE_DTL);
		delTable.add(BillingConstants.DEL_TBL_ACT_CHRG_AFLT_NAS);
		delTable.add(BillingConstants.DEL_TBL_BILL_AFLT_NAS_MSTR);
		//공통배분
		delTable.add(BillingConstants.DEL_TBL_BILL_COMM_BIZ_DSTRBT);
		delTable.add(BillingConstants.DEL_TBL_BILL_COMM_BIZ_DSTRBT_SMRY);
		delTable.add(BillingConstants.DEL_TBL_BILL_COMM_BIZ_CHRG_DTL);
		
		//delTable.add(BillingConstants.DEL_TBL_BILL_SYS_CHRG_SMRY);
		//청구원장 - 통합인프라
		delTable.add(BillingConstants.DEL_TBL_BILL_BILL_MSTR);
		//청구원장 - DR
		delTable.add(BillingConstants.DEL_TBL_BILL_DR_BILL_MSTR);
		//관계사별청구원장
		delTable.add(BillingConstants.DEL_TBL_BILL_AFLT_BILL_MSTR);
		
		//백화점배분
		delTable.add(BillingConstants.DEL_TBL_BILL_DEPTSTORE_DSTRBT_MSTR);
		delTable.add(BillingConstants.DEL_TBL_BILL_DEPTSTORE_DSTRBT_DTL);
		
		
		
		//향후 추가
		try{
			iResult =  batchMasterDao.deleteChargeData(chargeYm, delTable);
			log.info("iResult:"+iResult);
			
			//사용량기반 데이터 삭제처리(DEL_TBL_ACT_USEVAL_BASED_USE_DTL)
			ChargeSvcUseDtlInterface svcUseDtl = new ChargeSvcUseDtlInterfaceImpl();
			svcUseDtl.deleteUseValBaseChrgDtl(chargeYm);
			
			//UPDATE  STATUS OF BATCH JOB 
			updateChrgBatchStart(chargeYm);
		}catch(Exception e){
			log.error("ChargeBatchMasterInterfaceImpl.initializeChargeCalc end ########################################");
			throw new Exception (e.getMessage());
		}
		
		
		log.debug("iResult :::"+ result.toString());
		log.info("ChargeBatchMasterInterfaceImpl.initializeChargeCalc end ########################################");
	}
	/**
	 * <p>과금계산일자가 1일이면 당월기준과금년월을 생성한다.
	 * @param 없음
	 * @return String chargeYm : 과금년월
	 * @throws Exception
	 */
	public void insertChargeYM(String chargeYm) throws Exception{
		log.info("ChargeBatchMasterInterfaceImpl.insertChargeYM start ########################################");
		SqlSessionFactory sqlSessionFactory  = null;
		sqlSessionFactory = SqlSessionManager.getSqlSession();
		
		ChargeBatchMasterDAO batchMasterDao = new ChargeBatchMasterDAO(sqlSessionFactory);
		long iResult = -1; 
		String result = "";
		log.debug("chargeYm :::"+ chargeYm);
		
		iResult =  batchMasterDao.insertChargeYm(chargeYm);
		if (iResult == -1) {
			throw new Exception ("과금배치마스터 등록을 실패했습니다. 확인 바랍니다.!!");
		}
		
		log.debug("iResult :::"+ result.toString());
		log.info("ChargeBatchMasterInterfaceImpl.insertChargeYM end ########################################");
	}
	/**
	 * <p>과금계산 배치작업상태를 RUNNING으로 UPDATE처리한다.
	 * @param 없음
	 * @return String chargeYm : 과금년월
	 * @throws Exception
	 */
	public void updateChrgBatchStart(String chargeYm) throws Exception{
		log.info("ChargeBatchMasterInterfaceImpl.updateChrgBatchStart start ########################################");
		SqlSessionFactory sqlSessionFactory  = null;
		sqlSessionFactory = SqlSessionManager.getSqlSession();
		
		ChargeBatchMasterDAO batchMasterDao = new ChargeBatchMasterDAO(sqlSessionFactory);
		long iResult = -1; 
		String result = "";
		log.debug("chargeYm :::"+ chargeYm);
		
		iResult =  batchMasterDao.updateChargeBatchStart(chargeYm, BillingConstants.RUN_STAT_RUNNING);
		if (iResult == -1) {
			throw new Exception ("과금배치마스터  배치시작시간 등록을 실패했습니다. 확인 바랍니다.!!");
		}
		
		log.debug("iResult :::"+ result.toString());
		log.info("ChargeBatchMasterInterfaceImpl.updateChrgBatchStart end ########################################");
	}
	/**
	 * <p>과금계산 배치작업상태를 종료처리한다.
	 * @param String chargeYm : 과금년월
	 * @return String chargeYm : 과금년월
	 * @param  String batchStat : 배치작업상태 RUN_STAT_COMPLETE/RUN_STAT_ERROR
	 * @throws Exception
	 */
	public void updateChrgBatchEnd(String chargeYm, String batchStat) throws Exception{
		log.info("ChargeBatchMasterInterfaceImpl.updateChrgBatchEnd start ########################################");
		SqlSessionFactory sqlSessionFactory  = null;
		sqlSessionFactory = SqlSessionManager.getSqlSession();
		
		ChargeBatchMasterDAO batchMasterDao = new ChargeBatchMasterDAO(sqlSessionFactory);
		long iResult = -1; 
		String result = "";
		log.debug("chargeYm :::"+ chargeYm);
		log.debug("batchStat :::"+ batchStat);
		iResult =  batchMasterDao.updateChargeBatchEnd(chargeYm, batchStat);
		if (iResult == -1) {
			throw new Exception ("과금배치마스터  배치종료시간 등록을 실패했습니다. 확인 바랍니다.!!");
		}
		
		log.debug("iResult :::"+ result.toString());
		log.info("ChargeBatchMasterInterfaceImpl.updateChrgBatchEnd end ########################################");
	}
	
	/**
	 * <p>해당월의 과금이 마감여부를 조회한다.
	 * @param String chargeYm : 과금년월
	 * @return Y/N 
	 * @throws Exception
	 */
	public String  selectConfirmYn(String chrgYm) throws Exception{
		log.info("ChargeBatchMasterInterfaceImpl.selectConfirmYn start ########################################");
		//String strTempYYYYMM = DateUtil.getCurrentYyyymmdd();
		//String strTempYYYYMM = "201508";
		//String strChargeYYYYMM= "";
		
		
		SqlSessionFactory sqlSessionFactory  = null;
		sqlSessionFactory = SqlSessionManager.getSqlSession();
		ChargeBatchMasterDAO batchMasterDao = new ChargeBatchMasterDAO(sqlSessionFactory);
		
		List<HashMap> lstResult = new ArrayList<HashMap>();
		String result = "";
		try{
			
			log.info("chrgYm :::"+ chrgYm);
			lstResult =  batchMasterDao.selectConfirmAndStat(chrgYm);
		}catch(Exception e){
			log.debug("Error : "+ e.getMessage());
		}
	
		if(lstResult.size() > 0){
			log.debug("lstResult :::"+ lstResult.toString());
			
			result = (String)((HashMap)lstResult.get(0)).get("CNFRM_YN");
		}
		
		log.info("result :::"+ result.toString());
		log.info("ChargeBatchMasterInterfaceImpl.selectConfirmYn end ########################################");
		return result;
	}
}
