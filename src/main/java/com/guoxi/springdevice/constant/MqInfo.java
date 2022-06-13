package com.guoxi.springdevice.constant;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * machine_info
 * @author 
 */
@Data
@AllArgsConstructor
public class MqInfo implements Serializable {


    /**
     *
     *  * {
     *  *     "messageType":"发送类型/接受类型",
     *  *     "id": 0,//设备id
     *  *     "machineAttribute": "属性",
     *  *     "machineParam": "string",
     *  *     "machineType": "机器类型",
     *  *     "machineStatus": "机器状态（0未激活，1激活，2租赁）",
     *  *     "machineOwner": "机器所属者（经销商）",
     *  *     "machineBrand": "机器品牌",
     *  *     "userId": 0,//机器所属者id
     *  *     "machineWorkTimeOnce": "单次使用时长",
     *  *     "apkUrl":"",//android更新包地址
     *  *     "firmUrl":"",//固件更新包地址
     *  * }
     *
     */

    private Integer messageType;
    private Integer id;

    private String machineType;

    private String machineFunction;

    private String machineParam;

    private String machineAttribute;

    private Integer userId;

    /**
     * 使用时长
     */
    private Integer usedDuration;

    /**
     * 品牌
     */
    private String machineBrand;

    private String userName;

    /**
     * 设备状态
     */
    private String machineStatus;

    /**
     * 单词使用时长
     */
    private Integer machineWorkTimeOnce;

    private String machineProvice;

    private String machineCity;

    private String apkUrl;
    private String firmUrl;

    private String token;

    private static final long serialVersionUID = 1L;



}