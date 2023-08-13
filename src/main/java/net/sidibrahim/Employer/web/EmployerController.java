package net.sidibrahim.Employer.web;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.sidibrahim.Employer.entites.Employer;
import net.sidibrahim.Employer.repository.EmployerRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@AllArgsConstructor
@Controller
public class EmployerController {
    private EmployerRepository employerRepository;
    @GetMapping("/index")
    public String index(Model model,
                        @RequestParam(name = "page",defaultValue = "0") int page,
                        @RequestParam(name = "size",defaultValue = "5") int size,
                        @RequestParam(name = "keyword",defaultValue = "") String keyword){
        Page<Employer> pageEmployer = employerRepository.chercher("%"+keyword+"%", PageRequest.of(page,size));
        model.addAttribute("pageEmployer",pageEmployer);
        model.addAttribute("pages",new int[pageEmployer.getTotalPages()]);
        model.addAttribute("currentPage",page);
        model.addAttribute("keyword",keyword);
        return "employer";
    }
    @GetMapping("/")
    public String home(){
        return "redirect:/index";
    }
    @GetMapping("/deleteEmployer")
    public String delete(Long id, int page){
        employerRepository.deleteById(id);
        return "redirect:/index?page="+page;
    }
    @GetMapping("/editEmployer")
    public String edit(Model model,@RequestParam(name = "id") Long id){
        Employer employer = employerRepository.findById(id).get();
        model.addAttribute("employer",employer);
        return "editEmployer";
    }
    @GetMapping("/formEmployer")
    public String formEmployer(Model model) {
        model.addAttribute("employer",new Employer());
        return "formEmployer";
    }
    @PostMapping("/saveEmployer")
    public String save(@Valid Employer e,BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "formEmployer";
        }
            employerRepository.save(e);
            return "redirect:/index?keyword="+e.getName();
    }


}
