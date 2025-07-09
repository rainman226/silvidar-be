package dev.Silvidar.auth;

import java.util.Objects;

public class AuthenticationResponse {

    private String token;

    // No-argument constructor (replaces @NoArgsConstructor)
    public AuthenticationResponse() {
    }

    // All-arguments constructor (replaces @AllArgsConstructor)
    public AuthenticationResponse(String token) {
        this.token = token;
    }

    // Getter and Setter (replaces @Data)
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    // toString method (replaces @Data)
    @Override
    public String toString() {
        return "AuthenticationResponse{" +
                "token='" + token + '\'' +
                '}';
    }

    // equals method (replaces @Data)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthenticationResponse that = (AuthenticationResponse) o;
        return Objects.equals(token, that.token);
    }

    // hashCode method (replaces @Data)
    @Override
    public int hashCode() {
        return Objects.hash(token);
    }

    // Builder pattern (replaces @Builder)
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String token;

        public Builder token(String token) {
            this.token = token;
            return this;
        }

        public AuthenticationResponse build() {
            AuthenticationResponse response = new AuthenticationResponse();
            response.setToken(this.token);
            return response;
        }
    }
}
