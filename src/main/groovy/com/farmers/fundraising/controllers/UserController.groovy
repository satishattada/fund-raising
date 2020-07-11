package com.farmers.fundraising.controllers

import com.farmers.fundraising.models.User
import com.farmers.fundraising.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

import javax.transaction.Transactional

@RestController
@RequestMapping('user')
@Transactional
class UserController {
    @Autowired
    UserService userService

    @GetMapping('')
    List findAll() {
        userService.findAll()
    }

    @GetMapping('{id}')
    User findOne(@PathVariable long id) {
        userService.findById(id)
    }

    @PostMapping('')
    User save(@RequestBody User User) {
        userService.save(User)
    }

    @PutMapping('{id}')
    User update(@RequestBody User User, @PathVariable long id) {
        UserService.update(User, id)
    }

    @DeleteMapping('{id}')
    User deleteById(@PathVariable long id) {
        userService.deleteById(id)
    }
}