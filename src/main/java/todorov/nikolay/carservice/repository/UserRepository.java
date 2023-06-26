package todorov.nikolay.carservice.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import todorov.nikolay.carservice.model.User;
import todorov.nikolay.carservice.model.UserDTO;
import todorov.nikolay.carservice.model.UserNameDTO;

@Mapper
public interface UserRepository {
    @Select("""
            SELECT *
            FROM tbl_user
            WHERE username = #{username}
            	AND password = #{password}""")
    User getUserByCredentials(String username, String password);

    @Insert("""
            INSERT INTO tbl_client(name)
                        VALUES(#{name});
            """)
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertClient(UserNameDTO userNameDTO);

    @Insert("""
            INSERT INTO tbl_employee(name)
                        VALUES(#{name});
            """)
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertEmployee(UserNameDTO userNameDTO);

    @Insert("""
            INSERT INTO tbl_user (
            	username,
            	password,
            	type,
            	user_id
            	)
            VALUES (
            	#{username},
            	#{password},
            	#{type},
            	#{userId}
            	);""")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertUser(UserDTO user);
}
