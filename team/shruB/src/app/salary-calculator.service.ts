import { HttpClient } from '@angular/common/http'
import { Injectable } from '@angular/core';
import { Salary } from 'src/Models/SalaryCalculator';


@Injectable({
  providedIn: 'root'
})
export class SalaryCalculatorService {


  private url: string = "http://localhost:8766/api/Salary/history";

  private PUrl:string="http://localhost:8766/api/Salary";
 
   constructor(private http:HttpClient) { }
 
   getHistory()
   {
     type NewType = Salary;

     return this.http.get<Salary[]>(this.url)
   }
 
   addrecord(data: Salary)
   {
     return this.http.post<Salary>(`${this.PUrl}`,data)
   }
 
 }
 
 
