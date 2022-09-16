package com.louimolina.domain;

import com.louimolina.model.Address;
import lombok.Getter;
import lombok.Setter;

/**
 * Request object model
 *
 * */

@Getter
@Setter
public class LocatorReq {
    private Address address;
    private int distance;
    private String type;

}
