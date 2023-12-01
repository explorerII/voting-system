package com.alvis.votingsystem.rowMapper;

import com.alvis.votingsystem.dto.VoteInfo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class VoteInfoRowMapper implements RowMapper<VoteInfo> {

    @Override
    public VoteInfo mapRow(ResultSet resultSet, int i) throws SQLException {

        VoteInfo voteInfo = new VoteInfo();
        voteInfo.setItemId(resultSet.getInt("item_id"));
        voteInfo.setItemName(resultSet.getString("item_name"));
        voteInfo.setSum(resultSet.getInt("sum"));

        return voteInfo;
    }
}