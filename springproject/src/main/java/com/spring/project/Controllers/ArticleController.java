package com.spring.project.Controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.project.Model.Article;
import com.spring.project.Model.createArticleCommand;
import com.spring.project.Repository.ArticleRepository;
import com.spring.project.Repository.UserRepository;

@Controller // This means that this class is a Controller
@RequestMapping(path="/article") // This means URL's start with /demo (after Application path)
public class ArticleController {
  @Autowired // This means to get the bean called userRepository
         // Which is auto-generated by Spring, we will use it to handle the data
  private ArticleRepository ArticleRepository;
  @Autowired
  private UserRepository userRepository;

  @PostMapping(path="/add") // Map ONLY POST Requests
  public @ResponseBody String addNewArticle (@RequestBody createArticleCommand arg) {
    // @ResponseBody means the returned String is the response, not a view name
    // @RequestParam means it is a parameter from the GET or POST request

    Article n = new Article();
    n.setAuthor(userRepository.findById(arg.getAuthor()).get());
    n.setContent(arg.getContent());
    n.setPublishDate(new Date());
    ArticleRepository.save(n);
    return "Saved";
  }

  @GetMapping(path="/all")
  public @ResponseBody Iterable<Article> getAllArticles() {
    // This returns a JSON or XML with the users
    return ArticleRepository.findAll();
  }
}
