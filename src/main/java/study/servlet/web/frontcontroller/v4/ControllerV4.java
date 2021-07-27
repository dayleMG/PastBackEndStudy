package study.servlet.web.frontcontroller.v4;

import org.springframework.ui.Model;

import javax.servlet.http.HttpServlet;
import java.util.Map;

public interface ControllerV4 {

    String process(Map<String, String> paramMap, Map<String, Object> model);
}
