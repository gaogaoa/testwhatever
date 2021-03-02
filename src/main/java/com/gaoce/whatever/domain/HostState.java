package com.gaoce.whatever.domain;

import com.fasterxml.jackson.annotation.JsonValue;

public enum HostState {
    Normal(0),NET_UNREACHABLE(1),NETWORK_PROTOCOL_ERROR(2),
    UNKNOWN_DEVICE(3),UNKNOWN_USER(4),SNMP_NO_AUTH_WRITE(5),
    WRONG_CONFIGURATION(8),PORT_SHUTDOWN(9),WRONG_PACKAGE_(10),
    DEVICE_PORT_MISMATCH(11),TRAFFIC_OUT_MORE_THAN_IN(16),
    TRAFFIC_OUT_LESS_THAN_IN(17),TRAFFIC_CHANGED(18),GTC(24),
    G_D_LINK_NUMBER_MISMATCH(25);
    private int value;
    HostState(int value){
        this.value=value;
    }
    @JsonValue
    public int getValue() {
        return value;
    }
}
