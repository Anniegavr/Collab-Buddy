export const ipFilterConfig = {
    whitelist: ['127.0.0.1', '::1', '0.0.0.0'],
    mode: 'allow'
};

export class allowedIps {
    static includes(ipAddress: any) {
        return false;
    }
}