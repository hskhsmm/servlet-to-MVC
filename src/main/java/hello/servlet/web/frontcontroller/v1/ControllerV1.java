package hello.servlet.web.frontcontroller.v1;



import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface ControllerV1 {

    void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

    //이걸 가지고 여러가지, 폼 리스트 저장 컨트롤러로 인터페이스 다 구헌할 것.
    //매핑 정보 호출할 때 일관성 있게 다형성 이용해서 잘 호출
}
