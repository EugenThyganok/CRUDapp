package DAO;

import DTO.Groups;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Eugen on 7/8/2017.
 */
public class GroupsDAO implements IntrerfaceDAO<Groups> {
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Boolean insert(Groups groups) {
        int rows = jdbcTemplate.update("insert into groups values(?,?)",
                groups.getId(), groups.getTitle());

        return false;
    }

    @Override
    public Groups read(final Groups groups) {
        String sql = "SELECT * FROM groups where id = " + groups.getId();
        return (Groups) jdbcTemplate.query(sql, new ResultSetExtractor<Groups>() {

            @Override
            public Groups extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                if(resultSet.next()) {
                    groups.setId(resultSet.getInt(1));
                    groups.setTitle(resultSet.getString(2));
                }
                return groups;
            }
        });
    }

    @Override
    public Groups update(Groups groups) {
        String query = "UPDATE groups SET title =? WHERE id=?";
        jdbcTemplate.update(query,
                new Object[] {
                        groups.getTitle(), Integer.valueOf(groups.getId())
                });
        return null;
    }

    @Override
    public Boolean delete(Groups groups) {
        int id = groups.getId();
        String sql = "DELETE FROM groups WHERE id = ?";
        jdbcTemplate.update(sql, new Object[] {Integer.valueOf(groups.getId()) });
        return false;
    }
}
