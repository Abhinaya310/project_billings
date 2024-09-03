package com.billing.payment_processing.dto;

public class NotificationRequest {
    private Long invoiceId;
    private String customerEmail;

    // Constructor
    public NotificationRequest(Long invoiceId, String customerEmail) {
        this.invoiceId = invoiceId;
        this.customerEmail = customerEmail;
    }

    @Override
    public String toString() {
        return "NotificationRequest [invoiceId=" + invoiceId + ", customerEmail=" + customerEmail + "]";
    }

    public NotificationRequest() {
    }

    // Getters and Setters
    public Long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Long invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }
}
