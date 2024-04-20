package com.youngstone.mastery.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class VendorInventoryRequestV1 {
    private String inventoryId;
    private VendorInventorySearchFilter searchFilter;
}
