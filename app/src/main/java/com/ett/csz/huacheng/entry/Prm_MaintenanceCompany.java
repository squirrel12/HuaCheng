package com.ett.csz.huacheng.entry;

/**
 * 维修公司参数表
 * Created by csz on 2016/9/19.
 */
public class Prm_MaintenanceCompany extends BaseEntity{
    private String ID;//主键ID
    private String MaintenanceCompany;//维修公司
    private String MaintenancePerson;//维修人
    private String RepairsPersonnelTel;//联系方式
    private String LoginID;//项目ID
    private String EditDate;//编辑时间
    private String EditPersonnel;//编辑人
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getMaintenanceCompany() {
        return MaintenanceCompany;
    }

    public void setMaintenanceCompany(String maintenanceCompany) {
        MaintenanceCompany = maintenanceCompany;
    }

    public String getMaintenancePerson() {
        return MaintenancePerson;
    }

    public void setMaintenancePerson(String maintenancePerson) {
        MaintenancePerson = maintenancePerson;
    }

    public String getRepairsPersonnelTel() {
        return RepairsPersonnelTel;
    }

    public void setRepairsPersonnelTel(String repairsPersonnelTel) {
        RepairsPersonnelTel = repairsPersonnelTel;
    }

    public String getLoginID() {
        return LoginID;
    }

    public void setLoginID(String loginID) {
        LoginID = loginID;
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


}
