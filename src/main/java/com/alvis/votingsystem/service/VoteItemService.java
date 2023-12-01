package com.alvis.votingsystem.service;

import com.alvis.votingsystem.dto.VoteInfo;
import com.alvis.votingsystem.model.VoteItem;

import java.util.List;

public interface VoteItemService {
    VoteItem getVoteItemById (Integer itemId);
    List<VoteInfo> getVoteInfo ();
    List<VoteItem> getVoteItems ();
    Integer createVoteItem ();
    void updateVoteItem (Integer itemId, Integer itemStatus);
}
