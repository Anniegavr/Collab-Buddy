// api.ts

import axios from 'axios';
import { allowedIps } from '../config';

const api = axios.create({
    baseURL: 'http://localhost:5173/admin',
});

// Add an interceptor to check the IP address of incoming requests
api.interceptors.request.use((config) => {
    // Get the client's IP address from the request headers
    const ipAddress = config.headers['x-forwarded-for'] || config.socket.remoteAddress;

    // Check if the client's IP address is allowed
    if (!allowedIps.includes(ipAddress)) {
        // If the IP address is not allowed, throw an error
        throw new Error('Access denied');
    }

    // If the IP address is allowed, return the config object
    return config;
});

export default api;