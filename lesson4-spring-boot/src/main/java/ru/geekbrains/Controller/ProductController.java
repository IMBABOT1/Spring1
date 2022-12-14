package ru.geekbrains.Controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.geekbrains.Entities.Product;
import ru.geekbrains.Entities.ProductRepository;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductRepository productRepository;

    @GetMapping
    public String listPage(Model model) {
        model.addAttribute("products", productRepository.findAll());
        return "product";
    }

    @GetMapping("/{id}")
    public String form(@PathVariable("id") long id, Model model) {
        model.addAttribute("product", productRepository.findById(id));
        return "product_form";
    }

    @GetMapping("/new")
    public String addNewUser(Model model) {
        model.addAttribute("product", new Product());
        return "product_form";
    }

    @GetMapping("/delete/{id}")
    public String deleteUserById(@PathVariable long id) {
        productRepository.delete(id);
        return "redirect:/product";
    }

    @PostMapping
    public String saveProduct(@Valid Product product, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return "product_form";
        }
        productRepository.save(product);
        return "redirect:/product";
    }

    @PostMapping("/update")
    public String updateUser(Product product) {
        productRepository.save(product);
        return "redirect:/product";
    }
}