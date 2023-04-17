package br.com.academy.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.academy.Dao.StudentDao;
import br.com.academy.enums.Status;
import br.com.academy.model.Student;

@Controller
public class StudentController {

    @Autowired
    private StudentDao studentRepository;
    
    @GetMapping("/cadastration")
    public ModelAndView cadastration(Student student) {
        ModelAndView model = new ModelAndView();
        model.setViewName("student/form");
        model.addObject("student", defaultStudent());
        return model;
    }

    @ModelAttribute
    public Student defaultStudent() {
        Student dStudent = new Student();
        dStudent.setStatus(Status.STUDYING);
        return dStudent;
    }

    @PostMapping("cadastration")
    public ModelAndView studentRegistration(Student student) {
        ModelAndView model = new ModelAndView();
        model.setViewName("redirect:/studentList");
        studentRepository.save(student);
        return model;
    }

    @GetMapping("studentList")
    public ModelAndView studentList() {
        ModelAndView model = new ModelAndView();
        model.setViewName("student/studentList");
        model.addObject("students", studentRepository.findAll());
        return model;
    }   

    @GetMapping("edit/{id}")
    public ModelAndView edit(@PathVariable("id") Integer id) {
        ModelAndView model = new ModelAndView();
        model.setViewName("student/edit");
        Student student = studentRepository.getReferenceById(id);
        model.addObject("student", student);
        return model;
    }

    @PostMapping("/edit")
    public ModelAndView studentUpdate(@ModelAttribute Student student) {
        ModelAndView model = new ModelAndView();
        model.setViewName("redirect:/studentList");
        studentRepository.save(student);
        return model;
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        studentRepository.deleteById(id);
        return "redirect:/studentList";
    }

    @GetMapping("/search")
    public String search(@RequestParam("searchName") String searchName, Model model) {
        List<Student> students = studentRepository.findByNameContaining(searchName);
        model.addAttribute("students", students);
        return "student/studentList";
    }

}
