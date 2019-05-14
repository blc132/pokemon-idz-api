package pl.programirex.pokemonidzapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.programirex.pokemonidzapi.repository.UsersRepository;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors()
                .disable()
                .authorizeRequests()
                .antMatchers("/api/**")
                .authenticated()
                .and()
                .formLogin()
                .passwordParameter("password")
                .usernameParameter("name")
                .and()
                .userDetailsService(userDetailsServiceBean());


    }

    @Override
    public UserDetailsService userDetailsServiceBean() throws Exception {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
                return usersRepository.findOneByLogin(s);
            }
        };
    }

    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
