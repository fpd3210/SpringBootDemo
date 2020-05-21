package com.lbh.chat.websocket;

import javax.servlet.http.HttpSession;
import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;

/**
 * @Author hong
 * @Date 19-10-17
 */
public class GetSessionConfiguration extends ServerEndpointConfig.Configurator {

    @Override
    public void modifyHandshake(ServerEndpointConfig sec, HandshakeRequest request, HandshakeResponse response) {

        // 获取HttpSession
        HttpSession httpSession = (HttpSession) request.getHttpSession();

        // 保存HttpSession
        sec.getUserProperties().put(HttpSession.class.getName(),httpSession);
    }
}
