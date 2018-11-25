package dao.jpa;

import dao.CustomerDao;
import entity.Customer;
import exception.DaoException;
import jdbc.PostgresqlJDBC;

//import javax.ejb.Stateless;
import javax.persistence.Query;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//@Stateless
public class CustomerPersistence extends GenericPersistence implements CustomerDao {

    /*@Override
    public List<Customer> getCustomers() {
        List<Customer> customers;

        try {
            String sql = "select c from Customer c";
            Query query = entityManager.createQuery(sql);
            customers = (List<Customer>) query.getResultList();
        } catch (Exception ex) {
            throw new DaoException(ex.getMessage());
        }
        return customers;
    }*/

    @Override
    public List<Customer> getCustomers() {
        List<Customer> customers = new ArrayList<>();
        String SQL = "SELECT * FROM crud.customer";

        try (Connection conn = PostgresqlJDBC.getConnection();
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
