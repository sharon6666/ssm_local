package com.jacksonDemo;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: ssm
 * @Package: com.jacksonDemo
 * @Description: note
 * @Author:
 * @CreateDate: 2019-8-3 12:46
 * @UpdateUser:
 * @UpdateDate: 2019-8-3 12:46
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 **/
public class PostVoiceInfo {
    private String stateId = " ";
    private Character onlineCompose = ' ';
    private String  md5 = " ";

    public PostVoiceInfo(String stateId, Character onlineCompose, String md5) {
        this.stateId = stateId;
        this.onlineCompose = onlineCompose;
        this.md5 = md5;
    }

    public PostVoiceInfo() {
    }

    public String getStateId() {
        return stateId;
    }

    public void setStateId(String stateId) {
        this.stateId = stateId;
    }

    public Character getOnlineCompose() {
        return onlineCompose;
    }

    public void setOnlineCompose(Character onlineCompose) {
        this.onlineCompose = onlineCompose;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    @Override
    public String toString() {
        return "PostVoiceInfo{" +
                "stateId='" + stateId + '\'' +
                ", onlineCompose=" + onlineCompose +
                ", md5='" + md5 + '\'' +
                '}';
    }
}
