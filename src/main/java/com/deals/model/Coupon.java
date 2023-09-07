package com.deals.model;

import java.util.Date;

public class Coupon {

    public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	public String getCouponCode() {
		return couponCode;
	}

	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	private String merchantName;
    private String couponCode;
    private Date expiryDate;
    private String title;
    private String description;

    // Constructors, getters, and setters for all fields

    // Additional constructor
    public Coupon(String merchantName, String couponCode, Date expiryDate, String title, String description) {
        this.merchantName = merchantName;
        this.couponCode = couponCode;
        this.expiryDate = expiryDate;
        this.title = title;
        this.description = description;
    }
}
