package com.alvis.votingsystem.dao;

import java.util.List;

public interface VoteRecordDao {
    void createVoteRecord (String recordName, List<Integer> itemIdList);
}
