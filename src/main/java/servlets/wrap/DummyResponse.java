package servlets.wrap;

import java.io.CharArrayWriter;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class DummyResponse extends HttpServletResponseWrapper {

    private CharArrayWriter buffer; // This can be used as an Writer

    public DummyResponse(HttpServletResponse response) {
        super(response);
        buffer = new CharArrayWriter();
    }

    @Override
    public String toString() {
        return buffer.toString();
    }

    @Override
    public PrintWriter getWriter() {
        return new PrintWriter(buffer);
    }
}
