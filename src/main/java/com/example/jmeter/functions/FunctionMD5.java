package com.example.jmeter.functions;


import org.apache.jmeter.engine.util.CompoundVariable;
import org.apache.jmeter.functions.AbstractFunction;
import org.apache.jmeter.functions.InvalidVariableException;
import org.apache.jmeter.samplers.SampleResult;
import org.apache.jmeter.samplers.Sampler;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * @Project: jmeter-functional
 * @Author: Jessica
 * @Create: 2022-10-09 16:00
 * @Desc：MD5函数 **/


public class FunctionMD5 extends AbstractFunction {

    private String idNumber; //特殊ID
    private String timeStamp; //时间戳

    /**
     * 函数执行逻辑，自定义函数的核心逻辑，并返回经过处理后的内容
     * @param sampleResult
     * @param sampler
     * @return
     * @throws InvalidVariableException
     */

    @Override
    public String execute(SampleResult sampleResult, Sampler sampler) throws InvalidVariableException {
        String result = "";

        result = String.valueOf(DigestUtils.md5(idNumber+timeStamp));

        return result;
    }

    /**
     * 设置函数接收参数值，接收JMeter界面用户传递过来的参数
     * @param
     * @throws InvalidVariableException
     */
    @Override
    public void setParameters(Collection<CompoundVariable> collection) throws InvalidVariableException {
        //检查参数个数
        //获取参数
        Object[] params = collection.toArray();
        //获取操作数1
        CompoundVariable cvId = (CompoundVariable) params[0];
        this.idNumber = cvId.execute();
        //获取操作数2
        CompoundVariable cvTime = (CompoundVariable) params[1];
        this.timeStamp = cvTime.execute();

    }

    /**
     * 函数名称
     * @return
     */
    @Override
    public String getReferenceKey() {
        return "__FunctionMD5";
    }

    /**
     * 函数参数描述，JMeter界面显示的参数说明
     * @return
     */
    public List<String> getArgumentDesc() {
        List<String> desc = new LinkedList<String>();
        desc.add("特殊ID");
        desc.add("时间戳");
        return desc;
    }


}
