# Ecommerce Api

## Framework and Language
* ### Framework
    * Spring Boot
* ### Language
    * Java

## Data Flow
### 1. Controller


* **User Controller**
```java
   @RestController
public class UserController {

  @Autowired
  UserService userService;

  @PostMapping("users")
  public String addUser(@RequestBody List<User> userList){
    return userService.addUsers(userList);
  }

  @GetMapping("user/id/{id}")
  public User getUserById(@PathVariable Integer id){
    return userService.getUserById(id);
  }

}
```
* **Product Controller**
```java
    @RestController
public class ProductController {

  @Autowired
  ProductService productService;

  @PostMapping("products")
  public String addProducts(@RequestBody List<Product> productList){
    return productService.addProducts(productList);
  }

  @GetMapping("products")
  public List<Product> getProducts(){
    return productService.getProducts();
  }

  @GetMapping("products/category/{category}")
  public List<Product> getProductsByCategory(@PathVariable String category){
    return productService.getProductsByCategory(category);
  }

  @DeleteMapping("product/id/{id}")
  public String deleteProductById(@PathVariable Integer id){
    return productService.deleteProductById(id);
  }
}
```

* **Address Controller**
```java

@RestController
public class AddressController {

  @Autowired
  AddressService addressService;

  @PostMapping("addresses")
  public String addAddress(@RequestBody List<Address> addressList){
    return addressService.addAddresses(addressList);
  }
}
```
* **Order Controller**
```java
    @RestController
public class OrderController {

  @Autowired
  OrderService orderService;

  @PostMapping("orders")
  public String addOrder(@RequestBody List<Order> orderList){
    return orderService.addOrder(orderList);
  }

  @GetMapping("order/id/{id}")
  public Order getOrderById(@PathVariable Integer id){
    return orderService.getOrderById(id);
  }
}
```

### 2. Services
* **User Service**
```java
@Service
public class UserService {

  @Autowired
  IUserRepo userRepo;

  public String addUsers(List<User> userList) {
    userRepo.saveAll(userList);
    return "Added...";
  }

  public User getUserById(Integer id){
    return userRepo.findById(id).get();
  }
}

```
* **Product Service**
```java
@Service
public class ProductService {
  @Autowired
  IProductRepo productRepo;

  @Transactional
  public String addProducts(List<Product> productList) {
    productRepo.saveAll(productList);
    return "Added...";
  }

  public List<Product> getProducts() {
    return (List<Product>)productRepo.findAll();
  }

  public List<Product> getProductsByCategory(String category) {
    return productRepo.getProductsByCategory(category);
  }

  public String deleteProductById(Integer id) {
    productRepo.deleteById(id);
    return "Deleted...";
  }
}
```

* **Address Service**
```java
    @Service
public class AddressService {

  @Autowired
  IAddressRepo addressRepo;

  public String addAddresses(List<Address> addressList){
    addressRepo.saveAll(addressList);
    return "Added...";
  }
}
```
* **Order Service**
```java
    @Service
public class OrderService {
  @Autowired
  IOrderRepo orderRepo;

  public String addOrder(List<Order> orderList) {
    orderRepo.saveAll(orderList);
    return "Added...";
  }

  public Order getOrderById(Integer id) {
    return orderRepo.findById(id).get();
  }
}
```

### 3. Repository
* **User Repo**
```java
  public interface IUserRepo extends JpaRepository<User, Integer> {

} 
```
* **Product Repo**
```java
    public interface IProductRepo extends JpaRepository<Product,Integer> {

  @Modifying
  @Query(value = "Select * from product where category= :category", nativeQuery = true)
  List<Product> getProductsByCategory(String category);
}
```

* **Address Repo**
```java
    public interface IAddressRepo extends JpaRepository<Address, Integer> {

}
```
* **Order Repo**
```java
    public interface IOrderRepo extends JpaRepository<Order,Integer> {
}
```

### 4. Data Source
```java
  spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce
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
an eCommerce API involves defining endpoints and functionalities that allow interaction with an eCommerce system, managing products, orders, users and address.