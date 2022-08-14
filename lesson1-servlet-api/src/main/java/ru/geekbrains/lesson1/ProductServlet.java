package ru.geekbrains.lesson1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProductServlet", urlPatterns = "/products")
public class ProductServlet extends HttpServlet {

    private ProductRepository repository;

    @Override
    public void init() throws ServletException {
        repository = new ProductRepository();
        repository.insert(new Product("first", 1));
        repository.insert(new Product("second", 2));
        repository.insert(new Product("third", 3));
        repository.insert(new Product("fourth", 4));
        repository.insert(new Product("fifth", 5));
        repository.insert(new Product("six", 6));
        repository.insert(new Product("seven", 7));
        repository.insert(new Product("eight", 8));
        repository.insert(new Product("nine", 9));
        repository.insert(new Product("ten", 10));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().printf("<html><body>");
        for (int i = 0; i < repository.findAll().size(); i++) {
            resp.getWriter().printf("<h1>" + repository.findAll().get(i) + "</h1>");
        }
        resp.getWriter().printf("</body></html>");
    }
}
