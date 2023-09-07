package com.deals.service;

import com.deals.model.Coupon;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CouponServiceImpl implements CouponService {

    private List<Coupon> couponList = new ArrayList<>();

    @Override
    public void submitCoupon(Coupon coupon) {
        couponList.add(coupon);
    }

    @Override
    public List<Coupon> getAllCoupons() {
        return couponList;
    }

    @Override
    public void updateCoupon(String couponCode, Coupon updatedCoupon) {
        for (int i = 0; i < couponList.size(); i++) {
            if (couponList.get(i).getCouponCode().equals(couponCode)) {
                couponList.set(i, updatedCoupon);
                return;
            }
        }
    }

    @Override
    public void deleteCoupon(String couponCode) {
        couponList.removeIf(coupon -> coupon.getCouponCode().equals(couponCode));
    }

    @Override
    public long getTotalSubmissions() {
        return couponList.size();
    }

    @Override
    public Coupon getCouponByCode(String couponCode) {
        for (Coupon coupon : couponList) {
            if (coupon.getCouponCode().equals(couponCode)) {
                return coupon;
            }
        }
        return null;
    }
}
