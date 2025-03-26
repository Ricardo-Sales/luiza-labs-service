package com.luiza.labs.enums;

public enum ComunicationTypeEnum {
    EMAIL("email"),
    SMS("sms"),
    PUSH("push"),
    WHATSAPP("whatsapp");

    public String value;

    ComunicationTypeEnum(String description){
        this.value = value;
    }
}
