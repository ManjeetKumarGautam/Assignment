# User Management System

## Framework and Language 
* ### Framework
  * Spring Boot
* ### Language
  * Java
 
## Data Flow
### 1. Controller
 
```java
    @RestController
@Validated
public class UserController {
    @Autowired
    UserService userService;

    // add a new user
    @PostMapping("user")
    public String addUser(@RequestBody @Valid User newUser){
        return userService.addUser(newUser);
    }
    // add multiple user
    @PostMapping("users")
    public String addUsers(@RequestBody @Valid List<User> newUserList){
        return userService.addUsers(newUserList);
    }

    // get all user
    @GetMapping("users")
    public List<User> getUsers(){
        return userService.getAllUser();
    }

    // get user by id
    @GetMapping("user/id/{id}")
    public List<User> getUser(@PathVariable Integer id){
        return userService.getUserById(id);
    }

    //update user info
    @PutMapping("user/info/{id}/{str}/{val}")
    public String updateUser(@PathVariable @Valid Integer id,@PathVariable String str, @PathVariable String val){
        return userService.updateUserInfo(id,str,val);
    }

    // delete user by id
    @DeleteMapping("user/id/{id}")
    public String deleteUser(@PathVariable Integer id){
        return userService.deleteUser(id);
    }
}
```
### 2. Services
```java
    @Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    // add new user......
    public String addUser(User newUser){
        userRepo.getUser().add(newUser);
        return "New user added";
    }

    // add multiple users....
    public String addUsers(List<User> newUserList){
        for(User user:newUserList){
            userRepo.getUser().add(user);
        }
        return "New users added";
    }

    // get user by id......
    public List<User> getUserById(Integer Id){
        List<User> filterUser=new ArrayList<>();

        for(User u: getAllUser()){
            if(u.getUserId().equals(Id)){
                filterUser.add(u);
            }
        }
        return  filterUser;
    }

    // get all user.......
    public List<User> getAllUser(){
        return userRepo.getUser();
    }

    // update info of user
    public String updateUserInfo(Integer Id, String str,String val){

        for(User u: getAllUser()){
            if(u.getUserId().equals(Id)) {
                if (str.equals("userName")) {
                    u.setUserName(val);
                    return  "User "+Id+" user name updated...";
                } else if (str.equals("phoneNumber")) {
                    u.setPhoneNumber(val);
                    return  "User "+Id+" phone number updated...";
                } else if (str.equals("email")) {
                    u.setEmail(val);
                    return  "User "+Id+" email updated...";
                }

            }

        }
        return  "Invalid id";
    }

    // delete user by id
    public String deleteUser(Integer id){
        for(User u: getAllUser()){
            if(u.getUserId().equals(id)){
                getAllUser().remove(u);
                return "User deleted..";
            }
        }
        return "Invalid id..";
    }
}
```

### 3. Repository
```java
    
@Repository
public class UserRepo {
    @Autowired
    private List<User> userList;

    public List<User> getUser(){
        return userList;
    }
}
```

### 4. Data Base
```java
    @Configuration
public class UserDataSource {
    @Bean
    public List<User> userSource(){
        return new ArrayList<>();
    }
}
```

## Data Structure
*  ArrayList
*  Linear Search

## Project Summary
User management describes the ability for someone, to manage users' digital identities, including keeping them up to date and monitoring, changing, and revoking their access to different resources.
