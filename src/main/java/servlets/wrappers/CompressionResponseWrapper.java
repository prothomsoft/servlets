package servlets.wrappers;

import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class CompressionResponseWrapper extends HttpServletResponseWrapper {

    public CompressionResponseWrapper(HttpServletResponse response) {
        super(response);
    }

    @Override
    public ServletOutputStream getOutputStream() throws IOException {
        // TODO Auto-generated method stub
        return super.getOutputStream();
    }

    @Override
    public void setContentLength(int len) {
        // TODO Auto-generated method stub
        super.setContentLength(len);
    }
}