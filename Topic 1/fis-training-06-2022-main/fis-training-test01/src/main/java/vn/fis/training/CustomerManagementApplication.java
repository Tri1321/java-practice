package vn.fis.training;

import vn.fis.training.domain.Customer;
import vn.fis.training.domain.CustomerStatus;
import vn.fis.training.service.SimpleCustomerService;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class CustomerManagementApplication {
    public static void main(String[] args) {
        SimpleCustomerService customerService = new SimpleCustomerService();
        Customer c1 = new Customer("  hOang    DinH tRi  ", LocalDate.of(2002,7,31),
                "0123456789", CustomerStatus.ACTIVE, LocalDateTime.now());
        Customer c2 = new Customer(" phAm   vAn  B  ", LocalDate.of(2001,8,24),
                "0333333333", CustomerStatus.ACTIVE, LocalDateTime.now());
        Customer c3 = new Customer("  NgUyEn   vAn  a  ", LocalDate.of(2000,6,24),
                "0444444444", CustomerStatus.ACTIVE, LocalDateTime.now());

        Customer createdC1 = customerService.createCustomer(c1);
        Customer createdC2 = customerService.createCustomer(c2);
        Customer createdC3 = customerService.createCustomer(c3);

        System.out.println(createdC1);
        System.out.println(createdC2);
        System.out.println(createdC3);
    }
}