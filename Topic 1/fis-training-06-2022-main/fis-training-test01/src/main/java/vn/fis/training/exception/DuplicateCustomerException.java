package vn.fis.training.exception;

import vn.fis.training.domain.Customer;
import vn.fis.training.service.AppConstant;

public class DuplicateCustomerException extends ApplicationException{
    private Customer customer;
    public DuplicateCustomerException(Customer customer, String message) {
        super(message);
        this.customer = customer;
    }
    @Override
    public String getErrorCode() {
        return AppConstant.DUPLICATE_CUSTOMER;
    }
    public Customer getCustomer() {
        return this.customer;
    }
}
