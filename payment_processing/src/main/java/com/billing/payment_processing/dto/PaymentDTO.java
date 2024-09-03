package com.billing.payment_processing.dto;

import java.math.BigDecimal;

public class PaymentDTO {
    private String paymentId;
    private Long customerId;
    private Long invoiceId;
    private BigDecimal amount;
    private String paymentStatus;
    public PaymentDTO(String paymentId, Long customerId, Long invoiceId, BigDecimal amount, String paymentStatus) {
        this.paymentId = paymentId;
        this.customerId = customerId;
        this.invoiceId = invoiceId;
        this.amount = amount;
        this.paymentStatus = paymentStatus;
    }
    public PaymentDTO() {
    }
    @Override
    public String toString() {
        return "PaymentDTO [paymentId=" + paymentId + ", customerId=" + customerId + ", invoiceId=" + invoiceId
                + ", amount=" + amount + ", paymentStatus=" + paymentStatus + "]";
    }
    
    public String getPaymentId() {
        return paymentId;
    }
    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }
    public Long getCustomerId() {
        return customerId;
    }
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
    public Long getInvoiceId() {
        return invoiceId;
    }
    public void setInvoiceId(Long invoiceId) {
        this.invoiceId = invoiceId;
    }
    public BigDecimal getAmount() {
        return amount;
    }
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
    public String getPaymentStatus() {
        return paymentStatus;
    }
    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
    
    

    
}
