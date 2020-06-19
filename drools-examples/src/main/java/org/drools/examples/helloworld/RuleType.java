package org.drools.examples.helloworld;

public enum RuleType {
    REQUEST_ADD_UPDATE("request_add_update","采购申请新增变更"),
    REQUEST_REQUEST_UPDATE("request_back","采购申请撤销"),
    PACT_ADD_UPDATE_BACK("pact_add_update_back","采购合同新增变更撤销"),
    RECEIVE_PACKET_AND_BACK_PACKET("receive_packet_and_back_packet","采购收货及退换货"),
    PRE_PAY("pre_pay","采购预付款"),
    GET_TICKET_PAY_REQUEST("get_ticket_pay_request","到票付款申请")
    ;
    private String val;
    private String desc;

    RuleType(String val, String desc) {
        this.val = val;
        this.desc = desc;
    }

    public String getVal() {
        return val;
    }

    public String getDesc() {
        return desc;
    }
}
