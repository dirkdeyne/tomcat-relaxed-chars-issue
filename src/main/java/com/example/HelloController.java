package com.example;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author Deyne Dirk
 *
 */
@RestController
public class HelloController {

  @GetMapping("/hello")
  public ResponseEntity<String> helloQuery(@RequestParam(defaultValue = "World") String message) {
    return ResponseEntity.ok(message);
  }
  
  @GetMapping("/hello/{message}")
  public ResponseEntity<String> helloPath(@PathVariable String message) {
    return ResponseEntity.ok(message);
  }
}