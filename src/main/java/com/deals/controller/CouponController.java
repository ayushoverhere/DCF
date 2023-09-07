package com.deals.controller;

import com.deals.model.Coupon;
import com.deals.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin/coupon") // Updated endpoint path
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
        couponService.updateCoupon(couponCode, updatedCoupon);
        return "Coupon updated successfully!";
    }

    @DeleteMapping("/delete/{couponCode}")
    public String deleteCoupon(@PathVariable(name = "couponCode") String couponCode) {
        couponService.deleteCoupon(couponCode);
        return "Coupon deleted successfully!";
    }

    @GetMapping("/total-submissions")
    public long getTotalSubmissions() {
        return couponService.getTotalSubmissions();
    }

    @GetMapping("/search/{couponCode}") // New endpoint for searching by coupon code
    public Coupon searchCoupon(@PathVariable(name = "couponCode") String couponCode) {
        return couponService.getCouponByCode(couponCode);
    }
}
