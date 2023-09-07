import React, { useEffect, useState } from 'react';
import axios from 'axios';

function CouponManagement() {
  const [merchantName, setMerchantName] = useState('');
  const [couponCode, setCouponCode] = useState('');
  const [expiryDate, setExpiryDate] = useState('');
  const [title, setTitle] = useState('');
  const [description, setDescription] = useState('');
  const [coupons, setCoupons] = useState([]);
  const [searchQuery, setSearchQuery] = useState('');
  const [filteredCoupons, setFilteredCoupons] = useState([]);
  const [totalCoupons, setTotalCoupons] = useState(0);
  const [selectedCouponId, setSelectedCouponId] = useState('');
  const [showAllCoupons, setShowAllCoupons] = useState(false);

  useEffect(() => {
    loadCoupons();
  }, []);

  const loadCoupons = async () => {
    try {
      const response = await axios.get('http://localhost:8081/api/v1/admin/coupon/getall');
      setCoupons(response.data);
      setFilteredCoupons(response.data.slice(0, 5)); // Show the first 5 coupons initially
      setTotalCoupons(response.data.length);
    } catch (error) {
      console.error('Error loading coupons:', error);
    }
  };

  const registerCoupon = async (event) => {
    event.preventDefault();
    try {
      await axios.post('http://localhost:8081/api/v1/admin/coupon/submit', {
        merchantName,
        couponCode,
        expiryDate,
        title,
        description,
      });
      clearForm();
      loadCoupons();
      alert('Coupon Registration Successful');
    } catch (error) {
      console.error('Coupon Registration Failed:', error);
      alert('Coupon Registration Failed');
    }
  };

  const editCoupon = (coupon) => {
    setMerchantName(coupon.merchantName);
    setCouponCode(coupon.couponCode);
    setExpiryDate(coupon.expiryDate);
    setTitle(coupon.title);
    setDescription(coupon.description);
    setSelectedCouponId(coupon._id);
  };

  const updateCoupon = async () => {
    try {
      await axios.put(`http://localhost:8081/api/v1/admin/coupon/update/${selectedCouponId}`, {
        merchantName,
        couponCode,
        expiryDate,
        title,
        description,
      });
      clearForm();
      loadCoupons();
      alert('Coupon Update Successful');
    } catch (error) {
      console.error('Coupon Update Failed:', error);
      alert('Coupon Update Failed');
    }
  };

  const deleteCoupon = async (couponId) => {
    try {
      await axios.delete(`http://localhost:8081/api/v1/admin/coupon/delete/${couponId}`);
      loadCoupons();
      alert('Coupon Deletion Successful');
    } catch (error) {
      console.error('Coupon Deletion Failed:', error);
      alert('Coupon Deletion Failed');
    }
  };

  const clearForm = () => {
    setMerchantName('');
    setCouponCode('');
    setExpiryDate('');
    setTitle('');
    setDescription('');
    setSelectedCouponId('');
  };

  const handleSearch = () => {
    const filtered = coupons.filter((coupon) =>
      coupon.merchantName.toLowerCase().includes(searchQuery.toLowerCase())
    );
    setFilteredCoupons(filtered.slice(0, 5)); // Show the first 5 filtered coupons
    setTotalCoupons(filtered.length);
    setShowAllCoupons(false);
  };

  const handleShowAllCoupons = () => {
    setFilteredCoupons(coupons);
    setShowAllCoupons(true);
  };

  const handleShowLessCoupons = () => {
    setFilteredCoupons(coupons.slice(0, 5)); // Show the first 5 coupons
    setShowAllCoupons(false);
  };

  return (
    <div className="container mt-4">
      <h1 className="mb-3">Deals and Coupon Management</h1>
      <div className="row">
        <div className="col-md-6">
          <form onSubmit={registerCoupon}>
            <div className="form-group">
              <label>Merchant Name</label>
              <input
                type="text"
                className="form-control"
                value={merchantName}
                onChange={(e) => setMerchantName(e.target.value)}
                placeholder="Enter merchant name"
                required
              />
            </div>
            <div className="form-group">
              <label>Coupon Code</label>
              <input
                type="text"
                className="form-control"
                value={couponCode}
                onChange={(e) => setCouponCode(e.target.value)}
                placeholder="Enter coupon code"
                required
              />
            </div>
            <div className="form-group">
              <label>Expiry Date</label>
              <input
                type="date"
                className="form-control"
                value={expiryDate}
                onChange={(e) => setExpiryDate(e.target.value)}
                required
              />
            </div>
            <div className="form-group">
              <label>Title</label>
              <input
                type="text"
                className="form-control"
                value={title}
                onChange={(e) => setTitle(e.target.value)}
                placeholder="Enter coupon title"
                required
              />
            </div>
            <div className="form-group">
              <label>Description</label>
              <textarea
                className="form-control"
                value={description}
                onChange={(e) => setDescription(e.target.value)}
                placeholder="Enter coupon description"
                required
              ></textarea>
            </div>
            <div className="d-flex justify-content-between align-items-center">
              {selectedCouponId ? (
                <button className="btn btn-warning" type="button" onClick={updateCoupon}>
                  Update Coupon
                </button>
              ) : (
                <button className="btn btn-primary" type="submit">
                  Register Coupon
                </button>
              )}
              <button className="btn btn-secondary" type="button" onClick={clearForm}>
                Clear
              </button>
            </div>
          </form>
        </div>
        <div className="col-md-6">
          <div className="d-flex justify-content-between align-items-center mb-3">
            <div className="input-group">
              <input
                type="text"
                className="form-control"
                placeholder="Search by Merchant Name"
                value={searchQuery}
                onChange={(e) => setSearchQuery(e.target.value)}
              />
              <div className="input-group-append">
                <button className="btn btn-primary" type="button" onClick={handleSearch}>
                  Search
                </button>
              </div>
            </div>
            {showAllCoupons ? (
              <button className="btn btn-secondary" onClick={handleShowLessCoupons}>
                Show Less Coupons
              </button>
            ) : (
              <button className="btn btn-secondary" onClick={handleShowAllCoupons}>
                Show All Coupons
              </button>
            )}
          </div>
          <p>Total Coupons: {totalCoupons}</p>
          <table className="table table-striped">
            <thead>
              <tr>
                <th scope="col">Merchant Name</th>
                <th scope="col">Coupon Code</th>
                <th scope="col">Expiry Date</th>
                <th scope="col">Title</th>
                <th scope="col">Description</th>
                <th scope="col">Options</th>
              </tr>
            </thead>
            <tbody>
              {filteredCoupons.map((coupon) => (
                <tr key={coupon._id}>
                  <td>{coupon.merchantName}</td>
                  <td>{coupon.couponCode}</td>
                  <td>{new Date(coupon.expiryDate).toLocaleDateString()}</td>
                  <td>{coupon.title}</td>
                  <td>{coupon.description}</td>
                  <td>
                    <button
                      className="btn btn-warning btn-sm"
                      onClick={() => editCoupon(coupon)}
                    >
                      Edit
                    </button>
                    <button
                      className="btn btn-danger btn-sm"
                      onClick={() => deleteCoupon(coupon._id)}
                    >
                      Delete
                    </button>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      </div>
    </div>
  );
}

export default CouponManagement;
