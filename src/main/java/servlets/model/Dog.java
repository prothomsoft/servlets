package servlets.model;

import java.io.Serializable;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;

public class Dog implements HttpSessionBindingListener, HttpSessionActivationListener, Serializable{
    String breed;
    public Dog(String breed) {
        this.breed = breed;
    }
    public String getBreed() {
        return breed;
    }
    public void valueBound(HttpSessionBindingEvent arg0) {

    }
    public void valueUnbound(HttpSessionBindingEvent arg0) {

    }
    public void sessionDidActivate(HttpSessionEvent arg0) {

    }
    public void sessionWillPassivate(HttpSessionEvent arg0) {

    }
}
