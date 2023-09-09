package com.deals.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deals.model.Coupon;
import com.deals.service.CouponService;

@RestController
@RequestMapping("/api/v1/admin/coupon")
public class CouponController {

    @Autowired
    private CouponService couponService;

    @PostMapping("/submit")
    public String submitCoupon(@RequestBody Coupon coupon) {
        couponService.submitCoupon(coupon);
        return "Coupon submitted successfully!";
    }

    @GetMapping("/getall")
    public List<Coupon> getAllCoupons() {
        return couponService.getAllCoupons();
    }

    @PutMapping("/update/{couponCode}")
    public String updateCoupon(
            @PathVariable(name = "couponCode") String couponCode,
            @RequestBody Coupon updatedCoupon) {
        Coupon existingCoupon = couponService.getCouponByCode(couponCode);
        if (existingCoupon != null) {
            existingCoupon.setMerchantName(updatedCoupon.getMerchantName());
            existingCoupon.setExpiryDate(updatedCoupon.getExpiryDate());
            existingCoupon.setTitle(updatedCoupon.getTitle());
            couponService.updateCoupon(couponCode, existingCoupon);
            return "Coupon updated successfully!";
        } else {
            return "Coupon not found.";
        }
    }

    @DeleteMapping("/delete/{couponCode}")
    public String deleteCoupon(@PathVariable(name = "couponCode") String couponCode) {
        Coupon existingCoupon = couponService.getCouponByCode(couponCode);
        if (existingCoupon != null) {
            couponService.deleteCoupon(couponCode);
            return "Coupon deleted successfully!";
        } else {
            return "Coupon not found.";
        }
    }

    @GetMapping("/total-submissions")
    public long getTotalSubmissions() {
        return couponService.getTotalSubmissions();
    }

    @GetMapping("/search/{couponCode}")
    public Coupon searchCoupon(@PathVariable(name = "couponCode") String couponCode) {
        return couponService.getCouponByCode(couponCode);
    }

    @GetMapping("/search/merchant/{merchantName}")
    public List<Coupon> searchCouponsByMerchantName(@PathVariable(name = "merchantName") String merchantName) {
        return couponService.getCouponsByMerchant(merchantName);
    }
}
