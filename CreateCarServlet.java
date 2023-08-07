package servlet;

import com.sun.net.httpserver.HttpsServer;
import dao.CarDao;
import model.Car;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/create-car")
public class CreateCarServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String carName = req.getParameter("car-name");
        System.out.println(carName);
        Car car = new Car(carName);
        try {
            new CarDao().createCar(car);
        } catch (Exception e){

            System.out.println(e.getMessage());
        }



        req.getRequestDispatcher("index.html").forward(req,resp);
    }
}
