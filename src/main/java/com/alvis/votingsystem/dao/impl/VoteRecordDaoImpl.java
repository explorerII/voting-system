package com.alvis.votingsystem.dao.impl;

import com.alvis.votingsystem.dao.VoteRecordDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class VoteRecordDaoImpl implements VoteRecordDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Override
    public void createVoteRecord(String recordName, List<Integer> itemIdList) {

        String procedure = "CALL create_vote_record (:recordName, :itemId, :createDate)";

        Map<String, Object>[] mapList = new Map[itemIdList.size()];
        Date date = new Date();

        for (int i = 0; i < itemIdList.size(); i ++) {
            Map<String, Object> map = new HashMap<>();
            map.put("recordName", recordName);
            map.put("itemId", itemIdList.get(i));
            map.put("createDate", date);
            mapList[i] = map;
        }

        namedParameterJdbcTemplate.batchUpdate(procedure, mapList);
    }
}
