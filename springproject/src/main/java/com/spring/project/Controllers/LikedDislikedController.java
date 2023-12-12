package com.spring.project.Controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.project.Model.LikedDisliked;
import com.spring.project.Model.createLikedDislikedCommand;
import com.spring.project.Repository.ArticleRepository;
import com.spring.project.Repository.LikedDislikedRepository;
import com.spring.project.Repository.UserRepository;

@Controller // This means that this class is a Controller
@RequestMapping(path="/likeddisliked") // This means URL's start with /demo (after Application path)
public class LikedDislikedController {
  @Autowired // This means to get the bean called userRepository
         // Which is auto-generated by Spring, we will use it to handle the data
  private LikedDislikedRepository likedDislikedRepository;
  @Autowired
  private UserRepository userRepository;
  @Autowired
  private ArticleRepository articleRepository;

  @PostMapping(path="/add") // Map ONLY POST Requests
  public @ResponseBody String addNewLikedDisliked (@RequestBody createLikedDislikedCommand arg) {
    // @ResponseBody means the returned String is the response, not a view name
    // @RequestParam means it is a parameter from the GET or POST request

    LikedDisliked n = new LikedDisliked();
    n.setLove(arg.getLove());
    n.setArticle(articleRepository.findById(arg.getArticle()).get());
    n.setUser(userRepository.findById(arg.getUser()).get());
    likedDislikedRepository.save(n);
    return "Saved";
  }

  @GetMapping(path="/all")
  public @ResponseBody Iterable<LikedDisliked> getAllLikedDisliked() {
    // This returns a JSON or XML with the users
    return likedDislikedRepository.findAll();
  }

  @PutMapping(path="modify/{id}")
  public @ResponseBody Object modifyLiked(@PathVariable int id, @RequestBody createLikedDislikedCommand arg) {
    Optional<LikedDisliked> n = likedDislikedRepository.findById(id);
    if(n.isPresent()){
      return likedDislikedRepository.findById(id).map(liked -> {
        liked.setLove(arg.getLove());
        return likedDislikedRepository.save(liked);
        });
      }
    return "Problème avec la requete";
  }
}

