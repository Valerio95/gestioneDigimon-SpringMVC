package it.dstech.formazione.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
		System.out.println(id);
		Allenatore allenatore = allenatoreService.get(id);
		
		List<Digimon> listaDigimon = digimonService.listAll();
		model.put("allenatore", allenatore);
		model.put("listaDigimon", listaDigimon);
		return "gestioneSquadra";		
	}
	
	@RequestMapping("/aggiungiDigimon")
	public String addDigimonAllenatore( @RequestParam("digimon")long idDigimon, @RequestParam("idAllenatore") long idAlle, Model model) {	
		Digimon digimon = digimonService.get(idDigimon);
		allenatoreService.aggiungiDigimonAdAllenatore(digimon, idAlle);
		model.addAttribute("id", idAlle);
		return "redirect:/scegliAllenatore";		
	}
	
	@RequestMapping("/ordinaLista")
	public String ordinaLista(@RequestParam("ordinamento") String ordinamento,@RequestParam("idAllenatore") long idAlle, Map<String, Object> model ) {
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
		model.put("id", idAlle);
		model.put("listaDigimon", listaDigimon);
		model.put("digimon", digimon);

		return "redirect:/scegliAllenatore";		
	}
}
