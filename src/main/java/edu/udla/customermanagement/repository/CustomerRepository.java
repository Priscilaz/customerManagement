package edu.udla.customermanagement.repository;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepository {

  private final List<String> customersList = new ArrayList<>();

  public void addCustomer(String name) {
    customersList.add(name);
  }

  public boolean exists(String name) {
    return customersList.contains(name);
  }

  public List<String> getAll() {
    return new ArrayList<>(customersList);
  }
}
