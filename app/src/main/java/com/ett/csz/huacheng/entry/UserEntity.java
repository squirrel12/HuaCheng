package com.ett.csz.huacheng.entry;

/**
 * 用户实体类
 * Created by csz on 2016/10/8.
 */

public class UserEntity extends BaseEntity{
    private String UserID;  //ID
    private String LoginName;  //登录名
    private String ChineseName;  //用户名
    private String JobNumber;  //工号
    private String MobilePhone;   //手机
    private String Email; //邮箱
    private String QQ; //QQ

    public UserEntity(String userID, String loginName, String chineseName, String jobNumber, String mobilePhone, String email, String qq) {
        super();
        this.UserID=userID;
        this.LoginName=loginName;
        this.ChineseName=chineseName;
        this.JobNumber=jobNumber;
        this.MobilePhone=mobilePhone;
        this.Email=email;
        this.QQ=qq;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String userID) {
        UserID = userID;
    }

    public String getLoginName() {
        return LoginName;
    }

    public void setLoginName(String loginName) {
        LoginName = loginName;
    }

    public String getChineseName() {
        return ChineseName;
    }

    public void setChineseName(String chineseName) {
        ChineseName = chineseName;
    }

    public String getJobNumber() {
        return JobNumber;
    }

    public void setJobNumber(String jobNumber) {
        JobNumber = jobNumber;
    }

    public String getMobilePhone() {
        return MobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        MobilePhone = mobilePhone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getQQ() {
        return QQ;
    }

    public void setQQ(String QQ) {
        this.QQ = QQ;
    }
    public UserEntity() {
        super();
    }

}
