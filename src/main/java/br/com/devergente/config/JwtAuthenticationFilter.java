package br.com.devergente.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;
    private final List<String> routesToExclude;

    public JwtAuthenticationFilter(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
        this.routesToExclude = Arrays.asList("/perfil", "/login");
    }

    @Override
    protected void doFilterInternal(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull FilterChain filterChain) {
        if (routesToExclude.contains(request.getRequestURI())) {
            filterChain(request, response, filterChain);
            return;
        }
        String header = request.getHeader("Authorization");

        if (header == null || !header.startsWith("Bearer ")) {
            filterChain(request, response, filterChain);
            return;
        }
        String token = header.substring(7);
        String email = jwtUtil.getUsernameFromToken(token);

        if (email != null && jwtUtil.validateToken(token, email)) {
            Date expirationDate = jwtUtil.getExpirationDateFromToken(token);
            Date now = new Date();
            long diffInMillies = Math.abs(expirationDate.getTime() - now.getTime());
            long diff = TimeUnit.MINUTES.convert(diffInMillies, TimeUnit.MILLISECONDS);

            if (diff <= 20) {
                String newToken = jwtUtil.generateToken(email);
                response.setHeader("Authorization", "Bearer " + newToken);
            }

            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(email, null, new ArrayList<>());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        filterChain(request, response, filterChain);
    }

    private void filterChain(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) {
        try {
            filterChain.doFilter(request, response);
        } catch (IOException | ServletException e) {
            System.out.println("Token invalido, realize Login novamente. Erro ao filtrar a solicitação" + e.getMessage());
        }
    }
}
