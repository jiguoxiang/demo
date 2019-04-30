package com.ji.demo.controller;

import com.ji.demo.model.User;
import com.ji.demo.exception.UserNotFoundException;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
public class UserController {

    private static final String USER_NOT_FOUND = "User not found.";
    @GetMapping("/users/id/{id}")
    @ApiOperation(value = "get user information", notes = "")
    @ApiImplicitParams({
       @ApiImplicitParam(name = "userId", value = "Id of user", required = true, dataType = "int"),
    })
    public User getUser(@PathVariable int id , final HttpServletResponse response) {
        String headerValue = CacheControl.maxAge(10, TimeUnit.SECONDS)
                .getHeaderValue();

        response.addHeader("Cache-Control", headerValue);
        return new User(id, "user@test.com", "testPassword",1);
    }
    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@Valid @RequestBody User user, BindingResult result) {
        System.out.println("user:" + user);
        if (result.hasErrors()) {
            List<ObjectError> list = result.getAllErrors();
            for (ObjectError error : list) {
                System.out.println(error.getCode() + "-" + error.getDefaultMessage());
                throw new UserNotFoundException(error.getCode() + "-" + error.getDefaultMessage());
            }
        }
        return new User(12344, user.getEmail(), user.getPassword(), user.getAge());
    }
    @GetMapping(value = "/users")
    public User getByEmail(@RequestParam("email") String email) {
        return new User(123, email, "testPassword",1);

    }
    @GetMapping("/users/email/{email}")
    public User getUser(@PathVariable String email) throws UserNotFoundException {
        if(email.equals("123321@qq.com")){
            throw new UserNotFoundException(USER_NOT_FOUND);
        }
        return new User(111, email, "testPassword",1);
    }
}
