package com.alvis.votingsystem.service.impl;

import com.alvis.votingsystem.dao.VoteItemDao;
import com.alvis.votingsystem.dto.VoteInfo;
import com.alvis.votingsystem.dto.VoteItemRequest;
import com.alvis.votingsystem.model.VoteItem;
import com.alvis.votingsystem.service.VoteItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

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
    public Integer createVoteItem(VoteItemRequest voteItemRequest) {
        checkItemStatus(voteItemRequest.getItemStatus());
        return voteItemDao.createVoteItem(voteItemRequest.getItemName(), voteItemRequest.getItemStatus());
    }

    @Override
    public void updateVoteItem(Integer itemId, VoteItemRequest voteItemRequest) {
        checkItemStatus(voteItemRequest.getItemStatus());
        voteItemDao.updateVoteItem(itemId, voteItemRequest.getItemStatus());
    }

    public void checkItemStatus (Integer itemStatus) {

        if (!itemStatus.equals(0) && !itemStatus.equals(1)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "value of vote item status must be 0 or 1.");
        }
    }
}