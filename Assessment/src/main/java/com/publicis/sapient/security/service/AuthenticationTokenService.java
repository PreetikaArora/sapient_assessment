package com.publicis.sapient.security.service;

import com.publicis.sapient.security.api.AuthenticationTokenDetails;
import com.publicis.sapient.security.domain.Authority;

import java.util.Set;

/**
 * Service which provides operations for authentication tokens.
 *
 *
 */
public interface AuthenticationTokenService {

    /**
     * Issue an authentication token for a user with the given authorities.
     *
     * @param username
     * @param authorities
     * @return
     */
    String issueToken(String username, Set<Authority> authorities);

    /**
     * Parse an authentication token.
     *
     * @param token
     * @return
     */
    AuthenticationTokenDetails parseToken(String token);

    /**
     * Refresh an authentication token.
     *
     * @param currentAuthenticationTokenDetails
     * @return
     */
    String refreshToken(AuthenticationTokenDetails currentAuthenticationTokenDetails);
}
