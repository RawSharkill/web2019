import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MyGenericServlet extends GenericServlet {

    //MyGenericServlet
    @Override
    public void service(ServletRequest servletRequest, ServletResponse response) throws ServletException, IOException {
        response.setContentType( "text/html" ) ; // 设置响应内容类型

        PrintWriter out = response.getWriter();// 获得文本写入流

        // 给客户端回应的html文本

        out.println( "<html>" ) ;

        out.println( "<body>" ) ;

        out.println( "<h1>Hello Servlet </h1>" );

        out.println( "</body>" ) ;

        out.println( "</html>" ) ;

        out.flush();// 刷新写入

    }
}
