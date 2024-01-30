import { Component, OnInit } from '@angular/core';
import { Salary } from 'src/Models/SalaryCalculator';
import { SalaryCalculatorService } from '../salary-calculator.service';
import { FormGroup } from '@angular/forms';

@Component({
  selector: 'app-salary-calculator',
  templateUrl: './salary-calculator.component.html',
  styleUrls: ['./salary-calculator.component.css']
})
export class SalaryCalculatorComponent implements OnInit {


  salaryCalculator = new Salary();
  calculator: Salary[] = [];
  convertedRecord: FormGroup;
  showTotal = false;

  constructor(private salaryService: SalaryCalculatorService) { }

  ngOnInit(): void {
    this.get();
  }

  onSubmit() {
    console.log("inside component", this.salaryCalculator);
    const obj = this;
    obj.salaryService.addrecord(obj.salaryCalculator).subscribe(data => {
      console.log(data);
      obj.salaryCalculator.grossSalary = data.grossSalary;
      obj.salaryCalculator.netSalary = data.netSalary;
      obj.salaryCalculator.taxAmount = data.taxAmount;
      obj.salaryCalculator.tax = data.tax;
      obj.salaryCalculator.taxLiability = data.taxLiability;
      obj.salaryCalculator.taxPayable = data.taxPayable;
      obj.salaryCalculator.cess = data.cess;
      obj.salaryCalculator.surCharge = data.surCharge;
      obj.showTotal = true;
    })
    //  alert('')
  }

  get() {
    this.salaryService.getHistory().subscribe(res => {
      this.calculator = res;
      console.log(res)
    })
  }

 

}
