import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../models/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private url: string ="http://localhost:8765/${userId}/bmr-and-daily-calorie-needs";
  private PUrl: string ="http://localhost:8765/users/create";
  
  
  constructor(private http: HttpClient) {}

  getHistory() {
    return this.http.get<User[]>(this.url);
  }

  addrecord(data: User) {
    return this.http.post<User>(`${this.PUrl}`, data);
  }
}




