package servlets.ws.impl;

import javax.jws.WebService;

import servlets.ws.api.WebServiceInterface;

@WebService(endpointInterface = "servlets.ws.api.WebServiceInterface")
public class WebServiceImpl implements WebServiceInterface {

    public String printMessage() {
        return "Hello from Java Code Geeks Server";
    }
}