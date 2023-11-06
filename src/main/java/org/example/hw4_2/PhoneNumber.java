package org.example.hw4_2;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PhoneNumber implements Comparable<PhoneNumber> {
    private String phone;

    public String getPhone() {
        return phone;
    }

    @Override
    public int compareTo(final PhoneNumber o) {
        return this.phone.compareTo(o.phone);
    }

}
