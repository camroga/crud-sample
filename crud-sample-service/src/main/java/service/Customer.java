package service;

import dto.CustomerDto;

import java.util.List;

public interface Customer {

    String getData();

    List<CustomerDto> find();
}
