package com.yx.bootswagger.easyexcel.common;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.google.common.collect.Lists;
import com.yx.bootswagger.shiro.domain.Person;
import org.apache.poi.ss.formula.functions.T;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @description:
 * @author: GIF
 * @createDate: 2019/12/26 14:28
 * @version: 1.0
 */
public class PersonListener extends AnalysisEventListener<Person> {

    Collection<Person> coll = new ArrayList<>();
    @Override
    public void invoke(Person person, AnalysisContext analysisContext) {
        coll.add(person);
        System.err.println("解析数据"+person);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        System.out.println(coll);
    }
}
