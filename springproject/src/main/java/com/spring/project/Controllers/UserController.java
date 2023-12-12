package com.spring.project.Controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.project.Model.Article;
import com.spring.project.Model.LikedDisliked;
import com.spring.project.Model.User;
import com.spring.project.Model.createUserCommand;
import com.spring.project.Repository.ArticleRepository;
import com.spring.project.Repository.LikedDislikedRepository;
import com.spring.project.Repository.UserRepository;

@Controller // This means that this class is a Controller
@RequestMapping(path="/user") // This means URL's start with /demo (after Application path)
public class UserController {
  @Autowired // This means to get the bean called userRepository
         // Which is auto-generated by Spring, we will use it to handle the data
  private UserRepository userRepository;
  @Autowired
  private LikedDislikedRepository likedDislikedRepository;
  @Autowired
  private ArticleRepository articleRepository;

  @PostMapping(path="/add") // Map ONLY POST Requests
  public @ResponseBody String addNewUser (@RequestBody createUserCommand arg) {
    // @ResponseBody means the returned String is the response, not a view name
    // @RequestParam means it is a parameter from the GET or POST request

    User n = new User();
    n.setName(arg.getName());
    n.setPassword(arg.getPassword());
    n.setRole(arg.getRole());
    userRepository.save(n);
    return "Saved";
  }

  @GetMapping(path="/all")
  public @ResponseBody Iterable<User> getAllUsers() {
    // This returns a JSON or XML with the users
    return userRepository.findAll();
  }

  @PutMapping(path="modify/{id}")
  public @ResponseBody Object modifyUser(@PathVariable int id, @RequestBody createUserCommand arg) {
    Optional<User> n=userRepository.findById(id);
    if(n.isPresent()){
    return userRepository.findById(id).map(user -> {
      user.setName(arg.getName());
      user.setPassword(arg.getPassword());
      user.setRole(arg.getRole());
      return userRepository.save(user);
    });
  }
    return "Problème avec la requete";
  }

  @DeleteMapping(path="delete/{id}")
  public @ResponseBody String deleteUser(@PathVariable int id){
    Iterable<LikedDisliked> iterableLiked = userRepository.findLove(id);
    Iterable<Article> iterableArticle = userRepository.findArticle(id);
      for(Article article : iterableArticle){
        for(LikedDisliked liked : iterableLiked){
          likedDislikedRepository.deleteById(liked.getId());
        }
          articleRepository.deleteById(article.getId());
        }
      
      userRepository.deleteById(id);
      return "delete successfully";
    }
}
