package study.spring.springmvc.cofig;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@WebListener
public class SessionConfig implements HttpSessionListener {
    private static final Map<String, HttpSession> sessions = new ConcurrentHashMap<>();

    public synchronized static String getSessionIdCheck(String type, String compareId){
        String result = "";
        for( String key : sessions.keySet() ){
            HttpSession hs = sessions.get(key);
            if(hs != null &&  hs.getAttribute(type) != null && hs.getAttribute(type).toString().equals(compareId) ){
                result =  key;
            }
        }
        if(!result.equals("")) {
            removeSessionForDoubleLogin(result);
        }
        return result;
    }
    private static void removeSessionForDoubleLogin(String result){
        System.out.println("remove userId : " + result);
        sessions.get(result).invalidate();
        sessions.remove(result);
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        sessions.put(se.getSession().getId(), se.getSession());

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        if(sessions.get(se.getSession().getId()) != null){
            sessions.get(se.getSession().getId()).invalidate();
            sessions.remove(se.getSession().getId());
        }
    }
}
