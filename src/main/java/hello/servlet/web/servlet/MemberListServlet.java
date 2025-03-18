package hello.servlet.web.servlet;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "memberListServlet", urlPatterns = "/servlet/members")
public class MemberListServlet extends HttpServlet {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        List<Member> members = memberRepository.findAll();

        PrintWriter writer = response.getWriter();

        writer.write("<html>");
        writer.write("<head>");
        writer.write("<meta charset=\"UTF-8\">");
        writer.write("<title>Member List</title>");
        writer.write("</head>");
        writer.write("<body>");
        writer.write("<a href=\"/index.html\">메인</a>");
        writer.write("<table border=\"1\">");
        writer.write("<thead>");
        writer.write("<tr><th>ID</th><th>Username</th><th>Age</th></tr>");
        writer.write("</thead>");
        writer.write("<tbody>");

        for (Member member : members) {
            writer.write("<tr>");
            writer.write("<td>" + member.getId() + "</td>");
            writer.write("<td>" + member.getUsername() + "</td>");
            writer.write("<td>" + member.getAge() + "</td>");
            writer.write("</tr>");
        }

        writer.write("</tbody>");
        writer.write("</table>");
        writer.write("</body>");
        writer.write("</html>");
    }
}
