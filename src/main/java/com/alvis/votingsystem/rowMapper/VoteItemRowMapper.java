package com.alvis.votingsystem.rowMapper;

import com.alvis.votingsystem.model.VoteItem;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class VoteItemRowMapper implements RowMapper<VoteItem> {
    @Override
    public VoteItem mapRow(ResultSet resultSet, int i) throws SQLException {

        VoteItem voteItem = new VoteItem();
        voteItem.setItemId(resultSet.getInt("item_id"));
        voteItem.setItemName(resultSet.getString("item_name"));
        voteItem.setItemStatus(resultSet.getInt("item_status"));
        voteItem.setCreateDate(resultSet.getTimestamp("create_date"));
        voteItem.setLastModifiedDate(resultSet.getTimestamp("last_modified_date"));

        return voteItem;
    }
}
