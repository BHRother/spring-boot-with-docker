package com.bhrother.github.resources

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

import java.text.DateFormat

/**
 * Created by brunohenriquerother on 23/05/2017.
 */
@RestController
class GreetingRestController {

  @GetMapping(path = "/hello/{name}", produces = "application/json")
  Map returnJson(@PathVariable("name") String name) {
    ["greeting": name, "date": DateFormat.getDateTimeInstance().format(new Date())]
  }
}
