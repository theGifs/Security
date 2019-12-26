package com.yx.bootswagger.easyexcel.controller;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.yx.bootswagger.shiro.domain.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @description:
 * @author: GIF
 * @createDate: 2019/12/26 11:19
 * @version: 1.0
 */
@Controller
public class ExcelController {


    @RequestMapping("/export/person")
    public void downloadExcel(HttpServletResponse response){
        try {
            List<Person> persons=new ArrayList<>();
            for (int i = 1; i <=10; i++) {
//			persons.add(new Person(i, "小明"+i, "武汉"+i, new Random().nextBoolean()?1:0));
                persons.add(new Person(i, "小明"+i, "武汉"+i, new Random().nextDouble()>=0.5?1:0));
            }
            OutputStream out = response.getOutputStream();
            ExcelWriter writer =new ExcelWriter(out, ExcelTypeEnum.XLSX);
            Sheet sheet1 =new Sheet(1, 0, Person.class);
            sheet1.setSheetName("会员积分");
            response.setCharacterEncoding("utf-8");
            response.setContentType("application/vnd.ms-excel;charset=utf-8");
            response.setHeader("Content-Disposition", "attachment;filename=" +new String(( "会员积分数据.xlsx").getBytes(), "ISO8859-1"));
            writer.write(persons, sheet1);
            writer.finish();
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
