package com.jason.config;

import com.jason.service.HBaseService;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: 小小千千
 * @CreateTime: 2023/7/29 01:18
 * @Description:
 */
@Configuration
public class HBaseConfig {

    @Bean
    public HBaseService getHBaseService(){
        org.apache.hadoop.conf.Configuration conf = HBaseConfiguration.create();
        conf.set("hbase.cluster.distributed", "false");
        conf.set("hbase.rootdir", "/Users/qianhao/Applications/HBase/data");
        return new HBaseService(conf);
    }
}
