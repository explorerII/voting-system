package com.alvis.votingsystem.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

public class VoteRecordRequest {

    @NotBlank
    private String recordName;
    @NotEmpty
    private List<Integer> itemIdList;

    public String getRecordName() {
        return recordName;
    }

    public void setRecordName(String recordName) {
        this.recordName = recordName;
    }

    public List<Integer> getItemIdList() {
        return itemIdList;
    }

    public void setItemIdList(List<Integer> itemIdList) {
        this.itemIdList = itemIdList;
    }
}
