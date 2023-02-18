package com.jason;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CommonBusinessApplicationTests {

	@Test
	void contextLoads() {
		String path = this.getClass().getResource("/").getPath();
		System.out.println(path);
	}

}
