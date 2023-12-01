package com.alvis.votingsystem.dao;

import com.alvis.votingsystem.dto.VoteInfo;
import com.alvis.votingsystem.model.VoteItem;

import java.util.List;

public interface VoteItemDao {
    VoteItem getVoteItemById (Integer itemId);
    List<VoteItem> getVoteItems ();
    List<VoteInfo> getVoteInfo ();
    Integer createVoteItem (String itemName, Integer itemStatus);
    void updateVoteItem (Integer itemId, Integer itemStatus);
}
