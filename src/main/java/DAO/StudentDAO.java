package DAO;

import DTO.Student;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Eugen on 7/6/2017.
 */
public class StudentDAO implements IntrerfaceDAO<Student> {
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Boolean insert(Student student) {

        int rows = jdbcTemplate.update("insert into student values(?,?,?,?,?)",
                student.getStudentId(), student.getFirstName(), student.getLastName(), student.getMarkId(), student.getGroupId());

       return false;
    }

    @Override
    public Student read(final Student student){
        String sql = "SELECT * FROM student where studentId = " + student.getStudentId();
       return (Student)jdbcTemplate.query(sql, new ResultSetExtractor<Student>() {

        @Override
        public Student extractData(ResultSet resultSet) throws SQLException, DataAccessException {
            if(resultSet.next()) {
                student.setStudentId(resultSet.getInt(1));
                student.setFirstName(resultSet.getString(2));
                student.setLastName(resultSet.getString(3));
                student.setMarkId(resultSet.getInt(4));
                student.setGroupId(resultSet.getInt(5));
            }
            return student;
        }
    });
}

    @Override
    public Student update(Student student) {
        String query = "UPDATE student SET first_name =?,last_name=?, group_id=?, mark_id=? WHERE studentId=?";
        jdbcTemplate.update(query,
                new Object[] {
                        student.getFirstName(),student.getLastName(), student.getGroupId(), student.getMarkId(), Integer.valueOf(student.getStudentId())
                });
        return null;
    }

    @Override
    public Boolean delete(Student student) {
        int id = student.getStudentId();
        String sql = "DELETE FROM student WHERE studentId = ?";
        jdbcTemplate.update(sql, new Object[] {Integer.valueOf(student.getStudentId()) });
        return false;
    }
}
