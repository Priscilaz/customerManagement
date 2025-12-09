package edu.udla.customermanagement.repository;

import java.util.ArrayList;
import java.util.List;

public class OrderRepository {

  private final List<String> ordersList = new ArrayList<>();

  public void addOrder(String order) {
    ordersList.add(order);
  }

  public List<String> getAll() {
    return new ArrayList<>(ordersList);
  }
}
