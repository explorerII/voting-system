package com.alvis.votingsystem.controller;

import com.alvis.votingsystem.dto.VoteRecordRequest;
import com.alvis.votingsystem.service.VoteRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VoteRecordController {

    @Autowired
    private VoteRecordService voteRecordService;

    @PostMapping("/user/voteRecord")
    public void createVoteRecord (@RequestBody VoteRecordRequest voteRecordRequest) {
        voteRecordService.createVoteRecord(voteRecordRequest);
    }
}
