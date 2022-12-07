//package com.kkdemo.klarnademo.security;
//
//import com.kkdemo.klarnademo.model.Klarnaut;
//import com.kkdemo.klarnademo.service.KlarnautService;
//import com.kkdemo.klarnademo.util.SecurityUtils;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//import java.util.Optional;
//import java.util.Set;
//
//public class CustomKlarnautDetailsService implements UserDetailsService {
//
//    private KlarnautService klarnautService;
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Klarnaut klarnaut = klarnautService.findByUsername(username)
//                .orElseThrow(() -> new UsernameNotFoundException(username));
//
//        Set<GrantedAuthority> authorities = Set.of(SecurityUtils.convertToAuthority(klarnaut.getRole().name()));
//
//        return UserPrinciple.builder()
//                .klarnaut(klarnaut).id(klarnaut.getId())
//                .username(username)
//                .password(klarnaut.getPassword())
//                .authorities(authorities)
//                .build();
//    }
//
//}
