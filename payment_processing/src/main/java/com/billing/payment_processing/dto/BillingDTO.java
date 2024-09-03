package com.billing.payment_processing.dto;

import java.math.BigDecimal;

public class BillingDTO {
    private Long invoiceId;
    private Long customerId;
    private BigDecimal amount;
    private String billingStatus;

    public BillingDTO(Long invoiceId, Long customerId, BigDecimal amount, String billingStatus) {
        this.invoiceId = invoiceId;
        this.customerId = customerId;
        this.amount = amount;
        this.billingStatus = billingStatus;
    }

    public BillingDTO() {
    }

    @Override
    public String toString() {
        return "BillingDTO [invoiceId=" + invoiceId + ", customerId=" + customerId + ", amount=" + amount
                + ", billingStatus=" + billingStatus + "]";
    }

    // Getters and Setters
    public Long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Long invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getBillingStatus() {
        return billingStatus;
    }

    public void setBillingStatus(String billingStatus) {
        this.billingStatus = billingStatus;
    }
}
