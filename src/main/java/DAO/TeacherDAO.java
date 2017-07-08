package DAO;

import DTO.Teacher;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Eugen on 7/8/2017.
 */
public class TeacherDAO implements IntrerfaceDAO<Teacher> {
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Boolean insert(Teacher teacher) {
        int rows = jdbcTemplate.update("insert into teacher values(?,?,?,?)",
                teacher.getId(), teacher.getName(), teacher.getLastName(), teacher.getGroupdId());

        return false;
    }

    @Override
    public Teacher read(final Teacher teacher) {
        String sql = "SELECT * FROM teacher where teacherId = " + teacher.getId();
        return (Teacher)jdbcTemplate.query(sql, new ResultSetExtractor<Teacher>() {

            @Override
            public Teacher extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                if(resultSet.next()) {
                    teacher.setId(resultSet.getInt(1));
                    teacher.setName(resultSet.getString(2));
                    teacher.setLastName(resultSet.getString(3));
                    teacher.setGroupdId(resultSet.getInt(4));
                }
                return teacher;
            }
        });
    }

    @Override
    public Teacher update(Teacher teacher) {
        String query = "UPDATE teacher SET first_name =?,last_name=?, groupId=? WHERE teacherId=?";
        jdbcTemplate.update(query,
                new Object[] {
                        teacher.getName(),teacher.getLastName(), teacher.getGroupdId(), Integer.valueOf(teacher.getId())
                });
        return null;
    }

    @Override
    public Boolean delete(Teacher teacher) {
        int id = teacher.getId();
        String sql = "DELETE FROM student WHERE studentId = ?";
        jdbcTemplate.update(sql, new Object[] {Integer.valueOf(teacher.getId()) });
        return false;
    }
}
