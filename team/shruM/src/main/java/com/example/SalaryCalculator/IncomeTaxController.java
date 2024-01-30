package com.example.SalaryCalculator;





import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class IncomeTaxController {
               
               @Autowired
               private IncomeTaxService taxService;
               
               @Autowired
               private IncomeTaxRepository incomeTaxRepository;
               
               @GetMapping("/getAll")
               public List<IncomeTax> getAllIncomes() {
                             return taxService.getAllIncomes();
               }
               @GetMapping("/get/{id}")
               public IncomeTax getIncomeById(@PathVariable Long id) {
                             return taxService.getIncomeById(id);
     }
               
               
                @PutMapping("/{id}")
               public IncomeTax updateIncome(@PathVariable Long id, @RequestBody IncomeTax incomeDetails) {
                             return taxService.updateIncome(id, incomeDetails);
               }
               
                @DeleteMapping("/delete/{id}")
               public ResponseEntity<?> deleteIncome(@PathVariable Long id) {
                             taxService.deleteIncome(id);
                             return ResponseEntity.ok().build();
               }
               @PostMapping("/Salary")
                             public IncomeTax calculateTax(@RequestBody IncomeTax income) {
                                 return taxService.calculateTax(income);
                             }
               
               
                
//           @GetMapping("/result")
//               public String getResult() {
//                   double GrossSalary = incomeTaxRepository.findAll().stream()
//                           .mapToDouble(i -> Optional.ofNullable(i.getSalary()).orElse(0.0) 
//                                           + Optional.ofNullable(i.gethRA()).orElse(0.0)
//                                           + Optional.ofNullable(i.gethRA()).orElse(0.0)
//                                           + Optional.ofNullable(i.gethRA()).orElse(0.0))
//                           .sum();
//                  
//                   double result = GrossSalary;
//                  // String status = result >= 0 ? "Affordable" : "Not Affordable";
//                   return "Total Income: " + GrossSalary;
//                           
//               }
               @GetMapping("Salary/history")

               public List<IncomeTax> getAllCalculations() {

               return taxService.getAllCalculations();

               }
}


