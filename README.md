# spring-security-v1
Following lessons and taking important notes

Different branches represent one level up security implementation. 
# main branch 
Simple creation of UserDetails manually and saving in the InMemoryDetailsService

# v2 branch
Custom implementation of UserDetails and UserDetailsService, working with database

# v3 branch
Creating custom security hierarch. 
SimpleFilterChain -> Filter (OncePerRequestFilter) -> AuthenticationManager -> AuthenticationProvider. 
Security implementation over CustomAuthentication object  

# v4 branch
implementation of Custom and Default filter mechanism on the same filter chain.
