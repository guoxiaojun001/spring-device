package com.guoxi.springdevice.constant;



public interface TopicType {

    //设备状态信息,android 端发送过来

    //前端发送过来的请求
    String TOPIC_REQ = "topic_req";

    String RESPONSE_TOPIC = "topic_res";//响应主题

    String DEVICE_STATUS = "/+/device_status";//响应主题

    String[] TList = {DEVICE_STATUS,TOPIC_REQ,RESPONSE_TOPIC};

}
