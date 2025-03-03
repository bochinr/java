package com.javaee.ex07.controller;

import com.javaee.ex07.po.Book;
import com.javaee.ex07.po.BookEx;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
@RequestMapping(value = "/book")
public class BookController {
    @GetMapping("to_add_book")
    public String toAddbook(){
        return "book/add_book";
    }
    @PostMapping("add_book_binding_default")
    public String addBookBindingDefault(HttpServletRequest request, Model model){
        Book book = new Book();
        book.setBookId(Integer.parseInt(request.getParameter("book_id")));
        book.setBookName(request.getParameter("book_name"));
        book.setIsbn(request.getParameter("isbn"));
        book.setPrice(Float.parseFloat(request.getParameter("price")));
        book.setPubDate(request.getParameter("pub_date"));
        book.setWarehousingDate(request.getParameter("warehousing_date"));
        book.setAuthor(request.getParameter("author"));
        book.setInventory(Integer.parseInt(request.getParameter("inventory")));
        book.setPubId(Integer.parseInt(request.getParameter("pub_id")));
        model.addAttribute("book", book);
        return "book/book_info";
    }
    @PostMapping("/add_book_binding_basic")
    public String addBookBindingBasic(@RequestParam("book_id") int bookId,
                                      @RequestParam("book_name") String bookName, String isbn, float price,
                                      @RequestParam("pub_date") String pubDate,
                                      @RequestParam("warehousing_date") String warehousingDate,
                                      String author, int inventory, @RequestParam("pub_id") int pubId, Model model){
        Book book = new Book();
        book.setBookId(bookId);
        book.setBookName(bookName);
        book.setIsbn(isbn);
        book.setPrice(price);
        book.setPubDate(pubDate);
        book.setWarehousingDate(warehousingDate);
        book.setAuthor(author);
        book.setInventory(inventory);
        book.setPubId(pubId);
        model.addAttribute("book", book);
        return "book/book_info";
    }
    @PostMapping("/add_book_binding_basic_ex")
    public String addBookBindingBasicEx(@RequestParam("book_id") int bookId,
                                        @RequestParam("book_name") String bookName, String isbn, float price,
                                        @RequestParam("pub_date") Date pubDate,
                                        @RequestParam("warehousing_date") Date warehousingDate,
                                        String author, int inventory, @RequestParam("pub_id") int pubId, Model model) {
        BookEx book = new BookEx();
        book.setBookId(bookId);
        book.setBookName(bookName);
        book.setIsbn(isbn);
        book.setPrice(price);
        book.setPubDate(pubDate);
        book.setWarehousingDate(warehousingDate);
        book.setAuthor(author);
        book.setInventory(inventory);
        book.setPubId(pubId);
        model.addAttribute("book", book);
        return "book/book_info";
    }
    @PostMapping("/add_book_binding_pojo")
    public String addBookBindingBasic(BookEx bookEx, Model model) {
        model.addAttribute("book", bookEx);
        return "book/book_info_pojo";
    }
    @GetMapping("to_add_book_pojo")
    public String toAddbookPojo(){
        return "book/add_book_pojo";
    }

}
