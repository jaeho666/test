package com.nkia.xeus.service.billing.charge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;

import com.nkia.common.NNPLogger;
import com.nkia.xeus.entity.billing.charge.ActSvcUseDtlVO;
import com.nkia.xeus.entity.billing.charge.RateSvcPrcDtlVO;
import com.nkia.xeus.util.ChargeUtil;
import com.nkia.xeus.util.DateUtil;
/**
 * <p> ��ݰ��� ��ǥ���� ��ݰ��
 * 
 */  
public class ChargeCalcSimulation implements AccountInterface { 
	
	NNPLogger log = NNPLogger.getLogger(ChargeCalcSimulation.class);
	
	private long monVal;
	private String chrgYm;
	  
	//����
	private RateSvcRateInterface svcRateService ;
	//����voList
	private ActSvcUseDtlVO actSvcUseDtl;
	//����voList
	private List<ActSvcUseDtlVO> actSvcUseDtlList = new ArrayList<ActSvcUseDtlVO>();
	//����vo
	private List<RateSvcPrcDtlVO> rateSvcPrcDtl = new ArrayList<RateSvcPrcDtlVO>();
	//private HashMap<String,RateSvcPrcDtlVO> rateSvcPrcDtl = new HashMap<String,RateSvcPrcDtlVO>();
	
	//�����������
	private String stdAplyDt;
	

	//vm�ڵ�
	private String vmCd;
	private long svcAmt;
	private long unitPrice;
	private long valUnit;
	
	//��ݸ� hashMap
	private HashMap hmAplyMdl = new HashMap();
	
	//�����ݾ�
	private long adjAmt;

	//�����ݾ�
	public long getAdjAmt() {
		return adjAmt;
	}
	
	public long getSvcAmt(){
		return svcAmt;
	}
	public long getUnitPrice(){
		return unitPrice;
	}
	
	public long getValUnit(){
		return valUnit;
	}
	
	public ChargeCalcSimulation(){}
	
	public ChargeCalcSimulation( List<ActSvcUseDtlVO> actSvcUseDtl ){
		this.actSvcUseDtlList = actSvcUseDtl;
		selectChargeRowData();
	}
	public ChargeCalcSimulation( ActSvcUseDtlVO actSvcUseDtl ){
		this.actSvcUseDtl = actSvcUseDtl;
		selectChargeRowData();
	}
	/**
	 * <p>��� ���͸������� ��ȸ
	 * @param  ����
	 * @return void 
	 * @throws Exception
	 */
	public void selectChargeRowData(){
		log.info("ChargeSimulationCalcService.selectChargeRowData start #######################");
		try{
			ChargeBatchMasterInterface chargeBatchService = new ChargeBatchMasterInterfaceImpl();
			chrgYm = chargeBatchService.selectChargeYM();
			
			this.svcRateService = new RateSvcRateInterfaceImpl(chrgYm);
			this.stdAplyDt = svcRateService.getSvcAplyDt();
			hmAplyMdl = svcRateService.selectRateAplyMdl();
			
		}catch(Exception e){
			log.error("Error :" + e.getMessage());
		}
		log.info("ChargeSimulationCalcService.selectChargeRowData end #######################");
	}
	
	/**
	 * <p>//�Ҵ緮 ����� ���������Ѵ�.
	 * @param long �ǹ̾���
	 * @return void 
	 * @throws Exception
	 */
	public long calcOfAllocQts() throws Exception{
		log.info("ChargeSimulationCalcService.calcOfAllocQts start #######################");
		//����
		String strUnit = "";
		long svcPrice = 0l;
		long svcCstPrice = 0l;
		//�Ѵ��϶����
		double  priceOfMonth =0;
		double cstPriceOfMonth =0;
		//�Ҵ緮 
		long lAllocQts = 0l;
		double doubleQts = 0;
		
		//������ ����
		long valByUnit = 0l;
		
		HashMap<String, String> svcMap = new HashMap<String, String>();
		log.info("this.stdAplyDt:"+this.stdAplyDt);
		log.info("this.getCntrCd:"+this.actSvcUseDtl.getCntrCd());
		log.info("this.getTypCd:"+this.actSvcUseDtl.getTypCd());
		log.info("this.getOptCd:"+this.actSvcUseDtl.getOptCd());
		log.info("this.getOsCd:"+this.actSvcUseDtl.getOsCd());
		log.info("this.getVrtlCd:"+this.actSvcUseDtl.getVrtlCd());
		log.info("this.getQts:"+this.actSvcUseDtl.getQts());
		log.info("this.getDoubleQts:"+this.actSvcUseDtl.getDoubleQts());
		String strAfltCd="";
		String strAplymodelKey ="";
		// ���� ���� ���翩�� üũ ( �Ļ���� ���� üũ)��
		strAplymodelKey = this.stdAplyDt +"|"+actSvcUseDtl.getAfltCd();
		
		if(!hmAplyMdl.containsKey(strAplymodelKey)){
			strAfltCd = BillingConstants.MDL_AFLT_DEFAULT;
		}
		log.info("strAplymodelKey: " + strAplymodelKey + " result-> strAfltCd: "+strAfltCd);
				
		try{
			//��ǥ�� ���� �˻�
			svcMap =  svcRateService.searchSvcPrc(this.stdAplyDt,strAfltCd, actSvcUseDtl.getCntrCd(),  actSvcUseDtl.getTypCd(), actSvcUseDtl.getOptCd(), actSvcUseDtl.getOsCd(), actSvcUseDtl.getVrtlCd());	
		}catch ( NotFoundUnitPriceException e){
			throw new NotFoundUnitPriceException (e.getMessage());
		}
		
		//�ش缭���� ���ݿ����� ��°�� 
		if (svcMap.size() ==0){
			//throw new Exception("�ش� ������ �ܰ� ������ ����ϴ�.!!");
			log.info("�ش� ������ �ܰ� ������ ����ϴ�.!!###########");
			return 0;
		} 
		//��ݴ��� 
		strUnit = svcMap.get("unit");		
		
		//������ ��
		valByUnit = Long.parseLong((String)svcMap.get("fromVal"));
		
		//��ܰ�
		svcPrice = Long.parseLong((String)svcMap.get("prc"));
		
		//��
		svcCstPrice = Long.parseLong((String)svcMap.get("costPrc"));
		//�Ҵ緮
		lAllocQts = this.actSvcUseDtl.getQts();
		
		
		if(BillingConstants.TYP_CD_CPU.equals(this.actSvcUseDtl.getTypCd()) || BillingConstants.TYP_CD_MEMORY.equals(this.actSvcUseDtl.getTypCd())|| BillingConstants.TYP_CD_HA.equals(this.actSvcUseDtl.getTypCd())){
			doubleQts = actSvcUseDtl.getDoubleQts();
		}else{
			//�Ҵ緮
			lAllocQts = actSvcUseDtl.getQts();	
		}		
		//OS��, OS��  ���̼����� �ƴѰ��
		if(!"OS".equals(strUnit) && !"SERVER".equals(strUnit)  ){
			if(BillingConstants.TYP_CD_CPU.equals(this.actSvcUseDtl.getTypCd()) || BillingConstants.TYP_CD_MEMORY.equals(this.actSvcUseDtl.getTypCd())|| BillingConstants.TYP_CD_HA.equals(this.actSvcUseDtl.getTypCd())){
		
				//�Ѵ޿��
				priceOfMonth = doubleQts / valByUnit * svcPrice  ; 
				//�Ѵ� ��
				cstPriceOfMonth =  doubleQts / valByUnit * svcCstPrice ;
				
			}else{
				
				//�Ѵ޿��
				priceOfMonth = lAllocQts/ valByUnit * svcPrice;
				//�Ѵ� ��
				cstPriceOfMonth = lAllocQts /valByUnit * svcCstPrice ;				
				
			}
		}else{
			//�Ѵ޿��
			priceOfMonth = svcPrice;
			cstPriceOfMonth = svcCstPrice;
		}
		
		log.info("CntrCd:"+this.actSvcUseDtl.getCntrCd() + " vrtlCd:"+this.actSvcUseDtl.getVrtlCd() + " osCd:"+this.actSvcUseDtl.getOsCd());
		log.info("typCd:"+this.actSvcUseDtl.getTypCd() + " optCd:"+this.actSvcUseDtl.getOptCd());
		log.info("�Ҵ緮 : "+lAllocQts + ", ��ܰ�/������ ���� : "+svcPrice + ", �Ѵ��� ��� : "+priceOfMonth);
		log.info("�Ҵ緮 : "+lAllocQts + ", ��ܰ�/������ �� : "+svcCstPrice + ", �Ѵ��� ��� : "+cstPriceOfMonth);
		
		
		//���� --�ż��� I&C
		if(BillingConstants.AFLT_D_INC.equals(actSvcUseDtl.getAfltCd())){
			svcAmt = Math.round(cstPriceOfMonth);
			//�ܰ�
			unitPrice = svcCstPrice;
			//������ ��
			valUnit = valByUnit;
		}else{
			svcAmt = Math.round(priceOfMonth);
			//�ܰ�
			unitPrice = svcPrice;
			//��� ���� 
			valUnit = valByUnit;
		}
		log.info("ChargeSimulationCalcService.calcOfAllocQts end #######################");
		return monVal;
	}
	
	/**
	 * <p>//��� ���Ұ��
	 * @param List<ActSvcUseDtlVO> ���񽺻�볻��
	 * @return long chargAmt : ���Ұ��� �ݾ� 
	 * @throws Exception
	 */
	public long calcOnDailyBasis(String fromDt, String toDt, long svcPrice)throws Exception{
		long chargAmt =0l;
		chargAmt = ChargeUtil.calcOnDailyBasis(fromDt, toDt, svcPrice); 
		return chargAmt;
	}

	
	public HashMap<String, String> searchSvcPrcByCapcityAndOs(RateSvcPrcDtlVO prcDtl, String strSvcAplydt, String strCntrCd, String strTypeCd, String strOptCd, String strOscd, String strVrtlCd) throws Exception{
		log.info("searchSvcPrcByCapcityAndOs start #############################");
		HashMap<String, String> hmRtn = new HashMap<String, String> ();
		if(
				//strSvcAplydt.equals(prcDtl.getSvcAplyDt()) && 
				strCntrCd.equals(prcDtl.getCntrId())&&	
				strTypeCd.equals(prcDtl.getTypCd()) &&
				strOptCd.equals(prcDtl.getOptCd()) &&
				strOscd.equals(prcDtl.getOsCd()) &&
				strVrtlCd.equals(prcDtl.getVrtlCd())
				
			){
				log.info("SVC Price : " + prcDtl.getPrc());
				log.info("unit : " +  prcDtl.getUnit());
				//returnVal = prcDtl.getPrc() ;
				hmRtn.put("prc", String.valueOf(prcDtl.getPrc())  );
				hmRtn.put("unit", prcDtl.getUnit());
				
				log.info("searchSvcPrcByCapcityAndOs end #############################");
				return hmRtn;
		}
		log.info("searchSvcPrcByCapcityAndOs end #############################");
		//log.info("CPU/MEMORY ������ ã�� �� ����ϴ�. �ش� ������ ���� �ڵ�(TYPE_CODE, OPTION_CODE)��  ���񽺿�����  Ȯ�ιٶ�ϴ�.");
		return hmRtn;
	}
	
	public HashMap<String, String> searchSvcPrcByCapacity(RateSvcPrcDtlVO prcDtl, String strSvcAplydt, String strCntrCd, String strTypeCd, String strOptCd) throws Exception{
		log.info("searchSvcPrcByCapacity start #############################");
		HashMap<String, String> hmRtn = new HashMap<String, String> ();
		if(
				//strSvcAplydt.equals(prcDtl.getSvcAplyDt()) &&
				strCntrCd.equals(prcDtl.getCntrId())&&	
				strTypeCd.equals(prcDtl.getTypCd()) &&
				strOptCd.equals(prcDtl.getOptCd())
			){
				log.info("SVC Price : " + prcDtl.getPrc());
				log.info("unit : " +  prcDtl.getUnit());
				//returnVal = prcDtl.getPrc() ;
				hmRtn.put("prc", String.valueOf(prcDtl.getPrc())  );
				hmRtn.put("unit", prcDtl.getUnit());
				log.info("searchSvcPrcByCapacity end #############################");
				return hmRtn;
		}
		
		log.info("searchSvcPrcByCapacity end #############################");
		return hmRtn;
	}
	public HashMap<String, String> searchSvcPrcByOS(RateSvcPrcDtlVO prcDtl, String strSvcAplydt, String strCntrCd, String strTypeCd, String strOptCd, String strOscd) throws Exception{
		log.info("searchSvcPrcByOS start #############################");
		HashMap<String, String> hmRtn = new HashMap<String, String> ();
		if(
				//strSvcAplydt.equals(prcDtl.getSvcAplyDt()) && 
				strCntrCd.equals(prcDtl.getCntrId())&&	
				strTypeCd.equals(prcDtl.getTypCd()) &&
				strOptCd.equals(prcDtl.getOptCd()) &&
				strOscd.equals(prcDtl.getFromVal())
			){
				log.info("SVC Price : " + prcDtl.getPrc());
				log.info("unit : " +  prcDtl.getUnit());
				//returnVal = prcDtl.getPrc() ;
				hmRtn.put("prc", String.valueOf(prcDtl.getPrc())  );
				hmRtn.put("unit", prcDtl.getUnit());
				log.info("searchSvcPrcByOS end #############################");
				return hmRtn;
		}
		log.info("searchSvcPrcByOS end #############################");
		//log.info("�ش� ������ ������ ã�� �� ����ϴ�. �ش� ������ ���� �ڵ�(TYPE_CODE, OPTION_CODE)��  ���񽺿�����  Ȯ�ιٶ�ϴ�.");
		return hmRtn;
	}

	public long calcOfSw() throws Exception{
		long result =0;
		
		return result;
	}
}
