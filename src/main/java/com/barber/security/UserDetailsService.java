package com.barber.security;



import com.barber.entity.Customer;
import com.barber.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {


    private final CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String ime) throws UsernameNotFoundException {
        Customer customer = customerRepository.findByName(ime);

        if (customer != null) {
            return new User(
                    customer.getName(),
                    customer.getPassword(),
                    Collections.singleton(new SimpleGrantedAuthority(customer.getRole().getRoleName()))
            );
        }
        throw new UsernameNotFoundException("User not found");
    }
}
