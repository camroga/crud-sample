package service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import dao.CustomerDao;
import dao.LocationDao;
import dto.CustomerDto;
import entity.Location;
import exception.DaoException;
import exception.DataNotFoundException;
import exception.ServiceException;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class CustomerService implements Customer {
  
    @Inject
    CustomerDao customerDao;
  
    @Inject
    LocationDao locationDao;
  
    public String getData() {
        String data;
        Gson gson = new Gson();
        try {
            data = gson.toJson(find(), new TypeToken<List<CustomerDto>>() {
            }.getType());
        } catch (DataNotFoundException ex) {
            throw new DataNotFoundException(ex);
        } catch (Exception ex) {
            throw new ServiceException(ex);
        }
        return data;
    }
  
    public List<CustomerDto> find() {
        List<CustomerDto> customersDto = new ArrayList<>();
      
        try {
            List<entity.Customer> customers = customerDao.getCustomers();
            customers.stream().forEach(customer -> {
                Location location = locationDao.getLocation(customer.getId());
                CustomerDto customerDto = new CustomerDto();
                customerDto.setFirstName(customer.getFirstName());
                customerDto.setSurname(customer.getSurname());
                customerDto.setDob(location.getCity() + "  " + location.getPostCode());
                customerDto.setStreetAddress(location.getStreetAddress());
                customersDto.add(customerDto);
            });
        } catch (DaoException ex) {
            if (ex.getCause() instanceof NoResultException) {
                throw new DataNotFoundException(ex.getMessage());
            }

            throw new ServiceException(ex);
        } catch (Exception ex) {
            throw new ServiceException(ex);
        }
        return customersDto;
    }
}
