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
 * <p>��ݹ�ġ ������ ��� ���� * 
 */
public class ChargeBatchMasterInterfaceImpl implements ChargeBatchMasterInterface { 
	//static Logger log = Logger.getLogger(ChargeBatchMasterServiceImpl.class);
	//static Logger log = Logger.getLogger("charge");
	NNPLogger log = NNPLogger.getLogger(ChargeBatchMasterInterfaceImpl.class);
	/**
	 * <p>���� ��ݳ���� ��ȸ�Ѵ�.
	 * @param ����
	 * @return String chargeYm : ��ݳ��
	 * @throws Exception
	 */
	public String  selectChargeYM() throws Exception{
		log.info("ChargeBatchMasterInterfaceImpl.selectChargeYM start ########################################");
		String strTempYYYYMM = DateUtil.getCurrentYyyymmdd();
		//String strTempYYYYMM = "201508";
		String strChargeYYYYMM= "";
		
		//�Ŵ� 1���̸� ��� ���� ���
		if("01".equals(strTempYYYYMM.substring(6))){
			//DateUtil.getOpDate(java.util.Calendar.DATE , 1, "20080101")
			strChargeYYYYMM =   (DateUtil.getOpDate(java.util.Calendar.MONTH, -1, strTempYYYYMM)).substring(0,6); 
		}else{ //��� ���� ���
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
			//�ű� ��ġ ������ ��
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
	 * <p>��ݹ�ġ�۾� ���� üũ
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
		//�������
		if (BillingConstants.RUN_STAT_RUNNING.equals(result)){
			bResult = true;	
		//�ش� ��ݿ�ó�� �����ϴ� ��� --> 	
		} else if (BillingConstants.RUN_STAT_NOT_RUNNING.equals(result)){
			batchMasterDao.insertChargeYm(chargeYm);
		}
		
		return bResult;
	}
	
	
	/**
	 * <p>��ݰ���� �ʱ�ȭ �Ѵ�.(���� ��ݳ����� ���� ó���մϴ�.)
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
		
		//��ݸ����� ������� üũ 
		
		/*
		String DEL_TBL_ACT_CHRG_SVR  = "ACT_CHRG_SVR"; //��ݴ�󼭹�
		String DEL_TBL_ACT_SVC_USE_DTL  = "ACT_SVC_USE_DTL"; //���񽺻�볻��
		String DEL_TBL_ACT_SW_USE_DTL  = "ACT_SW_USE_DTL"; //SW ��볻��
		//String DEL_TBL_BILL_CHRG_MSTR  = "BILL_CHRG_MSTR"; //��ݿ���
		String DEL_TBL_BILL_SW_DTL  = "BILL_SW_DTL"; // ��ݿ���SW����
		String DEL_TBL_BILL_COMM_BIZ_CHRG_DTL = "BILL_COMM_BIZ_CHRG_DTL"; //������� ��ݳ���
		
		String DEL_TBL_BILL_COMM_BIZ_DSTRBT = "BILL_COMM_BIZ_DSTRBT"; //���������г���
		String DEL_TBL_BILL_COMM_BIZ_DSTRBT_SMRY = "BILL_COMM_BIZ_DSTRBT_SMRY"; //������� ��ݳ������
		// ������� ��ݳ��� 
		String DEL_TBL_ACT_AFLT_SVC_USE_DTL  = "ACT_AFLT_SVC_USE_DTL"; //��������� ���� ��볻��//String DEL_TBL_BILL_BILL_MSTR = "BILL_BILL_MSTR"; //û������
		//�����ݿ���
		*/
		
		
		List<String> delTable = new ArrayList<String>();
		//VM������ݵ�����
		delTable.add(BillingConstants.DEL_TBL_ACT_CHRG_SVR);
		delTable.add(BillingConstants.DEL_TBL_ACT_SVC_USE_DTL);
		delTable.add(BillingConstants.DEL_TBL_ACT_SW_USE_DTL);
		delTable.add(BillingConstants.DEL_TBL_BILL_CHRG_MSTR);
		delTable.add(BillingConstants.DEL_TBL_BILL_SW_DTL);
		//��뷮��� ������ --�ӽ�
		delTable.add(BillingConstants.DEL_TBL_ACT_USEVAL_BASED_CHRG_DTL);
		//delTable.add(BillingConstants.DEL_TBL_ACT_USEVAL_BASED_USE_DTL);
		
		
		//���������ݵ�����
		delTable.add(BillingConstants.DEL_TBL_ACT_AFLT_VAN_SVC_USE_DTL);
		delTable.add(BillingConstants.DEL_TBL_ACT_AFLT_SVC_USE_DTL);
		delTable.add(BillingConstants.DEL_TBL_BILL_AFLT_CHRG_MSTR);
		
		//�������NAS ��ݵ����� 
		delTable.add(BillingConstants.DEL_TBL_ACT_AFLT_NAS_USE_DTL);
		delTable.add(BillingConstants.DEL_TBL_ACT_CHRG_AFLT_NAS);
		delTable.add(BillingConstants.DEL_TBL_BILL_AFLT_NAS_MSTR);
		//������
		delTable.add(BillingConstants.DEL_TBL_BILL_COMM_BIZ_DSTRBT);
		delTable.add(BillingConstants.DEL_TBL_BILL_COMM_BIZ_DSTRBT_SMRY);
		delTable.add(BillingConstants.DEL_TBL_BILL_COMM_BIZ_CHRG_DTL);
		
		//delTable.add(BillingConstants.DEL_TBL_BILL_SYS_CHRG_SMRY);
		//û������ - ����������
		delTable.add(BillingConstants.DEL_TBL_BILL_BILL_MSTR);
		//û������ - DR
		delTable.add(BillingConstants.DEL_TBL_BILL_DR_BILL_MSTR);
		//���纰û������
		delTable.add(BillingConstants.DEL_TBL_BILL_AFLT_BILL_MSTR);
		
		//��ȭ�����
		delTable.add(BillingConstants.DEL_TBL_BILL_DEPTSTORE_DSTRBT_MSTR);
		delTable.add(BillingConstants.DEL_TBL_BILL_DEPTSTORE_DSTRBT_DTL);
		
		
		
		//���� �߰�
		try{
			iResult =  batchMasterDao.deleteChargeData(chargeYm, delTable);
			log.info("iResult:"+iResult);
			
			//��뷮��� ������ ����ó��(DEL_TBL_ACT_USEVAL_BASED_USE_DTL)
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
	 * <p>��ݰ�����ڰ� 1���̸� �����ذ�ݳ���� ���Ѵ�.
	 * @param ����
	 * @return String chargeYm : ��ݳ��
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
			throw new Exception ("��ݹ�ġ������ ����� �����߽��ϴ�. Ȯ�� �ٶ�ϴ�.!!");
		}
		
		log.debug("iResult :::"+ result.toString());
		log.info("ChargeBatchMasterInterfaceImpl.insertChargeYM end ########################################");
	}
	/**
	 * <p>��ݰ�� ��ġ�۾����¸� RUNNING���� UPDATEó���Ѵ�.
	 * @param ����
	 * @return String chargeYm : ��ݳ��
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
			throw new Exception ("��ݹ�ġ������  ��ġ���۽ð� ����� �����߽��ϴ�. Ȯ�� �ٶ�ϴ�.!!");
		}
		
		log.debug("iResult :::"+ result.toString());
		log.info("ChargeBatchMasterInterfaceImpl.updateChrgBatchStart end ########################################");
	}
	/**
	 * <p>��ݰ�� ��ġ�۾����¸� ����ó���Ѵ�.
	 * @param String chargeYm : ��ݳ��
	 * @return String chargeYm : ��ݳ��
	 * @param  String batchStat : ��ġ�۾����� RUN_STAT_COMPLETE/RUN_STAT_ERROR
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
			throw new Exception ("��ݹ�ġ������  ��ġ����ð� ����� �����߽��ϴ�. Ȯ�� �ٶ�ϴ�.!!");
		}
		
		log.debug("iResult :::"+ result.toString());
		log.info("ChargeBatchMasterInterfaceImpl.updateChrgBatchEnd end ########################################");
	}
	
	/**
	 * <p>�ش���� ����� �������θ� ��ȸ�Ѵ�.
	 * @param String chargeYm : ��ݳ��
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
