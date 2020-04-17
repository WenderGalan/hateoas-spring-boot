[![Netlify Status](https://api.netlify.com/api/v1/badges/8110a568-faef-49ae-9b5c-d62b616e5f2c/deploy-status)](https://app.netlify.com/sites/person-vue-spring-boot/deploys)
[![Build Status](https://travis-ci.org/WenderGalan/person-vue-spring-boot.svg?branch=master)](https://travis-ci.org/WenderGalan/person-vue-spring-boot)

# Person API RESTFUL Project
### Implementation of a RESTFUL API

This API is designed for study using various tools and dependencies to enhance my knowledge of the dependencies below.

To run the project you need to define the profile you will use to start the application, or just run the application with docker-compose.

### Dependencies (back-end):
  - #### [MAPSTRUCT](https://mapstruct.org/): Used to quickly create new DTOS.
  - #### [LOMBOK](https://projectlombok.org/): Used to prevent use of getters, setters, equals, and other standard methods on persistence entities.
  - #### SPRING SECURITY
  - #### JPA
  - #### SWAGGER UI: Used for RESTFUL API Documentation
  - #### H2: Database for application. Used as an in-memory database only.
  - #### [HATEOAS](https://spring.io/projects/spring-hateoas)
  - #### [JUNIT](https://junit.org/junit5/)
  
### Dependencies (front-end):
  - #### [VUE](https://vuejs.org/): Framework web.
  - #### [AXIOS](https://www.npmjs.com/package/axios): Used for asynchronous requests.
  - #### [VUE-ROUTER](https://router.vuejs.org/): Used for navigation between SPA pages.
  - #### [VUE-THE-MASK](https://vuejs-tips.github.io/vue-the-mask/): Used to create input masks.
  - #### [VUETIFY](https://vuetifyjs.com/): Used to make the application with a different design.
  
### Continuous integration 
  - #### [TRAVIS CI](https://travis-ci.org/WenderGalan/person-vue-spring-boot.svg?branch=master)

### Deploy
  - #### [FRONT-END (CLICK HERE)](https://person-vue-spring-boot.netlify.app/) - [NETLIFY](https://www.netlify.com/)
  - #### [BACK-END (CLICK HERE)](https://person-vue-spring-boot.herokuapp.com/) - [HEROKU](https://dashboard.heroku.com/)
    - ##### Default login to api: 'personapi'
    - ##### Default password to api: 'passworddefault'
    
- ### How to run the project?
  Assuming you already have Docker installed on the machine, perform the procedures below:

  Open the console in the root folder of the application

  Run the deploy, update the application image and create the front-end and back-end applications
  
  ```
  docker-compose up -d --build
  ```

  No seu browser acesse as urls: 
    - Front-end: http://localhost:5000
    - Back-end: http://localhost:4000/swagger-ui.html
  
 ## License
```
The MIT License (MIT)

Copyright (c) 2019 Wender Galan

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
```
