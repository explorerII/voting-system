package com.alvis.votingsystem.service.impl;

import com.alvis.votingsystem.dao.VoteRecordDao;
import com.alvis.votingsystem.dto.VoteRecordRequest;
import com.alvis.votingsystem.service.VoteRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VoteRecordServiceImpl implements VoteRecordService {

    @Autowired
    private VoteRecordDao voteRecordDao;
    @Override
    public void createVoteRecord(VoteRecordRequest voteRecordRequest) {
        voteRecordDao.createVoteRecord(voteRecordRequest.getRecordName(), voteRecordRequest.getItemIdList());
    }
}
