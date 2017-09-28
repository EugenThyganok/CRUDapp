package DAO;

import DTO.Student;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

import DTO.Country;

/**
 * Created by Eugen on 9/27/2017.
 */
public class CountryDAO implements IntrerfaceDAO<Country> {
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Boolean insert(Country student) {
        return null;
    }

    @Override
    public Country read(Country country) {
        String sql = "SELECT * FROM countries where id = " + country.getId();
        return (Country) jdbcTemplate.query(sql, new ResultSetExtractor<Country>() {

            @Override
            public Country extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                if (resultSet.next()) {
                    country.setId(resultSet.getInt(1));
                    country.setName(resultSet.getString(2));
                    country.setTime(resultSet.getTimestamp(3));
                    country.setUpdateTime(resultSet.getTimestamp(4));
                    country.setSymbolizedName(resultSet.getString(5));
                }
                return country;
            }
        });
    }

    @Override
    public Country update(Country name) {
        return null;
    }

    @Override
    public Boolean delete(Country name) {
        return null;
    }

    /*    Boolean insert(T student);
    T read(T student);
    T update(T student);
    Boolean delete(T student);*/
}

                    /*country.setStudentId(resultSet.getInt(1));
                    student.setFirstName(resultSet.getString(2));
                    student.setLastName(resultSet.getString(3));
                    student.setMarkId(resultSet.getInt(4));
                    student.setGroupId(resultSet.getInt(5));*/