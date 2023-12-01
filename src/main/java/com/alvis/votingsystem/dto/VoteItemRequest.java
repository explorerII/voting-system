package com.alvis.votingsystem.dto;

import javax.validation.constraints.NotNull;

public class VoteItemRequest {

    @NotNull
    private String itemName;
    @NotNull
    private Integer itemStatus;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getItemStatus() {
        return itemStatus;
    }

    public void setItemStatus(Integer itemStatus) {
        this.itemStatus = itemStatus;
    }
}
