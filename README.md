# indymorning API #
## (Work-In-Progess) ##

## Simple forum service exposed via REST interface ##
#### Written using Spring Boot for Java ####

- Makes use of hypermedia links to relevant resources (HATEOAS)
- Secured with JWT (Json-Web-Token) - Currently all endpoints other than register and login are secured
- In the future all GET requests will be unsecured allowing visitors to browse threads without needing to sign-up.
- Clear seperation between request models, entities/domain models and JSON resource responses.  
- Currently still using embedded h2 database while the DB structure is still subject to change.