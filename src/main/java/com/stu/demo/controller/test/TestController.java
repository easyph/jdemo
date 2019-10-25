package com.stu.demo.controller.test;

import com.stu.demo.dao.TestVO;
import com.stu.demo.dao.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value = "测试api", description = "测试相关api", tags = "测试")
@RequestMapping("test")
public class TestController {

    @ApiOperation(value = "get传参：query string", notes = "get query string 传参")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "argv1", value = "参数1", paramType = "query", dataType = "int", required = true),
            @ApiImplicitParam(name = "argv2", value = "参数2", paramType = "query", dataType = "string", required = true)
    })
    @RequestMapping(value = "get1", method = RequestMethod.GET)
    public String getTestQuery1(
            @RequestParam(value = "argv1") Integer argv1,
            @RequestParam("argv2") String argv2
    ){
        return "argv1:" + argv1 + "; argv2:" + argv2;
    }

    @ApiOperation(value = "get传参： pathinfo", notes = "get pathinfo 传参")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "argv1", value = "参数1", paramType = "path", dataType = "int", required = true),
            @ApiImplicitParam(name = "argv2", value = "参数2", paramType = "path", dataType = "string", required = true)
    })
    @RequestMapping(value = "get2/id/{argv1}/name/{argv2}", method = RequestMethod.GET)
    public String getTestQuery2(
            @PathVariable(value = "argv1") Integer argv1,
            @PathVariable("argv2") String argv2
    ){
        return "argv1:" + argv1 + "; argv2:" + argv2;
    }


    @ApiOperation(value = "post传参: query", notes = "post query 传参")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "argv1", value = "参数1", paramType = "query", dataType = "int", required = true),
            @ApiImplicitParam(name = "argv2", value = "参数2", paramType = "query", dataType = "string", required = true)
    })
    @RequestMapping(value = "post1", method = RequestMethod.POST)
    public String postTestQuery1(
            @RequestParam(value = "argv1") Integer argv1,
            @RequestParam("argv2") String argv2
    ){
        return "argv1:" + argv1 + "; argv2:" + argv2;
    }


    @ApiOperation(value = "post传参: path", notes = "post path 传参")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "argv1", value = "参数1", paramType = "path", dataType = "int", required = true),
            @ApiImplicitParam(name = "argv2", value = "参数2", paramType = "path", dataType = "string", required = true)
    })
    @RequestMapping(value = "post2/argv1/{argv1}/argv2/{argv2}", method = RequestMethod.POST)
    public String postTestQuery2(
            @PathVariable(value = "argv1") Integer argv1,
            @PathVariable("argv2") String argv2
    ){
        return "argv1:" + argv1 + "; argv2:" + argv2;
    }



    @ApiOperation(value = "post传参: path", notes = "post path + query 传参")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "argv1", value = "参数1", paramType = "path", dataType = "int", required = true),
            @ApiImplicitParam(name = "argv2", value = "参数2", paramType = "query", dataType = "string", required = true)
    })
    @RequestMapping(value = "post3/argv1/{argv1}", method = RequestMethod.POST)
    public String postTestQuery3(
            @PathVariable(value = "argv1") Integer argv1,
            @RequestParam("argv2") String argv2
    ){
        return "argv1:" + argv1 + "; argv2:" + argv2;
    }

    @ApiOperation(value = "post传参: body", notes = "post body 传参")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "argv2", value = "参数2", paramType = "body", dataType = "TestVO", required = true)
    })
    @RequestMapping(value = "post4", method = RequestMethod.POST)
    public String postTestQuery4(
            @RequestBody() TestVO argv2
    ){
        return "body:" + argv2.getName() + ", " + argv2.getNickName() + ", " + argv2.getPassword();
    }


    @ApiOperation(value = "post传参: query + body", notes = "post query + body 传参")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "argv1", value = "参数1", paramType = "query", dataType = "int", required = true),
            @ApiImplicitParam(name = "argv2", value = "参数2", paramType = "body", dataType = "TestVO", required = true)
    })
    @RequestMapping(value = "post5", method = RequestMethod.POST)
    public String postTestQuery5(
            @RequestParam(value = "argv1") Integer argv1,
            @RequestBody() TestVO argv2
    ){
        return "argv1:" + argv1 + "; body:" + argv2.getName() + ", " + argv2.getNickName() + ", " + argv2.getPassword();
    }


    @ApiOperation(value = "post传参: path + body", notes = "post path + body 传参")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "argv1", value = "参数1", paramType = "path", dataType = "int", required = true),
            @ApiImplicitParam(name = "argv2", value = "参数2", paramType = "body", dataType = "TestVO", required = true)
    })
    @RequestMapping(value = "post6/id/{argv1}", method = RequestMethod.POST)
    public String postTestQuery6(
            @PathVariable(value = "argv1") Integer argv1,
            @RequestBody() TestVO argv2
    ){
        return "argv1:" + argv1 + "; body:" + argv2.getName() + ", " + argv2.getNickName() + ", " + argv2.getPassword();
    }


}
