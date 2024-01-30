import { Component, OnInit } from '@angular/core';
import { User } from '../models/user';
import { UserService } from '../service/UserService';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent {

  convertedRecord: FormGroup;
  convertedRecordResult:any
  constructor(private userService: UserService, private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.convertedRecord = this.formBuilder.group({
      age: ['', Validators.required],
      gender: ['', Validators.required],
      height: ['', Validators.required],
      weight: ['', Validators.required],
      activityLevel: ['', Validators.required]
    })
  }
  calculateBmr() {
    if (this.convertedRecord.valid) {
      this.userService.addrecord(this.convertedRecord.value).subscribe({
        next: (data) => {
          this.convertedRecordResult=data
          console.log(data);
        },
        error: (e) => {
          console.log(e);
        }
      });
    }

  }


  // get() {
  //   this.userService.getHistory().subscribe(res => {
  //     this.calculator = res;
  //     // console.log(res);
  //     if (this.user.id === this.user.id) {
  //       console.log(res);
  //     }
  //   })
  // }
}

