package DAO;

import DTO.Marks;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Eugen on 7/8/2017.
 */
public class MarksDAO implements IntrerfaceDAO<Marks> {
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Boolean insert(Marks marks) {
        int rows = jdbcTemplate.update("insert into marks values(?,?)",
                marks.getId(), marks.getMarkNumber());

        return false;
    }

    @Override
    public Marks read(final Marks marks) {
        String sql = "SELECT * FROM marks where id = " + marks.getId();
        return (Marks) jdbcTemplate.query(sql, new ResultSetExtractor<Marks>() {

            @Override
            public Marks extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                if(resultSet.next()) {
                    marks.setId(resultSet.getInt(1));
                    marks.setMarkNumber(resultSet.getInt(2));
                }
                return marks;
            }
        });
    }

    @Override
    public Marks update(Marks marks) {
        String query = "UPDATE marks SET marknumber =? WHERE id=?";
        jdbcTemplate.update(query,
                new Object[] {
                        marks.getMarkNumber(), Integer.valueOf(marks.getId())
                });
        return null;
    }

    @Override
    public Boolean delete(Marks marks) {
        int id = marks.getId();
        String sql = "DELETE FROM marks WHERE id = ?";
        jdbcTemplate.update(sql, new Object[] {Integer.valueOf(marks.getId()) });
        return false;
    }
}
