package DbWork;

import java.sql.*;
import java.util.ArrayList;

import User.User;

public class DbWork {
    public ArrayList<User> select() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<User> users = new ArrayList<User>();
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/testBase","postgres", "lovehorse15");
             Statement statement = connection.createStatement();){

            String selectQuery = "select* from public.\"Users\"";
            ResultSet rs = statement.executeQuery(selectQuery);

            while (rs.next()) {
                String surname = rs.getString("surname");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String dateBirth = rs.getString("birth");
                users.add(new User(name, surname, dateBirth, email));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public void addUser(String[] user) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/testBase","postgres", "lovehorse15");
             Statement statement = connection.createStatement();){
            String name = user[0];
            String surname = user[1];
            String email = user[2];
            String date = user[3];
            String insertQuery = "INSERT INTO public.\"Users\" (name, surname, email, birth) VALUES(' "
            + name + "', '"+ surname + "', '" + email + "', '" + date + "')";
            System.out.println(insertQuery);
            statement.executeQuery(insertQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
