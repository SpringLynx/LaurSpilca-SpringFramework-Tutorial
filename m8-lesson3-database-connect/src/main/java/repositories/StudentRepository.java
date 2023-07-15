package repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addStudent(Student student){

        //String sql = "INSERT INTO Student VALUES (?, ?, ?)";
        String sql = "INSERT INTO students (first_name, last_name, date_of_birth, gender, address, phone_number, email)\n" +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, student.getFirstName(), student.getLastName(), student.getDob(), student.getGender(), student.getAddress(), student.getPhoneNumber(), student.getEmail());

    }

}
