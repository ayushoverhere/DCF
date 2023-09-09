package com.deals.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
public class Coupon {
    @Id
    private String couponCode;
    public String getCouponCode() {
		return couponCode;
	}

	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	private String merchantName;
    private Date expiryDate;
    private String title;

    // Getters and setters for all fields

    // Constructors

    public Coupon() {
    }

    public Coupon(String couponCode, String merchantName, Date expiryDate, String title) {
        this.couponCode = couponCode;
        this.merchantName = merchantName;
        this.expiryDate = expiryDate;
        this.title = title;
    }
}
