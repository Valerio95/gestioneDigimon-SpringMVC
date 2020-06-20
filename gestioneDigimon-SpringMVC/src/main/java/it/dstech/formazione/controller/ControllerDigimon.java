package it.dstech.formazione.controller;



import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import it.dstech.formazione.modelli.Digimon;
import it.dstech.formazione.service.DigimonService;



@Controller
public class ControllerDigimon {

	@Autowired
	private DigimonService digimonService;
	
	
	
	@RequestMapping("/")
	public ModelAndView home() {
		
		ModelAndView mav = new ModelAndView("homepage");
		
		
		return mav;
	}
	
	@RequestMapping("/gestioneDigimon")
	public String redirect(Map<String, Object> model ) {
			Digimon digimon = new Digimon();
			List<Digimon> listaDigimon = digimonService.listAll();
			model.put("listaDigimon", listaDigimon);
			model.put("digimon", digimon);
			
		return "azioniAdmin";
	}
	
	
	@RequestMapping(value = "/creaDigimon", method = RequestMethod.POST)
	public String aggiungiDigimon(@ModelAttribute("digimon") Digimon digimon) {
		digimonService.save(digimon);
		return "redirect:/gestioneDigimon";
	}
	
	
	@RequestMapping("/modificaDigimon")
	public ModelAndView editCustomerForm(@RequestParam long id) {
		ModelAndView mav = new ModelAndView("modificaDigimon");
		Digimon digimon = digimonService.get(id);
		mav.addObject("digimon", digimon);
		
		return mav;
	}
	
	@RequestMapping("/eliminaDigimon")
	public String deleteCustomerForm(@RequestParam long id) {
		digimonService.delete(id);
		return "redirect:/gestioneDigimon";		
	}
	
	@RequestMapping("/ordinaLista1")
	public String ordinaLista(@RequestParam("ordinamento") String ordinamento, Map<String, Object> model ) {
		List<Digimon> listaDigimon = digimonService.listAll();
		Digimon digimon = new Digimon();
		if ("OrdAtk".equalsIgnoreCase(ordinamento)) {
			listaDigimon=digimonService.ordinamentoPerAtk(listaDigimon);
		}else if ("OrdDef".equalsIgnoreCase(ordinamento)) {
			listaDigimon=digimonService.ordinamentoPerDef(listaDigimon);
		}else if ("OrdRes".equalsIgnoreCase(ordinamento)) {
			listaDigimon=digimonService.ordinamentoPerRes(listaDigimon);
		}else if ("OrdHp".equalsIgnoreCase(ordinamento)) {
			listaDigimon=digimonService.ordinamentoPerHp(listaDigimon);
		}
		model.put("listaDigimon", listaDigimon);
		model.put("digimon", digimon);

		return "azioniAdmin";		
	}
}
