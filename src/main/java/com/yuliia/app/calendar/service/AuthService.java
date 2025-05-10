package com.yuliia.app.calendar.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.yuliia.app.calendar.model.User;
import com.yuliia.app.calendar.repository.UserRepository;
import com.yuliia.app.calendar.util.JwtUtil;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public String register(User user) {
        // Проверка на существующего пользователя
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            return "Email already exists";
        }

        // Шифрование пароля и сохранение
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User savedUser = userRepository.save(user);
        
        // Генерация токена
        return jwtUtil.generateToken(savedUser.getEmail());
    }

    public String login(String email, String password) {
        // Поиск пользователя
        User user = userRepository.findByEmail(email)
            .orElse(null);

        // Проверка пароля
        if (user == null || !passwordEncoder.matches(password, user.getPassword())) {
            return "Invalid email or password";
        }

        // Генерация токена
        return jwtUtil.generateToken(user.getEmail());
    }
}