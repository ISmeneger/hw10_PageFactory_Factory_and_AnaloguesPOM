package Ilya_S.patterns.builder;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Address {
    private String street;
    private String city;
    private String state;
    private String zip;
}
