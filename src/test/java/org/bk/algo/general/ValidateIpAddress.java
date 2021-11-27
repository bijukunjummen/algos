package org.bk.algo.general;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ValidateIpAddress {
    public String validIPAddress(String IP) {
        if (mayBeIPV4(IP)) {
            return validateIPV4(IP);
        } else if (mayBeIPV6(IP)) {
            return validateIPV6(IP);
        } else {
            return "Neither";
        }
    }

    private boolean mayBeIPV4(String IP) {
        String[] tokens = IP.split("\\.");
        if (tokens.length == 4) {
            return true;
        }
        return false;
    }

    private String validateIPV4(String IP) {
        String[] tokens = IP.split("\\.");
        for (String token : tokens) {
            Integer intToken = Integer.valueOf(token);
            if (!(intToken >= 0 && intToken <= 255)) {
                return "Neither";
            }
        }
        return "IPv4";
    }


    private boolean mayBeIPV6(String IP) {
        String[] tokens = IP.split(":");
        if (tokens.length == 8) {
            return true;
        }
        return false;
    }

    private String validateIPV6(String IP) {
        String[] tokens = IP.split(":");
        for (String token : tokens) {
            if (!(token.length() <= 4 || token.length() >= 1)) {
                return "Neither";
            }
            if (token.length() == 1) {
                if (!token.equals("0")) {
                    return "Neither";
                }
            } else if (token.length() == 4) {
                char[] arr = token.toCharArray();
                for (char c : arr) {
                    if (!((c >= '0' && c <= '9') || (c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F'))) {
                        return "Neither";
                    }
                }
            }
        }
        return "IPv6";
    }


    @Test
    void testValidateIp() {
        assertThat(validIPAddress("172.16.254.1")).isEqualTo("IPv4");
        assertThat(validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334")).isEqualTo("IPv6");
    }
}