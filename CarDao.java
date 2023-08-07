package dao;

import model.Car;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CarDao {
    public void createCar(Car car) throws SQLException {
        String SQL ="INSERT INTO  CAR (NAME) VALUES (?) ";
        try{
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("OK");
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1,car.getNome());
            preparedStatement.execute();
            System.out.println("Inserido");
            connection.close();
        }catch (Exception e ){
            System.out.println(e.getMessage());
        }

    }
}
