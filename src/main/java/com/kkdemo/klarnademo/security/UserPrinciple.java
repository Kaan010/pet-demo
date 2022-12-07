//package com.kkdemo.klarnademo.security;
//
//import com.kkdemo.klarnademo.model.Klarnaut;
//import com.kkdemo.klarnademo.model.enums.Role;
//import com.kkdemo.klarnademo.util.SecurityUtils;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Collection;
//import java.util.Set;
//
//
//@Getter
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//public class UserPrinciple implements UserDetails
//{
//    private Long id;
//    private String username;
//    transient private String password; //don't show up on an searialized places
//    transient private Klarnaut klarnaut; //user for only login operation, don't use in JWT.
//    private Set<GrantedAuthority> authorities;
//
//    public static UserPrinciple createSuperUser()
//    {
//        Set<GrantedAuthority> authorities = Set.of(SecurityUtils.convertToAuthority(Role.SYSTEM_MANAGER.name()));
//
//        return UserPrinciple.builder()
//                .id(-1L)
//                .username("system-administrator")
//                .authorities(authorities)
//                .build();
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities()
//    {
//        return authorities;
//    }
//
//    @Override
//    public String getPassword()
//    {
//        return password;
//    }
//
//    @Override
//    public String getUsername()
//    {
//        return username;
//    }
//
//    @Override
//    public boolean isAccountNonExpired()
//    {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked()
//    {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired()
//    {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled()
//    {
//        return true;
//    }
//}
