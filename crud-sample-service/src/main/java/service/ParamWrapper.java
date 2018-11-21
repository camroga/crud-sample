package service;

import java.io.Serializable;

public class ParamWrapper implements Serializable {

    private String customer;

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }
}
