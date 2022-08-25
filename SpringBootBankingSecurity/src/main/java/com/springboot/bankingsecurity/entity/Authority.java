package com.springboot.bankingsecurity.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Authority")
public class Authority
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "authoritiesId")
    private Long authoritiesId;

    @Column(name = "authoritiesName")
    private String authoritiesName;

    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

    public Authority() {}

    public Authority(Long authoritiesId, String authoritiesName, Customer customer) {
        this.authoritiesId = authoritiesId;
        this.authoritiesName = authoritiesName;
        this.customer = customer;
    }

    public Long getAuthoritiesId() {
        return authoritiesId;
    }

    public void setAuthoritiesId(Long authoritiesId) {
        this.authoritiesId = authoritiesId;
    }

    public String getAuthoritiesName() {
        return authoritiesName;
    }

    public void setAuthoritiesName(String authoritiesName) {
        this.authoritiesName = authoritiesName;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
