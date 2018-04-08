package com.better3U.com.controller;

/**
 * 登录调用
 *
 * @author tangyuan
 * @create 2018-01-26 10:05
 **/

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

@org.springframework.stereotype.Service
public class ValidEffectUserImpl implements ValidEffectUser {
    public boolean validEffectUser(String jobnum, String password)throws Exception {
        String endpoint = "http://172.18.8.168:10000/SINGPOINT/services/ValidEffectUser?wsdl";
        Service service = new Service();
        Call call = (Call) service.createCall();
        call.setTargetEndpointAddress(endpoint);
        call.setOperationName("validatorLegalUser");// WSDL里面描述的接口名称
        call.addParameter("empNo", org.apache.axis.encoding.XMLType.XSD_DATE,
                javax.xml.rpc.ParameterMode.IN);// 接口的参数
        call.addParameter("password",
                org.apache.axis.encoding.XMLType.XSD_DATE,
                javax.xml.rpc.ParameterMode.IN);// 接口的参数
        call.setReturnType(org.apache.axis.encoding.XMLType.XSD_STRING);// 设置返回类型

        String result = (String) call.invoke(new Object[] { jobnum, password });
        String rightCode = "验证用户成功";
        return result.indexOf(rightCode) != -1;
    }

}
