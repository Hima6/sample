package com.sample.project.expensereport.enumerations;

import org.springframework.util.StringUtils;

public enum BillTypeEnum {
	MAINTAINANCE("MNT", "Maintainance"),
    ELECTRICITY("ECT", "Electricity"),
    RENT("RNT", "Rent"),
    INTERNET("INT", "Internet"),
    GAS("GAS", "Gas Bill");

    private String billType;
    private String description;

    private BillTypeEnum(String billType) {
        this.billType = billType;
    }
    
    private BillTypeEnum(String billType, String description) {
        this.billType = billType;
        this.description = description;
    }

    public String getBillType() {
        return billType;
    }
    
    public String getDescription() {
        return this.description;
    }
    
    public static String getBillTypeDescription(String code) {
        return !StringUtils.isEmpty(code) ? getBillTypeEnum(code).getDescription() : null;
    }

    public static BillTypeEnum getBillTypeEnum(String billType) {
        for (BillTypeEnum billTypeEnum : values()) {
            if (billTypeEnum.getBillType().equalsIgnoreCase(billType)) {
                return billTypeEnum;
            }
        }
        return null;
    }

}
