import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Observable} from 'rxjs';
import {LEARN_API} from '../../app.api';
import {Course} from '../../model/course';

@Injectable({
  providedIn: 'root',
})
export class CourseService {
  constructor(private http: HttpClient) {}

  save(course: Course): Observable<Course> {
    return this.http.post<Course>(`${LEARN_API}/courses`, course);
  }

  findAll(): Observable<Course[]> {
    return this.http.get<Course[]>(`${LEARN_API}/courses`);
  }
}
