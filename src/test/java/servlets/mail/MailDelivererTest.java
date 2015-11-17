package servlets.mail;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class MailDelivererTest {

    @InjectMocks private MailDeliverer mailDeliverer = new MailDeliverer();

    @Mock private IExternalMailSystem externalMailSystem;

    @Before
    public void injectDoubles() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void sendsEmailByConstructingEmailObject() {
        String expectedUser = "tim";
        String expectedDomain = "wingfield.com";
        String expectedBody = "Hi Tim!";

        mailDeliverer.deliver(expectedUser+"@"+expectedDomain,expectedBody);

        ArgumentCaptor<Email> emailCaptor = ArgumentCaptor.forClass(Email.class);
        verify(externalMailSystem).send(emailCaptor.capture());
        Email email = emailCaptor.getValue();
        assertEquals(expectedUser, email.getUser());
        assertEquals(expectedDomain, email.getDomain());
        assertEquals(expectedBody, email.getBody());
    }
}