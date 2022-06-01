package fis.java.core.topic01.dao;

public class InputComponent {
    private IValidation validation;
    private String data;

    public void display() {}

    public void validate() {}

    public void setValidation(IValidation validation) { this.validation = validation; }

    public void setData(String data) { this.data = data; }
}