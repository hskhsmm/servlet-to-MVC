package hello.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 전체 파라미터 조회
        System.out.println("[전체 파라미터 조회] - start");

        // 기존 코드: Enumeration 사용
        /*
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String paramName = parameterNames.nextElement();
            System.out.println(paramName + "=" + request.getParameter(paramName));
        }
        */

        // 변경된 코드: `asIterator()`를 사용하여 파라미터 출력
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> System.out.println(paramName + "=" + request.getParameter(paramName)));

        System.out.println("[전체 파라미터 조회] - end");
        System.out.println();

        // 단일 파라미터 조회
        System.out.println("[단일 파라미터 조회]");
        String username = request.getParameter("username");
        System.out.println("request.getParameter(username) = " + username);
        String age = request.getParameter("age");
        System.out.println("request.getParameter(age) = " + age);
        System.out.println();

        // 이름이 같은 복수 파라미터 조회
        System.out.println("[이름이 같은 복수 파라미터 조회]");
        String[] usernames = request.getParameterValues("username");
        if (usernames != null) {
            System.out.println("request.getParameterValues(username): ");
            for (String name : usernames) {
                System.out.println("username=" + name);
            }
        } else {
            System.out.println("username 파라미터가 없습니다.");
        }

        // 응답 작성
        response.getWriter().write("ok");
    }
}
