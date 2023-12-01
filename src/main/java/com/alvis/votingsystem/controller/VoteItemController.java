package com.alvis.votingsystem.controller;

import com.alvis.votingsystem.dto.VoteInfo;
import com.alvis.votingsystem.dto.VoteItemRequest;
import com.alvis.votingsystem.model.VoteItem;
import com.alvis.votingsystem.service.VoteItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class VoteItemController {

    @Autowired
    public VoteItemService voteItemService;

    @GetMapping("/user/voteInfo")
    public ResponseEntity<?> getVoteInfo () {
        List<VoteInfo> voteInfoList = voteItemService.getVoteInfo();
        return ResponseEntity.status(200).body(voteInfoList);
    }

    @GetMapping("/admin/voteItems")
    public ResponseEntity<List<VoteItem>> getVoteItems () {
        List<VoteItem> voteItemList = voteItemService.getVoteItems();
        return ResponseEntity.status(200).body(voteItemList);
    }

    @PostMapping("/admin/voteItems")
    public ResponseEntity<VoteItem> createVoteItem (@RequestBody @Valid VoteItemRequest voteItemRequest) {

        Integer itemId = voteItemService.createVoteItem(voteItemRequest);
        VoteItem voteItem = voteItemService.getVoteItemById(itemId);

        return ResponseEntity.status(201).body(voteItem);
    }

    @PutMapping("/admin/voteItems/{itemId}")
    public ResponseEntity<VoteItem> updateVoteItem (
                                        @PathVariable Integer itemId,
                                        @RequestBody @Valid VoteItemRequest voteItemRequest) {

        voteItemService.updateVoteItem(itemId, voteItemRequest);
        VoteItem voteItem = voteItemService.getVoteItemById(itemId);

        return ResponseEntity.status(200).body(voteItem);
    }
}