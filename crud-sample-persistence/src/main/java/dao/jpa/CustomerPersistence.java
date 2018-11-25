package dao.jpa;

import dao.CustomerDao;
import entity.Customer;
import exception.DaoException;
import jdbc.PostgresJdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerPersistence implements CustomerDao {

    @Override
    public List<Customer> getCustomers() {
        List<Customer> customers = new ArrayList<>();
        String SQL = "SELECT * FROM crud.customer";

        try (Connection conn = PostgresJdbc.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {
            while(rs.next()) {
                Customer customer = new Customer();
                customer.setId(rs.getString("id"));
                customer.setFirstName(rs.getString("firstName"));
                customer.setSurname(rs.getString("surName"));
                customers.add(customer);
            }
        } catch (SQLException ex) {
            throw new DaoException(ex);
        }

        return customers;
    }
}
