package it.danieltrosko.shop.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

public class ErrorControler implements ErrorController {

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request, Model model) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        Integer statusCode = Integer.valueOf(status.toString());
        model.addAttribute("code", statusCode);
        System.out.println(statusCode);
        return "error";
    }


    @Override
    public String getErrorPath() {
        return "/error";
    }
}
