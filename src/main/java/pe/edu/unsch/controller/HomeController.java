package pe.edu.unsch.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pe.edu.unsch.entities.Usuario;
import pe.edu.unsch.service.SemestreService;

@Controller
@RequestMapping("/admin")
public class HomeController {
	@Autowired
	private SemestreService semestreService;
	
	@GetMapping("/home")
	public String home(HttpSession session, Model model) {
		try {
			if(((Usuario) session.getAttribute("usuario")).getUsuario() == null || ((Usuario) session.getAttribute("usuario")).getUsuario().equals("")) {
				return "redirect:/login";
			} else {
				model.addAttribute("title", "Dashboard");
				return "views/admin/home/index";
				
			}
		} catch(NullPointerException npe) {
			return "redirect:/login";
		}
	}
	

	@GetMapping("/docentes")
	public String docentes(HttpSession session, Model model) {
		try {
			if(((Usuario) session.getAttribute("usuario")).getUsuario() == null || ((Usuario) session.getAttribute("usuario")).getUsuario().equals("")) {
				return "redirect:/login";
			} else {
				model.addAttribute("title", "Docentes");
				model.addAttribute("semestres",
						this.semestreService.getSemestres());
				return "views/admin/home/docente";
				
			}
		} catch(NullPointerException npe) {
			return "redirect:/login";
		}
	}
	
	@PostMapping("/logout")
	public String logout(HttpSession session, RedirectAttributes redir) {
		session.invalidate();
		redir.addFlashAttribute("error", "Ha cerrado sesión correctamente.");
		return "redirect:/login";
	}



}
