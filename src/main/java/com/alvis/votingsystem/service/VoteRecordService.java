package com.alvis.votingsystem.service;

import com.alvis.votingsystem.dto.VoteRecordRequest;

public interface VoteRecordService {
    void createVoteRecord (VoteRecordRequest voteRecordRequest);
}
