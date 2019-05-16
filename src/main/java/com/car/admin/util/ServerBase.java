package com.car.admin.util;

import com.car.admin.dto.User;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ServerBase {

    public class BuildAnnotation {
        private User user;
        private @NotNull(message = SystemCount.ACCOUNT_NULL) @NotBlank(message = SystemCount.ACCOUNT_NULL) String account;
        private @NotNull(message = SystemCount.PASSWORD_NULL) @NotBlank(message = SystemCount.PASSWORD_NULL) String password;

        public BuildAnnotation(User user) {
            this.user = user;
        }

        public String getAccount() {
            return account;
        }

        public String getPassword() {
            return password;
        }

        public BuildAnnotation invoke() {
            account = user.getAccount();
            password = user.getPassword();
            return this;
        }
    }

}
