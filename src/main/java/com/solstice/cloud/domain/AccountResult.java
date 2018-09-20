package com.solstice.cloud.domain;

import javax.persistence.JoinColumn;

public class AccountResult {

    private Long accountId;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private Long addressResult;

    public AccountResult() {
    }

    public AccountResult(Long accountId, String firstName, String lastName, String emailAddress, Long addressResult) {
        this.accountId = accountId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.addressResult = addressResult;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Long getAddressResult() {
        return addressResult;
    }

    public void setAddressResult(Long addressResult) {
        this.addressResult = addressResult;
    }
}
