package com.jason;

import com.jason.service.HBaseService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @Author: 小小千千
 * @CreateTime: 2023/7/29 02:04
 * @Description:
 */
@SpringBootTest
public class HBaseTest {
    @Autowired
    private HBaseService hbaseService;

    //测试创建表
    @Test
    public void testCreateTable() {
        hbaseService.creatTable("test_base", Arrays.asList("a", "back"));
    }

    /**
     * 查询hbase中的所有表
     */
    @Test
    public void test_getAllTable() {
        List<String> allTableNames = hbaseService.getAllTableNames();
        System.out.println(allTableNames);
    }

    //测试加入数据
    @Test
    public void testPutData() {
        hbaseService.putData("test_base", "000001", "a", new String[]{"project_id",
                "varName", "coefs", "pvalues", "tvalues", "create_time"}, new String[]{"40866", "mob_3", "0.9416",
                "0.0000", "12.2293", "null"});
        hbaseService.putData("test_base", "000002", "a", new String[]{"project_id",
                "varName", "coefs", "pvalues", "tvalues", "create_time"}, new String[]{"40866", "idno_prov", "0.9317",
                "0.0000", "9.8679", "null"});
        hbaseService.putData("test_base", "000003", "a", new String[]{"project_id",
                "varName", "coefs", "pvalues", "tvalues", "create_time"}, new String[]{"40866", "education", "0.8984",
                "0.0000", "25.5649", "null"});
    }

    /**
     * 测试安装rowKey查询数据
     */
    @Test
    public void test_getData() {
        Map<String, Map<String, String>> result = hbaseService.getResult("test_table", "row1");
        System.out.println(result);
    }

    //测试遍历全表
    @Test
    public void testGetResultScanner() {
        Map<String, Map<String, String>> result2 = hbaseService.getResultScanner("test_base");
        System.out.println("-----遍历查询全表内容-----");
        result2.forEach((k, value) -> {
            System.out.println(k + "--->" + value);
        });
    }
}
