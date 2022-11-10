package com.example.hitoentornoservidor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.Set;

@Controller
public class Controlador {

    private Usuarios usuarios;
    private Login login;

    // Inyección de dependencias
    public Controlador(Usuarios usuarios) {
        this.usuarios = usuarios;
    }
    @Autowired
    public void setLogin(Login login) {
        this.login = login;
    }

    // Controlador que retorna un ModelAndView.
    @RequestMapping("/")
    public ModelAndView peticion1(HttpServletRequest request){
        HttpSession sesion = request.getSession();
        ModelAndView mv = new ModelAndView();
        mv.addObject("login", new Usuario());
        mv.setViewName("home");
        return mv;
    }

    // Controlador que retorna un String.
    /*@RequestMapping("/peliculas")
    public String peticion2(ModelMap model) {
        model.addAttribute("sms1", "Nuestros usuarios recomiendan algunas películas");
        model.addAttribute("sms2", "Aquí las tienes:");
        Set<Usuario> coleccionUsuarios= new HashSet<Usuario>(this.usuarios.getUsuarios().values());
        model.addAttribute("usuarios", coleccionUsuarios);
        return "peliculas";
    }*/

    @RequestMapping("/peliculas")
    public String peticion5(Usuario user, ModelMap model) {
        System.out.println(user.getUser());
        System.out.println(user.getPassword());
        Usuario login = this.usuarios.getUsuarios().get(user.getUser());
        if (login==null) {
            model.addAttribute("sms", "Usuario no registrado, no se ha podido iniciar sesión");

            return "error";
        }
        else {
            if (user.getPassword().equals(login.getPassword())) {
                model.addAttribute("sms", "Bienvenido "+user.getUser());
                this.login.setLogin(user);
            }
            else {
                model.addAttribute("sms", "El password no es correcto");

                return "error";
            }
        }
        Set<Usuario> coleccionUsuarios= new HashSet<Usuario>(this.usuarios.getUsuarios().values());
        model.addAttribute("usuarios", coleccionUsuarios);
        return "peliculas";
    }


}
