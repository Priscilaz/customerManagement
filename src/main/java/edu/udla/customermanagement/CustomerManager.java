package edu.udla.customermanagement;

import edu.udla.customermanagement.repository.CustomerRepository;
import edu.udla.customermanagement.repository.OrderRepository;
import edu.udla.customermanagement.service.ReportService;
import edu.udla.customermanagement.util.ConsolePrinter;

public class CustomerManager {

  private final CustomerRepository customerRepo;
  private final OrderRepository orderRepo;
  private final ReportService reportService;
  private final ConsolePrinter printer;

  public CustomerManager() {
    this.printer = new ConsolePrinter();
    this.customerRepo = new CustomerRepository();
    this.orderRepo = new OrderRepository();
    this.reportService = new ReportService(printer);
  }

  public void addCustomer(String name) {
    customerRepo.addCustomer(name);
    printer.print("Added customer: " + name);
  }

  public void addOrder(String order) {
    orderRepo.addOrder(order);
    printer.print("Order added: " + order);
  }

  public void processOrdersForCustomer(String customer) {
    if (!customerRepo.exists(customer)) {
      printer.print("Customer not found: " + customer);
      return;
    }

    printer.print("Processing orders for: " + customer);
    for (String order : orderRepo.getAll()) {
      printer.print("Processing order: " + order);
    }
  }

  public void generateReport() {
    reportService.printCustomerReport(customerRepo.getAll());
    reportService.printOrderReport(orderRepo.getAll());
  }

  public static void main(String[] args) {
    CustomerManager manager = new CustomerManager();

    manager.addCustomer("John Doe");
    manager.addCustomer("Jane Smith");

    manager.addOrder("Order1");
    manager.addOrder("Order2");

    manager.processOrdersForCustomer("John Doe");
    manager.generateReport();
  }
}
