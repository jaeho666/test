package com.nkia.xeus.service.billing.charge;
/**
 * <p> 빌링에서 사용하는 상수 선언
 * 
 */
public interface BillingConstants {
	/**
	 * commit 기준개수
	 * */
	int COMMIT_CNT = 1000; //TRANSACTION 처리시  COMMIT 기준 건수
	/**
	 * 타입코드
	 * */
	String TYP_CD_CPU  = "CPU"; 				//CPU
	String TYP_CD_MEMORY = "MEMORY"; 			//메모리
	String TYP_CD_DISK = "DISK"; 				//스토리지
	String TYP_CD_DISK_SHARED = "DISK_SHARED"; 	//공유디스크
	String TYP_CD_DISK_COMM = "DISK_COMM"; 		//공통디스크
	String TYP_CD_HA = "HA"; 					//HA서비스
	String TYP_CD_DR = "DR";
	String TYP_CD_DUPLICATE = "DUPLICATE"; //실시간 복제/ 소산
	//String TYP_CD_BACKUP = "DUPLICATE";			//시점백업, 소산
	String TYP_CD_DR_CIRCUIT = "DR_CIRCUIT"; 	//센터간 회선 서비스
	String TYP_CD_NAS_SHARED = "NAS_SHARED"; 	// 공용NAS
	String TYP_CD_NAS_DEDICATED = "NAS_DEDICATED"; 		//전용 NAS
	String TYP_CD_NETWORK_PUBLIC = "NETWORK_PUBLIC";	//공용네트워크
	String TYP_CD_NETWORK_PRIVATE = "NETWORK_PRIVATE"; 	//전용네트워크 
	String TYP_CD_NETWORK_DEPT = "NETWORK_DEPT"; 		//전용선
	String TYP_CD_SOFTWARE = "SOFTWARE";
	String TYP_CD_STG_DEDICATED = "STG_DEDICATED";
	String TYP_CD_NAS_SERVER = "NAS_SERVER";			//전용NAS - 이마트
		
	
	/**
	 * 옵션코드
	 **/	
	String OPT_CD_VCORE= "VCORE"; 					//할당 설정된 vCore 수
	String OPT_CD_SOCKET= "SOCKET"; 				//Socket
	String OPT_CD_ENT_VCORE= "ENT_VCORE";			//실제 할당된 vCore 수
	String OPT_CD_MIN_VCORE= "MIN_VCORE"; 			//최소 할당 설정된 vCore 수
	String OPT_CD_MAX_VCORE= "MAX_VCORE"; 			//최대 할당 설정된 vCore 수
	String OPT_CD_PRVSNG_SIZE= "PRVSNG_SIZE"; 		//Provisioning 총할당량
	String OPT_CD_TOTAL_SIZE= "TOTAL_SIZE"; 		//MORY, Disk, NAS 등 총할당량
	String OPT_CD_EXT_EXADATA_DISK= "EXT_EXADATA_DISK"; //EXADATA Disk
	String OPT_CD_EXT_DATA_V7K= "EXT_DATA_V7K"; 	//DATA DISK (V7000)
	String OPT_CD_EXT_DATA_VMAX= "EXT_DATA_VMAX"; 	//DATA DISK (EMC VMAX)
	String OPT_CD_EXT_DATA_VNX= "EXT_DATA_VNX"; 	//DATA DISK (EMC VNX)
	String OPT_CD_INT_DATA_DISK= "INT_DATA_DISK"; 	//내장(로컬) DATA DISK
	String OPT_CD_EXT_OS_V7K= "EXT_OS_V7K"; 		//OS DISK (V7000)
	String OPT_CD_EXT_OS_EIO= "EXT_OS_EIO"; 		//OS DISK (EMC ExtreamIO)
	String OPT_CD_EXT_OS_VMAX= "EXT_OS_VMAX"; 		//OS DISK (EMC VMAX)
	String OPT_CD_EXT_OS_VNX= "EXT_OS_VNX"; 		//OS DISK (EMC VNX)
	String OPT_CD_INT_OS_DISK= "INT_OS_DISK"; 		//내장 OS DISK
	String OPT_CD_DISK_SHARED= "DISK_SHARED"; 		//공유(Shared) Disk 총할당량
	String OPT_CD_DISK_COMM= "DISK_COMM"; 			//공통(Common) Disk 총할당량
	String OPT_CD_INT_ARK= "INT_ARK"; 				//INT ARK 디스크
	
	String OPT_CD_NTX_OS_DISK= "NTX_OS_DISK"; 				//NUTANIX OS DISK
	String OPT_CD_NTX_DATA_DISK= "NTX_DATA_DISK"; 				//NUTANIX DATA DISK
	
	
	String OPT_CD_DR_SERVICE= "DR_SERVICE"; 		//DR 서비스
	String OPT_CD_DR_CENTER= "DR_CENTER"; 			//DR 센터
	
	String OPT_CD_TCP_IP_OS = "TCP_IP_OS"; 			//센터간 복제 회선
	String OPT_CD_TCP_IP_NAS = "TCP_IP_NAS"; 		//센터간 복제 NAS
	String OPT_CD_TCP_IP_ADG = "TCP_IP_ADG"; 		//센터간 복제 EXADATA
	String OPT_CD_TCP_IP_FC = "TCP_IP_FC"; 			//센터간 복제 FC
	String OPT_CD_INTERNET = "INTERNET";			//센터간 복제 인터넷
	String OPT_CD_TCP_IP_ARK = "TCP_IP_ARK"; 		//센터간 복제 ARK
	String OPT_CD_TCP_IP_BACKUP = "TCP_IP_BACKUP"; 	//센터간 복제 소산
	
	String OPT_CD_NW_NETWORK= "NW_NETWORK"; 		//네트워크 
	String OPT_CD_NW_SECCURITY= "NW_SECCURITY"; 	//보안
	String OPT_CD_NW_SAN= "NW_SAN"; 				//네트워크 유지운영
	
	String OPT_CD_NETWORK_VPN= "NW_VPN"; 			//VPN
	String OPT_CD_NETWORK_ROUTER= "NW_ROUTER"; 		//ROUTER
	
	String OPT_CD_MPLS= "MPLS"; 					//사별네트워크 (MPLS)
	String OPT_CD_GENERAL_VAN= "GENERAL_VAN"; 		//전용선/VAN
	
	String OPT_CD_REALTIME= "REALTIME"; 			//실시간 복제 (Vplex+통합SAN)
	String OPT_CD_SYMANTEC= "SYMANTEC"; 			//소산 서비스
	String OPT_CD_RECOVERPOINT= "RECOVERPOINT"; 	//시점백업 (VNX 5800)
	
	String OPT_CD_NAS= "NAS_SHARED"; 				//공용NAS
	String OPT_CD_NAS_DEDICATED= "NAS_DEDICATED"; 	//전용NAS
	
	String OPT_CD_HA_SERVICE= "HA_SERVICE"; 		//HA 서비스
	
	String OPT_CD_NETWORK_PUBLIC= "NETWORK_PUBLIC"; 	//공용 네트워크
	String OPT_CD_NETWORK_PRIVATE= "NETWORK_PRIVATE"; 	//전용 네트워크
	String OPT_CD_NETWORK_DEPT= "NETWORK_DEPT"; 		//사별네트워크
	
	String OPT_CD_NW_DEDICATED= "NW_DEDICATED"; 		//일반 전용 네트워크
	
	String OPT_CD_SW_ORACLE_LINUX= "SW_ORACLE_LINUX"; //Oracle Linux
	String OPT_CD_SW_REDHAT_LINUX= "SW_REDHAT_LINUX"; //Redhat Linux
	String OPT_CD_NAS_SERVER_DEDICATED= "NAS_SERVER_DEDICATED"; //이마트 전용NAS
	

	
	/**
	 * 라이센스종류 코드
	 * */
	String LCNS_TYP_SERVER = "SERVER";
	String LCNS_TYP_CPU = "CPU";
	String LCNS_TYP_COER = "CORE";
	
	long SW_LCNS_CPU_CNT = 2;
	
	
	/**
	 * 조정방법코드
	 * */
	String ADJ_METHOD_01 = "ADJ_M01"; //금액 보정
	String ADJ_METHOD_02 = "ADJ_M02"; //기간보정
	
	/**
	 * 조정대상코드
	 * */
	String ADJ_TARGET_01 = "ADJ_T01"; //VM 보정
	String ADJ_TARGET_02 = "ADJ_T02"; //전용선보정
	String ADJ_TARGET_03 = "ADJ_T03"; //전용NAS보정
	String ADJ_TARGET_04 = "ADJ_T04"; //관계사보정
	
	/**
	 * 해당사항없음
	 * */
	String NA = "N/A";
	
	/**
	 * 과금초기화를 하는 시점에 전일 과금데이터를 삭제해야하는 테이블
	 * */
	String DEL_TBL_ACT_CHRG_SVR  			= "ACT_CHRG_SVR"; 			//과금대상서버
	String DEL_TBL_ACT_SVC_USE_DTL  		= "ACT_SVC_USE_DTL"; 		//서비스사용내역
	String DEL_TBL_ACT_SW_USE_DTL  			= "ACT_SW_USE_DTL"; 		//SW 사용내역\
	String DEL_TBL_ACT_USEVAL_BASED_CHRG_DTL = "ACT_USEVAL_BASED_CHRG_DTL"; 		//사용량기반과금내역
	String DEL_TBL_ACT_USEVAL_BASED_USE_DTL  = "ACT_USEVAL_BASED_USE_DTL"; 		//사용량기반사용내역
	
	
	String DEL_TBL_BILL_CHRG_MSTR  			= "BILL_CHRG_MSTR"; 		//과금원장
	String DEL_TBL_BILL_SW_DTL  			= "BILL_SW_DTL"; 			// 과금원장SW내역
	String DEL_TBL_BILL_COMM_BIZ_CHRG_DTL 	= "BILL_COMM_BIZ_CHRG_DTL"; //공통업무 과금내역
	String DEL_TBL_BILL_COMM_BIZ_DSTRBT 	= "BILL_COMM_BIZ_DSTRBT"; 	//공통업무배분내역
	String DEL_TBL_BILL_COMM_BIZ_DSTRBT_SMRY = "BILL_COMM_BIZ_DSTRBT_SMRY"; //공통업무 과금내역집계
	String DEL_TBL_BILL_SYS_CHRG_SMRY 		= "BILL_SYS_CHRG_SMRY"; 		//업무단위 과금내역집계
	
	// 관계사단위 과금내역 ACT_AFLT_VAN_SVC_USE_DTL
	String DEL_TBL_ACT_AFLT_VAN_SVC_USE_DTL  	= "ACT_AFLT_VAN_SVC_USE_DTL"; //관계사단위의 공통업무 VAN 배분 내역
	String DEL_TBL_ACT_AFLT_SVC_USE_DTL  	= "ACT_AFLT_SVC_USE_DTL"; 		//관계사단위의 서비스 사용내역
	String DEL_TBL_BILL_AFLT_CHRG_MSTR  	= "BILL_AFLT_CHRG_MSTR"; 		//관계사단위의 과금마스터
	// 관계사단위 과금내역 
	String DEL_TBL_ACT_AFLT_NAS_USE_DTL  	= "ACT_AFLT_NAS_USE_DTL"; 		//관계사단위의 NAS 사용내역
	String DEL_TBL_ACT_CHRG_AFLT_NAS  		= "ACT_CHRG_AFLT_NAS"; 			//관계사단위의 NAS 서버목록 
	String DEL_TBL_BILL_AFLT_NAS_MSTR  		= "BILL_AFLT_NAS_CHRG_MSTR"; 	//관계사단위의 NAS 과금마스터
	
	String DEL_TBL_BILL_BILL_MSTR 			= "BILL_BILL_MSTR"; 			//청구마스터- 통합인프라
	String DEL_TBL_BILL_DR_BILL_MSTR 			= "BILL_DR_BILL_MSTR"; 		//청구마스터 - DR
	String DEL_TBL_BILL_AFLT_BILL_MSTR 		= "BILL_AFLT_BILL_MSTR"; 		//관계사별청구마스터
	//백화점 배분
	String DEL_TBL_BILL_DEPTSTORE_DSTRBT_MSTR 		= "BILL_DEPTSTORE_DSTRBT_MSTR"; 		//관계사별청구마스터
	String DEL_TBL_BILL_DEPTSTORE_DSTRBT_DTL 		= "BILL_DEPTSTORE_DSTRBT_DTL"; 		//관계사별청구마스터
	
	

	

	
	//관계사 과금원장
	/**
	 * 과금배치작업 실행상태
	 * */
	String RUN_STAT_RUNNING = "RUNNING";
	String RUN_STAT_NOT_RUNNING = "NOT_RUNNING";
	String RUN_STAT_COMPLETE = "COMPLETE";
	String RUN_STAT_ERROR = "ERROR";

	/**
	 * 모델적용관계사코드
	 * */
	String MDL_AFLT_DEFAULT = "DEFAULT";
	String MDL_AFLT_SHARED = "SHARED";
	/*
	 * 관계사코드
	 * */
	String AFLT_D_INC = "D_008";
	
	/*
	 * 센터코드
	 * */
	String CENTER_01 = "CENTER01";	//통합인프라
	String CENTER_02 = "CENTER02";	//DR센터
	
	/*
	 * 서비스구분
	 * */
	String SVC_GBN_VM = "VM"; 		//VM		
	String SVC_GBN_AFLT = "AFLT";	//관계사
	String SVC_GBN_SW = "SW";	//SW 라이센스
	String SVC_GBN_EXCLCRCT = "EXCL_CRCT";	//전용선
	
	/*가상화코드(하이퍼바이저)
	 * */
	//LEGACY
	//EXADATA
	String HYPER_PUREFLEX = "POWERVM_PUREFLEX";
	//POWERVM_HMC
	//VMWARE
	//OVM
	//POWERVM_I710\\\
	
	String DSTRBT_TYP_ALL = "ALL"; //전체금책 
	String DSTRBT_TYP_COM_AMT_EXPT = "COM_AMT_EXCPT"; //공통,재무 제외
	String DSTRBT_TYP_COM_AMT = "COM_AMT";	//공통,재무
	
	String CHRG_METHD_GBN_U = "U"; //사용량
	String CHRG_METHD_GBN_A = "A";  //할당량
	
}
