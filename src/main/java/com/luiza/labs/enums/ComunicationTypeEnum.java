package com.luiza.labs.enums;

import java.util.Arrays;

public enum ComunicationTypeEnum {
    EMAIL("email"),
    SMS("sms"),
    PUSH("push"),
    WHATSAPP("whatsapp");

    public final String description;

    ComunicationTypeEnum(String description){
        this.description = description;
    }

    static public ComunicationTypeEnum getComunicationType(String value) {
        return Arrays.stream(ComunicationTypeEnum.values()).filter(ComType -> ComType.description.equalsIgnoreCase(value)).findFirst().orElse(null);
    }

}
