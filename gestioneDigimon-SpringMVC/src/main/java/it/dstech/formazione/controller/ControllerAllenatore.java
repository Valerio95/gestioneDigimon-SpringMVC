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

import it.dstech.formazione.modelli.Allenatore;
import it.dstech.formazione.modelli.Digimon;
import it.dstech.formazione.service.AllenatoreService;
import it.dstech.formazione.service.DigimonService;


@Controller
public class ControllerAllenatore {
	
	@Autowired
	private DigimonService digimonService;
	
	@Autowired
	private AllenatoreService allenatoreService;
	
	@RequestMapping("/gestioneAllenatore")
	public String redirect(Map<String, Object> model ) {
			Allenatore allenatore = new Allenatore();
			List<Allenatore> listaAllenatori = allenatoreService.listAll();
			model.put("listaAllenatori", listaAllenatori);
			model.put("allenatore", allenatore);
			
		return "gestioneAllenatore";
	}
	
	@RequestMapping(value = "/creaAllenatore", method = RequestMethod.POST)
	public String aggiungiAllenatore(@ModelAttribute("allenatore") Allenatore allenatore) {
		allenatoreService.save(allenatore);
		return "redirect:/gestioneAllenatore";
	}
	
	
	@RequestMapping("/modificaAllenatore")
	public ModelAndView editCustomerForm(@RequestParam long id) {
		ModelAndView mav = new ModelAndView("modificaAllenatore");
		Allenatore allenatore = allenatoreService.get(id);
		mav.addObject("allenatore", allenatore);
		
		return mav;
	}
	
	@RequestMapping("/eliminaAllenatore")
	public String deleteCustomerForm(@RequestParam long id) {
		allenatoreService.delete(id);
		return "redirect:/gestioneAllenatore";		
	}
	
	@RequestMapping("/scegliAllenatore")
	public String scegliAllenatore(@RequestParam long id,Map<String, Object> model ) {
		Allenatore allenatore = allenatoreService.get(id);
		List<Digimon> squadra = allenatore.getListaDigimon();
		System.out.println("||||||||||||||\\\\\\\\\\\\\\"+allenatore);
		List<Digimon> listaDigimon = digimonService.listAll();
		model.put("squadra", squadra);
		model.put("listaDigimon", listaDigimon);
		return "gestioneSquadra";		
	}
	
}
