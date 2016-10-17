package com.ett.csz.huacheng.entry;

import com.ett.csz.huacheng.util.PageInfo;

import java.util.List;

/**
 * 抢修实体类
 * Created by csz on 2016/10/8.
 */

public class RepairEntity extends BaseEntity {
    private String RepairID; //
    private String JobNumber; //
    private String SingleState;
    private String DeviceNo;
    private String ProjectID;
    private String ProjectName;
    private String ProjectAddress;
    private String AreaID;
    private String ProjectLocale;
    private String EquipmentType;
    private String RepairsPersonnelName;
    private String RepairsPersonnelTel;
    private String RepairsPersonnelAddress;
    private String ReportDate;
    private String HotLineFrom;
    private String OrderDate;
    private String ReportType;
    private String RepairType;
    private String IsXiangFu;
    private String IsShouFei;
    private String ChuDongRenCi;
    private String ChuDongCheCi;
    private String UserRespond;
    private String FaultPerformance;
    private String RecordPerson;
    private String ArrivaTime;
    private String XianChangYongShi;
    private String MaintenanceContent;
    private String UserOkContent;
    private String XiaoZuShenHeRen ;
    private String MaintenancePerson;
    private String CompletionTime;
    private String HCAppEr;
    private String HCAppDate;
    private String AppEr;
    private String AppDate;
    private String AppPrincipal;
    private String AppPrincipalDate;
    private String GongDanType;
    private String EditDate;
    private String EditPersonnel;

    public String getRepairID() {
        return RepairID;
    }

    public void setRepairID(String repairID) {
        RepairID = repairID;
    }

    public String getJobNumber() {
        return JobNumber;
    }

    public void setJobNumber(String jobNumber) {
        JobNumber = jobNumber;
    }

    public String getSingleState() {
        return SingleState;
    }

    public void setSingleState(String singleState) {
        SingleState = singleState;
    }

    public String getDeviceNo() {
        return DeviceNo;
    }

    public void setDeviceNo(String deviceNo) {
        DeviceNo = deviceNo;
    }

    public String getProjectID() {
        return ProjectID;
    }

    public void setProjectID(String projectID) {
        ProjectID = projectID;
    }

    public String getProjectName() {
        return ProjectName;
    }

    public void setProjectName(String projectName) {
        ProjectName = projectName;
    }

    public String getProjectAddress() {
        return ProjectAddress;
    }

    public void setProjectAddress(String projectAddress) {
        ProjectAddress = projectAddress;
    }

    public String getAreaID() {
        return AreaID;
    }

    public void setAreaID(String areaID) {
        AreaID = areaID;
    }

    public String getProjectLocale() {
        return ProjectLocale;
    }

    public void setProjectLocale(String projectLocale) {
        ProjectLocale = projectLocale;
    }

    public String getEquipmentType() {
        return EquipmentType;
    }

    public void setEquipmentType(String equipmentType) {
        EquipmentType = equipmentType;
    }

    public String getRepairsPersonnelName() {
        return RepairsPersonnelName;
    }

    public void setRepairsPersonnelName(String repairsPersonnelName) {
        RepairsPersonnelName = repairsPersonnelName;
    }

    public String getRepairsPersonnelTel() {
        return RepairsPersonnelTel;
    }

    public void setRepairsPersonnelTel(String repairsPersonnelTel) {
        RepairsPersonnelTel = repairsPersonnelTel;
    }

    public String getRepairsPersonnelAddress() {
        return RepairsPersonnelAddress;
    }

    public void setRepairsPersonnelAddress(String repairsPersonnelAddress) {
        RepairsPersonnelAddress = repairsPersonnelAddress;
    }

    public String getReportDate() {
        return ReportDate;
    }

    public void setReportDate(String reportDate) {
        ReportDate = reportDate;
    }

    public String getHotLineFrom() {
        return HotLineFrom;
    }

    public void setHotLineFrom(String hotLineFrom) {
        HotLineFrom = hotLineFrom;
    }

    public String getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(String orderDate) {
        OrderDate = orderDate;
    }

    public String getReportType() {
        return ReportType;
    }

    public void setReportType(String reportType) {
        ReportType = reportType;
    }

    public String getRepairType() {
        return RepairType;
    }

    public void setRepairType(String repairType) {
        RepairType = repairType;
    }

    public String getIsXiangFu() {
        return IsXiangFu;
    }

    public void setIsXiangFu(String isXiangFu) {
        IsXiangFu = isXiangFu;
    }

    public String getIsShouFei() {
        return IsShouFei;
    }

    public void setIsShouFei(String isShouFei) {
        IsShouFei = isShouFei;
    }

    public String getChuDongRenCi() {
        return ChuDongRenCi;
    }

    public void setChuDongRenCi(String chuDongRenCi) {
        ChuDongRenCi = chuDongRenCi;
    }

    public String getChuDongCheCi() {
        return ChuDongCheCi;
    }

    public void setChuDongCheCi(String chuDongCheCi) {
        ChuDongCheCi = chuDongCheCi;
    }

    public String getUserRespond() {
        return UserRespond;
    }

    public void setUserRespond(String userRespond) {
        UserRespond = userRespond;
    }

    public String getFaultPerformance() {
        return FaultPerformance;
    }

    public void setFaultPerformance(String faultPerformance) {
        FaultPerformance = faultPerformance;
    }

    public String getRecordPerson() {
        return RecordPerson;
    }

    public void setRecordPerson(String recordPerson) {
        RecordPerson = recordPerson;
    }

    public String getArrivaTime() {
        return ArrivaTime;
    }

    public void setArrivaTime(String arrivaTime) {
        ArrivaTime = arrivaTime;
    }

    public String getXianChangYongShi() {
        return XianChangYongShi;
    }

    public void setXianChangYongShi(String xianChangYongShi) {
        XianChangYongShi = xianChangYongShi;
    }

    public String getMaintenanceContent() {
        return MaintenanceContent;
    }

    public void setMaintenanceContent(String maintenanceContent) {
        MaintenanceContent = maintenanceContent;
    }

    public String getUserOkContent() {
        return UserOkContent;
    }

    public void setUserOkContent(String userOkContent) {
        UserOkContent = userOkContent;
    }

    public String getXiaoZuShenHeRen() {
        return XiaoZuShenHeRen;
    }

    public void setXiaoZuShenHeRen(String xiaoZuShenHeRen) {
        XiaoZuShenHeRen = xiaoZuShenHeRen;
    }

    public String getMaintenancePerson() {
        return MaintenancePerson;
    }

    public void setMaintenancePerson(String maintenancePerson) {
        MaintenancePerson = maintenancePerson;
    }

    public String getCompletionTime() {
        return CompletionTime;
    }

    public void setCompletionTime(String completionTime) {
        CompletionTime = completionTime;
    }

    public String getHCAppEr() {
        return HCAppEr;
    }

    public void setHCAppEr(String HCAppEr) {
        this.HCAppEr = HCAppEr;
    }

    public String getHCAppDate() {
        return HCAppDate;
    }

    public void setHCAppDate(String HCAppDate) {
        this.HCAppDate = HCAppDate;
    }

    public String getAppEr() {
        return AppEr;
    }

    public void setAppEr(String appEr) {
        AppEr = appEr;
    }

    public String getAppDate() {
        return AppDate;
    }

    public void setAppDate(String appDate) {
        AppDate = appDate;
    }

    public String getAppPrincipal() {
        return AppPrincipal;
    }

    public void setAppPrincipal(String appPrincipal) {
        AppPrincipal = appPrincipal;
    }

    public String getAppPrincipalDate() {
        return AppPrincipalDate;
    }

    public void setAppPrincipalDate(String appPrincipalDate) {
        AppPrincipalDate = appPrincipalDate;
    }

    public String getGongDanType() {
        return GongDanType;
    }

    public void setGongDanType(String gongDanType) {
        GongDanType = gongDanType;
    }

    public String getEditDate() {
        return EditDate;
    }

    public void setEditDate(String editDate) {
        EditDate = editDate;
    }

    public String getEditPersonnel() {
        return EditPersonnel;
    }

    public void setEditPersonnel(String editPersonnel) {
        EditPersonnel = editPersonnel;
    }
    public static List<RepairEntity> parseBySimple(String json, PageInfo pageInfo){
        List<RepairEntity> datas = null;
        try{
            //TODO：解析返回的数据

        }catch (Exception e){
            e.printStackTrace();
        }
        return datas;
    }
}
