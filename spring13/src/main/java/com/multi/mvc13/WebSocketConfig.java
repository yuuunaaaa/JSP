package com.multi.mvc13;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

	//ä�ù� �̸� ����
	@Override
	public void configureMessageBroker(MessageBrokerRegistry config) {
		config.enableSimpleBroker("/topic");
		config.setApplicationDestinationPrefixes("/app");
	}
	
	//ä�� ������ ���� �ּ�(endPoint == url)
	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		//chat: �ǽð� ä�ÿ� 
		registry.addEndpoint("/chat"); //�ڹ� ���� ��� ���� 
		registry.addEndpoint("/chat").withSockJS(); //�ڹ� ��ũ��Ʈ ���� ��� 
		
		//chat2: ê���� 
		registry.addEndpoint("/chat2"); //�ڹ� ���� ��� ���� 
		registry.addEndpoint("/chat2").withSockJS(); //�ڹ� ��ũ��Ʈ ���� ��� 
	}

}
