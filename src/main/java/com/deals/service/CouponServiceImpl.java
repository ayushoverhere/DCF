package com.deals.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deals.model.Coupon;
import com.deals.repository.CouponRepository;

@Service
public class CouponServiceImpl implements CouponService {

    @Autowired
    private CouponRepository couponRepository;

    @Override
    public void submitCoupon(Coupon coupon) {
        couponRepository.save(coupon);
    }

    @Override
    public List<Coupon> getAllCoupons() {
        return couponRepository.findAll();
    }

    @Override
    public void updateCoupon(String couponCode, Coupon updatedCoupon) {
        couponRepository.save(updatedCoupon);
    }

    @Override
    public void deleteCoupon(String couponCode) {
        couponRepository.deleteById(couponCode);
    }

    @Override
    public long getTotalSubmissions() {
        return couponRepository.count();
    }

    @Override
    public Coupon getCouponByCode(String couponCode) {
        return couponRepository.findById(couponCode).orElse(null);
    }

    @Override
    public List<Coupon> getCouponsByMerchant(String merchantName) {
        return couponRepository.findByMerchantNameIgnoreCase(merchantName);
    }
}
