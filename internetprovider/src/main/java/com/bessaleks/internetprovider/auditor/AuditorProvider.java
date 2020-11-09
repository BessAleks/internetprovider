package com.bessaleks.internetprovider.auditor;

import com.bessaleks.internetprovider.entity.User;
import com.bessaleks.internetprovider.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Qualifier("auditorProvider")
@AllArgsConstructor
public class AuditorProvider implements AuditorAware<Long> {
    private final UserRepository userRepository;

    @Override
    public Optional<Long> getCurrentAuditor() {
        Object principle = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principle instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) principle;
            User user = (User) userRepository.findByEmail(userDetails.getUsername()).orElseThrow(() -> new UsernameNotFoundException(userDetails.getUsername()));
            return Optional.ofNullable(user.getId());
        }
        return Optional.empty();
    }
}
