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
 * <p> 요금계산기 지표들의 요금계산
 * 
 */  
public class ChargeCalcSimulation implements AccountInterface {
	
	NNPLogger log = NNPLogger.getLogger(ChargeCalcSimulation.class);
	
	private long monVal;
	private String chrgYm;
	  
	//요율
	private RateSvcRateInterface svcRateService ;
	//서비스voList
	private ActSvcUseDtlVO actSvcUseDtl;
	//서비스voList
	private List<ActSvcUseDtlVO> actSvcUseDtlList = new ArrayList<ActSvcUseDtlVO>();
	//요율vo
	private List<RateSvcPrcDtlVO> rateSvcPrcDtl = new ArrayList<RateSvcPrcDtlVO>();
	//private HashMap<String,RateSvcPrcDtlVO> rateSvcPrcDtl = new HashMap<String,RateSvcPrcDtlVO>();
	
	//요율적용일자
	private String stdAplyDt;
	

	//vm코드
	private String vmCd;
	private long svcAmt;
	private long unitPrice;
	private long valUnit;
	
	//과금모델 hashMap
	private HashMap hmAplyMdl = new HashMap();
	
	//조정금액
	private long adjAmt;

	//조정금액
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
	 * <p>사용 미터링데이터 조회
	 * @param  없음
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
	 * <p>//할당량 방식의 과금을계산한다.
	 * @param long 의미없음
	 * @return void 
	 * @throws Exception
	 */
	public long calcOfAllocQts() throws Exception{
		log.info("ChargeSimulationCalcService.calcOfAllocQts start #######################");
		//단위
		String strUnit = "";
		long svcPrice = 0l;
		long svcCstPrice = 0l;
		//한달일때요금
		double  priceOfMonth =0;
		double cstPriceOfMonth =0;
		//할당량 
		long lAllocQts = 0l;
		double doubleQts = 0;
		
		//단위당 가격
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
		// 관계사 요율 존재여부 체크 ( 파생요율 여부 체크)ㅇ
		strAplymodelKey = this.stdAplyDt +"|"+actSvcUseDtl.getAfltCd();
		
		if(!hmAplyMdl.containsKey(strAplymodelKey)){
			strAfltCd = BillingConstants.MDL_AFLT_DEFAULT;
		}
		log.info("strAplymodelKey: " + strAplymodelKey + " result-> strAfltCd: "+strAfltCd);
				
		try{
			//지표의 가격 검색
			svcMap =  svcRateService.searchSvcPrc(this.stdAplyDt,strAfltCd, actSvcUseDtl.getCntrCd(),  actSvcUseDtl.getTypCd(), actSvcUseDtl.getOptCd(), actSvcUseDtl.getOsCd(), actSvcUseDtl.getVrtlCd());	
		}catch ( NotFoundUnitPriceException e){
			throw new NotFoundUnitPriceException (e.getMessage());
		}
		
		//해당서비스의 가격요율이 없는경우 
		if (svcMap.size() ==0){
			//throw new Exception("해당 서비스의 단가 요율이 없습니다.!!");
			log.info("해당 서비스의 단가 요율이 없습니다.!!###########");
			return 0;
		} 
		//과금단위 
		strUnit = svcMap.get("unit");		
		
		//단위당 값
		valByUnit = Long.parseLong((String)svcMap.get("fromVal"));
		
		//월단가
		svcPrice = Long.parseLong((String)svcMap.get("prc"));
		
		//원가
		svcCstPrice = Long.parseLong((String)svcMap.get("costPrc"));
		//할당량
		lAllocQts = this.actSvcUseDtl.getQts();
		
		
		if(BillingConstants.TYP_CD_CPU.equals(this.actSvcUseDtl.getTypCd()) || BillingConstants.TYP_CD_MEMORY.equals(this.actSvcUseDtl.getTypCd())|| BillingConstants.TYP_CD_HA.equals(this.actSvcUseDtl.getTypCd())){
			doubleQts = actSvcUseDtl.getDoubleQts();
		}else{
			//할당량
			lAllocQts = actSvcUseDtl.getQts();	
		}		
		//OS당, OS별  라이센스가 아닌경우
		if(!"OS".equals(strUnit) && !"SERVER".equals(strUnit)  ){
			if(BillingConstants.TYP_CD_CPU.equals(this.actSvcUseDtl.getTypCd()) || BillingConstants.TYP_CD_MEMORY.equals(this.actSvcUseDtl.getTypCd())|| BillingConstants.TYP_CD_HA.equals(this.actSvcUseDtl.getTypCd())){
		
				//한달요금
				priceOfMonth = doubleQts / valByUnit * svcPrice  ; 
				//한달 원가
				cstPriceOfMonth =  doubleQts / valByUnit * svcCstPrice ;
				
			}else{
				
				//한달요금
				priceOfMonth = lAllocQts/ valByUnit * svcPrice;
				//한달 원가
				cstPriceOfMonth = lAllocQts /valByUnit * svcCstPrice ;				
				
			}
		}else{
			//한달요금
			priceOfMonth = svcPrice;
			cstPriceOfMonth = svcCstPrice;
		}
		
		log.info("CntrCd:"+this.actSvcUseDtl.getCntrCd() + " vrtlCd:"+this.actSvcUseDtl.getVrtlCd() + " osCd:"+this.actSvcUseDtl.getOsCd());
		log.info("typCd:"+this.actSvcUseDtl.getTypCd() + " optCd:"+this.actSvcUseDtl.getOptCd());
		log.info("할당량 : "+lAllocQts + ", 월단가/단위당 가격 : "+svcPrice + ", 한달의 요금 : "+priceOfMonth);
		log.info("할당량 : "+lAllocQts + ", 월단가/단위당 원가 : "+svcCstPrice + ", 한달의 요금 : "+cstPriceOfMonth);
		
		
		//월요금 --신세계 I&C
		if(BillingConstants.AFLT_D_INC.equals(actSvcUseDtl.getAfltCd())){
			svcAmt = Math.round(cstPriceOfMonth);
			//단가
			unitPrice = svcCstPrice;
			//단위당 값
			valUnit = valByUnit;
		}else{
			svcAmt = Math.round(priceOfMonth);
			//단가
			unitPrice = svcPrice;
			//과금 단위 
			valUnit = valByUnit;
		}
		log.info("ChargeSimulationCalcService.calcOfAllocQts end #######################");
		return monVal;
	}
	
	/**
	 * <p>//요금 일할계산
	 * @param List<ActSvcUseDtlVO> 서비스사용내역
	 * @return long chargAmt : 일할계산된 금액 
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
		//log.info("CPU/MEMORY 가격을 찾을 수 없습니다. 해당 서버의 서비스 코드(TYPE_CODE, OPTION_CODE)와  서비스요율을  확인바랍니다.");
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
		//log.info("해당 서비스의 가격을 찾을 수 없습니다. 해당 서버의 서비스 코드(TYPE_CODE, OPTION_CODE)와  서비스요율을  확인바랍니다.");
		return hmRtn;
	}

	public long calcOfSw() throws Exception{
		long result =0;
		
		return result;
	}
}
