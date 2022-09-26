package org.bk.algo.general;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class NumUniqueEmails {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            set.add(normalize(email));
        }
        return set.size();
    }

    private String normalize(String email) {
        int domainIndex = email.lastIndexOf('@');
        String domain = email.substring(domainIndex + 1);
        String localWithoutDomain = email.substring(0, domainIndex);
        String local = localWithoutDomain;
        int additional = localWithoutDomain.indexOf('+');
        if (additional >= 0) {
            local = localWithoutDomain.substring(0, additional);
        }
        return local.replaceAll("\\.", "") + "@" + domain;
    }

    @Test
    void testNormalize() {
        assertThat(normalize("test.email+alex@leetcode.com")).isEqualTo("testemail@leetcode.com");
        assertThat(normalize("test.e.mail+bob.cathy@leetcode.com")).isEqualTo("testemail@leetcode.com");
        assertThat(normalize("testemail+david@lee.tcode.com")).isEqualTo("testemail@lee.tcode.com");
        assertThat(numUniqueEmails(new String[]{"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"}))
                .isEqualTo(2);
        assertThat(numUniqueEmails(new String[]{"a@leetcode.com","b@leetcode.com","c@leetcode.com"}))
                .isEqualTo(3);
    }
}
