package kr.ed.haebeop.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.RemoteEndpoint.Basic;
import javax.websocket.server.ServerEndpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@ServerEndpoint(value = "/socket")
public class SocketController {
    private static final List<Session> sessionList = new ArrayList<Session>();

    public SocketController(){
        System.out.println("create socket");
    }
    //localhost:8084/pro04_war/socket
    @GetMapping("/socket")
    public String viewPage(Model model){
        return "/chat/socketTest";
    }

    @OnOpen  // socket 연결 시
    public void onOpen(Session session) {
        System.out.println("open session : " + session.getId());
        try{
            final Basic basic = session.getBasicRemote();
            basic.sendText(session.getId()+"님이 입장~!");
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        sendAllSessionToMessage(session, session.getId()+"님 입장~!");
        sessionList.add(session);
    }

    @OnMessage
    public void onMessage (String message, Session session) {
        /*
        try {
            //메세지 보낸 사람에게 표시됨
            final Basic basic = session.getBasicRemote();
            basic.sendText(session.getId()+"메시지 전송 성공~!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } */
        // 다른 사람에게 메세지 보내기
        sendAllSessionToMessage(session,session.getId()+" : "+message);
    }

    @OnError
    public void onError(Throwable e, Session session) {
        System.out.println(e.getMessage() + "by session : " + session.getId());
    }

    @OnClose
    public void onClose(Session session) {
        sendAllSessionToMessage(session,session.getId()+"님이 퇴장하셨습니다.");
        System.out.println("Session : "+ session.getId() + " closed");
        sessionList.remove(session);
    }

    private void sendAllSessionToMessage(Session self, String msg){ // 연결된 모든 사용자에게 메세지 전달
        try {
            for(Session s : SocketController.sessionList){
                //if(!self.getId().equals(s.getId())){
                    s.getBasicRemote().sendText(msg);
                //}
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}