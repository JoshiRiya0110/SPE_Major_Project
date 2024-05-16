import React, { useState } from 'react';
import {useParams } from 'react-router-dom';
import styles from './DeliveryResetPassword.module.css';
import axios from 'axios';
import { BASE_URL } from '../../services/helper';

export const DeliveryResetPassword = () => {
  const { emailId } = useParams();
  const [token, setToken] = useState("");
  const [newPassword, setNewPassword] = useState("");
  const [message, setMessage] = useState("");

  const handleResetPassword = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.post(`${BASE_URL}/resetpassword/deliveryperson`, {
        
        deliveryPerson:{
          emailId
        },
        token,
        newPassword,
      });
      setMessage(response.data);
    } catch (error) {
      setMessage("Failed to reset password. Please try again.");
    }
  };

  return (
    <div className={styles.container}>
      <h2>Reset Password</h2>
      <form onSubmit={handleResetPassword}>
        <label htmlFor="token">Token:</label>
        <input
          type="text"
          id="token"
          value={token}
          onChange={(e) => setToken(e.target.value)}
          required
        />
        <label htmlFor="newPassword">New Password:</label>
        <input
          type="password"
          id="newPassword"
          value={newPassword}
          onChange={(e) => setNewPassword(e.target.value)}
          required
        />
        <button type="submit">Reset Password</button>
      </form>
      {message && <p className={styles.message}>{message}</p>}
    </div>
  );
};