package com.multi.mvc13;

import java.util.Date;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {

	@MessageMapping("/chat2")
	@SendTo("/topic/messages2")
	public OutputMessage2 send2(Message message) {
		String menu = "";
		switch (message.getText()) {
		case "1":
			menu = "챗 봇>>  10) 번호 입력		11) 이메일 입력";
			break;
		case "2":
			menu = "챗 봇>>  20) 아이디 입력";
			break;
		case "yang":
			menu = "챗 봇>> 인증번호를 입력해주세요";
			break;
		case "1234":
			menu = "챗 봇>>  아이디는 ABC1234입니다";
			break;
		case "10":
			menu = "챗 봇>>  전화번호를 입력해주세요";
			break;
		case "01012345678":
			menu = "챗 봇>>  비밀번호는 1234입니다";
			break;
		case "11":
			menu = "챗 봇>>  이메일을 입력해주세요";
			break;
		case "abc1234@naver.com":
			menu = "챗 봇>>  비밀번호는 1234입니다";
			break;
		default:
			menu = "챗 봇>>선택한 번호는 없는 메뉴입니다. 다시 입력해주세요.";
			break;
		}
		OutputMessage2 outputMessage2 = new OutputMessage2(menu);
		return outputMessage2;
	}
	
	//ws프로토콜로 요청을 받음.
	@MessageMapping("/chat") // 채팅 내용 받을 때 사용하는 주소
	@SendTo("/topic/messages") // 가입한 주소 브라우저에 return message를 json으로 변환해서 보내줌
	public OutputMessage send(Message message) {
		System.out.println("서버에서 받은 데이터>> " + message); //서버에서 받은 클라이언트의 채팅 내용을 확인 
		Date date = new Date(); //java.util.Date;
		int hour = date.getHours();//시 
		int min = date.getMinutes();//분 
		String time = hour + ":" + min;
		//채팅방에 들어와있는 모든 클라이언트에게 보낼 데이터 
		OutputMessage output = new OutputMessage(message.getFrom(), message.getText(), time);
		return output; //return데이터는 json으로 만들어서 클라이언트 브라우저에 보냄.
		//jackson-databind
	}
}
