package com.alvis.votingsystem.service.impl;

import com.alvis.votingsystem.dao.VoteItemDao;
import com.alvis.votingsystem.dto.VoteInfo;
import com.alvis.votingsystem.model.VoteItem;
import com.alvis.votingsystem.service.VoteItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VoteItemServiceImpl implements VoteItemService {

    @Autowired
    private VoteItemDao voteItemDao;

    @Override
    public VoteItem getVoteItemById(Integer itemId) {
        return voteItemDao.getVoteItemById(itemId);
    }

    @Override
    public List<VoteInfo> getVoteInfo() {
        return voteItemDao.getVoteInfo();
    }

    @Override
    public List<VoteItem> getVoteItems() {
        return voteItemDao.getVoteItems();
    }

    @Override
    public Integer createVoteItem() {
        return voteItemDao.createVoteItem();
    }

    @Override
    public void updateVoteItem(Integer itemId, Integer itemStatus) {
        voteItemDao.updateVoteItem(itemId, itemStatus);
    }
}