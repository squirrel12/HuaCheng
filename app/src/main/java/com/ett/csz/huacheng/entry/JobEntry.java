package com.ett.csz.huacheng.entry;

/**
 * Created by csz on 2016/9/28.
 */

public class JobEntry extends BaseEntity{
    private String ProjectName;//项目名称
    private String AreaName;//区域名称
    private String HotLineFromName;//信息来源名称
    public String getHotLineFromName() {
        return HotLineFromName;
    }

    public void setHotLineFromName(String hotLineFromName) {
        HotLineFromName = hotLineFromName;
    }

    public String getProjectName() {
        return ProjectName;
    }

    public void setProjectName(String projectName) {
        ProjectName = projectName;
    }

    public String getAreaName() {
        return AreaName;
    }

    public void setAreaName(String areaName) {
        AreaName = areaName;
    }
public JobEntry(String ProjectName,String AreaName,String HotLineFromName){
    super();
    this.ProjectName=ProjectName;
    this.AreaName=AreaName;
    this.HotLineFromName=HotLineFromName;
}

}
