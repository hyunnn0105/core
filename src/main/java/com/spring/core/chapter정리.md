### chap01

Hotel

    public Hotel(Restaurant restaurant, Chef headChef){
        this.restaurant = new EasternRestaurant();
        this.headChef = new KimuraChef();
    }

EasternRestaurant

    public EasternRestaurant(){
        this.chef = new KimuraChef();
        this.course = new SushiCourse();
    }

새로 생성해서 넣어줌 -> SQLID 법칙에 위배됨

### chap01_2   
-> config.HotelManager 생성

Hotel

    public Hotel(Restaurant restaurant, Chef chef){
        // 구현체에 의존하고있기도 함
        this.restaurant = restaurant;
        this.headChef = chef;
    }

EasternRestaurant

    public EasternRestaurant(Chef chef, Course course){
        this.chef = chef;
        this.course = course;
    }

HotelManager

    // 쉐프객체를 생성하여 리던하는 메서드 -> Bean
    public Chef chef(){
        return new JuanChef();
    }
    public Course course(){
        return new FrendhCourse();
    }
    public Restaurant restaurant(){
        return new WesternRestaurant(chef(), course());
    }
    public Hotel hotel(){
        return new Hotel(restaurant(), chef());
    }

호텔 매니저에서 return 값만 수정

### chap02
HotelConfig + xml 생성   
@Configuration : 스프링 컨테이너에 스프링 빈을 등록하는 설정파일   
@Bean : 빈 등록   
@Bean(name = "사용자지정") : 빈 이름 설정  

<br>

    @Configuration
    public class HotelConfig {
    
        // 빈 등록 방식 1. 생성자 주입 , 2.세터 주입
        @Bean
        public Chef chef(){
            // 주입할거X
            return new KimuraChef();
        }
        @Bean(name = "sc")
        public Course Sushicourse(){
            return new SushiCourse();
        }
    }
<br>

- 빈등록 방식
1. 생성자 주입 (이게 안전함)
  
       @Bean(name = "res") // 빈 이름 짓기 -> 안지으면 기본값 생성?
       public Restaurant restaurant(){
           EasternRestaurant er = new EasternRestaurant(chef(), Sushicourse());
       return er;
       }
<br>


2. 세터 주입
<br>

       @Bean(name = "res") // 빈 이름 짓기 -> 안지으면 기본값 생성?
       public Restaurant restaurant(){

       // 수정자 주입(setter injection) like builder
           EasternRestaurant er = new EasternRestaurant();
               er.setChef(chef());
               er.setCourse(Sushicourse());

       return er;
       }
<br>
