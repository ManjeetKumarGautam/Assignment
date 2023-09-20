# Readme file of URL Hit

## Framework and Language 
* ### Framework
  * Spring Boot
* ### Language
  * Java
 
## Data Flow
### 1. Controller
```JAVA
@RestController
@RequestMapping("/api/v1/visitor-count-app")
public class URLHitController {
    @Autowired
    URLHitService urlHitService;

    @PostMapping("/username/{username}")
    public String addUrlHit(@PathVariable String username){
        return urlHitService.addUrlHit(username);
    }

    @GetMapping("/username/{userName}/count")
    public URLHit getUrlHitCount(@PathVariable String userName) {
        return urlHitService.getUrlHit(userName);
    }

    @GetMapping("/count")
    public String getHitCount(){
        return urlHitService.getHitCount();
    }

    @GetMapping("/visitors")
    public  String getVisitors(){
        return urlHitService.getVisitors();
    }
}
  
```

### 2. Services
```JAVA
@Service
public class URLHitService {

    @Autowired
    URLHitRepo urlHitRepo;

    public String addUrlHit(String username){


        urlHitRepo.getUrlHitMap().put(
                username,
                urlHitRepo.getUrlHitMap().getOrDefault(username,0)+1
        );
        return  username+" hit";
    }

    public URLHit getUrlHit(String userName){
        URLHit urlHit=new URLHit();
        urlHit.setUsername(userName);
        urlHit.setCount(urlHitRepo.getUrlHitMap().get(userName));

        return  urlHit;
    }

    public String getHitCount() {
        int count=0;
        for (String str : urlHitRepo.getUrlHitMap().keySet()){
            count+= urlHitRepo.getUrlHitMap().get(str);
        }
        return "Total Url Hit : " + count;
    }

    public String getVisitors() {
        return "Visitors : "+ urlHitRepo.getUrlHitMap().size();
    }
}

```
### 3. Repository
```JAVA
@Repository
public class URLHitRepo {

    @Autowired
    private Map<String, Integer> urlHitMap;

    public Map<String, Integer> getUrlHitMap() {
        return urlHitMap;
    }
}
```


### 4. Data Source
```JAVA
@Configuration
public class DataSource {

    @Bean
    Map<String, Integer> getURLHitSource(){
        return new HashMap<>();
    }
}
```

## Data Structure
*  HashMap


## Project Summary
In the URL Hit Application, where you  
