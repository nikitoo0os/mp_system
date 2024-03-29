package org.vyatsu.localApiModule.config.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.vyatsu.localApiModule.entity.user.User;
import org.vyatsu.localApiModule.repository.UserRepository;
import org.vyatsu.localApiModule.security.UserDetailsImpl;
import org.vyatsu.localApiModule.service.RoleService;

import javax.management.relation.RoleNotFoundException;
import java.util.List;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {

    private final UserRepository userRepository;
    private final RoleService roleService;

    /**
     * Конфигурация сервиса для получения информации о пользователях.
     *
     * @return Объект UserDetailsService, способный загружать информацию о пользователях по адресу электронной почты.
     */
    @Bean
    public UserDetailsService userDetailsService() {
        return username -> {
            User user = userRepository.findByEmail(username)
                    .orElseThrow(() -> new UsernameNotFoundException("User not found"));

            List<SimpleGrantedAuthority> authorities = null;
            try {
                authorities = roleService.getAuthorities(user.getId());
            } catch (RoleNotFoundException e) {
                throw new RuntimeException(e);
            }

            return new UserDetailsImpl(user.getEmail(), user.getPassword(), authorities);
        };
    }

    /**
     * Конфигурация провайдера аутентификации.
     *
     * @return Объект AuthenticationProvider, используемый для аутентификации пользователей.
     */
    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();

        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());

        return authenticationProvider;
    }

    /**
     * Конфигурация менеджера аутентификации.
     *
     * @param configuration Конфигурация аутентификации Spring.
     * @return Объект AuthenticationManager, управляющий аутентификацией пользователей.
     * @throws Exception Исключение, которое может возникнуть при создании менеджера аутентификации.
     */
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    /**
     * Конфигурация кодировщика паролей (PasswordEncoder).
     *
     * @return Объект PasswordEncoder, используемый для хеширования паролей пользователей.
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}