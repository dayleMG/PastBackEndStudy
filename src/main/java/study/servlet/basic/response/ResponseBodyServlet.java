package study.servlet.basic.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.Provider;

@WebServlet(name = "responseBodyServlet", urlPatterns = "/response-header")
public class ResponseBodyServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setStatus(HttpServletResponse.SC_OK);

        //[response-header]
        resp.setContentType("text/plain");
        resp.setCharacterEncoding("utf-8");
        //캐쉬 무효화
        resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        //과거 버전까지 캐쉬 무효화
        resp.setHeader("Pragma", "no-cache");
        //커스텀 헤더
        resp.setHeader("my-header", "servletStudy");

        // 쿠키
        Cookie cookie = new Cookie("myCookie", "good");
        cookie.setMaxAge(600); //600초
        resp.addCookie(cookie);

        // 단순 텍스트 응답
        PrintWriter writer = resp.getWriter();
        writer.println("study");

        //redirect 기능
        //redirect(resp);

    }

    private void redirect(HttpServletResponse response) throws IOException {

        response.sendRedirect("/basic/hello-form.html");
    }
}
