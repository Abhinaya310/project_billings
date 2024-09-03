package com.billing.payment_processing.dto;

public class CustomerDTO {
    private Long customerId;
    private String email;
    public CustomerDTO(Long customerId, String email) {
        this.customerId = customerId;
        this.email = email;
    }
    public CustomerDTO() {
    }
    
    @Override
    public String toString() {
        return "CustomerDTO [customerId=" + customerId + ", email=" + email + "]";
    }
    public Long getCustomerId() {
        return customerId;
    }
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
    

}
