# Restaurant Api

## Framework and Language
* ### Framework
    * Spring Boot
* ### Language
    * Java

## Data Flow
### 1. Controller

* AdminController
    * adminSignUp
    * adminSignIn
    * adminSignOut
    * getFoods
    * addFood
    * getAllUsers


* UserController
    * userSignUp
    * userSignIn
    * userSignOut
    * getFoods
    * orderFood
    * getOrders

### 2. Services

* AdminService
    * adminSignUp
    * adminSignIn
    * adminSignOut


* FoodService
    * getFoodItems
    * addFood


* OrderService
    * orderFood
    * getOrders


* PasswordEncrypt
    * encrypt


* TokenService
    * createToken
    * deleteToken
    * authenticate


* UserService
    * userSignUp
    * userSignIn
    * userSignOut
    * getAllUsers

### 3. Repository
* IFoodRepo


* IOrderRepo


* ITokenRepo
    * findFirstByTokenValue


* IUserRepo
    * findFirstByEmail


### 4. Data Source
```java
  spring.datasource.url=jdbc:mysql://localhost:3306/restaurant
  spring.datasource.username=root
  spring.datasource.password=root
  spring.datasource.driverClassName=com.mysql.cj.jdbc.Driver
  spring.jpa.hibernate.ddl-auto=update

  spring.jpa.properties.hibernate.show_sql=true
  spring.jpa.properties.hibernate.use_sql_comments=true
  spring.jpa.properties.hibernate.format_sql=true
```

## Data Sturcture
* List

## Project Summary
The Restaurant Api is used to order a food and  a user can see food without sign up  if user can order a food when user sign in, and admin can add food , see all the users and etc.
   