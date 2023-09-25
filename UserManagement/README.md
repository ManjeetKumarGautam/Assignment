# User Management System

## Framework and Language 
* ### Framework
  * Spring Boot
* ### Language
  * Java
 
## Data Flow
### 1. Controller
* add a new user  
```java
    @PostMapping("user")
    public String addUser(@RequestBody User newUser){
        return userService.addUser(newUser);
    }
```
    
* add multiple user
```java
    @PostMapping("users")
    public String addUsers(@RequestBody List<User> newUserList){
        return userService.addUsers(newUserList);
    }
```

* get all user
```java
    @GetMapping("users")
    public List<User> getUsers(){
        return userService.getAllUser();
    }
```
* get user by id
```java
   @GetMapping("user/id/{id}")
    public List<User> getUser(@PathVariable Integer id){
        return userService.getUserById(id);
    }
```
* update user info
```java
    @PutMapping("user/info/{id}/{str}/{val}")
    public String updateUser(@PathVariable Integer id,@PathVariable String str, @PathVariable String val){
        return userService.updateUserInfo(id,str,val);
    }
```

* delete user by id
```java
    @DeleteMapping("user/id/{id}")
    public String deleteUser(@PathVariable Integer id){
        return userService.deleteUser(id);
    }
```
### 2. Services
```java
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

    // get all user.......
    public List<User> getAllUser(){
        return userRepo.getUser();
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

    // update info of user
    public String updateUserInfo(Integer Id, String str,String val){

        for(User u: getAllUser()){
            if(u.getUserId().equals(Id)) {
                if (str.equals("id")) {
                    u.setUserId(Integer.parseInt(val));
                    return  "User "+Id+" id udated...";
                } else if (str.equals("name")) {
                    u.setName(val);
                    return  "User "+Id+" name udated...";
                } else if (str.equals("userName")) {
                    u.setUserName(val);
                    return  "User "+Id+" user name udated...";
                } else if (str.equals("address")) {
                    u.setAddress(val);
                } else if (str.equals("phoneNumber")) {
                    u.setPhoneNumber(val);
                    return  "User "+Id+" phone number udated...";
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
```

### 3. Repository
```java
    public List<User> getUser(){
        return userList;
    }
```

### 4. Data Base
```java
    public List<User> userSource(){
       return new ArrayList<>();
    }
```

## Data Structure
*  ArrayList
*  Linear Search

## Project Summary
User management describes the ability for someone, to manage users' digital identities, including keeping them up to date and monitoring, changing, and revoking their access to different resources.
