package com.jason.api;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DemoController {
	
	public DemoController() {
		// TODO Auto-generated constructor stub
		System.out.println("cnnn");
	}

    @GetMapping("index")
    public ResponseEntity<String> index(){
        return ResponseEntity.ok("请求成功");
    }

    @GetMapping("page")
    public ModelAndView page(){
        return new ModelAndView("websocket");
    }

    @RequestMapping("/push/{toUserId}")
    public ResponseEntity<String> pushToWeb(String message, @PathVariable String toUserId) throws IOException {
        WebSocketServer.sendInfo(message,toUserId);
        return ResponseEntity.ok("MSG SEND SUCCESS");
    }
    
    @RequestMapping("/testBean")
    public void testBean() {
    	ConcurrentHashMap<String,WebSocketServer> concurrentHashMap = WebSocketServer.getConcurrentHashMap();
    	WebSocketServer webSocketServer1 = concurrentHashMap.get("10");
    	WebSocketServer webSocketServer2 = concurrentHashMap.get("11");
    	if(webSocketServer1 == webSocketServer2) {
    		log.info("true");
    	}else {
    		log.info("false");
    	}
    }
}