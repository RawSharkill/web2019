import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

public class FirstServlet extends HttpServlet {

//   Servlet 相关的生命周期方法
    String message ;
//需要配置相关内容到web.xml
    @Override
    public void init(ServletConfig config) throws ServletException {
        message = "fully initialised!";
    }

    //FirstServlet
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        //设置逻辑实现
        PrintWriter out = resp.getWriter();
        out.println("<h1>" + message +"跳转到百度主页"+ "</h1>");

        resp.sendRedirect("https://www.baidu.com");
    }

    //和表单交互内容
    //jsp form
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //从表单中获取用户名和密码 如果用户名正确就会跳转到这里
        Map<String,String[]> map = req.getParameterMap();
        String queryString = map.get("username")[0];
        if(queryString.equals("123")){
            resp.setContentType("text/html");

            message="you are entering admin mode";
            //设置逻辑实现
            PrintWriter out = resp.getWriter();
            out.println("<h1>" + message + "</h1>");
        }else{
            resp.setContentType("text/html");

            message = "you are not authorized!";
            //设置逻辑实现
            PrintWriter out = resp.getWriter();
            out.println("<h1>" + message + "</h1>");
        }

        getRequestHeader(req);
        getAllReqParameter(req);
    }


    //打印所有的请求参数
    private void getAllReqParameter(HttpServletRequest req){
        Map<String,String[]> map = req.getParameterMap();
        Set<String> keys = map.keySet();
        for(String key:keys){
            System.out.println("key " + key +":" );
            String values[] = map.get(key);
            for(String value:values){
                System.out.println(value);
            }
        }
    }

//打印请求头
    private void getRequestHeader(HttpServletRequest req) {
        //获取请求参数
        System.out.println(req.getQueryString());
        System.out.println("----------------------------------------------------------");
        //获取请求头
        String header = req.getHeader("user-Agent");
        System.out.println(header);
        header = header.toLowerCase();
        //根据请求头数据判断浏览器类型
        if (header.contains("chrome")) {
            System.out.println("您的访问浏览器为谷歌浏览器");
        } else if (header.contains("msie")) {
            System.out.println("您的访问浏览器为IE浏览器");
        } else if (header.contains("firefox")) {
            System.out.println("您的访问浏览器为火狐浏览器");
        } else {
            System.out.println("您的访问浏览器为其它浏览器");
        }
        System.out.println("----------------------------------------------------------");
        //获取所有的消息头名称
        Enumeration<String> headerNames = req.getHeaderNames();
        //获取获取的消息头名称，获取对应的值，并输出
        while (headerNames.hasMoreElements()) {
            String nextElement = headerNames.nextElement();
            System.out.println(nextElement + ":" + req.getHeader(nextElement));
        }
        System.out.println("----------------------------------------------------------");
        //根据名称获取此重名的所有数据
        Enumeration<String> headers = req.getHeaders("accept");
        while (headers.hasMoreElements()) {
            String string = (String) headers.nextElement();
            System.out.println(string);
        }

    }
    @Override
    public void destroy() {
        super.destroy();
    }

}
