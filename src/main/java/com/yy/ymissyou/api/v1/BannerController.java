package com.yy.ymissyou.api.v1;

import com.yy.ymissyou.model.Banner;
import com.yy.ymissyou.sample.ISkill;
import com.yy.ymissyou.service.BannerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.constraints.NotBlank;

/**
 * @Date: 2020/12/6 17:15
 * @Description:
 */
//@Controller // 告诉spring这是一个controller，通知包扫描扫描，并纳入到spring容器中
//@ResponseBody
//@RestController // = @ResponseBody + @Controller
//@RequestMapping("/v1/banner")
//@Lazy // 延迟加载（实例化）
@Controller
@RequestMapping("/exception")
@Validated
public class BannerController {


    //@Autowired //属性注入
    //@Qualifier("rivenMm") // 指定具体要注入bean的名字
    //@Qualifier("diana")
    private ISkill iSkill;

    //@Autowired
    private BannerServiceImpl bannerService;

    @Autowired
    public BannerController(BannerServiceImpl bannerService, ISkill iSkill){
        this.bannerService = bannerService;
        this.iSkill = iSkill;
    }

    //@Autowired
    //private IConnect iConnect;

    //@Autowired // 通过setter方法注入，这个注解必须要加
    //public void setDiana(Diana diana) {
    //    this.diana = diana;
    //}

    //@Autowired(required = false) // 如果不加required = false并且spring容器中没有该类的实例时，项目启动会报错
    //private BannerService bannerService;

    //@Autowired
    //public BannerController(Diana diana){
    //    this.diana = diana;
    //}

    //@GetMapping(value = "/test/{id}/{name}") // 方法路由,method:标明该方法的请求动词
    //@ResponseBody
    // 1.@RequestBody Map<String,Object> person接收前端请求体中传来参数。
    //
    /*public String test(
            @Validated @Range(min = 1, max = 10, message = "URL中的id值需要在1和10之间") @PathVariable("id") Long id,
            @Length(min = 3, max = 10) @PathVariable("name") String name) {
        //iSkill.r();
        //System.out.println("bannerService = " + bannerService);
        //System.out.println("id = " + id);
        //System.out.println("name = " + name);
        //iSkill.e();
        //PersonDTO person = new PersonDTO("18",18);
        //System.out.println("person = " + personDTO);
        //System.out.println("personDTO.equals(person) = " + personDTO.equals(person));
        //throw new ForbiddenException(403);
        //PersonDTO personDTO1 = PersonDTO.builder()
        //        .name("yuanYao")
        //        .age(20)
        //        .build(); // 通过lombok，@Builder建造者模式实例化Bean
        System.out.println("id = " + id);
        System.out.println("name = " + name);
        return "hello,姚远222";
    }

    @GetMapping("/test1")
    @ResponseBody
    public String test1(@Validated PersonDTO personDTO) {
        System.out.println("personDTO = " + personDTO);
        return "hello world";
    }

    @PostMapping("/test2")
    @ResponseBody // @RequestBody主要用来接收前端传递给后端的json字符串中的数据的(请求体中的数据的)；
    //GET方式无请求体，所以使用@RequestBody接收数据时，前端不能使用GET方式提交数据，而是用POST方式进行提交。
    //在后端的同一个接收方法里，@RequestBody与@RequestParam()可以同时使用，@RequestBody最多只能有一个，而@RequestParam()可以有多个。
    public PersonDTO test2(@Validated @RequestBody PersonDTO personDTO) {
        return personDTO;
    }*/

    @GetMapping("/name/{name}") // @NotBlank:标明该属性该参数既不能为null,长度必须大于0
    @ResponseBody
    public Banner getByName(@NotBlank @PathVariable("name") String name){
        // JPA会根据方法的命名规范自动推导出sql语句来
        Banner banner = bannerService.getByName(name);
        return banner;
    }

}



