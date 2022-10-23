# spring-security-v1
Following lessons and taking important notes

Different branches represent one level up security implementation. 
# main branch 
Simple creation of UserDetails manually and saving in the InMemoryDetailsService

# v1 branch
Custom implementation of UserDetails and UserDetailsService, working with database

# v2 branch
Creating custom security hierarch. 
SimpleFilterChain -> Filter (OncePerRequestFilter) -> AuthenticationManager -> AuthenticationProvider. 
Security implementation over CustomAuthentication object  
