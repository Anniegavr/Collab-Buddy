export const ipFilterConfig = {
    whitelist: ['127.0.0.1', '::1'], // example whitelist, replace with your own list
    mode: 'allow'
};

export class allowedIps {
    static includes(ipAddress: any) {
        return false;
    }
}