package hello.container;

import hello.servlet.HelloServlet;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletRegistration;

//프로그래밍 방식 서블릿 등록
/*
* 서블릿을 등록하는 방식은 2가지로 @WebServlet 과 아래와 같은 방식으로 인터페이스를 만들어 등록하는 방법이 있다.
* @WebServlet의 경우 빠르게 만들수 있지만 uri 변경시 직접 일일이 하드 코딩해야하는 단점이 있다.
* 반면 아래와 같은 방식은 if문과 같이 분기 로직을 태울 수 있으므로 유연성이 좋다.
* */
public class AppInitV1Servlet implements AppInit {
    @Override
    public void onStartup(ServletContext servletContext) {
        //순수 서블릿 코드 등록
        ServletRegistration.Dynamic helloServlet = servletContext.addServlet("helloServlet", new HelloServlet());
        helloServlet.addMapping("/ hello-servlet");
    }
}
