package ru.vlsv.repositories;

import ru.vlsv.entity.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * GeekBrains Java, JavaEEWebApp.
 *
 * @author Anatoly Lebedev
 * @version 1.0.0 01.04.2020
 * @link https://github.com/Centnerman
 */

public class ProductRepository {
    private final Connection connection;

    public ProductRepository(Connection connection) throws SQLException {
        this.connection = connection;
        createTableIfNotExist(connection);
    }

    public void insert(Product product) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "insert into `products` (`name`, `description`, `price`) values (?,?,?);")) {
            preparedStatement.setString(1, product.getProductName());
            preparedStatement.setString(2, product.getDescription());
            preparedStatement.setBigDecimal(3, product.getPrice());
            preparedStatement.execute();
        }
    }

    public void update(Product product) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "update `products` set `name` = ?, `'description` = ?, `price` = ? where `id` = ?;")) {
            preparedStatement.setString(1, product.getProductName());
            preparedStatement.setString(2, product.getDescription());
            preparedStatement.setBigDecimal(3, product.getPrice());
            preparedStatement.setLong(4, product.getId());
            preparedStatement.execute();
        }
    }

    public void delete(Long id) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "delete from `products` where `id` = ?;")) {
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
        }
    }

    public Product findById(Long id) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "select `id`, `name`, `description`, `price` from `products` where `id`= ?;")) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Product(resultSet.getLong(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getBigDecimal(4));
            }
            return new Product(-1L, "", "", null);
        }
    }

    public List<Product> findAll() throws SQLException {
        List<Product> productList = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(
                    "select `id`, `name`, `description`, `price` from `products`");

            while (resultSet.next()) {
                productList.add(new Product(resultSet.getLong(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getBigDecimal(4)));
            }
            return productList;
        }
    }

    private void createTableIfNotExist(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement();) {
            statement.execute("create table if not exists `products` (\n" +
                    "`id` int auto_increment primary key, \n" +
                    "`name` varchar(25), \n" +
                    "`description` varchar(50), \n " +
                    "`price` decimal(19,2) \n" +
                    ");");
        }
    }

}