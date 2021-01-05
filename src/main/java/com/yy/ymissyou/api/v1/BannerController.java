package com.yy.ymissyou.api.v1;

import com.yy.ymissyou.dto.PersonDTO;
import com.yy.ymissyou.sample.ISkill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @Date: 2020/12/6 17:15
 * @Description:
 */
//@Controller // 告诉spring这是一个controller，通知包扫描扫描，并纳入到spring容器中
//@ResponseBody
//@RestController // = @ResponseBody + @Controller
//@RequestMapping("/v1/banner")
//@Lazy // 延迟加载（实例化）
@RequestMapping("/exception")
@Controller
//@Validated
public class BannerController {


    @Autowired //属性注入
    //@Qualifier("rivenMm") // 指定具体要注入bean的名字
    //@Qualifier("diana")
    private ISkill iSkill;

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

    @GetMapping(value = "/test/{id}") // 方法路由,method:标明该方法的请求动词
    @ResponseBody
    // 1.@RequestBody Map<String,Object> person接收前端请求体中传来参数。
    //
    public String test(@Validated String name,@Validated @PathVariable("id") Long id) {
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
    public String test1(@Validated PersonDTO personDTO){
        System.out.println("personDTO = " + personDTO);
        return "hello world";
    }

    @PostMapping("/test2")
    @ResponseBody
    public PersonDTO test2(@Validated @RequestBody PersonDTO personDTO){
        return personDTO;
    }
}
