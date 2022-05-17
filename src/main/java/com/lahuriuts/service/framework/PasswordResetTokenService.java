package com.lahuriuts.service.framework;

import com.lahuriuts.entity.PasswordResetToken;


public interface PasswordResetTokenService {
    PasswordResetToken findByToken(String token);

    PasswordResetToken save(PasswordResetToken passwordResetToken);
}
