package com.jason.mail.hutool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.hutool.extra.mail.MailAccount;
import cn.hutool.extra.mail.MailUtil;

@RestController
public class HutoolEmail {
	
	@Autowired
	private MailAccount mailAccount;

	/**
	 * MailUtil.send参数：
	 *  tos: 对方的邮箱地址，可以是单个，也可以是多个（Collection表示）
		subject：标题
		content：邮件正文，可以是文本，也可以是HTML内容
		isHtml： 是否为HTML，如果是，那参数3识别为HTML内容
		files： 可选：附件，可以为多个或没有，将File对象加在最后一个可变参数中即可
	 * @return
	 */
	@RequestMapping("/hutoolemail")
	public String hutoolemail(String toEmail, String subject, String content) {
		try {
			MailUtil.send(mailAccount, toEmail, subject, content, false);
			return "Success";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "Fail";
		}
	}
}
