package com.testsmirk.model.room;

import java.util.ArrayList;

public class GroupDetailModel  {
    private String groupIcon;
    private String groupName;
    private String groupID;
    private String groupArea;
    private String groupSchool;
    private String groupGrade;
    private ArrayList<MemberModel> memberModel;
    private String groupMyName;

    public String getGroupIcon() {
        return groupIcon;
    }

    public void setGroupIcon(String groupIcon) {
        this.groupIcon = groupIcon;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupID() {
        return groupID;
    }

    public void setGroupID(String groupID) {
        this.groupID = groupID;
    }

    public String getGroupArea() {
        return groupArea;
    }

    public void setGroupArea(String groupArea) {
        this.groupArea = groupArea;
    }

    public String getGroupSchool() {
        return groupSchool;
    }

    public void setGroupSchool(String groupSchool) {
        this.groupSchool = groupSchool;
    }

    public String getGroupGrade() {
        return groupGrade;
    }

    public void setGroupGrade(String groupGrade) {
        this.groupGrade = groupGrade;
    }

    public ArrayList<MemberModel> getMemberModel() {
        return memberModel;
    }

    public void setMemberModel(ArrayList<MemberModel> memberModel) {
        this.memberModel = memberModel;
    }

    public String getGroupMyName() {
        return groupMyName;
    }

    public void setGroupMyName(String groupMyName) {
        this.groupMyName = groupMyName;
    }
}