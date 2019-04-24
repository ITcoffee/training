package com.zhouyun.training.mybatis;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

/** 
 * 
 *
 * @author  周云
 * @version 2017年10月20日 上午11:59:53
 */
public class Generator {

	 public static void main(String[] args) {
		 try {
			 System.out.println("Generator Starting...");
			 List<String> warnings = new ArrayList<String>();
			 boolean overwrite = true;
			 File configFile = new File(Generator.class.getResource("/resources/mybatis/generator.xml").getFile());
			 ConfigurationParser cp = new ConfigurationParser(warnings);
			 Configuration config = cp.parseConfiguration(configFile);
			 DefaultShellCallback callback = new DefaultShellCallback(overwrite);
			 MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
			 myBatisGenerator.generate(null);
			 System.out.println("Generator End!");
		 } catch (IOException e) {
			 e.printStackTrace();
		 } catch (XMLParserException e) {
			 e.printStackTrace();
		 } catch (InvalidConfigurationException e) {
			 e.printStackTrace();
		 } catch (SQLException e) {
			 e.printStackTrace();
		 } catch (InterruptedException e) {
			 e.printStackTrace();
		 }
	}
}
