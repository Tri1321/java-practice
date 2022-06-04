package vn.fis.training.service;

import vn.fis.training.domain.Customer;
import vn.fis.training.domain.CustomerStatus;
import vn.fis.training.exception.CustomerNotFoundException;
import vn.fis.training.exception.DuplicateCustomerException;
import vn.fis.training.exception.InvalidCustomerException;
import vn.fis.training.exception.InvalidCustomerStatusException;
import vn.fis.training.store.InMemoryCustomerStore;

import java.util.*;
import java.util.stream.Collectors;

import static vn.fis.training.utility.Validation.*;
import static vn.fis.training.utility.Validation.validateStatus;

public class SimpleCustomerService implements CustomerService {

    private final InMemoryCustomerStore customerStore;

    public SimpleCustomerService() { this.customerStore = new InMemoryCustomerStore(); }

    @Override
    public Customer findById(String id) {
        if(customerStore.getMapCustomer().containsKey(id))
            return customerStore.getMapCustomer().get(id);
        else throw new CustomerNotFoundException("Customer not found");
    }

    @Override
    public Customer createCustomer(Customer customer) {
        validateCustomer(customer);
        return customerStore.insertOrUpdate(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        findById(customer.getId());
        validateCustomer(customer);
        return customerStore.insertOrUpdate(customer);
    }

    @Override
    public void deleteCustomerById(String id) {
        Customer customer = findById(id);
        if(customer.getStatus().equals(CustomerStatus.INACTIVE) && customer.getStatus() != null) {
            customerStore.deleteById(id);
        } else throw new InvalidCustomerStatusException(customer,
                String.format("Invalid customer status: %s", customer.getStatus()));
    }

    @Override
    public List<Customer> findAllOrderByNameAsc() {
        return customerStore.findAll().stream()
                .sorted(Comparator.comparing(Customer::getName)).collect(Collectors.toList());
    }

    @Override
    public List<Customer> findAllOrderByNameLimit(int limit) {
        return findAllOrderByNameAsc().stream().limit(limit).collect(Collectors.toList());
    }

    @Override
    public List<Customer> findAllCustomerByNameLikeOrderByNameAsc(String custName, int limit) {
        return customerStore.findAll().stream().sorted(Comparator.comparing(Customer::getName))
                .filter(v -> v.getName().toLowerCase().contains(custName.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public List<SummaryCustomerByAgeDTO> summaryCustomerByAgeOrderByAgeDesc() {
        List<SummaryCustomerByAgeDTO> customers = new ArrayList<>();
        customerStore.findAll().stream().sorted(Comparator.comparing(Customer::getAge))
                .collect(Collectors.groupingBy(Customer::getAge, Collectors.counting()))
                .forEach((k, v) -> customers.add(new SummaryCustomerByAgeDTO(k.intValue(), v.intValue())));
        return customers;
    }

    public void validateCustomer(Customer customer) {
        if(!validateName(customer.getName())) {
            throw new InvalidCustomerException(customer, String.format("Invalid name: %s", customer.getName()));
        } else if(!validateDob(customer.getBirthDay())) {
            throw new InvalidCustomerException(customer, "Customer is too young");
        } else if(!validateMobile(customer.getMobile())) {
            throw new InvalidCustomerException(customer, String.format("Invalid mobile: %s", customer.getMobile()));
        } else if(!validateStatus(customer.getStatus())) {
            throw new InvalidCustomerException(customer, String.format("Invalid status: %s", customer.getStatus()));
        }
        for(Customer c : customerStore.findAll()) {
            if(c.getMobile().equals(customer.getMobile()))
                throw new DuplicateCustomerException(customer,
                        String.format("Duplicate phone number: %s", customer.getMobile()));
        }
    }
}