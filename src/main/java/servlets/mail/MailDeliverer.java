package servlets.mail;

public class MailDeliverer {

    private IExternalMailSystem externalMailSystem;

    public void deliver(String address, String body) {
        Email email = new Email();
        email.setBody(body);
        applyUserAndDomainUsingProvidedAddress(address, email);
        externalMailSystem.send(email);
    }

    private void applyUserAndDomainUsingProvidedAddress(String address, Email email) {
        String[] addressComponents = address.split("@");
        email.setUser(addressComponents[0]);
        email.setDomain(addressComponents[1]);
    }

}
