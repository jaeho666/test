package com.nkia.xeus.service.billing.charge;
/**
 * <p> �������� ����ϴ� ��� ����
 * 
 */
public interface BillingConstants { 
	/**
	 * commit ���ذ���
	 * */
	int COMMIT_CNT = 1000; //TRANSACTION ó����  COMMIT ���� �Ǽ�
	/**
	 * Ÿ���ڵ�
	 * */
	String TYP_CD_CPU  = "CPU"; 				//CPU
	String TYP_CD_MEMORY = "MEMORY"; 			//�޸�
	String TYP_CD_DISK = "DISK"; 				//���丮��
	String TYP_CD_DISK_SHARED = "DISK_SHARED"; 	//������ũ
	String TYP_CD_DISK_COMM = "DISK_COMM"; 		//�����ũ
	String TYP_CD_HA = "HA"; 					//HA����
	String TYP_CD_DR = "DR";
	String TYP_CD_DUPLICATE = "DUPLICATE"; //�ǽð� ����/ �һ�
	//String TYP_CD_BACKUP = "DUPLICATE";			//�������, �һ�
	String TYP_CD_DR_CIRCUIT = "DR_CIRCUIT"; 	//���Ͱ� ȸ�� ����
	String TYP_CD_NAS_SHARED = "NAS_SHARED"; 	// ���NAS
	String TYP_CD_NAS_DEDICATED = "NAS_DEDICATED"; 		//��� NAS
	String TYP_CD_NETWORK_PUBLIC = "NETWORK_PUBLIC";	//����Ʈ��ũ
	String TYP_CD_NETWORK_PRIVATE = "NETWORK_PRIVATE"; 	//����Ʈ��ũ 
	String TYP_CD_NETWORK_DEPT = "NETWORK_DEPT"; 		//��뼱
	String TYP_CD_SOFTWARE = "SOFTWARE";
	String TYP_CD_STG_DEDICATED = "STG_DEDICATED";
	String TYP_CD_NAS_SERVER = "NAS_SERVER";			//���NAS - �̸�Ʈ
		
	
	/**
	 * �ɼ��ڵ�
	 **/	
	String OPT_CD_VCORE= "VCORE"; 					//�Ҵ� ������ vCore ��
	String OPT_CD_SOCKET= "SOCKET"; 				//Socket
	String OPT_CD_ENT_VCORE= "ENT_VCORE";			//���� �Ҵ�� vCore ��
	String OPT_CD_MIN_VCORE= "MIN_VCORE"; 			//�ּ� �Ҵ� ������ vCore ��
	String OPT_CD_MAX_VCORE= "MAX_VCORE"; 			//�ִ� �Ҵ� ������ vCore ��
	String OPT_CD_PRVSNG_SIZE= "PRVSNG_SIZE"; 		//Provisioning ���Ҵ緮
	String OPT_CD_TOTAL_SIZE= "TOTAL_SIZE"; 		//MORY, Disk, NAS �� ���Ҵ緮
	String OPT_CD_EXT_EXADATA_DISK= "EXT_EXADATA_DISK"; //EXADATA Disk
	String OPT_CD_EXT_DATA_V7K= "EXT_DATA_V7K"; 	//DATA DISK (V7000)
	String OPT_CD_EXT_DATA_VMAX= "EXT_DATA_VMAX"; 	//DATA DISK (EMC VMAX)
	String OPT_CD_EXT_DATA_VNX= "EXT_DATA_VNX"; 	//DATA DISK (EMC VNX)
	String OPT_CD_INT_DATA_DISK= "INT_DATA_DISK"; 	//����(����) DATA DISK
	String OPT_CD_EXT_OS_V7K= "EXT_OS_V7K"; 		//OS DISK (V7000)
	String OPT_CD_EXT_OS_EIO= "EXT_OS_EIO"; 		//OS DISK (EMC ExtreamIO)
	String OPT_CD_EXT_OS_VMAX= "EXT_OS_VMAX"; 		//OS DISK (EMC VMAX)
	String OPT_CD_EXT_OS_VNX= "EXT_OS_VNX"; 		//OS DISK (EMC VNX)
	String OPT_CD_INT_OS_DISK= "INT_OS_DISK"; 		//���� OS DISK
	String OPT_CD_DISK_SHARED= "DISK_SHARED"; 		//����(Shared) Disk ���Ҵ緮
	String OPT_CD_DISK_COMM= "DISK_COMM"; 			//����(Common) Disk ���Ҵ緮
	String OPT_CD_INT_ARK= "INT_ARK"; 				//INT ARK ��ũ
	
	String OPT_CD_NTX_OS_DISK= "NTX_OS_DISK"; 				//NUTANIX OS DISK
	String OPT_CD_NTX_DATA_DISK= "NTX_DATA_DISK"; 				//NUTANIX DATA DISK
	
	
	String OPT_CD_DR_SERVICE= "DR_SERVICE"; 		//DR ����
	String OPT_CD_DR_CENTER= "DR_CENTER"; 			//DR ����
	
	String OPT_CD_TCP_IP_OS = "TCP_IP_OS"; 			//���Ͱ� ���� ȸ��
	String OPT_CD_TCP_IP_NAS = "TCP_IP_NAS"; 		//���Ͱ� ���� NAS
	String OPT_CD_TCP_IP_ADG = "TCP_IP_ADG"; 		//���Ͱ� ���� EXADATA
	String OPT_CD_TCP_IP_FC = "TCP_IP_FC"; 			//���Ͱ� ���� FC
	String OPT_CD_INTERNET = "INTERNET";			//���Ͱ� ���� ���ͳ�
	String OPT_CD_TCP_IP_ARK = "TCP_IP_ARK"; 		//���Ͱ� ���� ARK
	String OPT_CD_TCP_IP_BACKUP = "TCP_IP_BACKUP"; 	//���Ͱ� ���� �һ�
	
	String OPT_CD_NW_NETWORK= "NW_NETWORK"; 		//��Ʈ��ũ 
	String OPT_CD_NW_SECCURITY= "NW_SECCURITY"; 	//����
	String OPT_CD_NW_SAN= "NW_SAN"; 				//��Ʈ��ũ �����
	
	String OPT_CD_NETWORK_VPN= "NW_VPN"; 			//VPN
	String OPT_CD_NETWORK_ROUTER= "NW_ROUTER"; 		//ROUTER
	
	String OPT_CD_MPLS= "MPLS"; 					//�纰��Ʈ��ũ (MPLS)
	String OPT_CD_GENERAL_VAN= "GENERAL_VAN"; 		//��뼱/VAN
	
	String OPT_CD_REALTIME= "REALTIME"; 			//�ǽð� ���� (Vplex+����SAN)
	String OPT_CD_SYMANTEC= "SYMANTEC"; 			//�һ� ����
	String OPT_CD_RECOVERPOINT= "RECOVERPOINT"; 	//������� (VNX 5800)
	
	String OPT_CD_NAS= "NAS_SHARED"; 				//���NAS
	String OPT_CD_NAS_DEDICATED= "NAS_DEDICATED"; 	//���NAS
	
	String OPT_CD_HA_SERVICE= "HA_SERVICE"; 		//HA ����
	
	String OPT_CD_NETWORK_PUBLIC= "NETWORK_PUBLIC"; 	//��� ��Ʈ��ũ
	String OPT_CD_NETWORK_PRIVATE= "NETWORK_PRIVATE"; 	//��� ��Ʈ��ũ
	String OPT_CD_NETWORK_DEPT= "NETWORK_DEPT"; 		//�纰��Ʈ��ũ
	
	String OPT_CD_NW_DEDICATED= "NW_DEDICATED"; 		//�Ϲ� ��� ��Ʈ��ũ
	
	String OPT_CD_SW_ORACLE_LINUX= "SW_ORACLE_LINUX"; //Oracle Linux
	String OPT_CD_SW_REDHAT_LINUX= "SW_REDHAT_LINUX"; //Redhat Linux
	String OPT_CD_NAS_SERVER_DEDICATED= "NAS_SERVER_DEDICATED"; //�̸�Ʈ ���NAS
	

	
	/**
	 * ���̼������� �ڵ�
	 * */
	String LCNS_TYP_SERVER = "SERVER";
	String LCNS_TYP_CPU = "CPU";
	String LCNS_TYP_COER = "CORE";
	
	long SW_LCNS_CPU_CNT = 2;
	
	
	/**
	 * ��������ڵ�
	 * */
	String ADJ_METHOD_01 = "ADJ_M01"; //�ݾ� ����
	String ADJ_METHOD_02 = "ADJ_M02"; //�Ⱓ����
	
	/**
	 * ��������ڵ�
	 * */
	String ADJ_TARGET_01 = "ADJ_T01"; //VM ����
	String ADJ_TARGET_02 = "ADJ_T02"; //��뼱����
	String ADJ_TARGET_03 = "ADJ_T03"; //���NAS����
	String ADJ_TARGET_04 = "ADJ_T04"; //���纸��
	
	/**
	 * �ش���׾���
	 * */
	String NA = "N/A";
	
	/**
	 * ����ʱ�ȭ�� �ϴ� ������ ���� ��ݵ����͸� �����ؾ��ϴ� ���̺�
	 * */
	String DEL_TBL_ACT_CHRG_SVR  			= "ACT_CHRG_SVR"; 			//��ݴ�󼭹�
	String DEL_TBL_ACT_SVC_USE_DTL  		= "ACT_SVC_USE_DTL"; 		//���񽺻�볻��
	String DEL_TBL_ACT_SW_USE_DTL  			= "ACT_SW_USE_DTL"; 		//SW ��볻��\
	String DEL_TBL_ACT_USEVAL_BASED_CHRG_DTL = "ACT_USEVAL_BASED_CHRG_DTL"; 		//��뷮��ݰ�ݳ���
	String DEL_TBL_ACT_USEVAL_BASED_USE_DTL  = "ACT_USEVAL_BASED_USE_DTL"; 		//��뷮��ݻ�볻��
	
	
	String DEL_TBL_BILL_CHRG_MSTR  			= "BILL_CHRG_MSTR"; 		//��ݿ���
	String DEL_TBL_BILL_SW_DTL  			= "BILL_SW_DTL"; 			// ��ݿ���SW����
	String DEL_TBL_BILL_COMM_BIZ_CHRG_DTL 	= "BILL_COMM_BIZ_CHRG_DTL"; //������� ��ݳ���
	String DEL_TBL_BILL_COMM_BIZ_DSTRBT 	= "BILL_COMM_BIZ_DSTRBT"; 	//���������г���
	String DEL_TBL_BILL_COMM_BIZ_DSTRBT_SMRY = "BILL_COMM_BIZ_DSTRBT_SMRY"; //������� ��ݳ������
	String DEL_TBL_BILL_SYS_CHRG_SMRY 		= "BILL_SYS_CHRG_SMRY"; 		//�������� ��ݳ������
	
	// ������� ��ݳ��� ACT_AFLT_VAN_SVC_USE_DTL
	String DEL_TBL_ACT_AFLT_VAN_SVC_USE_DTL  	= "ACT_AFLT_VAN_SVC_USE_DTL"; //��������� ������� VAN ��� ����
	String DEL_TBL_ACT_AFLT_SVC_USE_DTL  	= "ACT_AFLT_SVC_USE_DTL"; 		//��������� ���� ��볻��
	String DEL_TBL_BILL_AFLT_CHRG_MSTR  	= "BILL_AFLT_CHRG_MSTR"; 		//��������� ��ݸ�����
	// ������� ��ݳ��� 
	String DEL_TBL_ACT_AFLT_NAS_USE_DTL  	= "ACT_AFLT_NAS_USE_DTL"; 		//��������� NAS ��볻��
	String DEL_TBL_ACT_CHRG_AFLT_NAS  		= "ACT_CHRG_AFLT_NAS"; 			//��������� NAS ������� 
	String DEL_TBL_BILL_AFLT_NAS_MSTR  		= "BILL_AFLT_NAS_CHRG_MSTR"; 	//��������� NAS ��ݸ�����
	
	String DEL_TBL_BILL_BILL_MSTR 			= "BILL_BILL_MSTR"; 			//û��������- ����������
	String DEL_TBL_BILL_DR_BILL_MSTR 			= "BILL_DR_BILL_MSTR"; 		//û�������� - DR
	String DEL_TBL_BILL_AFLT_BILL_MSTR 		= "BILL_AFLT_BILL_MSTR"; 		//���纰û��������
	//��ȭ�� ���
	String DEL_TBL_BILL_DEPTSTORE_DSTRBT_MSTR 		= "BILL_DEPTSTORE_DSTRBT_MSTR"; 		//���纰û��������
	String DEL_TBL_BILL_DEPTSTORE_DSTRBT_DTL 		= "BILL_DEPTSTORE_DSTRBT_DTL"; 		//���纰û��������
	
	

	

	
	//���� ��ݿ���
	/**
	 * ��ݹ�ġ�۾� �������
	 * */
	String RUN_STAT_RUNNING = "RUNNING";
	String RUN_STAT_NOT_RUNNING = "NOT_RUNNING";
	String RUN_STAT_COMPLETE = "COMPLETE";
	String RUN_STAT_ERROR = "ERROR";

	/**
	 * ���������ڵ�
	 * */
	String MDL_AFLT_DEFAULT = "DEFAULT";
	String MDL_AFLT_SHARED = "SHARED";
	/*
	 * �����ڵ�
	 * */
	String AFLT_D_INC = "D_008";
	
	/*
	 * �����ڵ�
	 * */
	String CENTER_01 = "CENTER01";	//����������
	String CENTER_02 = "CENTER02";	//DR����
	
	/*
	 * ���񽺱���
	 * */
	String SVC_GBN_VM = "VM"; 		//VM		
	String SVC_GBN_AFLT = "AFLT";	//����
	String SVC_GBN_SW = "SW";	//SW ���̼���
	String SVC_GBN_EXCLCRCT = "EXCL_CRCT";	//��뼱
	
	/*����ȭ�ڵ�(�����۹�����)
	 * */
	//LEGACY
	//EXADATA
	String HYPER_PUREFLEX = "POWERVM_PUREFLEX";
	//POWERVM_HMC
	//VMWARE
	//OVM
	//POWERVM_I710\\\
	
	String DSTRBT_TYP_ALL = "ALL"; //��ü��å 
	String DSTRBT_TYP_COM_AMT_EXPT = "COM_AMT_EXCPT"; //����,�繫 ����
	String DSTRBT_TYP_COM_AMT = "COM_AMT";	//����,�繫
	
	String CHRG_METHD_GBN_U = "U"; //��뷮
	String CHRG_METHD_GBN_A = "A";  //�Ҵ緮
	
}
