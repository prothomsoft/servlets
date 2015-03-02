package servlets.listeners;

import java.io.Serializable;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;

public class SessionBindingActivationListener implements HttpSessionBindingListener, HttpSessionActivationListener, Serializable {
    String breed;
    public SessionBindingActivationListener(String breed) {
        this.breed = breed;
    }
    public String getBreed() {
        return breed;
    }
    public void valueBound(HttpSessionBindingEvent event) {

    }
    public void valueUnbound(HttpSessionBindingEvent event) {

    }
    public void sessionDidActivate(HttpSessionEvent event) {

    }
    public void sessionWillPassivate(HttpSessionEvent event) {

    }
}
