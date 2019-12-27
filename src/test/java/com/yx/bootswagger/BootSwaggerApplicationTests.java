package com.yx.bootswagger;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.builder.ExcelReaderSheetBuilder;
import com.yx.bootswagger.easyexcel.common.PersonListener;
import com.yx.bootswagger.shiro.domain.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BootSwaggerApplicationTests {

    @Test
    public void contextLoads() {
            String fileName = "C:\\Users\\THE GIFTED\\Desktop\\会员积分数据.xlsx";
            // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
            // 参数一：读取的excel文件路径
            // 参数二：读取sheet的一行，将参数封装在DemoData实体类中
            // 参数三：读取每一行的时候会执行DemoDataListener监听器
            ExcelReaderSheetBuilder sheet = EasyExcel.read(fileName, Person.class, new PersonListener()).sheet();
            sheet.doRead();

    }

}
