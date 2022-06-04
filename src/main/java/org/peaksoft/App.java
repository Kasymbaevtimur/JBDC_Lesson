package org.peaksoft;


import org.peaksoft.utill.Db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class App {


    public static void main(String[] args) {
//
//        addCity(1, "Osh", "182 km2", 283300);
//        addCity(2,"Bishkek","160 km2",1088900);
//        addCity(3,"Moscow","2561,5 km2",12635446);
//        addCity(4,"New York","1214,9 km2",8405837);
//        addCity(5,"Dubai","3885 km2",3331420);
//
//        addCountry(1, "Kyrgyzstan", "199951 km2", 6523529);
//        addCountry(2, "Russia", "17125191 km2", 145557191);
//        addCountry(3, "China", "9598962 km2", 1411778724);
//        addCountry(4, "Canada", "99846670 km2", 38526760);
//        addCountry(5, "Germany", "357578 km2", 83155031);
        //System.out.println(getCity());

        System.out.println(getCityByiId(1));
        System.out.println(getCountry());
    }


    public static void createTable() {
        try (Connection connection = Db.connection();
             Statement statement = connection.createStatement()) {
            String SQL = " CREATE TABLE IF NOT EXISTS city  " +
                    "(id INTEGER PRIMARY KEY NOT NULL," +
                    " name VARCHAR (55) NOT NULL," +
                    " square VARCHAR (55) NOT NULL," +
                    " population INTEGER NOT NULL)";
            statement.executeUpdate(SQL);
            System.out.println("Table is succesfully created");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addCity(int id, String name, String square, int population) {
        try {
            String SQL = " Insert into city(id,name,square,population) values(?,?,?,?)";
            Connection connection = Db.connection();
            PreparedStatement prep = connection.prepareStatement(SQL);
            prep.setInt(1, id);
            prep.setString(2, name);
            prep.setString(3, square);
            prep.setInt(4, population);
            prep.executeUpdate();
            System.out.println(" Succesfully added  " + name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addCountry(int id, String name, String square, int population) {
        try {
            String SQL = " Insert into country(id,name,square,population) values(?,?,?,?)";
            Connection connection = Db.connection();
            PreparedStatement prep = connection.prepareStatement(SQL);
            prep.setInt(1, id);
            prep.setString(2, name);
            prep.setString(3, square);
            prep.setInt(4, population);
            prep.executeUpdate();
            System.out.println(" Succesfully added  " + name);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public static void addMayorCity() {
        try (Connection connection = Db.connection();
             Statement statement = connection.createStatement()) {
            String SQL = "INSERT INTO mayor_city" +
                    " VAlUES (1,'Almaz','Mambetov','male',46)," +
                    "(2,'Emilbek','Abdykadyrov','male',64)," +
                    "(3,'Sergey','Sobyanin','male',55)," +
                    "(4,'Erik','Adams','male',61)," +
                    "(5,'Moxammed','Rashid','male',72)";
            statement.executeUpdate(SQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<City> getCity() {
        String sql = "SELECT * FROM city ;";
        List<City> cities = new ArrayList<>();
        try (Connection connection = Db.connection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                City city = new City();
                city.setId(resultSet.getInt("id"));
                city.setName(resultSet.getString("name"));
                city.setSquare(resultSet.getString("square"));
                city.setPopulation(resultSet.getInt("population"));
                cities.add(city);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cities;
    }

    public static List<Country> getCountry() {
        String sql = "SELECT * FROM country ;";
        List<Country> countries = new ArrayList<>();
        try (Connection connection = Db.connection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Country country = new Country();
                country.setId(resultSet.getInt("id"));
                country.setName(resultSet.getString("name"));
                country.setSquare(resultSet.getString("square"));
                country.setPopulation(resultSet.getInt("population"));
                countries.add(country);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return countries;
    }

    public static City getCityByiId(int id) {
        City city = new City();
        String sql = " SELECT * FROM city WHERE id = ? ;";
        try (Connection connection = Db.connection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                city.setId(resultSet.getInt("id"));
                city.setName(resultSet.getString("name"));
                city.setSquare(resultSet.getString("square"));
                city.setPopulation(resultSet.getInt("population"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return city;
    }

}