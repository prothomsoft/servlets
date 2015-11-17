package servlets.mail;

public interface IExternalMailSystem {
    
    public void send(String domain, String user, String body);
    
    public void send(Email email);

}
