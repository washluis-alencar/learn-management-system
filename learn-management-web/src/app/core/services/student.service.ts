import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {Student} from '../../model/student';
import {LEARN_API} from '../../app.api';

@Injectable({
  providedIn: 'root'
})
export class StudentService {
  constructor(private http: HttpClient) {}

  save(student: Student): Observable<Student> {
    return this.http.post<Student>(`${LEARN_API}/students`, student);
  }
}
