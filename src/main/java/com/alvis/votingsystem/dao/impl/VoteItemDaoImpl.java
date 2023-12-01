package com.alvis.votingsystem.dao.impl;

import com.alvis.votingsystem.dao.VoteItemDao;
import com.alvis.votingsystem.dto.VoteInfo;
import com.alvis.votingsystem.model.VoteItem;
import com.alvis.votingsystem.rowMapper.VoteInfoRowMapper;
import com.alvis.votingsystem.rowMapper.VoteItemRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Component
public class VoteItemDaoImpl implements VoteItemDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public VoteItem getVoteItemById(Integer itemId) {

        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                                    .withProcedureName("get_vote_item")
                                    .returningResultSet("vote_item", new VoteItemRowMapper());

        SqlParameterSource in = new MapSqlParameterSource().addValue("itemId", itemId);
        Map<String, Object> out = simpleJdbcCall.execute(in);
        List<VoteItem> list = (List<VoteItem>) out.get("vote_item");

        if (list.size() > 0) {
            return list.get(0);
        } else {
            return null;
        }
    }

    @Override
    public List<VoteItem> getVoteItems() {

        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                                    .withProcedureName("get_vote_item_list")
                                    .returningResultSet("vote_item_list", new VoteItemRowMapper());

        Map<String, Object> out = simpleJdbcCall.execute();
        List<VoteItem> voteItemList = (List<VoteItem>) out.get("vote_item_list");

        return voteItemList;
    }

    @Override
    public List<VoteInfo> getVoteInfo() {

        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                                    .withProcedureName("get_vote_item_with_sum_list")
                                    .returningResultSet("vote_info_list", new VoteInfoRowMapper());

        Map<String, Object> out = simpleJdbcCall.execute();
        List<VoteInfo> voteInfoList = (List<VoteInfo>) out.get("vote_info_list");

        return voteInfoList;
    }

    @Override
    public Integer createVoteItem(String itemName, Integer itemStatus) {

        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                                    .withProcedureName("create_vote_item");

        Date date = new Date();

        SqlParameterSource in = new MapSqlParameterSource()
                                    .addValue("itemName", itemName)
                                    .addValue("itemStatus", itemStatus)
                                    .addValue("createDate", date)
                                    .addValue("lastModifiedDate", date);

        Map<String, Object> out = simpleJdbcCall.execute(in);

        return (Integer) out.get("itemId");
    }

    @Override
    public void updateVoteItem(Integer itemId, Integer itemStatus) {

        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                                    .withProcedureName("update_vote_item");

        SqlParameterSource in = new MapSqlParameterSource()
                                    .addValue("itemId", itemId)
                                    .addValue("itemStatus", itemStatus)
                                    .addValue("lastModifiedDate", new Date());

        simpleJdbcCall.execute(in);
    }
}
