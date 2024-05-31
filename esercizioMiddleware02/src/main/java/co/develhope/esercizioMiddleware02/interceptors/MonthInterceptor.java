package co.develhope.esercizioMiddleware02.interceptors;

import co.develhope.esercizioMiddleware02.entitites.Month;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Component
public class MonthInterceptor implements HandlerInterceptor {

    private List<Month> months = Arrays.asList(
            new Month(1, "January", "Gennaio", "Januar"),
            new Month(2, "February", "Febbraio", "Februar"),
            new Month(3, "March", "Marzo", "März"),
            new Month(4, "April", "Aprile", "April"),
            new Month(5, "May", "Maggio", "Mai"),
            new Month(6, "June", "Giugno", "Juni")
    );

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        String monthNumberHeader = request.getHeader("monthNumber");

        if (monthNumberHeader == null || monthNumberHeader.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Month number header is missing");
            return false;
        }

        int monthNumber = Integer.parseInt(monthNumberHeader);

        Month foundMonth = months.stream()
                .filter(month -> month.getMonthNumber() == monthNumber)
                .findFirst()
                .orElse(new Month(-1, "nope", "nope", "nope"));

        request.setAttribute("foundMonth", foundMonth);

        return true;
    }

}
