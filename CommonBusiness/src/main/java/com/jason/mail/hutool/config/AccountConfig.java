package com.jason.mail.hutool.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cn.hutool.extra.mail.MailAccount;

@Configuration
public class AccountConfig {

	@Bean
	public MailAccount mailAccount() {
		MailAccount account = new MailAccount();
		account.setHost("smtp.163.com");
//		account.setPort(25);
		account.setAuth(true);
		account.setFrom("xiaoqianittest@163.com");
//		account.setUser("xiaoqianittest");
		account.setPass("DGTQZCESAMGOWPVT");
		return account;
	}
}
