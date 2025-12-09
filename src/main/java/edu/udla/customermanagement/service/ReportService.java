package edu.udla.customermanagement.service;

import edu.udla.customermanagement.util.ConsolePrinter;

import java.util.List;

public class ReportService {

  private final ConsolePrinter printer;

  public ReportService(ConsolePrinter printer) {
    this.printer = printer;
  }

  public void printCustomerReport(List<String> customersList) {
    printer.print("Customer Report:");
    if (customersList.isEmpty()) {
      printer.print("No customers registered.");
    }
    for (String customer : customersList) {
      printer.print("Customer: " + customer);
    }
  }

  public void printOrderReport(List<String> ordersList) {
    printer.print("Order Report:");
    if (ordersList.isEmpty()) {
      printer.print("No orders registered.");
    }
    for (String order : ordersList) {
      printer.print("Order: " + order);
    }
  }
}
