package com.jason.generator;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

/**
 * Mybatis generator主类
 * 
 * @author qianhao
 *
 */
public class Generator {

	public static void main(String[] args) throws Exception {
		// MBG 执行过程中的警告信息
		List<String> warnings = new ArrayList<String>();
		// 当生成的代码重复时，覆盖原代码
		boolean overwrite = true;
		// 读取我们的 MBG 配置文件
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = cp.parseConfiguration(Generator.class.getResourceAsStream("/generatorConfig.xml"));
		
		DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
		myBatisGenerator.generate(null);

		//输出警告信息
        for (String warning : warnings) {
            System.out.println(warning);
        }
	}
}