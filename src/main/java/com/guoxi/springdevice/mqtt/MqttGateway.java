package com.guoxi.springdevice.mqtt;

import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.messaging.handler.annotation.Header;

/**
 * mqtt gateway
 *
 * @author guoxi_789@126.com
 * @date 2020/12/15
 */
@MessagingGateway(defaultRequestChannel = "mqttOutboundChannel")
public interface MqttGateway {
    /**
    * 功能描述
    * @author guoxi_789@126.com
    * @date 2020/12/15
    * @param  data , topic
    * @return void
    */
    void sendToMqtt(String data, @Header(MqttHeaders.TOPIC) String topic);
}