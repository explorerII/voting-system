package com.alvis.votingsystem.controller;

import com.alvis.votingsystem.dto.VoteInfo;
import com.alvis.votingsystem.dto.VoteItemRequest;
import com.alvis.votingsystem.model.VoteItem;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class VoteItemController {

    public VoteItemService voteItemService;

    @GetMapping("/user/voteInfo")
    public ResponseEntity<?> getVoteInfo () {
        List<VoteInfo> voteInfoList = voteItemService.getVoteInfo();
        return ResponseEntity.status(200).body(voteInfoList);
    }

    @GetMapping("/admin/voteItems")
    public ResponseEntity<?> getVoteItem () {
        List<VoteItem> voteItemList = voteItemService.getVoteItem();
        return ResponseEntity.status(200).body(voteItemList);
    }

    @PostMapping("/admin/voteItems")
    public ResponseEntity createVoteItem (@RequestBody @Valid VoteItemRequest voteItemRequest) {
        VoteItem voteItem = voteItemService.createVoteItem();
        return ResponseEntity.status(201).body(voteItem);
    }

    @PutMapping("/admin/voteItems/{itemId}")
    public ResponseEntity<String> updateVoteItem (
                                        @PathVariable Integer itemId,
                                        @RequestBody Integer itemStatus) {

        voteItemService.updateVoteItem(itemId, itemStatus);
        return ResponseEntity.status(200).body("updated successfully.");
    }
}