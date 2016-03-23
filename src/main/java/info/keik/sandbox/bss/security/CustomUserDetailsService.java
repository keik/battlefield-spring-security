package info.keik.sandbox.bss.security;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	DataSource dataSource;

	private static final String DEF_USERS_BY_USERNAME_QUERY =
			"select id, password,enabled " +
					"from users " +
					"where id = ?";

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return new JdbcTemplate(dataSource).query(DEF_USERS_BY_USERNAME_QUERY, new String[] { username }, new RowMapper<UserDetails>() {
			public UserDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
				String id = rs.getString(1);
				String password = rs.getString(2);
				return new User(id, password, true, true, true, true, AuthorityUtils.NO_AUTHORITIES);
			}
		}).get(0);
	}
}
