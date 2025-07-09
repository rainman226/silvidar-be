package dev.Silvidar.auth;

import java.util.Objects;

public class AuthenticationRequest {

    private String email;
    private String password;

    // No-argument constructor (replaces @NoArgsConstructor)
    public AuthenticationRequest() {
    }

    // All-arguments constructor (replaces @AllArgsConstructor)
    public AuthenticationRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    // Getters and Setters (replaces @Data)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // toString method (replaces @Data)
    @Override
    public String toString() {
        return "AuthenticationRequest{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    // equals method (replaces @Data)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthenticationRequest that = (AuthenticationRequest) o;
        return Objects.equals(email, that.email) &&
                Objects.equals(password, that.password);
    }

    // hashCode method (replaces @Data)
    @Override
    public int hashCode() {
        return Objects.hash(email, password);
    }

    // Builder pattern (replaces @Builder)
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String email;
        private String password;

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public AuthenticationRequest build() {
            AuthenticationRequest request = new AuthenticationRequest();
            request.setEmail(this.email);
            request.setPassword(this.password);
            return request;
        }
    }
}
