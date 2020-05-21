package com.lbh.chat.websocket;

import com.alibaba.fastjson.JSON;
import com.lbh.chat.pojo.Message;
import com.lbh.chat.utils.MessageUtil;

import javax.servlet.http.HttpSession;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.*;

/**
 * @Author hong
 * @Date 19-10-17
 */
@ServerEndpoint(value = "/websocket",configurator = GetSessionConfiguration.class)
public class ChatSocket{

    private Session session;

    private HttpSession httpSession;

    /**
     * 记录当前系统在线socket实例
     */
    private static Map<HttpSession,ChatSocket> onLineMap = new HashMap<>();

    /**
     * 当前系统在线总人数
     */
    private static Integer onLineNumber = 0;

    @OnOpen
    public void onOpen(Session session, EndpointConfig config){

        // 保存参数
        this.session = session;
        this.httpSession = (HttpSession)config.getUserProperties().get(HttpSession.class.getName());
        onLineMap.put(httpSession,this);

        System.out.println("用户:" + httpSession.getAttribute("username") + " 连接聊天室,当前聊天室人数为:" + getLineNumber());

        incrLineNumber();

        // 群发消息通知有新用户上线
        List<String> names = getUserNames();
        String context = MessageUtil.getContent(MessageUtil.TYPE_USER,
                "",""
                , String.join(",", names));  // 发送内容


        multiPushMessage(context);
    }


    @OnMessage
    public void OnMessage(String content){
        System.out.println("接收到消息:" + content);

        Message message = JSON.parseObject(content, Message.class);

        String toName = message.getToName();

        // 构建消息对象
        String messageContent = MessageUtil.getContent(MessageUtil.TYPE_MESSAGE, message.getFromName(), message.getToName(), message.getContent());

        // 群发消息
        if("all".equals(toName)){
            multiPushMessage(messageContent);
            return;
        }

        // 单一发送消息
        singlePushMessage(messageContent,message.getFromName(),message.getToName());

    }

    /**
     * 单一发送消息
     * @param context
     * @param fromName
     * @param toName
     */
    private void singlePushMessage(String context,String fromName,String toName){

        // 查看用户是否在线
        boolean isOnLine = checkUserIsOnLine(toName);

        if(!isOnLine){
            System.out.println("当前用户:" + toName + " 不在线");
            return;
        }

        Set<Map.Entry<HttpSession, ChatSocket>> entries = onLineMap.entrySet();

        for (Map.Entry<HttpSession, ChatSocket> entry : entries) {
            HttpSession session = entry.getKey();
            String username = (String)session.getAttribute("username");

            // 如果发送的消息和当前用户有关
            if(fromName.equals(username) || toName.equals(username)){
                ChatSocket chatSocket = entry.getValue();
                try {
                    // 发送消息
                    chatSocket.session.getBasicRemote().sendText(context);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }


    }

    /**
     * 查看用户是否在线
     * @param name
     * @return
     */
    private boolean checkUserIsOnLine(String name) {

        Set<HttpSession> httpSessions = onLineMap.keySet();

        for (HttpSession session : httpSessions) {
            String username = (String)session.getAttribute("username");

            if(name.equals(username)){
                return true;
            }

        }

        return false;

    }

    /**
     * 发生错误
     * @param session
     * @param thr
     */
    @OnError
    public void onError(Session session, Throwable thr){

        // 关闭连接
        close(session);

        // 打印异常信息
        thr.printStackTrace();

    }

    /**
     * 关闭连接时触发
     * @param session
     * @param closeReason
     */
    @OnClose
    public void onClose(Session session){

        close(session);

        // 关闭连接
        try {
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    /**
     * 关闭连接
     * @param session
     */
    private void close(Session session) {
        Set<HttpSession> httpSessions = onLineMap.keySet();

        Iterator<HttpSession> iterator = httpSessions.iterator();

        // 从容器中删除对应的socket实例
        while (iterator.hasNext()){
            HttpSession httpSession = iterator.next();
            ChatSocket chatSocket = onLineMap.get(httpSession);

            // 寻找对应的socket
            if(session.getId().equals(chatSocket.session.getId())){
                iterator.remove();
                System.out.println("用户:" + httpSession.getAttribute("username") + " 下线");
                break;
            }
        }
    }


    /**
     * 获取用户名称列表
     * @return
     */
    private List<String> getUserNames() {
        List<String> names = new ArrayList<>();
        Set<HttpSession> httpSessions = onLineMap.keySet();

        for (HttpSession session : httpSessions) {
            String username = (String) session.getAttribute("username");
            names.add(username);
        }

        return names;
    }

    /**
     * 群发消息
     * @param context
     */
    private void multiPushMessage(String context) {

        Set<Map.Entry<HttpSession, ChatSocket>> entries = onLineMap.entrySet();

        for (Map.Entry<HttpSession, ChatSocket> entry : entries) {
            try {
                entry.getValue().session.getBasicRemote().sendText(context);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    /**
     * 获取当前在线人数
     * @return
     */
    public Integer getLineNumber(){
        return onLineNumber;
    }

    /**
     * 增加在线人数
     */
    private synchronized void incrLineNumber(){
        ++onLineNumber;
    }

    /**
     * 减少在线人数
     */
    private synchronized void decrLineNumber(){
        --onLineNumber;
    }

}
